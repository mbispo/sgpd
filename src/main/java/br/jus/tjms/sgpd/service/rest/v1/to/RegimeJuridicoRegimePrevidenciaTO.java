package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RegimeJuridicoRegimePrevidenciaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long regimeJuridicoId;
	private Long regimePrevidenciaId;

	public RegimeJuridicoRegimePrevidenciaTO() {
		super();
	}

	public RegimeJuridicoRegimePrevidenciaTO(Long id, Long regimeJuridicoId, Long regimePrevidenciaId) {
		super();
		this.id = id;
		this.regimeJuridicoId = regimeJuridicoId;
		this.regimePrevidenciaId = regimePrevidenciaId;
	}

	public RegimeJuridicoRegimePrevidenciaTO(Long regimeJuridicoId, Long regimePrevidenciaId) {
		super();
		this.regimeJuridicoId = regimeJuridicoId;
		this.regimePrevidenciaId = regimePrevidenciaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegimeJuridicoId() {
		return regimeJuridicoId;
	}

	public void setRegimeJuridicoId(Long regimeJuridicoId) {
		this.regimeJuridicoId = regimeJuridicoId;
	}

	public Long getRegimePrevidenciaId() {
		return regimePrevidenciaId;
	}

	public void setRegimePrevidenciaId(Long regimePrevidenciaId) {
		this.regimePrevidenciaId = regimePrevidenciaId;
	}

	@Override
	public String toString() {
		return "RegimeJuridicoRegimePrevidenciaTO [id=" + id + ", regimeJuridicoId=" + regimeJuridicoId
				+ ", regimePrevidenciaId=" + regimePrevidenciaId + "]";
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
		RegimeJuridicoRegimePrevidenciaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}