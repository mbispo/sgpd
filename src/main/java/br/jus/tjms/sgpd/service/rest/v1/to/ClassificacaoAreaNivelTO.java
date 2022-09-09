package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ClassificacaoAreaNivelTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer nivel;
	private String descricao;

	public ClassificacaoAreaNivelTO() {
		super();
	}

	public ClassificacaoAreaNivelTO(Long id, Integer nivel, String descricao) {
		super();
		this.id = id;
		this.nivel = nivel;
		this.descricao = descricao;
	}

	public ClassificacaoAreaNivelTO(Integer nivel, String descricao) {
		super();
		this.nivel = nivel;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "ClassificacaoAreaNivelTO [id=" + id + ", nivel=" + nivel + ", descricao=" + descricao + "]";
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
		ClassificacaoAreaNivelTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}