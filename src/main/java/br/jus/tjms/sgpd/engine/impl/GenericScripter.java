package br.jus.tjms.sgpd.engine.impl;

import br.jus.tjms.sgpd.engine.Scripter;
import br.jus.tjms.sgpd.exception.SGPException;

public class GenericScripter implements Scripter {
	
	private static final long serialVersionUID = -334556806778381939L;
	
	static Scripter instance;
	
	public static Scripter newInstance() {
		return new GenericScripter();
	}
	
	public static Scripter instance() {
		if (instance == null) {
			instance = new GenericScripter(); 
		}
		
		return instance;
	}

	@Override
	public Object executar(String expressao, Object contexto, String nomeVariavelContexto) throws SGPException {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
