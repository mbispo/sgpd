package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.entity.Pessoa;

public class ConcessaoFeriasCalculoProcessor implements ItemCalculoProcessor {

	private static final long serialVersionUID = 2832875249646490556L;
	
	static ConcessaoFeriasCalculoProcessor instance;
	
	public static ConcessaoFeriasCalculoProcessor instance() {
		if (instance == null) {
			instance = new ConcessaoFeriasCalculoProcessor(); 
		}
		
		return instance;
	}
	

	public static ConcessaoFeriasCalculoProcessor newInstance() {
		return new ConcessaoFeriasCalculoProcessor();
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