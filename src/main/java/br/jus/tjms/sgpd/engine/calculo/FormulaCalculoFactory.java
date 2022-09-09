package br.jus.tjms.sgpd.engine.calculo;

import br.jus.tjms.sgpd.engine.calculo.impl.FormulaClasseCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FormulaExpressaoGroovyCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FormulaExpressaoJavaScriptCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FormulaGroovyScriptCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FormulaJavaScriptCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FormulaMetodoEstaticoCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FormulaProcedureCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FormulaSQLScriptCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FormulaScriptCalculo;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.exception.SGPException;

/**
 * Fábrica de calculadores de formula de acordo com o tipo TipoFormula
 * usados para calcular rubricas do tipo FORMULA
 * @author marcos.bispo
 *
 */
public class FormulaCalculoFactory {
	
	private FormulaCalculoFactory() {
	}

	/**
	 * Cria a calculadora de fórmulas de acordo com o tipo TipoFormula
	 * @param TipoFormula tipo
	 * @return FormulaCalculo Implementação de acordo com o tipo (FormulaExpressaoCalculo, FormulaClasseCalculo ...)
	 */
	public static FormulaCalculo fabricar(TipoFormula tipo) {
		switch (tipo) {
			case EXPRESSAO_GROOVY: 		return FormulaExpressaoGroovyCalculo.instance();
			case EXPRESSAO_JAVASCRIPT: 	return FormulaExpressaoJavaScriptCalculo.instance();
			case CLASSE: 				return FormulaClasseCalculo.instance();
			case METODO_ESTATICO: 		return FormulaMetodoEstaticoCalculo.instance();
			case SCRIPT_JAVASCRIPT: 	return FormulaJavaScriptCalculo.instance();
			case SCRIPT_GROOVY: 		return FormulaGroovyScriptCalculo.instance();
			case SCRIPT_SQL: 			return FormulaSQLScriptCalculo.instance();
			case PROCEDURE: 			return FormulaProcedureCalculo.instance();
			case SCRIPT: 				return FormulaScriptCalculo.instance();
			default: 					throw new SGPException("Tipo de fórmula não informado!");
		}
	}

}