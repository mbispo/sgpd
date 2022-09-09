package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.LogradouroTipo;

public class LogradouroTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private LogradouroTipo tipo;
	
	public LogradouroTO() {
		super();
	}

	public LogradouroTO(Long id, String nome, LogradouroTipo tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}

	public LogradouroTO(String nome, LogradouroTipo tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
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

	public LogradouroTipo getTipo() {
		return tipo;
	}

	public void setTipo(LogradouroTipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "LogradouroTO [id=" + id + ", nome=" + nome + ", tipo=" + tipo + "]";
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
		LogradouroTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}