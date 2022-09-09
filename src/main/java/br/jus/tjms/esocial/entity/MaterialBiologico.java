package br.jus.tjms.esocial.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.esocial.enumerators.TipoMaterialBiologico;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:42
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class MaterialBiologico implements Serializable {

	private static final long serialVersionUID = -6581216421018322605L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	private TipoMaterialBiologico material;

	@ManyToOne
	@JoinColumn(name = "agenteQuimico_id", nullable = false)
	private ResultadoMonitoracaoBiologica agenteQuimico;

	public MaterialBiologico() {
		super();
	}

	public MaterialBiologico(Long id, TipoMaterialBiologico material, ResultadoMonitoracaoBiologica agenteQuimico) {
		super();
		this.id = id;
		this.material = material;
		this.agenteQuimico = agenteQuimico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoMaterialBiologico getMaterial() {
		return material;
	}

	public void setMaterial(TipoMaterialBiologico material) {
		this.material = material;
	}

	public ResultadoMonitoracaoBiologica getAgenteQuimico() {
		return agenteQuimico;
	}

	public void setAgenteQuimico(ResultadoMonitoracaoBiologica agenteQuimico) {
		this.agenteQuimico = agenteQuimico;
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
		MaterialBiologico other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "MaterialBiologico [id=" + id + ", material=" + material + ", agenteQuimico=" + agenteQuimico + "]";
	}

}