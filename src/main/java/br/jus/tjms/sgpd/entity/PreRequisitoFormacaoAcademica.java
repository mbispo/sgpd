package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoFormacaoAcademica;
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
	@NamedQuery(name = "preRequisitoFormacaoAcademica.buscarPorFormacaoAcademica", 
			query = "SELECT p from PreRequisitoFormacaoAcademica p WHERE p.cargo.id = :cargoId"),
})
public class PreRequisitoFormacaoAcademica implements Serializable {

	private static final long serialVersionUID = -6991339391572591684L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@Enumerated(EnumType.ORDINAL)
	private TipoFormacaoAcademica tipo;

	public PreRequisitoFormacaoAcademica() {
		super();
	}

	public PreRequisitoFormacaoAcademica(Long id, Cargo cargo, TipoFormacaoAcademica tipo) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.tipo = tipo;
	}

	public PreRequisitoFormacaoAcademica(Cargo cargo, TipoFormacaoAcademica tipoFormacaoAcademica) {
		this.cargo = cargo;
		this.tipo = tipoFormacaoAcademica;
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

	public TipoFormacaoAcademica getTipo() {
		return tipo;
	}

	public void setTipo(TipoFormacaoAcademica tipo) {
		this.tipo = tipo;
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
		PreRequisitoFormacaoAcademica other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PreRequisitoFormacaoAcademica [id=" + id + ", cargo=" + cargo + ", tipo=" + tipo + "]";
	}

	public void alterar(Cargo cargo, TipoFormacaoAcademica tipoFormacaoAcademica) {
		this.cargo = cargo;
		this.tipo = tipoFormacaoAcademica;
	}

}