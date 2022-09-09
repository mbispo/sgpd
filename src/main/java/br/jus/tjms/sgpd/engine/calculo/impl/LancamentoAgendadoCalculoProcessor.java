package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.entity.Pessoa;

public class LancamentoAgendadoCalculoProcessor implements ItemCalculoProcessor {
	
	private static final long serialVersionUID = 7746148056515835676L;
	
	static LancamentoAgendadoCalculoProcessor instance;
	
	public static LancamentoAgendadoCalculoProcessor instance() {
		if (instance == null) {
			instance = new LancamentoAgendadoCalculoProcessor(); 
		}
		
		return instance;
	}
	

	public static LancamentoAgendadoCalculoProcessor newInstance() {
		return new LancamentoAgendadoCalculoProcessor();
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
