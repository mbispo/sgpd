package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.ArrayList;
import java.util.Arrays;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculoFactory;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.engine.to.ItemCalculoResultado;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.engine.to.TipoAcaoItemCalculo;
import br.jus.tjms.sgpd.entity.EmprestimoConsignado;
import br.jus.tjms.sgpd.entity.ParcelaEmprestimoConsignado;
import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.util.CalcUtilz;

public class ParcelaEmprestimoConsignadoCalculoProcessor implements ItemCalculoProcessor {
	
	private static final long serialVersionUID = -341353304250799261L;
	
	static ParcelaEmprestimoConsignadoCalculoProcessor instance;
	
	public static ParcelaEmprestimoConsignadoCalculoProcessor instance() {
		if (instance == null) {
			instance = new ParcelaEmprestimoConsignadoCalculoProcessor(); 
		}
		
		return instance;
	}
	

	public static ParcelaEmprestimoConsignadoCalculoProcessor newInstance() {
		return new ParcelaEmprestimoConsignadoCalculoProcessor();
	}

	@Override
	public ItemCalculo processar(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		
		Double resultado = 0.0;
		
		ParcelaEmprestimoConsignado parcelaEmprestimoConsignado = itemCalculo.getParcelaEmprestimoConsignado();
		EmprestimoConsignado emprestimoConsignado = parcelaEmprestimoConsignado.getEmprestimoConsignado();
		
		Rubrica rubrica = emprestimoConsignado.getRubrica();
		
		TipoAcaoItemCalculo tipoAcaoItemCalculo = TipoAcaoItemCalculo.LANCAR_DEBITO;

		if (rubrica != null) {
			// cálculo baseado em rubrica
			
			if (rubrica.getSinal().equals(Sinal.POSITIVO))
				tipoAcaoItemCalculo = TipoAcaoItemCalculo.LANCAR_CREDITO;
			
			Double valor = rubrica.getValor();
		
			if (valor != null) {
				
				resultado = valor;
				
			} else {				
				// delegar o cálculo para rubricaCalculatorTabajara!
				
				RubricaCalculoResultado res = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica);
				
				resultado = res.getResultado();
			}
			
		} else {
			
			resultado = parcelaEmprestimoConsignado.getValor();
			
		}
		
		itemCalculo.setResultado(new ItemCalculoResultado(CalcUtilz.round(resultado,2)));
		itemCalculo.setAcoesAExecutar(
				new ArrayList<TipoAcaoItemCalculo>(
						Arrays.asList(
								TipoAcaoItemCalculo.PAGAR_PARCELA_EMPRESTIMO_CONSIGNADO,
								tipoAcaoItemCalculo
							)
					)
			);
		
		return itemCalculo;
		
	}
	
}