package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Atitude;
import br.jus.tjms.sgpd.entity.PessoaAtitude;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:38
 */
@Stateless
public class AtitudeService extends GenericService<Atitude, Long> implements Serializable {

	private static final long serialVersionUID = -5537600226635389927L;

	public List<Atitude> buscarPorPessoa(Long pessoaId) {
		TypedQuery<Atitude> query = getEm()
				.createNamedQuery("pessoaAtitude.buscarAtitudesPorPessoa", Atitude.class)
				.setParameter("pessoaId", pessoaId);
		return query.getResultList();
	}
	
	public List<Atitude> buscarPorNome(String nome) {
		TypedQuery<Atitude> query = getEm()
				.createNamedQuery("pessoaAtitude.buscarAtitudesPorNome", Atitude.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}

	public PessoaAtitude salvarPessoaAtitude(PessoaAtitude pessoaAtitude) {
		return getEm().merge(pessoaAtitude);
	}

	public PessoaAtitude buscarPessoaAtitudePorId(Long id) {
		TypedQuery<PessoaAtitude> query = getEm()
				.createNamedQuery("pessoaAtitude.buscarPessoaAtitudePorId", PessoaAtitude.class)
				.setParameter("id",id);
		return query.getSingleResult();
	}

	public void excluirPessoaAtitude(PessoaAtitude pessoaAtitude) {
		getEm().remove(pessoaAtitude);
	}

}