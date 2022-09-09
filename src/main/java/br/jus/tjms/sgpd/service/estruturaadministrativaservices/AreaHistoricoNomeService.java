package br.jus.tjms.sgpd.service.estruturaadministrativaservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.AreaHistoricoNome;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:34
 */
@Stateless
public class AreaHistoricoNomeService extends GenericService<AreaHistoricoNome, Long> implements Serializable {

	private static final long serialVersionUID = 8048325785116407357L;

	public List<AreaHistoricoNome> buscarPorArea(Long areaId) {
		TypedQuery<AreaHistoricoNome> query = getEm()
				.createNamedQuery("areaHistoricoNome.buscarPorArea", AreaHistoricoNome.class)
				.setParameter("areaId", areaId);
		return query.getResultList();
	}

}