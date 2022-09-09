package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.GrupoFormulaTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
public class GrupoFormula implements Serializable {

	private static final long serialVersionUID = 670342423739943842L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	public GrupoFormula() {
		super();
	}

	public GrupoFormula(Long id) {
		super();
		this.id = id;
	}

	public GrupoFormula(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public GrupoFormula(GrupoFormulaTO grupoFormulaTO) {
		this.descricao = grupoFormulaTO.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
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
		GrupoFormula other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "GrupoFormula [id=" + id + ", descricao=" + descricao + "]";
	}

	public void alterar(GrupoFormulaTO grupoFormulaTO) {
		this.descricao = grupoFormulaTO.getDescricao();
	}

}