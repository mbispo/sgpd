package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RubricaPlanoSaudeTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long rubricaId;
	private Long planoSaudeId;
	private Double percentual;

	public RubricaPlanoSaudeTO() {
		super();
	}

	public RubricaPlanoSaudeTO(Long id, Long rubricaId, Long planoSaudeId, Double percentual) {
		super();
		this.id = id;
		this.rubricaId = rubricaId;
		this.planoSaudeId = planoSaudeId;
		this.percentual = percentual;
	}

	public RubricaPlanoSaudeTO(Long rubricaId, Long planoSaudeId, Double percentual) {
		super();
		this.rubricaId = rubricaId;
		this.planoSaudeId = planoSaudeId;
		this.percentual = percentual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Long rubricaId) {
		this.rubricaId = rubricaId;
	}

	public Long getPlanoSaudeId() {
		return planoSaudeId;
	}

	public void setPlanoSaudeId(Long planoSaudeId) {
		this.planoSaudeId = planoSaudeId;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	@Override
	public String toString() {
		return "RubricaPlanoSaudeTO [id=" + id + ", rubricaId=" + rubricaId + ", planoSaudeId=" + planoSaudeId
				+ ", percentual=" + percentual + "]";
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
		RubricaPlanoSaudeTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}