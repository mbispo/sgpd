package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.calculo.OutputParam;
import br.jus.tjms.sgpd.enumerators.TipoInputOutput;
import br.jus.tjms.sgpd.service.rest.v1.to.FormulaOutputTO;
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
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = { "formula_id", "nome" }),
		@UniqueConstraint(columnNames = { "formula_id", "sequencia" })
	}
)
@NamedQueries({
	@NamedQuery(name = "formulaOutput.buscarPorFormula", query = "SELECT f FROM FormulaOutput f WHERE f.formula.id = :formulaId"),
})
public class FormulaOutput implements Serializable, OutputParam {

	private static final long serialVersionUID = -6260832551974774110L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "formula_id", nullable = false)
	private Formula formula;

	private Integer sequencia;

	// resultado padrão na execução das fórmulas, quando não for feita uma referência ao mapa de valores de output
	private Boolean resultadoDefault;

	@Column(length = 200)
	private String nome;

	@Enumerated(EnumType.ORDINAL)
	private TipoInputOutput tipoOutput;

	@Column(length = 255)
	private String classe;
	
	@Transient
	private transient Object valor;

	public FormulaOutput() {
		super();
	}

	public FormulaOutput(Formula formula, Integer sequencia, Boolean resultadoDefault, String nome,
			TipoInputOutput tipoOutput, String classe) {
		super();
		this.formula = formula;
		this.sequencia = sequencia;
		this.resultadoDefault = resultadoDefault;
		this.nome = nome;
		this.tipoOutput = tipoOutput;
		this.classe = classe;
	}

	public FormulaOutput(Formula formula, Integer sequencia, Boolean resultadoDefault, String nome,
			TipoInputOutput tipoOutput, String classe, Object valor) {
		super();
		this.formula = formula;
		this.sequencia = sequencia;
		this.resultadoDefault = resultadoDefault;
		this.nome = nome;
		this.tipoOutput = tipoOutput;
		this.classe = classe;
		this.valor = valor;
	}

	public FormulaOutput(FormulaOutputTO formulaOutputTO, Formula formula) {
		this.id = formulaOutputTO.getId();
		this.formula = formula;
		this.sequencia = formulaOutputTO.getSequencia();
		this.resultadoDefault = formulaOutputTO.getResultadoDefault();
		this.nome = formulaOutputTO.getNome();
		this.tipoOutput = formulaOutputTO.getTipoOutput();
		this.classe = formulaOutputTO.getClasse();
		this.valor = formulaOutputTO.getValor();
	}
	
	public FormulaOutput(FormulaOutputTO formulaOutputTO) {
		this.id = formulaOutputTO.getId();
		this.formula = new Formula(formulaOutputTO.getFormulaId());
		this.sequencia = formulaOutputTO.getSequencia();
		this.resultadoDefault = formulaOutputTO.getResultadoDefault();
		this.nome = formulaOutputTO.getNome();
		this.tipoOutput = formulaOutputTO.getTipoOutput();
		this.classe = formulaOutputTO.getClasse();
		this.valor = formulaOutputTO.getValor();
	}	

	public Long getId() {
		return id;
	}

	public Formula getFormula() {
		return formula;
	}

	public void setFormula(Formula formula) {
		this.formula = formula;
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

	@Override
	public Boolean getResultadoDefault() {
		return resultadoDefault;
	}

	public void setResultadoDefault(Boolean resultadoDefault) {
		this.resultadoDefault = resultadoDefault;
	}

	@Override
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoInputOutput getTipoOutput() {
		return tipoOutput;
	}

	public void setTipoOutput(TipoInputOutput tipoOutput) {
		this.tipoOutput = tipoOutput;
	}
	
	@Override
	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	@Override
	@Transient
	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
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
		FormulaOutput other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FormulaOutput [id=" + id + ", formula=" + formula + ", sequencia=" + sequencia + ", resultadoDefault="
				+ resultadoDefault + ", nome=" + nome + ", tipoOutput=" + tipoOutput + ", classe=" + classe + ", valor="
				+ valor + "]";
	}
	
	public void alterar(FormulaOutputTO formulaOutputTO) {
		this.formula = new Formula(formulaOutputTO.getFormulaId());
		this.sequencia = formulaOutputTO.getSequencia();
		this.resultadoDefault = formulaOutputTO.getResultadoDefault();
		this.nome = formulaOutputTO.getNome();
		this.tipoOutput = formulaOutputTO.getTipoOutput();
		this.classe = formulaOutputTO.getClasse();
		this.valor = formulaOutputTO.getValor();
	}

	public FormulaOutputTO toTO() {
		return new FormulaOutputTO(id, formula.getId(), sequencia, resultadoDefault, nome,
				tipoOutput, classe, valor);
	}
	
}