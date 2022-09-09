package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.SituacaoSimulacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.enumerators.TipoEmprestimoConsignado;

public class SimulacaoEmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long solicitacaoEmprestimoConsignadoId;
	private Long agenciaBancariaId;
	private Long funcionarioDoBancoId; // o funcionário do banco que faz a simulação
	private Date dataSimulacao;
	private String numeroDoBanco;
	private Integer numeroParcelas;
	private Date vencimentoPrimeiraParcela;
	private Double valorEmprestimo;
	private Double valorParcela;
	private TipoEmprestimoConsignado tipo;
	private String observacoes;
	private SituacaoSimulacaoEmprestimoConsignado situacao;
	private Date dataSituacao;
	private String parecer;

	public SimulacaoEmprestimoConsignadoTO() {
		super();
	}

	public SimulacaoEmprestimoConsignadoTO(Long id, Long solicitacaoEmprestimoConsignadoId, Long agenciaBancariaId,
			Long funcionarioDoBancoId, Date dataSimulacao, String numeroDoBanco, Integer numeroParcelas,
			Date vencimentoPrimeiraParcela, Double valorEmprestimo, Double valorParcela, TipoEmprestimoConsignado tipo,
			String observacoes, SituacaoSimulacaoEmprestimoConsignado situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitacaoEmprestimoConsignadoId = solicitacaoEmprestimoConsignadoId;
		this.agenciaBancariaId = agenciaBancariaId;
		this.funcionarioDoBancoId = funcionarioDoBancoId;
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

	public SimulacaoEmprestimoConsignadoTO(Long solicitacaoEmprestimoConsignadoId, Long agenciaBancariaId,
			Long funcionarioDoBancoId, Date dataSimulacao, String numeroDoBanco, Integer numeroParcelas,
			Date vencimentoPrimeiraParcela, Double valorEmprestimo, Double valorParcela, TipoEmprestimoConsignado tipo,
			String observacoes, SituacaoSimulacaoEmprestimoConsignado situacao, Date dataSituacao, String parecer) {
		super();
		this.solicitacaoEmprestimoConsignadoId = solicitacaoEmprestimoConsignadoId;
		this.agenciaBancariaId = agenciaBancariaId;
		this.funcionarioDoBancoId = funcionarioDoBancoId;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSolicitacaoEmprestimoConsignadoId() {
		return solicitacaoEmprestimoConsignadoId;
	}

	public void setSolicitacaoEmprestimoConsignadoId(Long solicitacaoEmprestimoConsignadoId) {
		this.solicitacaoEmprestimoConsignadoId = solicitacaoEmprestimoConsignadoId;
	}

	public Long getAgenciaBancariaId() {
		return agenciaBancariaId;
	}

	public void setAgenciaBancariaId(Long agenciaBancariaId) {
		this.agenciaBancariaId = agenciaBancariaId;
	}

	public Long getFuncionarioDoBancoId() {
		return funcionarioDoBancoId;
	}

	public void setFuncionarioDoBancoId(Long funcionarioDoBancoId) {
		this.funcionarioDoBancoId = funcionarioDoBancoId;
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

	public SituacaoSimulacaoEmprestimoConsignado getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSimulacaoEmprestimoConsignado situacao) {
		this.situacao = situacao;
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

	@Override
	public String toString() {
		return "SimulacaoEmprestimoConsignadoTO [id=" + id + ", solicitacaoEmprestimoConsignadoId="
				+ solicitacaoEmprestimoConsignadoId + ", agenciaBancariaId=" + agenciaBancariaId
				+ ", funcionarioDoBancoId=" + funcionarioDoBancoId + ", dataSimulacao=" + dataSimulacao
				+ ", numeroDoBanco=" + numeroDoBanco + ", numeroParcelas=" + numeroParcelas
				+ ", vencimentoPrimeiraParcela=" + vencimentoPrimeiraParcela + ", valorEmprestimo=" + valorEmprestimo
				+ ", valorParcela=" + valorParcela + ", tipo=" + tipo + ", observacoes=" + observacoes + ", situacao="
				+ situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
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
		SimulacaoEmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}