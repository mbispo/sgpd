package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.HabilidadeTO;
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
	@NamedQuery(name = "pessoaHabilidade.buscarHabilidadesPorPessoa", 
			query = "SELECT ph.habilidade from PessoaHabilidade ph WHERE ph.pessoa.id = :pessoaId"),
	@NamedQuery(name = "pessoaHabilidade.buscarHabilidadesPorId", 
	query = "SELECT pc from PessoaHabilidade pc WHERE pc.id = :id")
})
public class PessoaHabilidade implements Serializable {

	private static final long serialVersionUID = -3835859063857480094L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id", nullable = false)
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="habilidade_id", nullable = false)
	private Habilidade habilidade;

	public PessoaHabilidade() {
		super();
	}

	public PessoaHabilidade(Long id, Pessoa pessoa, Habilidade habilidade) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.habilidade = habilidade;
	}

	public PessoaHabilidade(HabilidadeTO habilidadeTO, Pessoa pessoa) {
		this.pessoa = pessoa;
		//FIXME this.habilidade = habilidadeTO;
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

	public Habilidade getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
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
		PessoaHabilidade other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	@Override
	public String toString() {
		return "PessoaHabilidade [id=" + id + ", pessoa=" + pessoa + ", habilidade=" + habilidade + "]";
	}

	public void alterar(PessoaHabilidade pessoaHabilidade) {
		//FIXME this.habilidade = habilidadeTO;
	}

}