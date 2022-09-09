package br.jus.tjms.sgpd.engine.calculo.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculoFactory;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.engine.to.ItemCalculoResultado;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.engine.to.TipoAcaoItemCalculo;
import br.jus.tjms.sgpd.entity.LancamentoAvulso;
import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.util.CalcUtilz;

public class LancamentoAvulsoCalculoProcessor implements ItemCalculoProcessor {

	private static final long serialVersionUID = 8031602782755102391L;
	
	static LancamentoAvulsoCalculoProcessor instance;
	
	public static LancamentoAvulsoCalculoProcessor instance() {
		if (instance == null) {
			instance = new LancamentoAvulsoCalculoProcessor(); 
		}
		
		return instance;
	}

	public static LancamentoAvulsoCalculoProcessor newInstance() {
		return new LancamentoAvulsoCalculoProcessor();
	}

	@Override
	public ItemCalculo processar(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		
		Double resultado;

		Rubrica rubrica = itemCalculo.getRubrica();
		
		LancamentoAvulso lancamento = itemCalculo.getLancamentoAvulso();
		
		Sinal sinal = lancamento.getSinal();
		
		if (rubrica != null) {
			// cálculo baseado em rubrica
			
			sinal = rubrica.getSinal();
			
			// delegar o cálculo para rubricaCalculatorTabajara!
			
			RubricaCalculoResultado res = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica);

			// valor não definido na rubrica, retorna valor do lançamento avulso
			resultado = res.getResultado()!=null?res.getResultado():lancamento.getValor();
			
		} else {
			// valorado
			resultado = lancamento.getValor();
		}

		itemCalculo.setEntidadeOrigem(LancamentoAvulso.class.getName());
		itemCalculo.setIdOrigem(lancamento.getId());
		
		itemCalculo.setResultado(new ItemCalculoResultado(CalcUtilz.round(resultado,2)));
		itemCalculo.setAcoesAExecutar(
				new ArrayList<TipoAcaoItemCalculo>(
						Arrays.asList(
								TipoAcaoItemCalculo.PAGAR_LANCAMENTO_AVULSO,
								getTipoAcaoDebitoOuCredito(resultado, sinal)
							)
					)
			);
		
		return itemCalculo;
		
	}

	private TipoAcaoItemCalculo getTipoAcaoDebitoOuCredito(Double resultado, Sinal sinal) {
		return BigDecimal.valueOf(resultado).equals(BigDecimal.ZERO) ? TipoAcaoItemCalculo.NADA : sinal.equals(Sinal.POSITIVO) ? TipoAcaoItemCalculo.LANCAR_CREDITO : TipoAcaoItemCalculo.LANCAR_DEBITO;
	}

}