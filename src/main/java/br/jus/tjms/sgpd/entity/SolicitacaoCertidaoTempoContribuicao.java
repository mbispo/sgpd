package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoCertidaoTempoContribuicao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:04
 */
@Entity
@Auditavel
@Cacheable
public class SolicitacaoCertidaoTempoContribuicao implements Serializable {

	private static final long serialVersionUID = -7164337811838707687L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@Column(length = 500)
	private String motivo;

	private Date dataSolicitacao;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoCertidaoTempoContribuicao situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoCertidaoTempoContribuicao() {
		super();
	}

	public SolicitacaoCertidaoTempoContribuicao(Long id, Funcionario solicitante, String motivo, Date dataSolicitacao,
			SituacaoSolicitacaoCertidaoTempoContribuicao situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.motivo = motivo;
		this.dataSolicitacao = dataSolicitacao;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Funcionario solicitante) {
		this.solicitante = solicitante;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public SituacaoSolicitacaoCertidaoTempoContribuicao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoCertidaoTempoContribuicao situacao) {
		this.situacao = situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
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
		SolicitacaoCertidaoTempoContribuicao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoCertidaoTempoContribuicao [id=" + id + ", solicitante=" + solicitante + ", motivo=" + motivo
				+ ", dataSolicitacao=" + dataSolicitacao + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao
				+ ", parecer=" + parecer + "]";
	}

}