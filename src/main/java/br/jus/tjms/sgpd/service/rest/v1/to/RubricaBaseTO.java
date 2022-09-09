package br.jus.tjms.sgpd.service.rest.v1.to;


import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RubricaBaseTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long rubricaId;
	private Long rubricaBaseId;

	public RubricaBaseTO() {
		super();
	}

	public RubricaBaseTO(Long id, Long rubricaId, Long rubricaBaseId) {
		super();
		this.id = id;
		this.rubricaId = rubricaId;
		this.rubricaBaseId = rubricaBaseId;
	}

	public RubricaBaseTO(Long rubricaId, Long rubricaBaseId) {
		super();
		this.rubricaId = rubricaId;
		this.rubricaBaseId = rubricaBaseId;
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

	public Long getRubricaBaseId() {
		return rubricaBaseId;
	}

	public void setRubricaBaseId(Long rubricaBaseId) {
		this.rubricaBaseId = rubricaBaseId;
	}

	@Override
	public String toString() {
		return "RubricaBaseTO [id=" + id + ", rubricaId=" + rubricaId + ", rubricaBaseId=" + rubricaBaseId + "]";
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
		RubricaBaseTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
}