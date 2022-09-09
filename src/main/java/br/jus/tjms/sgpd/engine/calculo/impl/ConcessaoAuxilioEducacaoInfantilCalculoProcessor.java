package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.entity.Pessoa;

public class ConcessaoAuxilioEducacaoInfantilCalculoProcessor implements ItemCalculoProcessor {
	
	private static final long serialVersionUID = -4948126744670755548L;
	
	static ConcessaoAuxilioEducacaoInfantilCalculoProcessor instance;
	
	public static ConcessaoAuxilioEducacaoInfantilCalculoProcessor instance() {
		if (instance == null) {
			instance = new ConcessaoAuxilioEducacaoInfantilCalculoProcessor(); 
		}
		
		return instance;
	}

	public static ConcessaoAuxilioEducacaoInfantilCalculoProcessor newInstance() {
		return new ConcessaoAuxilioEducacaoInfantilCalculoProcessor();
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