package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class GrupoFolhaPagamentoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private Long grupoSuperiorId;

	public GrupoFolhaPagamentoTO() {
		super();
	}

	public GrupoFolhaPagamentoTO(Long id, String descricao, Long grupoSuperiorId) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.grupoSuperiorId = grupoSuperiorId;
	}

	public GrupoFolhaPagamentoTO(String descricao, Long grupoSuperiorId) {
		super();
		this.descricao = descricao;
		this.grupoSuperiorId = grupoSuperiorId;
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

	public Long getGrupoSuperiorId() {
		return grupoSuperiorId;
	}

	public void setGrupoSuperiorId(Long grupoSuperiorId) {
		this.grupoSuperiorId = grupoSuperiorId;
	}

	@Override
	public String toString() {
		return "GrupoFolhaPagamentoTO [id=" + id + ", descricao=" + descricao + ", grupoSuperiorId=" + grupoSuperiorId
				+ "]";
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
		GrupoFolhaPagamentoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}