package br.jus.tjms.sgpd.engine.calculo.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoProcessor;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculoFactory;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.engine.to.ItemCalculoResultado;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.engine.to.TipoAcaoItemCalculo;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.util.CalcUtilz;
import br.jus.tjms.sgpd.util.DateUtilz;

public class RubricaFuncionarioCalculoProcessor implements ItemCalculoProcessor {
	
	private static final long serialVersionUID = -7363477949839248145L;
	
	static RubricaFuncionarioCalculoProcessor instance;
	
	public static RubricaFuncionarioCalculoProcessor instance() {
		if (instance == null) {
			instance = new RubricaFuncionarioCalculoProcessor(); 
		}
		
		return instance;
	}
	

	public static RubricaFuncionarioCalculoProcessor newInstance() {
		return new RubricaFuncionarioCalculoProcessor();
	}

	@Override
	public ItemCalculo processar(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		
		Double resultado = 0.0;

		Rubrica rubrica = itemCalculo.getRubricaFuncionario().getRubrica();
		RubricaFuncionario rubricaFuncionario = itemCalculo.getRubricaFuncionario();	
		
		// se especificado o cargo na rubrica do funcionário, usamos ele para definir a proporcionalidade
		FuncionarioCargo cargo = rubricaFuncionario.getFuncionarioCargo();

		// a proporção em dias de acordo com o cargo do funcionário deve ser feita aqui, usando os períodos de folha e de cargos
		Date dataInicioFolha = contexto.getFolha().getDataInicial();
		Date dataFimFolha = contexto.getFolha().getDataFinal();

		Date dataInicioCargo = dataInicioFolha;
		Date dataFimCargo = dataFimFolha;

		// calcula a proporcionalidade de acordo com o cargo do funcionário definido na rubrica do funcionário, né?
		if (cargo!=null) {
			
			dataInicioCargo = DateUtilz.criaData(cargo.getDataInicio());
			dataFimCargo = cargo.getDataFim()!=null?DateUtilz.criaDataAoFinalDoDia(cargo.getDataFim()):dataFimFolha;
			
			if (dataInicioCargo.before(dataInicioFolha)) {
				dataInicioCargo = dataInicioFolha;
			} else if (dataInicioCargo.after(dataFimFolha)) {
				dataInicioCargo = dataFimFolha;
			}
			
			if (dataFimCargo.after(dataFimFolha)) {
				dataFimCargo = dataFimFolha;
			} else if (dataFimCargo.before(dataInicioFolha)) {
				dataFimCargo = dataInicioFolha;
			}
			
		}
		
		Integer ndiasFolha = DateUtilz.diasEntre(dataInicioFolha, dataFimFolha);
		Integer ndiasCargo = DateUtilz.diasEntre(dataInicioCargo, dataFimCargo);
		
		ndiasCargo = ndiasCargo<=0?0:(ndiasCargo>ndiasFolha?ndiasFolha:ndiasCargo);
		
		if (ndiasCargo>0) {
			
			Double valor = rubricaFuncionario.getValor();
		
			if (valor != null) {
				
				resultado = (valor/ndiasFolha.doubleValue())*ndiasCargo.doubleValue();
				
			} else {
			
				// delegar o cálculo para rubricaCalculatorTabajara!
				
				contexto.setFuncionarioCargo(cargo);
				
				RubricaCalculoResultado res = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica);
				
				resultado = (res.getResultado()/ndiasFolha.doubleValue())*ndiasCargo.doubleValue();
			}
			
		}
		
		itemCalculo.setResultado(new ItemCalculoResultado(CalcUtilz.round(resultado,2)));
		itemCalculo.setAcoesAExecutar(
				new ArrayList<TipoAcaoItemCalculo>(
						Arrays.asList(
								getTipoAcaoDebitoOuCredito(rubrica,resultado)
							)
					)
			);
		
		return itemCalculo;
		
	}

	private TipoAcaoItemCalculo getTipoAcaoDebitoOuCredito(Rubrica rubrica, Double resultado) {
		return BigDecimal.valueOf(resultado).equals(BigDecimal.ZERO)  ? TipoAcaoItemCalculo.NADA : (rubrica.getSinal().equals(Sinal.POSITIVO)?TipoAcaoItemCalculo.LANCAR_CREDITO:TipoAcaoItemCalculo.LANCAR_DEBITO);
	}
	
}