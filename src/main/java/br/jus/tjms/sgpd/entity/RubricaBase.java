package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaBaseTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "rubricaBase.buscarRubricaBasePorRubrica", 
			query = "SELECT r FROM RubricaBase r WHERE r.rubrica.id = :rubricaId"),
})
public class RubricaBase implements Serializable {

	private static final long serialVersionUID = -399352245331606315L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = false)
	private Rubrica rubrica;

	@ManyToOne
	@JoinColumn(name = "rubricaBase_id", nullable = false)
	private Rubrica rubricaBase;

	public RubricaBase() {
		super();
	}

	public RubricaBase(Long id, Rubrica rubrica, Rubrica rubricaBase) {
		super();
		this.id = id;
		this.rubrica = rubrica;
		this.rubricaBase = rubricaBase;
	}

	public RubricaBase(Rubrica rubrica, Rubrica rubricaBase) {
		super();
		this.rubrica = rubrica;
		this.rubricaBase = rubricaBase;
	}

	public RubricaBase(RubricaBaseTO rubricaBaseTO, Rubrica rubrica) {
		this.rubrica = rubrica;
		this.rubricaBase = new Rubrica(rubricaBaseTO.getRubricaBaseId());
	}
	
	public RubricaBase(RubricaBaseTO rubricaBaseTO) {
		this.rubrica = new Rubrica(rubricaBaseTO.getRubricaId());
		this.rubricaBase = new Rubrica(rubricaBaseTO.getRubricaBaseId());
	}	
	
	public RubricaBaseTO toTO() {
		return new RubricaBaseTO(id, rubrica.getId(), rubricaBase.getId());
	}

	public Long getId() {
		return id;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public Rubrica getRubricaBase() {
		return rubricaBase;
	}

	public void setRubricaBase(Rubrica rubricaBase) {
		this.rubricaBase = rubricaBase;
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
		RubricaBase other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RubricaBase [id=" + id + ", rubrica=" + rubrica + ", rubricaBase=" + rubricaBase + "]";
	}

	public void alterar(RubricaBaseTO rubricaBaseTO) {
		this.rubricaBase = new Rubrica(rubricaBaseTO.getRubricaBaseId());
	}

}