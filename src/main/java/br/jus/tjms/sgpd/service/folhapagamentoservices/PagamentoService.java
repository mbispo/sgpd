package br.jus.tjms.sgpd.service.folhapagamentoservices;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;

import br.jus.tjms.sgpd.entity.Pagamento;
import br.jus.tjms.sgpd.entity.PagamentoItem;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.enumerators.TipoPagamentoItem;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:42
 */
@Stateless
public class PagamentoService extends GenericService<Pagamento, Long> implements Serializable {

	private static final long serialVersionUID = 4337411940724704912L;
	
	@Override
	public Pagamento buscarPorId(Long id) {
		Pagamento p = super.buscarPorId(id);
		Hibernate.initialize(p.getItens());
		return p;
	}

	public void lancarItemDebito(Pagamento pagamento, Rubrica rubrica, Double quantidade, String descricao, String mensagem, Double valor, String entidadeOrigem, Long idOrigem) {
		pagamento.getItens().add(new PagamentoItem(pagamento, TipoPagamentoItem.DEBITO, rubrica, quantidade, descricao, mensagem, valor, entidadeOrigem, idOrigem));
		pagamento.totalizar();
	}

	public void lancarItemCredito(Pagamento pagamento, Rubrica rubrica, Double quantidade, String descricao, String mensagem, Double valor, String entidadeOrigem, Long idOrigem) {
		pagamento.getItens().add(new PagamentoItem(pagamento, TipoPagamentoItem.CREDITO, rubrica, quantidade, descricao, mensagem, valor, entidadeOrigem, idOrigem));
		pagamento.totalizar();
	}

	public void lancarItemSubTotalCredito(Pagamento pagamento, Double quantidade, String descricao, String mensagem,
			Double valor) {
		//TODO implementar
	}

	public void lancarItemSubTotalDebito(Pagamento pagamento, Double quantidade, String descricao, String mensagem,
			Double valor) {
		//TODO implementar
	}
	
	public void lancarItemSubTotal(Pagamento pagamento, Double quantidade, String descricao, String mensagem, Double valor) {
		//TODO implementar
	}

	public void lancarItemTotal(Pagamento pagamento, Double quantidade, String descricao, String mensagem, Double valor) {
		//TODO implementar
	}

	public List<Pagamento> buscarPorFolhaEFuncionario(Long folhaPagamentoId, Long funcionarioId) {
		TypedQuery<Pagamento> query = getEm()
				.createNamedQuery("pagamento.buscarPorFolhaEFuncionario", Pagamento.class)
				.setParameter("folhaPagamentoId", folhaPagamentoId)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}

	public List<Pagamento> buscarPorFuncionario(Long funcionarioId) {
		TypedQuery<Pagamento> query = getEm()
				.createNamedQuery("pagamento.buscarPorFuncionario", Pagamento.class)
				.setParameter("funcionarioId", funcionarioId);
		return query.getResultList();
	}

}