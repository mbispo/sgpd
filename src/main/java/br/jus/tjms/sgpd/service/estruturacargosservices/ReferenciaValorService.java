package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.ReferenciaValor;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class ReferenciaValorService extends GenericService<ReferenciaValor, Long> implements Serializable {

	private static final long serialVersionUID = -3800688508974560314L;
	
	public List<ReferenciaValor> buscarPorCargo(Long cargoId) {
		TypedQuery<ReferenciaValor> query = getEm().
				createNamedQuery("referenciaValor.buscarPorCargo", ReferenciaValor.class)
				.setParameter("cargoId", cargoId);
		return query.getResultList();
 	}
}