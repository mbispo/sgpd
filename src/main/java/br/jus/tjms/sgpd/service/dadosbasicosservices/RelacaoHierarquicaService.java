package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.RelacaoHierarquica;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:45
 */
@Stateless
public class RelacaoHierarquicaService extends GenericService<RelacaoHierarquica, Long> implements Serializable {

	private static final long serialVersionUID = 2906061130335477179L;

	public List<RelacaoHierarquica> buscarRelacoesHierarquicasPorPessoa(Long idPessoa) {
		TypedQuery<RelacaoHierarquica> query = getEm()
				.createNamedQuery("relacaoHierarquica.buscarRelacoesHierarquicasPorPessoa", RelacaoHierarquica.class)
				.setParameter("idPessoa", idPessoa);
		return query.getResultList();
	}
}
