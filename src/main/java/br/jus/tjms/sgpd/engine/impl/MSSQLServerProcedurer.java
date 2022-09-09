package br.jus.tjms.sgpd.engine.impl;

import br.jus.tjms.sgpd.engine.Scripter;
import br.jus.tjms.sgpd.exception.SGPException;

public class MSSQLServerProcedurer implements Scripter {
	
	private static final long serialVersionUID = -1171537596902616798L;
	
	static Scripter instance;
	
	public static Scripter newInstance() {
		return new MSSQLServerProcedurer();
	}
	
	public static Scripter instance() {
		if (instance == null) {
			instance = new MSSQLServerProcedurer(); 
		}
		
		return instance;
	}

	@Override
	public Object executar(String expressao, Object contexto, String nomeVariavelContexto) throws SGPException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
