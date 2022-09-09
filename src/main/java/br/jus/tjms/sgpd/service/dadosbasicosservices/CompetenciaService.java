package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Competencia;
import br.jus.tjms.sgpd.entity.PessoaCompetencia;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class CompetenciaService extends GenericService<Competencia, Long> implements Serializable {

	private static final long serialVersionUID = 4969443941959366538L;

	public Competencia buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Competencia> buscarCompetenciasPorPessoa(Long pessoaId) {
		TypedQuery<Competencia> query = getEm()
				.createNamedQuery("pessoaCompetencia.buscarCompetenciasPorPessoa", Competencia.class)
				.setParameter("pessoaId", pessoaId);
		return query.getResultList();
	}

	public PessoaCompetencia salvarPessoaCompetencia(PessoaCompetencia pessoaCompetencia) {
		return getEm().merge(pessoaCompetencia);
	}

}