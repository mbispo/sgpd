package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.PreRequisitoAtitude;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class PreRequisitoAtitudeService extends GenericService<PreRequisitoAtitude, Long> implements Serializable {

	private static final long serialVersionUID = 363509518667256460L;

	public List<PreRequisitoAtitude> buscarPorCargo(Long cargoId) {
		TypedQuery<PreRequisitoAtitude> query = getEm().
				createNamedQuery("preRequisitoAtitude.buscarPorCargo", PreRequisitoAtitude.class)
				.setParameter("cargoId", cargoId);
		return query.getResultList();
 	}
}