package br.jus.tjms.sgpd.formulas;

import br.jus.tjms.sgpd.engine.calculo.ClasseCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.Referencia;
import br.jus.tjms.sgpd.entity.ReferenciaValor;

import java.util.Date;

/**
 --[SD-22499] Inclusão da rubrica 334

 -- [11]: GRAT CHEFE DE SECAO
 -- [19]: GRAT SECRET DIRECAO DO FORO
 -- [20]: GRAT MEMBRO DE GRUPO
 -- [40]: GRAT COORDENADOR
 -- [56]: GRAT CHEFE DE DEPARTAMENTO
 -- [57]: GRAT CHEFE DE TURMA
 -- [60]: GRAT COORDENADOR DE SERVIÇOS
 -- [61]: ASSISTENTE ADMINISTRATIVO/JURIDICO
 -- [62]: REVISOR JURÍDICO/GRAMATICAL
 -- [64]: ANALISTA CONTÁBIL
 -- [70]: GRAT ASSISTENTE DE DIRETORIA
 -- [72]: GRAT AGENTE DE GABINETE
 -- [73]: GRAT CHEFE DE CARTÓRIO RECURSAL
 -- [76]: GRAT ANALISTA JUDICIÁRIO
 -- [141]: GRAT CHEFE DE CARTÓRIO
 -- [146]: GRAT DISTRIB, CONT E PARTIDOR ENTR ESP
 -- [174]: GRAT DISTRIB, CONT E PARTIDOR 1ª ENTR
 -- [177]: GRAT DISTRIB, CONT E PARTIDOR 2ª ENTR
 -- [178]: GRAT CONTROL. DE MANDADOS 2A ENTR
 -- [179]: GRAT CONTROL. DE MANDADOS DE DOURADOS
 -- [186]: GRAT CONTROL DE MANDADOS DE CAMPO GRANDE
 -- [195]: GRAT ASSESSOR TÉCNICO DE DIRETORIA
 -- [196]: GRAT AGENTE TÉCNICO DE INFORMÁTICA I
 -- [197]: GRAT AGENTE TÉCNICO DE INFORMÁTICA II
 -- [207]: GRAT CHEFE DE SECRETARIA
 -- [208]: GRAT CHEFE DE SERVIÇO
 -- [209]: GRAT CHEFE DE TURNO
 -- [211]: GRAT SINDICO
 -- [213]: GRAT DIRETOR DE DEPARTAMENTO
 -- [216]: GRAT CHEFE DE GABINETE DE GESTÃO
 -- [218]: GRAT CHEFE DE SERVIÇO
 -- [219]: GRAT SECRETARIO DA CORREGEDERIA-GERAL
 -- [222]: GRAT ATIVIDADE DE GABINETE
 -- [225]: GRAT. ASS. DIRETORIA
 -- [228]: GRAT. ASSESSOR TÉCNICO ESPECIALIZADO
 -- [229]: GRAT. MEMBRO DE COMISSÃO
 -- [234]: GRAT ASSISTENTE EXECUTIVO
 -- [235]: GRAT DISTRIB, CONT E PARTIDOR
 -- [238]: GRAT CONTROL DE MANDADOS
 -- [281]: GRAT AJUDANTE DE ORDEM
 -- [282]: GRAT ASSISTENTE DE INTELIGÊNCIA
 -- [283]: GRAT ADJUNTO DA ASSESSORIA MILITAR
 -- [284]: GRAT SECRETARIO EXECUTIVO
 -- [334]: ADICIONAL ATIV MOTORISTA JUIZ TRÂNSITO E JUST ITINER 2
 -- [346]: GRAT PREGOEIRO
 -- [347]: GRAT ASSISTENTE DE TI-GABINETE
 -- [348]: GRAT ASSISTENTE ADMINISTRATIVO MILITAR
 IF @CD_Rbc IN (11, 19, 20, 40, 56, 57, 60, 61, 62, 64, 70, 72, 73, 76, 141,
 146, 174, 177, 178, 179, 186, 195, 196, 197, 207, 208, 209,
 211, 213, 216, 218, 219, 222, 225, 228, 229, 234,
 235, 238, 281, 282, 283, 284, 334, 346, 347, 348)
 BEGIN
 -- artur 06/07/07 passou a considerar a referência salarial acumulada
 SELECT @CD_RfrSlrInc = CD_RfrSlrInc,
 @CD_RfrSlrAcm = CD_RfrSlrAcm
 FROM   sgp.T_Fnc
 WHERE  CD_EmpSgp = @CD_EmpSgp
 AND CD_Fnc = @CD_Fnc

 SELECT @VL_PrcClc = PR_Clc,
 @VL_PvtPpr = PR_Clc1,
 @CD_TpoPrv = CD_TpoPrv
 FROM   sgp.T_RbcFnc
 WHERE  CD_EmpSgp = @CD_EmpSgp
 AND CD_Fnc = @CD_Fnc
 AND CD_Rbc = @CD_Rbc

 -- marcos bispo, 06/07/2007
 -- ajuste para pegar o valor da referência de acordo com o período e ano/mes da folha atual
 SELECT @VL_RfrSlrAcm = v.VL_RfrSlr
 FROM   sgp.T_RfrSlr r
 JOIN sgp.T_VlrRfrSlr v
 ON  (r.CD_RfrSlr = v.CD_RfrSlr)
 WHERE  r.CD_RfrSlr = @CD_RfrSlrAcm
 AND @data_inicio_folha >= v.DT_INI
 AND @data_fim_folha <= v.DT_FIM

 -- Valor da Referência Salarial Incorporada
 SELECT @VL_RfrSlrIcp = ISNULL(VL_Clc, 0.0)
 FROM   sgp.T_ClcFlh
 WHERE  CD_EmpSGP = @CD_EmpSGP
 AND CD_Fnc = @CD_Fnc
 AND CD_Flh = @CD_Flh
 AND CD_Rbc IN (6, 15, 21, 25, 39, 176, 184, 204, 205, 206, 215, 288)

 -- calcula o último dia do mês.
 SELECT @nrDiasPgt = CASE
 WHEN DATEDIFF(DAY,ISNULL(fnc.DT_IncVncAcm, fnc.DT_IncExrCrgAcm),@dtUltDia) + 1 > @nrDiasMes
 THEN DATEDIFF(DAY,CAST(@NR_Ano AS VARCHAR(4)) + SUBSTRING(CAST(@NR_Mes + 100 AS VARCHAR(3)), 2, 2) + '01',@dtUltDia) + 1
 ELSE DATEDIFF(DAY,ISNULL(fnc.DT_IncVncAcm, fnc.DT_IncExrCrgAcm),@dtUltDia) + 1
 END
 FROM   sgp.T_Fnc fnc
 WHERE  fnc.CD_Fnc = @CD_Fnc
 AND fnc.CD_EmpSGP = @CD_EmpSGP
 AND fnc.CD_StcFnc = @CD_StcFnc

 --se o servidor se aposentou, calcula os dias de exercício
 IF @nrDiasPgt IS NULL
 BEGIN
 SELECT @nrDiasPgt = CASE
 WHEN DATEDIFF(DAY,ISNULL(fnc.DT_IncVncAcm, fnc.DT_IncExrCrgAcm), fnc.DT_AfsFlh - 1) + 1 > @nrDiasMes
 THEN DATEDIFF(DAY,CAST(@NR_Ano AS VARCHAR(4)) + SUBSTRING(CAST(@NR_Mes + 100 AS VARCHAR(3)), 2, 2) + '01', fnc.DT_AfsFlh - 1) + 1
 ELSE DATEDIFF(DAY,ISNULL(fnc.DT_IncVncAcm, fnc.DT_IncExrCrgAcm), fnc.DT_AfsFlh - 1) + 1
 END
 FROM   sgp.T_Fnc fnc
 WHERE  fnc.CD_Fnc = @CD_Fnc
 AND fnc.CD_EmpSGP = @CD_EmpSGP
 END

 --Calcula o valor da averbação para subtrair na rubrica do cargo
 --SET @VL_Averbado = ISNULL(sgp.fn_ValorAverbadoPorData(@CD_Fnc, @CD_EmpSGP, @data_inicio_folha, @data_fim_folha),0)
 SELECT @VL_Averbado = SUM(ISNULL(VL_Clc, 0.0))
 FROM   sgp.T_ClcFlh
 WHERE  CD_EmpSGP = @CD_EmpSGP
 AND CD_Fnc = @CD_Fnc
 AND CD_Flh = @CD_Flh
 AND CD_Rbc IN (396, 436)
 AND CD_TpoLnc = 1 -- Para não considerar o retroativo do MS-PREV

 PRINT 'Código da Sit. func....: ' + CAST(@CD_StcFnc AS VARCHAR)
 PRINT 'Código do tipo de prov.: ' + CAST(IsNull(@CD_TpoPrv,0) AS VARCHAR)
 PRINT 'mes de.................: ' + CAST(ISNULL(@nrDiasMes, 0) AS VARCHAR)
 + ' dias'
 PRINT 'Nº de dias a pagar.....: ' + CAST(ISNULL(@nrDiasPgt, 0) AS VARCHAR)
 PRINT 'Valor da referência salarial acumulada...: ' + CAST(@VL_RfrSlrAcm AS VARCHAR)
 PRINT 'Valor da referência salarial incorporada.: ' + CAST(@VL_RfrSlrIcp AS VARCHAR)
 PRINT 'Valor Averbado: '+ CAST(ISNULL(@VL_Averbado,0) as varchar)

 -- Bit utilizado para calcular o valor da rubrica no mês cheio, sem a proporcionalização
 IF @calculoMesCheio = 1
 BEGIN
 SET @nrDiasPgt = @nrDiasMes;

 --SGP-5245
 --SET @VL_Averbado = 0;
 END

 -- 17/01/2016 Estabilidade X rubrica cargo x Aposentadoria (mat 2010)
 -- Se esta calculando a folha Em Exercício de um Aposentado, calcula o proporcional (nª de dias Exercício) do cargo e depois faz a diferença da incorporação e averbação (estão já proporcionalizados)
 --Debugando: Quando calcula a folha Em Exercício não tem os valores da folha Aposentado, por isso, não dá pra somar tudo e depois proporcionalizar
 IF @CD_StcFnc <> @CD_StcFncCds and @CD_TpoPrvCds = 27
 BEGIN
 SET @VL_Res = (
 (
 ((@VL_RfrSlrAcm / @nrDiasMes) * @nrDiasPgt) * (@VL_PrcClc / 100)
 )
 )
 - ISNULL(@VL_RfrSlrIcp, 0)
 - ISNULL(@VL_Averbado, 0)

 END
 --Soma tudo depois calcula o proporcional
 ELSE
 BEGIN
 SET @VL_Res = (
 (
 (@VL_RfrSlrAcm * (@VL_PrcClc / 100))
 - ISNULL(@VL_RfrSlrIcp,0)
 - ISNULL(@VL_Averbado, 0)
 )
 / @nrDiasMes * @nrDiasPgt
 )

 END

 PRINT 'Valor resultante....: ' + Cast(@VL_Res AS VARCHAR(15))
 END

 */
public class FormulaGratificacao implements ClasseCalculo{

    private static ClasseCalculo instance;

    public static ClasseCalculo newInstance() {
        return new FormulaGratificacao();
    }

    public static ClasseCalculo instance() {
        if (instance == null) {
            instance = new FormulaGratificacao();
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

        Double percentual = contexto.getRubrica().getPercentual();

        //TODO
        Double referenciaSalariaAcumulada = 0.0;
        Double valorAverbado = 0.0;

        //@VL_Res = (((@VL_RfrSlrAcm * (@VL_PrcClc / 100)) - ISNULL(@VL_RfrSlrIcp,0) - ISNULL(@VL_Averbado, 0)) / @nrDiasMes * @nrDiasPgt)
        Double gratificacao = (referenciaValor.getValor() * (percentual / 100)) - referenciaSalariaAcumulada - valorAverbado;

        contexto.output("gratificacao").setValor(gratificacao);
        return gratificacao;
      }

}

