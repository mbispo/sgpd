package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CargoHistoricoNomeTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long cargoId;
	private Long atoAdministrativoId;
	private String nome;
	private Date vigenciaInicio;
	private Date vigenciaFim;

	public CargoHistoricoNomeTO() {
		super();
	}

	public CargoHistoricoNomeTO(Long id, Long cargoId, Long atoAdministrativoId, String nome, Date vigenciaInicio,
			Date vigenciaFim) {
		super();
		this.id = id;
		this.cargoId = cargoId;
		this.atoAdministrativoId = atoAdministrativoId;
		this.nome = nome;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
	}

	public CargoHistoricoNomeTO(Long cargoId, Long atoAdministrativoId, String nome, Date vigenciaInicio,
			Date vigenciaFim) {
		super();
		this.cargoId = cargoId;
		this.atoAdministrativoId = atoAdministrativoId;
		this.nome = nome;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
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

	public Long getAtoAdministrativoId() {
		return atoAdministrativoId;
	}

	public void setAtoAdministrativoId(Long atoAdministrativoId) {
		this.atoAdministrativoId = atoAdministrativoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	@Override
	public String toString() {
		return "CargoHistoricoNomeTO [id=" + id + ", cargoId=" + cargoId + ", atoAdministrativoId="
				+ atoAdministrativoId + ", nome=" + nome + ", vigenciaInicio=" + vigenciaInicio + ", vigenciaFim="
				+ vigenciaFim + "]";
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
		CargoHistoricoNomeTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}