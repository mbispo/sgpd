package br.jus.tjms.sgpd.service.rest.v1.to;


import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RubricaParametroTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long rubricaId;
	private Date vigenciaInicio;
	private Date vigenciaFim;
	private Boolean localEspecifico = false;
	private Long classificacaoAreaNivelId;
	private Long areaId;
	private Long localidadeId;
	private Boolean cargoEspecifico = false;
	private Long cargoId;
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
	private String observacoes;	
	
	public RubricaParametroTO() {
		super();
	}

	public RubricaParametroTO(Long id, Long rubricaId, Date vigenciaInicio, Date vigenciaFim, Boolean localEspecifico,
			Long classificacaoAreaNivelId, Long areaId, Long localidadeId, Boolean cargoEspecifico, Long cargoId,
			Boolean ativo, Double valorBaseInicial, Double valorBaseFinal, Double percentual, Double percentualPatronal,
			Double valorTeto, Double valorDeducao, Double valorFixo, Double valorDeducaoPorDependente,
			Double valorDeducaoPorIdade, Double valorDeducaoPorDoenca, Double valorDeducaoPorAposentadoria, 
			Double percentualPatronalInativos, String observacoes) {
		super();
		this.id = id;
		this.rubricaId = rubricaId;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.localEspecifico = localEspecifico;
		this.classificacaoAreaNivelId = classificacaoAreaNivelId;
		this.areaId = areaId;
		this.localidadeId = localidadeId;
		this.cargoEspecifico = cargoEspecifico;
		this.cargoId = cargoId;
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

	public RubricaParametroTO(Long rubricaId, Date vigenciaInicio, Date vigenciaFim, Boolean localEspecifico,
			Long classificacaoAreaNivelId, Long areaId, Long localidadeId, Boolean cargoEspecifico, Long cargoId,
			Boolean ativo, Double valorBaseInicial, Double valorBaseFinal, Double percentual, Double percentualPatronal,
			Double valorTeto, Double valorDeducao, Double valorFixo, Double valorDeducaoPorDependente,
			Double valorDeducaoPorIdade, Double valorDeducaoPorDoenca, Double valorDeducaoPorAposentadoria, 
			Double percentualPatronalInativos, String observacoes) {
		super();
		this.rubricaId = rubricaId;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.localEspecifico = localEspecifico;
		this.classificacaoAreaNivelId = classificacaoAreaNivelId;
		this.areaId = areaId;
		this.localidadeId = localidadeId;
		this.cargoEspecifico = cargoEspecifico;
		this.cargoId = cargoId;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Long rubricaId) {
		this.rubricaId = rubricaId;
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

	public Long getClassificacaoAreaNivelId() {
		return classificacaoAreaNivelId;
	}

	public void setClassificacaoAreaNivelId(Long classificacaoAreaNivelId) {
		this.classificacaoAreaNivelId = classificacaoAreaNivelId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getLocalidadeId() {
		return localidadeId;
	}

	public void setLocalidadeId(Long localidadeId) {
		this.localidadeId = localidadeId;
	}

	public Boolean getCargoEspecifico() {
		return cargoEspecifico;
	}

	public void setCargoEspecifico(Boolean cargoEspecifico) {
		this.cargoEspecifico = cargoEspecifico;
	}

	public Long getCargoId() {
		return cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
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
	public String toString() {
		return "RubricaParametroTO [id=" + id + ", rubricaId=" + rubricaId + ", vigenciaInicio=" + vigenciaInicio
				+ ", vigenciaFim=" + vigenciaFim + ", localEspecifico=" + localEspecifico
				+ ", classificacaoAreaNivelId=" + classificacaoAreaNivelId + ", areaId=" + areaId + ", localidadeId="
				+ localidadeId + ", cargoEspecifico=" + cargoEspecifico + ", cargoId=" + cargoId + ", ativo=" + ativo
				+ ", valorBaseInicial=" + valorBaseInicial + ", valorBaseFinal=" + valorBaseFinal + ", percentual="
				+ percentual + ", percentualPatronal=" + percentualPatronal + ", valorTeto=" + valorTeto
				+ ", valorDeducao=" + valorDeducao + ", valorFixo=" + valorFixo + ", valorDeducaoPorDependente="
				+ valorDeducaoPorDependente + ", valorDeducaoPorIdade=" + valorDeducaoPorIdade
				+ ", valorDeducaoPorDoenca=" + valorDeducaoPorDoenca + ", valorDeducaoPorAposentadoria="
				+ valorDeducaoPorAposentadoria + ", percentualPatronalInativos=" + percentualPatronalInativos
				+ ", observacoes=" + observacoes + "]";
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
		RubricaParametroTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}