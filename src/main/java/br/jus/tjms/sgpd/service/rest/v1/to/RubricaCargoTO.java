package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;

public class RubricaCargoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long rubricaId;
	private Long cargoId;
	private TipoFolhaPagamento tipoFolhaPagamento;
	

	public RubricaCargoTO() {
		super();
	}

	public RubricaCargoTO(Long id, Long rubricaId, Long cargoId, TipoFolhaPagamento tipoFolhaPagamento) {
		super();
		this.id = id;
		this.rubricaId = rubricaId;
		this.cargoId = cargoId;
		this.tipoFolhaPagamento = tipoFolhaPagamento;
	}

	public RubricaCargoTO(Long rubricaId, Long cargoId, TipoFolhaPagamento tipoFolhaPagamento) {
		super();
		this.rubricaId = rubricaId;
		this.cargoId = cargoId;
		this.tipoFolhaPagamento = tipoFolhaPagamento;
	}

	public Long getId() {
		return id;
	}

	public Long getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Long rubricaId) {
		this.rubricaId = rubricaId;
	}

	public Long getCargoId() {
		return cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	public TipoFolhaPagamento getTipoFolhaPagamento() {
		return tipoFolhaPagamento;
	}

	public void setTipoFolhaPagamento(TipoFolhaPagamento tipoFolhaPagamento) {
		this.tipoFolhaPagamento = tipoFolhaPagamento;
	}

	@Override
	public String toString() {
		return "RubricaCargoTO [id=" + id + ", rubricaId=" + rubricaId + ", cargoId=" + cargoId
				+ ", tipoFolhaPagamento=" + tipoFolhaPagamento + "]";
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
		RubricaCargoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}