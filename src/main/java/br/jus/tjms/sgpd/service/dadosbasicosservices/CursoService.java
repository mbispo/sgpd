package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Curso;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class CursoService extends GenericService<Curso, Long> implements Serializable {

	private static final long serialVersionUID = 3920955464827682546L;
	
	public List<Curso> buscarCursosPorPessoa(Long pessoaId) {
		TypedQuery<Curso> query = getEm()
				.createNamedQuery("pessoaCurso.buscarCursosPorPessoa", Curso.class)
				.setParameter("pessoaId", pessoaId);
		return query.getResultList();
	}

	public List<Curso> buscarCursosPorInstituicaoDeEnsino(Long instituicaoDeEnsinoId) {
		TypedQuery<Curso> query = getEm()
				.createNamedQuery("curso.buscarCursosPorInstituicaoDeEnsino", Curso.class)
				.setParameter("instituicaoDeEnsinoId", instituicaoDeEnsinoId);
		return query.getResultList();
	}

	public List<Curso> buscarCursosPorNome(String nome) {
		TypedQuery<Curso> query = getEm()
				.createNamedQuery("curso.buscarCursosPorNome", Curso.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}
}