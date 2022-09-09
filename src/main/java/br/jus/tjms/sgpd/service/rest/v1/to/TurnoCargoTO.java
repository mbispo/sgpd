package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoVinculoTurno;

public class TurnoCargoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long cargoId;
	private Long turnoId;
	private Date vigenciaInicio;
	private Date vigenciaFim;
	private TipoVinculoTurno tipoVinculo;
	private Boolean ativo;

	public TurnoCargoTO() {
		super();
	}

	public TurnoCargoTO(Long id, Long cargoId, Long turnoId, Date vigenciaInicio, Date vigenciaFim,
			TipoVinculoTurno tipoVinculo, Boolean ativo) {
		super();
		this.id = id;
		this.cargoId = cargoId;
		this.turnoId = turnoId;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.tipoVinculo = tipoVinculo;
		this.ativo = ativo;
	}

	public TurnoCargoTO(Long cargoId, Long turnoId, Date vigenciaInicio, Date vigenciaFim, TipoVinculoTurno tipoVinculo,
			Boolean ativo) {
		super();
		this.cargoId = cargoId;
		this.turnoId = turnoId;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.tipoVinculo = tipoVinculo;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCargoId() {
		return cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	public Long getTurnoId() {
		return turnoId;
	}

	public void setTurnoId(Long turnoId) {
		this.turnoId = turnoId;
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

	public TipoVinculoTurno getTipoVinculo() {
		return tipoVinculo;
	}

	public void setTipoVinculo(TipoVinculoTurno tipoVinculo) {
		this.tipoVinculo = tipoVinculo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "TurnoCargoTO [id=" + id + ", cargoId=" + cargoId + ", turnoId=" + turnoId + ", vigenciaInicio="
				+ vigenciaInicio + ", vigenciaFim=" + vigenciaFim + ", tipoVinculo=" + tipoVinculo + ", ativo=" + ativo
				+ "]";
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
		TurnoCargoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}