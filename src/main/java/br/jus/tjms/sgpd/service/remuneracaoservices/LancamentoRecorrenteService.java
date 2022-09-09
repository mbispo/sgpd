package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.LancamentoRecorrente;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:41
 */
@Stateless
public class LancamentoRecorrenteService extends GenericService<LancamentoRecorrente, Long> implements Serializable {

	private static final long serialVersionUID = -2974682138991325976L;

	public void registrarHistoricoPagamento(LancamentoRecorrente lancamentoRecorrente) {
		//TODO implementar
	}

	public List<LancamentoRecorrente> buscarPorFuncionario(Long funcionarioId) {
		TypedQuery<LancamentoRecorrente> query = getEm()
				.createNamedQuery("lancamentoRecorrente.buscarPorFuncionario", LancamentoRecorrente.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}

}