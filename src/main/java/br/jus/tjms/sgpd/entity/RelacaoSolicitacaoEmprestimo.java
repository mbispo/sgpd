package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
public class RelacaoSolicitacaoEmprestimo implements Serializable {

	private static final long serialVersionUID = -5481484378508991055L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoEmprestimoConsignado solicitacao;

	@ManyToOne
	@JoinColumn(name = "emprestimo_id", nullable = false)
	private EmprestimoConsignado emprestimo;

	public RelacaoSolicitacaoEmprestimo() {
		super();
	}

	public RelacaoSolicitacaoEmprestimo(Long id, SolicitacaoEmprestimoConsignado solicitacao,
			EmprestimoConsignado emprestimo) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.emprestimo = emprestimo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SolicitacaoEmprestimoConsignado getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoEmprestimoConsignado solicitacao) {
		this.solicitacao = solicitacao;
	}

	public EmprestimoConsignado getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(EmprestimoConsignado emprestimo) {
		this.emprestimo = emprestimo;
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
		RelacaoSolicitacaoEmprestimo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RelacaoSolicitacaoEmprestimo [id=" + id + ", solicitacao=" + solicitacao + ", emprestimo=" + emprestimo
				+ "]";
	}

}