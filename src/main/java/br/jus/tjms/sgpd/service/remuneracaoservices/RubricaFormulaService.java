package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.entity.RubricaFormula;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Stateless
public class RubricaFormulaService extends GenericService<RubricaFormula, Long> implements Serializable {

	private static final long serialVersionUID = 1309005429763426182L;

	public RubricaFormula buscarRubricaFormulaPorRubricaEFormula(Long rubricaId, Long formulaId) {
		TypedQuery<RubricaFormula> query = getEm()
				.createNamedQuery("rubricaFormula.buscarRubricaFormulaPorRubricaEFormula", RubricaFormula.class)
				.setParameter("rubricaId", rubricaId)
				.setParameter("formulaId", formulaId);
		return query.getSingleResult();
	}
	
	public List<Formula> buscarFormulasPorRubrica(Long rubricaId) {
		TypedQuery<Formula> query = getEm()
				.createNamedQuery("rubricaFormula.buscarFormulasPorRubrica", Formula.class)
				.setParameter("rubricaId", rubricaId);
		return query.getResultList();
	}

}