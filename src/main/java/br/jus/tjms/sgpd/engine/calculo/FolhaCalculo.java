package br.jus.tjms.sgpd.engine.calculo;

import java.io.Serializable;

import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;

@FunctionalInterface
public interface FolhaCalculo extends Serializable {
	
	public Object calcular(Contexto contextoGlobal, FolhaPagamento folha);

}
