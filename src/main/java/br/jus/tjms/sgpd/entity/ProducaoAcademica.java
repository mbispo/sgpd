package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
public class ProducaoAcademica implements Serializable {

	private static final long serialVersionUID = 6681086031680601812L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoaFormacao_id", nullable = false)
	private PessoaFormacao pessoaFormacao;

	private Date dataPublicacao;

	private Integer idDocumentoGerdoc;

	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] integra;

	@Column(length = 255)
	private String url;

	@Column(length = 200)
	private String descricao;

	public ProducaoAcademica() {
		super();
	}

	public ProducaoAcademica(Long id, PessoaFormacao pessoaFormacao, Date dataPublicacao, Integer idDocumentoGerdoc,
			byte[] integra, String url, String descricao) {
		super();
		this.id = id;
		this.pessoaFormacao = pessoaFormacao;
		this.dataPublicacao = dataPublicacao;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
		this.integra = integra;
		this.url = url;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PessoaFormacao getPessoaFormacao() {
		return pessoaFormacao;
	}

	public void setPessoaFormacao(PessoaFormacao pessoaFormacao) {
		this.pessoaFormacao = pessoaFormacao;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public byte[] getIntegra() {
		return integra;
	}

	public void setIntegra(byte[] integra) {
		this.integra = integra;
	}

	public Integer getIdDocumentoGerdoc() {
		return idDocumentoGerdoc;
	}

	public void setIdDocumentoGerdoc(Integer idDocumentoGerdoc) {
		this.idDocumentoGerdoc = idDocumentoGerdoc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		ProducaoAcademica other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ProducaoAcademica [id=" + id + ", pessoaFormacao=" + pessoaFormacao + ", dataPublicacao="
				+ dataPublicacao + ", idDocumentoGerdoc=" + idDocumentoGerdoc + ", url=" + url + ", descricao="
				+ descricao + "]";
	}

}