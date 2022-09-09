package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoFormacaoAcademica;
import br.jus.tjms.sgpd.service.rest.v1.to.FormacaoAcademicaTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:57
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "formacaoAcademica.buscarFormacoesAcademicasPorInstituicaoDeEnsino", 
			query = "SELECT f from FormacaoAcademica f WHERE f.instituicao.id = :instituicaoEnsinoId"),
	@NamedQuery(name = "formacaoAcademica.buscarFormacoesAcademicasPorDescricao", 
			query = "SELECT f from FormacaoAcademica f WHERE f.descricao = :descricao")
})
public class FormacaoAcademica implements Serializable {

	private static final long serialVersionUID = -4930834652576192801L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "instituicao_id", nullable = false)
	private InstituicaoEnsino instituicao;

	@ManyToOne
	@JoinColumn(name = "areaConhecimento_id", nullable = false)
	private AreaConhecimento areaConhecimento;

	@Column(length = 200)
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	private TipoFormacaoAcademica tipo;

	public FormacaoAcademica() {
		super();
	}

	public FormacaoAcademica(Long id, InstituicaoEnsino instituicao, AreaConhecimento areaConhecimento,
			String descricao, TipoFormacaoAcademica tipo) {
		super();
		this.id = id;
		this.instituicao = instituicao;
		this.areaConhecimento = areaConhecimento;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public FormacaoAcademica(FormacaoAcademicaTO formacaoAcademicaTO) {
		//FIXME this.instituicao = formacaoAcademicaTO.getInstituicao();
		//FIXME this.areaConhecimento = formacaoAcademicaTO.getAreaConhecimento();
		this.descricao = formacaoAcademicaTO.getDescricao();
		this.tipo = formacaoAcademicaTO.getTipo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InstituicaoEnsino getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoEnsino instituicao) {
		this.instituicao = instituicao;
	}

	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
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
		FormacaoAcademica other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FormacaoAcademica [id=" + id + ", instituicao=" + instituicao + ", areaConhecimento=" + areaConhecimento
				+ ", descricao=" + descricao + ", tipo=" + tipo + "]";
	}

	public void alterar(FormacaoAcademicaTO formacaoAcademicaTO) {
		//FIXME this.instituicao = formacaoAcademicaTO.getInstituicao();
		//FIXME this.areaConhecimento = formacaoAcademicaTO.getAreaConhecimento();
		this.descricao = formacaoAcademicaTO.getDescricao();
		this.tipo = formacaoAcademicaTO.getTipo();
	}

}