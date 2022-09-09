package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CargoAreaEstoqueTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long cargoAreaId;
	private Long ocupacaoId;
	private Long especialidadeId;
	private Date data;
	private Integer estoque;

	public CargoAreaEstoqueTO() {
		super();
	}

	public CargoAreaEstoqueTO(Long id, Long cargoAreaId, Long ocupacaoId, Long especialidadeId, Date data,
			Integer estoque) {
		super();
		this.id = id;
		this.cargoAreaId = cargoAreaId;
		this.ocupacaoId = ocupacaoId;
		this.especialidadeId = especialidadeId;
		this.data = data;
		this.estoque = estoque;
	}

	public CargoAreaEstoqueTO(Long cargoAreaId, Long ocupacaoId, Long especialidadeId, Date data, Integer estoque) {
		super();
		this.cargoAreaId = cargoAreaId;
		this.ocupacaoId = ocupacaoId;
		this.especialidadeId = especialidadeId;
		this.data = data;
		this.estoque = estoque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCargoAreaId() {
		return cargoAreaId;
	}

	public void setCargoAreaId(Long cargoAreaId) {
		this.cargoAreaId = cargoAreaId;
	}

	public Long getOcupacaoId() {
		return ocupacaoId;
	}

	public void setOcupacaoId(Long ocupacaoId) {
		this.ocupacaoId = ocupacaoId;
	}

	public Long getEspecialidadeId() {
		return especialidadeId;
	}

	public void setEspecialidadeId(Long especialidadeId) {
		this.especialidadeId = especialidadeId;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "CargoAreaEstoqueTO [id=" + id + ", cargoAreaId=" + cargoAreaId + ", ocupacaoId=" + ocupacaoId
				+ ", especialidadeId=" + especialidadeId + ", data=" + data + ", estoque=" + estoque + "]";
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
		CargoAreaEstoqueTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}