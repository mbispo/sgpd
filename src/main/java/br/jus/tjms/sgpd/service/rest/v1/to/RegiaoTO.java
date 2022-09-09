package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RegiaoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private PaisTO pais;
	
	public RegiaoTO() {
		super();
	}

	public RegiaoTO(Long id, String nome, PaisTO pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}

	public RegiaoTO(String nome, PaisTO pais) {
		super();
		this.nome = nome;
		this.pais = pais;
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

	public PaisTO getPais() {
		return pais;
	}

	public void setPais(PaisTO pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "RegiaoTO [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
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
		RegiaoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}