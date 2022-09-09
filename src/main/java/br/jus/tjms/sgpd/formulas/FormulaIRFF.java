package br.jus.tjms.sgpd.formulas;

import br.jus.tjms.sgpd.engine.calculo.ClasseCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.entity.FormulaOutput;

import java.util.Date;

public class FormulaIRFF implements ClasseCalculo{

    private static ClasseCalculo instance;

    public static ClasseCalculo newInstance() {
        return new FormulaIRFF();
    }

    public static ClasseCalculo instance() {
        if (instance == null) {
            instance = new FormulaIRFF();
        }
        return instance;
    }

    @Override
    public Object calcular(Contexto contexto) {

        FolhaPagamento folhaPagamento = contexto.getFolha();
        Integer mes = folhaPagamento.getMes();
        Integer ano = folhaPagamento.getAno();

        Date dataInicialFolha = br.jus.tjms.sgpd.util.DateUtilz.primeiroDiaDoMes(mes, ano);

        Double descontoIrrfNoMes = contexto.irrfNoMes(ano, mes);
        Double baseIrrfNoMes = contexto.getBaseIrrfNoMes(ano, mes);

        Integer numeroDependentes = contexto.obterNumeroDependentes(dataInicialFolha);
        Double deducaoPorDependentes = contexto.obterParametroDeducaoPorDependente(dataInicialFolha);
        Double deducaoPorAposentadoriaOuIdade = contexto.obterParametroDeducaoPorAposentadoriaOuIdade(dataInicialFolha);


        //TODO extrair metodo e criar teste calcularBaseIrrfNoMes
        Double baseIrrf = baseIrrfNoMes - (deducaoPorDependentes * numeroDependentes) - deducaoPorAposentadoriaOuIdade;


        Double percentualIrrfNaFaixa = contexto.getPercentualIrrfNaFaixa(baseIrrf, dataInicialFolha);
        Double deducaoNaFaixa = contexto.getDeducaoIrrfNaFaixa(baseIrrf, dataInicialFolha);

        Double vlirrf = (baseIrrf * (percentualIrrfNaFaixa / 100.0)) - (deducaoNaFaixa + descontoIrrfNoMes);


        Double irrf = (vlirrf < 10.0 ? 0.0 : vlirrf);


        FormulaOutput formulaOutputIRRF = new FormulaOutput();
        formulaOutputIRRF.setNome("irrf");
        contexto.getFormulaOutputs().add(formulaOutputIRRF);
        contexto.output("irrf").setValor(irrf);

        FormulaOutput formulaOutputBaseIRRF = new FormulaOutput();
        formulaOutputBaseIRRF.setNome("baseIrrf");
        contexto.getFormulaOutputs().add(formulaOutputBaseIRRF);
        contexto.output("baseIrrf").setValor(baseIrrf);

        FormulaOutput formulaOutputNumeroDependentes = new FormulaOutput();
        formulaOutputNumeroDependentes.setNome("numeroDependentes");
        contexto.getFormulaOutputs().add(formulaOutputNumeroDependentes);
        contexto.output("numeroDependentes").setValor(numeroDependentes);

        FormulaOutput formulaOutputDeducaoDependentes = new FormulaOutput();
        formulaOutputDeducaoDependentes.setNome("deducaoPorDependentes");
        contexto.getFormulaOutputs().add(formulaOutputDeducaoDependentes);
        contexto.output("deducaoPorDependentes").setValor(deducaoPorDependentes);

        FormulaOutput formulaOutputDeducaoPorIdadeAposentadoria = new FormulaOutput();
        formulaOutputDeducaoPorIdadeAposentadoria.setNome("deducaoPorIdadeAposentadoria");
        contexto.getFormulaOutputs().add(formulaOutputDeducaoPorIdadeAposentadoria);
        contexto.output("deducaoPorIdadeAposentadoria").setValor(deducaoPorAposentadoriaOuIdade);

        return irrf;
      }

}
