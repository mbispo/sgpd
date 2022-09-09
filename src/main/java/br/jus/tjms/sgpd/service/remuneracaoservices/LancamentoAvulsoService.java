package br.jus.tjms.sgpd.service.remuneracaoservices;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.LancamentoAvulso;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:41
 */
@Stateless
public class LancamentoAvulsoService extends GenericService<LancamentoAvulso, Long> implements Serializable {

	private static final long serialVersionUID = -7671217841988745763L;

	public void pagarLancamento(LancamentoAvulso lancamentoAvulso, Date dataPagamento, Double valorPago) {
		
		lancamentoAvulso.setPago(true);
		lancamentoAvulso.setValorPago(valorPago);
		lancamentoAvulso.setPagamento(dataPagamento);
		
		if (getEm() != null) // evita erro no teste...
			salvar(lancamentoAvulso);
		
	}

	public List<LancamentoAvulso> buscarPorFuncionario(Long funcionarioId) {
		TypedQuery<LancamentoAvulso> query = getEm()
				.createNamedQuery("lancamentoAvulso.buscarPorFuncionario", LancamentoAvulso.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}
	
}