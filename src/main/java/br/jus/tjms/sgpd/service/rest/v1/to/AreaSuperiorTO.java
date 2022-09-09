package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AreaSuperiorTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long areaId;
	private Long areaSuperiorId;
	private Date dataFim;
	private Date dataInicio;
	private Long atoAdministrativoId;

	public AreaSuperiorTO() {
		super();
	}

	public AreaSuperiorTO(Long id, Long areaId, Long areaSuperiorId, Date dataFim, Date dataInicio,
			Long atoAdministrativoId) {
		super();
		this.id = id;
		this.areaId = areaId;
		this.areaSuperiorId = areaSuperiorId;
		this.dataFim = dataFim;
		this.dataInicio = dataInicio;
		this.atoAdministrativoId = atoAdministrativoId;
	}

	public AreaSuperiorTO(Long areaId, Long areaSuperiorId, Date dataFim, Date dataInicio, Long atoAdministrativoId) {
		super();
		this.areaId = areaId;
		this.areaSuperiorId = areaSuperiorId;
		this.dataFim = dataFim;
		this.dataInicio = dataInicio;
		this.atoAdministrativoId = atoAdministrativoId;
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

	public Long getAreaSuperiorId() {
		return areaSuperiorId;
	}

	public void setAreaSuperiorId(Long areaSuperiorId) {
		this.areaSuperiorId = areaSuperiorId;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Long getAtoAdministrativoId() {
		return atoAdministrativoId;
	}

	public void setAtoAdministrativoId(Long atoAdministrativoId) {
		this.atoAdministrativoId = atoAdministrativoId;
	}

	@Override
	public String toString() {
		return "AreaSuperiorTO [id=" + id + ", areaId=" + areaId + ", areaSuperiorId=" + areaSuperiorId + ", dataFim="
				+ dataFim + ", dataInicio=" + dataInicio + ", atoAdministrativoId=" + atoAdministrativoId + "]";
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
		AreaSuperiorTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}