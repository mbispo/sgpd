package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoDocumentoAnexoSolicitacaoLicenca;
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
public class DocumentoAnexoSolicitacaoLicenca implements Serializable {

	private static final long serialVersionUID = -2109686358256081746L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoLicenca solicitacao;

	@Enumerated(EnumType.ORDINAL)
	private TipoDocumentoAnexoSolicitacaoLicenca tipoDocumento;

	@Column(length = 200)
	private String descricao;

	private Integer idDocumentoGerdoc;
	
	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] integra;

	@ManyToOne
	@JoinColumn(name = "fornecedor_id", nullable = true)
	private Pessoa fornecedor;

	public DocumentoAnexoSolicitacaoLicenca() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SolicitacaoLicenca getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoLicenca solicitacao) {
		this.solicitacao = solicitacao;
	}

	public TipoDocumentoAnexoSolicitacaoLicenca getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoAnexoSolicitacaoLicenca tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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

	public Pessoa getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Pessoa fornecedor) {
		this.fornecedor = fornecedor;
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
		DocumentoAnexoSolicitacaoLicenca other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DocumentoAnexoSolicitacaoLicenca [id=" + id + ", solicitacao=" + solicitacao + ", tipoDocumento="
				+ tipoDocumento + ", descricao=" + descricao + ", idDocumentoGerdoc=" + idDocumentoGerdoc
				+ ", fornecedor=" + fornecedor + "]";
	}

}