package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
public class CertidaoTempoContribuicao implements Serializable {

	private static final long serialVersionUID = 6266101462352353153L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoCertidaoTempoContribuicao solicitacao;

	private Date dataEmissao;
	private Date dataValidade;

	@Column(length = 200)
	private String codigoVerificacao;

	private Integer idDocumentoGerdoc;

	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] integra;

	public CertidaoTempoContribuicao() {
		super();
	}

	public CertidaoTempoContribuicao(Long id, Funcionario funcionario,
			SolicitacaoCertidaoTempoContribuicao solicitacao, Date dataEmissao, Date dataValidade,
			String codigoVerificacao, Integer idDocumentoGerdoc, byte[] integra) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.solicitacao = solicitacao;
		this.dataEmissao = dataEmissao;
		this.dataValidade = dataValidade;
		this.codigoVerificacao = codigoVerificacao;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
		this.integra = integra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public SolicitacaoCertidaoTempoContribuicao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoCertidaoTempoContribuicao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getCodigoVerificacao() {
		return codigoVerificacao;
	}

	public void setCodigoVerificacao(String codigoVerificacao) {
		this.codigoVerificacao = codigoVerificacao;
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
		CertidaoTempoContribuicao other = (CertidaoTempoContribuicao) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CertidaoTempoContribuicao [id=" + id + ", funcionario=" + funcionario + ", solicitacao=" + solicitacao
				+ ", dataEmissao=" + dataEmissao + ", dataValidade=" + dataValidade + ", codigoVerificacao="
				+ codigoVerificacao + ", idDocumentoGerdoc=" + idDocumentoGerdoc + "]";
	}

}