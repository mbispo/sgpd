package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;
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
	@NamedQuery(name = "cargoTipoProvimento.buscarPorCargo", 
			query = "SELECT c from CargoTipoProvimento c WHERE c.cargo.id = :cargoId"),
})
public class CargoTipoProvimento implements Serializable {

	private static final long serialVersionUID = -464162088005837939L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@Enumerated(EnumType.ORDINAL)
	private TipoProvimento tipoProvimento;

	public CargoTipoProvimento() {
		super();
	}

	public CargoTipoProvimento(Long id, Cargo cargo, TipoProvimento tipoProvimento) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.tipoProvimento = tipoProvimento;
	}

	public CargoTipoProvimento(Cargo cargo, TipoProvimento tipoProvimento) {
		this.cargo = cargo;
		this.tipoProvimento = tipoProvimento;
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

	public TipoProvimento getTipoProvimento() {
		return tipoProvimento;
	}

	public void setTipoProvimento(TipoProvimento tipoProvimento) {
		this.tipoProvimento = tipoProvimento;
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
		CargoTipoProvimento other = (CargoTipoProvimento) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CargoTipoProvimento [id=" + id + ", cargo=" + cargo + ", tipoProvimento=" + tipoProvimento + "]";
	}

	public void alterar(Cargo cargo, TipoProvimento tipoProvimento) {
		this.cargo = cargo;
		this.tipoProvimento = tipoProvimento;
	}

}