package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.entity.Pessoa;

public class PlanoSaudePessoaInclusaCalculoProcessor implements ItemCalculoProcessor {
	
	private static final long serialVersionUID = 1778011973063914913L;
	
	static PlanoSaudePessoaInclusaCalculoProcessor instance;
	
	public static PlanoSaudePessoaInclusaCalculoProcessor instance() {
		if (instance == null) {
			instance = new PlanoSaudePessoaInclusaCalculoProcessor(); 
		}
		
		return instance;
	}
	

	public static PlanoSaudePessoaInclusaCalculoProcessor newInstance() {
		return new PlanoSaudePessoaInclusaCalculoProcessor();
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