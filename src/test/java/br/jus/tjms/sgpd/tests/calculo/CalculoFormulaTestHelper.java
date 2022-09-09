package br.jus.tjms.sgpd.tests.calculo;

import java.util.ArrayList;
import java.util.List;

import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.entity.FormulaInput;
import br.jus.tjms.sgpd.entity.FormulaOutput;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.enumerators.TipoInputOutput;

public class CalculoFormulaTestHelper {

	public Contexto montaContextoParaTesteCalcularFormula() {
		
		Contexto contexto = new Contexto();
		contexto.setFormulaInputs(montaInputs(null));
		contexto.setFormulaOutputs(montaOutputs(null));
		return contexto;
	}

	//------------------------------------------------------------------------------------------------------------------
	public Formula montaFormulaBonusPorDiaUtilNoMes(TipoFormula tipoFormula) {
		Formula formula = new Formula();
		
		formula.setTipo(tipoFormula);
		switch (tipoFormula) {
			case SCRIPT_GROOVY: {
				formula.setScript(montaScriptGroovyBonusPorDiaUtilNoMes());		
				break;
			}
			case SCRIPT_JAVASCRIPT: {
				formula.setScript(montaScriptJavaScriptBonusPorDiaUtilNoMes());
				break;
			}
			case SCRIPT_SQL: {
				formula.setScript(montaScriptSQLBonusPorDiaUtilNoMes());
				break;
			}
			case CLASSE: {
				formula.setExpressao(montaExpressaoClasseBonusPorDiaUtilNoMes());
				break;
			}
			case METODO_ESTATICO: {
				formula.setExpressao(montaExpressaoMetodoEstaticoBonusPorDiaUtilNoMes());
				break;
			}
			default: {
				break;
			}
		}

		formula.setInputs(montaInputsBonusPorDiaUtilNoMes(formula));
		formula.setOutputs(montaOutputsBonusPorDiaUtilNoMes(formula));
		formula.setNome("bonusPorDiaUtilNoMes");
		formula.setGlobal(true); 	// indica que a fórmula está disponível globalmente para todos os scripts/expressões,
									// e que pode ser referenciada da seguinte forma: 
									//   a = bonusPorDiaUtilNoMes(13.0,2016,3) 
									// esta fórmula depende de outra: diasUteis(2016,3);
		
		return formula;
	}

	public List<FormulaOutput> montaOutputsBonusPorDiaUtilNoMes(Formula formula) {
		List<FormulaOutput> lista = new ArrayList<>();
		lista.add(new FormulaOutput(formula, 1, true, "bonus", TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}

	public List<FormulaInput> montaInputsBonusPorDiaUtilNoMes(Formula formula) {
		List<FormulaInput> lista = new ArrayList<>();
		lista.add(new FormulaInput(formula, 1, "valor", true, TipoInputOutput.DECIMAL, Double.class.getName()));
		lista.add(new FormulaInput(formula, 2, "ano", true, TipoInputOutput.INTEIRO, Integer.class.getName()));
		lista.add(new FormulaInput(formula, 3, "mes", true, TipoInputOutput.INTEIRO, Integer.class.getName()));
		return lista;
	}

	public String montaScriptGroovyBonusPorDiaUtilNoMes() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("def bonusPorDiaUtilNoMes(valor,ano,mes) {\n"
				+ "	  return valor*diasUteis(ano,mes)\n"
				+ "}");
		
		return sb.toString();
	}
	
	public String montaScriptJavaScriptBonusPorDiaUtilNoMes() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("function bonusPorDiaUtilNoMes(valor,ano,mes) {\n"
				+ "	  return valor*diasUteis(ano,mes);\n"
				+ "}");
		
		return sb.toString();
	}
	
	public String montaScriptSQLBonusPorDiaUtilNoMes() {
		return "SET @output_bonus = @input_valor * @input_ano * @input_mes;";
	}
	
	public String montaExpressaoClasseBonusPorDiaUtilNoMes() {
		return "br.jus.tjms.sgpd.tests.calculo.ClasseCalculoParaTeste";
	}
	
	public String montaExpressaoMetodoEstaticoBonusPorDiaUtilNoMes() {
		return "br.jus.tjms.sgpd.tests.calculo.ClasseCalculoParaTeste.metodoEstaticoParaTeste";
	}
	
	//------------------------------------------------------------------------------------------------------------------

	public Formula montaFormulaDiasUteis(TipoFormula tipoFormula) {
		Formula formula = new Formula();
		
		formula.setTipo(tipoFormula);
		
		switch (tipoFormula) {
			case SCRIPT_GROOVY: {
				formula.setScript(montaScriptGroovyDiasUteis());		
				break;
			}
			case SCRIPT_JAVASCRIPT: {
				formula.setScript(montaScriptJavaScriptDiasUteis());
				break;
			}
			default: {
				break;
			}
		}
		
		formula.setInputs(montaInputsDiasUteis(formula));
		formula.setOutputs(montaOutputsDiasUteis(formula));
		formula.setNome("diasUteis");
		formula.setGlobal(true); 	// indica que a fórmula está disponível globalmente para todos os scripts/expressões,
									// e que pode ser referenciada da seguinte forma: 
									//   Integer diasUteis = (Integer)diasUteis(2016,3); 
		
		return formula;
	}
	
	public List<FormulaOutput> montaOutputsDiasUteis(Formula formula) {
		List<FormulaOutput> lista = new ArrayList<>();
		lista.add(new FormulaOutput(formula, 1, true, "dias", TipoInputOutput.INTEIRO, Integer.class.getName()));
		return lista;
	}

	public List<FormulaInput> montaInputsDiasUteis(Formula formula) {
		List<FormulaInput> lista = new ArrayList<>();
		lista.add(new FormulaInput(formula, 1, "ano", true, TipoInputOutput.INTEIRO, Integer.class.getName()));
		lista.add(new FormulaInput(formula, 2, "mes", true, TipoInputOutput.INTEIRO, Integer.class.getName()));
		return lista;
	}

	public String montaScriptGroovyDiasUteis() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("def diasUteis(ano,mes) {\n"
				+ "	  return ano*mes\n"
				+ "}");
		
		return sb.toString();
	}
	
	public String montaScriptJavaScriptDiasUteis() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("function diasUteis(ano,mes) {\n"
				+ "	  return ano*mes;\n"
				+ "}");
		
		return sb.toString();
	}
	
	//------------------------------------------------------------------------------------------------------------------

	// com lista de outputs, o script pode retornar vários valores
	public Formula montaExpressao1UsandoAmbasFormulasGlobais(TipoFormula tipoFormula) {
		Formula formula = new Formula();
		formula.setTipo(tipoFormula);
		formula.setExpressao("contexto.output('bonus').valor = bonusPorDiaUtilNoMes(contexto.input('valor').valor,contexto.input('ano').valor,contexto.input('mes').valor)");
		formula.setInputs(montaInputs(formula));
		formula.setOutputs(montaOutputs(formula));
		formula.setNome("teste");
		formula.setGlobal(false); 
		return formula;
	}
	
	// sem outputs
	public Formula montaExpressao2UsandoAmbasFormulasGlobais(TipoFormula tipoFormula) {
		Formula formula = new Formula();
		formula.setTipo(tipoFormula);
		formula.setExpressao("bonusPorDiaUtilNoMes(contexto.input('valor').valor,contexto.input('ano').valor,contexto.input('mes').valor)");
		formula.setInputs(montaInputs(formula));
		formula.setNome("teste");
		formula.setGlobal(false); 
		return formula;
	}
	
	public List<FormulaOutput> montaOutputs(Formula formula) {
		List<FormulaOutput> lista = new ArrayList<>();
		lista.add(new FormulaOutput(formula, 1, true, "bonus", TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}

	public List<FormulaInput> montaInputs(Formula formula) {
		List<FormulaInput> lista = new ArrayList<>();
		lista.add(new FormulaInput(formula, 1, "valor", true, TipoInputOutput.DECIMAL, Double.class.getName()));
		lista.add(new FormulaInput(formula, 2, "ano", true, TipoInputOutput.INTEIRO, Integer.class.getName()));
		lista.add(new FormulaInput(formula, 3, "mes", true, TipoInputOutput.INTEIRO, Integer.class.getName()));
		return lista;
	}
	
}