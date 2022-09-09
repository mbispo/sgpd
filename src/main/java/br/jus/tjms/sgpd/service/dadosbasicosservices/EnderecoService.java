package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Endereco;
import br.jus.tjms.sgpd.entity.PessoaEndereco;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class EnderecoService extends GenericService<Endereco, Long> implements Serializable {

	private static final long serialVersionUID = -2727294892886067567L;

	public List<Endereco> buscarEnderecosPorPessoa(Long pessoaId) {
		TypedQuery<Endereco> query = getEm()
				.createNamedQuery("pessoaEndereco.buscarEnderecosPorPessoa", Endereco.class)
				.setParameter("pessoaId", pessoaId);
		return query.getResultList();
	}

	public PessoaEndereco salvarPessoaEndereco(PessoaEndereco pessoaEndereco) {
		return getEm().merge(pessoaEndereco);
	}

	public List<Endereco> buscarEnderecoPorDescricao(String descricao) {
		TypedQuery<Endereco> query = getEm()
				.createNamedQuery("endereco.buscarEnderecosPorDescricao", Endereco.class)
				.setParameter("descricao", descricao);
		return query.getResultList();
	}
	
	public PessoaEndereco buscarPessoaEnderecoPorId(Long id) {
		TypedQuery<PessoaEndereco> query = getEm()
				.createNamedQuery("pessoaEndereco.buscarPessoaEnderecoPorId", PessoaEndereco.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}
}