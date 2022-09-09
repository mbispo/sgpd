package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class FuncionarioAreaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long funcionarioId;
	private Long areaId;
	private Date dataInicio;
	private Date dataFim;

	public FuncionarioAreaTO() {
		super();
	}

	public FuncionarioAreaTO(Long id, Long funcionarioId, Long areaId, Date dataInicio, Date dataFim) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.areaId = areaId;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public FuncionarioAreaTO(Long funcionarioId, Long areaId, Date dataInicio, Date dataFim) {
		super();
		this.funcionarioId = funcionarioId;
		this.areaId = areaId;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
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
		return "FuncionarioAreaTO [id=" + id + ", funcionarioId=" + funcionarioId + ", areaId=" + areaId
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
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
		FuncionarioAreaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}