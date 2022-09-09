package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.entity.Area;

public class AreaResponsavelTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Area area;
	private Date dataInicio;
	private Long funcionarioId;
	private Date dataFim;

	public AreaResponsavelTO() {
		super();
	}

	public AreaResponsavelTO(Long id, Area area, Date dataInicio, Long funcionarioId, Date dataFim) {
		super();
		this.id = id;
		this.area = area;
		this.dataInicio = dataInicio;
		this.funcionarioId = funcionarioId;
		this.dataFim = dataFim;
	}

	public AreaResponsavelTO(Area area, Date dataInicio, Long funcionarioId, Date dataFim) {
		super();
		this.area = area;
		this.dataInicio = dataInicio;
		this.funcionarioId = funcionarioId;
		this.dataFim = dataFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return "AreaResponsavelTO [id=" + id + ", area=" + area + ", dataInicio=" + dataInicio + ", funcionarioId="
				+ funcionarioId + ", dataFim=" + dataFim + "]";
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
		AreaResponsavelTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}