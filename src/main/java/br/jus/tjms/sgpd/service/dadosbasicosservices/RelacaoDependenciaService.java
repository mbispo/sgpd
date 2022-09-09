package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RelacaoDependencia;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:45
 */
@Stateless
public class RelacaoDependenciaService extends GenericService<RelacaoDependencia, Long> implements Serializable {

	private static final long serialVersionUID = -4540063119743298317L;
	
	public List<RelacaoDependencia> buscarRelacoesDeDependenciaPorPessoa(Long idPessoa) {
		TypedQuery<RelacaoDependencia> query = getEm()
				.createNamedQuery("relacaoDependencia.buscarRelacoesDeDependenciaPorPessoa", RelacaoDependencia.class)
				.setParameter("idPessoa", idPessoa);
		return query.getResultList();
	}
}