package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EntidadeCertificadoraTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;

	public EntidadeCertificadoraTO() {
		super();
	}

	public EntidadeCertificadoraTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public EntidadeCertificadoraTO(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "EntidadeCertificadoraTO [id=" + id + ", nome=" + nome + "]";
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
		EntidadeCertificadoraTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}