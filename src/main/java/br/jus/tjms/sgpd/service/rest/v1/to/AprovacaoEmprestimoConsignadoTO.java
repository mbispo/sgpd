package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.SituacaoAprovacaoEmprestimoConsignado;

public class AprovacaoEmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long funcionarioId;
	private Long simulacaoEmprestimoConsignadoId;
	private Date dataAprovacao;
	private String observacoes;
	private Date dataSituacao;
	private SituacaoAprovacaoEmprestimoConsignado situacao;
	private Boolean notificacaoPendente;

	public AprovacaoEmprestimoConsignadoTO() {
		super();
	}

	public AprovacaoEmprestimoConsignadoTO(Long id, Long funcionarioId, Long simulacaoEmprestimoConsignadoId,
			Date dataAprovacao, String observacoes, Date dataSituacao, SituacaoAprovacaoEmprestimoConsignado situacao,
			Boolean notificacaoPendente) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.simulacaoEmprestimoConsignadoId = simulacaoEmprestimoConsignadoId;
		this.dataAprovacao = dataAprovacao;
		this.observacoes = observacoes;
		this.dataSituacao = dataSituacao;
		this.situacao = situacao;
		this.notificacaoPendente = notificacaoPendente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Long getSimulacaoEmprestimoConsignadoId() {
		return simulacaoEmprestimoConsignadoId;
	}

	public void setSimulacaoEmprestimoConsignadoId(Long simulacaoEmprestimoConsignadoId) {
		this.simulacaoEmprestimoConsignadoId = simulacaoEmprestimoConsignadoId;
	}

	public Date getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(Date dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoAprovacaoEmprestimoConsignado getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAprovacaoEmprestimoConsignado situacao) {
		this.situacao = situacao;
	}

	public Boolean getNotificacaoPendente() {
		return notificacaoPendente;
	}

	public void setNotificacaoPendente(Boolean notificacaoPendente) {
		this.notificacaoPendente = notificacaoPendente;
	}

	@Override
	public String toString() {
		return "AprovacaoEmprestimoConsignadoTO [id=" + id + ", funcionarioId=" + funcionarioId
				+ ", simulacaoEmprestimoConsignadoId=" + simulacaoEmprestimoConsignadoId + ", dataAprovacao="
				+ dataAprovacao + ", observacoes=" + observacoes + ", dataSituacao=" + dataSituacao + ", situacao="
				+ situacao + ", notificacaoPendente=" + notificacaoPendente + "]";
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
		AprovacaoEmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}