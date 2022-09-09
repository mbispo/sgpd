package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class OcupacaoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;

	public OcupacaoTO() {
		super();
	}

	public OcupacaoTO(Long id) {
		super();
		this.id = id;
	}

	public OcupacaoTO(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public OcupacaoTO(String descricao) {
		super();
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "OcupacaoTO [id=" + id + ", descricao=" + descricao + "]";
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
		OcupacaoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}