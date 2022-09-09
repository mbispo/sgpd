package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.ProgressaoFuncional;
import br.jus.tjms.sgpd.entity.ReferenciaValor;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;

public class RubricaBaseAtualCalculo implements RubricaCalculo {
	
	private static final long serialVersionUID = 5728902678098644058L;
	
	static RubricaCalculo instance;
	
	public static RubricaCalculo newInstance() {
		return new RubricaBaseAtualCalculo();
	}
	
	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaBaseAtualCalculo(); 
		}
		
		return instance;
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {
		
		/*
		 * base atual depende do cargo do funcionário, que está vinculado às progressões, que está vinculado às referências e valores
		 */
		
		FuncionarioCargo funcionarioCargo = contexto.getFuncionarioCargo();
		
		ProgressaoFuncional progressaoAtual = funcionarioCargo.getProgressaoNaData(contexto.getFolha().getDataFinal());
		
		ReferenciaValor referenciaValor = progressaoAtual.getReferencia().getValorAtual(contexto.getFolha().getDataFinal());
		
		return new RubricaCalculoResultado(referenciaValor.getValor());
		
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		
		/*
		 * base atual depende do cargo do funcionário, que está vinculado às progressões, que está vinculado às referências e valores
		 * 
		 * neste caso, se a rubrica do funcionário indicar um cargo diferente, usamos ele
		 */
		
		FuncionarioCargo funcionarioCargo;
		
		if (rubricaFuncionario.getFuncionarioCargo()!=null) {
			funcionarioCargo = rubricaFuncionario.getFuncionarioCargo();
		} else {
			funcionarioCargo = contexto.getFuncionarioCargo();
		}
		
		ProgressaoFuncional progressaoAtual = funcionarioCargo.getProgressaoNaData(contexto.getFolha().getDataFinal());
		
		ReferenciaValor referenciaValor = progressaoAtual.getReferencia().getValorAtual(contexto.getFolha().getDataFinal());
		
		return new RubricaCalculoResultado(referenciaValor.getValor());

	}

}