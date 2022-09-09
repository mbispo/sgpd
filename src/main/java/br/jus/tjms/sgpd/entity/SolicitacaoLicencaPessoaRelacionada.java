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
public class SolicitacaoLicencaPessoaRelacionada implements Serializable {

	private static final long serialVersionUID = 7278561709311802969L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoLicenca solicitacao;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@Column(length = 500)
	private String observacoes;

	public SolicitacaoLicencaPessoaRelacionada() {
		super();
	}

	public SolicitacaoLicencaPessoaRelacionada(Long id, SolicitacaoLicenca solicitacao, Pessoa pessoa,
			String observacoes) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.pessoa = pessoa;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SolicitacaoLicenca getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoLicenca solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		SolicitacaoLicencaPessoaRelacionada other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoLicencaPessoaRelacionada [id=" + id + ", solicitacao=" + solicitacao + ", pessoa=" + pessoa
				+ ", observacoes=" + observacoes + "]";
	}

}