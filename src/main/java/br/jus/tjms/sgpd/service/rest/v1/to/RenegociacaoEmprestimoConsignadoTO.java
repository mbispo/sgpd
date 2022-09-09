package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RenegociacaoEmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long emprestimoConsignadoId;
	private Date dataRenegociacao;
	private Double valorRenegociado;
	private String observacoes;

	public RenegociacaoEmprestimoConsignadoTO() {
		super();
	}

	public RenegociacaoEmprestimoConsignadoTO(Long emprestimoConsignadoId, Date dataRenegociacao,
			Double valorRenegociado, String observacoes) {
		super();
		this.emprestimoConsignadoId = emprestimoConsignadoId;
		this.dataRenegociacao = dataRenegociacao;
		this.valorRenegociado = valorRenegociado;
		this.observacoes = observacoes;
	}

	public Long getEmprestimoConsignadoId() {
		return emprestimoConsignadoId;
	}

	public void setEmprestimoConsignadoId(Long emprestimoConsignadoId) {
		this.emprestimoConsignadoId = emprestimoConsignadoId;
	}

	public Date getDataRenegociacao() {
		return dataRenegociacao;
	}

	public void setDataRenegociacao(Date dataRenegociacao) {
		this.dataRenegociacao = dataRenegociacao;
	}

	public Double getValorRenegociado() {
		return valorRenegociado;
	}

	public void setValorRenegociado(Double valorRenegociado) {
		this.valorRenegociado = valorRenegociado;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "RenegociacaoEmprestimoConsignadoTO [emprestimoConsignadoId=" + emprestimoConsignadoId
				+ ", dataRenegociacao=" + dataRenegociacao + ", valorRenegociado=" + valorRenegociado + ", observacoes="
				+ observacoes + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(emprestimoConsignadoId).toHashCode();
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
		RenegociacaoEmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(emprestimoConsignadoId, other.getEmprestimoConsignadoId()).isEquals();
	}

}