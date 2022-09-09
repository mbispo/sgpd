package br.jus.tjms.sgpd.service.estruturacargosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.Especialidade;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Stateless
public class EspecialidadeService extends GenericService<Especialidade, Long> implements Serializable {

	private static final long serialVersionUID = 4294043847086042106L;

	public List<Especialidade> buscarPorNome(String nome) {
		TypedQuery<Especialidade> query = getEm()
				.createNamedQuery("especialidade.buscarEspecialidadesPorNome", Especialidade.class)
				.setParameter("nome", nome);
		return query.getResultList();
	}
}