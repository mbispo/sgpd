package br.jus.tjms.sgpd.engine.calculo;

import java.io.Serializable;

import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;

public interface RubricaCalculo extends Serializable {
	
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica);
	
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario);

}
