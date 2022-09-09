package br.jus.tjms.sgpd.service.indiceservices;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Indice;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
public class IndiceService extends GenericService<Indice, Long> implements Serializable {

	private static final long serialVersionUID = -653211723938136293L;
	
	public List<Indice> listarIndicesAtivos() {
		TypedQuery<Indice> query = getEm().createNamedQuery("indice.buscarAtivos", Indice.class);
		return query.getResultList();
	}

	public List<Indice> buscarPorDescricao(String descricao) {
		TypedQuery<Indice> query = getEm().createNamedQuery("indice.buscarPorDescricao", Indice.class);
		query.setParameter("descricao", "%"+descricao+"%");
		return query.getResultList();
	}

	public List<Indice> buscarPorSigla(String sigla) {
		TypedQuery<Indice> query = getEm().createNamedQuery("indice.buscarPorSigla", Indice.class);
		query.setParameter("sigla", "%"+sigla+"%");
		return query.getResultList();
	}
	
}