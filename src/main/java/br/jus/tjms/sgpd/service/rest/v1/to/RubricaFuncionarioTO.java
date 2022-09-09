package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;

public class RubricaFuncionarioTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long funcionarioId;
	private Long funcionarioCargoId;
	private Long contraParteId;
	private Long rubricaId;
	private TipoFolhaPagamento tipoFolhaPagamento;
	private Double quantidade;
	private Double percentual;
	private Double valor;
	private List<RubricaFuncionarioBaseTO> rubricasBase;

	public RubricaFuncionarioTO() {
		super();
	}

	public RubricaFuncionarioTO(Long id, Long funcionarioId, Long funcionarioCargoId, Long contraParteId, Long rubricaId,
			TipoFolhaPagamento tipoFolhaPagamento, Double quantidade, Double percentual, Double valor,
			List<RubricaFuncionarioBaseTO> rubricasBase) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.funcionarioCargoId = funcionarioCargoId;
		this.contraParteId = contraParteId;
		this.rubricaId = rubricaId;
		this.tipoFolhaPagamento = tipoFolhaPagamento;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.valor = valor;
		this.rubricasBase = rubricasBase;
	}

	public RubricaFuncionarioTO(Long funcionarioId, Long funcionarioCargoId, Long contraParteId, Long rubricaId,
			TipoFolhaPagamento tipoFolhaPagamento, Double quantidade, Double percentual, Double valor,
			List<RubricaFuncionarioBaseTO> rubricasBase) {
		super();
		this.funcionarioId = funcionarioId;
		this.funcionarioCargoId = funcionarioCargoId;
		this.contraParteId = contraParteId;
		this.rubricaId = rubricaId;
		this.tipoFolhaPagamento = tipoFolhaPagamento;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.valor = valor;
		this.rubricasBase = rubricasBase;
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

	public Long getFuncionarioCargoId() {
		return funcionarioCargoId;
	}

	public void setFuncionarioCargoId(Long funcionarioCargoId) {
		this.funcionarioCargoId = funcionarioCargoId;
	}

	public Long getContraParteId() {
		return contraParteId;
	}

	public void setContraParteId(Long contraParteId) {
		this.contraParteId = contraParteId;
	}

	public Long getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Long rubricaId) {
		this.rubricaId = rubricaId;
	}

	public TipoFolhaPagamento getTipoFolhaPagamento() {
		return tipoFolhaPagamento;
	}

	public void setTipoFolhaPagamento(TipoFolhaPagamento tipoFolhaPagamento) {
		this.tipoFolhaPagamento = tipoFolhaPagamento;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<RubricaFuncionarioBaseTO> getRubricasBase() {
		return rubricasBase;
	}

	public void setRubricasBase(List<RubricaFuncionarioBaseTO> rubricasBase) {
		this.rubricasBase = rubricasBase;
	}

	@Override
	public String toString() {
		return "RubricaFuncionarioTO [id=" + id + ", funcionarioId=" + funcionarioId + ", funcionarioCargoId="
				+ funcionarioCargoId + ", contraParteId=" + contraParteId + ", rubricaId=" + rubricaId
				+ ", tipoFolhaPagamento=" + tipoFolhaPagamento + ", quantidade=" + quantidade + ", percentual="
				+ percentual + ", valor=" + valor + "]";
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
		RubricaFuncionarioTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}