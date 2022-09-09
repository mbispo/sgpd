package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.FolhaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;

public class FolhaFeriasCalculo implements FolhaCalculo {

	private static final long serialVersionUID = 4154837846038599248L;
	
	static FolhaCalculo instance;
	
	public static FolhaCalculo newInstance() {
		return new FolhaFeriasCalculo();
	}
	
	public static FolhaCalculo instance() {
		if (instance == null) {
			instance = new FolhaFeriasCalculo(); 
		}
		
		return instance;
	}
	

	@Override
	public Object calcular(Contexto contexto, FolhaPagamento folha) {
		// TODO Auto-generated method stub
		return null;
	}

}