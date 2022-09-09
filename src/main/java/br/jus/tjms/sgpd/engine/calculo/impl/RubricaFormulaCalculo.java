package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.List;
import java.util.Map;

import br.jus.tjms.sgpd.engine.calculo.FormulaCalculoFactory;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.FormulaOutput;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFormula;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.enumerators.TipoFormula;

public class RubricaFormulaCalculo implements RubricaCalculo {
	
	private static final long serialVersionUID = -4139164753249002028L;
	
	static RubricaCalculo instance;
	
	public static RubricaCalculo newInstance() {
		return new RubricaFormulaCalculo();
	}
	
	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaFormulaCalculo(); 
		}
		
		return instance;
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {
		contexto.setRubrica(rubrica);
		contexto.setRubricaFuncionario(null);
		
		Double resultado = 0.0;
		
		List<RubricaFormula> formulas = rubrica.getFormulas();
		
		for (RubricaFormula rubricaFormula : formulas) {
			Double r = null;
			// TODO não é a solução ideal... (testar se o tipo de fórmula é SCRIPT_SQL e tratar o retorno para pegar o default)
			//      pois obriga a fórmula do tipo SCRIPT_SQL possuir inputs, outputs e um output default, senão nada funciona...
			if (rubricaFormula.getFormula().getTipo().equals(TipoFormula.SCRIPT_SQL)) {
				@SuppressWarnings("unchecked")
				Map<String,Object> map = (Map<String, Object>) FormulaCalculoFactory.fabricar(rubricaFormula.getFormula().getTipo()).calcular(contexto, rubricaFormula.getFormula());
				
				List<FormulaOutput> outputs = rubricaFormula.getFormula().getOutputs();
				for (FormulaOutput formulaOutput : outputs) {
					if (formulaOutput.getResultadoDefault()) {
						r = (Double)map.get("output_"+formulaOutput.getNome());
					}
				}
				
			} else {
 
				r = (Double)FormulaCalculoFactory.fabricar(rubricaFormula.getFormula().getTipo()).calcular(contexto, rubricaFormula.getFormula());			
				
			}
 
			resultado = resultado + r;
		}
		
		return new RubricaCalculoResultado(resultado);
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		contexto.setRubrica(rubricaFuncionario.getRubrica());
		contexto.setRubricaFuncionario(rubricaFuncionario);
		
		Double resultado = 0.0;
		
		List<RubricaFormula> formulas = rubricaFuncionario.getRubrica().getFormulas();
		
		for (RubricaFormula rubricaFormula : formulas) {
			Double r = (Double) FormulaCalculoFactory.fabricar(rubricaFormula.getFormula().getTipo()).calcular(contexto, rubricaFormula.getFormula());
			resultado = resultado + r;
		}
		
		return new RubricaCalculoResultado(resultado);

	}

}
