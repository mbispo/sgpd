package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.engine.annotations.FolowList;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;
import br.jus.tjms.sgpd.service.rest.v1.to.*;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "rubrica.buscarPorGrupo", query = "SELECT r FROM Rubrica r WHERE r.grupo.id = :grupoId"),
	@NamedQuery(name = "rubrica.buscarPorNome", query = "SELECT r FROM Rubrica r WHERE r.descricao = :nome"),
})
public class Rubrica implements Serializable {

	private static final long serialVersionUID = 5554555132965695567L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer sequenciaCalculo;

	@Column(length = 20)
	private String sigla;

	@Column(length = 255)
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	private Sinal sinal;

	private Boolean ativa;
	private Boolean visivel;
	private Double valor;
	private Double percentual;
	private Double quantidade;

	@Enumerated(EnumType.ORDINAL)
	private TipoRubrica tipo;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "grupo_id", nullable = false)
	private GrupoRubrica grupo;

	@FolowList
	@OneToMany(mappedBy = "rubrica", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RubricaParametro> parametros = new ArrayList<RubricaParametro>();
	
	
	@OneToMany(mappedBy = "rubrica", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RubricaFormula> formulas = new ArrayList<RubricaFormula>();
	
	@FolowList
	@OneToMany(mappedBy = "rubrica", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RubricaBase> rubricasBase = new ArrayList<RubricaBase>();
	
	@FolowList
	@OneToMany(mappedBy = "rubrica", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RubricaUtilizaBaseCalculo> utilizaTiposBaseCalculo = new ArrayList<RubricaUtilizaBaseCalculo>();
	
	@FolowList
	@OneToMany(mappedBy = "rubrica", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RubricaCompoeBaseCalculo> compoeTiposBaseCalculo = new ArrayList<RubricaCompoeBaseCalculo>();
	
	@FolowList
	@OneToMany(mappedBy = "rubrica", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RubricaTipoClassificacaoContabil> classificacaoContabil = new ArrayList<RubricaTipoClassificacaoContabil>();	

	public Rubrica() {
		super();
	}

	public Rubrica(Long id) {
		super();
		this.id = id;
	}

	public Rubrica(Long id, Integer sequenciaCalculo, String sigla, String descricao, Sinal sinal, Boolean ativa,
			Boolean visivel, Double valor, Double percentual, Double quantidade, TipoRubrica tipo, GrupoRubrica grupo,
			List<RubricaParametro> parametros, List<RubricaFormula> formulas, List<RubricaBase> rubricasBase, 
			List<RubricaUtilizaBaseCalculo> utilizaTiposBaseCalculo, List<RubricaCompoeBaseCalculo> compoeTiposBaseCalculo,
			List<RubricaTipoClassificacaoContabil> classificacaoContabil) {
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
		this.grupo = grupo;
		this.parametros = parametros;
		this.formulas = formulas;
		this.rubricasBase = rubricasBase;
		this.utilizaTiposBaseCalculo = utilizaTiposBaseCalculo;
		this.compoeTiposBaseCalculo = compoeTiposBaseCalculo;
		this.classificacaoContabil = classificacaoContabil;
	}

	public Rubrica(RubricaTO rubricaTO) {
		this.sequenciaCalculo = rubricaTO.getSequenciaCalculo();
		this.sigla = rubricaTO.getSigla();
		this.descricao = rubricaTO.getDescricao();
		this.sinal = rubricaTO.getSinal();
		this.ativa = rubricaTO.getAtiva();
		this.visivel = rubricaTO.getVisivel();
		this.valor = rubricaTO.getValor();
		this.percentual = rubricaTO.getPercentual();
		this.quantidade = rubricaTO.getQuantidade();
		this.tipo = rubricaTO.getTipo();
		
		if (rubricaTO.getGrupoRubricaId()!=null) {
			this.grupo = new GrupoRubrica(rubricaTO.getGrupoRubricaId());
		}
		
		if (rubricaTO.getParametros()!=null) {
			for (RubricaParametroTO to : rubricaTO.getParametros()) {
				this.parametros.add(new RubricaParametro(to,this));
			}
		}

		if (rubricaTO.getFormulas()!=null) {
			for (RubricaFormulaTO to: rubricaTO.getFormulas()) {
				this.formulas.add(new RubricaFormula(to,this));
			}
		}
		
		if (rubricaTO.getRubricasBase()!=null) {
			for (RubricaBaseTO to : rubricaTO.getRubricasBase()) {
				this.rubricasBase.add(new RubricaBase(to,this));
			}
		}
		
		if (rubricaTO.getUtilizaTiposBaseCalculo()!=null) {
			for (RubricaUtilizaBaseCalculoTO to : rubricaTO.getUtilizaTiposBaseCalculo()) {
				this.utilizaTiposBaseCalculo.add(new RubricaUtilizaBaseCalculo(to,this));
			}			
		}
		
		if (rubricaTO.getCompoeTiposBaseCalculo()!=null) {
			for (RubricaCompoeBaseCalculoTO to : rubricaTO.getCompoeTiposBaseCalculo()) {
				this.compoeTiposBaseCalculo.add(new RubricaCompoeBaseCalculo(to,this));
			}			
		}
		
		if (rubricaTO.getClassificacaoContabil()!=null) {
			for (RubricaTipoClassificacaoContabilTO to : rubricaTO.getClassificacaoContabil()) {
				this.classificacaoContabil.add(new RubricaTipoClassificacaoContabil(to,this));
			}
		}
		
	}
	
	public RubricaTO toTO() {
        return new RubricaTO(id, sequenciaCalculo, sigla, descricao, sinal, ativa,
				visivel, valor, percentual, quantidade, tipo,
                grupo != null ? grupo.getId() : null);
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

	public GrupoRubrica getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoRubrica grupo) {
		this.grupo = grupo;
	}

	public List<RubricaParametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<RubricaParametro> parametros) {
		this.parametros = parametros;
	}

	public List<RubricaFormula> getFormulas() {
		return formulas;
	}

	public void setFormulas(List<RubricaFormula> formulas) {
		this.formulas = formulas;
	}

	public List<RubricaBase> getRubricasBase() {
		return rubricasBase;
	}

	public void setRubricasBase(List<RubricaBase> rubricasBase) {
		this.rubricasBase = rubricasBase;
	}

	public List<RubricaUtilizaBaseCalculo> getUtilizaTiposBaseCalculo() {
		return utilizaTiposBaseCalculo;
	}

	public void setUtilizaTiposBaseCalculo(List<RubricaUtilizaBaseCalculo> utilizaTiposBaseCalculo) {
		this.utilizaTiposBaseCalculo = utilizaTiposBaseCalculo;
	}

	public List<RubricaCompoeBaseCalculo> getCompoeTiposBaseCalculo() {
		return compoeTiposBaseCalculo;
	}

	public void setCompoeTiposBaseCalculo(List<RubricaCompoeBaseCalculo> compoeTiposBaseCalculo) {
		this.compoeTiposBaseCalculo = compoeTiposBaseCalculo;
	}

	public List<RubricaTipoClassificacaoContabil> getClassificacaoContabil() {
		return classificacaoContabil;
	}

	public void setClassificacaoContabil(List<RubricaTipoClassificacaoContabil> classificacaoContabil) {
		this.classificacaoContabil = classificacaoContabil;
	}

	@Transient
	public List<RubricaParametro> getParametrosAtivos(final Date data) {

		/* usando guava */

		if (parametros != null) {
			Collection<RubricaParametro> c = Collections2.filter(parametros, new Predicate<RubricaParametro>() {
				@Override
				public boolean apply(RubricaParametro p) {
					return (p.getAtivo() && p.getVigenciaInicio().before(data) && p.getVigenciaFim().after(data));
				}
			});
			
			return new ArrayList<>(c);
		}

		// usando lambda
		/*
		if (parametros != null) {
			return parametros.stream()
					.filter(p -> p.getAtivo() && p.getVigenciaInicio().before(data) && p.getVigenciaFim().after(data))
					.collect(Collectors.toList());
		}
		*/

		return null;
	}
	
	public List<RubricaParametro> getParametrosAtivos(final Date data, final Area area) {

		List<RubricaParametro> retorno = null;
		
		/* usando guava */

		if (parametros != null) {
			Collection<RubricaParametro> c = Collections2.filter(parametros, new Predicate<RubricaParametro>() {
				@Override
				public boolean apply(RubricaParametro p) {
					return (p.getAtivo() && p.getLocalEspecifico() && p.getArea().equals(area) && p.getVigenciaInicio().before(data) && p.getVigenciaFim().after(data));
				}
			});
		
			if (c != null && !c.isEmpty()) {
				// possui parâmetros específicos para a area informada
				retorno = new ArrayList<>(c); 
			} else {
				// retorna parâmetros gerais ativos na data
				retorno = getParametrosAtivos(data);
			}

		}

		return retorno;
		
	}
	
	public List<RubricaParametro> getParametrosAtivos(final Date data, final Cargo cargo) {

		List<RubricaParametro> retorno = null;

		if (parametros != null) {
			Collection<RubricaParametro> c = Collections2.filter(parametros, new Predicate<RubricaParametro>() {
				@Override
				public boolean apply(RubricaParametro p) {
					return (p.getAtivo() && p.getCargoEspecifico() && p.getCargo().equals(cargo) && p.getVigenciaInicio().before(data) && p.getVigenciaFim().after(data));
				}
			});
		
			if (c != null && !c.isEmpty()) {
				// possui parâmetros específicos para o cargo informado
				retorno = new ArrayList<>(c); 
			} else {
				// retorna parâmetros gerais ativos na data
				retorno = getParametrosAtivos(data);
			}

		}

		return retorno;

	}	
	
	
	public List<RubricaParametro> getParametrosAtivos(final Date data, final Area area, final Cargo cargo) {

		List<RubricaParametro> retorno = null;

		if (parametros != null) {
			Collection<RubricaParametro> c = Collections2.filter(parametros, new Predicate<RubricaParametro>() {
				@Override
				public boolean apply(RubricaParametro p) {
					return (p.getAtivo() && p.getLocalEspecifico() && p.getCargoEspecifico() && p.getCargo().equals(cargo) && p.getArea().equals(area) && p.getVigenciaInicio().before(data) && p.getVigenciaFim().after(data));
				}
			});
			
			if (c != null && !c.isEmpty()) {
				// possui parâmetros específicos para area/cargo informado
				retorno = new ArrayList<>(c); 
			} else {
				// retorna parâmetros gerais ativos na data na area
				retorno = getParametrosAtivos(data, area);
			}

		}

		return retorno;
		
	}	
	
	@Transient
	public List<RubricaParametro> getParametrosAtivos(final Date data, final Double valorBase) {

		/* usando guava */

		if (parametros != null) {
			Collection<RubricaParametro> c = Collections2.filter(parametros, new Predicate<RubricaParametro>() {
				@Override
				public boolean apply(RubricaParametro p) {
					return (p.getAtivo() && p.getVigenciaInicio().before(data) && p.getVigenciaFim().after(data) && p.getValorBaseInicial().doubleValue()<=valorBase && p.getValorBaseFinal().doubleValue()>valorBase);
				}
			});
			
			return new ArrayList<>(c);
		}

		// usando lambda
		/*
		if (parametros != null) {
			return parametros.stream()
					.filter(p -> p.getAtivo() && p.getVigenciaInicio().before(data) && p.getVigenciaFim().after(data) && p.getValorBaseInicial().doubleValue()<=valorBase && p.getValorBaseFinal().doubleValue()>valorBase)
					.collect(Collectors.toList());
		}
		*/

		return null;
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
		Rubrica other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Rubrica [id=" + id + ", sequenciaCalculo=" + sequenciaCalculo + ", sigla=" + sigla + ", descricao="
				+ descricao + ", sinal=" + sinal + ", ativa=" + ativa + ", visivel=" + visivel + ", valor=" + valor
				+ ", percentual=" + percentual + ", quantidade=" + quantidade + ", tipo=" + tipo + ", grupo=" + grupo
				+ "]";
	}
	
	public void alterar(RubricaTO rubricaTO) {
		this.sequenciaCalculo = rubricaTO.getSequenciaCalculo();
		this.sigla = rubricaTO.getSigla();
		this.descricao = rubricaTO.getDescricao();
		this.sinal = rubricaTO.getSinal();
		this.ativa = rubricaTO.getAtiva();
		this.visivel = rubricaTO.getVisivel();
		this.valor = rubricaTO.getValor();
		this.percentual = rubricaTO.getPercentual();
		this.quantidade = rubricaTO.getQuantidade();
		this.tipo = rubricaTO.getTipo();
		
		if (rubricaTO.getGrupoRubricaId()!=null) {
			this.grupo = new GrupoRubrica(rubricaTO.getGrupoRubricaId());
		}
		
		if (rubricaTO.getParametros()!=null) {
			for (RubricaParametroTO to : rubricaTO.getParametros()) {
				this.parametros.add(new RubricaParametro(to,this));
			}
		}

		if (rubricaTO.getFormulas()!=null) {
			for (RubricaFormulaTO to: rubricaTO.getFormulas()) {
				this.formulas.add(new RubricaFormula(to,this));
			}
		}
		
		if (rubricaTO.getRubricasBase()!=null) {
			for (RubricaBaseTO to : rubricaTO.getRubricasBase()) {
				this.rubricasBase.add(new RubricaBase(to,this));
			}
		}
		
		if (rubricaTO.getUtilizaTiposBaseCalculo()!=null) {
			for (RubricaUtilizaBaseCalculoTO to : rubricaTO.getUtilizaTiposBaseCalculo()) {
				this.utilizaTiposBaseCalculo.add(new RubricaUtilizaBaseCalculo(to,this));
			}			
		}
		
		if (rubricaTO.getCompoeTiposBaseCalculo()!=null) {
			for (RubricaCompoeBaseCalculoTO to : rubricaTO.getCompoeTiposBaseCalculo()) {
				this.compoeTiposBaseCalculo.add(new RubricaCompoeBaseCalculo(to, this));
			}			
		}
		
		if (rubricaTO.getClassificacaoContabil()!=null) {
			for (RubricaTipoClassificacaoContabilTO to : rubricaTO.getClassificacaoContabil()) {
				this.classificacaoContabil.add(new RubricaTipoClassificacaoContabil(to,this));
			}
		}
		
	}

}