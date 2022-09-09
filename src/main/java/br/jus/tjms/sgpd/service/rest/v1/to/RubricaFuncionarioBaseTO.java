package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RubricaFuncionarioBaseTO implements Serializable {
	
	private static final long serialVersionUID = -4282664676486688705L;
	
	private Long id;
	private Long rubricaFuncionarioId;
	private Long rubricaId;

	public RubricaFuncionarioBaseTO() {
		super();
	}
	
	public RubricaFuncionarioBaseTO(Long rubricaFuncionarioId, Long rubricaId) {
		super();
		this.rubricaFuncionarioId = rubricaFuncionarioId;
		this.rubricaId = rubricaId;
	}
	
	public RubricaFuncionarioBaseTO(Long id, Long rubricaFuncionarioId, Long rubricaId) {
		super();
		this.id = id;
		this.rubricaFuncionarioId = rubricaFuncionarioId;
		this.rubricaId = rubricaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRubricaFuncionarioId() {
		return rubricaFuncionarioId;
	}

	public void setRubricaFuncionarioId(Long rubricaFuncionarioId) {
		this.rubricaFuncionarioId = rubricaFuncionarioId;
	}

	public Long getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Long rubricaId) {
		this.rubricaId = rubricaId;
	}

	@Override
	public String toString() {
		return "RubricaFuncionarioBaseTO [id=" + id + ", rubricaFuncionarioId=" + rubricaFuncionarioId + ", rubricaId="
				+ rubricaId + "]";
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
		RubricaFuncionarioBaseTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}