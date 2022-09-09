package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoAdicionalInsalubridade;
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
public class SolicitacaoAdicionalInsalubridade implements Serializable {

	private static final long serialVersionUID = -4712909323665044981L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	private Date dataSolicitacao;

	@Column(length = 500)
	private String motivo;

	@Column(length = 60)
	private String processo;

	private Double percentual;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoAdicionalInsalubridade situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoAdicionalInsalubridade() {
		super();
	}

	public SolicitacaoAdicionalInsalubridade(Long id, Funcionario solicitante, Date dataSolicitacao, String motivo,
			String processo, Double percentual, SituacaoSolicitacaoAdicionalInsalubridade situacao, Date dataSituacao,
			String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.dataSolicitacao = dataSolicitacao;
		this.motivo = motivo;
		this.processo = processo;
		this.percentual = percentual;
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

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public SituacaoSolicitacaoAdicionalInsalubridade getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoAdicionalInsalubridade situacao) {
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
		SolicitacaoAdicionalInsalubridade other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoAdicionalInsalubridade [id=" + id + ", solicitante=" + solicitante + ", dataSolicitacao="
				+ dataSolicitacao + ", motivo=" + motivo + ", processo=" + processo + ", percentual=" + percentual
				+ ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}