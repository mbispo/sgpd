package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.DeclaracaoBens;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class DeclaracaoBensService extends GenericService<DeclaracaoBens, Long> implements Serializable {

	private static final long serialVersionUID = -2107148761223142392L;

	public List<DeclaracaoBens> buscarDeclaracoesBensPorPessoa(Long pessoaId) {
		TypedQuery<DeclaracaoBens> query = getEm()
				.createNamedQuery("declaracaoBens.buscarDeclaracoesBensPorPessoa", DeclaracaoBens.class)
				.setParameter("pessoaId", pessoaId);
		return query.getResultList();
	}
}