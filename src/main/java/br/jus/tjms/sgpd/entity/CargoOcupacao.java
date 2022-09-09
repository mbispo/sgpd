package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.OcupacaoTO;
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
	@NamedQuery(name = "cargoOcupacao.buscarPorCargo", 
			query = "SELECT c from CargoOcupacao c WHERE c.cargo.id = :cargoId"),
})
public class CargoOcupacao implements Serializable {

	private static final long serialVersionUID = 108187169395492093L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "ocupacao_id", nullable = false)
	private Ocupacao ocupacao;

	public CargoOcupacao() {
		super();
	}

	public CargoOcupacao(Long id) {
		super();
		this.id = id;
	}

	public CargoOcupacao(Long id, Cargo cargo, Ocupacao ocupacao) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.ocupacao = ocupacao;
	}

	public CargoOcupacao(Cargo cargo, OcupacaoTO ocupacaoTO) {
		this.cargo = cargo;
		this.ocupacao = new Ocupacao(ocupacaoTO);
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

	public Ocupacao getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
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
		CargoOcupacao other = (CargoOcupacao) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CargoOcupacao [id=" + id + ", cargo=" + cargo + ", ocupacao=" + ocupacao + "]";
	}
	
	public void alterar(Cargo cargo, OcupacaoTO ocupacaoTO) {
		this.cargo = cargo;
		this.ocupacao = new Ocupacao(ocupacaoTO);
	}
}