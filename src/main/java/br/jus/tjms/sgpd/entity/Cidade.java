package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.CidadeTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "cidade.buscarCidadesPorNome", 
			query = "SELECT c from Cidade c WHERE c.nome = :nome"),
	@NamedQuery(name = "cidade.buscarCidadesPorEstado", 
	query = "SELECT c from Cidade c WHERE c.estado.id = :id")
})
public class Cidade implements Serializable {

	private static final long serialVersionUID = -6922954838226343164L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "estado_id", nullable = false)
	private Estado estado;

	public Cidade() {
		super();
	}

	public Cidade(Long id, String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}
	
	public Cidade(CidadeTO cidadeTO) {
		super();
		this.id = cidadeTO.getId();
		this.nome = cidadeTO.getNome();
		
		if (cidadeTO.getEstado()!=null)
			this.estado = new Estado(cidadeTO.getEstado());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		Cidade other = (Cidade) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
	}

	public void alterar(CidadeTO cidadeTO) {
		this.nome = cidadeTO.getNome();
		//FIXME this.estado = cidadeTO.getEstado();
	}

}