package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoTurno;

public class TurnoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	private TipoTurno tipo;
	private Date horaEntrada;
	private Date horaSaida;
	private Integer toleranciaMinutos;

	public TurnoTO() {
		super();
	}

	public TurnoTO(Long id, String descricao, TipoTurno tipo, Date horaEntrada, Date horaSaida,
			Integer toleranciaMinutos) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.toleranciaMinutos = toleranciaMinutos;
	}

	public TurnoTO(String descricao, TipoTurno tipo, Date horaEntrada, Date horaSaida, Integer toleranciaMinutos) {
		super();
		this.descricao = descricao;
		this.tipo = tipo;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.toleranciaMinutos = toleranciaMinutos;
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
	public String toString() {
		return "TurnoTO [id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + ", horaEntrada=" + horaEntrada
				+ ", horaSaida=" + horaSaida + ", toleranciaMinutos=" + toleranciaMinutos + "]";
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
		TurnoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}