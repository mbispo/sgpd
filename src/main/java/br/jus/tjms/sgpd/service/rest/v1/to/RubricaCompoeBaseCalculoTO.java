package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoBaseCalculo;

public class RubricaCompoeBaseCalculoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long rubricaId;
	private TipoBaseCalculo tipoBaseCalculo;

	public RubricaCompoeBaseCalculoTO() {
		super();
	}

	public RubricaCompoeBaseCalculoTO(Long id, Long rubricaId, TipoBaseCalculo tipoBaseCalculo) {
		super();
		this.id = id;
		this.rubricaId = rubricaId;
		this.tipoBaseCalculo = tipoBaseCalculo;
	}

	public RubricaCompoeBaseCalculoTO(Long rubricaId, TipoBaseCalculo tipoBaseCalculo) {
		super();
		this.rubricaId = rubricaId;
		this.tipoBaseCalculo = tipoBaseCalculo;
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

	public TipoBaseCalculo getTipoBaseCalculo() {
		return tipoBaseCalculo;
	}

	public void setTipoBaseCalculo(TipoBaseCalculo tipoBaseCalculo) {
		this.tipoBaseCalculo = tipoBaseCalculo;
	}

	@Override
	public String toString() {
		return "RubricaCompoeBaseCalculoTO [id=" + id + ", rubricaId=" + rubricaId + ", tipoBaseCalculo="
				+ tipoBaseCalculo + "]";
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
		RubricaCompoeBaseCalculoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}