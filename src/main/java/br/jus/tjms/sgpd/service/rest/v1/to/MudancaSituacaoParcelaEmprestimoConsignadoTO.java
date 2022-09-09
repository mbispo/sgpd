package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.SituacaoParcelaEmprestimoConsignado;

public class MudancaSituacaoParcelaEmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long parcelaId;
	private Long emprestimoConsignadoId;
	private SituacaoParcelaEmprestimoConsignado situacao;
	private String observacoes;

	public MudancaSituacaoParcelaEmprestimoConsignadoTO() {
		super();
	}

	public MudancaSituacaoParcelaEmprestimoConsignadoTO(Long parcelaId, Long emprestimoConsignadoId,
			SituacaoParcelaEmprestimoConsignado situacao, String observacoes) {
		super();
		this.parcelaId = parcelaId;
		this.emprestimoConsignadoId = emprestimoConsignadoId;
		this.situacao = situacao;
		this.observacoes = observacoes;
	}

	public Long getParcelaId() {
		return parcelaId;
	}

	public void setParcelaId(Long parcelaId) {
		this.parcelaId = parcelaId;
	}

	public Long getEmprestimoConsignadoId() {
		return emprestimoConsignadoId;
	}

	public void setEmprestimoConsignadoId(Long emprestimoConsignadoId) {
		this.emprestimoConsignadoId = emprestimoConsignadoId;
	}

	public SituacaoParcelaEmprestimoConsignado getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoParcelaEmprestimoConsignado situacao) {
		this.situacao = situacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "MudancaSituacaoParcelaEmprestimoConsignadoTO [parcelaId=" + parcelaId + ", emprestimoConsignadoId="
				+ emprestimoConsignadoId + ", situacao=" + situacao + ", observacoes=" + observacoes + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(parcelaId).toHashCode();
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
		MudancaSituacaoParcelaEmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(parcelaId, other.getParcelaId()).isEquals();
	}

}