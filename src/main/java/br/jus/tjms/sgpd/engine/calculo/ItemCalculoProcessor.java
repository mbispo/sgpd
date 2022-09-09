package br.jus.tjms.sgpd.engine.calculo;

import java.io.Serializable;

import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.entity.Pessoa;

@FunctionalInterface
public interface ItemCalculoProcessor extends Serializable {
	
	ItemCalculo processar(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa);

}
