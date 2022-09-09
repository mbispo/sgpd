package br.jus.tjms.sgpd.formulas;

import br.jus.tjms.sgpd.engine.calculo.ClasseCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.Referencia;
import br.jus.tjms.sgpd.entity.ReferenciaValor;

import java.util.Date;

/**
 -- [SD-18853] Inclusão da rbc 333
 -- [231]: ADICIONAL ATIVIDADE AGENTE TÉC. DE  INFORMÁTICA
 -- [233]: ADICIONAL ATIVIDADE ASSISTÊNCIA GABINETE
 -- [239]: ADIC FUNÇÃO MEMBRO DE COMISSÃO
 -- [240]: ADICIONAL ATIVIDADE MOTORISTA
 -- [241]: ADICIONAL ATIVIDADE CRECHE
 -- [242]: ADICIONAL ATIVIDADE  PERICULOSIDADE
 -- [294]: ADICIONAL ATIVIDADE ESPECÍFICA
 -- [298]: ADICIONAL DE RISCO DE VIDA
 -- [309]: ADICIONAL ATIVIDADE 2
 -- [317]: ADICIONAL ATIVIDADE
 -- [318]: ADICIONAL ATIVIDADE OPERADOR DA SONORIZAÇÃO
 -- [333]: ADICIONAL ATIV MOTORISTA JUIZ TRÂNSITO E JUST ITINER
 -- [391]: ASSISTÊNCIA MÉDICO-SOCIAL
 -- [392]: ADICIONAL ATIVIDADE APOIO DIR. DO FORO E CART. JUDICIAIS
 IF (@CD_Rbc IN (231, 233, 239, 240, 241, 242, 294, 298, 309, 317, 318, 333, 391, 392))
 BEGIN
 SELECT @CD_RfrSlr = CD_RfrSlr
 FROM   sgp.T_RbcFnc
 WHERE  CD_Rbc = @CD_Rbc
 AND CD_Fnc = @CD_Fnc
 AND CD_EmpSgp = @CD_EmpSgp
 AND CD_StcFnc = @CD_StcFnc

 -- Marcos Bispo, 06/07/2007
 -- Obtem o valor da referência válido para esta folha, de acordo com o período
 -- (início e fim) do valor cadastrado para a referência
 SELECT @VL_RfrSlr = ISNULL(v.VL_RfrSlr, 0)
 FROM   sgp.T_RfrSlr r
 JOIN sgp.T_VlrRfrSlr v
 ON  (r.CD_RfrSlr = v.CD_RfrSlr)
 WHERE  r.CD_RfrSlr = @CD_RfrSlr
 AND @data_inicio_folha >= v.DT_INI
 AND @data_fim_folha <= v.DT_FIM

 IF (@CD_Rbc IN (231, 233, 240, 294, 309, 317, 318, 333, 391, 392))
 BEGIN
 SELECT @CD_RfrSlr = ISNULL(CD_RfrSlrAcm, CD_RfrSlr),
 @CD_TpoPrv = ISNULL(CD_TpoPrvAcm, CD_TpoPrv)
 FROM   sgp.T_Fnc
 WHERE  (
 CD_EmpSgp = @CD_EmpSgp
 AND CD_Fnc = @CD_Fnc
 AND CD_StcFnc = @CD_StcFnc
 )

 --Calculando Folha Em Exercício mas que aposentou
 IF (@CD_StcFncCds <> @CD_StcFnc and @CD_TpoPrv = 27)
 BEGIN
 SELECT @nrDiasPgt = CASE
 WHEN DATEDIFF(DAY, @data_inicio_folha, fnc.DT_IncVnc) + 1 > @nrDiasMes
 THEN DATEDIFF(DAY,CAST(@NR_Ano AS VARCHAR(4)) + SUBSTRING(CAST(@NR_Mes + 100 AS VARCHAR(3)), 2, 2) + '01',@dtUltDia) + 1
 ELSE DATEDIFF(DAY, @data_inicio_folha, fnc.DT_IncVnc) /* + 1
                                  END
                                          FROM   sgp.T_Fnc fnc
                                          WHERE  fnc.CD_Fnc = @CD_Fnc
                     AND fnc.CD_EmpSGP = @CD_EmpSGP
            END
                    ELSE BEGIN
                    SELECT @nrDiasPgt = CASE WHEN DATEDIFF(DAY, ISNULL(fnc.DT_IncVncAcm, fnc.DT_IncExrCrgAcm), @dtUltDia) + 1 > @nrDiasMes THEN
        DATEDIFF(DAY, CAST(@NR_Ano AS VARCHAR(4)) + SUBSTRING(CAST(@NR_Mes + 100 AS VARCHAR(3)), 2, 2) + '01', @dtUltDia) + 1
        ELSE DATEDIFF(DAY,ISNULL(fnc.DT_IncVncAcm, fnc.DT_IncExrCrgAcm),@dtUltDia) + 1
        END
        FROM   sgp.T_Fnc fnc
        WHERE  fnc.CD_Fnc = @CD_Fnc
                   AND fnc.CD_EmpSGP = @CD_EmpSGP
                   AND fnc.CD_StcFnc = @CD_StcFnc
          END

                  END
                  ELSE IF @CD_Rbc in (239,241)
        BEGIN
        SELECT @CD_RfrSlr = CD_RfrSlr,
@CD_TpoPrv = CD_TpoPrv
        FROM   sgp.T_Fnc
        WHERE  (
        CD_EmpSgp = @CD_EmpSgp
            AND CD_Fnc = @CD_Fnc
            AND CD_StcFnc = @CD_StcFnc
          )

                  SELECT @nrDiasPgt = CASE
        WHEN DATEDIFF(DAY, fnc.DT_IncVncAcm, @dtUltDia) +
        1 > @nrDiasMes THEN DATEDIFF(
        DAY,
        CAST(@NR_Ano AS VARCHAR(4)) +
        SUBSTRING(CAST(@NR_Mes + 100 AS VARCHAR(3)), 2, 2)
        + '01',
@dtUltDia
                                                       ) + 1
                                                               ELSE DATEDIFF(DAY, fnc.DT_IncVncAcm, @dtUltDia) +
        1
        END
        FROM   sgp.T_Fnc fnc
        WHERE  fnc.CD_Fnc = @CD_Fnc
                 AND fnc.CD_EmpSGP = @CD_EmpSGP
                 AND fnc.CD_StcFnc = @CD_StcFnc
        END
                ELSE IF @CD_Rbc in (242,298)
        BEGIN
        SELECT @CD_RfrSlr = CD_RfrSlr,
@CD_TpoPrv = CD_TpoPrv
        FROM   sgp.T_Fnc
        WHERE  (
        CD_EmpSgp = @CD_EmpSgp
            AND CD_Fnc = @CD_Fnc
            AND CD_StcFnc = @CD_StcFnc
          )

                  IF @CD_StcFncCds = 3 AND @CD_StcFnc <> 3
        BEGIN
        SELECT @nrDiasPgt = CASE
        WHEN DAY(@dtUltDia) - DATEDIFF(DAY, fnc.DT_IncVnc, @dtUltDia) - 1 > @nrDiasMes
                                    THEN DAY(@dtUltDia) - DATEDIFF(DAY, CAST(@NR_Ano AS VARCHAR(4)) + SUBSTRING(CAST(@NR_Mes + 100 AS VARCHAR(3)), 2, 2) + '01', @dtUltDia) - 1
        ELSE DAY(@dtUltDia) - DATEDIFF(DAY, fnc.DT_IncVnc, @dtUltDia) - 1
        END
        FROM   sgp.T_Fnc fnc
        WHERE  fnc.CD_Fnc = @CD_Fnc
                     AND fnc.CD_EmpSGP = @CD_EmpSGP
            END
                    ELSE BEGIN
                    SELECT @nrDiasPgt = CASE
        WHEN DATEDIFF(DAY, fnc.DT_IncVncAcm, @dtUltDia) + 1 > @nrDiasMes
                                  THEN DATEDIFF(DAY,CAST(@NR_Ano AS VARCHAR(4)) + SUBSTRING(CAST(@NR_Mes + 100 AS VARCHAR(3)), 2, 2) + '01', @dtUltDia) + 1
        ELSE DATEDIFF(DAY, fnc.DT_IncVncAcm, @dtUltDia) + 1
        END
        FROM   sgp.T_Fnc fnc
        WHERE  fnc.CD_Fnc = @CD_Fnc
                   AND fnc.CD_EmpSGP = @CD_EmpSGP
          END
                  END

                  -- Bit utilizado para calcular o valor da rubrica no mês cheio, sem a proporcionalização
                  IF @calculoMesCheio = 1
        BEGIN
        SET @nrDiasPgt = @nrDiasMes
        END

                SELECT @VL_Res = ((@VL_RfrSlr / @nrDiasMes) * @nrDiasPgt)

        SET @VL_Prm1 = @VL_Res

      PRINT 'Mes com................: ' + CAST(ISNULL(@nrDiasMes, 0) AS VARCHAR) + ' dias'
        PRINT 'Ultimo dia.............: ' + CAST(ISNULL(@dtUltDia, 0) AS VARCHAR)
        PRINT 'Nº de dias a pagar.....: ' + CAST(ISNULL(@nrDiasPgt, 0) AS VARCHAR)
        PRINT 'Valor Referência.......: ' + CAST(IsNull(@VL_RfrSlr,0) AS VARCHAR(11))
        PRINT 'Resultado..............: ' + CAST(IsNull(@VL_Res,0) AS VARCHAR(11))
        END
 */
public class FormulaAdicional implements ClasseCalculo{

    private static ClasseCalculo instance;

    public static ClasseCalculo newInstance() {
        return new FormulaAdicional();
    }

    public static ClasseCalculo instance() {
        if (instance == null) {
            instance = new FormulaAdicional();
        }
        return instance;
    }

    @Override
    public Object calcular(Contexto contexto) {
        FolhaPagamento folhaPagamento = contexto.getFolha();
        Integer mes = folhaPagamento.getMes();
        Integer ano = folhaPagamento.getAno();

        Date dataInicialFolha = br.jus.tjms.sgpd.util.DateUtilz.primeiroDiaDoMes(mes, ano);

        FuncionarioCargo funcionarioCargo = contexto.getFuncionarioCargo();
        Referencia referencia = funcionarioCargo.getProgressaoNaData(dataInicialFolha).getReferencia();
        ReferenciaValor referenciaValor = referencia.getValorAtual(dataInicialFolha);

        //@VL_Res = ((@VL_RfrSlr / @nrDiasMes) * @nrDiasPgt) -- a divisão e multiplicação é feitra pela RubricaCargoCalculoProcessor
        Double adicional = referenciaValor.getValor();
        contexto.output("adicional").setValor(adicional);
        return adicional;
      }

}

