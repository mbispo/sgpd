package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Cidade;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class CidadeService extends GenericService<Cidade, Long> implements Serializable {

	private static final long serialVersionUID = 6574320290312140598L;

	public List<Cidade> buscarPorNome(String nome) {
		TypedQuery<Cidade> query = getEm()
				.createNamedQuery("cidade.buscarCidadesPorNome", Cidade.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}

	public List<Cidade> buscarPorEstado(Long id) {
		TypedQuery<Cidade> query = getEm()
				.createNamedQuery("cidade.buscarCidadesPorEstado", Cidade.class)
				.setParameter("id", id);
		return query.getResultList();
	}

}