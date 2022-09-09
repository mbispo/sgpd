package br.jus.tjms.sgpd.service.folhapagamentoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.FormulaInput;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class FormulaInputService extends GenericService<FormulaInput, Long> implements Serializable {
	
	private static final long serialVersionUID = -6787147616770145654L;

	public List<FormulaInput> buscarPorFormula(Long formulaId) {
		TypedQuery<FormulaInput> query = getEm()
				.createNamedQuery("formulaInput.buscarPorFormula", FormulaInput.class)
				.setParameter("formulaId", formulaId);
		return query.getResultList();
	}

}