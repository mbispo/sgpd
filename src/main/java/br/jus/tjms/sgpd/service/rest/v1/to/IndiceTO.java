package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.Periodo;

public class IndiceTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private String sigla;
	private Periodo periodo;
	private Boolean ativo;

	public IndiceTO() {
		super();
	}

	public IndiceTO(Long id, String descricao, String sigla, Periodo periodo, Boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.sigla = sigla;
		this.periodo = periodo;
		this.ativo = ativo;
	}
	
	public IndiceTO(String descricao, String sigla, Periodo periodo, Boolean ativo) {
		super();
		this.descricao = descricao;
		this.sigla = sigla;
		this.periodo = periodo;
		this.ativo = ativo;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "IndiceTO [id=" + id + ", descricao=" + descricao + ", sigla=" + sigla + ", periodo=" + periodo
				+ ", ativo=" + ativo + "]";
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
		IndiceTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}