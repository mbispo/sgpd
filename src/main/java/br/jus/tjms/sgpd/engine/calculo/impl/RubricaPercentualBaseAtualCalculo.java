package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculoFactory;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;

public class RubricaPercentualBaseAtualCalculo implements RubricaCalculo {
	
	private static final long serialVersionUID = 8420220343443358469L;
	
	static RubricaCalculo instance;
	
	public static RubricaCalculo newInstance() {
		return new RubricaPercentualBaseAtualCalculo();
	}
	
	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaPercentualBaseAtualCalculo(); 
		}
		
		return instance;
	}
	
	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {

		Double baseAtual = RubricaCalculoFactory.fabricar(TipoRubrica.BASE_ATUAL).calcular(contexto, rubrica).getResultado();
		
		Double resultado = baseAtual * (rubrica.getPercentual()/100);
		
		return new RubricaCalculoResultado(resultado);
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		Double baseAtual = RubricaCalculoFactory.fabricar(TipoRubrica.BASE_ATUAL).calcular(contexto, rubricaFuncionario).getResultado();
		
		Double resultado = baseAtual * (rubricaFuncionario.getPercentual()/100);
		
		return new RubricaCalculoResultado(resultado);
	}

}
