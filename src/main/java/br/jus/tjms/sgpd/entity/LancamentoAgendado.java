package br.jus.tjms.sgpd.entity;


import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.service.rest.v1.to.LancamentoAgendadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PagamentoLancamentoAgendadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PagamentoLancamentoAvulsoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "lancamentoAgendado.buscarPorFuncionario", 
			query = "SELECT l FROM LancamentoAgendado l WHERE l.funcionario.id = :funcionarioId")
})
public class LancamentoAgendado implements Serializable {

	private static final long serialVersionUID = -6673458571571192331L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = true)
	private Rubrica rubrica;
	
	@Enumerated(EnumType.ORDINAL)
	private Sinal sinal;

	private Double quantidade;
	private Double percentual;
	private Date agendadoPara;
	private Double valor;
	private Boolean pago;
	private Double valorPago;
	private Date pagamento;

	public LancamentoAgendado() {
		super();
	}

	public LancamentoAgendado(Funcionario funcionario, Rubrica rubrica, Sinal sinal, Double quantidade, Double percentual,
			Date agendadoPara, Double valor, Boolean pago, Double valorPago, Date pagamento) {
		super();
		this.funcionario = funcionario;
		this.rubrica = rubrica;
		this.sinal = sinal;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.agendadoPara = agendadoPara;
		this.valor = valor;
		this.pago = pago;
		this.valorPago = valorPago;
		this.pagamento = pagamento;
	}

	public LancamentoAgendado(LancamentoAgendadoTO lancamentoAgendadoTO) {
		this.id = lancamentoAgendadoTO.getId();

		this.funcionario = new Funcionario(lancamentoAgendadoTO.getFuncionarioId());
		
		if (lancamentoAgendadoTO.getRubricaId()!=null) {
			this.rubrica = new Rubrica(lancamentoAgendadoTO.getRubricaId());
		}
		
		this.sinal = lancamentoAgendadoTO.getSinal();
		this.quantidade = lancamentoAgendadoTO.getQuantidade();
		this.percentual = lancamentoAgendadoTO.getPercentual();
		this.agendadoPara = lancamentoAgendadoTO.getAgendadoPara();
		this.valor = lancamentoAgendadoTO.getValor();
		this.pago = lancamentoAgendadoTO.getPago();
		this.valorPago = lancamentoAgendadoTO.getValorPago();
		this.pagamento = lancamentoAgendadoTO.getPagamento();
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

	public Date getAgendadoPara() {
		return agendadoPara;
	}

	public void setAgendadoPara(Date agendadoPara) {
		this.agendadoPara = agendadoPara;
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
		LancamentoAgendado other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "LancamentoAgendado [id=" + id + ", funcionario=" + funcionario + ", rubrica=" + rubrica + ", sinal="
				+ sinal + ", quantidade=" + quantidade + ", percentual=" + percentual + ", agendadoPara=" + agendadoPara
				+ ", valor=" + valor + ", pago=" + pago + ", valorPago=" + valorPago + ", pagamento=" + pagamento + "]";
	}
	
	public LancamentoAgendadoTO toTO() {
		return new LancamentoAgendadoTO(id, funcionario.getId(), rubrica!=null?rubrica.getId():null, sinal, quantidade,
				percentual, agendadoPara, valor, pago, valorPago, pagamento); 
	}
	
	public void alterar(LancamentoAgendadoTO lancamentoAgendadoTO) {
		this.funcionario = new Funcionario(lancamentoAgendadoTO.getFuncionarioId());
		
		if (lancamentoAgendadoTO.getRubricaId()!=null) {
			this.rubrica = new Rubrica(lancamentoAgendadoTO.getRubricaId());
		} else {
			this.rubrica = null;
		}

		this.sinal = lancamentoAgendadoTO.getSinal();
		this.quantidade = lancamentoAgendadoTO.getQuantidade();
		this.percentual = lancamentoAgendadoTO.getPercentual();
		this.valor = lancamentoAgendadoTO.getValor();
		this.pago = lancamentoAgendadoTO.getPago();
		this.valorPago = lancamentoAgendadoTO.getValorPago();
		this.pagamento = lancamentoAgendadoTO.getPagamento();
	}
	
	public void pagar(PagamentoLancamentoAvulsoTO pagamentoLancamentoAvulsoTO) {
		this.pagamento = pagamentoLancamentoAvulsoTO.getDataPagamento();
		this.valorPago = pagamentoLancamentoAvulsoTO.getValorPago();
	}

	public void pagar(PagamentoLancamentoAgendadoTO pagamentoLancamentoAgendadoTO) {
		this.pagamento = pagamentoLancamentoAgendadoTO.getDataPagamento();
		this.valorPago = pagamentoLancamentoAgendadoTO.getValorPago();
	}
}