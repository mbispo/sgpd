package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculoFactory;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;

public class RubricaPercentualLiquidoCalculo implements RubricaCalculo {

	private static final long serialVersionUID = -2137865427553477386L;
	
	static RubricaCalculo instance;

	public static RubricaCalculo newInstance() {
		return new RubricaPercentualLiquidoCalculo();
	}

	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaPercentualLiquidoCalculo();
		}

		return instance;
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {
		Double baseCalculo = RubricaCalculoFactory.fabricar(TipoRubrica.LIQUIDO).calcular(contexto, rubrica).getResultado();
		Double resultado = baseCalculo * (rubrica.getPercentual()/100);
		return new RubricaCalculoResultado(resultado);
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		Double baseCalculo = RubricaCalculoFactory.fabricar(TipoRubrica.LIQUIDO).calcular(contexto, rubricaFuncionario).getResultado();
		Double resultado = baseCalculo * (rubricaFuncionario.getPercentual()/100);
		return new RubricaCalculoResultado(resultado);
	}

}