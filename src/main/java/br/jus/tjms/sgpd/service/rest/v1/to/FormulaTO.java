package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoFormula;

public class FormulaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String expressao;
	private String script;
	private Long formulaBaseId;
	private Long grupoFormulaId;
	private TipoFormula tipo;
	private Boolean global;
	private List<FormulaInputTO> inputs = new ArrayList<FormulaInputTO>();
	private List<FormulaOutputTO> outputs = new ArrayList<FormulaOutputTO>();

	public FormulaTO() {
		super();
	}

	public FormulaTO(Long id, String nome, String expressao, String script, Long formulaBaseId, Long grupoFormulaId,
			TipoFormula tipo, Boolean global, List<FormulaInputTO> inputs, List<FormulaOutputTO> outputs) {
		super();
		this.id = id;
		this.nome = nome;
		this.expressao = expressao;
		this.script = script;
		this.formulaBaseId = formulaBaseId;
		this.grupoFormulaId = grupoFormulaId;
		this.tipo = tipo;
		this.global = global;
		this.inputs = inputs;
		this.outputs = outputs;
	}

	public FormulaTO(String nome, String expressao, String script, Long formulaBaseId, Long grupoFormulaId,
			TipoFormula tipo, Boolean global, List<FormulaInputTO> inputs, List<FormulaOutputTO> outputs) {
		super();
		this.nome = nome;
		this.expressao = expressao;
		this.script = script;
		this.formulaBaseId = formulaBaseId;
		this.grupoFormulaId = grupoFormulaId;
		this.tipo = tipo;
		this.global = global;
		this.inputs = inputs;
		this.outputs = outputs;
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

	public Long getFormulaBaseId() {
		return formulaBaseId;
	}

	public void setFormulaBaseId(Long formulaBaseId) {
		this.formulaBaseId = formulaBaseId;
	}

	public Long getGrupoFormulaId() {
		return grupoFormulaId;
	}

	public void setGrupoFormulaId(Long grupoFormulaId) {
		this.grupoFormulaId = grupoFormulaId;
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

	public List<FormulaInputTO> getInputs() {
		return inputs;
	}

	public void setInputs(List<FormulaInputTO> inputs) {
		this.inputs = inputs;
	}

	public List<FormulaOutputTO> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<FormulaOutputTO> outputs) {
		this.outputs = outputs;
	}

	@Override
	public String toString() {
		return "FormulaTO [id=" + id + ", nome=" + nome + ", expressao=" + expressao + ", script=" + script
				+ ", formulaBaseId=" + formulaBaseId + ", grupoFormulaId=" + grupoFormulaId + ", tipo=" + tipo
				+ ", global=" + global + ", inputs=" + inputs + ", outputs=" + outputs + "]";
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
		FormulaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}