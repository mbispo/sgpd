package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CertificacaoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long entidadeCertificadoraId;
	private String nome;

	public CertificacaoTO() {
		super();
	}

	public CertificacaoTO(Long id, Long entidadeCertificadoraId, String nome) {
		super();
		this.id = id;
		this.entidadeCertificadoraId = entidadeCertificadoraId;
		this.nome = nome;
	}

	public CertificacaoTO(Long entidadeCertificadoraId, String nome) {
		super();
		this.entidadeCertificadoraId = entidadeCertificadoraId;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEntidadeCertificadoraId() {
		return entidadeCertificadoraId;
	}

	public void setEntidadeCertificadoraId(Long entidadeCertificadoraId) {
		this.entidadeCertificadoraId = entidadeCertificadoraId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "CertificacaoTO [id=" + id + ", entidadeCertificadoraId=" + entidadeCertificadoraId + ", nome=" + nome
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
		CertificacaoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}