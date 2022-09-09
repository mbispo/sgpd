package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.List;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoResultadoRubricaFuncionarioFolhaCache;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculoResultado;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.entity.RubricaUtilizaBaseCalculo;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.exception.SGPException;

public class RubricaSomaTipoBaseCalculoCalculo implements RubricaCalculo {
	
	private static final long serialVersionUID = -3691777622021654323L;
	
	static RubricaCalculo instance;
	
	public static RubricaCalculo newInstance() {
		return new RubricaSomaTipoBaseCalculoCalculo();
	}
	
	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaSomaTipoBaseCalculoCalculo(); 
		}
		
		return instance;
	}
	
	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {
		Double soma = 0.0;
		
		List<RubricaUtilizaBaseCalculo> listaUtilizaBaseCalculo = rubrica.getUtilizaTiposBaseCalculo();
		
		for (RubricaUtilizaBaseCalculo utilizaBaseCalculo : listaUtilizaBaseCalculo) {
			
			List<ItemCalculoResultado> resultadosSoma = ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache().obterResultadosPorComposicaoTipoBaseCalculo(contexto.getFolha(), contexto.getPessoa(), utilizaBaseCalculo.getTipoBaseCalculo(), Sinal.POSITIVO);
			
			if (resultadosSoma != null) {
				for (ItemCalculoResultado itemCalculoResultado : resultadosSoma) {
					soma = soma + itemCalculoResultado.getResultado();	
				}
			} else {
				throw new SGPException("Rubrica base ainda não foi calculada!");
			}
			
			List<ItemCalculoResultado> resultadosDesconta = ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache().obterResultadosPorComposicaoTipoBaseCalculo(contexto.getFolha(), contexto.getPessoa(), utilizaBaseCalculo.getTipoBaseCalculo(), Sinal.NEGATIVO);
			
			if (resultadosDesconta != null) {
				for (ItemCalculoResultado itemCalculoResultado : resultadosDesconta) {
					soma = soma - itemCalculoResultado.getResultado();	
				}
			} else {
				throw new SGPException("Rubrica base ainda não foi calculada!");
			}
			
		}

		return new RubricaCalculoResultado(soma);
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		return calcular(contexto, rubricaFuncionario.getRubrica());
	}

}