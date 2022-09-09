package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DadosConsolidadosDoFuncionarioTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private FuncionarioTO funcionario;
	private Date dataConsolidacao;
	private ContaRecebimentoTO contaRecebimento;
	private FuncionarioAreaTO funcionarioArea;
	private FuncionarioCargoTO funcionarioCargoPrincipal;
	private FuncionarioCargoTO funcionarioCargoAcumulado1;
	private FuncionarioCargoTO funcionarioCargoAcumulado2;
	private String lotacao;
	private String cargoPrincipal;
	private String cargoAcumulado1;
	private String cargoAcumulado2;
	private String observacoes;

	public DadosConsolidadosDoFuncionarioTO() {
		super();
	}

	public DadosConsolidadosDoFuncionarioTO(Long id, FuncionarioTO funcionario, Date dataConsolidacao,
			ContaRecebimentoTO contaRecebimento, FuncionarioAreaTO funcionarioArea,
			FuncionarioCargoTO funcionarioCargoPrincipal, FuncionarioCargoTO funcionarioCargoAcumulado1,
			FuncionarioCargoTO funcionarioCargoAcumulado2, String lotacao, String cargoPrincipal,
			String cargoAcumulado1, String cargoAcumulado2, String observacoes) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.dataConsolidacao = dataConsolidacao;
		this.contaRecebimento = contaRecebimento;
		this.funcionarioArea = funcionarioArea;
		this.funcionarioCargoPrincipal = funcionarioCargoPrincipal;
		this.funcionarioCargoAcumulado1 = funcionarioCargoAcumulado1;
		this.funcionarioCargoAcumulado2 = funcionarioCargoAcumulado2;
		this.lotacao = lotacao;
		this.cargoPrincipal = cargoPrincipal;
		this.cargoAcumulado1 = cargoAcumulado1;
		this.cargoAcumulado2 = cargoAcumulado2;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FuncionarioTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioTO funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataConsolidacao() {
		return dataConsolidacao;
	}

	public void setDataConsolidacao(Date dataConsolidacao) {
		this.dataConsolidacao = dataConsolidacao;
	}

	public ContaRecebimentoTO getContaRecebimento() {
		return contaRecebimento;
	}

	public void setContaRecebimento(ContaRecebimentoTO contaRecebimento) {
		this.contaRecebimento = contaRecebimento;
	}

	public FuncionarioAreaTO getFuncionarioArea() {
		return funcionarioArea;
	}

	public void setFuncionarioArea(FuncionarioAreaTO funcionarioArea) {
		this.funcionarioArea = funcionarioArea;
	}

	public FuncionarioCargoTO getFuncionarioCargoPrincipal() {
		return funcionarioCargoPrincipal;
	}

	public void setFuncionarioCargoPrincipal(FuncionarioCargoTO funcionarioCargoPrincipal) {
		this.funcionarioCargoPrincipal = funcionarioCargoPrincipal;
	}

	public FuncionarioCargoTO getFuncionarioCargoAcumulado1() {
		return funcionarioCargoAcumulado1;
	}

	public void setFuncionarioCargoAcumulado1(FuncionarioCargoTO funcionarioCargoAcumulado1) {
		this.funcionarioCargoAcumulado1 = funcionarioCargoAcumulado1;
	}

	public FuncionarioCargoTO getFuncionarioCargoAcumulado2() {
		return funcionarioCargoAcumulado2;
	}

	public void setFuncionarioCargoAcumulado2(FuncionarioCargoTO funcionarioCargoAcumulado2) {
		this.funcionarioCargoAcumulado2 = funcionarioCargoAcumulado2;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

	public String getCargoPrincipal() {
		return cargoPrincipal;
	}

	public void setCargoPrincipal(String cargoPrincipal) {
		this.cargoPrincipal = cargoPrincipal;
	}

	public String getCargoAcumulado1() {
		return cargoAcumulado1;
	}

	public void setCargoAcumulado1(String cargoAcumulado1) {
		this.cargoAcumulado1 = cargoAcumulado1;
	}

	public String getCargoAcumulado2() {
		return cargoAcumulado2;
	}

	public void setCargoAcumulado2(String cargoAcumulado2) {
		this.cargoAcumulado2 = cargoAcumulado2;
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
		DadosConsolidadosDoFuncionarioTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DadosConsolidadosDoFuncionarioTO [id=" + id + ", funcionario=" + funcionario + ", dataConsolidacao="
				+ dataConsolidacao + ", contaRecebimento=" + contaRecebimento + ", funcionarioArea=" + funcionarioArea
				+ ", funcionarioCargoPrincipal=" + funcionarioCargoPrincipal + ", funcionarioCargoAcumulado1="
				+ funcionarioCargoAcumulado1 + ", funcionarioCargoAcumulado2=" + funcionarioCargoAcumulado2
				+ ", lotacao=" + lotacao + ", cargoPrincipal=" + cargoPrincipal + ", cargoAcumulado1=" + cargoAcumulado1
				+ ", cargoAcumulado2=" + cargoAcumulado2 + ", observacoes=" + observacoes + "]";
	}

}