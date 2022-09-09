package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Localidade;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class LocalidadeService extends GenericService<Localidade, Long> implements Serializable {

	private static final long serialVersionUID = 6574320290312140598L;

	public List<Localidade> buscarPorNome(String nome) {
		TypedQuery<Localidade> query = getEm()
				.createNamedQuery("localidade.buscarLocalidadesPorNome", Localidade.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}

	public List<Localidade> buscarPorArea(Long areaId) {
		TypedQuery<Localidade> query = getEm()
				.createNamedQuery("localidade.buscarLocalidadesPorArea", Localidade.class)
				.setParameter("areaId", areaId);
		return query.getResultList();
	}

}