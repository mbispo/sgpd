package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "pessoaCurso.buscarCursosPorPessoa", 
			query = "SELECT pc.curso from PessoaCurso pc WHERE pc.pessoa.id = :pessoaId")
})
public class PessoaCurso implements Serializable {

	private static final long serialVersionUID = -3532293510016288250L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="curso_id", nullable = false)
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id", nullable = false)
	private Pessoa pessoa;
	
	private Date inicio;
	private Date fim;
	
	private Integer cargaHoraria;

	public PessoaCurso() {
		super();
	}

	public PessoaCurso(Long id, Curso curso, Pessoa pessoa, Date inicio, Date fim, Integer cargaHoraria) {
		super();
		this.id = id;
		this.curso = curso;
		this.pessoa = pessoa;
		this.inicio = inicio;
		this.fim = fim;
		this.cargaHoraria = cargaHoraria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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
		PessoaCurso other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	@Override
	public String toString() {
		return "PessoaCurso [id=" + id + ", curso=" + curso + ", pessoa=" + pessoa + ", inicio=" + inicio + ", fim="
				+ fim + ", cargaHoraria=" + cargaHoraria + "]";
	}

}