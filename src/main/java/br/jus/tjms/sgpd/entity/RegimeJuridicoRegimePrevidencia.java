package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.RegimeJuridicoRegimePrevidenciaTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
public class RegimeJuridicoRegimePrevidencia implements Serializable {

	private static final long serialVersionUID = -1284757145911616188L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "regimeJuridico_id", nullable = false)
	private RegimeJuridico regimeJuridico;

	@ManyToOne
	@JoinColumn(name = "regimePrevidencia_id", nullable = false)
	private RegimePrevidencia regimePrevidencia;

	public RegimeJuridicoRegimePrevidencia() {
		super();
	}

	public RegimeJuridicoRegimePrevidencia(Long id, RegimeJuridico regimeJuridico, RegimePrevidencia regimePrevidencia) {
		super();
		this.id = id;
		this.regimeJuridico = regimeJuridico;
		this.regimePrevidencia = regimePrevidencia;
	}

	public RegimeJuridicoRegimePrevidencia(RegimeJuridicoRegimePrevidenciaTO regimeJuridicoRegimePrevidenciaTO) {
//FIXME	this.regimeJuridico = regimeJuridicoRegimePrevidenciaTO.getRegimeJuridicoId();
//FIXME	this.regimePrevidencia = regimeJuridicoRegimePrevidenciaTO.getRegimePrevidenciaId();
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

	public RegimePrevidencia getRegimePrevidencia() {
		return regimePrevidencia;
	}

	public void setRegimePrevidencia(RegimePrevidencia regimePrevidencia) {
		this.regimePrevidencia = regimePrevidencia;
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
		RegimeJuridicoRegimePrevidencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RegimeJuridicoRegimePrevidencia [id=" + id + ", regimeJuridico=" + regimeJuridico
				+ ", regimePrevidencia=" + regimePrevidencia + "]";
	}

	public void alterar(RegimeJuridicoRegimePrevidenciaTO regimeJuridicoRegimePrevidenciaTO) {
		//FIXME	this.regimeJuridico = regimeJuridicoRegimePrevidenciaTO.getRegimeJuridicoId();
		//FIXME	this.regimePrevidencia = regimeJuridicoRegimePrevidenciaTO.getRegimePrevidenciaId();
	}
}