package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.ExperienciaTO;
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
	@NamedQuery(name = "preRequisitoExperiencia.buscarPorExperiencia", 
			query = "SELECT p from PreRequisitoExperiencia p WHERE p.cargo.id = :cargoId"),
})
public class PreRequisitoExperiencia implements Serializable {

	private static final long serialVersionUID = 1873026520847878601L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@Column(length = 200)
	private String descricao;

	public PreRequisitoExperiencia() {
		super();
	}

	public PreRequisitoExperiencia(Long id, Cargo cargo, String descricao) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.descricao = descricao;
	}

	public PreRequisitoExperiencia(Cargo cargo, ExperienciaTO experienciaTO) {
		this.cargo = cargo;
		this.descricao = experienciaTO.getDescricao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		PreRequisitoExperiencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PreRequisitoExperiencia [id=" + id + ", cargo=" + cargo + ", descricao=" + descricao + "]";
	}

	public void alterar(Cargo cargo, ExperienciaTO experienciaTO) {
		this.cargo = cargo;
		this.descricao = experienciaTO.getDescricao();
	}

}