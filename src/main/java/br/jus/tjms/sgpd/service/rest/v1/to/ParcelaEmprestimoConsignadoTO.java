package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.SituacaoParcelaEmprestimoConsignado;

public class ParcelaEmprestimoConsignadoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long emprestimoConsignadoId;
	private Integer sequencial;
	private SituacaoParcelaEmprestimoConsignado situacao;
	private Date vencimento;
	private Date pagamento;
	private Double valor;
	private Double valorPago;

	public ParcelaEmprestimoConsignadoTO() {
		super();
	}

	public ParcelaEmprestimoConsignadoTO(Long id, Long emprestimoConsignadoId, Integer sequencial,
			SituacaoParcelaEmprestimoConsignado situacao, Date vencimento, Date pagamento, Double valor,
			Double valorPago) {
		super();
		this.id = id;
		this.emprestimoConsignadoId = emprestimoConsignadoId;
		this.sequencial = sequencial;
		this.situacao = situacao;
		this.vencimento = vencimento;
		this.pagamento = pagamento;
		this.valor = valor;
		this.valorPago = valorPago;
	}

	public ParcelaEmprestimoConsignadoTO(Long emprestimoConsignadoId, Integer sequencial,
			SituacaoParcelaEmprestimoConsignado situacao, Date vencimento, Date pagamento, Double valor,
			Double valorPago) {
		super();
		this.emprestimoConsignadoId = emprestimoConsignadoId;
		this.sequencial = sequencial;
		this.situacao = situacao;
		this.vencimento = vencimento;
		this.pagamento = pagamento;
		this.valor = valor;
		this.valorPago = valorPago;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmprestimoConsignadoId() {
		return emprestimoConsignadoId;
	}

	public void setEmprestimoConsignadoId(Long emprestimoConsignadoId) {
		this.emprestimoConsignadoId = emprestimoConsignadoId;
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public SituacaoParcelaEmprestimoConsignado getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoParcelaEmprestimoConsignado situacao) {
		this.situacao = situacao;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Date getPagamento() {
		return pagamento;
	}

	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	@Override
	public String toString() {
		return "ParcelaEmprestimoConsignadoTO [id=" + id + ", emprestimoConsignadoId=" + emprestimoConsignadoId
				+ ", sequencial=" + sequencial + ", situacao=" + situacao + ", vencimento=" + vencimento
				+ ", pagamento=" + pagamento + ", valor=" + valor + ", valorPago=" + valorPago + "]";
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
		ParcelaEmprestimoConsignadoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}