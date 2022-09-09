package br.jus.tjms.sgpd.service.consignacaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.SolicitacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:49
 */
@Stateless
public class SolicitacaoEmprestimoConsignadoService extends GenericService<SolicitacaoEmprestimoConsignado, Long> implements Serializable {

	private static final long serialVersionUID = 7140381157008060726L;

	public List<SolicitacaoEmprestimoConsignado> buscarPorFuncionario(Long funcionarioId) {
		TypedQuery<SolicitacaoEmprestimoConsignado> query = getEm()
				.createNamedQuery("solicitacaoEmprestimoConsignado.buscarSolicitacaoesPorFuncionario", SolicitacaoEmprestimoConsignado.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
				
	}

}