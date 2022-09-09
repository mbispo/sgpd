package br.jus.tjms.sgpd.engine.calculo.impl;

import java.util.Date;

import br.jus.tjms.sgpd.engine.calculo.RubricaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.RubricaCalculoResultado;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.ProgressaoFuncional;
import br.jus.tjms.sgpd.entity.ReferenciaValor;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;

public class RubricaBaseInicialCalculo implements RubricaCalculo  {
	
	private static final long serialVersionUID = 4443818465326134547L;
	
	static RubricaCalculo instance;
	
	public static RubricaCalculo newInstance() {
		return new RubricaBaseInicialCalculo();
	}
	
	public static RubricaCalculo instance() {
		if (instance == null) {
			instance = new RubricaBaseInicialCalculo(); 
		}
		
		return instance;
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, Rubrica rubrica) {
		
		/*
		 * base inicial depende do cargo do funcionário, que está vinculado às progressões, que está vinculado às referências e valores
		 */
		
		FuncionarioCargo funcionarioCargo = contexto.getFuncionarioCargo();
		
		ProgressaoFuncional progressaoInicial = funcionarioCargo.getProgressaoInicial();
		
		ReferenciaValor referenciaValor = progressaoInicial.getReferencia().getValorAtual(new Date());
		
		return new RubricaCalculoResultado(referenciaValor.getValor());
		
	}

	@Override
	public RubricaCalculoResultado calcular(Contexto contexto, RubricaFuncionario rubricaFuncionario) {
		
		/*
		 * base inicial depende do cargo do funcionário, que está vinculado às progressões, que está vinculado às referências e valores
		 * 
		 * neste caso, se a rubrica do funcionário indicar um cargo diferente, usamos ele
		 */
		
		FuncionarioCargo funcionarioCargo;
		
		if (rubricaFuncionario.getFuncionarioCargo()!=null) {
			funcionarioCargo = rubricaFuncionario.getFuncionarioCargo();
		} else {
			funcionarioCargo = contexto.getFuncionarioCargo();
		}
		
		ProgressaoFuncional progressaoInicial = funcionarioCargo.getProgressaoInicial();
		
		ReferenciaValor referenciaValor = progressaoInicial.getReferencia().getValorAtual(new Date());
		
		return new RubricaCalculoResultado(referenciaValor.getValor());

	}

}