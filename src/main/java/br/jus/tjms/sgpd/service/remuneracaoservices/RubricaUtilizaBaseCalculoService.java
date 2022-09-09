package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RubricaUtilizaBaseCalculo;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class RubricaUtilizaBaseCalculoService extends GenericService<RubricaUtilizaBaseCalculo, Long> implements Serializable {

	private static final long serialVersionUID = 1309005429763426182L;

	public List<RubricaUtilizaBaseCalculo> buscarPorRubrica(Long rubricaId) {
		TypedQuery<RubricaUtilizaBaseCalculo> query = getEm()
				.createNamedQuery("rubricaUtilizaBaseCalculo.buscarRubricaUtilizaBaseCalculoPorRubrica", RubricaUtilizaBaseCalculo.class)
				.setParameter("rubricaId", rubricaId);
		return query.getResultList();
	}

}