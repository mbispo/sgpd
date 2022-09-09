package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ReferenciaValorTO implements Serializable {

	private static final long serialVersionUID = -9033282689838725053L;

	private Long id;
	private Long refererenciaId;
	private Double valor;
	private Date vigenciaInicio;
	private Date vigenciaFim;

	public ReferenciaValorTO() {
		super();
	}

	public ReferenciaValorTO(Long id, Long refererenciaId, Double valor, Date vigenciaInicio, Date vigenciaFim) {
		super();
		this.id = id;
		this.refererenciaId = refererenciaId;
		this.valor = valor;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
	}

	public ReferenciaValorTO(Long refererenciaId, Double valor, Date vigenciaInicio, Date vigenciaFim) {
		super();
		this.refererenciaId = refererenciaId;
		this.valor = valor;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRefererenciaId() {
		return refererenciaId;
	}

	public void setRefererenciaId(Long refererenciaId) {
		this.refererenciaId = refererenciaId;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	@Override
	public String toString() {
		return "ReferenciaValorTO [id=" + id + ", refererenciaId=" + refererenciaId + ", valor=" + valor
				+ ", vigenciaInicio=" + vigenciaInicio + ", vigenciaFim=" + vigenciaFim + "]";
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
		ReferenciaValorTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}