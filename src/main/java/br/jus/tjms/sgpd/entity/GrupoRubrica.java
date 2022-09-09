package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.GrupoRubricaTO;
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
public class GrupoRubrica implements Serializable {

	private static final long serialVersionUID = -8046041776615941966L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	public GrupoRubrica() {
		super();
	}

	public GrupoRubrica(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public GrupoRubrica(Long id) {
		super();
		this.id = id;
	}
	

	public GrupoRubrica(GrupoRubricaTO grupoRubricaTO) {
		this.id = grupoRubricaTO.getId();
		this.descricao = grupoRubricaTO.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		GrupoRubrica other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "GrupoRubrica [id=" + id + ", descricao=" + descricao + "]";
	}

	public void alterar(GrupoRubricaTO grupoRubricaTO) {
		this.descricao = grupoRubricaTO.getDescricao();
	}
}