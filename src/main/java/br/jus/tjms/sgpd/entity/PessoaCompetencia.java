package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.PessoaCompetenciaTO;
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
	@NamedQuery(name = "pessoaCompetencia.buscarCompetenciasPorPessoa", 
			query = "SELECT pc.competencia from PessoaCompetencia pc WHERE pc.pessoa.id = :pessoaId")
})
public class PessoaCompetencia implements Serializable {

	private static final long serialVersionUID = -8948930229722724718L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "competencia_id", nullable = false)
	private Competencia competencia;

	public PessoaCompetencia() {
		super();
	}

	public PessoaCompetencia(Long id, Pessoa pessoa, Competencia competencia) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.competencia = competencia;
	}

	public PessoaCompetencia(PessoaCompetenciaTO pessoaCompetenciaTO) {
		this.pessoa = pessoaCompetenciaTO.getPessoa();
		//FIXME this.competencia = pessoaCompetenciaTO.getCompetenciaTO();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Competencia getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
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
		PessoaCompetencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PessoaCompetencia [id=" + id + ", pessoa=" + pessoa + ", competencia=" + competencia + "]";
	}

}