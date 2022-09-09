package br.jus.tjms.sgpd.service.consignacaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.AprovacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Stateless
public class AprovacaoEmprestimoConsignadoService extends GenericService<AprovacaoEmprestimoConsignado, Long> implements Serializable {

	private static final long serialVersionUID = 5748535429220236086L;

	public List<AprovacaoEmprestimoConsignado> buscarPorFuncionario(Long funcionarioId) {
		TypedQuery<AprovacaoEmprestimoConsignado> query = getEm()
				.createNamedQuery("aprovacaoEmprestimoConsignado.buscarAprovacoesPorFuncionario", AprovacaoEmprestimoConsignado.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}

}