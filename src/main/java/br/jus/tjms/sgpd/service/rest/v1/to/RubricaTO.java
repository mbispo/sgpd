package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;

public class RubricaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer sequenciaCalculo;
	private String sigla;
	private String descricao;
	private Sinal sinal;
	private Boolean ativa;
	private Boolean visivel;
	private Double valor;
	private Double percentual;
	private Double quantidade;
	private TipoRubrica tipo;
	private Long grupoRubricaId;
	private List<RubricaParametroTO> parametros = new ArrayList<RubricaParametroTO>();
	private List<RubricaFormulaTO> formulas = new ArrayList<RubricaFormulaTO>();
	private List<RubricaBaseTO> rubricasBase = new ArrayList<RubricaBaseTO>();
	private List<RubricaUtilizaBaseCalculoTO> utilizaTiposBaseCalculo = new ArrayList<RubricaUtilizaBaseCalculoTO>();
	private List<RubricaCompoeBaseCalculoTO> compoeTiposBaseCalculo = new ArrayList<RubricaCompoeBaseCalculoTO>();
	private List<RubricaTipoClassificacaoContabilTO> classificacaoContabil = new ArrayList<RubricaTipoClassificacaoContabilTO>();

	public RubricaTO() {
		super();
	}

	public RubricaTO(Long id, Integer sequenciaCalculo, String sigla, String descricao, Sinal sinal, Boolean ativa,
			Boolean visivel, Double valor, Double percentual, Double quantidade, TipoRubrica tipo, Long grupoRubricaId) {
		super();
		this.id = id;
		this.sequenciaCalculo = sequenciaCalculo;
		this.sigla = sigla;
		this.descricao = descricao;
		this.sinal = sinal;
		this.ativa = ativa;
		this.visivel = visivel;
		this.valor = valor;
		this.percentual = percentual;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.grupoRubricaId = grupoRubricaId;
	}

	public RubricaTO(Long id, Integer sequenciaCalculo, String sigla, String descricao, Sinal sinal, Boolean ativa,
			Boolean visivel, Double valor, Double percentual, Double quantidade, TipoRubrica tipo, Long grupoRubricaId,
			List<RubricaParametroTO> parametros, List<RubricaFormulaTO> formulas, List<RubricaBaseTO> rubricasBase,
			List<RubricaUtilizaBaseCalculoTO> utilizaTiposBaseCalculo, List<RubricaCompoeBaseCalculoTO> compoeTiposBaseCalculo,
			List<RubricaTipoClassificacaoContabilTO> classificacaoContabil) {
		super();
		this.id = id;
		this.sequenciaCalculo = sequenciaCalculo;
		this.sigla = sigla;
		this.descricao = descricao;
		this.sinal = sinal;
		this.ativa = ativa;
		this.visivel = visivel;
		this.valor = valor;
		this.percentual = percentual;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.grupoRubricaId = grupoRubricaId;
		this.parametros = parametros;
		this.formulas = formulas;
		this.rubricasBase = rubricasBase;
		this.utilizaTiposBaseCalculo = utilizaTiposBaseCalculo;
		this.compoeTiposBaseCalculo = compoeTiposBaseCalculo;
		this.classificacaoContabil = classificacaoContabil;
	}

	public RubricaTO(Integer sequenciaCalculo, String sigla, String descricao, Sinal sinal, Boolean ativa,
			Boolean visivel, Double valor, Double percentual, Double quantidade, TipoRubrica tipo, Long grupoRubricaId,
			List<RubricaParametroTO> parametros, List<RubricaFormulaTO> formulas, List<RubricaBaseTO> rubricasBaseTO,
			List<RubricaUtilizaBaseCalculoTO> utilizaTiposBaseCalculo,
			List<RubricaCompoeBaseCalculoTO> compoeTiposBaseCalculo,
			List<RubricaTipoClassificacaoContabilTO> classificacaoContabil) {
		super();
		this.sequenciaCalculo = sequenciaCalculo;
		this.sigla = sigla;
		this.descricao = descricao;
		this.sinal = sinal;
		this.ativa = ativa;
		this.visivel = visivel;
		this.valor = valor;
		this.percentual = percentual;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.grupoRubricaId = grupoRubricaId;
		
		this.parametros = parametros;
		this.formulas = formulas;
		this.rubricasBase = rubricasBaseTO;
		this.utilizaTiposBaseCalculo = utilizaTiposBaseCalculo;
		this.compoeTiposBaseCalculo = compoeTiposBaseCalculo;
		this.classificacaoContabil = classificacaoContabil;
	}

	public RubricaTO(Integer sequenciaCalculo, String sigla, String descricao, Sinal sinal, Boolean ativa,
			Boolean visivel, Double valor, Double percentual, Double quantidade, TipoRubrica tipo, Long grupoRubricaId) {
		super();
		this.sequenciaCalculo = sequenciaCalculo;
		this.sigla = sigla;
		this.descricao = descricao;
		this.sinal = sinal;
		this.ativa = ativa;
		this.visivel = visivel;
		this.valor = valor;
		this.percentual = percentual;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.grupoRubricaId = grupoRubricaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSequenciaCalculo() {
		return sequenciaCalculo;
	}

	public void setSequenciaCalculo(Integer sequenciaCalculo) {
		this.sequenciaCalculo = sequenciaCalculo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Sinal getSinal() {
		return sinal;
	}

	public void setSinal(Sinal sinal) {
		this.sinal = sinal;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}

	public Boolean getVisivel() {
		return visivel;
	}

	public void setVisivel(Boolean visivel) {
		this.visivel = visivel;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public TipoRubrica getTipo() {
		return tipo;
	}

	public void setTipo(TipoRubrica tipo) {
		this.tipo = tipo;
	}

	public Long getGrupoRubricaId() {
		return grupoRubricaId;
	}

	public void setGrupoRubricaId(Long grupoRubricaId) {
		this.grupoRubricaId = grupoRubricaId;
	}

	public List<RubricaParametroTO> getParametros() {
		return parametros;
	}

	public void setParametros(List<RubricaParametroTO> parametros) {
		this.parametros = parametros;
	}

	public List<RubricaFormulaTO> getFormulas() {
		return formulas;
	}

	public void setFormulas(List<RubricaFormulaTO> formulas) {
		this.formulas = formulas;
	}

	public List<RubricaBaseTO> getRubricasBase() {
		return rubricasBase;
	}

	public void setRubricasBase(List<RubricaBaseTO> rubricasBase) {
		this.rubricasBase = rubricasBase;
	}

	public List<RubricaUtilizaBaseCalculoTO> getUtilizaTiposBaseCalculo() {
		return utilizaTiposBaseCalculo;
	}

	public void setUtilizaTiposBaseCalculo(List<RubricaUtilizaBaseCalculoTO> utilizaTiposBaseCalculo) {
		this.utilizaTiposBaseCalculo = utilizaTiposBaseCalculo;
	}

	public List<RubricaCompoeBaseCalculoTO> getCompoeTiposBaseCalculo() {
		return compoeTiposBaseCalculo;
	}

	public void setCompoeTiposBaseCalculo(List<RubricaCompoeBaseCalculoTO> compoeTiposBaseCalculo) {
		this.compoeTiposBaseCalculo = compoeTiposBaseCalculo;
	}
	
	public List<RubricaTipoClassificacaoContabilTO> getClassificacaoContabil() {
		return classificacaoContabil;
	}

	public void setClassificacaoContabil(List<RubricaTipoClassificacaoContabilTO> classificacaoContabil) {
		this.classificacaoContabil = classificacaoContabil;
	}

	@Override
	public String toString() {
		return "RubricaTO [id=" + id + ", sequenciaCalculo=" + sequenciaCalculo + ", sigla=" + sigla + ", descricao="
				+ descricao + ", sinal=" + sinal + ", ativa=" + ativa + ", visivel=" + visivel + ", valor=" + valor
				+ ", percentual=" + percentual + ", quantidade=" + quantidade + ", tipo=" + tipo + ", grupoRubricaId="
				+ grupoRubricaId + "]";
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
		RubricaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}