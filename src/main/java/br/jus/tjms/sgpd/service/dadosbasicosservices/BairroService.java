package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Bairro;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class BairroService extends GenericService<Bairro, Long> implements Serializable {

	private static final long serialVersionUID = 6574320290312140598L;

	public List<Bairro> buscarPorNome(String nome) {
		TypedQuery<Bairro> query = getEm()
				.createNamedQuery("Bairro.buscarBairrosPorNome", Bairro.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}


}