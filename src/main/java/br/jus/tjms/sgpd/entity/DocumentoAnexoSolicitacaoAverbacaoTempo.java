package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoDocumentoAnexoSolicitacaoAverbacaoTempo;
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
public class DocumentoAnexoSolicitacaoAverbacaoTempo implements Serializable {

	private static final long serialVersionUID = -3796953733369049426L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoAverbacaoTempo solicitacao;

	@ManyToOne
	@JoinColumn(name = "fornecedor_id", nullable = false)
	private Funcionario fornecedor;

	@Enumerated(EnumType.ORDINAL)
	private TipoDocumentoAnexoSolicitacaoAverbacaoTempo tipoDocumento;

	@Column(length = 200)
	private String descricao;

	private Integer idDocumentoGerdoc;

	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] integra;

	public DocumentoAnexoSolicitacaoAverbacaoTempo() {
		super();
	}

	public DocumentoAnexoSolicitacaoAverbacaoTempo(Long id, SolicitacaoAverbacaoTempo solicitacao,
			Funcionario fornecedor, TipoDocumentoAnexoSolicitacaoAverbacaoTempo tipoDocumento, String descricao,
			Integer idDocumentoGerdoc, byte[] integra) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.fornecedor = fornecedor;
		this.tipoDocumento = tipoDocumento;
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

	public SolicitacaoAverbacaoTempo getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoAverbacaoTempo solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Funcionario getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Funcionario fornecedor) {
		this.fornecedor = fornecedor;
	}

	public TipoDocumentoAnexoSolicitacaoAverbacaoTempo getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoAnexoSolicitacaoAverbacaoTempo tipoDocumento) {
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
		DocumentoAnexoSolicitacaoAverbacaoTempo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DocumentoAnexoSolicitacaoAverbacaoTempo [id=" + id + ", solicitacao=" + solicitacao + ", fornecedor="
				+ fornecedor + ", tipoDocumento=" + tipoDocumento + ", descricao=" + descricao + ", idDocumentoGerdoc="
				+ idDocumentoGerdoc + "]";
	}

}