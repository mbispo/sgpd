package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EscalaFuncionarioTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long escalaId;
	private Long funcionarioId;
	private Integer sequencial;
	private Date dataHoraEntrada;
	private Date dataHoraSaida;
	private Boolean cumprida;

	public EscalaFuncionarioTO() {
		super();
	}
	
	public EscalaFuncionarioTO(Long id) {
		super();
		this.id = id;
	}


	public EscalaFuncionarioTO(Long escalaId, Long funcionarioId, Date dataHoraEntrada, Date dataHoraSaida, Boolean cumprida) {
		super();
		this.escalaId = escalaId;
		this.funcionarioId = funcionarioId;
		this.dataHoraEntrada = dataHoraEntrada;
		this.dataHoraSaida = dataHoraSaida;
		this.cumprida = cumprida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEscalaId() {
		return escalaId;
	}

	public void setEscalaId(Long escalaId) {
		this.escalaId = escalaId;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public Date getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Date dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Date getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(Date dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}

	public Boolean getCumprida() {
		return cumprida;
	}

	public void setCumprida(Boolean cumprida) {
		this.cumprida = cumprida;
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
		EscalaFuncionarioTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "EscalaFuncionario [id=" + id + ", escala=" + escalaId + ", funcionario=" + funcionarioId + ", sequencial="
				+ sequencial + ", dataHoraEntrada=" + dataHoraEntrada + ", dataHoraSaida=" + dataHoraSaida
				+ ", cumprida=" + cumprida + "]";
	}

}