package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RubricaBase;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class RubricaBaseService extends GenericService<RubricaBase, Long> implements Serializable {

	private static final long serialVersionUID = 1309005429763426182L;

	public List<RubricaBase> buscarPorRubrica(Long rubricaId) {
		TypedQuery<RubricaBase> query = getEm()
				.createNamedQuery("rubricaBase.buscarRubricaBasePorRubrica", RubricaBase.class)
				.setParameter("rubricaId", rubricaId);
		return query.getResultList();
	}

}