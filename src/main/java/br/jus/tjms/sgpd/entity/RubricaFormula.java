package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaFormulaTO;
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
	@NamedQuery(name = "rubricaFormula.buscarRubricaFormulaPorRubricaEFormula", 
			query = "SELECT r FROM RubricaFormula r WHERE r.rubrica.id = :rubricaId and r.formula.id = :formulaId"),
	@NamedQuery(name = "rubricaFormula.buscarFormulasPorRubrica", 
			query = "SELECT r.formula FROM RubricaFormula r WHERE r.rubrica.id = :rubricaId"),
})
public class RubricaFormula implements Serializable {

	private static final long serialVersionUID = -9030812753453076179L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="rubrica_id", nullable = false)
	private Rubrica rubrica;
	
	@ManyToOne
	@JoinColumn(name="formula_id", nullable = false)
	private Formula formula;

	public RubricaFormula() {
		super();
	}

	public RubricaFormula(Long id, Rubrica rubrica, Formula formula) {
		super();
		this.id = id;
		this.rubrica = rubrica;
		this.formula = formula;
	}
	
	public RubricaFormula(Rubrica rubrica, Formula formula) {
		super();
		this.rubrica = rubrica;
		this.formula = formula;
	}

	public RubricaFormula(RubricaFormulaTO rubricaFormulaTO, Rubrica rubrica) {
		this.rubrica = rubrica;
		this.formula = new Formula(rubricaFormulaTO.getFormulaId());
	}
	
	public RubricaFormula(RubricaFormulaTO rubricaFormulaTO) {
		this.rubrica = new Rubrica(rubricaFormulaTO.getRubricaId());
		this.formula = new Formula(rubricaFormulaTO.getFormulaId());
	}	
	
	public RubricaFormulaTO toTO() {
		return new RubricaFormulaTO(id, rubrica.getId(), formula.getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
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
		RubricaFormula other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	@Override
	public String toString() {
		return "RubricaFormula [id=" + id + ", rubrica=" + rubrica + ", formula=" + formula + "]";
	}

	public void alterar(RubricaFormulaTO rubricaFormulaTO) {
		this.formula = new Formula(rubricaFormulaTO.getFormulaId());
	}

}