package br.jus.tjms.sgpd.formulas;

import br.jus.tjms.sgpd.engine.calculo.ClasseCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.Referencia;
import br.jus.tjms.sgpd.entity.ReferenciaValor;

import java.util.Date;

/**
 IF @CD_Rbc = 274
 BEGIN
 SET DATEFORMAT YMD
 SELECT @PR_Adc = trf.PR_Clc
 FROM   sgp.T_RbcFnc trf
 WHERE  trf.CD_EmpSgp = @CD_EmpSGP
 AND trf.CD_Fnc = @CD_Fnc
 AND trf.CD_StcFnc = @CD_StcFnc
 AND trf.CD_Rbc = @CD_Rbc

 SELECT @VL_RfrSlr = ISNULL(v.VL_RfrSlr, 0)
 FROM   sgp.T_RfrSlr r
 JOIN sgp.T_VlrRfrSlr v
 ON  (r.CD_RfrSlr = v.CD_RfrSlr)
 WHERE  r.CD_RfrSlr = 777 --AGSG-1
 AND @data_inicio_folha >= v.DT_INI
 AND @data_fim_folha <= v.DT_FIM

 SELECT @VL_Res = @VL_RfrSlr * (@PR_Adc / 100.00)

 SET @VL_Prm1 = @VL_RfrSlr
 SET @VL_Prm2 = @PR_Adc / 100.00
 END
 */
public class FormulaInsalubridade implements ClasseCalculo{

    private static ClasseCalculo instance;

    public static ClasseCalculo newInstance() {
        return new FormulaInsalubridade();
    }

    public static ClasseCalculo instance() {
        if (instance == null) {
            instance = new FormulaInsalubridade();
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

        //@VL_Res = @VL_RfrSlr * (@PR_Adc / 100.00)
        Double insalubridade = referenciaValor.getValor() * (percentual / 100);
        contexto.output("insalubridade").setValor(insalubridade);
        return insalubridade;
      }

}

