package br.jus.tjms.sgpd.formulas;

import br.jus.tjms.sgpd.engine.calculo.ClasseCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.enumerators.TipoBaseCalculo;
import br.jus.tjms.sgpd.enumerators.TipoPagamentoItem;

/**
 * -- marcos, 27/09/2006, baseado no cálculo da rubrica 250
 -- marcos, 29/07/2008, baseado no cálculo da rubrica 251
 -- [251]: ATRASO/SAÍDA ANTECIPADA
 -- [556]: ATRASO/SAÍDA ANTECIPADA JUIZADO
 IF (@CD_Rbc IN (251, 556))
 BEGIN
 DECLARE @NR_FlhBse2    INT
 DECLARE @VL_PrtHor     SMALLDATETIME
 DECLARE @VL_PrtQtdHor  FLOAT
 DECLARE @horas         INT
 DECLARE @minutos       INT
 DECLARE @quant         FLOAT
 DECLARE @desconto      FLOAT
 DECLARE @NR_HrsMes     INT

 SET @DT_FlhBse = CAST(@NR_Ano AS VARCHAR(4)) + SUBSTRING(CAST(@NR_Mes + 100 AS VARCHAR(3)), 2, 2)
 + '01'

 SET @NR_HrsMes = 0


 --#H Decrementa para mês anterior
 --SELECT @DT_FlhBse = DATEADD(MONTH, -2, @DT_FlhBse)
 --somente para cálcular a folha de julho que estará descontando atrasos de maio


Quando o lançamento é pela tela de lançamento avulso alimenta-se o campo VL_PrtVlrFxo e
 quando é efetuado pelo formulário de lançamento automático alimenta-se o campo VL_PrtDta
      SELECT @DT_FlhBse = COALESCE(
        CAST(CAST(VL_PrtVlrFxo AS INT) AS VARCHAR) + '01',
        VL_PrtDta
        )
        FROM   sgp.T_ClcFlh tcf
        WHERE  tcf.CD_Flh = @CD_Flh
             AND tcf.CD_Rbc = @CD_Rbc
             AND tcf.CD_Fnc = @CD_Fnc
             AND tcf.CD_EmpSGP = @CD_EmpSGP
             AND tcf.CD_ClcFlh = @CD_ClcFlh


      SELECT @NR_Ano = YEAR(@DT_FlhBse),
@NR_Mes = MONTH(@DT_FlhBse)


        -- Seleciona a folha base para cálculo (anterior)
        SELECT @NR_FlhBse2 = CD_Flh
        FROM   sgp.T_Flh
        WHERE  NR_Ano = @NR_Ano
             AND NR_Mes = @NR_Mes
             AND CD_TpoFlh = 1
                     AND CD_EmpSgp = @CD_EmpSgp


      -- define horas por mês
              -- definir carga horária
              SELECT @NR_HrsMes = COUNT(tcf.CD_Rbc)
        FROM   sgp.T_RbcAsc tra
        JOIN sgp.T_ClcFlh tcf
        ON  (tra.CD_RbcAsc = tcf.CD_Rbc)
        WHERE  (tra.CD_Rbc = 460 OR tcf.CD_Rbc = 2)
        AND tra.CD_RbcAsc <> 31
        AND tcf.CD_Flh = @NR_FlhBse2
             AND tcf.CD_EmpSGP = @CD_EmpSgp
             AND tcf.CD_Fnc = @CD_Fnc
             AND tra.CD_RbcAsc NOT IN (240,280) -- Exclui atividades de 150 horas. --280: SGP-5401

                     IF @NR_HrsMes > 0
        BEGIN
        SET @NR_HrsMes = 200
        END
        ELSE
        BEGIN
        SET @NR_HrsMes = 150
        END

        -- se estiver calculando atraso do juizado (556) define a carga horária = 120 horas/mês
        IF (@CD_Rbc = 556)
        BEGIN
        SET @NR_HrsMes = 120
        END

        -- Monta a base para cálculo, baseado nos ganhos do mês anterior, usando as rubricas associadas
        SELECT @VL_Bse = SUM(VL_Clc)
        FROM   sgp.T_ClcFlh cf
        JOIN sgp.T_RbcAsc ra
        ON  (cf.CD_Rbc = ra.cd_RbcAsc)
        WHERE  cf.CD_Rbc = ra.CD_RbcAsc
        AND ra.CD_Rbc = @CD_Rbc
             AND CD_Fnc = @CD_Fnc
             AND CD_EmpSgp = @CD_EmpSgp
             AND CD_Flh = @NR_FlhBse2
             AND cf.CD_TpoLnc = 1 --Não entram avulso e parcela

                     -- Seleciona a quantidade de horas e minutos do lançamento avulso
                     SET @VL_PrtHor = 0
        SET @VL_PrtQtdHor = 0

        IF (ISNULL(@CD_ClcFlh, 0) > 0)
        BEGIN
        SELECT @VL_PrtHor = CAST(ISNULL(VL_PrtHor, VL_PrtQtd) AS DATETIME)
        FROM   sgp.T_ClcFlh
        WHERE  CD_Flh = @CD_Flh
                 AND CD_EmpSgp = @CD_EmpSgp
                 AND CD_Fnc = @CD_Fnc
                 AND CD_Rbc = @CD_Rbc
                 AND CD_ClcFlh = @CD_ClcFlh
        END
                ELSE
                BEGIN
                SELECT @VL_PrtHor = CAST(ISNULL(VL_PrtHor, VL_PrtQtd) AS DATETIME)
        FROM   sgp.T_ClcFlh
        WHERE  CD_Flh = @CD_Flh
                 AND CD_EmpSgp = @CD_EmpSgp
                 AND CD_Fnc = @CD_Fnc
                 AND CD_Rbc = @CD_Rbc
        END
                -- se não informou o parametro horas/minutos no avulso, então
                IF @VL_PrtHor = 0
        BEGIN
        -- pega quantidade de horas/minutos lançado nas rubricas do funcionário
        SELECT @VL_PrtQtdHor = ISNULL(PR_Clc, 0)
        FROM   sgp.T_RbcFnc
        WHERE  CD_EmpSgp = @CD_EmpSgp
                 AND CD_Fnc = @CD_Fnc
                 AND CD_Rbc = @CD_Rbc
        END

                IF @VL_PrtHor = 0
        BEGIN
        IF @VL_PrtQtdHor = 0
        BEGIN
        -- define resultado como ZERO
        SET @VL_Res = 0
        END
        ELSE
        BEGIN
        -- calcula o resultado baseando-se na quantidade
        -- (lançado na rubrica do funcionário)
        SET @quant = @VL_PrtQtdHor
              SET @desconto = ROUND((@VL_Bse / @NR_HrsMes) * @quant, 2)
        SET @VL_Res = @desconto
            END
                    END
                    ELSE
                    BEGIN
                    -- calcula o resultado baseando-se nas horas de atraso (lançado nos avulsos)
                    SET @horas = DATEPART(hour, @VL_PrtHor)
        SET @minutos = DATEPART(minute, @VL_PrtHor)
        IF @VL_PrtHor > 0
        BEGIN
        SET @quant = CAST(@VL_PrtHor AS integer) / 3600.00
        END
        ELSE
        BEGIN
        SET @quant = CAST(@horas AS FLOAT) + (CAST(@minutos AS FLOAT) / 60)
        END
        SET @desconto = ROUND((@VL_Bse / @NR_HrsMes) * @quant, 2)
        SET @VL_Res = @desconto
        END

                Print 'Folha Base .......: '+Cast(@NR_FlhBse2 as varchar)
        Print 'DataFolhaBase ....: '+Cast(@DT_FlhBse as varchar)

        Print '@VL_PrtHor (seg)..: '+Cast(Cast(@VL_PrtHor as int) as varchar)
        Print '@VL_PrtHor (min)..: '+Cast(Cast(@VL_PrtHor as int)/60 as varchar)
        Print '@NR_HrsMes .......: '+Cast(Cast(@NR_HrsMes as int) as varchar)

        Print 'Horas ............: '+Cast(@horas as nvarchar(14))
        Print 'Minutos ..........: '+Cast(@minutos as nvarchar(14))
        Print 'Quantidade .......: '+Cast(@quant as nvarchar(14))
        Print 'Base de cálculo ..: '+Cast(@VL_Bse as nvarchar(14))
        Print 'Desconto .........: '+Cast(@VL_Res as nvarchar(14))

        END
 *
 */
public class FormulaAtraso implements ClasseCalculo{

    private static ClasseCalculo instance;

    public static ClasseCalculo newInstance() {
        return new FormulaAtraso();
    }

    public static ClasseCalculo instance() {
        if (instance == null) {
            instance = new FormulaAtraso();
        }
        return instance;
    }

    @Override
    public Object calcular(Contexto contexto) {
        if (contexto.input("horasAtraso") == null) {
            return 0.0;
        }

        Double baseCalculo = contexto.totalItensPorRubricasBaseNaFolha();
        Double horasAtraso = (Double) contexto.input("horasAtraso").getValor();
        Integer cargaHoraria = (Integer) contexto.input("cargaHoraria").getValor();

        //ROUND((@VL_Bse / @NR_HrsMes) * @quant, 2)
        Double atrasos = (baseCalculo / cargaHoraria) * horasAtraso;
        contexto.output("atrasos").setValor(1.0);
        return atrasos;
      }

}

