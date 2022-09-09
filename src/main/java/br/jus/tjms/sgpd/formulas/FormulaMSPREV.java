package br.jus.tjms.sgpd.formulas;

import br.jus.tjms.sgpd.engine.calculo.ClasseCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.entity.FormulaOutput;

import java.util.Date;

public class FormulaMSPREV implements ClasseCalculo{

    private static ClasseCalculo instance;

    public static ClasseCalculo newInstance() {
        return new FormulaMSPREV();
    }

    public static ClasseCalculo instance() {
        if (instance == null) {
            instance = new FormulaMSPREV();
        }
        return instance;
    }

    @Override
    public Object calcular(Contexto contexto) {

        FolhaPagamento folhaPagamento = contexto.getFolha();
        Integer mes = folhaPagamento.getMes();
        Integer ano = folhaPagamento.getAno();

        Date dataInicialFolha = br.jus.tjms.sgpd.util.DateUtilz.primeiroDiaDoMes(mes, ano);

        Double descontosMSPrevNoMes = getTotalDescontosMSPrevNoMes(contexto, ano, mes);
        Double baseMSPrevNoMes = getBaseMSPrevNoMes(contexto, ano, mes);

        Double percentualMSPrev = getPercentualMSPrevNaFaixa(contexto, baseMSPrevNoMes, dataInicialFolha);
        Double tetoMSPrev = getTetoMSPrevNaFaixa(contexto, baseMSPrevNoMes, dataInicialFolha);
        Double deducaoTetoMSPrev = getDeducaoTetoMSPrev(contexto, tetoMSPrev);

        Double baseMSPrev = baseMSPrevNoMes - deducaoTetoMSPrev;

        // cálculo da contribuição
        Double msprevCalculado = (baseMSPrev * (percentualMSPrev/100.0)) - descontosMSPrevNoMes;
        Double msprev = msprevCalculado > 0.0 ? msprevCalculado : 0.0;

        FormulaOutput formulaOutput = new FormulaOutput();
        formulaOutput.setNome("msprev");
        contexto.getFormulaOutputs().add(formulaOutput);
        contexto.output("msprev").setValor(msprev);

        return msprev;
    }

    private Double getTotalDescontosMSPrevNoMes(Contexto contexto, Integer ano, Integer mes) {
        return contexto.previdenciaRegimeProprioNoMes(ano,mes);
    }

    private Double getBaseMSPrevNoMes(Contexto contexto, Integer ano, Integer mes) {
        Double baseNoMes = contexto.baseCalculoPrevidenciaRegimeProprioNoMes(ano, mes);
        Double baseNaFolha = contexto.baseCalculoPrevidenciaRegimeProprioNaFolha();
        return baseNoMes + baseNaFolha;
    }

    private Double getPercentualMSPrevNaFaixa(Contexto contexto, Double base, Date data) {
        return contexto.getRubrica().getParametrosAtivos(data, base).get(0).getPercentual();
    }

    private Double getTetoMSPrevNaFaixa(Contexto contexto, Double baseIrrf, Date data) {
        return contexto.getRubrica().getParametrosAtivos(data, baseIrrf).get(0).getValorTeto();
    }

    private Double getFatorDeducaoTeto(Contexto contexto) {
        return contexto.getRubricaFuncionario() != null ? contexto.getRubricaFuncionario().getQuantidade() : 0.0;
    }

    private Double getDeducaoTetoMSPrev(Contexto contexto, Double teto) {
        Double fatorDeducaoTeto = getFatorDeducaoTeto(contexto);
        Double fator = (fatorDeducaoTeto > 0.0 ? fatorDeducaoTeto : 1.0);

        if (contexto.aposentadoPorIdade()) {
            return (teto * fator);
        }
        if (contexto.aposentadoPorDoenca()) {
            return ((teto * fator) * 2);
        }
        return 0.0;
    }

}
