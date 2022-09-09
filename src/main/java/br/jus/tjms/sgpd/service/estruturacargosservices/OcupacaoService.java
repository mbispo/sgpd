package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Ocupacao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class OcupacaoService extends GenericService<Ocupacao, Long> implements Serializable {

	private static final long serialVersionUID = 363509518667256460L;

	public List<Ocupacao> buscarPorNome(String nome) {
		TypedQuery<Ocupacao> query = getEm().
				createNamedQuery("ocupacao.buscarPorNome", Ocupacao.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}
}