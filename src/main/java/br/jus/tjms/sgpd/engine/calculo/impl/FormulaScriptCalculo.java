package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.FormulaCalculo;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.exception.SGPException;

public class FormulaScriptCalculo implements FormulaCalculo {

	private static final long serialVersionUID = -2494015737508842520L;
	
	static FormulaCalculo instance;

	public static FormulaCalculo newInstance() {
		return new FormulaScriptCalculo();
	}

	public static FormulaCalculo instance() {
		if (instance == null) {
			instance = new FormulaScriptCalculo();
		}

		return instance;
	}

    @Override
	public Object calcular(Contexto contexto, Formula formula) {
		// TODO esse cara aqui é o mestre do universo, ele vai parsear e executar um script misto de SQL+GROOVY+JAVASCRIPT
		// TODO como? não sei ainda...
		// return 0.0;
		
		throw new SGPException("FormulaScriptCalculo.calcular não está pronto ainda!");
	}

}