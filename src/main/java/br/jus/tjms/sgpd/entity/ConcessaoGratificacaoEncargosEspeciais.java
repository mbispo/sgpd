package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class ConcessaoGratificacaoEncargosEspeciais implements Serializable {

	private static final long serialVersionUID = -2978716875160963514L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "participacao_id", nullable = true)
	private ParticipacaoComissaoLicitacao participacao;

	@Column(length = 60)
	private String processo;

	private Double valor;
	private Boolean pago;
	private Double valorPago;
	private Date pagamento;

	public ConcessaoGratificacaoEncargosEspeciais() {
		super();
	}

	public ConcessaoGratificacaoEncargosEspeciais(Funcionario funcionario, ParticipacaoComissaoLicitacao participacao,
			String processo, Double valor, Boolean pago, Double valorPago, Date pagamento) {
		super();
		this.funcionario = funcionario;
		this.participacao = participacao;
		this.processo = processo;
		this.valor = valor;
		this.pago = pago;
		this.valorPago = valorPago;
		this.pagamento = pagamento;
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

	public ParticipacaoComissaoLicitacao getParticipacao() {
		return participacao;
	}

	public void setParticipacao(ParticipacaoComissaoLicitacao participacao) {
		this.participacao = participacao;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
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
		ConcessaoGratificacaoEncargosEspeciais other = (ConcessaoGratificacaoEncargosEspeciais) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcessaoGratificacaoEncargosEspeciais [id=" + id + ", funcionario=" + funcionario + ", participacao="
				+ participacao + ", processo=" + processo + ", valor=" + valor + ", pago=" + pago + ", valorPago="
				+ valorPago + ", pagamento=" + pagamento + "]";
	}

}