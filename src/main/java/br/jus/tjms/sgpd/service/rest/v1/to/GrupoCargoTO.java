package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.NaturezaGrupoCargo;

public class GrupoCargoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long quadroId;
	private NaturezaGrupoCargo natureza;
	private String nome;

	public GrupoCargoTO() {
		super();
	}

	public GrupoCargoTO(Long id, Long quadroId, NaturezaGrupoCargo natureza, String nome) {
		super();
		this.id = id;
		this.quadroId = quadroId;
		this.natureza = natureza;
		this.nome = nome;
	}

	public GrupoCargoTO(Long quadroId, NaturezaGrupoCargo natureza, String nome) {
		super();
		this.quadroId = quadroId;
		this.natureza = natureza;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuadroId() {
		return quadroId;
	}

	public void setQuadroId(Long quadroId) {
		this.quadroId = quadroId;
	}

	public NaturezaGrupoCargo getNatureza() {
		return natureza;
	}

	public void setNatureza(NaturezaGrupoCargo natureza) {
		this.natureza = natureza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "GrupoCargoTO [id=" + id + ", quadroId=" + quadroId + ", natureza=" + natureza + ", nome=" + nome + "]";
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
		GrupoCargoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}