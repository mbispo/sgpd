package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.List;

import br.jus.tjms.sgpd.engine.ScriptEngineFactory;
import br.jus.tjms.sgpd.engine.calculo.FormulaCalculo;
import br.jus.tjms.sgpd.engine.calculo.FormulaGlobalCache;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.enumerators.TipoScript;

public class FormulaClasseCalculo implements FormulaCalculo {
	
	private static final long serialVersionUID = -6893163719999585665L;
	
	static FormulaCalculo instance;
	
	public static FormulaCalculo newInstance() {
		return new FormulaClasseCalculo();
	}
	
	public static FormulaCalculo instance() {
		if (instance == null) {
			instance = new FormulaClasseCalculo(); 
		}
		
		return instance;
	}

	@Override
	public Object calcular(Contexto contexto, Formula formula) {

        // aqui começamos a montar um script que conterá os scripts de fórmulas globais
		StringBuilder sb = new StringBuilder();
		
		List<Formula> formulasGlobaisGroovy = FormulaGlobalCache.instance().getFormulasGlobaisPorTipo(TipoFormula.SCRIPT_GROOVY);
		
		for (Formula f : formulasGlobaisGroovy) {
			sb.append("\n\n"+f.getScript());
		}
		
		// e acrescentamos o script/expressão da fórmula que vamos executar agora
		// usamos a expressão que indica qual classe deve ser usada, com a chamada para o método executar
		
		// Observações:
		//   a classe deve implementar a interface br.jus.tjms.sgpd.engine.calculo.ClasseCalculo (que define o método calcular(Contexto contexto))
		//   a classe deve possuir um étodo estático instance que retorna uma instância da classe
		
		String classe = formula.getExpressao();
		
		sb.append("\n\nreturn ("+classe+" as Class).instance().calcular(contexto)");

        contexto.getFormulaInputs().addAll(formula.getInputs());
        contexto.getFormulaOutputs().addAll(formula.getOutputs());

		// execução e retorno usando a Groovy engine
		Object resultado = ScriptEngineFactory.fabricar(TipoScript.GROOVY_SCRIPT).executar(sb.toString(), contexto, "contexto");
		
		return resultado;
	}
}