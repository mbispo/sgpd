package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.service.rest.v1.to.LancamentoAvulsoTO;
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
	@NamedQuery(name = "lancamentoAvulso.buscarPorFuncionario", 
			query = "SELECT l FROM LancamentoAvulso l WHERE l.funcionario.id = :funcionarioId")
})
public class LancamentoAvulso implements Serializable {

	private static final long serialVersionUID = -3871306806855795840L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	@Column(length = 255)
	private String descricao;	

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = true)
	private Rubrica rubrica;
	
	@Enumerated(EnumType.ORDINAL)
	private Sinal sinal;

	private Double quantidade;
	private Double percentual;
	private Double valor;

	private Boolean pago = Boolean.FALSE;
	private Double valorPago;
	private Date pagamento;

	public LancamentoAvulso() {
		super();
	}

	public LancamentoAvulso(Funcionario funcionario, String descricao, Double valor) {
		super();
		this.funcionario = funcionario;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public LancamentoAvulso(Funcionario funcionario, String descricao, Double valor, Sinal sinal) {
		super();
		this.funcionario = funcionario;
		this.descricao = descricao;
		this.valor = valor;
		this.sinal = sinal;
	}

	public LancamentoAvulso(Funcionario funcionario, String descricao, Rubrica rubrica, Sinal sinal, Double quantidade, Double percentual,
			Double valor, Boolean pago, Double valorPago, Date pagamento) {
		super();
		this.funcionario = funcionario;
		this.descricao = descricao;
		this.rubrica = rubrica;
		this.sinal = sinal;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.valor = valor;
		this.pago = pago;
		this.valorPago = valorPago;
		this.pagamento = pagamento;
	}

	public LancamentoAvulso(LancamentoAvulsoTO lancamentoAvulsoTO) {
		this.id = lancamentoAvulsoTO.getId();
		
		if (lancamentoAvulsoTO.getFuncionarioId()!=null) {
			this.funcionario = new Funcionario(lancamentoAvulsoTO.getFuncionarioId());
		}
		
		if (lancamentoAvulsoTO.getRubricaId()!=null) {
			this.rubrica = new Rubrica(lancamentoAvulsoTO.getRubricaId());
		}		
		
		this.sinal = lancamentoAvulsoTO.getSinal();
		this.quantidade = lancamentoAvulsoTO.getQuantidade();
		this.percentual = lancamentoAvulsoTO.getPercentual();
		this.valor = lancamentoAvulsoTO.getValor();
		this.pago = lancamentoAvulsoTO.getPago();
		this.valorPago = lancamentoAvulsoTO.getValorPago();
		this.pagamento = lancamentoAvulsoTO.getPagamento();
	}
	
	public void alterar(LancamentoAvulsoTO lancamentoAvulsoTO) {

		if (lancamentoAvulsoTO.getFuncionarioId()!=null) {
			this.funcionario = new Funcionario(lancamentoAvulsoTO.getFuncionarioId());
		}
		
		if (lancamentoAvulsoTO.getRubricaId()!=null) {
			this.rubrica = new Rubrica(lancamentoAvulsoTO.getRubricaId());
		}
		
		this.sinal = lancamentoAvulsoTO.getSinal();
		this.quantidade = lancamentoAvulsoTO.getQuantidade();
		this.percentual = lancamentoAvulsoTO.getPercentual();
		this.valor = lancamentoAvulsoTO.getValor();
		this.pago = lancamentoAvulsoTO.getPago();
		this.valorPago = lancamentoAvulsoTO.getValorPago();
		this.pagamento = lancamentoAvulsoTO.getPagamento();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		LancamentoAvulso other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "LancamentoAvulso [id=" + id + ", funcionario=" + funcionario + ", descricao=" + descricao + ", rubrica="
				+ rubrica + ", sinal=" + sinal + ", quantidade=" + quantidade + ", percentual=" + percentual
				+ ", valor=" + valor + ", pago=" + pago + ", valorPago=" + valorPago + ", pagamento=" + pagamento + "]";
	}

	public LancamentoAvulsoTO toTO() {
		return new LancamentoAvulsoTO(id, funcionario.getId(), descricao, rubrica!=null?rubrica.getId():null, sinal,
			quantidade, percentual, valor, pago, valorPago, pagamento);
	}
	
}