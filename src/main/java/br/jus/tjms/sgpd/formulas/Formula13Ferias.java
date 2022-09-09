package br.jus.tjms.sgpd.formulas;

import br.jus.tjms.sgpd.engine.calculo.ClasseCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.enumerators.Sinal;

/**
 -- [51]: 1/3 FERIAS
 -- [81]: 1/3 FERIAS
 -- [249]: 1/3 FERIAS
 -- [289]: 1/3 FÉRIAS S/ABONO
 IF @CD_Rbc IN(51, 81, 249, 289)
 BEGIN
 SELECT DISTINCT @CD_TpoFlh = f.CD_TpoFlh
 FROM   sgp.T_Flh f
 WHERE  f.CD_Flh = @CD_Flh

 DECLARE @NR_Prl            VARCHAR
 DECLARE @RECEBE_PAGAMENTO  VARCHAR

 -- seleciona a quantidade de dia de gozo de férias
 -- se for folha do tipo férias, pega a quantidade de dias a partir da ocorrência
 -- se não, pega do lançamento avulso

 IF ISNULL(@parametro_calculo, 0) > 0
 BEGIN
 SET @VL_PrtQtd = @parametro_calculo
 PRINT 'Parametro de calculo informado: ' + CAST(@VL_PrtQtd AS VARCHAR)
 END

 IF ISNULL(@VL_PrtQtd, 0) = 0
 -- se não tiver passado o nº de dias como parametro
 BEGIN
 PRINT 'Parametro de calculo não informado... '
 IF (@CD_TpoFlh = 4)-- se for folha de férias
 BEGIN
 -- pega atributo "parcela" da ocorrência
 SELECT @NR_Prl = rs.DS_RslAtbOcr
 FROM   sgp.t_ocrfnc ocr
 -- pega o atributo "PARCELA" das férias
 JOIN sgp.T_RslAtbOcr rs
 ON  (rs.CD_OcrFnc = ocr.CD_OcrFnc)
 JOIN sgp.T_AtbTpoOcr atb
 ON  (
 ocr.CD_TpoOcr = atb.CD_TpoOcr
 AND atb.CD_Atb = 20
 AND rs.NR_SeqAtb = atb.NR_SeqAtb
 )-- tipo de ocorrência = férias
 JOIN sgp.t_tpoocr tpo
 ON  (ocr.cd_tpoocr = tpo.cd_tpoocr AND tpo.cd_tpoocr = 2)
 WHERE  ocr.cd_empsgp = @CD_EmpSGP
 AND ocr.CD_Fnc = @CD_Fnc
 AND (ocr.dt_ini BETWEEN @data_inicio_folha AND @data_fim_folha2)-- pega atributo "recebe pagamento" da ocorrência
 SELECT @RECEBE_PAGAMENTO = rs.DS_RslAtbOcr
 FROM   sgp.t_ocrfnc ocr
 -- pega o atributo "RECEBE PAGAMENTO" das férias
 JOIN sgp.T_RslAtbOcr rs
 ON  (rs.CD_OcrFnc = ocr.CD_OcrFnc)
 JOIN sgp.T_AtbTpoOcr atb
 ON  (
 ocr.CD_TpoOcr = atb.CD_TpoOcr
 AND atb.CD_Atb = 243
 AND rs.NR_SeqAtb = atb.NR_SeqAtb
 )-- tipo de ocorrência = férias
 JOIN sgp.t_tpoocr tpo
 ON  (ocr.cd_tpoocr = tpo.cd_tpoocr AND tpo.cd_tpoocr = 2)
 WHERE  ocr.cd_empsgp = @CD_EmpSGP
 AND ocr.CD_Fnc = @CD_Fnc
 AND (ocr.dt_ini BETWEEN @data_inicio_folha AND @data_fim_folha2)

 IF (
 ISNULL(@NR_Prl, '') IN ('0', '1')
 AND (ISNULL(@RECEBE_PAGAMENTO, '') = '1')
 )
 BEGIN
 -- define nº dias padrão
 SET @VL_PrtQtd = 30
 PRINT

 'parametro de calculo não informado, ocorrência de férias encontrada, definido nº de dias padrão = 30'
 END
 ELSE
 BEGIN
 SELECT @VL_PrtQtd = cf.VL_PrtQtd
 FROM   sgp.T_ClcFlh cf
 WHERE  cf.CD_Rbc = @CD_Rbc
 AND cf.CD_Flh = @CD_Flh
 AND cf.CD_EmpSgp = @CD_EmpSgp
 AND cf.CD_Fnc = @CD_Fnc

 PRINT

 'parametro de calculo não informado, ocorrência de férias não encontrada, definido nº de dias a partir do lançamento avulso...'
 END
 END
 ELSE
 -- não é folha de férias
 BEGIN
 -- usa a quantidade de dias informada no lançamento avulso
 SELECT @VL_PrtQtd = cf.VL_PrtQtd
 FROM   sgp.T_ClcFlh cf
 WHERE  cf.CD_Rbc = @CD_Rbc
 AND cf.CD_Flh = @CD_Flh
 AND cf.CD_EmpSgp = @CD_EmpSgp
 AND cf.CD_Fnc = @CD_Fnc

 PRINT

 'parametro de calculo não informado, definido nº de dias a partir do lançamento avulso...'
 END
 END

 -- Montar a base para cálculo do abono

 IF (@CD_TpoPrv = 1) or (@CD_TpoPrv = 2)
 BEGIN
 SELECT @VL_Bse = SUM(VL_Clc)
 FROM   sgp.T_ClcFlh clc
 JOIN sgp.T_Rbc r
 ON  (clc.CD_Rbc = r.CD_Rbc)
 JOIN sgp.T_Flh f
 ON  (
 clc.CD_Flh = f.CD_Flh
 AND f.NR_Ano = @NR_Ano
 AND f.NR_Mes = @NR_Mes
 )
 WHERE  clc.CD_EmpSgp = @CD_EmpSgp
 AND CD_Fnc = @CD_Fnc
 AND NR_Ano = @NR_Ano
 AND NR_Mes = @NR_Mes
 AND CD_StcFnc = 1 -- inclui esta linha
 AND SG_OprMtm = '+'
 AND clc.CD_Rbc IN (SELECT CD_RbcAsc
 FROM   sgp.T_RbcAsc
 WHERE  CD_Rbc = @CD_Rbc)
 AND f.CD_TpoFlh = 1
 AND clc.CD_TpoLnc = 1 --SD-8173
 END
 ELSE
 BEGIN
 SELECT @VL_Bse = SUM(VL_Clc)
 FROM   sgp.T_ClcFlh clc
 JOIN sgp.T_Rbc r
 ON  (clc.CD_Rbc = r.CD_Rbc)
 JOIN sgp.T_Flh f
 ON  (
 clc.CD_Flh = f.CD_Flh
 AND f.NR_Ano = @NR_Ano
 AND f.NR_Mes = @NR_Mes
 )
 WHERE  clc.CD_EmpSgp = @CD_EmpSgp
 AND CD_Fnc = @CD_Fnc
 AND NR_Ano = @NR_Ano
 AND NR_Mes = @NR_Mes
 AND CD_StcFnc = 1 -- inclui esta linha
 AND SG_OprMtm = '+'
 AND clc.CD_Rbc IN (SELECT CD_RbcAsc
 FROM   sgp.T_RbcAsc
 WHERE  CD_Rbc = @CD_Rbc
 AND clc.CD_Rbc <> 286)
 AND f.CD_TpoFlh = 1
 AND clc.CD_TpoLnc = 1 --SD-8173
 END

 -- [SD-99148] Verificação do Teto Constitucional para a base da rubrica de férias [Paulo Nomura - 23.SET.14]
 -- pega o teto nos parâmetros da rubrica
 SELECT @VL_Tto = pc.VL_Tto
 FROM   sgp.T_PrtClc pc
 WHERE  pc.CD_Rbc = @CD_Rbc
 AND pc.CD_StcPrt = 1

 -- Verifica se a base das férias atingiu o teto.
 IF (ISNULL(@VL_Tto, 0) > 0) AND (ISNULL(@VL_Bse, 0) > ISNULL(@VL_Tto, 0))
 BEGIN
 -- se atingiu, reduz a base para o valor do teto
 SET @VL_Bse = ISNULL(@VL_Tto, 0)
 END

 IF (@VL_Bse > 0)
 BEGIN
 SELECT @VL_Res = ((@VL_Bse / 3) / 30) * @VL_PrtQtd
 END
 ELSE
 BEGIN
 SET @VL_Res = 0
 END

    END
 */
public class Formula13Ferias implements ClasseCalculo{

    private static ClasseCalculo instance;
    private static Integer QUANTIDADE_DIAS = 30;

    public static ClasseCalculo newInstance() {
        return new Formula13Ferias();
    }

    public static ClasseCalculo instance() {
        if (instance == null) {
            instance = new Formula13Ferias();
        }
        return instance;
    }

    @Override
    public Object calcular(Contexto contexto) {
        Integer quantidadeDias = QUANTIDADE_DIAS;
        if (contexto.input("quantidadeDias") != null) {
            quantidadeDias = (Integer) contexto.input("quantidadeDias").getValor();
        }

        Double baseCalculo = contexto.totalItensPorRubricasBaseNaFolha(contexto.getRubrica(), Sinal.POSITIVO);

        //((@VL_Bse / 3) / 30) * @VL_PrtQtd
        Double umTercoFerias = ((baseCalculo / 3)/30) * quantidadeDias;
        contexto.output("umTercoFerias").setValor(umTercoFerias);
        return umTercoFerias;
      }

}

