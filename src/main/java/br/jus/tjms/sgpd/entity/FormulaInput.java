package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.calculo.InputParam;
import br.jus.tjms.sgpd.enumerators.TipoInputOutput;
import br.jus.tjms.sgpd.service.rest.v1.to.FormulaInputTO;
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
@Table(uniqueConstraints={
			@UniqueConstraint(columnNames={"formula_id","nome"}),
			@UniqueConstraint(columnNames={"formula_id","sequencia"})
		})
@NamedQueries({
	@NamedQuery(name = "formulaInput.buscarPorFormula", query = "SELECT f FROM FormulaInput f WHERE f.formula.id = :formulaId"),
})
public class FormulaInput implements Serializable, InputParam {

	private static final long serialVersionUID = 3351349121822165454L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "formula_id", nullable = false)
	private Formula formula;

	private Integer sequencia;

	@Column(length = 200)
	private String nome;

	private Boolean somenteLeitura;

	@Enumerated(EnumType.ORDINAL)
	private TipoInputOutput tipoInput;

	@Column(length = 255)
	private String classe;
	
	@Transient
	private transient Object valor;

	public FormulaInput() {
		super();
	}

	public FormulaInput(Formula formula, Integer sequencia, String nome, Boolean somenteLeitura,
			TipoInputOutput tipoInput, String classe) {
		super();
		this.formula = formula;
		this.sequencia = sequencia;
		this.nome = nome;
		this.somenteLeitura = somenteLeitura;
		this.tipoInput = tipoInput;
		this.classe = classe;
	}

	public FormulaInput(Formula formula, Integer sequencia, String nome, Boolean somenteLeitura,
			TipoInputOutput tipoInput, String classe, Object valor) {
		super();
		this.formula = formula;
		this.sequencia = sequencia;
		this.nome = nome;
		this.somenteLeitura = somenteLeitura;
		this.tipoInput = tipoInput;
		this.classe = classe;
		this.valor = valor;
	}

	public FormulaInput(FormulaInputTO formulaInputTO, Formula formula) {
		this.id = formulaInputTO.getId();
		this.formula = formula;
		this.sequencia = formulaInputTO.getSequencia();
		this.nome = formulaInputTO.getNome();
		this.somenteLeitura = formulaInputTO.getSomenteLeitura();
		this.tipoInput = formulaInputTO.getTipoInput();
		this.classe = formulaInputTO.getClasse();
		this.valor = formulaInputTO.getValor();
	}
	
	public FormulaInput(FormulaInputTO formulaInputTO) {
		this.id = formulaInputTO.getId();
		this.formula = new Formula(formulaInputTO.getFormulaId());
		this.sequencia = formulaInputTO.getSequencia();
		this.nome = formulaInputTO.getNome();
		this.somenteLeitura = formulaInputTO.getSomenteLeitura();
		this.tipoInput = formulaInputTO.getTipoInput();
		this.classe = formulaInputTO.getClasse();
		this.valor = formulaInputTO.getValor();
	}	
	
	public FormulaInput(Long id) {
		super();
		this.id = id;
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

	/* (non-Javadoc)
	 * @see br.jus.tjms.sgpd.entity.InputParam#getNome()
	 */
	@Override
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getSomenteLeitura() {
		return somenteLeitura;
	}

	public void setSomenteLeitura(Boolean somenteLeitura) {
		this.somenteLeitura = somenteLeitura;
	}

	public TipoInputOutput getTipoInput() {
		return tipoInput;
	}

	public void setTipoInput(TipoInputOutput tipoInput) {
		this.tipoInput = tipoInput;
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
		FormulaInput other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FormulaInput [id=" + id + ", formula=" + formula + ", sequencia=" + sequencia + ", nome=" + nome
				+ ", somenteLeitura=" + somenteLeitura + ", tipoInput=" + tipoInput + ", classe=" + classe + ", valor="
				+ valor + "]";
	}
	
	public void alterar(FormulaInputTO formulaInputTO) {
		this.formula = new Formula(formulaInputTO.getFormulaId());
		this.sequencia = formulaInputTO.getSequencia();
		this.nome = formulaInputTO.getNome();
		this.somenteLeitura = formulaInputTO.getSomenteLeitura();
		this.tipoInput = formulaInputTO.getTipoInput();
		this.classe = formulaInputTO.getClasse();
		this.valor = formulaInputTO.getValor();
	}

	public FormulaInputTO toTO() {
		return new FormulaInputTO(id, formula.getId(), sequencia, nome, somenteLeitura, tipoInput, classe, valor);
	}
}