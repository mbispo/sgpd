package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.enumerators.TipoEmprestimoConsignado;
import br.jus.tjms.sgpd.service.rest.v1.to.EmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.MudancaSituacaoEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.QuitacaoEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RenegociacaoEmprestimoConsignadoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:57
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "emprestimoConsignado.buscarEmprestimosPorFuncionario", 
			query = "SELECT e from EmprestimoConsignado e WHERE e.funcionario.id = :funcionarioId")
})
public class EmprestimoConsignado implements Serializable {

	private static final long serialVersionUID = -1199326425682203772L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = false)
	private Rubrica rubrica;

	@ManyToOne
	@JoinColumn(name = "agenciaBancaria_id", nullable = false)
	private AgenciaBancaria agenciaBancaria;

	@ManyToOne
	@JoinColumn(name = "aprovacao_id", nullable = true)
	private AprovacaoEmprestimoConsignado aprovacao;

	@Enumerated(EnumType.ORDINAL)
	private TipoEmprestimoConsignado tipo;

	private Integer diaVencimento;
	private Double valorEmprestimo;
	private Integer numeroParcelas;
	private Double valorParcela;
	private Date vencimentoPrimeiraParcela;
	private Date vencimentoUltimaParcela;

	@Column(length = 20)
	private String numeroDoBanco;

	@Column(length = 500)
	private String observacoes;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoEmprestimoConsignado situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;
	
	@OrderBy("sequencial")
	@OneToMany(mappedBy = "emprestimoConsignado", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<ParcelaEmprestimoConsignado> parcelas = new ArrayList<ParcelaEmprestimoConsignado>();


	public EmprestimoConsignado() {
		super();
	}

	public EmprestimoConsignado(Funcionario funcionario, Rubrica rubrica, TipoEmprestimoConsignado tipo,
			Integer diaVencimento, Double valorEmprestimo, Integer numeroParcelas, Double valorParcela,
			Date vencimentoPrimeiraParcela, Date vencimentoUltimaParcela, List<ParcelaEmprestimoConsignado> parcelas) {
		super();
		this.funcionario = funcionario;
		this.rubrica = rubrica;
		this.tipo = tipo;
		this.diaVencimento = diaVencimento;
		this.valorEmprestimo = valorEmprestimo;
		this.numeroParcelas = numeroParcelas;
		this.valorParcela = valorParcela;
		this.vencimentoPrimeiraParcela = vencimentoPrimeiraParcela;
		this.vencimentoUltimaParcela = vencimentoUltimaParcela;
		this.parcelas = parcelas;
	}

	public EmprestimoConsignado(Funcionario funcionario, Rubrica rubrica, AgenciaBancaria agenciaBancaria,
			AprovacaoEmprestimoConsignado aprovacao, TipoEmprestimoConsignado tipo, Integer diaVencimento,
			Double valorEmprestimo, Integer numeroParcelas, Double valorParcela, Date vencimentoPrimeiraParcela,
			Date vencimentoUltimaParcela, String numeroDoBanco, String observacoes,
			SituacaoEmprestimoConsignado situacao, Date dataSituacao, String parecer,
			List<ParcelaEmprestimoConsignado> parcelas) {
		super();
		this.funcionario = funcionario;
		this.rubrica = rubrica;
		this.agenciaBancaria = agenciaBancaria;
		this.aprovacao = aprovacao;
		this.tipo = tipo;
		this.diaVencimento = diaVencimento;
		this.valorEmprestimo = valorEmprestimo;
		this.numeroParcelas = numeroParcelas;
		this.valorParcela = valorParcela;
		this.vencimentoPrimeiraParcela = vencimentoPrimeiraParcela;
		this.vencimentoUltimaParcela = vencimentoUltimaParcela;
		this.numeroDoBanco = numeroDoBanco;
		this.observacoes = observacoes;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
		this.parcelas = parcelas;
	}

	public EmprestimoConsignado(EmprestimoConsignadoTO emprestimoConsignadoTO) {
		//FIXME this.funcionario = emprestimoConsignadoTO.getFuncionarioId();
		//FIXME this.rubrica = emprestimoConsignadoTO.getRubricaId();
		//FIXME this.agenciaBancaria = emprestimoConsignadoTO.getAgenciaBancariaId();
		//FIXME this.aprovacao = emprestimoConsignadoTO.getAprovacaoEmprestimoConsignadoId();
		this.tipo = emprestimoConsignadoTO.getTipo();
		this.diaVencimento = emprestimoConsignadoTO.getDiaVencimento();
		this.valorEmprestimo = emprestimoConsignadoTO.getValorEmprestimo();
		this.numeroParcelas = emprestimoConsignadoTO.getNumeroParcelas();
		this.valorParcela = emprestimoConsignadoTO.getValorParcela();
		this.vencimentoPrimeiraParcela = emprestimoConsignadoTO.getVencimentoPrimeiraParcela();
		this.vencimentoUltimaParcela = emprestimoConsignadoTO.getVencimentoUltimaParcela();
		this.numeroDoBanco = emprestimoConsignadoTO.getNumeroDoBanco();
		this.observacoes = emprestimoConsignadoTO.getObservacoes();
		this.situacao = emprestimoConsignadoTO.getSituacao();
		this.dataSituacao = emprestimoConsignadoTO.getDataSituacao();
		this.parecer = emprestimoConsignadoTO.getParecer();
		//FIXME this.parcelas = emprestimoConsignadoTO.getParcelas();
	}

	public Long getId() {
		return id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public AgenciaBancaria getAgenciaBancaria() {
		return agenciaBancaria;
	}

	public void setAgenciaBancaria(AgenciaBancaria agenciaBancaria) {
		this.agenciaBancaria = agenciaBancaria;
	}

	public AprovacaoEmprestimoConsignado getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(AprovacaoEmprestimoConsignado aprovacao) {
		this.aprovacao = aprovacao;
	}

	public TipoEmprestimoConsignado getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmprestimoConsignado tipo) {
		this.tipo = tipo;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Double getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(Double valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Date getVencimentoPrimeiraParcela() {
		return vencimentoPrimeiraParcela;
	}

	public void setVencimentoPrimeiraParcela(Date vencimentoPrimeiraParcela) {
		this.vencimentoPrimeiraParcela = vencimentoPrimeiraParcela;
	}

	public Date getVencimentoUltimaParcela() {
		return vencimentoUltimaParcela;
	}

	public void setVencimentoUltimaParcela(Date vencimentoUltimaParcela) {
		this.vencimentoUltimaParcela = vencimentoUltimaParcela;
	}

	public String getNumeroDoBanco() {
		return numeroDoBanco;
	}

	public void setNumeroDoBanco(String numeroDoBanco) {
		this.numeroDoBanco = numeroDoBanco;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public SituacaoEmprestimoConsignado getSituacao() {
		return situacao;
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

	public List<ParcelaEmprestimoConsignado> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaEmprestimoConsignado> parcelas) {
		this.parcelas = parcelas;
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
		EmprestimoConsignado other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "EmprestimoConsignado [id=" + id + ", funcionario=" + funcionario + ", rubrica=" + rubrica
				+ ", agenciaBancaria=" + agenciaBancaria + ", aprovacao=" + aprovacao + ", tipo=" + tipo
				+ ", diaVencimento=" + diaVencimento + ", valorEmprestimo=" + valorEmprestimo + ", numeroParcelas="
				+ numeroParcelas + ", valorParcela=" + valorParcela + ", vencimentoPrimeiraParcela="
				+ vencimentoPrimeiraParcela + ", vencimentoUltimaParcela=" + vencimentoUltimaParcela
				+ ", numeroDoBanco=" + numeroDoBanco + ", observacoes=" + observacoes + ", situacao=" + situacao
				+ ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}
	
	public void alterar(EmprestimoConsignadoTO emprestimoConsignadoTO) {
		//FIXME this.funcionario = emprestimoConsignadoTO.getFuncionarioId();
		//FIXME this.rubrica = emprestimoConsignadoTO.getRubricaId();
		//FIXME this.agenciaBancaria = emprestimoConsignadoTO.getAgenciaBancariaId();
		//FIXME this.aprovacao = emprestimoConsignadoTO.getAprovacaoEmprestimoConsignadoId();
		this.tipo = emprestimoConsignadoTO.getTipo();
		this.diaVencimento = emprestimoConsignadoTO.getDiaVencimento();
		this.valorEmprestimo = emprestimoConsignadoTO.getValorEmprestimo();
		this.numeroParcelas = emprestimoConsignadoTO.getNumeroParcelas();
		this.valorParcela = emprestimoConsignadoTO.getValorParcela();
		this.vencimentoPrimeiraParcela = emprestimoConsignadoTO.getVencimentoPrimeiraParcela();
		this.vencimentoUltimaParcela = emprestimoConsignadoTO.getVencimentoUltimaParcela();
		this.numeroDoBanco = emprestimoConsignadoTO.getNumeroDoBanco();
		this.observacoes = emprestimoConsignadoTO.getObservacoes();
		this.situacao = emprestimoConsignadoTO.getSituacao();
		this.dataSituacao = emprestimoConsignadoTO.getDataSituacao();
		this.parecer = emprestimoConsignadoTO.getParecer();
		//FIXME this.parcelas = emprestimoConsignadoTO.getParcelas();
	}

	public void ativar() {
		this.situacao = SituacaoEmprestimoConsignado.ATIVO;
	}
	
	public void quitar(QuitacaoEmprestimoConsignadoTO quitacaoEmprestimoConsignadoTO) {
		this.observacoes = quitacaoEmprestimoConsignadoTO.getObservacoes();
		this.dataSituacao = quitacaoEmprestimoConsignadoTO.getDataQuitacao();
		this.situacao = SituacaoEmprestimoConsignado.QUITADO;
	}

	public void renegociar(RenegociacaoEmprestimoConsignadoTO renegociacaoEmprestimoConsignadoTO) {
		this.observacoes = renegociacaoEmprestimoConsignadoTO.getObservacoes();
		this.dataSituacao = renegociacaoEmprestimoConsignadoTO.getDataRenegociacao();
		this.situacao = SituacaoEmprestimoConsignado.RENEGOCIADO;
	}

	public void definirSituacaoEmprestimoConsignado(
			MudancaSituacaoEmprestimoConsignadoTO mudancaSituacaoEmprestimoConsignadoTO) {
		this.observacoes = mudancaSituacaoEmprestimoConsignadoTO.getObservacoes();
		this.dataSituacao = mudancaSituacaoEmprestimoConsignadoTO.getData();
		this.situacao = mudancaSituacaoEmprestimoConsignadoTO.getNovaSituacao();
		
	}
}