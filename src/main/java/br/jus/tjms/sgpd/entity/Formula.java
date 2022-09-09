package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.service.rest.v1.to.FormulaInputTO;
import br.jus.tjms.sgpd.service.rest.v1.to.FormulaOutputTO;
import br.jus.tjms.sgpd.service.rest.v1.to.FormulaTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "formula.buscarPorGrupo", query = "SELECT f FROM Formula f WHERE f.grupo.id = :grupoId"),
	@NamedQuery(name = "formula.buscarPorNome", query = "SELECT f FROM Formula f WHERE f.nome = :nome")
})
public class Formula implements Serializable {

	private static final long serialVersionUID = 8237013346872514006L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	@Column(length = 500)
	private String expressao;

	//@Lob
	//@Basic(fetch = FetchType.LAZY)
	@Column(columnDefinition="text")
	private String script;
	//private byte[] script;
	
	@ManyToOne
	@JoinColumn(name = "formulaBase_id", nullable = true)
	private Formula formulaBase;

	@ManyToOne
	@JoinColumn(name = "grupo_id", nullable = true)
	private GrupoFormula grupo;

	@Enumerated(EnumType.ORDINAL)
	private TipoFormula tipo;
	
	private Boolean global; // indica que a fórmula está disponível para ser referenciada por qualquer script/expressão

	@OneToMany(mappedBy = "formula", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<FormulaInput> inputs = new ArrayList<FormulaInput>();

	@OneToMany(mappedBy = "formula", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<FormulaOutput> outputs = new ArrayList<FormulaOutput>();

	public Formula() {
		super();
	}

	public Formula(String nome, String expressao, String script, Formula formulaBase, GrupoFormula grupo,
			TipoFormula tipo, Boolean global, List<FormulaInput> inputs, List<FormulaOutput> outputs) {
		super();
		this.nome = nome;
		this.expressao = expressao;
		this.script = script;
		this.formulaBase = formulaBase;
		this.grupo = grupo;
		this.tipo = tipo;
		this.global = global;
		this.inputs = inputs;
		this.outputs = outputs;
	}

	public Formula(FormulaTO formulaTO) {
		this.id = formulaTO.getId();
		this.nome = formulaTO.getNome();
		this.expressao = formulaTO.getExpressao();
		this.script = formulaTO.getScript();
		
		if (formulaTO.getFormulaBaseId()!=null)
			this.formulaBase = new Formula(formulaTO.getFormulaBaseId());
		
		if (formulaTO.getGrupoFormulaId()!=null)
			this.grupo = new GrupoFormula(formulaTO.getGrupoFormulaId());
		
		this.tipo = formulaTO.getTipo();
		this.global = formulaTO.getGlobal();
		
		if (formulaTO.getInputs()!=null) {
			for (FormulaInputTO to : formulaTO.getInputs()) {
				this.inputs.add(new FormulaInput(to,this));				
			}
		}
		
		if (formulaTO.getOutputs()!=null) {
			for (FormulaOutputTO to : formulaTO.getOutputs()) {
				this.outputs.add(new FormulaOutput(to,this));				
			}
		}
		
	}

	public FormulaTO toTO() {
		return new FormulaTO(id, nome, expressao, script, formulaBase!=null?formulaBase.getId():null, grupo!=null?grupo.getId():null,
				tipo, global, inputsToTO(), outputsToTO());
	}

	private List<FormulaOutputTO> outputsToTO() {
		List<FormulaOutputTO> lista = new ArrayList<>();
		
		for (FormulaOutput formulaOutput : outputs) {
			lista.add(formulaOutput.toTO());
			
		}
		return lista;
	}

	private List<FormulaInputTO> inputsToTO() {
		List<FormulaInputTO> lista = new ArrayList<>();
		
		for (FormulaInput formulaInput : inputs) {
			lista.add(formulaInput.toTO());
			
		}
		return lista;	}

	public Formula(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getExpressao() {
		return expressao;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public Formula getFormulaBase() {
		return formulaBase;
	}

	public void setFormulaBase(Formula formulaBase) {
		this.formulaBase = formulaBase;
	}

	public GrupoFormula getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoFormula grupo) {
		this.grupo = grupo;
	}

	public TipoFormula getTipo() {
		return tipo;
	}

	public void setTipo(TipoFormula tipo) {
		this.tipo = tipo;
	}

	public Boolean getGlobal() {
		return global;
	}

	public void setGlobal(Boolean global) {
		this.global = global;
	}


	public List<FormulaInput> getInputs() {
		return inputs;
	}

	public void setInputs(List<FormulaInput> inputs) {
		this.inputs = inputs;
	}

	public List<FormulaOutput> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<FormulaOutput> outputs) {
		this.outputs = outputs;
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
		Formula other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}


	@Override
	public String toString() {
		return "Formula [id=" + id + ", nome=" + nome + ", expressao=" + expressao + ", script=" + script
				+ ", formulaBase=" + formulaBase + ", grupo=" + grupo + ", tipo=" + tipo + ", global=" + global
				+ ", inputs=" + inputs + ", outputs=" + outputs + "]";
	}

	public void alterar(FormulaTO formulaTO) {

		this.nome = formulaTO.getNome();
		this.expressao = formulaTO.getExpressao();
		this.script = formulaTO.getScript();
		
		if (formulaTO.getFormulaBaseId()!=null)
			this.formulaBase = new Formula(formulaTO.getFormulaBaseId());
		
		if (formulaTO.getGrupoFormulaId()!=null)
			this.grupo = new GrupoFormula(formulaTO.getGrupoFormulaId());
		
		this.tipo = formulaTO.getTipo();
		this.global = formulaTO.getGlobal();
		
		if (formulaTO.getInputs()!=null) {
			for (FormulaInputTO to : formulaTO.getInputs()) {
				this.inputs.add(new FormulaInput(to,this));				
			}
		}
		
		if (formulaTO.getOutputs()!=null) {
			for (FormulaOutputTO to : formulaTO.getOutputs()) {
				this.outputs.add(new FormulaOutput(to,this));				
			}
		}
		
	}
}