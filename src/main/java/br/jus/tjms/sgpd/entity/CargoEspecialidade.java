package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.EspecialidadeTO;
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
	@NamedQuery(name = "cargoEspecialidade.buscarPorCargo", 
			query = "SELECT c from CargoEspecialidade c WHERE c.cargo.id = :cargoId")
})
public class CargoEspecialidade implements Serializable {

	private static final long serialVersionUID = -6239836999096771363L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "especialidade_id", nullable = false)
	private Especialidade especialidade;

	public CargoEspecialidade() {
		super();
	}

	public CargoEspecialidade(Long id) {
		super();
		this.id = id;
	}

	public CargoEspecialidade(Long id, Cargo cargo, Especialidade especialidade) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.especialidade = especialidade;
	}

	public CargoEspecialidade(Cargo cargo, EspecialidadeTO especialidadeTO) {
		this.cargo = cargo;
		this.especialidade = new Especialidade(especialidadeTO);
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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
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
		CargoEspecialidade other = (CargoEspecialidade) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CargoEspecialidade [id=" + id + ", cargo=" + cargo + ", especialidade=" + especialidade + "]";
	}

	public void alterar(EspecialidadeTO especialidadeTO) {
		this.especialidade = new Especialidade(especialidadeTO);
	}

}