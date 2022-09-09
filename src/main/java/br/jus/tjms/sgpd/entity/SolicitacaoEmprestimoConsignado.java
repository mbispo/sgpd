package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoEmprestimoConsignado;
import br.jus.tjms.sgpd.service.rest.v1.to.SolicitacaoEmprestimoConsignadoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:04
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "solicitacaoEmprestimoConsignado.buscarSolicitacaoesPorFuncionario", 
			query = "SELECT s from SolicitacaoEmprestimoConsignado s WHERE s.funcionario.id = :funcionarioId")
})
public class SolicitacaoEmprestimoConsignado implements Serializable {

	private static final long serialVersionUID = 3430572308271250013L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@Enumerated(EnumType.ORDINAL)
	private TipoEmprestimoConsignado tipo;
	
	@OneToMany(mappedBy = "solicitacao", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RelacaoSolicitacaoEmprestimo> emprestimosRelacionados = new ArrayList<RelacaoSolicitacaoEmprestimo>();	

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

	@Column(length = 500)
	private String observacoes;

	public SolicitacaoEmprestimoConsignado() {
		super();
	}

	public SolicitacaoEmprestimoConsignado(Long id, Funcionario funcionario, TipoEmprestimoConsignado tipo,
			List<RelacaoSolicitacaoEmprestimo> emprestimosRelacionados,
			Date dataSolicitacao, Integer validade, Integer numeroParcelasMin, Integer numeroParcelasMax,
			Double valorParcelaMin, Double valorParcelaMax, Integer valorEmprestimoMax, Double valorEmprestimoMin,
			Date primeiroVencimento, Boolean aberto, String observacoes) {
		super();
		this.id = id;
		this.funcionario = funcionario;
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

	public SolicitacaoEmprestimoConsignado(SolicitacaoEmprestimoConsignadoTO solicitacaoEmprestimoConsignadoTO) {
		//FIXME this.funcionario = solicitacaoEmprestimoConsignadoTO.getFuncionarioId();
		this.tipo = solicitacaoEmprestimoConsignadoTO.getTipo();
		//FIXME this.emprestimosRelacionados = solicitacaoEmprestimoConsignadoTO.getEmprestimosRelacionados();
		this.dataSolicitacao = solicitacaoEmprestimoConsignadoTO.getDataSolicitacao();
		this.validade = solicitacaoEmprestimoConsignadoTO.getValidade();
		this.numeroParcelasMin = solicitacaoEmprestimoConsignadoTO.getNumeroParcelasMin();
		this.numeroParcelasMax = solicitacaoEmprestimoConsignadoTO.getNumeroParcelasMax();
		this.valorParcelaMin = solicitacaoEmprestimoConsignadoTO.getValorParcelaMin();
		this.valorParcelaMax = solicitacaoEmprestimoConsignadoTO.getValorParcelaMax();
		this.valorEmprestimoMax = solicitacaoEmprestimoConsignadoTO.getValorEmprestimoMax();
		this.valorEmprestimoMin = solicitacaoEmprestimoConsignadoTO.getValorEmprestimoMin();
		this.primeiroVencimento = solicitacaoEmprestimoConsignadoTO.getPrimeiroVencimento();
		this.aberto = solicitacaoEmprestimoConsignadoTO.getAberto();
		this.observacoes = solicitacaoEmprestimoConsignadoTO.getObservacoes();
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

	public TipoEmprestimoConsignado getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmprestimoConsignado tipo) {
		this.tipo = tipo;
	}

	public List<RelacaoSolicitacaoEmprestimo> getEmprestimosRelacionados() {
		return emprestimosRelacionados;
	}

	public void setEmprestimosRelacionados(List<RelacaoSolicitacaoEmprestimo> emprestimosRelacionados) {
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
		SolicitacaoEmprestimoConsignado other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoEmprestimoConsignado [id=" + id + ", funcionario=" + funcionario + ", tipo=" + tipo
				+ ", dataSolicitacao=" + dataSolicitacao + ", validade=" + validade + ", numeroParcelasMin="
				+ numeroParcelasMin + ", numeroParcelasMax=" + numeroParcelasMax + ", valorParcelaMin="
				+ valorParcelaMin + ", valorParcelaMax=" + valorParcelaMax + ", valorEmprestimoMax="
				+ valorEmprestimoMax + ", valorEmprestimoMin=" + valorEmprestimoMin + ", primeiroVencimento="
				+ primeiroVencimento + ", aberto=" + aberto + ", observacoes=" + observacoes + "]";
	}

	public void altarar(SolicitacaoEmprestimoConsignadoTO solicitacaoEmprestimoConsignadoTO) {
		//FIXME this.funcionario = solicitacaoEmprestimoConsignadoTO.getFuncionarioId();
		this.tipo = solicitacaoEmprestimoConsignadoTO.getTipo();
		//FIXME this.emprestimosRelacionados = solicitacaoEmprestimoConsignadoTO.getEmprestimosRelacionados();
		this.dataSolicitacao = solicitacaoEmprestimoConsignadoTO.getDataSolicitacao();
		this.validade = solicitacaoEmprestimoConsignadoTO.getValidade();
		this.numeroParcelasMin = solicitacaoEmprestimoConsignadoTO.getNumeroParcelasMin();
		this.numeroParcelasMax = solicitacaoEmprestimoConsignadoTO.getNumeroParcelasMax();
		this.valorParcelaMin = solicitacaoEmprestimoConsignadoTO.getValorParcelaMin();
		this.valorParcelaMax = solicitacaoEmprestimoConsignadoTO.getValorParcelaMax();
		this.valorEmprestimoMax = solicitacaoEmprestimoConsignadoTO.getValorEmprestimoMax();
		this.valorEmprestimoMin = solicitacaoEmprestimoConsignadoTO.getValorEmprestimoMin();
		this.primeiroVencimento = solicitacaoEmprestimoConsignadoTO.getPrimeiroVencimento();
		this.aberto = solicitacaoEmprestimoConsignadoTO.getAberto();
		this.observacoes = solicitacaoEmprestimoConsignadoTO.getObservacoes();
	}
}