package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoEmprestimoConsignado;

public class SolicitacaoEmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long funcionarioId;
	private TipoEmprestimoConsignado tipo;
	private List<RelacaoSolicitacaoEmprestimoTO> emprestimosRelacionados = new ArrayList<RelacaoSolicitacaoEmprestimoTO>();
	private Date dataSolicitacao;
	private Integer validade;
	private Integer numeroParcelasMin;
	private Integer numeroParcelasMax;
	private Double valorParcelaMin;
	private Double valorParcelaMax;
	private Integer valorEmprestimoMax;
	private Double valorEmprestimoMin;
	private Date primeiroVencimento;
	private Boolean aberto;
	private String observacoes;

	public SolicitacaoEmprestimoConsignadoTO() {
		super();
	}

	public SolicitacaoEmprestimoConsignadoTO(Long id, Long funcionarioId, TipoEmprestimoConsignado tipo,
			List<RelacaoSolicitacaoEmprestimoTO> emprestimosRelacionados, Date dataSolicitacao, Integer validade,
			Integer numeroParcelasMin, Integer numeroParcelasMax, Double valorParcelaMin, Double valorParcelaMax,
			Integer valorEmprestimoMax, Double valorEmprestimoMin, Date primeiroVencimento, Boolean aberto,
			String observacoes) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.tipo = tipo;
		this.emprestimosRelacionados = emprestimosRelacionados;
		this.dataSolicitacao = dataSolicitacao;
		this.validade = validade;
		this.numeroParcelasMin = numeroParcelasMin;
		this.numeroParcelasMax = numeroParcelasMax;
		this.valorParcelaMin = valorParcelaMin;
		this.valorParcelaMax = valorParcelaMax;
		this.valorEmprestimoMax = valorEmprestimoMax;
		this.valorEmprestimoMin = valorEmprestimoMin;
		this.primeiroVencimento = primeiroVencimento;
		this.aberto = aberto;
		this.observacoes = observacoes;
	}

	public SolicitacaoEmprestimoConsignadoTO(Long funcionarioId, TipoEmprestimoConsignado tipo,
			List<RelacaoSolicitacaoEmprestimoTO> emprestimosRelacionados, Date dataSolicitacao, Integer validade,
			Integer numeroParcelasMin, Integer numeroParcelasMax, Double valorParcelaMin, Double valorParcelaMax,
			Integer valorEmprestimoMax, Double valorEmprestimoMin, Date primeiroVencimento, Boolean aberto,
			String observacoes) {
		super();
		this.funcionarioId = funcionarioId;
		this.tipo = tipo;
		this.emprestimosRelacionados = emprestimosRelacionados;
		this.dataSolicitacao = dataSolicitacao;
		this.validade = validade;
		this.numeroParcelasMin = numeroParcelasMin;
		this.numeroParcelasMax = numeroParcelasMax;
		this.valorParcelaMin = valorParcelaMin;
		this.valorParcelaMax = valorParcelaMax;
		this.valorEmprestimoMax = valorEmprestimoMax;
		this.valorEmprestimoMin = valorEmprestimoMin;
		this.primeiroVencimento = primeiroVencimento;
		this.aberto = aberto;
		this.observacoes = observacoes;
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

	public TipoEmprestimoConsignado getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmprestimoConsignado tipo) {
		this.tipo = tipo;
	}

	public List<RelacaoSolicitacaoEmprestimoTO> getEmprestimosRelacionados() {
		return emprestimosRelacionados;
	}

	public void setEmprestimosRelacionados(List<RelacaoSolicitacaoEmprestimoTO> emprestimosRelacionados) {
		this.emprestimosRelacionados = emprestimosRelacionados;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Integer getValidade() {
		return validade;
	}

	public void setValidade(Integer validade) {
		this.validade = validade;
	}

	public Integer getNumeroParcelasMin() {
		return numeroParcelasMin;
	}

	public void setNumeroParcelasMin(Integer numeroParcelasMin) {
		this.numeroParcelasMin = numeroParcelasMin;
	}

	public Integer getNumeroParcelasMax() {
		return numeroParcelasMax;
	}

	public void setNumeroParcelasMax(Integer numeroParcelasMax) {
		this.numeroParcelasMax = numeroParcelasMax;
	}

	public Double getValorParcelaMin() {
		return valorParcelaMin;
	}

	public void setValorParcelaMin(Double valorParcelaMin) {
		this.valorParcelaMin = valorParcelaMin;
	}

	public Double getValorParcelaMax() {
		return valorParcelaMax;
	}

	public void setValorParcelaMax(Double valorParcelaMax) {
		this.valorParcelaMax = valorParcelaMax;
	}

	public Integer getValorEmprestimoMax() {
		return valorEmprestimoMax;
	}

	public void setValorEmprestimoMax(Integer valorEmprestimoMax) {
		this.valorEmprestimoMax = valorEmprestimoMax;
	}

	public Double getValorEmprestimoMin() {
		return valorEmprestimoMin;
	}

	public void setValorEmprestimoMin(Double valorEmprestimoMin) {
		this.valorEmprestimoMin = valorEmprestimoMin;
	}

	public Date getPrimeiroVencimento() {
		return primeiroVencimento;
	}

	public void setPrimeiroVencimento(Date primeiroVencimento) {
		this.primeiroVencimento = primeiroVencimento;
	}

	public Boolean getAberto() {
		return aberto;
	}

	public void setAberto(Boolean aberto) {
		this.aberto = aberto;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "SolicitacaoEmprestimoConsignadoTO [id=" + id + ", funcionarioId=" + funcionarioId + ", tipo=" + tipo
				+ ", emprestimosRelacionados=" + emprestimosRelacionados + ", dataSolicitacao=" + dataSolicitacao
				+ ", validade=" + validade + ", numeroParcelasMin=" + numeroParcelasMin + ", numeroParcelasMax="
				+ numeroParcelasMax + ", valorParcelaMin=" + valorParcelaMin + ", valorParcelaMax=" + valorParcelaMax
				+ ", valorEmprestimoMax=" + valorEmprestimoMax + ", valorEmprestimoMin=" + valorEmprestimoMin
				+ ", primeiroVencimento=" + primeiroVencimento + ", aberto=" + aberto + ", observacoes=" + observacoes
				+ "]";
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
		SolicitacaoEmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}