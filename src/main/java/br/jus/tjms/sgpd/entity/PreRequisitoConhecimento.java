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
	@NamedQuery(name = "preRequisitoConhecimento.buscarPorCargo", 
			query = "SELECT p from PreRequisitoConhecimento p WHERE p.cargo.id = :cargoId"),
})
public class PreRequisitoConhecimento implements Serializable {

	private static final long serialVersionUID = -6077116131449050921L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "conhecimento_id", nullable = false)
	private Conhecimento conhecimento;

	public PreRequisitoConhecimento() {
		super();
	}

	public PreRequisitoConhecimento(Long id, Cargo cargo, Conhecimento conhecimento) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.conhecimento = conhecimento;
	}

	public PreRequisitoConhecimento(Cargo cargo, ConhecimentoTO conhecimentoTO) {
		this.cargo = cargo;
		this.conhecimento = new Conhecimento(conhecimentoTO);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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
		PreRequisitoConhecimento other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PreRequisitoConhecimento [id=" + id + ", cargo=" + cargo + ", conhecimento=" + conhecimento + "]";
	}

	public void alterar(Cargo cargo, ConhecimentoTO conhecimentoTO) {
		this.cargo = cargo;
		this.conhecimento = new Conhecimento(conhecimentoTO);
	}
}