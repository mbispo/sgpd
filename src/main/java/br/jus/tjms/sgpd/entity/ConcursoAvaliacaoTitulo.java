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
public class ConcursoAvaliacaoTitulo implements Serializable {

	private static final long serialVersionUID = 7264390455034283141L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "concursoAvaliacao_id", nullable = false)
	private ConcursoAvaliacao concursoAvaliacao;

	@Column(length = 200)
	private String descricao;

	private Integer pontuacao;

	public ConcursoAvaliacaoTitulo() {
		super();
	}

	public ConcursoAvaliacaoTitulo(Long id, ConcursoAvaliacao concursoAvaliacao, String descricao, Integer pontuacao) {
		super();
		this.id = id;
		this.concursoAvaliacao = concursoAvaliacao;
		this.descricao = descricao;
		this.pontuacao = pontuacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConcursoAvaliacao getConcursoAvaliacao() {
		return concursoAvaliacao;
	}

	public void setConcursoAvaliacao(ConcursoAvaliacao concursoAvaliacao) {
		this.concursoAvaliacao = concursoAvaliacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
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
		ConcursoAvaliacaoTitulo other = (ConcursoAvaliacaoTitulo) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcursoAvaliacaoTitulo [id=" + id + ", concursoAvaliacao=" + concursoAvaliacao + ", descricao="
				+ descricao + ", pontuacao=" + pontuacao + "]";
	}

}