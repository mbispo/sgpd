package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ReferenciaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String sigla;
	private Integer nivel;
	private Long cargoId;
	private List<ReferenciaValorTO> valores = new ArrayList<ReferenciaValorTO>();

	public ReferenciaTO() {
		super();
	}

	public ReferenciaTO(Long id, String sigla, Integer nivel, Long cargoId, List<ReferenciaValorTO> valores) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nivel = nivel;
		this.cargoId = cargoId;
		this.valores = valores;
	}

	public ReferenciaTO(String sigla, Integer nivel, Long cargoId, List<ReferenciaValorTO> valores) {
		super();
		this.sigla = sigla;
		this.nivel = nivel;
		this.cargoId = cargoId;
		this.valores = valores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Long getCargoId() {
		return cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	public List<ReferenciaValorTO> getValores() {
		return valores;
	}

	public void setValores(List<ReferenciaValorTO> valores) {
		this.valores = valores;
	}

	@Override
	public String toString() {
		return "ReferenciaTO [id=" + id + ", sigla=" + sigla + ", nivel=" + nivel + ", cargoId=" + cargoId
				+ ", valores=" + valores + "]";
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
		ReferenciaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}