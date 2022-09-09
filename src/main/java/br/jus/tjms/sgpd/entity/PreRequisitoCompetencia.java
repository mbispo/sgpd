package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.CompetenciaTO;
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
	@NamedQuery(name = "preRequisitoCompetencia.buscarPorCargo", 
			query = "SELECT p from PreRequisitoCompetencia p WHERE p.cargo.id = :cargoId"),
})
public class PreRequisitoCompetencia implements Serializable {

	private static final long serialVersionUID = -6739971253423395555L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "competencia_id", nullable = false)
	private Competencia competencia;

	public PreRequisitoCompetencia() {
		super();
	}

	public PreRequisitoCompetencia(Long id, Cargo cargo, Competencia competencia) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.competencia = competencia;
	}

	public PreRequisitoCompetencia(Cargo cargo, CompetenciaTO competenciaTO) {
		this.cargo = cargo;
		this.competencia = new Competencia(competenciaTO);
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

	public Competencia getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
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
		PreRequisitoCompetencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PreRequisitoCompetencia [id=" + id + ", cargo=" + cargo + ", competencia=" + competencia + "]";
	}

	public void alterar(Cargo cargo, CompetenciaTO competenciaTO) {
		this.cargo = cargo;
		this.competencia = new Competencia(competenciaTO);
	}
}