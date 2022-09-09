package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.PreRequisitoConhecimento;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class PreRequisitoConhecimentoService extends GenericService<PreRequisitoConhecimento, Long> implements Serializable {

	private static final long serialVersionUID = -4873982194575873431L;

	public List<PreRequisitoConhecimento> buscarPorCargo(Long cargoId) {
		TypedQuery<PreRequisitoConhecimento> query = getEm().
				createNamedQuery("preRequisitoConhecimento.buscarPorCargo", PreRequisitoConhecimento.class)
				.setParameter("cargoId", cargoId);
		return query.getResultList();
 	}
}