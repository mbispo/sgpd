package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class DesignacaoTempoIntegralFuncionario implements Serializable {

	private static final long serialVersionUID = 413089382970386906L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="designacao_id", nullable = false)
	private DesignacaoAdicionalTempoIntegral designacao;
	
	@ManyToOne
	@JoinColumn(name="funcionario_id", nullable = false)
	private Funcionario funcionario;

	public DesignacaoTempoIntegralFuncionario(){
		super();
	}

	public DesignacaoTempoIntegralFuncionario(Long id, DesignacaoAdicionalTempoIntegral designacao,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.designacao = designacao;
		this.funcionario = funcionario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DesignacaoAdicionalTempoIntegral getDesignacao() {
		return designacao;
	}

	public void setDesignacao(DesignacaoAdicionalTempoIntegral designacao) {
		this.designacao = designacao;
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
		DesignacaoTempoIntegralFuncionario other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	@Override
	public String toString() {
		return "DesignacaoTempoIntegralFuncionario [id=" + id + ", designacao=" + designacao + ", funcionario="
				+ funcionario + "]";
	}
	
}