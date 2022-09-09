package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AreaLocalidadeTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long areaId;
	private Long localidadeId;
	private Date dataInicio;
	private Date dataFim;

	public AreaLocalidadeTO() {
		super();
	}

	public AreaLocalidadeTO(Long id, Long areaId, Long localidadeId, Date dataInicio, Date dataFim) {
		super();
		this.id = id;
		this.areaId = areaId;
		this.localidadeId = localidadeId;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public AreaLocalidadeTO(Long areaId, Long localidadeId, Date dataInicio, Date dataFim) {
		super();
		this.areaId = areaId;
		this.localidadeId = localidadeId;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getLocalidadeId() {
		return localidadeId;
	}

	public void setLocalidadeId(Long localidadeId) {
		this.localidadeId = localidadeId;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return "AreaLocalidadeTO [id=" + id + ", areaId=" + areaId + ", localidadeId=" + localidadeId + ", dataInicio="
				+ dataInicio + ", dataFim=" + dataFim + "]";
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
		AreaLocalidadeTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}