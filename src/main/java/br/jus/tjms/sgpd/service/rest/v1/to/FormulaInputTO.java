package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoInputOutput;

public class FormulaInputTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long formulaId;
	private Integer sequencia;
	private String nome;
	private Boolean somenteLeitura;
	private TipoInputOutput tipoInput;
	private String classe;
	private transient Object valor;


	public FormulaInputTO() {
		super();
	}

	public FormulaInputTO(Long id, Long formulaId, Integer sequencia, String nome, Boolean somenteLeitura,
			TipoInputOutput tipoInput, String classe, Object valor) {
		super();
		this.id = id;
		this.formulaId = formulaId;
		this.sequencia = sequencia;
		this.nome = nome;
		this.somenteLeitura = somenteLeitura;
		this.tipoInput = tipoInput;
		this.classe = classe;
		this.valor = valor;
	}

	public FormulaInputTO(Long formulaId, Integer sequencia, String nome, Boolean somenteLeitura,
			TipoInputOutput tipoInput, String classe, Object valor) {
		super();
		this.formulaId = formulaId;
		this.sequencia = sequencia;
		this.nome = nome;
		this.somenteLeitura = somenteLeitura;
		this.tipoInput = tipoInput;
		this.classe = classe;
		this.valor = valor;
	}
	
	public FormulaInputTO(Integer sequencia, String nome, Boolean somenteLeitura,
			TipoInputOutput tipoInput, String classe, Object valor) {
		super();
		this.sequencia = sequencia;
		this.nome = nome;
		this.somenteLeitura = somenteLeitura;
		this.tipoInput = tipoInput;
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
		return "FormulaInputTO [id=" + id + ", formulaId=" + formulaId + ", sequencia=" + sequencia + ", nome=" + nome
				+ ", somenteLeitura=" + somenteLeitura + ", tipoInput=" + tipoInput + ", classe=" + classe + ", valor="
				+ valor + "]";
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
		FormulaInputTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}