package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PagamentoLancamentoAvulsoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Double valorPago;
	private Date dataPagamento;

	public PagamentoLancamentoAvulsoTO() {
		super();
	}

	public PagamentoLancamentoAvulsoTO(Long id, Double valorPago, Date dataPagamento) {
		super();
		this.id = id;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	@Override
	public String toString() {
		return "PagamentoLancamentoAvulsoTO [id=" + id + ", valorPago=" + valorPago + ", dataPagamento=" + dataPagamento
				+ "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		PagamentoLancamentoAvulsoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}