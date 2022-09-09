package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
public class RequisicaoDiariaDevolucao implements Serializable {

	private static final long serialVersionUID = 8333474623045990310L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "requisicao_id", nullable = false)
	private RequisicaoDiarias requisicao;

	private Double valor;

	public RequisicaoDiariaDevolucao() {
		super();
	}

	public RequisicaoDiariaDevolucao(Long id, Funcionario funcionario, RequisicaoDiarias requisicao, Double valor) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.requisicao = requisicao;
		this.valor = valor;
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

	public RequisicaoDiarias getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(RequisicaoDiarias requisicao) {
		this.requisicao = requisicao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
		RequisicaoDiariaDevolucao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RequisicaoDiariaDevolucao [id=" + id + ", funcionario=" + funcionario + ", requisicao=" + requisicao
				+ ", valor=" + valor + "]";
	}

}