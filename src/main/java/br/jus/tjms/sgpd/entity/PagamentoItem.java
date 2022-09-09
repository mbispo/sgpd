package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoPagamentoItem;
import br.jus.tjms.sgpd.service.rest.v1.to.PagamentoItemTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "pagamentoItem.buscarPorFuncionario", 
			query = "SELECT p FROM PagamentoItem p WHERE p.pagamento.id = :pagamentoId")
})
public class PagamentoItem implements Serializable {

	private static final long serialVersionUID = 8361333737198011900L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pagamento_id", nullable = false)
	private Pagamento pagamento;

	@Enumerated(EnumType.ORDINAL)
	private TipoPagamentoItem tipo; // registra o tipo de item: débito, crédito, totalizador, bases de cálculo, etc
	
	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = true)
	private Rubrica rubrica;	

	private Double quantidade;

	@Column(length = 255)
	private String descricao;

	@Column(length = 500)
	private String mensagem;

	private Double valor;
	
	@Column(length = 255)
	private String entidadeOrigem; // entidade que originou o item de pagamento
	
	private Long entidadeOrigemId; // id da entidade que originou o item de pagamento
	
	public PagamentoItem() {
		super();
	}

	public PagamentoItem(Pagamento pagamento, TipoPagamentoItem tipo, Rubrica rubrica, Double quantidade, String descricao,
			String mensagem, Double valor, String entidadeOrigem, Long entidadeOrigemId) {
		super();
		this.pagamento = pagamento;
		this.tipo = tipo;
		this.rubrica = rubrica;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.mensagem = mensagem;
		this.valor = valor;
		this.entidadeOrigem = entidadeOrigem;
		this.entidadeOrigemId = entidadeOrigemId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public TipoPagamentoItem getTipo() {
		return tipo;
	}

	public void setTipo(TipoPagamentoItem tipo) {
		this.tipo = tipo;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getEntidadeOrigem() {
		return entidadeOrigem;
	}

	public void setEntidadeOrigem(String entidadeOrigem) {
		this.entidadeOrigem = entidadeOrigem;
	}

	public Long getEntidadeOrigemId() {
		return entidadeOrigemId;
	}

	public void setEntidadeOrigemId(Long entidadeOrigemId) {
		this.entidadeOrigemId = entidadeOrigemId;
	}
	
	@Transient
	public Date getDataPagamento() {
		return pagamento.getDataPagamento();
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
		PagamentoItem other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	

	@Override
	public String toString() {
		return "PagamentoItem [id=" + id + ", pagamento=" + pagamento + ", tipo=" + tipo + ", rubrica=" + rubrica
				+ ", quantidade=" + quantidade + ", descricao=" + descricao + ", mensagem=" + mensagem + ", valor="
				+ valor + ", entidadeOrigem=" + entidadeOrigem + ", entidadeOrigemId=" + entidadeOrigemId + "]";
	}

	public PagamentoItemTO toTO() {
		return new PagamentoItemTO(id, pagamento.getId(), tipo, rubrica!=null?rubrica.getId():null, quantidade, descricao, mensagem, valor, entidadeOrigem, entidadeOrigemId);
	}

}