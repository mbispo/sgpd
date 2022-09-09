package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.FolhaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;

public class FolhaOutrosCalculo implements FolhaCalculo {

	private static final long serialVersionUID = -6538556472093158118L;
	
	static FolhaCalculo instance;

	public static FolhaCalculo newInstance() {
		return new FolhaOutrosCalculo();
	}

	public static FolhaCalculo instance() {
		if (instance == null) {
			instance = new FolhaOutrosCalculo();
		}

		return instance;
	}

	@Override
	public Object calcular(Contexto contexto, FolhaPagamento folha) {
		// TODO Auto-generated method stub
		return null;
	}

}