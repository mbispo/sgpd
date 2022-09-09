package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.FormacaoAcademica;
import br.jus.tjms.sgpd.entity.PessoaFormacao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:40
 */
@Stateless
public class FormacaoAcademicaService extends GenericService<FormacaoAcademica, Long> implements Serializable {

	private static final long serialVersionUID = -7984886621520046893L;

	public List<FormacaoAcademica> buscarFormacoesAcademicasPorPessoa(Long pessoaId) {
		TypedQuery<FormacaoAcademica> query = getEm()
				.createNamedQuery("pessoaFormacao.buscarFormacoesAcademicasPorPessoa", FormacaoAcademica.class)
				.setParameter("pessoaId", pessoaId);
		return query.getResultList();
	}
	
	public List<FormacaoAcademica> buscarFormacoesAcademicasPorInstituicaoDeEnsino(Long instituicaoEnsinoId) {
		TypedQuery<FormacaoAcademica> query = getEm()
				.createNamedQuery("formacaoAcademica.buscarFormacoesAcademicasPorInstituicaoDeEnsino", FormacaoAcademica.class)
				.setParameter("instituicaoEnsinoId", instituicaoEnsinoId);
		return query.getResultList();
	}

	public List<FormacaoAcademica> buscarFormacoesAcademicasPorDescricao(String descricao) {
		TypedQuery<FormacaoAcademica> query = getEm()
				.createNamedQuery("formacaoAcademica.buscarFormacoesAcademicasPorDescricao", FormacaoAcademica.class)
				.setParameter("descricao", descricao);
		return query.getResultList();
	}

	public PessoaFormacao salvarPessoaFormacao(PessoaFormacao pessoaFormacao) {
		return getEm().merge(pessoaFormacao);
	}
}