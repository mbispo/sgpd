package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.entity.Pessoa;

public class PessoaFormacaoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long pessoaId;
	private FormacaoAcademicaTO formacao;
	private Integer anoInicio;
	private Integer anoConclusao;
	private String descricao;
	private String atividades;
	private Pessoa pessoa;

	public PessoaFormacaoTO() {
		super();
	}

	public PessoaFormacaoTO(Long id, Long pessoaId, FormacaoAcademicaTO formacao, Integer anoInicio,
			Integer anoConclusao, String descricao, String atividades) {
		super();
		this.id = id;
		this.pessoaId = pessoaId;
		this.formacao = formacao;
		this.anoInicio = anoInicio;
		this.anoConclusao = anoConclusao;
		this.descricao = descricao;
		this.atividades = atividades;
	}

	public PessoaFormacaoTO(Long pessoaId, FormacaoAcademicaTO formacao, Integer anoInicio, Integer anoConclusao,
			String descricao, String atividades) {
		super();
		this.pessoaId = pessoaId;
		this.formacao = formacao;
		this.anoInicio = anoInicio;
		this.anoConclusao = anoConclusao;
		this.descricao = descricao;
		this.atividades = atividades;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public FormacaoAcademicaTO getFormacao() {
		return formacao;
	}

	public void setFormacao(FormacaoAcademicaTO formacao) {
		this.formacao = formacao;
	}

	public Integer getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(Integer anoInicio) {
		this.anoInicio = anoInicio;
	}

	public Integer getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(Integer anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "PessoaFormacaoTO [id=" + id + ", pessoaId=" + pessoaId + ", formacao=" + formacao + ", anoInicio="
				+ anoInicio + ", anoConclusao=" + anoConclusao + ", descricao=" + descricao + ", atividades="
				+ atividades + "]";
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
		PessoaFormacaoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}