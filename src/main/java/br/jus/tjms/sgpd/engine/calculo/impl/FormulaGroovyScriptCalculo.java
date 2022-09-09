package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.List;

import br.jus.tjms.sgpd.engine.ScriptEngineFactory;
import br.jus.tjms.sgpd.engine.calculo.FormulaCalculo;
import br.jus.tjms.sgpd.engine.calculo.FormulaGlobalCache;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.enumerators.TipoScript;

public class FormulaGroovyScriptCalculo implements FormulaCalculo {

	private static final long serialVersionUID = 4504149043309243944L;
	
	static FormulaCalculo instance;

	public static FormulaCalculo newInstance() {
		return new FormulaGroovyScriptCalculo();
	}

	public static FormulaCalculo instance() {
		if (instance == null) {
			instance = new FormulaGroovyScriptCalculo();
		}

		return instance;
	}

    @Override
	public Object calcular(Contexto contexto, Formula formula) {

		StringBuilder sb = new StringBuilder();
		
		List<Formula> formulasGlobaisGroovy = FormulaGlobalCache.instance().getFormulasGlobaisPorTipo(TipoFormula.SCRIPT_GROOVY);
		
		for (Formula f : formulasGlobaisGroovy) {
			sb.append("\n\n"+f.getScript());
		}
		
		// e acrescentamos o script/expressão da fórmula que vamos executar agora
		sb.append("\n\n"+formula.getScript());

		// execução e retorno usando a Groovy engine
		contexto.setFormulaInputs(formula.getInputs());
		contexto.setFormulaOutputs(formula.getOutputs());
		Object resultado = ScriptEngineFactory.fabricar(TipoScript.GROOVY_SCRIPT).executar(sb.toString(), contexto, "contexto");
		
		return resultado;

	}

}