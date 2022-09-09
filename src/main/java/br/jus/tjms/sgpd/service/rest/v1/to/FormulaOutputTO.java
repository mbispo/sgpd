package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoInputOutput;

public class FormulaOutputTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long formulaId;
	private Integer sequencia;
	private Boolean resultadoDefault;
	private String nome;
	private TipoInputOutput tipoOutput;
	private String classe;
	private transient Object valor;

	public FormulaOutputTO() {
		super();
	}

	public FormulaOutputTO(Long id, Long formulaId, Integer sequencia, Boolean resultadoDefault, String nome,
			TipoInputOutput tipoOutput, String classe, Object valor) {
		super();
		this.id = id;
		this.formulaId = formulaId;
		this.sequencia = sequencia;
		this.resultadoDefault = resultadoDefault;
		this.nome = nome;
		this.tipoOutput = tipoOutput;
		this.classe = classe;
		this.valor = valor;
	}

	public FormulaOutputTO(Long formulaId, Integer sequencia, Boolean resultadoDefault, String nome,
			TipoInputOutput tipoOutput, String classe, Object valor) {
		super();
		this.formulaId = formulaId;
		this.sequencia = sequencia;
		this.resultadoDefault = resultadoDefault;
		this.nome = nome;
		this.tipoOutput = tipoOutput;
		this.classe = classe;
		this.valor = valor;
	}
	
	public FormulaOutputTO(Integer sequencia, Boolean resultadoDefault, String nome,
			TipoInputOutput tipoOutput, String classe, Object valor) {
		super();
		this.sequencia = sequencia;
		this.resultadoDefault = resultadoDefault;
		this.nome = nome;
		this.tipoOutput = tipoOutput;
		this.classe = classe;
		this.valor = valor;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFormulaId() {
		return formulaId;
	}

	public void setFormulaId(Long formulaId) {
		this.formulaId = formulaId;
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

	public Boolean getResultadoDefault() {
		return resultadoDefault;
	}

	public void setResultadoDefault(Boolean resultadoDefault) {
		this.resultadoDefault = resultadoDefault;
	}

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

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "FormulaOutputTO [id=" + id + ", formulaId=" + formulaId + ", sequencia=" + sequencia
				+ ", resultadoDefault=" + resultadoDefault + ", nome=" + nome + ", tipoOutput=" + tipoOutput
				+ ", classe=" + classe + ", valor=" + valor + "]";
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
		FormulaOutputTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}