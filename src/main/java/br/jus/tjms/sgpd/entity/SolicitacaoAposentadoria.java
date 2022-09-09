package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoAposentadoria;
import br.jus.tjms.sgpd.enumerators.TipoSolicitacaoAposentadoria;
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
public class SolicitacaoAposentadoria implements Serializable {

	private static final long serialVersionUID = -1185812607340786250L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@ManyToOne
	@JoinColumn(name = "solicitado_id", nullable = false)
	private Funcionario solicitado;

	private Date dataSolicitacao;

	@Enumerated(EnumType.ORDINAL)
	private TipoSolicitacaoAposentadoria tipoSolicitacaoAposentadoria;

	private Boolean declaraCienciaNecessidadeRecadastroAnual;
	private Boolean declaraNaoAcumularCargoComproventosAposentadoria;

	@Column(length = 500)
	private String observacoes;

	@Column(length = 60)
	private String processo;

	private Date dataSituacao;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoAposentadoria situacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoAposentadoria() {
		super();
	}

	public SolicitacaoAposentadoria(Long id, Funcionario solicitante, Funcionario solicitado, Date dataSolicitacao,
			TipoSolicitacaoAposentadoria tipoSolicitacaoAposentadoria,
			Boolean declaraCienciaNecessidadeRecadastroAnual, Boolean declaraNaoAcumularCargoComproventosAposentadoria,
			String observacoes, String processo, Date dataSituacao, SituacaoSolicitacaoAposentadoria situacao,
			String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.solicitado = solicitado;
		this.dataSolicitacao = dataSolicitacao;
		this.tipoSolicitacaoAposentadoria = tipoSolicitacaoAposentadoria;
		this.declaraCienciaNecessidadeRecadastroAnual = declaraCienciaNecessidadeRecadastroAnual;
		this.declaraNaoAcumularCargoComproventosAposentadoria = declaraNaoAcumularCargoComproventosAposentadoria;
		this.observacoes = observacoes;
		this.processo = processo;
		this.dataSituacao = dataSituacao;
		this.situacao = situacao;
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

	public Funcionario getSolicitado() {
		return solicitado;
	}

	public void setSolicitado(Funcionario solicitado) {
		this.solicitado = solicitado;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public TipoSolicitacaoAposentadoria getTipoSolicitacaoAposentadoria() {
		return tipoSolicitacaoAposentadoria;
	}

	public void setTipoSolicitacaoAposentadoria(TipoSolicitacaoAposentadoria tipoSolicitacaoAposentadoria) {
		this.tipoSolicitacaoAposentadoria = tipoSolicitacaoAposentadoria;
	}

	public Boolean getDeclaraCienciaNecessidadeRecadastroAnual() {
		return declaraCienciaNecessidadeRecadastroAnual;
	}

	public void setDeclaraCienciaNecessidadeRecadastroAnual(Boolean declaraCienciaNecessidadeRecadastroAnual) {
		this.declaraCienciaNecessidadeRecadastroAnual = declaraCienciaNecessidadeRecadastroAnual;
	}

	public Boolean getDeclaraNaoAcumularCargoComproventosAposentadoria() {
		return declaraNaoAcumularCargoComproventosAposentadoria;
	}

	public void setDeclaraNaoAcumularCargoComproventosAposentadoria(
			Boolean declaraNaoAcumularCargoComproventosAposentadoria) {
		this.declaraNaoAcumularCargoComproventosAposentadoria = declaraNaoAcumularCargoComproventosAposentadoria;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoSolicitacaoAposentadoria getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoAposentadoria situacao) {
		this.situacao = situacao;
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
		SolicitacaoAposentadoria other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoAposentadoria [id=" + id + ", solicitante=" + solicitante + ", solicitado=" + solicitado
				+ ", dataSolicitacao=" + dataSolicitacao + ", tipoSolicitacaoAposentadoria="
				+ tipoSolicitacaoAposentadoria + ", declaraCienciaNecessidadeRecadastroAnual="
				+ declaraCienciaNecessidadeRecadastroAnual + ", declaraNaoAcumularCargoComproventosAposentadoria="
				+ declaraNaoAcumularCargoComproventosAposentadoria + ", observacoes=" + observacoes + ", processo="
				+ processo + ", dataSituacao=" + dataSituacao + ", situacao=" + situacao + ", parecer=" + parecer + "]";
	}

}