package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.DocumentoTipo;
import br.jus.tjms.sgpd.service.rest.v1.to.DocumentoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:59
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "documento.buscarDocumentosPorPessoa", 
			query = "SELECT d from Documento d WHERE d.pessoa.id = :idPessoa")
})
public class Documento implements Serializable {

	private static final long serialVersionUID = -4123827160924111594L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@Enumerated(EnumType.ORDINAL)
	private DocumentoTipo tipo;

	@ManyToOne
	@JoinColumn(name = "orgaoEmissor_id", nullable = false)
	private OrgaoEmissor orgaoEmissor;

	@Column(length = 60)
	private String numero;

	@Column(length = 60)
	private String complemento;

	private Date emissao;
	private Date validade;

	@Column(length = 500)
	private String observacoes;

	public Documento() {
		super();
	}

	public Documento(Long id, Pessoa pessoa, DocumentoTipo tipo, OrgaoEmissor orgaoEmissor, String numero,
			String complemento, Date emissao, Date validade, String observacoes) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.tipo = tipo;
		this.orgaoEmissor = orgaoEmissor;
		this.numero = numero;
		this.complemento = complemento;
		this.emissao = emissao;
		this.validade = validade;
		this.observacoes = observacoes;
	}
	
	public Documento(DocumentoTO documentoTO) {
		super();
		this.pessoa = documentoTO.getPessoa();
		this.tipo = documentoTO.getTipo();
		//FIXME this.orgaoEmissor = documentoTO.getOrgaoEmissor();
		this.numero = documentoTO.getNumero();
		this.complemento = documentoTO.getComplemento();
		this.emissao = documentoTO.getEmissao();
		this.validade = documentoTO.getValidade();
		this.observacoes = documentoTO.getObservacoes();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DocumentoTipo getTipo() {
		return tipo;
	}

	public void setTipo(DocumentoTipo tipo) {
		this.tipo = tipo;
	}

	public OrgaoEmissor getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(OrgaoEmissor orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
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
		Documento other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", pessoa=" + pessoa + ", tipo=" + tipo + ", orgaoEmissor=" + orgaoEmissor
				+ ", numero=" + numero + ", complemento=" + complemento + ", emissao=" + emissao + ", validade="
				+ validade + ", observacoes=" + observacoes + "]";
	}

	public void alterar(DocumentoTO documentoTO) {
		this.pessoa = documentoTO.getPessoa();
		this.tipo = documentoTO.getTipo();
		//FIXME this.orgaoEmissor = documentoTO.getOrgaoEmissor();
		this.numero = documentoTO.getNumero();
		this.complemento = documentoTO.getComplemento();
		this.emissao = documentoTO.getEmissao();
		this.validade = documentoTO.getValidade();
		this.observacoes = documentoTO.getObservacoes();
	}

}