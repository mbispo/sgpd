package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.PessoaFormacaoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "pessoaFormacao.buscarFormacoesAcademicasPorPessoa", 
			query = "SELECT pf.formacao from PessoaFormacao pf WHERE pf.pessoa.id = :pessoaId")
})
public class PessoaFormacao implements Serializable {

	private static final long serialVersionUID = -3450828940664838888L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "formacao_id", nullable = false)
	private FormacaoAcademica formacao;

	private Integer anoInicio;
	private Integer anoConclusao;

	@Column(length = 200)
	private String descricao;

	@Column(length = 500)
	private String atividades;

	public PessoaFormacao() {
		super();
	}

	public PessoaFormacao(Long id, Pessoa pessoa, FormacaoAcademica formacao, Integer anoInicio, Integer anoConclusao,
			String descricao, String atividades) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.formacao = formacao;
		this.anoInicio = anoInicio;
		this.anoConclusao = anoConclusao;
		this.descricao = descricao;
		this.atividades = atividades;
	}

	public PessoaFormacao(PessoaFormacaoTO pessoaFormacaoTO) {
		this.pessoa = pessoaFormacaoTO.getPessoa();
		//FIXME this.formacao = pessoaFormacaoTO.getFormacao();
		this.anoInicio = pessoaFormacaoTO.getAnoInicio();
		this.anoConclusao = pessoaFormacaoTO.getAnoConclusao();
		this.descricao = pessoaFormacaoTO.getDescricao();
		this.atividades = pessoaFormacaoTO.getAtividades();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FormacaoAcademica getFormacao() {
		return formacao;
	}

	public void setFormacao(FormacaoAcademica formacao) {
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
		PessoaFormacao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PessoaFormacao [id=" + id + ", pessoa=" + pessoa + ", formacao=" + formacao + ", anoInicio="
				+ anoInicio + ", anoConclusao=" + anoConclusao + ", descricao=" + descricao + ", atividades="
				+ atividades + "]";
	}

}