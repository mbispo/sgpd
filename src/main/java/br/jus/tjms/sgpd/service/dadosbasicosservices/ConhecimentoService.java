package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Conhecimento;
import br.jus.tjms.sgpd.entity.PessoaConhecimento;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class ConhecimentoService extends GenericService<Conhecimento, Long> implements Serializable {

	private static final long serialVersionUID = 4969443941959366538L;

	public Conhecimento buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public PessoaConhecimento buscarPessoaConhecimentoPorId(Long id) {
		TypedQuery<PessoaConhecimento> query = getEm()
				.createNamedQuery("pessoaConhecimento.buscarPessoaConhecimentoPorId", PessoaConhecimento.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public List<Conhecimento> buscarConhecimentosPorPessoa(Long pessoaId) {
		TypedQuery<Conhecimento> query = getEm()
				.createNamedQuery("pessoaConhecimento.buscarConhecimentosPorPessoa", Conhecimento.class)
				.setParameter("pessoaId", pessoaId);
		return query.getResultList();
	}

	public PessoaConhecimento salvarPessoaConhecimento(PessoaConhecimento pessoaConhecimento) {
		return getEm().merge(pessoaConhecimento);
	}

	public void excluirPessoaConhecimento(PessoaConhecimento pessoaConhecimento) {
		getEm().remove(pessoaConhecimento);
	}

	public List<Conhecimento> buscarConhecimentosPorNome(String nome) {
		TypedQuery<Conhecimento> query = getEm()
				.createNamedQuery("conhecimento.buscarConhecimentosPorNome", Conhecimento.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}

}