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
 * @created 11-dez-2015 18:15:36
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class CompatibilidadeFPASClassificacaoTributaria implements Serializable {

	private static final long serialVersionUID = -7419597098976687116L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer codigoFPAS;

	@ManyToOne
	@JoinColumn(name = "classificacaoTributaria_id", nullable = false)
	private ClassificacaoTributaria classificacaoTributaria;

	public CompatibilidadeFPASClassificacaoTributaria() {
		super();
	}

	public CompatibilidadeFPASClassificacaoTributaria(Long id, Integer codigoFPAS,
			ClassificacaoTributaria classificacaoTributaria) {
		super();
		this.id = id;
		this.codigoFPAS = codigoFPAS;
		this.classificacaoTributaria = classificacaoTributaria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigoFPAS() {
		return codigoFPAS;
	}

	public void setCodigoFPAS(Integer codigoFPAS) {
		this.codigoFPAS = codigoFPAS;
	}

	public ClassificacaoTributaria getClassificacaoTributaria() {
		return classificacaoTributaria;
	}

	public void setClassificacaoTributaria(ClassificacaoTributaria classificacaoTributaria) {
		this.classificacaoTributaria = classificacaoTributaria;
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
		CompatibilidadeFPASClassificacaoTributaria other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CompatibilidadeFPASClassificacaoTributaria [id=" + id + ", codigoFPAS=" + codigoFPAS
				+ ", classificacaoTributaria=" + classificacaoTributaria + "]";
	}

}