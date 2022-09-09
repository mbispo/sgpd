package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.List;

import br.jus.tjms.sgpd.engine.ScriptEngineFactory;
import br.jus.tjms.sgpd.engine.calculo.FormulaCalculo;
import br.jus.tjms.sgpd.engine.calculo.FormulaGlobalCache;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.enumerators.TipoScript;

public class FormulaJavaScriptCalculo implements FormulaCalculo {

	private static final long serialVersionUID = -5723633905747240883L;
	
	static FormulaCalculo instance;

	public static FormulaCalculo newInstance() {
		return new FormulaJavaScriptCalculo();
	}

	public static FormulaCalculo instance() {
		if (instance == null) {
			instance = new FormulaJavaScriptCalculo();
		}

		return instance;
	}

    @Override
	public Object calcular(Contexto contexto, Formula formula) {
		// aqui começamos a montar um script que conterá os scripts de fórmulas globais
		StringBuilder sb = new StringBuilder();
		
		List<Formula> formulasGlobaisJavaScript = FormulaGlobalCache.instance().getFormulasGlobaisPorTipo(TipoFormula.SCRIPT_JAVASCRIPT);
		
		for (Formula f : formulasGlobaisJavaScript) {
			sb.append("\n\n"+f.getScript());
		}
		
		// e acrescentamos o script/expressão da fórmula que vamos executar agora
		sb.append("\n\n"+formula.getScript());

		// execução e retorno usando a JavaScript engine
		Object resultado = ScriptEngineFactory.fabricar(TipoScript.JAVA_SCRIPT).executar(sb.toString(), contexto, "contexto");
		
		return resultado;

	}

}