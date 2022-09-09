package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSimulacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.enumerators.TipoEmprestimoConsignado;
import br.jus.tjms.sgpd.service.rest.v1.to.SimulacaoEmprestimoConsignadoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "simulacaoEmprestimoConsignado.buscarSimulacoesPorSolicitacaoEmsprestimoConsignado", 
			query = "SELECT s from SimulacaoEmprestimoConsignado s WHERE s.solicitacao.id = :solicitacaoId")
})
public class SimulacaoEmprestimoConsignado implements Serializable {

	private static final long serialVersionUID = 1646639471162490997L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoEmprestimoConsignado solicitacao;	
	
	@ManyToOne
	@JoinColumn(name = "agenciaBancaria_id", nullable = false)
	private AgenciaBancaria agenciaBancaria;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Pessoa funcionario; // o funcionário do banco que faz a simulação

	private Date dataSimulacao;

	@Column(length = 20)
	private String numeroDoBanco;

	private Integer numeroParcelas;
	private Date vencimentoPrimeiraParcela;
	private Double valorEmprestimo;
	private Double valorParcela;

	@Enumerated(EnumType.ORDINAL)
	private TipoEmprestimoConsignado tipo;

	@Column(length = 500)
	private String observacoes;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSimulacaoEmprestimoConsignado situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SimulacaoEmprestimoConsignado() {
		super();
	}

	public SimulacaoEmprestimoConsignado(Long id, SolicitacaoEmprestimoConsignado solicitacao, 
			AgenciaBancaria agenciaBancaria, Pessoa funcionario,
			Date dataSimulacao, String numeroDoBanco, Integer numeroParcelas, Date vencimentoPrimeiraParcela,
			Double valorEmprestimo, Double valorParcela, TipoEmprestimoConsignado tipo, String observacoes,
			SituacaoSimulacaoEmprestimoConsignado situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.agenciaBancaria = agenciaBancaria;
		this.funcionario = funcionario;
		this.dataSimulacao = dataSimulacao;
		this.numeroDoBanco = numeroDoBanco;
		this.numeroParcelas = numeroParcelas;
		this.vencimentoPrimeiraParcela = vencimentoPrimeiraParcela;
		this.valorEmprestimo = valorEmprestimo;
		this.valorParcela = valorParcela;
		this.tipo = tipo;
		this.observacoes = observacoes;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
	}

	public SimulacaoEmprestimoConsignado(SimulacaoEmprestimoConsignadoTO simulacaoEmprestimoConsignadoTO) {
//FIXME	this.solicitacao = simulacaoEmprestimoConsignadoTO.getSituacao();
//FIXME	this.agenciaBancaria = simulacaoEmprestimoConsignadoTO.getAgenciaBancariaId();
//FIXME	this.funcionario = simulacaoEmprestimoConsignadoTO.getFuncionarioDoBancoId();
		this.dataSimulacao = simulacaoEmprestimoConsignadoTO.getDataSimulacao();
		this.numeroDoBanco = simulacaoEmprestimoConsignadoTO.getNumeroDoBanco();
		this.numeroParcelas = simulacaoEmprestimoConsignadoTO.getNumeroParcelas();
		this.vencimentoPrimeiraParcela = simulacaoEmprestimoConsignadoTO.getVencimentoPrimeiraParcela();
		this.valorEmprestimo = simulacaoEmprestimoConsignadoTO.getValorEmprestimo();
		this.valorParcela = simulacaoEmprestimoConsignadoTO.getValorParcela();
		this.tipo = simulacaoEmprestimoConsignadoTO.getTipo();
		this.observacoes = simulacaoEmprestimoConsignadoTO.getObservacoes();
		this.situacao = simulacaoEmprestimoConsignadoTO.getSituacao();
		this.dataSituacao = simulacaoEmprestimoConsignadoTO.getDataSituacao();
		this.parecer = simulacaoEmprestimoConsignadoTO.getParecer();
	}

	public Long getId() {
		return id;
	}

	public SolicitacaoEmprestimoConsignado getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoEmprestimoConsignado solicitacao) {
		this.solicitacao = solicitacao;
	}

	public AgenciaBancaria getAgenciaBancaria() {
		return agenciaBancaria;
	}

	public void setAgenciaBancaria(AgenciaBancaria agenciaBancaria) {
		this.agenciaBancaria = agenciaBancaria;
	}

	public Pessoa getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Pessoa funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataSimulacao() {
		return dataSimulacao;
	}

	public void setDataSimulacao(Date dataSimulacao) {
		this.dataSimulacao = dataSimulacao;
	}

	public String getNumeroDoBanco() {
		return numeroDoBanco;
	}

	public void setNumeroDoBanco(String numeroDoBanco) {
		this.numeroDoBanco = numeroDoBanco;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public Date getVencimentoPrimeiraParcela() {
		return vencimentoPrimeiraParcela;
	}

	public void setVencimentoPrimeiraParcela(Date vencimentoPrimeiraParcela) {
		this.vencimentoPrimeiraParcela = vencimentoPrimeiraParcela;
	}

	public Double getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(Double valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public SituacaoSimulacaoEmprestimoConsignado getSituacao() {
		return situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public TipoEmprestimoConsignado getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmprestimoConsignado tipo) {
		this.tipo = tipo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		SimulacaoEmprestimoConsignado other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SimulacaoEmprestimoConsignado [id=" + id + ", solicitacao=" + solicitacao + ", agenciaBancaria="
				+ agenciaBancaria + ", funcionario=" + funcionario + ", dataSimulacao=" + dataSimulacao
				+ ", numeroDoBanco=" + numeroDoBanco + ", numeroParcelas=" + numeroParcelas
				+ ", vencimentoPrimeiraParcela=" + vencimentoPrimeiraParcela + ", valorEmprestimo=" + valorEmprestimo
				+ ", valorParcela=" + valorParcela + ", tipo=" + tipo + ", observacoes=" + observacoes + ", situacao="
				+ situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

	public void alterar(SimulacaoEmprestimoConsignadoTO simulacaoEmprestimoConsignadoTO) {
		//FIXME	this.solicitacao = simulacaoEmprestimoConsignadoTO.getSituacao();
		//FIXME	this.agenciaBancaria = simulacaoEmprestimoConsignadoTO.getAgenciaBancariaId();
		//FIXME	this.funcionario = simulacaoEmprestimoConsignadoTO.getFuncionarioDoBancoId();
				this.dataSimulacao = simulacaoEmprestimoConsignadoTO.getDataSimulacao();
				this.numeroDoBanco = simulacaoEmprestimoConsignadoTO.getNumeroDoBanco();
				this.numeroParcelas = simulacaoEmprestimoConsignadoTO.getNumeroParcelas();
				this.vencimentoPrimeiraParcela = simulacaoEmprestimoConsignadoTO.getVencimentoPrimeiraParcela();
				this.valorEmprestimo = simulacaoEmprestimoConsignadoTO.getValorEmprestimo();
				this.valorParcela = simulacaoEmprestimoConsignadoTO.getValorParcela();
				this.tipo = simulacaoEmprestimoConsignadoTO.getTipo();
				this.observacoes = simulacaoEmprestimoConsignadoTO.getObservacoes();
				this.situacao = simulacaoEmprestimoConsignadoTO.getSituacao();
				this.dataSituacao = simulacaoEmprestimoConsignadoTO.getDataSituacao();
				this.parecer = simulacaoEmprestimoConsignadoTO.getParecer();
	}

	public void aprovar(String observacoes) {
		this.observacoes = observacoes;
		this.situacao = SituacaoSimulacaoEmprestimoConsignado.APROVADA;
	}

	public void recusar(String observacoes) {
		this.observacoes = observacoes;
		this.situacao = SituacaoSimulacaoEmprestimoConsignado.RECUSADA;
	}

	public void definirSituacaoSimulacaoEmprestimoConsignado(SituacaoSimulacaoEmprestimoConsignado situacao,
			String parecer) {
		this.parecer = parecer;
		this.situacao = situacao;
	}
}