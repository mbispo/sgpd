package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class OrgaoEmissorTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String sigla;
	private String uf;
	
	public OrgaoEmissorTO() {
		super();
	}

	public OrgaoEmissorTO(Long id, String nome, String sigla, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.uf = uf;
	}

	public OrgaoEmissorTO(String nome, String sigla, String uf) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.uf = uf;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "OrgaoEmissorTO [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", uf=" + uf + "]";
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
		OrgaoEmissorTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}