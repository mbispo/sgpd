package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.AtitudeTO;
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
	@NamedQuery(name = "pessoaAtitude.buscarAtitudesPorPessoa", 
			query = "SELECT pa.atitude from PessoaAtitude pa WHERE pa.pessoa.id = :pessoaId"),
	@NamedQuery(name = "pessoaAtitude.buscarPessoaAtitudePorId", 
	query = "SELECT pa.atitude from PessoaAtitude pa WHERE pa.id = :id")
})
public class PessoaAtitude implements Serializable {
	
	private static final long serialVersionUID = 8871348529869842441L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id", nullable = false)
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="atitude_id", nullable = false)
	private Atitude atitude;

	public PessoaAtitude() {
		super();
	}

	public PessoaAtitude(Long id, Pessoa pessoa, Atitude atitude) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.atitude = atitude;
	}

	public PessoaAtitude(AtitudeTO atitudeTO, Pessoa pessoa) {
		this.pessoa = pessoa;
		//FIXME this.atitude = atitudeTO;
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

	public Atitude getAtitude() {
		return atitude;
	}

	public void setAtitude(Atitude atitude) {
		this.atitude = atitude;
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
		PessoaAtitude other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	
	@Override
	public String toString() {
		return "PessoaAtitude [id=" + id + ", pessoa=" + pessoa + ", atitude=" + atitude + "]";
	}

	public void alterar(AtitudeTO atitudeTO) {
		//FIXME this.atitude = atitudeTO;
	}

}