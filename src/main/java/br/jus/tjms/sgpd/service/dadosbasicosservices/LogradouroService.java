package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Logradouro;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class LogradouroService extends GenericService<Logradouro, Long> implements Serializable {

	private static final long serialVersionUID = 6574320290312140598L;

	public List<Logradouro> buscarPorNome(String nome) {
		TypedQuery<Logradouro> query = getEm()
				.createNamedQuery("Logradouro.buscarLogradourosPorNome", Logradouro.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}


}