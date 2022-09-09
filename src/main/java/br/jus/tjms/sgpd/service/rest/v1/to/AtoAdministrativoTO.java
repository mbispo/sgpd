package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AtoAdministrativoTO implements Serializable {

	private static final long serialVersionUID = -5666694901443352985L;
	
	private Long id;
	private Date dataPublicacao;
	private Date dataEfeito;
	private String numero;
	private String publicacao;
	private String assunto;
	private String observacoes;
	private Integer idDocumentoGerdoc;
	private byte[] integra;

	public AtoAdministrativoTO() {
		super();
	}

	public AtoAdministrativoTO(Long id, Date dataPublicacao, Date dataEfeito, String numero, String publicacao,
			String assunto, String observacoes, Integer idDocumentoGerdoc, byte[] integra) {
		super();
		this.id = id;
		this.dataPublicacao = dataPublicacao;
		this.dataEfeito = dataEfeito;
		this.numero = numero;
		this.publicacao = publicacao;
		this.assunto = assunto;
		this.observacoes = observacoes;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
		this.integra = integra;
	}

	public AtoAdministrativoTO(Date dataPublicacao, Date dataEfeito, String numero, String publicacao, String assunto,
			String observacoes, Integer idDocumentoGerdoc, byte[] integra) {
		super();
		this.dataPublicacao = dataPublicacao;
		this.dataEfeito = dataEfeito;
		this.numero = numero;
		this.publicacao = publicacao;
		this.assunto = assunto;
		this.observacoes = observacoes;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
		this.integra = integra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getIdDocumentoGerdoc() {
		return idDocumentoGerdoc;
	}

	public void setIdDocumentoGerdoc(Integer idDocumentoGerdoc) {
		this.idDocumentoGerdoc = idDocumentoGerdoc;
	}

	public byte[] getIntegra() {
		return integra;
	}

	public void setIntegra(byte[] integra) {
		this.integra = integra;
	}

	@Override
	public String toString() {
		return "AtoAdministrativoTO [id=" + id + ", dataPublicacao=" + dataPublicacao + ", dataEfeito=" + dataEfeito
				+ ", numero=" + numero + ", publicacao=" + publicacao + ", assunto=" + assunto + ", observacoes="
				+ observacoes + ", idDocumentoGerdoc=" + idDocumentoGerdoc + "]";
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
		AtoAdministrativoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}