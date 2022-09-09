package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.CursoTO;
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
	@NamedQuery(name = "preRequisitoCurso.buscarPorCargo", 
			query = "SELECT p from PreRequisitoCurso p WHERE p.cargo.id = :cargoId"),
})
public class PreRequisitoCurso implements Serializable {

	private static final long serialVersionUID = 3762051967085292125L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false)
	private Curso curso;

	public PreRequisitoCurso() {
		super();
	}

	public PreRequisitoCurso(Long id, Cargo cargo, Curso curso) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.curso = curso;
	}

	public PreRequisitoCurso(Cargo cargo, CursoTO cursoTO) {
		this.cargo = cargo;
		this.curso = new Curso(cursoTO);
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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
		PreRequisitoCurso other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PreRequisitoCurso [id=" + id + ", cargo=" + cargo + ", curso=" + curso + "]";
	}

	public void alterar(Cargo cargo, CursoTO cursoTO) {
		this.cargo = cargo;
		this.curso = new Curso(cursoTO);
	}

}