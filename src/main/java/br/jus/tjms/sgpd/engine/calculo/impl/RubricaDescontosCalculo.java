package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.List;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoResultadoRubricaFuncionarioFolhaCache;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculoResultado;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.enumerators.Sinal;

public class RubricaDescontosCalculo implements RubricaCalculo {

	private static final long serialVersionUID = 2955551246894479417L;
	
	static RubricaCalculo instance;

	public static RubricaCalculo newInstance() {
		return new RubricaDescontosCalculo();
	}

	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaDescontosCalculo();
		}

		return instance;
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {
		Double soma = 0.0;
			
		List<ItemCalculoResultado> resultados = ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache().obterResultadosPorSinal(contexto.getFolha(), contexto.getPessoa(), Sinal.NEGATIVO);
		
		if (resultados != null) {
			for (ItemCalculoResultado itemCalculoResultado : resultados) {
				soma = soma + itemCalculoResultado.getResultado();	
			}
		}

		return new RubricaCalculoResultado(soma);
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		return calcular(contexto, rubricaFuncionario.getRubrica());
	}
	
}