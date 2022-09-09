package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaCargoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "rubricaCargo.buscarRubricasPorCargo", 
			query = "SELECT r.rubrica FROM RubricaCargo r WHERE r.cargo.id = :cargoId"),
})
public class RubricaCargo implements Serializable {

	private static final long serialVersionUID = 409493201972350419L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@FolowField
	@ManyToOne
	@JoinColumn(name="rubrica_id", nullable = false)
	private Rubrica rubrica;
	
	@ManyToOne
	@JoinColumn(name="cargo_id", nullable = false)
	private Cargo cargo;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoFolhaPagamento tipoFolhaPagamento;

	public RubricaCargo() {
		super();
	}

	public RubricaCargo(Long id, Rubrica rubrica, Cargo cargo, TipoFolhaPagamento tipoFolhaPagamento) {
		super();
		this.id = id;
		this.rubrica = rubrica;
		this.cargo = cargo;
		this.tipoFolhaPagamento = tipoFolhaPagamento;
	}
	
	public RubricaCargo(Rubrica rubrica, Cargo cargo, TipoFolhaPagamento tipoFolhaPagamento) {
		super();
		this.rubrica = rubrica;
		this.cargo = cargo;
		this.tipoFolhaPagamento = tipoFolhaPagamento;
	}
	
	public RubricaCargo(RubricaCargoTO rubricaCargoTO) {
		this.rubrica = new Rubrica(rubricaCargoTO.getRubricaId());
		this.cargo = new Cargo(rubricaCargoTO.getCargoId());
		this.tipoFolhaPagamento = rubricaCargoTO.getTipoFolhaPagamento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public TipoFolhaPagamento getTipoFolhaPagamento() {
		return tipoFolhaPagamento;
	}

	public void setTipoFolhaPagamento(TipoFolhaPagamento tipoFolhaPagamento) {
		this.tipoFolhaPagamento = tipoFolhaPagamento;
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
		RubricaCargo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RubricaCargo [id=" + id + ", rubrica=" + rubrica + ", cargo=" + cargo + ", tipoFolhaPagamento="
				+ tipoFolhaPagamento + "]";
	}

	public void alterar(RubricaCargoTO rubricaCargoTO) {
		this.rubrica = new Rubrica(rubricaCargoTO.getRubricaId());
		this.cargo = new Cargo(rubricaCargoTO.getCargoId());
		this.tipoFolhaPagamento = rubricaCargoTO.getTipoFolhaPagamento();
	}
}