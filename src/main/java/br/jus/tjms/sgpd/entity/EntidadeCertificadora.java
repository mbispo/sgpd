package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.EntidadeCertificadoraTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:57
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "entidadeCertificadora.buscarEntidadesCertificadorasPorNome", 
		query = "SELECT e from EntidadeCertificadora e WHERE e.nome = :nome")
})
public class EntidadeCertificadora implements Serializable {

	private static final long serialVersionUID = -896836094850120107L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	public EntidadeCertificadora() {
		super();
	}

	public EntidadeCertificadora(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public EntidadeCertificadora(EntidadeCertificadoraTO entidadeCertificadoraTO) {
		this.nome = entidadeCertificadoraTO.getNome();
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
		EntidadeCertificadora other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "EntidadeCertificadora [id=" + id + ", nome=" + nome + "]";
	}

	public void alterar(EntidadeCertificadoraTO entidadeCertificadoraTO) {
		this.nome = entidadeCertificadoraTO.getNome();
	}

}