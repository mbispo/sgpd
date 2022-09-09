package br.jus.tjms.sgpd.engine.calculo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.enumerators.TipoFormula;

public class FormulaGlobalCache implements Serializable {
	
	private static final long serialVersionUID = -7384304075352221021L;
	
	private static FormulaGlobalCache instance;
	
	private List<Formula> formulasGlobais = new ArrayList<>();
	
	private FormulaGlobalCache() {
	}

	public static FormulaGlobalCache instance() {
		if (instance == null) { 
			instance = new FormulaGlobalCache();
		}
		return instance;
	}
	
	public static FormulaGlobalCache cache() {
		return instance();
	}

	public List<Formula> getFormulasGlobaisPorTipo(TipoFormula tipo) {
		List<Formula> retorno = new ArrayList<>();
		for (Formula formula : formulasGlobais) {
			if (formula.getTipo().equals(tipo)) {
				retorno.add(formula);
			}
		}
		return retorno;
	}

	public void setFormulasGlobais(List<Formula> formulasGlobais) {
		this.formulasGlobais = formulasGlobais;
	}
	
	public FormulaGlobalCache adicionar(Formula formula) {
		formulasGlobais.add(formula);
		return this;
	}
	
	public FormulaGlobalCache limpar() {
		formulasGlobais = new ArrayList<>();
		return this;
	}

}