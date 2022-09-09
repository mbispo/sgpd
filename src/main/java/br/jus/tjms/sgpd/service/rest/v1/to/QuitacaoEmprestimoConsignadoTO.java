package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class QuitacaoEmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long emprestimoConsignadoId;
	private Date dataQuitacao;
	private Double valorQuitacao;
	private String observacoes;

	public QuitacaoEmprestimoConsignadoTO() {
		super();
	}

	public QuitacaoEmprestimoConsignadoTO(Long emprestimoConsignadoId, Date dataQuitacao, Double valorQuitacao,
			String observacoes) {
		super();
		this.emprestimoConsignadoId = emprestimoConsignadoId;
		this.dataQuitacao = dataQuitacao;
		this.valorQuitacao = valorQuitacao;
		this.observacoes = observacoes;
	}

	public Long getEmprestimoConsignadoId() {
		return emprestimoConsignadoId;
	}

	public void setEmprestimoConsignadoId(Long emprestimoConsignadoId) {
		this.emprestimoConsignadoId = emprestimoConsignadoId;
	}

	public Date getDataQuitacao() {
		return dataQuitacao;
	}

	public void setDataQuitacao(Date dataQuitacao) {
		this.dataQuitacao = dataQuitacao;
	}

	public Double getValorQuitacao() {
		return valorQuitacao;
	}

	public void setValorQuitacao(Double valorQuitacao) {
		this.valorQuitacao = valorQuitacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "QuitacaoEmprestimoConsignadoTO [emprestimoConsignadoId=" + emprestimoConsignadoId + ", dataQuitacao="
				+ dataQuitacao + ", valorQuitacao=" + valorQuitacao + ", observacoes=" + observacoes + "]";
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
		QuitacaoEmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(emprestimoConsignadoId, other.getEmprestimoConsignadoId()).isEquals();
	}

}