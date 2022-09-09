package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.Date;
import java.util.List;

import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.entity.RubricaParametro;

public class RubricaValorFixoCargoCalculo implements RubricaCalculo {

	private static final long serialVersionUID = -2137513685973925196L;
	
	static RubricaCalculo instance;
	
	public static RubricaCalculo newInstance() {
		return new RubricaValorFixoCargoCalculo();
	}
	
	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaValorFixoCargoCalculo(); 
		}
		
		return instance;
	}
	
	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {

		List<RubricaParametro> parametrosAtivos = rubrica.getParametrosAtivos(new Date(), contexto.getCargo());
		
		if (parametrosAtivos != null && parametrosAtivos.size()>0) {
			return new RubricaCalculoResultado(parametrosAtivos.get(0).getValorFixo());
		}
		
		return new RubricaCalculoResultado(rubrica.getValor());
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		return (rubricaFuncionario.getValor() != null ? new RubricaCalculoResultado(rubricaFuncionario.getValor()) : calcular(contexto, rubricaFuncionario.getRubrica()));
	}

}