package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaCargo;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Stateless
public class RubricaCargoService extends GenericService<RubricaCargo, Long> implements Serializable {
	
	private static final long serialVersionUID = -3232431365752047354L;

	public List<RubricaCargo> obterRubricasDoCargo(Long idCargo) {
		//TODO implementar
		return null;
	}
	
	public Long vincularRubricaAoCargo(Long idRubrica, Long idCargo) {
		//TODO implementar
		return null;
	}
	
	public void desvincularRubricaDoCargo(Long idRubricaCargo) {
		//TODO implementar
	}

	public List<Rubrica> buscarRubricasPorCargo(Long cargoId) {
		TypedQuery<Rubrica> query = getEm()
				.createNamedQuery("rubricaCargo.buscarRubricasPorCargo", Rubrica.class)
				.setParameter("cargoId", cargoId);
		return query.getResultList();
	}

}