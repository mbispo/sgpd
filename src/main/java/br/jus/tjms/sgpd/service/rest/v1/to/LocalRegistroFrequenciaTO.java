package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class LocalRegistroFrequenciaTO implements Serializable {

	private static final long serialVersionUID = -1476431952817439582L;

	private Long id;
	private String descricao;
	private Long areaId;

	public LocalRegistroFrequenciaTO() {
		super();
	}

	public LocalRegistroFrequenciaTO(Long id, String descricao, Long areaId) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.areaId = areaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	@Override
	public String toString() {
		return "LocalRegistroFrequenciaTO [id=" + id + ", descricao=" + descricao + ", areaId=" + areaId + "]";
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
		LocalRegistroFrequenciaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}