package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoCurso;
import br.jus.tjms.sgpd.service.rest.v1.to.CursoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "curso.buscarCursosPorInstituicaoDeEnsino", 
			query = "SELECT c from Curso c WHERE c.instituicao.id = :instituicaoDeEnsinoId"),
	@NamedQuery(name = "curso.buscarCursosPorNome", 
		query = "SELECT c from Curso c WHERE c.descricao = :nome")
})
public class Curso implements Serializable {

	private static final long serialVersionUID = -4413843964859040731L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "instituicao_id", nullable = false)
	private InstituicaoEnsino instituicao;

	@ManyToOne
	@JoinColumn(name = "areaConhecimento_id", nullable = true)
	private AreaConhecimento areaConhecimento;

	@Column(length = 200)
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	private TipoCurso tipo;

	public Curso() {
		super();
	}

	public Curso(Long id, InstituicaoEnsino instituicao, AreaConhecimento areaConhecimento, String descricao,
			TipoCurso tipo) {
		super();
		this.id = id;
		this.instituicao = instituicao;
		this.areaConhecimento = areaConhecimento;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public Curso(CursoTO cursoTO) {
		super();
		//FIXME this.instituicao = cursoTO.getInstituicao();
		//FIXME this.areaConhecimento = cursoTO.getAreaConhecimento();
		this.descricao = cursoTO.getDescricao();
		this.tipo = cursoTO.getTipo();
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

	public TipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCurso tipo) {
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
		Curso other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", instituicao=" + instituicao + ", areaConhecimento=" + areaConhecimento
				+ ", descricao=" + descricao + ", tipo=" + tipo + "]";
	}

	public void alterar(CursoTO cursoTO) {
		//FIXME this.instituicao = cursoTO.getInstituicao();
		//FIXME this.areaConhecimento = cursoTO.getAreaConhecimento();
		this.descricao = cursoTO.getDescricao();
		this.tipo = cursoTO.getTipo();
	}

}