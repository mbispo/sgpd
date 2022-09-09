package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AtualizacaoDadosCadastrais implements Serializable {

	private static final long serialVersionUID = 6756351126733148932L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoAtualizacaoDadosCadastrais solicitacao;

	private Date dataAtualizacao;

	public AtualizacaoDadosCadastrais() {
		super();
	}

	public AtualizacaoDadosCadastrais(Long id, Funcionario funcionario,
			SolicitacaoAtualizacaoDadosCadastrais solicitacao, Date dataAtualizacao) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.solicitacao = solicitacao;
		this.dataAtualizacao = dataAtualizacao;
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

	public SolicitacaoAtualizacaoDadosCadastrais getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoAtualizacaoDadosCadastrais solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
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
		AtualizacaoDadosCadastrais other = (AtualizacaoDadosCadastrais) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "AtualizacaoDadosCadastrais [id=" + id + ", funcionario=" + funcionario + ", solicitacao=" + solicitacao
				+ "]";
	}

}