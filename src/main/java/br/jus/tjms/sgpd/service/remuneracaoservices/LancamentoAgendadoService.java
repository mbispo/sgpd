package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.LancamentoAgendado;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:41
 */
@Stateless
public class LancamentoAgendadoService extends GenericService<LancamentoAgendado, Long> implements Serializable {

	private static final long serialVersionUID = -4422074050744886954L;

	public void pagarLancamento(LancamentoAgendado lancamentoAgendado, Date dataPagamento, Double valorPago) {
		//TODO implementar
	}

	public List<LancamentoAgendado> buscarPorFuncionario(Long funcionarioId) {
		TypedQuery<LancamentoAgendado> query = getEm()
				.createNamedQuery("lancamentoAgendado.buscarPorFuncionario", LancamentoAgendado.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}

}