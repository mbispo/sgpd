package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.CargoAreaMovimento;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class CargoAreaMovimentoService extends GenericService<CargoAreaMovimento, Long> implements Serializable {

	private static final long serialVersionUID = 363509518667256460L;

	public List<CargoAreaMovimento> buscarPorCargoArea(Long cargoAreaId) {
		TypedQuery<CargoAreaMovimento> query = getEm()
				.createNamedQuery("cargoAreaMovimento.buscarPorCargoArea", CargoAreaMovimento.class)
				.setParameter("cargoAreaId", cargoAreaId);
		return query.getResultList();
 	}
}