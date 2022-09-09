package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoDesignacaoTempoIntegral;
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
public class SolicitacaoDesignacaoTempoIntegral implements Serializable {

	private static final long serialVersionUID = -3057262801899549093L;

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

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoDesignacaoTempoIntegral situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoDesignacaoTempoIntegral() {
		super();
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

	public SituacaoSolicitacaoDesignacaoTempoIntegral getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoDesignacaoTempoIntegral situacao) {
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
		SolicitacaoDesignacaoTempoIntegral other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoDesignacaoTempoIntegral [id=" + id + ", solicitante=" + solicitante + ", dataSolicitacao="
				+ dataSolicitacao + ", motivo=" + motivo + ", processo=" + processo + ", situacao=" + situacao
				+ ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}