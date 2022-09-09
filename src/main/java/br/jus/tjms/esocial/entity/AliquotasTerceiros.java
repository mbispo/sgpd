package br.jus.tjms.esocial.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class AliquotasTerceiros implements Serializable {

	private static final long serialVersionUID = -6405188399248657830L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "terceiro_id", nullable = false)
	private Terceiro terceiro;

	@ManyToOne
	@JoinColumn(name = "codigoAliquotaFPASTerceiros_id", nullable = false)
	private CodigoAliquotaFPASTerceiros codigoAliquotaFPASTerceiros;

	public AliquotasTerceiros() {
		super();
	}

	public AliquotasTerceiros(Long id, Terceiro terceiro, CodigoAliquotaFPASTerceiros codigoAliquotaFPASTerceiros) {
		super();
		this.id = id;
		this.terceiro = terceiro;
		this.codigoAliquotaFPASTerceiros = codigoAliquotaFPASTerceiros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Terceiro getTerceiro() {
		return terceiro;
	}

	public void setTerceiro(Terceiro terceiro) {
		this.terceiro = terceiro;
	}

	public CodigoAliquotaFPASTerceiros getCodigoAliquotaFPASTerceiros() {
		return codigoAliquotaFPASTerceiros;
	}

	public void setCodigoAliquotaFPASTerceiros(CodigoAliquotaFPASTerceiros codigoAliquotaFPASTerceiros) {
		this.codigoAliquotaFPASTerceiros = codigoAliquotaFPASTerceiros;
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
		AliquotasTerceiros other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "AliquotasTerceiros [id=" + id + ", terceiro=" + terceiro + ", codigoAliquotaFPASTerceiros="
				+ codigoAliquotaFPASTerceiros + "]";
	}

}