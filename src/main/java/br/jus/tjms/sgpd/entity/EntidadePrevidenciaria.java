package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.EntidadePrevidenciariaTO;
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
public class EntidadePrevidenciaria implements Serializable {

	private static final long serialVersionUID = -5687977843456746691L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	public EntidadePrevidenciaria() {
		super();
	}

	public EntidadePrevidenciaria(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public EntidadePrevidenciaria(EntidadePrevidenciariaTO entidadePrevidenciariaTO) {
		this.nome = entidadePrevidenciariaTO.getNome();
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
		EntidadePrevidenciaria other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "EntidadePrevidenciaria [id=" + id + ", nome=" + nome + "]";
	}

	public void alterar(EntidadePrevidenciariaTO entidadePrevidenciariaTO) {
		this.nome = entidadePrevidenciariaTO.getNome();
	}

}