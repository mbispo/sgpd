package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoTurno;
import br.jus.tjms.sgpd.service.rest.v1.to.TurnoTO;
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
public class Turno implements Serializable {

	private static final long serialVersionUID = 1325737302963496470L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	private TipoTurno tipo;

	private Date horaEntrada;
	private Date horaSaida;
	private Integer toleranciaMinutos;

	public Turno() {
		super();
	}

	public Turno(Long id, String descricao, TipoTurno tipo, Date horaEntrada, Date horaSaida, Integer toleranciaMinutos) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.toleranciaMinutos = toleranciaMinutos;
	}

	public Turno(TurnoTO turnoTO) {
		this.descricao = turnoTO.getDescricao();
		this.tipo = turnoTO.getTipo();
		this.horaEntrada = turnoTO.getHoraEntrada();
		this.horaSaida = turnoTO.getHoraSaida();
		this.toleranciaMinutos = turnoTO.getToleranciaMinutos();
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

	public TipoTurno getTipo() {
		return tipo;
	}

	public void setTipo(TipoTurno tipo) {
		this.tipo = tipo;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Integer getToleranciaMinutos() {
		return toleranciaMinutos;
	}

	public void setToleranciaMinutos(Integer toleranciaMinutos) {
		this.toleranciaMinutos = toleranciaMinutos;
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
		Turno other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + ", horaEntrada=" + horaEntrada
				+ ", horaSaida=" + horaSaida + ", toleranciaMinutos=" + toleranciaMinutos + "]";
	}

	public void alterar(TurnoTO turnoTO) {
		this.descricao = turnoTO.getDescricao();
		this.tipo = turnoTO.getTipo();
		this.horaEntrada = turnoTO.getHoraEntrada();
		this.horaSaida = turnoTO.getHoraSaida();
		this.toleranciaMinutos = turnoTO.getToleranciaMinutos();
	}

}