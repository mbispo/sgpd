package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.entity.Pessoa;

public class ConcessaoAdicionalQualificacaoCalculoProcessor implements ItemCalculoProcessor {

	private static final long serialVersionUID = -3455623116896960976L;
	
	static ConcessaoAdicionalQualificacaoCalculoProcessor instance;
	
	public static ConcessaoAdicionalQualificacaoCalculoProcessor instance() {
		if (instance == null) {
			instance = new ConcessaoAdicionalQualificacaoCalculoProcessor(); 
		}
		
		return instance;
	}
	

	public static ConcessaoAdicionalQualificacaoCalculoProcessor newInstance() {
		return new ConcessaoAdicionalQualificacaoCalculoProcessor();
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