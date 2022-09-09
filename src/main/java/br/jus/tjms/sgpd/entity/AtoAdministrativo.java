package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.AtoAdministrativoTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AtoAdministrativo implements Serializable {

	private static final long serialVersionUID = -3542659118882114400L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date dataPublicacao;
	private Date dataEfeito;

	@Column(length = 60)
	private String numero;

	@Column(length = 60)
	private String publicacao;

	@Column(length = 200)
	private String assunto;

	@Column(length = 500)
	private String observacoes;

	private Integer idDocumentoGerdoc;

	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] integra;

	public AtoAdministrativo() {
		super();
	}
	
	public AtoAdministrativo(Long id) {
		super();
		this.id = id;
	}

	public AtoAdministrativo(AtoAdministrativoTO atoAdministrativoTO) {
		super();
		this.id = atoAdministrativoTO.getId();
		this.dataPublicacao = atoAdministrativoTO.getDataPublicacao(); 
		this.dataEfeito = atoAdministrativoTO.getDataEfeito();
		this.numero = atoAdministrativoTO.getNumero();
		this.publicacao = atoAdministrativoTO.getPublicacao();
		this.assunto = atoAdministrativoTO.getAssunto();
		this.observacoes = atoAdministrativoTO.getObservacoes();
		this.idDocumentoGerdoc = atoAdministrativoTO.getIdDocumentoGerdoc();
		this.integra = atoAdministrativoTO.getIntegra();
	}
	
	public AtoAdministrativo(Long id, Date dataPublicacao, Date dataEfeito, String numero, String publicacao,
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
	
	public void alterar(AtoAdministrativoTO atoAdministrativoTO) {
		this.dataPublicacao = atoAdministrativoTO.getDataPublicacao(); 
		this.dataEfeito = atoAdministrativoTO.getDataEfeito();
		this.numero = atoAdministrativoTO.getNumero();
		this.publicacao = atoAdministrativoTO.getPublicacao();
		this.assunto = atoAdministrativoTO.getAssunto();
		this.observacoes = atoAdministrativoTO.getObservacoes();
		this.idDocumentoGerdoc = atoAdministrativoTO.getIdDocumentoGerdoc();
		this.integra = atoAdministrativoTO.getIntegra();
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

	public byte[] getIntegra() {
		return integra;
	}

	public void setIntegra(byte[] integra) {
		this.integra = integra;
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

	public Integer getIdDocumentoGerdoc() {
		return idDocumentoGerdoc;
	}

	public void setIdDocumentoGerdoc(Integer idDocumentoGerdoc) {
		this.idDocumentoGerdoc = idDocumentoGerdoc;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		AtoAdministrativo other = (AtoAdministrativo) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "AtoAdministrativo [id=" + id + ", dataPublicacao=" + dataPublicacao + ", dataEfeito=" + dataEfeito
				+ ", numero=" + numero + ", publicacao=" + publicacao + ", assunto=" + assunto + ", observacoes="
				+ observacoes + ", idDocumentoGerdoc=" + idDocumentoGerdoc + "]";
	}
	
	public AtoAdministrativoTO toTO() {
		AtoAdministrativoTO to = new AtoAdministrativoTO(this.id, this.dataPublicacao, this.dataEfeito, this.numero, 
				this.publicacao, this.assunto, this.observacoes, this.idDocumentoGerdoc, this.integra);
		return to;
	}

}