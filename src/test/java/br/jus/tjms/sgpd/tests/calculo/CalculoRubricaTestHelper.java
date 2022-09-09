package br.jus.tjms.sgpd.tests.calculo;

import java.util.ArrayList;
import java.util.List;

import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Cargo;
import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.entity.FormulaInput;
import br.jus.tjms.sgpd.entity.FormulaOutput;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.ProgressaoFuncional;
import br.jus.tjms.sgpd.entity.Referencia;
import br.jus.tjms.sgpd.entity.ReferenciaValor;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFormula;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.enumerators.TipoInputOutput;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;
import br.jus.tjms.sgpd.util.DateUtilz;

public class CalculoRubricaTestHelper {

	public Contexto montaContextoParaTesteCalcularRubricaBaseInicial(final Double valor) {
		return new Contexto().setFuncionarioCargo(montaCargoFuncionario(valor, valor*1.025));
	}

	public Contexto montaContextoParaTesteCalcularRubricaBaseAtual(final Double valor) {
		return new Contexto().setFuncionarioCargo(montaCargoFuncionario(valor-(valor*0.025), valor));
	}
	
	public Contexto montaContextoParaTesteCalcularRubricaFormulaSQLScript() {
		Contexto contexto = new Contexto();
		contexto.setFormulaInputs(montaInputs(null));
		contexto.setFormulaOutputs(montaOutputs(null));
		return contexto;
	}

	private List<FormulaOutput> montaOutputs(Formula formula) {
		List<FormulaOutput> lista = new ArrayList<>();
		lista.add(new FormulaOutput(formula, 1, true, "bonus", TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}

	private List<FormulaInput> montaInputs(Formula formula) {
		List<FormulaInput> lista = new ArrayList<>();
		lista.add(new FormulaInput(formula, 1, "valor", true, TipoInputOutput.DECIMAL, Double.class.getName()));
		lista.add(new FormulaInput(formula, 2, "ano", true, TipoInputOutput.INTEIRO, Integer.class.getName()));
		lista.add(new FormulaInput(formula, 3, "mes", true, TipoInputOutput.INTEIRO, Integer.class.getName()));
		return lista;
	}
	
	public FuncionarioCargo montaCargoFuncionario(final Double valorInicial, final Double valorAtual) {
		// cria o cargo
		Cargo c = new Cargo();
		c.setNome("Técnico de nível superior");
		c.setSimbolo("TNSU");

		// vincula cargo ao funcionário
		FuncionarioCargo fc = new FuncionarioCargo();		
		fc.setCargo(c);
		fc.setDataInicio(DateUtilz.criaData(1, 8, 2006));
		fc.setDataFim(null);
		
		// cria referência salarial inicial
		Referencia r1 = new Referencia();
		r1.setCargo(c);
		r1.setNivel(1);
		r1.setSigla("TNS1");
		// cria referência salarial atual
		Referencia r2 = new Referencia();
		r2.setCargo(c);
		r2.setNivel(2);
		r2.setSigla("TNS2");
		
		// cria valor para a referência inicial
		ReferenciaValor rv1 = new ReferenciaValor();
		rv1.setValor(valorInicial);
		rv1.setReferencia(r1);
		rv1.setVigenciaInicio(DateUtilz.criaData(1, 4, 2016));
		rv1.setVigenciaFim(null);		
		
		// cria valor para a referência atual
		ReferenciaValor rv2 = new ReferenciaValor();
		rv2.setValor(valorAtual);
		rv2.setReferencia(r2);
		rv2.setVigenciaInicio(DateUtilz.criaData(1, 4, 2016));
		rv2.setVigenciaFim(null);
		
		r1.getValores().add(rv1);
		r2.getValores().add(rv2);

		// cria progressões funcionais
		ProgressaoFuncional pf1 = new ProgressaoFuncional();		
		pf1.setDataProgressao(DateUtilz.criaData(1, 8, 2009));		
		pf1.setReferencia(r1);
		
		ProgressaoFuncional pf2 = new ProgressaoFuncional();		
		pf2.setDataProgressao(DateUtilz.criaData(1, 8, 2011));		
		pf2.setReferencia(r2);
		
		fc.getProgressoes().add(pf1);
		fc.getProgressoes().add(pf2);
		
		return fc;
	}

	public Rubrica montaRubricaParaTesteCalcularRubricaFormula(Double percentual, TipoFormula tipoFormula) {
		
		Rubrica rubrica = new Rubrica();
		rubrica.setTipo(TipoRubrica.FORMULA);
		rubrica.getFormulas().add(montaFormulaParaTesteCalcularRubricaFormula(rubrica, tipoFormula));
		rubrica.setAtiva(true);
		rubrica.setPercentual(percentual);
		rubrica.setSinal(Sinal.POSITIVO);

		return rubrica;
	}
	
	public RubricaFormula montaFormulaParaTesteCalcularRubricaFormula(Rubrica rubrica, TipoFormula tipoFormula) {
		Formula formula = new Formula();
		formula.setTipo(tipoFormula);
		
		switch (tipoFormula) {
			case CLASSE: { 
				formula.setExpressao(montaExpressaoClasseParaTesteCalcularRubricaFormula());
				break;
			}
			case EXPRESSAO_GROOVY: {
				formula.setExpressao(montaExpressaoGroovyParaTesteCalcularRubricaFormula());
				break;
			}
			case EXPRESSAO_JAVASCRIPT: {
				formula.setExpressao(montaExpressaoJavaScriptParaTesteCalcularRubricaFormula());
				break;
			}
			case METODO_ESTATICO: {
				formula.setExpressao(montaExpressaoMetodoEstaticoParaTesteCalcularRubricaFormula());
				break;
			}
			case SCRIPT_GROOVY: {
				formula.setScript(montaScriptGroovyParaTesteCalcularRubricaFormula());
				break;
			}
			case SCRIPT_JAVASCRIPT: {
				formula.setScript(montaScriptJavaScriptParaTesteCalcularRubricaFormula());
				break;
			}
			case SCRIPT_SQL: {
				formula.setScript(montaScriptSQLParaTesteCalcularRubricaFormula());
				formula.setInputs(montaInputs(formula));
				formula.setOutputs(montaOutputs(formula));
				break;
			}
			default: {
				break;
			}
		}
		
		formula.setGlobal(false);
		
		RubricaFormula rubricaFormula = new RubricaFormula();
		rubricaFormula.setRubrica(rubrica);
		rubricaFormula.setFormula(formula);
		
		return rubricaFormula;
	}
	
	private String montaExpressaoClasseParaTesteCalcularRubricaFormula() {
		return "br.jus.tjms.sgpd.tests.calculo.ClasseCalculoParaTesteCalcularRubricaFormula";
	}
	
	private String montaExpressaoMetodoEstaticoParaTesteCalcularRubricaFormula() {
		return "br.jus.tjms.sgpd.tests.calculo.ClasseCalculoParaTesteCalcularRubricaFormula.metodoEstaticoParaTeste";
	}

	private String montaScriptGroovyParaTesteCalcularRubricaFormula() {
		StringBuilder script = new StringBuilder();
		
		script
			.append("\nfuncionarioCargo = contexto.funcionarioCargo")
			.append("\nprogressaoAtual = funcionarioCargo.progressaoAtual")
			.append("\nreferenciaValor = progressaoAtual.referencia.getValorAtual(new Date())")
			.append("\nresultado = (referenciaValor.valor * (contexto.rubricaFuncionario != null ? contexto.rubricaFuncionario.percentual : contexto.rubrica.percentual)) / 100.0")
			.append("\nreturn resultado");
		
		return script.toString();
	}
	
	private String montaScriptJavaScriptParaTesteCalcularRubricaFormula() {
		StringBuilder script = new StringBuilder();
		
		script
			.append("\nfuncionarioCargo = contexto.funcionarioCargo")
			.append("\nprogressaoAtual = funcionarioCargo.progressaoAtual")
			.append("\nreferenciaValor = progressaoAtual.referencia.getValorAtual(new java.util.Date())")
			.append("\nresultado = (referenciaValor.valor * (contexto.rubricaFuncionario != null ? contexto.rubricaFuncionario.percentual : contexto.rubrica.percentual)) / 100.0")
			.append("\nresultado");
		
		return script.toString();
	}
	
	private String montaScriptSQLParaTesteCalcularRubricaFormula() {
		return "SET @output_bonus = ((@input_valor * @input_ano * @input_mes) * @rubrica_percentual) / 100.0;";
	}
	
	private String montaExpressaoGroovyParaTesteCalcularRubricaFormula() {
		return "(contexto.funcionarioCargo.progressaoAtual.referencia.getValorAtual(new Date()).valor * (contexto.rubricaFuncionario != null ? contexto.rubricaFuncionario.percentual : contexto.rubrica.percentual)) / 100.0";
	}
	
	private String montaExpressaoJavaScriptParaTesteCalcularRubricaFormula() {
		return "(contexto.funcionarioCargo.progressaoAtual.referencia.getValorAtual(new java.util.Date()).valor * (contexto.rubricaFuncionario != null ? contexto.rubricaFuncionario.percentual : contexto.rubrica.percentual)) / 100.0";
	}

}