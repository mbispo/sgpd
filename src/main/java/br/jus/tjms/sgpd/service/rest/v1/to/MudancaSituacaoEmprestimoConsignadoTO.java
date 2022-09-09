package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.SituacaoEmprestimoConsignado;

public class MudancaSituacaoEmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long emprestimoConsignadoId;
	private String observacoes;
	private SituacaoEmprestimoConsignado novaSituacao;
	private Date data;
	private String parecer;

	public MudancaSituacaoEmprestimoConsignadoTO() {
		super();
	}

	public MudancaSituacaoEmprestimoConsignadoTO(Long emprestimoConsignadoId, String observacoes,
			SituacaoEmprestimoConsignado novaSituacao, Date data, String parecer) {
		super();
		this.emprestimoConsignadoId = emprestimoConsignadoId;
		this.observacoes = observacoes;
		this.novaSituacao = novaSituacao;
		this.data = data;
		this.parecer = parecer;
	}

	public Long getEmprestimoConsignadoId() {
		return emprestimoConsignadoId;
	}

	public void setEmprestimoConsignadoId(Long emprestimoConsignadoId) {
		this.emprestimoConsignadoId = emprestimoConsignadoId;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public SituacaoEmprestimoConsignado getNovaSituacao() {
		return novaSituacao;
	}

	public void setNovaSituacao(SituacaoEmprestimoConsignado novaSituacao) {
		this.novaSituacao = novaSituacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	@Override
	public String toString() {
		return "MudancaSituacaoEmprestimoConsignadoTO [emprestimoConsignadoId=" + emprestimoConsignadoId
				+ ", observacoes=" + observacoes + ", novaSituacao=" + novaSituacao + ", data=" + data + ", parecer="
				+ parecer + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(emprestimoConsignadoId).toHashCode();
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
		MudancaSituacaoEmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(emprestimoConsignadoId, other.getEmprestimoConsignadoId()).isEquals();
	}

}