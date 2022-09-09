package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.FolhaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;

public class FolhaDecimoTerceiroCalculo implements FolhaCalculo {
	
	private static final long serialVersionUID = 6483987109279576775L;
	
	static FolhaCalculo instance;
	
	public static FolhaCalculo newInstance() {
		return new FolhaDecimoTerceiroCalculo();
	}
	
	public static FolhaCalculo instance() {
		if (instance == null) {
			instance = new FolhaDecimoTerceiroCalculo(); 
		}
		
		return instance;
	}
	

	@Override
	public Object calcular(Contexto contexto, FolhaPagamento folha) {
		// TODO Auto-generated method stub
		return null;
	}

}
