package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
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
public class ConcursoRealizacaoProva implements Serializable {

	private static final long serialVersionUID = -6556000087709311039L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id", nullable = false)	
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="concursoProva_id", nullable = false)
	private ConcursoProva concursoProva;

	public ConcursoRealizacaoProva() {		
		super();
	}

	public ConcursoRealizacaoProva(Long id, Pessoa pessoa, ConcursoProva concursoProva) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.concursoProva = concursoProva;
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

	public ConcursoProva getConcursoProva() {
		return concursoProva;
	}

	public void setConcursoProva(ConcursoProva concursoProva) {
		this.concursoProva = concursoProva;
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
		ConcursoRealizacaoProva other = (ConcursoRealizacaoProva) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcursoRealizacaoProva [id=" + id + ", pessoa=" + pessoa + ", concursoProva=" + concursoProva + "]";
	}

}