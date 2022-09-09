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

public class RubricaLiquidoCalculo implements RubricaCalculo {

	private static final long serialVersionUID = -6367477392794369740L;
	
	static RubricaCalculo instance;

	public static RubricaCalculo newInstance() {
		return new RubricaLiquidoCalculo();
	}

	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaLiquidoCalculo();
		}

		return instance;
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {
		Double bruto = 0.0;
		Double descontos = 0.0;
			
		List<ItemCalculoResultado> resultadosBruto = ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache().obterResultadosPorSinal(contexto.getFolha(), contexto.getPessoa(), Sinal.POSITIVO);
		List<ItemCalculoResultado> resultadosDesconto = ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache().obterResultadosPorSinal(contexto.getFolha(), contexto.getPessoa(), Sinal.NEGATIVO);
		
		if (resultadosBruto != null) {
			for (ItemCalculoResultado itemCalculoResultado : resultadosBruto) {
				bruto = bruto + itemCalculoResultado.getResultado();	
			}
		}
		if (resultadosDesconto != null) {
			for (ItemCalculoResultado itemCalculoResultado : resultadosDesconto) {
				descontos = descontos + itemCalculoResultado.getResultado();	
			}
		}

		Double resultado = bruto - descontos;

		return new RubricaCalculoResultado(resultado);
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		return calcular(contexto, rubricaFuncionario.getRubrica());
	}
	
}