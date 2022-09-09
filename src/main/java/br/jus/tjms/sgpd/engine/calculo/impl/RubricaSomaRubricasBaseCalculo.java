package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.List;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoResultadoRubricaFuncionarioFolhaCache;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculoResultado;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaBase;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.exception.SGPException;

public class RubricaSomaRubricasBaseCalculo implements RubricaCalculo {
	
	private static final long serialVersionUID = 9199113861702057473L;
	
	static RubricaCalculo instance;
	
	public static RubricaCalculo newInstance() {
		return new RubricaSomaRubricasBaseCalculo();
	}
	
	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaSomaRubricasBaseCalculo(); 
		}
		
		return instance;
	}
	
	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {
		Double soma = 0.0;
		
		List<RubricaBase> rubricasBase = rubrica.getRubricasBase();
		
		for (RubricaBase rubricaBase : rubricasBase) {
			ItemCalculoResultado r = ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache().obterResultado(contexto.getFolha(), contexto.getPessoa(), rubricaBase.getRubricaBase());
			if (r != null) {
				Double valorCalculado = r.getResultado(); 
				soma = soma + valorCalculado;
			} else {
				throw new SGPException("Falha ao calcular '"+rubrica.getDescricao()+"': Rubrica base '"+rubricaBase.getRubricaBase().getDescricao()+"' ainda não foi calculada!");
			}
		}

		return new RubricaCalculoResultado(soma);
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		return calcular(contexto, rubricaFuncionario.getRubrica());
	}

}