package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RubricaParametro;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class RubricaParametroService extends GenericService<RubricaParametro, Long> implements Serializable {

	private static final long serialVersionUID = -4011338882001759681L;

	public List<RubricaParametro> buscarPorRubrica(Long rubricaId) {
		TypedQuery<RubricaParametro> query = getEm()
				.createNamedQuery("rubricaParametro.buscarPorRubrica", RubricaParametro.class)
				.setParameter("rubricaId", rubricaId);
		return query.getResultList();
	}

}