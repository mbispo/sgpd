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
public class ConcursoAvaliacaoProva implements Serializable {

	private static final long serialVersionUID = -5012677859994051259L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "concursoProva_id", nullable = false)
	private ConcursoProva concursoProva;

	@ManyToOne
	@JoinColumn(name = "concursoAvaliacao_id", nullable = false)
	private ConcursoAvaliacao concursoAvaliacao;

	public ConcursoAvaliacaoProva() {
		super();
	}

	public ConcursoAvaliacaoProva(Long id, ConcursoProva concursoProva, ConcursoAvaliacao concursoAvaliacao) {
		super();
		this.id = id;
		this.concursoProva = concursoProva;
		this.concursoAvaliacao = concursoAvaliacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConcursoProva getConcursoProva() {
		return concursoProva;
	}

	public void setConcursoProva(ConcursoProva concursoProva) {
		this.concursoProva = concursoProva;
	}

	public ConcursoAvaliacao getConcursoAvaliacao() {
		return concursoAvaliacao;
	}

	public void setConcursoAvaliacao(ConcursoAvaliacao concursoAvaliacao) {
		this.concursoAvaliacao = concursoAvaliacao;
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
		ConcursoAvaliacaoProva other = (ConcursoAvaliacaoProva) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcursoAvaliacaoProva [id=" + id + ", concursoProva=" + concursoProva + ", concursoAvaliacao="
				+ concursoAvaliacao + "]";
	}

}