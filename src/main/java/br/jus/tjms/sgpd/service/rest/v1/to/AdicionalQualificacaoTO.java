package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoAdicionalQualificacao;

public class AdicionalQualificacaoTO implements Serializable {

	private static final long serialVersionUID = -5666694901443352985L;
	
	private Long idFuncionario;
	private Date dataSolicitacao;
	private Date dataSituacao;
	private SituacaoSolicitacaoAdicionalQualificacao situacao;
	private String observacoes;

	public AdicionalQualificacaoTO() {
		super();
	}
	

	public AdicionalQualificacaoTO(Long idFuncionario, Date dataSolicitacao, Date dataSituacao, SituacaoSolicitacaoAdicionalQualificacao situacao, String observacoes) {
		super();
		this.idFuncionario = idFuncionario;
		this.dataSolicitacao = dataSolicitacao;
		this.dataSituacao = dataSituacao;
		this.situacao = situacao;
		this.observacoes = observacoes;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}


	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public SituacaoSolicitacaoAdicionalQualificacao getSituacao() {
		return situacao;
	}


	public void setSituacao(SituacaoSolicitacaoAdicionalQualificacao situacao) {
		this.situacao = situacao;
	}


	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSolicitacao == null) ? 0 : dataSolicitacao.hashCode());
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdicionalQualificacaoTO other = (AdicionalQualificacaoTO) obj;
		if (dataSolicitacao == null) {
			if (other.dataSolicitacao != null)
				return false;
		} else if (!dataSolicitacao.equals(other.dataSolicitacao))
			return false;
		if (idFuncionario == null) {
			if (other.idFuncionario != null)
				return false;
		} else if (!idFuncionario.equals(other.idFuncionario))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AdicionalQualificacaoTO [idFuncionario=" + idFuncionario + ", dataSolicitacao=" + dataSolicitacao
				+ ", situacao=" + situacao + ", observacoes=" + observacoes + "]";
	}

}