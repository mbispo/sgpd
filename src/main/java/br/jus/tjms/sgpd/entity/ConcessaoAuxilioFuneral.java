package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
public class ConcessaoAuxilioFuneral implements Serializable {

	private static final long serialVersionUID = 6073999444818661167L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "requerimento_id", nullable = true)
	private RequerimentoAuxilioFuneral requerimento;

	@ManyToOne
	@JoinColumn(name = "beneficiario_id", nullable = false)
	private Pessoa beneficiario;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@Column(length = 60)
	private String processo;

	private Boolean pagamentoAgendado;
	private Double valor;
	private Date dataPagamento;

	public ConcessaoAuxilioFuneral() {
		super();

	}

	public ConcessaoAuxilioFuneral(Long id, RequerimentoAuxilioFuneral requerimento, Pessoa beneficiario,
			Funcionario funcionario, String processo, Boolean pagamentoAgendado, Double valor, Date dataPagamento) {
		super();
		this.id = id;
		this.requerimento = requerimento;
		this.beneficiario = beneficiario;
		this.funcionario = funcionario;
		this.processo = processo;
		this.pagamentoAgendado = pagamentoAgendado;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Pessoa beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Boolean getPagamentoAgendado() {
		return pagamentoAgendado;
	}

	public void setPagamentoAgendado(Boolean pagamentoAgendado) {
		this.pagamentoAgendado = pagamentoAgendado;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public RequerimentoAuxilioFuneral getRequerimento() {
		return requerimento;
	}

	public void setRequerimento(RequerimentoAuxilioFuneral requerimento) {
		this.requerimento = requerimento;
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
		ConcessaoAuxilioFuneral other = (ConcessaoAuxilioFuneral) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcessaoAuxilioFuneral [id=" + id + ", requerimento=" + requerimento + ", beneficiario="
				+ beneficiario + ", funcionario=" + funcionario + ", processo=" + processo + ", pagamentoAgendado="
				+ pagamentoAgendado + ", valor=" + valor + ", dataPagamento=" + dataPagamento + "]";
	}

}