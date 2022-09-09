package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.entity.Pessoa;

public class PessoaCompetenciaTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private CompetenciaTO competenciaTO;
	private Pessoa pessoa;

	public PessoaCompetenciaTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompetenciaTO getCompetenciaTO() {
		return competenciaTO;
	}

	public void setCompetenciaTO(CompetenciaTO competenciaTO) {
		this.competenciaTO = competenciaTO;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "CompetenciaTO [id=" + id + "]";
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
		PessoaCompetenciaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}