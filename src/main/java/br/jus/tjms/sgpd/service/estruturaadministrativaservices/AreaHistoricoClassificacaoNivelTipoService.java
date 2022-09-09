package br.jus.tjms.sgpd.service.estruturaadministrativaservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.AreaHistoricoClassificacaoNivelTipo;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:34
 */
@Stateless
public class AreaHistoricoClassificacaoNivelTipoService extends GenericService<AreaHistoricoClassificacaoNivelTipo, Long> implements Serializable {

	private static final long serialVersionUID = 8048325785116407357L;

	public List<AreaHistoricoClassificacaoNivelTipo> buscarPorArea(Long areaId) {
		TypedQuery<AreaHistoricoClassificacaoNivelTipo> query = getEm()
				.createNamedQuery("areaHistoricoClassificacaoNivelTipo.buscarPorArea", AreaHistoricoClassificacaoNivelTipo.class)
				.setParameter("areaId", areaId);
		return query.getResultList();
	}

}