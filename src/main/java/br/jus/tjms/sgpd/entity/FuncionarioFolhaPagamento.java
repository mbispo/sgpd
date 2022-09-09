package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.FuncionarioFolhaPagamentoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "funcionarioFolhaPagamento.buscarFuncionariosPorFolhaPagamentoId", 
			query = "SELECT distinct f.funcionario FROM FuncionarioFolhaPagamento f WHERE f.folhaPagamento.id = :id" )
})

public class FuncionarioFolhaPagamento implements Serializable {

	private static final long serialVersionUID = -8647803370955158051L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "folhaPagamento_id", nullable = false)
	private FolhaPagamento folhaPagamento;

	public FuncionarioFolhaPagamento() {
		super();
	}

	public FuncionarioFolhaPagamento(Funcionario funcionario, FolhaPagamento folhaPagamento) {
		super();
		this.funcionario = funcionario;
		this.folhaPagamento = folhaPagamento;
	}

	public FuncionarioFolhaPagamento(Long id, Funcionario funcionario, FolhaPagamento folhaPagamento) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.folhaPagamento = folhaPagamento;
	}
	
	public FuncionarioFolhaPagamento(FuncionarioFolhaPagamentoTO to) {
		this.id = to.getId();
		this.folhaPagamento = new FolhaPagamento(to.getFolhaPagamentoId());
		this.funcionario = new Funcionario(to.getFuncionarioId());
	}
	
	public FuncionarioFolhaPagamento(Long funcionarioId, FolhaPagamento folhaPagamento) {
		this.folhaPagamento = folhaPagamento;
		this.funcionario = new Funcionario(funcionarioId);
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

	public FolhaPagamento getFolhaPagamento() {
		return folhaPagamento;
	}

	public void setFolhaPagamento(FolhaPagamento folhaPagamento) {
		this.folhaPagamento = folhaPagamento;
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
		FuncionarioFolhaPagamento other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FuncionarioFolhaPagamento [id=" + id + ", funcionario=" + funcionario + ", folhaPagamento="
				+ folhaPagamento + "]";
	}

	public FuncionarioFolhaPagamentoTO toTO() {
		return new FuncionarioFolhaPagamentoTO(id, funcionario.getId(), folhaPagamento.getId());
	}

}