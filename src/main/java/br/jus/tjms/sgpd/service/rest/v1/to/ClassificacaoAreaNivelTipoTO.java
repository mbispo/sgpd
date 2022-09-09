package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ClassificacaoAreaNivelTipoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long classificacaoAreaNivelId;
	private String descricao;

	public ClassificacaoAreaNivelTipoTO() {
		super();
	}

	public ClassificacaoAreaNivelTipoTO(Long id, Long classificacaoAreaNivelId, String descricao) {
		super();
		this.id = id;
		this.classificacaoAreaNivelId = classificacaoAreaNivelId;
		this.descricao = descricao;
	}

	public ClassificacaoAreaNivelTipoTO(Long classificacaoAreaNivelId, String descricao) {
		super();
		this.classificacaoAreaNivelId = classificacaoAreaNivelId;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassificacaoAreaNivelId() {
		return classificacaoAreaNivelId;
	}

	public void setClassificacaoAreaNivelId(Long classificacaoAreaNivelId) {
		this.classificacaoAreaNivelId = classificacaoAreaNivelId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "ClassificacaoAreaNivelTipoTO [id=" + id + ", classificacaoAreaNivelId=" + classificacaoAreaNivelId
				+ ", descricao=" + descricao + "]";
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
		ClassificacaoAreaNivelTipoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}