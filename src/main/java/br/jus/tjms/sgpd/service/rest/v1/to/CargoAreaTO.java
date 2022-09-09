package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CargoAreaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long cargoId;
	private Long areaId;

	public CargoAreaTO() {
		super();
	}

	public CargoAreaTO(Long id, Long cargoId, Long areaId) {
		super();
		this.id = id;
		this.cargoId = cargoId;
		this.areaId = areaId;
	}

	public CargoAreaTO(Long cargoId, Long areaId) {
		super();
		this.cargoId = cargoId;
		this.areaId = areaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCargoId() {
		return cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	@Override
	public String toString() {
		return "CargoAreaTO [id=" + id + ", cargoId=" + cargoId + ", areaId=" + areaId + "]";
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
		CargoAreaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}