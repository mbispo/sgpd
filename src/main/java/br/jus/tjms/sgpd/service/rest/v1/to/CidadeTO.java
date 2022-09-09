package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@XmlRootElement
public class CidadeTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private EstadoTO estado;

	public CidadeTO() {
		super();
	}

	public CidadeTO(Long id, String nome, EstadoTO estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public CidadeTO(String nome, EstadoTO estado) {
		super();
		this.nome = nome;
		this.estado = estado;
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

	public EstadoTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoTO estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CidadeTO [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
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
		CidadeTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}