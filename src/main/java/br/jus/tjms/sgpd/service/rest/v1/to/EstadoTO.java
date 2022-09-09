package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@XmlRootElement
public class EstadoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String sigla;
	private PaisTO pais;
	
	public EstadoTO() {
		super();
	}

	public EstadoTO(Long id, String nome, String sigla, PaisTO pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.pais = pais;
	}

	public EstadoTO(String nome, String sigla, PaisTO pais) {
		super();
		this.nome = nome;
		this.sigla = sigla;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public PaisTO getPais() {
		return pais;
	}

	public void setPais(PaisTO pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "EstadoTO [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", pais=" + pais + "]";
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
		EstadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}