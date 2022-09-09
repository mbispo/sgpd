package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.FormulaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.exception.SGPException;

public class FormulaProcedureCalculo implements FormulaCalculo {

	private static final long serialVersionUID = -8105735268901137415L;
	
	static FormulaCalculo instance;

	public static FormulaCalculo newInstance() {
		return new FormulaProcedureCalculo();
	}

	public static FormulaCalculo instance() {
		if (instance == null) {
			instance = new FormulaProcedureCalculo();
		}

		return instance;
	}

    @Override
	public Object calcular(Contexto contexto, Formula formula) {
		throw new SGPException("FormulaProcedureCalculo.calcular não está pronto ainda!");
	}

}