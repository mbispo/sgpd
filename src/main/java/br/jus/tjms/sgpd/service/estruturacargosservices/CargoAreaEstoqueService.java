package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.CargoAreaEstoque;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class CargoAreaEstoqueService extends GenericService<CargoAreaEstoque, Long> implements Serializable {

	private static final long serialVersionUID = 363509518667256460L;

	public List<CargoAreaEstoque> buscarPorCargoArea(Long cargoAreaId) {
		TypedQuery<CargoAreaEstoque> query = getEm().
				createNamedQuery("cargoAreaEstoque.buscarPorCargoArea", CargoAreaEstoque.class)
				.setParameter("cargoAreaId", cargoAreaId);
		return query.getResultList();
 	}
}