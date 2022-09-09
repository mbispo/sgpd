package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoPagamentoItem;

public class PagamentoItemTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long pagamentoId;
	private TipoPagamentoItem tipo;
	private Long rubricaId;
	private Double quantidade;
	private String descricao;
	private String mensagem;
	private Double valor;
	private String entidadeOrigem;	
	private Long entidadeOrigemId;	


	public PagamentoItemTO() {
		super();
	}

	public PagamentoItemTO(Long id, Long pagamentoId, TipoPagamentoItem tipo, Long rubricaId, Double quantidade, String descricao,
			String mensagem, Double valor, String entidadeOrigem, Long entidadeOrigemId) {
		super();
		this.id = id;
		this.pagamentoId = pagamentoId;
		this.tipo = tipo;
		this.rubricaId = rubricaId;
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

	public Long getPagamentoId() {
		return pagamentoId;
	}

	public void setPagamentoId(Long pagamentoId) {
		this.pagamentoId = pagamentoId;
	}

	public TipoPagamentoItem getTipo() {
		return tipo;
	}

	public void setTipo(TipoPagamentoItem tipo) {
		this.tipo = tipo;
	}

	public Long getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Long rubricaId) {
		this.rubricaId = rubricaId;
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

	@Override
	public String toString() {
		return "PagamentoItemTO [id=" + id + ", pagamentoId=" + pagamentoId + ", tipo=" + tipo + ", rubricaId="
				+ rubricaId + ", quantidade=" + quantidade + ", descricao=" + descricao + ", mensagem=" + mensagem
				+ ", valor=" + valor + ", entidadeOrigem=" + entidadeOrigem + ", entidadeOrigemId=" + entidadeOrigemId
				+ "]";
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
		PagamentoItemTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}