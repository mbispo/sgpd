package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoVinculoTurno;
import br.jus.tjms.sgpd.service.rest.v1.to.TurnoCargoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:07
 */
@Entity
@Auditavel
@Cacheable
public class TurnoCargo implements Serializable {

	private static final long serialVersionUID = -8571104734678514387L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "turno_id", nullable = false)
	private Turno turno;

	private Date vigenciaInicio;
	private Date vigenciaFim;

	@Enumerated(EnumType.ORDINAL)
	private TipoVinculoTurno tipoVinculo;

	private Boolean ativo;

	public TurnoCargo() {
		super();
	}

	public TurnoCargo(Long id, Cargo cargo, Turno turno, Date vigenciaInicio, Date vigenciaFim,
			TipoVinculoTurno tipoVinculo, Boolean ativo) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.turno = turno;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.tipoVinculo = tipoVinculo;
		this.ativo = ativo;
	}

	public TurnoCargo(Cargo cargo, TurnoCargoTO turnoCargoTO) {
		this.cargo = cargo;
		//FIXME this.turno = turnoCargoTO.getTurnoId();
		this.vigenciaInicio = turnoCargoTO.getVigenciaInicio();
		this.vigenciaFim = turnoCargoTO.getVigenciaFim();
		this.tipoVinculo = turnoCargoTO.getTipoVinculo();
		this.ativo = turnoCargoTO.getAtivo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
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
		TurnoCargo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "TurnoCargo [id=" + id + ", cargo=" + cargo + ", turno=" + turno + ", vigenciaInicio=" + vigenciaInicio
				+ ", vigenciaFim=" + vigenciaFim + ", tipoVinculo=" + tipoVinculo + ", ativo=" + ativo + "]";
	}

	public void alterar(Cargo cargo, TurnoCargoTO turnoCargoTO) {
		this.cargo = cargo;
		//FIXME this.turno = turnoCargoTO.getTurnoId();
		this.vigenciaInicio = turnoCargoTO.getVigenciaInicio();
		this.vigenciaFim = turnoCargoTO.getVigenciaFim();
		this.tipoVinculo = turnoCargoTO.getTipoVinculo();
		this.ativo = turnoCargoTO.getAtivo();
	}

}