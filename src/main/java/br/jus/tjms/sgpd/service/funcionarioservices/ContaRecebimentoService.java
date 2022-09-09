package br.jus.tjms.sgpd.service.funcionarioservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.ContaRecebimento;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class ContaRecebimentoService extends GenericService<ContaRecebimento, Long> implements Serializable {

	private static final long serialVersionUID = -7325999867822413212L;

	public List<ContaRecebimento> buscarContasRecebimentoPorPessoa(Long idPessoa) {
		TypedQuery<ContaRecebimento> query = getEm()
				.createNamedQuery("contaRecebimento.buscarContasRecebimentoPorPessoa", ContaRecebimento.class)
				.setParameter("idPessoa", idPessoa);
		return query.getResultList();
	}
}