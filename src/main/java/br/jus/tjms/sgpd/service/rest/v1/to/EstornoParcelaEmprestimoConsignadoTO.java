package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EstornoParcelaEmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long parcelaId;
	private Long emprestimoConsignadoId;
	private Date dataEstorno;
	private Double valorEstorno;

	public EstornoParcelaEmprestimoConsignadoTO() {
		super();
	}

	public EstornoParcelaEmprestimoConsignadoTO(Long parcelaId, Long emprestimoConsignadoId, Date dataEstorno,
			Double valorEstorno) {
		super();
		this.parcelaId = parcelaId;
		this.emprestimoConsignadoId = emprestimoConsignadoId;
		this.dataEstorno = dataEstorno;
		this.valorEstorno = valorEstorno;
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

	public Date getDataEstorno() {
		return dataEstorno;
	}

	public void setDataEstorno(Date dataEstorno) {
		this.dataEstorno = dataEstorno;
	}

	public Double getValorEstorno() {
		return valorEstorno;
	}

	public void setValorEstorno(Double valorEstorno) {
		this.valorEstorno = valorEstorno;
	}

	@Override
	public String toString() {
		return "EstornoParcelaEmprestimoConsignadoTO [parcelaId=" + parcelaId + ", emprestimoConsignadoId="
				+ emprestimoConsignadoId + ", dataEstorno=" + dataEstorno + ", valorEstorno=" + valorEstorno + "]";
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
		EstornoParcelaEmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(parcelaId, other.getParcelaId()).isEquals();
	}

}