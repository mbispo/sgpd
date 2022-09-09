package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.enumerators.DocumentoTipo;

public class DocumentoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long pessoaId;
	private DocumentoTipo tipo;
	private OrgaoEmissorTO orgaoEmissor;
	private String numero;
	private String complemento;
	private Date emissao;
	private Date validade;
	private String observacoes;
	private Pessoa pessoa;

	public DocumentoTO() {
		super();
	}

	public DocumentoTO(Long id, DocumentoTipo tipo, OrgaoEmissorTO orgaoEmissor, String numero, String complemento,
			Date emissao, Date validade, String observacoes) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.orgaoEmissor = orgaoEmissor;
		this.numero = numero;
		this.complemento = complemento;
		this.emissao = emissao;
		this.validade = validade;
		this.observacoes = observacoes;
	}

	public DocumentoTO(DocumentoTipo tipo, OrgaoEmissorTO orgaoEmissor, String numero, String complemento,
			Date emissao, Date validade, String observacoes) {
		super();
		this.tipo = tipo;
		this.orgaoEmissor = orgaoEmissor;
		this.numero = numero;
		this.complemento = complemento;
		this.emissao = emissao;
		this.validade = validade;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
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

	public OrgaoEmissorTO getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(OrgaoEmissorTO orgaoEmissor) {
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
	public String toString() {
		return "DocumentoTO [id=" + id + ", tipo=" + tipo + ", orgaoEmissor=" + orgaoEmissor + ", numero=" + numero
				+ ", complemento=" + complemento + ", emissao=" + emissao + ", validade=" + validade + ", observacoes="
				+ observacoes + "]";
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
		DocumentoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}
