package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.entity.Pessoa;

public class LicencaCalculoProcessor implements ItemCalculoProcessor {

	private static final long serialVersionUID = 9160996032128701737L;

	static LicencaCalculoProcessor instance;
	
	public static LicencaCalculoProcessor instance() {
		if (instance == null) {
			instance = new LicencaCalculoProcessor(); 
		}
		
		return instance;
	}
	

	public static LicencaCalculoProcessor newInstance() {
		return new LicencaCalculoProcessor();
	}

	@Override
	public ItemCalculo processar(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		
		/* TODO aqui efetivamente o cálculo deve ser processado
		 * 
		 * 
		 */
		
		return itemCalculo;
		
	}

}