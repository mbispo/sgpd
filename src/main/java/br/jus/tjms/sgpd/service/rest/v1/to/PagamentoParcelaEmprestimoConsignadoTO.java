package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PagamentoParcelaEmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long parcelaId;
	private Long emprestimoConsignadoId;
	private Date pagamento;
	private Double valorPago;

	public PagamentoParcelaEmprestimoConsignadoTO() {
		super();
	}

	public PagamentoParcelaEmprestimoConsignadoTO(Long parcelaId, Long emprestimoConsignadoId, Date pagamento,
			Double valorPago) {
		super();
		this.parcelaId = parcelaId;
		this.emprestimoConsignadoId = emprestimoConsignadoId;
		this.pagamento = pagamento;
		this.valorPago = valorPago;
	}

	public Long getParcelaId() {
		return parcelaId;
	}

	public void setParcelaId(Long parcelaId) {
		this.parcelaId = parcelaId;
	}

	public Long getEmprestimoConsignadoId() {
		return emprestimoConsignadoId;
	}

	public void setEmprestimoConsignadoId(Long emprestimoConsignadoId) {
		this.emprestimoConsignadoId = emprestimoConsignadoId;
	}

	public Date getPagamento() {
		return pagamento;
	}

	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	@Override
	public String toString() {
		return "PagamentoParcelaEmprestimoConsignadoTO [parcelaId=" + parcelaId + ", emprestimoConsignadoId="
				+ emprestimoConsignadoId + ", pagamento=" + pagamento + ", valorPago=" + valorPago + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(parcelaId).toHashCode();
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
		PagamentoParcelaEmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(parcelaId, other.getParcelaId()).isEquals();
	}

}