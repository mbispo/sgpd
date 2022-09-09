package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BancoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer codigo;
	private String nome;
	private String sigla;
	
	public BancoTO() {
		super();
	}

	public BancoTO(Long id, Integer codigo, String nome, String sigla) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
	}

	public BancoTO(Integer codigo, String nome, String sigla) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		return "BancoTO [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", sigla=" + sigla + "]";
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
		BancoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}