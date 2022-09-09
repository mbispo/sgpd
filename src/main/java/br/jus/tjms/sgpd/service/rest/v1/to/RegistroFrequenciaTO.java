package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RegistroFrequenciaTO implements Serializable {

	private static final long serialVersionUID = -2091007951025710599L;

	private Long id;
	private Long localRegistroFrequenciaId;
	private Long funcionarioId;
	private Date dataHora;

	public RegistroFrequenciaTO() {
		super();
	}

	public RegistroFrequenciaTO(Long id, Long localRegistroFrequenciaId, Long funcionarioId, Date dataHora) {
		super();
		this.id = id;
		this.localRegistroFrequenciaId = localRegistroFrequenciaId;
		this.funcionarioId = funcionarioId;
		this.dataHora = dataHora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLocalRegistroFrequenciaId() {
		return localRegistroFrequenciaId;
	}

	public void setLocalRegistroFrequenciaId(Long localRegistroFrequenciaId) {
		this.localRegistroFrequenciaId = localRegistroFrequenciaId;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		return "RegistroFrequenciaTO [id=" + id + ", localRegistroFrequenciaId=" + localRegistroFrequenciaId
				+ ", funcionarioId=" + funcionarioId + ", dataHora=" + dataHora + "]";
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
		RegistroFrequenciaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}