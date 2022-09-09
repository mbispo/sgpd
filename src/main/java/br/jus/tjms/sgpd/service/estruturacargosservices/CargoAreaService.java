package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.CargoArea;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class CargoAreaService extends GenericService<CargoArea, Long> implements Serializable {

	private static final long serialVersionUID = 8626046530162252103L;

	public List<CargoArea> buscarPorCargo(Long id) {
		TypedQuery<CargoArea> query = getEm().
				createNamedQuery("cargoArea.buscarPorCargo", CargoArea.class);
		return query.getResultList();
 	}
}