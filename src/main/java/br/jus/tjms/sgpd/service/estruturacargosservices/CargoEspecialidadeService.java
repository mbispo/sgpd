package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.CargoEspecialidade;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class CargoEspecialidadeService extends GenericService<CargoEspecialidade, Long> implements Serializable {

	private static final long serialVersionUID = 363509518667256460L;

	public List<CargoEspecialidade> buscarPorCargo(Long cargoId) {
		TypedQuery<CargoEspecialidade> query = getEm().
				createNamedQuery("cargoEspecialidade.buscarPorCargo", CargoEspecialidade.class)
				.setParameter("cargoId", cargoId);
		return query.getResultList();
 	}
}