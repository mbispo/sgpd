package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:04
 */
@Entity
@Auditavel
@Cacheable
public class SolicitacaoDesignacaoTempoIntegralFuncionario implements Serializable {

	private static final long serialVersionUID = 5395460183133880848L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoDesignacaoTempoIntegral solicitacao;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	public SolicitacaoDesignacaoTempoIntegralFuncionario() {
		super();
	}

	public SolicitacaoDesignacaoTempoIntegralFuncionario(Long id, SolicitacaoDesignacaoTempoIntegral solicitacao,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.funcionario = funcionario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SolicitacaoDesignacaoTempoIntegral getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoDesignacaoTempoIntegral solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
		SolicitacaoDesignacaoTempoIntegralFuncionario other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoDesignacaoTempoIntegralFuncionario [id=" + id + ", solicitacao=" + solicitacao
				+ ", funcionario=" + funcionario + "]";
	}

}