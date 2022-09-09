package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AreaHistoricoClassificacaoNivelTipoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date dataFim;
	private Date dataInicio;
	private Long areaId;

	private Long classificacaoAreaNivelTipoId;

	public AreaHistoricoClassificacaoNivelTipoTO() {
		super();
	}

	public AreaHistoricoClassificacaoNivelTipoTO(Long id, Date dataFim, Date dataInicio, Long areaId,
			Long classificacaoAreaNivelTipoId) {
		super();
		this.id = id;
		this.dataFim = dataFim;
		this.dataInicio = dataInicio;
		this.areaId = areaId;
		this.classificacaoAreaNivelTipoId = classificacaoAreaNivelTipoId;
	}

	public AreaHistoricoClassificacaoNivelTipoTO(Date dataFim, Date dataInicio, Long areaId,
			Long classificacaoAreaNivelTipoId) {
		super();
		this.dataFim = dataFim;
		this.dataInicio = dataInicio;
		this.areaId = areaId;
		this.classificacaoAreaNivelTipoId = classificacaoAreaNivelTipoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getClassificacaoAreaNivelTipoId() {
		return classificacaoAreaNivelTipoId;
	}

	public void setClassificacaoAreaNivelTipoId(Long classificacaoAreaNivelTipoId) {
		this.classificacaoAreaNivelTipoId = classificacaoAreaNivelTipoId;
	}

	@Override
	public String toString() {
		return "AreaHistoricoClassificacaoNivelTipoTO [id=" + id + ", dataFim=" + dataFim + ", dataInicio=" + dataInicio
				+ ", areaId=" + areaId + ", classificacaoAreaNivelTipoId=" + classificacaoAreaNivelTipoId + "]";
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
		AreaHistoricoClassificacaoNivelTipoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}