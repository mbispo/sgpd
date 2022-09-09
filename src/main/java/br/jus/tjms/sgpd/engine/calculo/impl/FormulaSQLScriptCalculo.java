package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.List;
import java.util.Map;

import br.jus.tjms.sgpd.engine.ScriptEngineFactory;
import br.jus.tjms.sgpd.engine.calculo.FormulaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.entity.FormulaOutput;
import br.jus.tjms.sgpd.enumerators.TipoScript;

public class FormulaSQLScriptCalculo implements FormulaCalculo {

	private static final long serialVersionUID = -8460892968604008933L;
	
	static FormulaCalculo instance;

	public static FormulaCalculo newInstance() {
		return new FormulaSQLScriptCalculo();
	}

	public static FormulaCalculo instance() {
		if (instance == null) {
			instance = new FormulaSQLScriptCalculo();
		}

		return instance;
	}

    @Override
	public Object calcular(Contexto contexto, Formula formula) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n\n"+formula.getScript());
		
		Object resultado = ScriptEngineFactory.fabricar(TipoScript.SQL_SCRIPT).executar(sb.toString(), contexto, "contexto");

		if (resultado instanceof Map) {
			
			List<FormulaOutput> outputs = contexto.getFormulaOutputs();
			
			for (FormulaOutput formulaOutput : outputs) {
				formulaOutput.setValor(((Map<String, Object>) resultado).get("output_"+formulaOutput.getNome()));
			}
			
		}
		
		return resultado;
	}

}