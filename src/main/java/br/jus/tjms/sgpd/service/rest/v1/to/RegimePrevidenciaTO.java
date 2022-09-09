package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoRegimePrevidenciario;

public class RegimePrevidenciaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private Long regimeJuridicoId;
	private Long entidadePrevidenciariaId;
	private TipoRegimePrevidenciario tipoRegimePrevidenciario;

	public RegimePrevidenciaTO() {
		super();
	}

	public RegimePrevidenciaTO(Long id, String descricao, Long regimeJuridicoId, Long entidadePrevidenciariaId,
			TipoRegimePrevidenciario tipoRegimePrevidenciario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.regimeJuridicoId = regimeJuridicoId;
		this.entidadePrevidenciariaId = entidadePrevidenciariaId;
		this.tipoRegimePrevidenciario = tipoRegimePrevidenciario;
	}

	public RegimePrevidenciaTO(String descricao, Long regimeJuridicoId, Long entidadePrevidenciariaId,
			TipoRegimePrevidenciario tipoRegimePrevidenciario) {
		super();
		this.descricao = descricao;
		this.regimeJuridicoId = regimeJuridicoId;
		this.entidadePrevidenciariaId = entidadePrevidenciariaId;
		this.tipoRegimePrevidenciario = tipoRegimePrevidenciario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getRegimeJuridicoId() {
		return regimeJuridicoId;
	}

	public void setRegimeJuridicoId(Long regimeJuridicoId) {
		this.regimeJuridicoId = regimeJuridicoId;
	}

	public Long getEntidadePrevidenciariaId() {
		return entidadePrevidenciariaId;
	}

	public void setEntidadePrevidenciariaId(Long entidadePrevidenciariaId) {
		this.entidadePrevidenciariaId = entidadePrevidenciariaId;
	}

	public TipoRegimePrevidenciario getTipoRegimePrevidenciario() {
		return tipoRegimePrevidenciario;
	}

	public void setTipoRegimePrevidenciario(TipoRegimePrevidenciario tipoRegimePrevidenciario) {
		this.tipoRegimePrevidenciario = tipoRegimePrevidenciario;
	}

	@Override
	public String toString() {
		return "RegimePrevidenciaTO [id=" + id + ", descricao=" + descricao + ", regimeJuridicoId=" + regimeJuridicoId
				+ ", entidadePrevidenciariaId=" + entidadePrevidenciariaId + ", tipoRegimePrevidenciario="
				+ tipoRegimePrevidenciario + "]";
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
		RegimePrevidenciaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}