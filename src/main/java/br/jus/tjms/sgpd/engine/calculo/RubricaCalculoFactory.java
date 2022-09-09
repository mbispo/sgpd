package br.jus.tjms.sgpd.engine.calculo;

import br.jus.tjms.sgpd.engine.calculo.impl.RubricaBaseAtualCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaBaseInicialCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaBrutoCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaDescontosCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaFormulaCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaLiquidoCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaPercentualBaseAtualCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaPercentualBaseInicialCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaPercentualBrutoCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaPercentualDescontosCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaPercentualLiquidoCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaPercentualSomaRubricasBaseCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaPercentualSomaTipoBaseCalculoCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaSomaRubricasBaseCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaSomaTipoBaseCalculoCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaValorFixoAreaCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaValorFixoAreaCargoCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaValorFixoCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.RubricaValorFixoCargoCalculo;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;
import br.jus.tjms.sgpd.exception.SGPException;

/**
 * Fábrica de calculadores de rubrica de acordo com o tipo
 * @author marcos.bispo
 *
 */
public class RubricaCalculoFactory {
	
	private RubricaCalculoFactory() {
	}

	/**
	 * Cria a calculadora da rubrica de acordo com tipo TipoRubrica
	 * @param TipoRubrica tipo
	 * @return RubricaCalculo implementação de acordo com o tipo TipoRubrica (RubricaBaseInicialCalculo, RubricaPercentualBaseInicialCalculo ...)
	 */
	public static RubricaCalculo fabricar(TipoRubrica tipo) {
		switch (tipo) {
			case BASE_INICIAL:				return RubricaBaseInicialCalculo.instance();
			case PERCENTUAL_BASE_INICIAL: 	return RubricaPercentualBaseInicialCalculo.instance();
			case BASE_ATUAL: 				return RubricaBaseAtualCalculo.instance();
			case PERCENTUAL_BASE_ATUAL: 	return RubricaPercentualBaseAtualCalculo.instance();
			case FORMULA: 					return RubricaFormulaCalculo.instance();			
			case VALOR_FIXO: 				return RubricaValorFixoCalculo.instance();
			case VALOR_FIXO_AREA: 			return RubricaValorFixoAreaCalculo.instance();
			case VALOR_FIXO_CARGO: 			return RubricaValorFixoCargoCalculo.instance();
			case VALOR_FIXO_AREA_CARGO: 	return RubricaValorFixoAreaCargoCalculo.instance();
			
			case SOMA_RUBRICAS_BASE: 		return RubricaSomaRubricasBaseCalculo.instance();
			case PERCENTUAL_SOMA_RUBRICAS_BASE: return RubricaPercentualSomaRubricasBaseCalculo.instance();
			case SOMA_TIPO_BASE_CALCULO: 	return RubricaSomaTipoBaseCalculoCalculo.instance();
			case PERCENTUAL_SOMA_TIPO_BASE_CALCULO: return RubricaPercentualSomaTipoBaseCalculoCalculo.instance();
			case BRUTO: 					return RubricaBrutoCalculo.instance();
			case PERCENTUAL_BRUTO: 			return RubricaPercentualBrutoCalculo.instance();
			case DESCONTOS: 				return RubricaDescontosCalculo.instance();
			case PERCENTUAL_DESCONTOS: 		return RubricaPercentualDescontosCalculo.instance();
			case LIQUIDO: 					return RubricaLiquidoCalculo.instance();
			case PERCENTUAL_LIQUIDO: 		return RubricaPercentualLiquidoCalculo.instance();
			default: 						throw new SGPException("Tipo de rubrica não informado!");
		}
	}
}