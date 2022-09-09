package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoDocumentoAnexoSolicitacaoAposentadoria;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Auditavel
@Cacheable
public class DocumentoAnexoSolicitacaoAposentadoria implements Serializable {

	private static final long serialVersionUID = -1876153506468095337L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoAposentadoria solicitacao;

	@Enumerated(EnumType.ORDINAL)
	private TipoDocumentoAnexoSolicitacaoAposentadoria tipo;

	@ManyToOne
	@JoinColumn(name = "fornecedor_id", nullable = true)
	private Funcionario fornecedor;

	@ManyToOne
	@JoinColumn(name = "juntaMedica_id", nullable = true)
	private JuntaMedica juntaMedica;

	@Column(length = 200)
	private String descricao;

	private int idDocumentoGerdoc;
	
	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] integra;

	public DocumentoAnexoSolicitacaoAposentadoria() {
		super();
	}

	public DocumentoAnexoSolicitacaoAposentadoria(Long id, SolicitacaoAposentadoria solicitacao,
			TipoDocumentoAnexoSolicitacaoAposentadoria tipo, Funcionario fornecedor, JuntaMedica juntaMedica,
			String descricao, int idDocumentoGerdoc, byte[] integra) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.tipo = tipo;
		this.fornecedor = fornecedor;
		this.juntaMedica = juntaMedica;
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

	public SolicitacaoAposentadoria getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoAposentadoria solicitacao) {
		this.solicitacao = solicitacao;
	}

	public TipoDocumentoAnexoSolicitacaoAposentadoria getTipo() {
		return tipo;
	}

	public void setTipo(TipoDocumentoAnexoSolicitacaoAposentadoria tipo) {
		this.tipo = tipo;
	}

	public Funcionario getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Funcionario fornecedor) {
		this.fornecedor = fornecedor;
	}

	public JuntaMedica getJuntaMedica() {
		return juntaMedica;
	}

	public void setJuntaMedica(JuntaMedica juntaMedica) {
		this.juntaMedica = juntaMedica;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdDocumentoGerdoc() {
		return idDocumentoGerdoc;
	}

	public void setIdDocumentoGerdoc(int idDocumentoGerdoc) {
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
		DocumentoAnexoSolicitacaoAposentadoria other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DocumentoAnexoSolicitacaoAposentadoria [id=" + id + ", solicitacao=" + solicitacao + ", tipo=" + tipo
				+ ", fornecedor=" + fornecedor + ", juntaMedica=" + juntaMedica + ", descricao=" + descricao
				+ ", idDocumentoGerdoc=" + idDocumentoGerdoc + ", integra=" + Arrays.toString(integra) + "]";
	}

}