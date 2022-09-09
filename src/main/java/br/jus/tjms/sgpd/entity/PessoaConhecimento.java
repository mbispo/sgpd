package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.ConhecimentoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "pessoaConhecimento.buscarConhecimentosPorPessoa", 
			query = "SELECT pc.conhecimento from PessoaConhecimento pc WHERE pc.pessoa.id = :pessoaId"),
	@NamedQuery(name = "pessoaConhecimento.buscarConhecimentosPorId", 
	query = "SELECT pc from PessoaConhecimento pc WHERE pc.id = :id")
})
public class PessoaConhecimento implements Serializable {

	private static final long serialVersionUID = 2876138926539736039L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "conhecimento_id", nullable = false)
	private Conhecimento conhecimento;

	public PessoaConhecimento() {
		super();
	}

	public PessoaConhecimento(Long id, Pessoa pessoa, Conhecimento conhecimento) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.conhecimento = conhecimento;
	}

	public PessoaConhecimento(ConhecimentoTO conhecimentoTO, Pessoa pessoa) {
		this.pessoa = pessoa;
		//FIXME this.conhecimento = conhecimentoTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Conhecimento getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(Conhecimento conhecimento) {
		this.conhecimento = conhecimento;
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
		PessoaConhecimento other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PessoaConhecimento [id=" + id + ", pessoa=" + pessoa + ", conhecimento=" + conhecimento + "]";
	}

	public void alterar(ConhecimentoTO conhecimentoTO) {
		//FIXME this.conhecimento = conhecimentoTO;
	}

}