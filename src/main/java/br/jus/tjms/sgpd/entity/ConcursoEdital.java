package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class ConcursoEdital implements Serializable {

	private static final long serialVersionUID = -3321893326080395057L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "concurso_id", nullable = false)
	private Concurso concurso;

	@Column(length = 200)
	private String descricao;

	private Date dataPublicacao;

	@Column(length = 200)
	private String assunto;

	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] integra;

	private Integer idDocumentoDerdoc;

	public ConcursoEdital() {
		super();
	}

	public ConcursoEdital(Long id, Concurso concurso, String descricao, Date dataPublicacao, String assunto,
			byte[] integra, Integer idDocumentoDerdoc) {
		super();
		this.id = id;
		this.concurso = concurso;
		this.descricao = descricao;
		this.dataPublicacao = dataPublicacao;
		this.assunto = assunto;
		this.integra = integra;
		this.idDocumentoDerdoc = idDocumentoDerdoc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public byte[] getIntegra() {
		return integra;
	}

	public void setIntegra(byte[] integra) {
		this.integra = integra;
	}

	public Integer getIdDocumentoDerdoc() {
		return idDocumentoDerdoc;
	}

	public void setIdDocumentoDerdoc(Integer idDocumentoDerdoc) {
		this.idDocumentoDerdoc = idDocumentoDerdoc;
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
		ConcursoEdital other = (ConcursoEdital) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcursoEdital [id=" + id + ", concurso=" + concurso + ", descricao=" + descricao + ", dataPublicacao="
				+ dataPublicacao + ", assunto=" + assunto + ", idDocumentoDerdoc=" + idDocumentoDerdoc + "]";
	}

}