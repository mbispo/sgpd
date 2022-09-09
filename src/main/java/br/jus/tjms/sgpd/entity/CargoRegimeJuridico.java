package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.RegimeJuridicoTO;
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
	@NamedQuery(name = "cargoRegimeJuridico.buscarPorCargo", 
			query = "SELECT c from CargoRegimeJuridico c WHERE c.cargo.id = :cargoId")
})
public class CargoRegimeJuridico implements Serializable {

	private static final long serialVersionUID = 407607977512888270L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "regimeJuridico_id", nullable = false)
	private RegimeJuridico regimeJuridico;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	public CargoRegimeJuridico() {
		super();
	}

	public CargoRegimeJuridico(Long id, RegimeJuridico regimeJuridico, Cargo cargo) {
		super();
		this.id = id;
		this.regimeJuridico = regimeJuridico;
		this.cargo = cargo;
	}

	public CargoRegimeJuridico(Cargo cargo, RegimeJuridicoTO regimeJuridicoTO) {
		this.regimeJuridico = new RegimeJuridico(regimeJuridicoTO);
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegimeJuridico getRegimeJuridico() {
		return regimeJuridico;
	}

	public void setRegimeJuridico(RegimeJuridico regimeJuridico) {
		this.regimeJuridico = regimeJuridico;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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
		CargoRegimeJuridico other = (CargoRegimeJuridico) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CargoRegimeJuridico [id=" + id + ", regimeJuridico=" + regimeJuridico + ", cargo=" + cargo + "]";
	}

	public void alterar(Cargo cargo, RegimeJuridicoTO regimeJuridicoTO) {
		this.regimeJuridico = new RegimeJuridico(regimeJuridicoTO);
		this.cargo = cargo;
	}

}