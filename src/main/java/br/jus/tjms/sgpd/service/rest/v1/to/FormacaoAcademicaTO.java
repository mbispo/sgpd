package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoFormacaoAcademica;

public class FormacaoAcademicaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private InstituicaoEnsinoTO instituicao;
	private AreaConhecimentoTO areaConhecimento;
	private String descricao;
	private TipoFormacaoAcademica tipo;

	public FormacaoAcademicaTO() {
		super();
	}

	public FormacaoAcademicaTO(Long id, InstituicaoEnsinoTO instituicao, AreaConhecimentoTO areaConhecimento,
			String descricao, TipoFormacaoAcademica tipo) {
		super();
		this.id = id;
		this.instituicao = instituicao;
		this.areaConhecimento = areaConhecimento;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public FormacaoAcademicaTO(InstituicaoEnsinoTO instituicao, AreaConhecimentoTO areaConhecimento, String descricao,
			TipoFormacaoAcademica tipo) {
		super();
		this.instituicao = instituicao;
		this.areaConhecimento = areaConhecimento;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InstituicaoEnsinoTO getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoEnsinoTO instituicao) {
		this.instituicao = instituicao;
	}

	public AreaConhecimentoTO getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimentoTO areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoFormacaoAcademica getTipo() {
		return tipo;
	}

	public void setTipo(TipoFormacaoAcademica tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "FormacaoAcademicaTO [id=" + id + ", instituicao=" + instituicao + ", areaConhecimento="
				+ areaConhecimento + ", descricao=" + descricao + ", tipo=" + tipo + "]";
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
		FormacaoAcademicaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}