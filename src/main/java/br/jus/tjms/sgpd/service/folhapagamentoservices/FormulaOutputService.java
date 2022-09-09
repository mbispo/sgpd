package br.jus.tjms.sgpd.service.folhapagamentoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.FormulaOutput;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class FormulaOutputService extends GenericService<FormulaOutput, Long> implements Serializable {

	private static final long serialVersionUID = 8042818197062038484L;

	public List<FormulaOutput> buscarPorFormula(Long formulaId) {
		TypedQuery<FormulaOutput> query = getEm()
				.createNamedQuery("formulaOutput.buscarPorFormula", FormulaOutput.class)
				.setParameter("formulaId", formulaId);
		return query.getResultList();
	}
}