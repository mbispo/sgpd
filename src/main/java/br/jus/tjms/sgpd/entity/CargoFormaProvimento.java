package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.FormaProvimento;
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
	@NamedQuery(name = "cargoFormaProvimento.buscarPorCargo", 
			query = "SELECT c from CargoFormaProvimento c WHERE c.cargo.id = :cargoId")
})
public class CargoFormaProvimento implements Serializable {

	private static final long serialVersionUID = -1440570459560704004L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@Enumerated(EnumType.ORDINAL)
	private FormaProvimento formaProvimento;

	public CargoFormaProvimento() {
		super();
	}

	public CargoFormaProvimento(Cargo cargo, FormaProvimento formaProvimento) {
		this.cargo = cargo;
		this.formaProvimento = formaProvimento;
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

	public FormaProvimento getFormaProvimento() {
		return formaProvimento;
	}

	public void setFormaProvimento(FormaProvimento formaProvimento) {
		this.formaProvimento = formaProvimento;
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
		CargoFormaProvimento other = (CargoFormaProvimento) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CargoFormaProvimento [id=" + id + ", cargo=" + cargo + ", formaProvimento=" + formaProvimento + "]";
	}

	public void alterar(Cargo cargo, FormaProvimento formaProvimento) {
		this.cargo = cargo;
		this.formaProvimento = formaProvimento;
	}

}