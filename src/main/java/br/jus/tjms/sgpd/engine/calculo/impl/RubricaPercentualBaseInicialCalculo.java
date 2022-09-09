package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculoFactory;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;

public class RubricaPercentualBaseInicialCalculo implements RubricaCalculo {

	private static final long serialVersionUID = 1115808646601521977L;
	
	static RubricaCalculo instance;
	
	public static RubricaCalculo newInstance() {
		return new RubricaPercentualBaseInicialCalculo();
	}
	
	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaPercentualBaseInicialCalculo(); 
		}
		
		return instance;
	}
	
	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {
		
		Double baseInicial = RubricaCalculoFactory.fabricar(TipoRubrica.BASE_INICIAL).calcular(contexto, rubrica).getResultado();
		
		Double resultado = baseInicial * (rubrica.getPercentual()/100);
		
		return new RubricaCalculoResultado(resultado);
		
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {

		Double baseInicial = RubricaCalculoFactory.fabricar(TipoRubrica.BASE_INICIAL).calcular(contexto, rubricaFuncionario).getResultado();
		
		Double resultado = baseInicial * (rubricaFuncionario.getPercentual()/100);
		
		return new RubricaCalculoResultado(resultado);

	}

}