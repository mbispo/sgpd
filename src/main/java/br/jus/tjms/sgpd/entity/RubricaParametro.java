package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaParametroTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "rubricaParametro.buscarPorRubrica", 
			query = "SELECT r FROM RubricaParametro r WHERE r.rubrica.id = :rubricaId"),
})
public class RubricaParametro implements Serializable {

	private static final long serialVersionUID = 6425117046563143773L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = false)
	private Rubrica rubrica;

	private Date vigenciaInicio;
	private Date vigenciaFim;

	// quando for necessário ter parâmetros diferentes por área/nível/região
	// etc, caso dos plantões
	private Boolean localEspecifico = false;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "classificacaoAreaNivel_id", nullable = true)
	private ClassificacaoAreaNivel classificacaoAreaNivel;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "area_id", nullable = true)
	private Area area;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "localidade_id", nullable = true)
	private Localidade localidade;

	// quando for necessário ter parâmetros diferentes por cargo
	private Boolean cargoEspecifico = false;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = true)
	private Cargo cargo;

	private Boolean ativo;

	private Double valorBaseInicial;
	private Double valorBaseFinal;
	private Double percentual;
	private Double percentualPatronal;
	private Double valorTeto;
	private Double valorDeducao;
	private Double valorFixo;
	private Double valorDeducaoPorDependente;
	private Double valorDeducaoPorIdade;
	private Double valorDeducaoPorDoenca;
	
	private Double valorDeducaoPorAposentadoria;	
	private Double percentualPatronalInativos;
	
	@Column(length = 500)
	private String observacoes;
	

	public RubricaParametro() {
		super();
	}
	
	public RubricaParametro(Rubrica rubrica, Date vigenciaInicio, Date vigenciaFim, 
			Boolean ativo, Double valorBaseInicial, Double valorBaseFinal, Double percentual,
			Double percentualPatronal, Double valorTeto, Double valorDeducao, Double valorFixo,
			Double valorDeducaoPorDependente, Double valorDeducaoPorIdade, Double valorDeducaoPorDoenca, 
			Double valorDeducaoPorAposentadoria, Double percentualPatronalInativos, String observacoes) {
		super();
		this.rubrica = rubrica;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.ativo = ativo;
		this.valorBaseInicial = valorBaseInicial;
		this.valorBaseFinal = valorBaseFinal;
		this.percentual = percentual;
		this.percentualPatronal = percentualPatronal;
		this.valorTeto = valorTeto;
		this.valorDeducao = valorDeducao;
		this.valorFixo = valorFixo;
		this.valorDeducaoPorDependente = valorDeducaoPorDependente;
		this.valorDeducaoPorIdade = valorDeducaoPorIdade;
		this.valorDeducaoPorDoenca = valorDeducaoPorDoenca;
		this.valorDeducaoPorAposentadoria = valorDeducaoPorAposentadoria;
		this.percentualPatronalInativos = percentualPatronalInativos;
		this.observacoes = observacoes;
	}

	public RubricaParametro(Rubrica rubrica, Date vigenciaInicio, Date vigenciaFim, Boolean localEspecifico,
			ClassificacaoAreaNivel classificacaoAreaNivel, Area area, Localidade localidade, Boolean cargoEspecifico,
			Cargo cargo, Boolean ativo, Double valorBaseInicial, Double valorBaseFinal, Double percentual,
			Double percentualPatronal, Double valorTeto, Double valorDeducao, Double valorFixo,
			Double valorDeducaoPorDependente, Double valorDeducaoPorIdade, Double valorDeducaoPorDoenca,
			Double valorDeducaoPorAposentadoria, Double percentualPatronalInativos, String observacoes) {
		super();
		this.rubrica = rubrica;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.localEspecifico = localEspecifico;
		this.classificacaoAreaNivel = classificacaoAreaNivel;
		this.area = area;
		this.localidade = localidade;
		this.cargoEspecifico = cargoEspecifico;
		this.cargo = cargo;
		this.ativo = ativo;
		this.valorBaseInicial = valorBaseInicial;
		this.valorBaseFinal = valorBaseFinal;
		this.percentual = percentual;
		this.percentualPatronal = percentualPatronal;
		this.valorTeto = valorTeto;
		this.valorDeducao = valorDeducao;
		this.valorFixo = valorFixo;
		this.valorDeducaoPorDependente = valorDeducaoPorDependente;
		this.valorDeducaoPorIdade = valorDeducaoPorIdade;
		this.valorDeducaoPorDoenca = valorDeducaoPorDoenca;
		this.valorDeducaoPorAposentadoria = valorDeducaoPorAposentadoria;
		this.percentualPatronalInativos = percentualPatronalInativos;
		this.observacoes = observacoes;
	}

	public RubricaParametro(RubricaParametroTO rubricaParametroTO, Rubrica rubrica) {
		this.rubrica = rubrica;
		this.vigenciaInicio = rubricaParametroTO.getVigenciaInicio();
		this.vigenciaFim = rubricaParametroTO.getVigenciaFim();
		this.localEspecifico = rubricaParametroTO.getLocalEspecifico();
		
		if (rubricaParametroTO.getClassificacaoAreaNivelId()!=null)
			this.classificacaoAreaNivel = new ClassificacaoAreaNivel(rubricaParametroTO.getClassificacaoAreaNivelId());
		
		if (rubricaParametroTO.getAreaId()!=null)
			this.area = new Area(rubricaParametroTO.getAreaId());
		
		if (rubricaParametroTO.getLocalidadeId()!=null)
			this.localidade = new Localidade(rubricaParametroTO.getLocalidadeId());
		
		this.cargoEspecifico = rubricaParametroTO.getCargoEspecifico();
		
		if (rubricaParametroTO.getCargoId()!=null)
			this.cargo = new Cargo(rubricaParametroTO.getCargoId());
		
		this.ativo = rubricaParametroTO.getAtivo();
		
		this.valorBaseInicial = rubricaParametroTO.getValorBaseInicial();
		this.valorBaseFinal = rubricaParametroTO.getValorBaseFinal();
		this.percentual = rubricaParametroTO.getPercentual();
		this.percentualPatronal = rubricaParametroTO.getPercentualPatronal();
		this.valorTeto = rubricaParametroTO.getValorTeto();
		this.valorDeducao = rubricaParametroTO.getValorDeducao();
		this.valorFixo = rubricaParametroTO.getValorFixo();
		this.valorDeducaoPorDependente = rubricaParametroTO.getValorDeducaoPorDependente();
		this.valorDeducaoPorIdade = rubricaParametroTO.getValorDeducaoPorIdade();
		this.valorDeducaoPorDoenca = rubricaParametroTO.getValorDeducao();
		
		this.valorDeducaoPorAposentadoria = rubricaParametroTO.getValorDeducaoPorAposentadoria();
		this.percentualPatronalInativos = rubricaParametroTO.getPercentualPatronalInativos();
		this.observacoes = rubricaParametroTO.getObservacoes();		
	}
	
	public RubricaParametro(RubricaParametroTO rubricaParametroTO) {
		this.rubrica = new Rubrica(rubricaParametroTO.getRubricaId());
		this.vigenciaInicio = rubricaParametroTO.getVigenciaInicio();
		this.vigenciaFim = rubricaParametroTO.getVigenciaFim();
		this.localEspecifico = rubricaParametroTO.getLocalEspecifico();
		
		if (rubricaParametroTO.getClassificacaoAreaNivelId()!=null)
			this.classificacaoAreaNivel = new ClassificacaoAreaNivel(rubricaParametroTO.getClassificacaoAreaNivelId());
		
		if (rubricaParametroTO.getAreaId()!=null)
			this.area = new Area(rubricaParametroTO.getAreaId());
		
		if (rubricaParametroTO.getLocalidadeId()!=null)
			this.localidade = new Localidade(rubricaParametroTO.getLocalidadeId());
		
		this.cargoEspecifico = rubricaParametroTO.getCargoEspecifico();
		
		if (rubricaParametroTO.getCargoId()!=null)
			this.cargo = new Cargo(rubricaParametroTO.getCargoId());
		
		this.ativo = rubricaParametroTO.getAtivo();
		
		this.valorBaseInicial = rubricaParametroTO.getValorBaseInicial();
		this.valorBaseFinal = rubricaParametroTO.getValorBaseFinal();
		this.percentual = rubricaParametroTO.getPercentual();
		this.percentualPatronal = rubricaParametroTO.getPercentualPatronal();
		this.valorTeto = rubricaParametroTO.getValorTeto();
		this.valorDeducao = rubricaParametroTO.getValorDeducao();
		this.valorFixo = rubricaParametroTO.getValorFixo();
		this.valorDeducaoPorDependente = rubricaParametroTO.getValorDeducaoPorDependente();
		this.valorDeducaoPorIdade = rubricaParametroTO.getValorDeducaoPorIdade();
		this.valorDeducaoPorDoenca = rubricaParametroTO.getValorDeducao();
		
		this.valorDeducaoPorAposentadoria = rubricaParametroTO.getValorDeducaoPorAposentadoria();
		this.percentualPatronalInativos = rubricaParametroTO.getPercentualPatronalInativos();
		this.observacoes = rubricaParametroTO.getObservacoes();		
	}
		
	
	public RubricaParametroTO toTO() {
		return new RubricaParametroTO(id, rubrica.getId(), vigenciaInicio, vigenciaFim, localEspecifico,
			classificacaoAreaNivel!=null?classificacaoAreaNivel.getId():null, area!=null?area.getId():null, 
			localidade!=null?localidade.getId():null, cargoEspecifico, cargo!=null?cargo.getId():null,
			ativo, valorBaseInicial, valorBaseFinal, percentual, percentualPatronal,
			valorTeto, valorDeducao, valorFixo, valorDeducaoPorDependente,
			valorDeducaoPorIdade, valorDeducaoPorDoenca, valorDeducaoPorAposentadoria, 
			percentualPatronalInativos, observacoes);
	}
	
	public RubricaParametro(Long id) {
		super();
		this.id = id;
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

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	public Boolean getLocalEspecifico() {
		return localEspecifico;
	}

	public void setLocalEspecifico(Boolean localEspecifico) {
		this.localEspecifico = localEspecifico;
	}

	public ClassificacaoAreaNivel getClassificacaoAreaNivel() {
		return classificacaoAreaNivel;
	}

	public void setClassificacaoAreaNivel(ClassificacaoAreaNivel classificacaoAreaNivel) {
		this.classificacaoAreaNivel = classificacaoAreaNivel;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Boolean getCargoEspecifico() {
		return cargoEspecifico;
	}

	public void setCargoEspecifico(Boolean cargoEspecifico) {
		this.cargoEspecifico = cargoEspecifico;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Double getValorBaseInicial() {
		return valorBaseInicial;
	}

	public void setValorBaseInicial(Double valorBaseInicial) {
		this.valorBaseInicial = valorBaseInicial;
	}

	public Double getValorBaseFinal() {
		return valorBaseFinal;
	}

	public void setValorBaseFinal(Double valorBaseFinal) {
		this.valorBaseFinal = valorBaseFinal;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public Double getPercentualPatronal() {
		return percentualPatronal;
	}

	public void setPercentualPatronal(Double percentualPatronal) {
		this.percentualPatronal = percentualPatronal;
	}

	public Double getValorTeto() {
		return valorTeto;
	}

	public void setValorTeto(Double valorTeto) {
		this.valorTeto = valorTeto;
	}

	public Double getValorDeducao() {
		return valorDeducao;
	}

	public void setValorDeducao(Double valorDeducao) {
		this.valorDeducao = valorDeducao;
	}

	public Double getValorFixo() {
		return valorFixo;
	}

	public void setValorFixo(Double valorFixo) {
		this.valorFixo = valorFixo;
	}

	public Double getValorDeducaoPorDependente() {
		return valorDeducaoPorDependente;
	}

	public void setValorDeducaoPorDependente(Double valorDeducaoPorDependente) {
		this.valorDeducaoPorDependente = valorDeducaoPorDependente;
	}

	public Double getValorDeducaoPorIdade() {
		return valorDeducaoPorIdade;
	}

	public void setValorDeducaoPorIdade(Double valorDeducaoPorIdade) {
		this.valorDeducaoPorIdade = valorDeducaoPorIdade;
	}

	public Double getValorDeducaoPorDoenca() {
		return valorDeducaoPorDoenca;
	}

	public void setValorDeducaoPorDoenca(Double valorDeducaoPorDoenca) {
		this.valorDeducaoPorDoenca = valorDeducaoPorDoenca;
	}

	public Double getValorDeducaoPorAposentadoria() {
		return valorDeducaoPorAposentadoria;
	}

	public void setValorDeducaoPorAposentadoria(Double valorDeducaoPorAposentadoria) {
		this.valorDeducaoPorAposentadoria = valorDeducaoPorAposentadoria;
	}

	public Double getPercentualPatronalInativos() {
		return percentualPatronalInativos;
	}

	public void setPercentualPatronalInativos(Double percentualPatronalInativos) {
		this.percentualPatronalInativos = percentualPatronalInativos;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		RubricaParametro other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RubricaParametro [id=" + id + ", vigenciaInicio=" + vigenciaInicio + ", vigenciaFim=" + vigenciaFim
				+ ", localEspecifico=" + localEspecifico + ", classificacaoAreaNivel=" + classificacaoAreaNivel
				+ ", area=" + area + ", localidade=" + localidade + ", cargoEspecifico=" + cargoEspecifico + ", cargo="
				+ cargo + ", ativo=" + ativo + ", valorBaseInicial=" + valorBaseInicial + ", valorBaseFinal="
				+ valorBaseFinal + ", percentual=" + percentual + ", percentualPatronal=" + percentualPatronal
				+ ", valorTeto=" + valorTeto + ", valorDeducao=" + valorDeducao + ", valorFixo=" + valorFixo
				+ ", valorDeducaoPorDependente=" + valorDeducaoPorDependente + ", valorDeducaoPorIdade="
				+ valorDeducaoPorIdade + ", valorDeducaoPorDoenca=" + valorDeducaoPorDoenca
				+ ", valorDeducaoPorAposentadoria=" + valorDeducaoPorAposentadoria + ", percentualPatronalInativos="
				+ percentualPatronalInativos + ", observacoes=" + observacoes + "]";
	}

	public void alterar(RubricaParametroTO rubricaParametroTO) {
		this.vigenciaInicio = rubricaParametroTO.getVigenciaInicio();
		this.vigenciaFim = rubricaParametroTO.getVigenciaFim();
		this.localEspecifico = rubricaParametroTO.getLocalEspecifico();
		
		if (rubricaParametroTO.getClassificacaoAreaNivelId()!=null)
			this.classificacaoAreaNivel = new ClassificacaoAreaNivel(rubricaParametroTO.getClassificacaoAreaNivelId());
		
		if (rubricaParametroTO.getAreaId()!=null)
			this.area = new Area(rubricaParametroTO.getAreaId());
		
		if (rubricaParametroTO.getLocalidadeId()!=null)
			this.localidade = new Localidade(rubricaParametroTO.getLocalidadeId());
		
		this.cargoEspecifico = rubricaParametroTO.getCargoEspecifico();
		
		if (rubricaParametroTO.getCargoId()!=null)
			this.cargo = new Cargo(rubricaParametroTO.getCargoId());
		
		this.ativo = rubricaParametroTO.getAtivo();
		
		this.valorBaseInicial = rubricaParametroTO.getValorBaseInicial();
		this.valorBaseFinal = rubricaParametroTO.getValorBaseFinal();
		this.percentual = rubricaParametroTO.getPercentual();
		this.percentualPatronal = rubricaParametroTO.getPercentualPatronal();
		this.valorTeto = rubricaParametroTO.getValorTeto();
		this.valorDeducao = rubricaParametroTO.getValorDeducao();
		this.valorFixo = rubricaParametroTO.getValorFixo();
		this.valorDeducaoPorDependente = rubricaParametroTO.getValorDeducaoPorDependente();
		this.valorDeducaoPorIdade = rubricaParametroTO.getValorDeducaoPorIdade();
		this.valorDeducaoPorDoenca = rubricaParametroTO.getValorDeducao();
		this.valorDeducaoPorAposentadoria = rubricaParametroTO.getValorDeducaoPorAposentadoria();
		this.percentualPatronalInativos = rubricaParametroTO.getPercentualPatronalInativos();
		this.observacoes = rubricaParametroTO.getObservacoes();		
	}
	
}