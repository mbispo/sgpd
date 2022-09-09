package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Contato;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class ContatoService extends GenericService<Contato, Long> implements Serializable {

	private static final long serialVersionUID = 875185612563981941L;

	public List<Contato> buscarContatosPorPessoa(Long idPessoa) {
		TypedQuery<Contato> query = getEm()
				.createNamedQuery("contato.buscarContatosPorPessoa", Contato.class)
				.setParameter("idPessoa", idPessoa);
		return query.getResultList();
	}
}