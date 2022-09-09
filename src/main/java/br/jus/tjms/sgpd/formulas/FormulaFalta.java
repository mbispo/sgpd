package br.jus.tjms.sgpd.formulas;

import br.jus.tjms.sgpd.engine.calculo.ClasseCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.entity.FormulaOutput;
import br.jus.tjms.sgpd.enumerators.TipoBaseCalculo;
import br.jus.tjms.sgpd.enumerators.TipoPagamentoItem;

import java.util.Date;

/**
 *  SET @VL_PrtQtd = 0
 SELECT @VL_PrtQtd = ISNULL(VL_PrtQtd, 0)
 FROM   sgp.T_ClcFlh
 WHERE  CD_Flh = @CD_Flh
 AND CD_EmpSgp = @CD_EmpSgp
 AND CD_Fnc = @CD_Fnc
 AND CD_Rbc = @CD_Rbc
 AND CD_ClcFlh = @CD_ClcFlh

 -- se o nº de faltas não foi informado nos avulsos, tenta pegar nas rubricas do funcionario
 IF @VL_PrtQtd = 0
 BEGIN
 SELECT @VL_PrtQtd = ISNULL(PR_Clc, 0)
 FROM   sgp.T_RbcFnc
 WHERE  CD_EmpSgp = @CD_EmpSgp
 AND CD_Fnc = @CD_Fnc
 AND CD_Rbc = @CD_Rbc
 END

 -- Resultado
 SELECT @VL_Res = (@VL_Bse / 30) * @VL_PrtQtd
 */
public class FormulaFalta implements ClasseCalculo{

    private static ClasseCalculo instance;

    public static ClasseCalculo newInstance() {
        return new FormulaFalta();
    }

    public static ClasseCalculo instance() {
        if (instance == null) {
            instance = new FormulaFalta();
        }
        return instance;
    }

    @Override
    public Object calcular(Contexto contexto) {

        Double baseCalculo = contexto.totalItensPorRubricasBaseNaFolha();
        Double faltas = (baseCalculo / 30) * contexto.getFaltas();
        contexto.output("faltas").setValor(faltas);

        return faltas;
      }

}
