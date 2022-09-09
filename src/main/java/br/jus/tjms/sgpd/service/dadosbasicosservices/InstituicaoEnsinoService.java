package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.InstituicaoEnsino;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:41
 */
@Stateless
public class InstituicaoEnsinoService extends GenericService<InstituicaoEnsino, Long> implements Serializable {

	private static final long serialVersionUID = 1030032546215052058L;

	public List<InstituicaoEnsino> buscarInstituicoesEnsinoPorNome(String nome) {
		TypedQuery<InstituicaoEnsino> query = getEm().createNamedQuery("instituicaoEnsino.buscarPorNome", InstituicaoEnsino.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}

}