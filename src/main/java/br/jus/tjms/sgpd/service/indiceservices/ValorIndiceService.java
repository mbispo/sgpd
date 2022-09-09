package br.jus.tjms.sgpd.service.indiceservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.ValorIndice;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
public class ValorIndiceService extends GenericService<ValorIndice, Long> implements Serializable {

	private static final long serialVersionUID = -4029840450277645017L;
	
	public List<ValorIndice> listarValoresDoIndice(Long indiceId) {		
		TypedQuery<ValorIndice> query = getEm()
				.createNamedQuery("valorIndice.buscarPorIndiceId", ValorIndice.class)
				.setParameter("indiceId", indiceId);
		return query.getResultList();
	}

}