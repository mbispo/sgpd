package br.jus.tjms.sgpd.engine.calculo;

import java.io.Serializable;

import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Formula;

@FunctionalInterface
public interface FormulaCalculo extends Serializable {
	
	public Object calcular(Contexto contexto, Formula formula);

}