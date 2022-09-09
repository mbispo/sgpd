package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.List;

import br.jus.tjms.sgpd.engine.ScriptEngineFactory;
import br.jus.tjms.sgpd.engine.calculo.FormulaCalculo;
import br.jus.tjms.sgpd.engine.calculo.FormulaGlobalCache;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.enumerators.TipoScript;

public class FormulaMetodoEstaticoCalculo implements FormulaCalculo {

	private static final long serialVersionUID = -2507868849240591919L;
	
	static FormulaCalculo instance;

	public static FormulaCalculo newInstance() {
		return new FormulaMetodoEstaticoCalculo();
	}

	public static FormulaCalculo instance() {
		if (instance == null) {
			instance = new FormulaMetodoEstaticoCalculo();
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
		// usamos a expressão que indica qual classe deve ser usada, com a chamada para o método estático
		
		// Observações:
		//   o método estático deve retornar Object com o resultado do cálculo, deve possuir apenas um paâmetro do tipo Contexto, exemplo:
		//
		//      public Object calcularXYZ(Contexto contexto) {
		//          // retorna 10% do valor do parâmetro de entrada "xyz"
		//			return contexto.input("xyz")*0.1;
		//		}
		//
		
		String metodo = formula.getExpressao();

		sb.append("\n\nreturn "+metodo+"(contexto)");

		// execução e retorno usando a Groovy engine
		Object resultado = ScriptEngineFactory.fabricar(TipoScript.GROOVY_SCRIPT).executar(sb.toString(), contexto, "contexto");
		
		return resultado;

	}

}