package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:59
 */
@Entity
@Auditavel
@Cacheable
public class DocumentoAnexoRequerimentoCancelamentoAuxilioEducacaoInfantil implements Serializable {

	private static final long serialVersionUID = 8232108668626415590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "requerimento_id", nullable = false)
	private RequerimentoCancelamentoAuxilioEducacaoInfantil requerimento;

	@Column(length = 200)
	private String descricao;

	private Integer idDocumentoGerdoc;

	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] integra;

	public DocumentoAnexoRequerimentoCancelamentoAuxilioEducacaoInfantil() {
		super();
	}

	public DocumentoAnexoRequerimentoCancelamentoAuxilioEducacaoInfantil(Long id,
			RequerimentoCancelamentoAuxilioEducacaoInfantil requerimento, String descricao, Integer idDocumentoGerdoc,
			byte[] integra) {
		super();
		this.id = id;
		this.requerimento = requerimento;
		this.descricao = descricao;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
		this.integra = integra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RequerimentoCancelamentoAuxilioEducacaoInfantil getRequerimento() {
		return requerimento;
	}

	public void setRequerimento(RequerimentoCancelamentoAuxilioEducacaoInfantil requerimento) {
		this.requerimento = requerimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		DocumentoAnexoRequerimentoCancelamentoAuxilioEducacaoInfantil other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DocumentoAnexoRequerimentoCancelamentoAuxilioEducacaoInfantil [id=" + id + ", requerimento="
				+ requerimento + ", descricao=" + descricao + ", idDocumentoGerdoc=" + idDocumentoGerdoc + "]";
	}

}