package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Habilidade;
import br.jus.tjms.sgpd.entity.PessoaHabilidade;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class HabilidadeService extends GenericService<Habilidade, Long> implements Serializable {

	private static final long serialVersionUID = 4969443941959366538L;

	public Habilidade buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public PessoaHabilidade buscarPessoaHabilidadePorId(Long id) {
		TypedQuery<PessoaHabilidade> query = getEm()
				.createNamedQuery("pessoaHabilidade.buscarPessoaHabilidadePorId", PessoaHabilidade.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public PessoaHabilidade salvarPessoaHabilidade(PessoaHabilidade pessoaHabilidade) {
		return getEm().merge(pessoaHabilidade);
	}

	public void excluirPessoaHabilidade(PessoaHabilidade pessoaHabilidade) {
		getEm().remove(pessoaHabilidade);
	}

	public List<Habilidade> buscarHabilidadesPorNome(String nome) {
		TypedQuery<Habilidade> query = getEm()
				.createNamedQuery("habilidade.buscarHabilidadesPorNome", Habilidade.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}

	public List<Habilidade> buscarHabilidadesPorPessoa(Long pessoaId) {
		TypedQuery<Habilidade> query = getEm()
				.createNamedQuery("pessoaHabilidade.buscarHabilidadesPorPessoa", Habilidade.class)
				.setParameter("pessoaId", pessoaId);
		return query.getResultList();
	}

}