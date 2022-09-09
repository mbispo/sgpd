package br.jus.tjms.sgpd.service.folhapagamentoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.jus.tjms.sgpd.entity.PagamentoItem;
import br.jus.tjms.sgpd.service.GenericService;

@Stateless
public class PagamentoItemService extends GenericService<PagamentoItem, Long> implements Serializable {

	private static final long serialVersionUID = 6157749004423681540L;

	public List<PagamentoItem> buscarPorPagamento(Long pagamentoId) {
		TypedQuery<PagamentoItem> query = getEm()
				.createNamedQuery("pagamentoItem.buscarPorPagamento", PagamentoItem.class)
				.setParameter("pagamentoId", pagamentoId);
		return query.getResultList();
	}

}