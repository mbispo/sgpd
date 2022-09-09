package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:04
 */
@Entity
@Auditavel
@Cacheable
public class SolicitacaoAproveitamentoLaudoJuntaMedica implements Serializable {

	private static final long serialVersionUID = -3419307823067067872L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoAproveitamento solicitacao;

	private Boolean favoravel;
	private Date data;
	private Date dataFimValidade;
	private Integer idDocumentoGerdoc;
	
	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] integra;

	public SolicitacaoAproveitamentoLaudoJuntaMedica() {
		super();
	}

	public SolicitacaoAproveitamentoLaudoJuntaMedica(Long id, SolicitacaoAproveitamento solicitacao, Boolean favoravel,
			Date data, Date dataFimValidade, Integer idDocumentoGerdoc, byte[] integra) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.favoravel = favoravel;
		this.data = data;
		this.dataFimValidade = dataFimValidade;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
		this.integra = integra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SolicitacaoAproveitamento getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoAproveitamento solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Boolean getFavoravel() {
		return favoravel;
	}

	public void setFavoravel(Boolean favoravel) {
		this.favoravel = favoravel;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataFimValidade() {
		return dataFimValidade;
	}

	public void setDataFimValidade(Date dataFimValidade) {
		this.dataFimValidade = dataFimValidade;
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
		SolicitacaoAproveitamentoLaudoJuntaMedica other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoAproveitamentoLaudoJuntaMedica [id=" + id + ", solicitacao=" + solicitacao + ", favoravel="
				+ favoravel + ", data=" + data + ", dataFimValidade=" + dataFimValidade + ", idDocumentoGerdoc="
				+ idDocumentoGerdoc + ", integra=" + Arrays.toString(integra) + "]";
	}

}