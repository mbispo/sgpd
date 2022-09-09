package br.jus.tjms.sgpd.engine.calculo.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculoFactory;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.engine.to.ItemCalculoResultado;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.engine.to.TipoAcaoItemCalculo;
import br.jus.tjms.sgpd.entity.ContratoPlanoSaude;
import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.entity.PlanoSaude;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaPlanoSaude;
import br.jus.tjms.sgpd.util.CalcUtilz;

public class PlanoSaudeResponsavelFinanceiroCalculoProcessor implements ItemCalculoProcessor {
	
	private static final long serialVersionUID = 4972207127956512693L;
	
	static PlanoSaudeResponsavelFinanceiroCalculoProcessor instance;
	
	public static PlanoSaudeResponsavelFinanceiroCalculoProcessor instance() {
		if (instance == null) {
			instance = new PlanoSaudeResponsavelFinanceiroCalculoProcessor(); 
		}
		
		return instance;
	}
	

	public static PlanoSaudeResponsavelFinanceiroCalculoProcessor newInstance() {
		return new PlanoSaudeResponsavelFinanceiroCalculoProcessor();
	}

	@Override
	public ItemCalculo processar(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		
		Double resultado = 0.0;
		
		ContratoPlanoSaude contratoPlanoSaude = itemCalculo.getContratoPlanoSaude();
		PlanoSaude planoSaude = contratoPlanoSaude.getPlanoSaude();
		List<RubricaPlanoSaude> rubricasPlanoSaude = planoSaude.getRubricas();
		
		for (RubricaPlanoSaude rubricaPlanoSaude : rubricasPlanoSaude) {

			// ver as rubricas do plano de saúde e o percentual aplicado de cada uma
			
			Rubrica rubrica = rubricaPlanoSaude.getRubrica();
			
			Double percentual = rubricaPlanoSaude.getPercentual();
			
			Double valor = rubrica.getValor();
		
			if (valor != null) {
				
				resultado = resultado + (valor*(percentual/100.0));
				
			} else {				
				// delegar o cálculo para rubricaCalculatorTabajara!
				
				RubricaCalculoResultado res = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica);

				resultado = resultado + (res.getResultado()*(percentual/100.0));
			}
			
		}
		
		itemCalculo.setResultado(new ItemCalculoResultado(CalcUtilz.round(resultado,2)));
		itemCalculo.setAcoesAExecutar(
				new ArrayList<>(
						Collections.singletonList(
								getTipoAcaoDebitoOuCredito(resultado)
							)
					)
			);
		
		return itemCalculo;
		
	}

	private TipoAcaoItemCalculo getTipoAcaoDebitoOuCredito(Double resultado) {
		return BigDecimal.valueOf(resultado).equals(BigDecimal.ZERO)  ? TipoAcaoItemCalculo.NADA : TipoAcaoItemCalculo.LANCAR_DEBITO;
	}

}