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
	@NamedQuery(name = "preRequisitoHabilidade.buscarPorCargo", 
			query = "SELECT p from PreRequisitoHabilidade p WHERE p.cargo.id = :cargoId"),
})
public class PreRequisitoHabilidade implements Serializable {

	private static final long serialVersionUID = -9057187293748717589L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "habilidade_id", nullable = false)
	private Habilidade habilidade;

	public PreRequisitoHabilidade() {
		super();
	}

	public PreRequisitoHabilidade(Long id, Cargo cargo, Habilidade habilidade) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.habilidade = habilidade;
	}

	public PreRequisitoHabilidade(Cargo cargo, HabilidadeTO habilidadeTO) {
		this.cargo = cargo;
		this.habilidade = new Habilidade(habilidadeTO);
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
		PreRequisitoHabilidade other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PreRequisitoHabilidade [id=" + id + ", cargo=" + cargo + ", habilidade=" + habilidade + "]";
	}
	
	public void alterar (Cargo cargo, HabilidadeTO habilidadeTO) {
		this.cargo = cargo;
		this.habilidade = new Habilidade(habilidadeTO);
	}

}