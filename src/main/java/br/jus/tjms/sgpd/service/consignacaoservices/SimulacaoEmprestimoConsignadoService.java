package br.jus.tjms.sgpd.service.consignacaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.SimulacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Stateless
public class SimulacaoEmprestimoConsignadoService extends GenericService<SimulacaoEmprestimoConsignado, Long> implements Serializable {

	private static final long serialVersionUID = -6034433320431759226L;

	public List<SimulacaoEmprestimoConsignado> buscarSimulacoesPorSolicitacaoEmsprestimoConsignado(Long solicitacaoId) {
		TypedQuery<SimulacaoEmprestimoConsignado> query = getEm()
				.createNamedQuery("simulacaoEmprestimoConsignado.buscarSimulacoesPorSolicitacaoEmsprestimoConsignado", SimulacaoEmprestimoConsignado.class)
				.setParameter("solicitacaoId", solicitacaoId);
		return query.getResultList();
	}

}