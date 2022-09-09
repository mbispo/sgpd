package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.PreRequisitoHabilidade;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class PreRequisitoHabilidadeService extends GenericService<PreRequisitoHabilidade, Long> implements Serializable {

	private static final long serialVersionUID = 363509518667256460L;

	public List<PreRequisitoHabilidade> buscarPorCargo(Long cargoId) {
		TypedQuery<PreRequisitoHabilidade> query = getEm().
				createNamedQuery("preRequisitoHabilidade.buscarPorCargo", PreRequisitoHabilidade.class)
				.setParameter("cargoId", cargoId);
		return query.getResultList();
 	}
}