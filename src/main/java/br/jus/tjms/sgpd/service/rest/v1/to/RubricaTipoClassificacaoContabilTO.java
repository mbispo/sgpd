package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoClassificacaoContabil;

public class RubricaTipoClassificacaoContabilTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String classificacaoContabil;
	private Long rubricaId;
	private TipoClassificacaoContabil tipoClassificacaoContabil;

	public RubricaTipoClassificacaoContabilTO() {
		super();
	}

	public RubricaTipoClassificacaoContabilTO(Long id, String classificacaoContabil, Long rubricaId,
			TipoClassificacaoContabil tipoClassificacaoContabil) {
		super();
		this.id = id;
		this.classificacaoContabil = classificacaoContabil;
		this.rubricaId = rubricaId;
		this.tipoClassificacaoContabil = tipoClassificacaoContabil;
	}

	public RubricaTipoClassificacaoContabilTO(String classificacaoContabil, Long rubricaId,
			TipoClassificacaoContabil tipoClassificacaoContabil) {
		super();
		this.classificacaoContabil = classificacaoContabil;
		this.rubricaId = rubricaId;
		this.tipoClassificacaoContabil = tipoClassificacaoContabil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassificacaoContabil() {
		return classificacaoContabil;
	}

	public void setClassificacaoContabil(String classificacaoContabil) {
		this.classificacaoContabil = classificacaoContabil;
	}

	public Long getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Long rubricaId) {
		this.rubricaId = rubricaId;
	}

	public TipoClassificacaoContabil getTipoClassificacaoContabil() {
		return tipoClassificacaoContabil;
	}

	public void setTipoClassificacaoContabil(TipoClassificacaoContabil tipoClassificacaoContabil) {
		this.tipoClassificacaoContabil = tipoClassificacaoContabil;
	}

	@Override
	public String toString() {
		return "RubricaTipoClassificacaoContabilTO [id=" + id + ", classificacaoContabil=" + classificacaoContabil
				+ ", rubricaId=" + rubricaId + ", tipoClassificacaoContabil=" + tipoClassificacaoContabil + "]";
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
		RubricaTipoClassificacaoContabilTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}