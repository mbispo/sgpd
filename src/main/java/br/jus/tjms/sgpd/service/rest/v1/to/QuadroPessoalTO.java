package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class QuadroPessoalTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long planoCargoId;
	private Long estruturaCargoId;
	private String nome;

	public QuadroPessoalTO() {
		super();
	}

	public QuadroPessoalTO(Long id, Long planoCargoId, Long estruturaCargoId, String nome) {
		super();
		this.id = id;
		this.planoCargoId = planoCargoId;
		this.estruturaCargoId = estruturaCargoId;
		this.nome = nome;
	}

	public QuadroPessoalTO(Long planoCargoId, Long estruturaCargoId, String nome) {
		super();
		this.planoCargoId = planoCargoId;
		this.estruturaCargoId = estruturaCargoId;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlanoCargoId() {
		return planoCargoId;
	}

	public void setPlanoCargoId(Long planoCargoId) {
		this.planoCargoId = planoCargoId;
	}
	
	public Long getEstruturaCargoId() {
		return estruturaCargoId;
	}

	public void setEstruturaCargoId(Long estruturaCargoId) {
		this.estruturaCargoId = estruturaCargoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "QuadroPessoalTO [id=" + id + ", planoCargoId=" + planoCargoId + ", estruturaCargoId=" + estruturaCargoId
				+ ", nome=" + nome + "]";
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
		QuadroPessoalTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}