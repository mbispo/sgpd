package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.entity.Pessoa;

public class LancamentoRecorrenteCalculoProcessor implements ItemCalculoProcessor {
	
	private static final long serialVersionUID = -1838984485656079864L;
	
	static LancamentoRecorrenteCalculoProcessor instance;
	
	public static LancamentoRecorrenteCalculoProcessor instance() {
		if (instance == null) {
			instance = new LancamentoRecorrenteCalculoProcessor(); 
		}
		
		return instance;
	}
	

	public static LancamentoRecorrenteCalculoProcessor newInstance() {
		return new LancamentoRecorrenteCalculoProcessor();
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
