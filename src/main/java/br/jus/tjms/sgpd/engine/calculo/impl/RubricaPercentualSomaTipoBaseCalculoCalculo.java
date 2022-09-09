package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculoFactory;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;

public class RubricaPercentualSomaTipoBaseCalculoCalculo implements RubricaCalculo {

	private static final long serialVersionUID = -8936741367390717334L;
	
	static RubricaCalculo instance;

	public static RubricaCalculo newInstance() {
		return new RubricaPercentualSomaTipoBaseCalculoCalculo();
	}

	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaPercentualSomaTipoBaseCalculoCalculo();
		}

		return instance;
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {
		Double baseCalculo = RubricaCalculoFactory.fabricar(TipoRubrica.SOMA_TIPO_BASE_CALCULO).calcular(contexto, rubrica).getResultado();
		Double resultado = baseCalculo * (rubrica.getPercentual()/100);
		return new RubricaCalculoResultado(resultado);
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		Double baseCalculo = RubricaCalculoFactory.fabricar(TipoRubrica.SOMA_TIPO_BASE_CALCULO).calcular(contexto, rubricaFuncionario).getResultado();
		Double resultado = baseCalculo * (rubricaFuncionario.getPercentual()/100);
		return new RubricaCalculoResultado(resultado);
	}

}