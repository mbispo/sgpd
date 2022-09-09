package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PagamentoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long funcionarioId;
	private Long folhaPagamentoId;
	private Date dataPagamento;
	private Long contaRecebimentoId;
	private String mensagem;
	private Long dadosConsolidadosDoFuncionarioId;
	private List<PagamentoItemTO> itens = new ArrayList<PagamentoItemTO>();
	private Double ganhos;
	private Double descontos;
	private Double liquido;
	private Double baseCalculoIrrf;
	private Double irrf;

	public PagamentoTO() {
		super();
	}
	
	public PagamentoTO(Long id, Long funcionarioId, Long folhaPagamentoId, Date dataPagamento, Long contaRecebimentoId,
			String mensagem, Long dadosConsolidadosDoFuncionarioId, List<PagamentoItemTO> itens, Double ganhos,
			Double descontos, Double liquido, Double baseCalculoIrrf, Double irrf) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.folhaPagamentoId = folhaPagamentoId;
		this.dataPagamento = dataPagamento;
		this.contaRecebimentoId = contaRecebimentoId;
		this.mensagem = mensagem;
		this.dadosConsolidadosDoFuncionarioId = dadosConsolidadosDoFuncionarioId;
		this.itens = itens;
		this.ganhos = ganhos;
		this.descontos = descontos;
		this.liquido = liquido;
		this.baseCalculoIrrf = baseCalculoIrrf;
		this.irrf = irrf;
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

	public Long getFolhaPagamentoId() {
		return folhaPagamentoId;
	}

	public void setFolhaPagamentoId(Long folhaPagamentoId) {
		this.folhaPagamentoId = folhaPagamentoId;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Long getContaRecebimentoId() {
		return contaRecebimentoId;
	}

	public void setContaRecebimentoId(Long contaRecebimentoId) {
		this.contaRecebimentoId = contaRecebimentoId;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getDadosConsolidadosDoFuncionarioId() {
		return dadosConsolidadosDoFuncionarioId;
	}

	public void setDadosConsolidadosDoFuncionarioId(Long dadosConsolidadosDoFuncionarioId) {
		this.dadosConsolidadosDoFuncionarioId = dadosConsolidadosDoFuncionarioId;
	}

	public List<PagamentoItemTO> getItens() {
		return itens;
	}

	public void setItens(List<PagamentoItemTO> itens) {
		this.itens = itens;
	}

	public Double getGanhos() {
		return ganhos;
	}

	public void setGanhos(Double ganhos) {
		this.ganhos = ganhos;
	}

	public Double getDescontos() {
		return descontos;
	}

	public void setDescontos(Double descontos) {
		this.descontos = descontos;
	}

	public Double getLiquido() {
		return liquido;
	}

	public void setLiquido(Double liquido) {
		this.liquido = liquido;
	}
	
	public Double getBaseCalculoIrrf() {
		return baseCalculoIrrf;
	}

	public void setBaseCalculoIrrf(Double baseCalculoIrrf) {
		this.baseCalculoIrrf = baseCalculoIrrf;
	}

	public Double getIrrf() {
		return irrf;
	}

	public void setIrrf(Double irrf) {
		this.irrf = irrf;
	}

	@Override
	public String toString() {
		return "PagamentoTO [id=" + id + ", funcionarioId=" + funcionarioId + ", folhaPagamentoId=" + folhaPagamentoId
				+ ", dataPagamento=" + dataPagamento + ", contaRecebimentoId=" + contaRecebimentoId + ", mensagem="
				+ mensagem + ", dadosConsolidadosDoFuncionarioId=" + dadosConsolidadosDoFuncionarioId + ", itens="
				+ itens + ", ganhos=" + ganhos + ", descontos=" + descontos + ", liquido=" + liquido
				+ ", baseCalculoIrrf=" + baseCalculoIrrf + ", irrf=" + irrf + "]";
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
		PagamentoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}