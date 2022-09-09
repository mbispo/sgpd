package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.MotivoReconducao;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoReconducao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:05
 */
@Entity
@Auditavel
@Cacheable
public class SolicitacaoReconducao implements Serializable {

	private static final long serialVersionUID = -3565903759547724408L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@Enumerated(EnumType.ORDINAL)
	private MotivoReconducao motivo;

	@Column(length = 60)
	private String processo;

	@ManyToOne
	@JoinColumn(name = "reintegracaoRelacionada_id", nullable = true)
	private Reintegracao reintegracaoRelacionada;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoReconducao situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoReconducao() {
		super();
	}

	public SolicitacaoReconducao(Long id, Funcionario funcionario, Funcionario solicitante, MotivoReconducao motivo,
			String processo, Reintegracao reintegracaoRelacionada, SituacaoSolicitacaoReconducao situacao,
			Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.solicitante = solicitante;
		this.motivo = motivo;
		this.processo = processo;
		this.reintegracaoRelacionada = reintegracaoRelacionada;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Funcionario solicitante) {
		this.solicitante = solicitante;
	}

	public MotivoReconducao getMotivo() {
		return motivo;
	}

	public void setMotivo(MotivoReconducao motivo) {
		this.motivo = motivo;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Reintegracao getReintegracaoRelacionada() {
		return reintegracaoRelacionada;
	}

	public void setReintegracaoRelacionada(Reintegracao reintegracaoRelacionada) {
		this.reintegracaoRelacionada = reintegracaoRelacionada;
	}

	public SituacaoSolicitacaoReconducao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoReconducao situacao) {
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
		SolicitacaoReconducao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoReconducao [id=" + id + ", funcionario=" + funcionario + ", solicitante=" + solicitante
				+ ", motivo=" + motivo + ", processo=" + processo + ", reintegracaoRelacionada="
				+ reintegracaoRelacionada + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer="
				+ parecer + "]";
	}

}