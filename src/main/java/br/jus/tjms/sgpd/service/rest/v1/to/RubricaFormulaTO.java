package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RubricaFormulaTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long rubricaId;
	private Long formulaId;

	public RubricaFormulaTO() {
		super();
	}

	public RubricaFormulaTO(Long id, Long rubricaId, Long formulaId) {
		super();
		this.id = id;
		this.rubricaId = rubricaId;
		this.formulaId = formulaId;
	}

	public RubricaFormulaTO(Long rubricaId, Long formulaId) {
		super();
		this.rubricaId = rubricaId;
		this.formulaId = formulaId;
	}

	public RubricaFormulaTO(Long id) {
		super();
		this.id = id;
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

	public Long getFormulaId() {
		return formulaId;
	}

	public void setFormulaId(Long formulaId) {
		this.formulaId = formulaId;
	}

	@Override
	public String toString() {
		return "RubricaFormulaTO [id=" + id + ", rubricaId=" + rubricaId + ", formulaId=" + formulaId + "]";
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
		RubricaFormulaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}