package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.SituacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.enumerators.TipoEmprestimoConsignado;

public class EmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long funcionarioId;
	private Long rubricaId;
	private Long agenciaBancariaId;
	private Long aprovacaoEmprestimoConsignadoId;
	private TipoEmprestimoConsignado tipo;
	private Integer diaVencimento;
	private Double valorEmprestimo;
	private Integer numeroParcelas;
	private Double valorParcela;
	private Date vencimentoPrimeiraParcela;
	private Date vencimentoUltimaParcela;
	private String numeroDoBanco;
	private String observacoes;
	private SituacaoEmprestimoConsignado situacao;
	private Date dataSituacao;
	private String parecer;
	private List<ParcelaEmprestimoConsignadoTO> parcelas = new ArrayList<ParcelaEmprestimoConsignadoTO>();

	public EmprestimoConsignadoTO() {
		super();
	}

	public EmprestimoConsignadoTO(Long id, Long funcionarioId, Long rubricaId, Long agenciaBancariaId,
			Long aprovacaoEmprestimoConsignadoId, TipoEmprestimoConsignado tipo, Integer diaVencimento,
			Double valorEmprestimo, Integer numeroParcelas, Double valorParcela, Date vencimentoPrimeiraParcela,
			Date vencimentoUltimaParcela, String numeroDoBanco, String observacoes,
			SituacaoEmprestimoConsignado situacao, Date dataSituacao, String parecer,
			List<ParcelaEmprestimoConsignadoTO> parcelas) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.rubricaId = rubricaId;
		this.agenciaBancariaId = agenciaBancariaId;
		this.aprovacaoEmprestimoConsignadoId = aprovacaoEmprestimoConsignadoId;
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

	public EmprestimoConsignadoTO(Long funcionarioId, Long rubricaId, Long agenciaBancariaId,
			Long aprovacaoEmprestimoConsignadoId, TipoEmprestimoConsignado tipo, Integer diaVencimento,
			Double valorEmprestimo, Integer numeroParcelas, Double valorParcela, Date vencimentoPrimeiraParcela,
			Date vencimentoUltimaParcela, String numeroDoBanco, String observacoes,
			SituacaoEmprestimoConsignado situacao, Date dataSituacao, String parecer,
			List<ParcelaEmprestimoConsignadoTO> parcelas) {
		super();
		this.funcionarioId = funcionarioId;
		this.rubricaId = rubricaId;
		this.agenciaBancariaId = agenciaBancariaId;
		this.aprovacaoEmprestimoConsignadoId = aprovacaoEmprestimoConsignadoId;
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

	public Long getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Long rubricaId) {
		this.rubricaId = rubricaId;
	}

	public Long getAgenciaBancariaId() {
		return agenciaBancariaId;
	}

	public void setAgenciaBancariaId(Long agenciaBancariaId) {
		this.agenciaBancariaId = agenciaBancariaId;
	}

	public Long getAprovacaoEmprestimoConsignadoId() {
		return aprovacaoEmprestimoConsignadoId;
	}

	public void setAprovacaoEmprestimoConsignadoId(Long aprovacaoEmprestimoConsignadoId) {
		this.aprovacaoEmprestimoConsignadoId = aprovacaoEmprestimoConsignadoId;
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

	public void setSituacao(SituacaoEmprestimoConsignado situacao) {
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

	public List<ParcelaEmprestimoConsignadoTO> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaEmprestimoConsignadoTO> parcelas) {
		this.parcelas = parcelas;
	}

	@Override
	public String toString() {
		return "EmprestimoConsignadoTO [id=" + id + ", funcionarioId=" + funcionarioId + ", rubricaId=" + rubricaId
				+ ", agenciaBancariaId=" + agenciaBancariaId + ", aprovacaoEmprestimoConsignadoId="
				+ aprovacaoEmprestimoConsignadoId + ", tipo=" + tipo + ", diaVencimento=" + diaVencimento
				+ ", valorEmprestimo=" + valorEmprestimo + ", numeroParcelas=" + numeroParcelas + ", valorParcela="
				+ valorParcela + ", vencimentoPrimeiraParcela=" + vencimentoPrimeiraParcela
				+ ", vencimentoUltimaParcela=" + vencimentoUltimaParcela + ", numeroDoBanco=" + numeroDoBanco
				+ ", observacoes=" + observacoes + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao
				+ ", parecer=" + parecer + "]";
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
		EmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}