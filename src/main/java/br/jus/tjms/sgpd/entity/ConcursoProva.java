package br.jus.tjms.sgpd.entity;


import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class ConcursoProva implements Serializable {

	private static final long serialVersionUID = -6502106752613282877L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "concurso_id", nullable = false)
	private Concurso concurso;

	private Date dataAplicacao;

	public ConcursoProva() {
		super();
	}

	public ConcursoProva(Long id, Concurso concurso, Date dataAplicacao) {
		super();
		this.id = id;
		this.concurso = concurso;
		this.dataAplicacao = dataAplicacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}

	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
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
		ConcursoProva other = (ConcursoProva) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcursoProva [id=" + id + ", concurso=" + concurso + ", dataAplicacao=" + dataAplicacao + "]";
	}

}