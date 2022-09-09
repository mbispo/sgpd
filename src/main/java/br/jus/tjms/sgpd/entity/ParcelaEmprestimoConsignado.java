package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoParcelaEmprestimoConsignado;
import br.jus.tjms.sgpd.service.rest.v1.to.EstornoParcelaEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.MudancaSituacaoParcelaEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PagamentoParcelaEmprestimoConsignadoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ParcelaEmprestimoConsignadoTO;
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
	@NamedQuery(name = "parcelaEmprestimoConsignado.buscarParcelasPorEmprestimo", 
			query = "SELECT p from ParcelaEmprestimoConsignado p WHERE p.emprestimoConsignado.id = :emprestimoId")
})
public class ParcelaEmprestimoConsignado implements Serializable {

	private static final long serialVersionUID = 3611324959426760520L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "emprestimoConsignado_id", nullable = false)
	private EmprestimoConsignado emprestimoConsignado;

	private Integer sequencial;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoParcelaEmprestimoConsignado situacao;

	private Date vencimento;
	private Date pagamento;
	private Double valor;
	private Double valorPago;

	public ParcelaEmprestimoConsignado() {
		super();
	}

	public ParcelaEmprestimoConsignado(Long id, EmprestimoConsignado emprestimoConsignado, Integer sequencial,
			SituacaoParcelaEmprestimoConsignado situacao, Date vencimento, Date pagamento, Double valor,
			Double valorPago) {
		super();
		this.id = id;
		this.emprestimoConsignado = emprestimoConsignado;
		this.sequencial = sequencial;
		this.situacao = situacao;
		this.vencimento = vencimento;
		this.pagamento = pagamento;
		this.valor = valor;
		this.valorPago = valorPago;
	}

	public ParcelaEmprestimoConsignado(ParcelaEmprestimoConsignadoTO parcelaEmprestimoConsignadoTO) {
		//FIXME this.emprestimoConsignado = parcelaEmprestimoConsignadoTO.getEmprestimoConsignadoId();
		this.sequencial = parcelaEmprestimoConsignadoTO.getSequencial();
		this.situacao = parcelaEmprestimoConsignadoTO.getSituacao();
		this.vencimento = parcelaEmprestimoConsignadoTO.getVencimento();
		this.pagamento = parcelaEmprestimoConsignadoTO.getPagamento();
		this.valor = parcelaEmprestimoConsignadoTO.getValor();
		this.valorPago = parcelaEmprestimoConsignadoTO.getValorPago();
	}

	public Long getId() {
		return id;
	}

	public EmprestimoConsignado getEmprestimoConsignado() {
		return emprestimoConsignado;
	}

	public void setEmprestimoConsignado(EmprestimoConsignado emprestimoConsignado) {
		this.emprestimoConsignado = emprestimoConsignado;
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
		ParcelaEmprestimoConsignado other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ParcelaEmprestimoConsignado [id=" + id + ", emprestimoConsignado=" + emprestimoConsignado
				+ ", sequencial=" + sequencial + ", situacao=" + situacao + ", vencimento=" + vencimento
				+ ", pagamento=" + pagamento + ", valor=" + valor + ", valorPago=" + valorPago + "]";
	}

	public void alterar(ParcelaEmprestimoConsignadoTO parcelaEmprestimoConsignadoTO) {
		//FIXME this.emprestimoConsignado = parcelaEmprestimoConsignadoTO.getEmprestimoConsignadoId();
		this.sequencial = parcelaEmprestimoConsignadoTO.getSequencial();
		this.situacao = parcelaEmprestimoConsignadoTO.getSituacao();
		this.vencimento = parcelaEmprestimoConsignadoTO.getVencimento();
		this.pagamento = parcelaEmprestimoConsignadoTO.getPagamento();
		this.valor = parcelaEmprestimoConsignadoTO.getValor();
		this.valorPago = parcelaEmprestimoConsignadoTO.getValorPago();
	}

	public void cancelar() {
		this.situacao = SituacaoParcelaEmprestimoConsignado.CANCELADA;
	}

	public void pagar() {
		this.situacao = SituacaoParcelaEmprestimoConsignado.PAGA;
	}

	public void definirSituacaoParcelaEmprestimoConsignado(
			MudancaSituacaoParcelaEmprestimoConsignadoTO mudancaSituacaoParcelaEmprestimoConsignadoTO) {
		this.situacao = mudancaSituacaoParcelaEmprestimoConsignadoTO.getSituacao();
	}

	public void pagar(PagamentoParcelaEmprestimoConsignadoTO pagamentoParcelaEmprestimoConsignadoTO) {
		this.situacao = SituacaoParcelaEmprestimoConsignado.PAGA;
	}

	public void estonar(EstornoParcelaEmprestimoConsignadoTO estornoParcelaEmprestimoConsignadoTO) {
		this.situacao = SituacaoParcelaEmprestimoConsignado.ESTORNADA;
	}
	
}