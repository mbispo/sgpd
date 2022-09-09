package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RubricaCompoeBaseCalculo;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class RubricaCompoeBaseCalculoService extends GenericService<RubricaCompoeBaseCalculo, Long> implements Serializable {
	
	private static final long serialVersionUID = 1750027281086603018L;

	public List<RubricaCompoeBaseCalculo> buscarPorRubrica(Long rubricaId) {
		TypedQuery<RubricaCompoeBaseCalculo> query = getEm()
				.createNamedQuery("rubricaCompoeBaseCalculoService.buscarRubricaCompoeBaseCalculoPorRubrica", RubricaCompoeBaseCalculo.class)
				.setParameter("rubricaId", rubricaId);
		return query.getResultList();
	}

}