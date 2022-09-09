package br.jus.tjms.sgpd.service.estruturaadministrativaservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.TurnoArea;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class TurnoAreaService extends GenericService<TurnoArea, Long> implements Serializable {

	private static final long serialVersionUID = -8470574482526728997L;

	public List<TurnoArea> buscarPorArea(Long areaId) {
		TypedQuery<TurnoArea> query = getEm()
				.createNamedQuery("areaTurno.buscarPorArea", TurnoArea.class)
				.setParameter("areaId", areaId);
		return query.getResultList();
	}
}