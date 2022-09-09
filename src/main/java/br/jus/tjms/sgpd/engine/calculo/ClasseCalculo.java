package br.jus.tjms.sgpd.engine.calculo;

import java.io.Serializable;

import br.jus.tjms.sgpd.engine.to.Contexto;

@FunctionalInterface
public interface ClasseCalculo extends Serializable {

	public Object calcular(Contexto contexto);

}