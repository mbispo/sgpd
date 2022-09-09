package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.Sinal;

public class LancamentoAvulsoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long funcionarioId;
	private Long rubricaId;
	private String descricao;
	private Sinal sinal;
	private Double quantidade;
	private Double percentual;
	private Double valor;
	private Boolean pago = Boolean.FALSE;
	private Double valorPago;
	private Date pagamento;

	public LancamentoAvulsoTO() {
		super();
	}

	public LancamentoAvulsoTO(Long id, Long funcionarioId, String descricao, Long rubricaId, Sinal sinal,
			Double quantidade, Double percentual, Double valor, Boolean pago, Double valorPago, Date pagamento) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.rubricaId = rubricaId;
		this.descricao = descricao;
		this.sinal = sinal;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.valor = valor;
		this.pago = pago;
		this.valorPago = valorPago;
		this.pagamento = pagamento;
	}

	public LancamentoAvulsoTO(Long funcionarioId, String descricao, Long rubricaId, Sinal sinal, Double quantidade,
			Double percentual, Double valor, Boolean pago, Double valorPago, Date pagamento) {
		super();
		this.funcionarioId = funcionarioId;
		this.descricao = descricao;
		this.rubricaId = rubricaId;
		this.sinal = sinal;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.valor = valor;
		this.pago = pago;
		this.valorPago = valorPago;
		this.pagamento = pagamento;
	}

	public Long getId() {
		return id;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Long rubricaId) {
		this.rubricaId = rubricaId;
	}

	public Sinal getSinal() {
		return sinal;
	}

	public void setSinal(Sinal sinal) {
		this.sinal = sinal;
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

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Date getPagamento() {
		return pagamento;
	}

	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public String toString() {
		return "LancamentoAvulsoTO [id=" + id + ", funcionarioId=" + funcionarioId + ", descricao=" + descricao
				+ ", rubricaId=" + rubricaId + ", sinal=" + sinal + ", quantidade=" + quantidade + ", percentual="
				+ percentual + ", valor=" + valor + ", pago=" + pago + ", valorPago=" + valorPago + ", pagamento="
				+ pagamento + "]";
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
		LancamentoAvulsoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}