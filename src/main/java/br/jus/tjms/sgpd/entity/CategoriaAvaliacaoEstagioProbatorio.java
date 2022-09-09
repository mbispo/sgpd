package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
public class CategoriaAvaliacaoEstagioProbatorio implements Serializable {

	private static final long serialVersionUID = -5524787821120244997L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fator_id", nullable = false)
	private FatorAvaliacaoEstagioProbatorio fator;

	@Column(length = 200)
	private String nome;

	@Column(length = 200)
	private String descricao;

	public CategoriaAvaliacaoEstagioProbatorio() {
		super();
	}

	public CategoriaAvaliacaoEstagioProbatorio(Long id, FatorAvaliacaoEstagioProbatorio fator, String nome,
			String descricao) {
		super();
		this.id = id;
		this.fator = fator;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FatorAvaliacaoEstagioProbatorio getFator() {
		return fator;
	}

	public void setFator(FatorAvaliacaoEstagioProbatorio fator) {
		this.fator = fator;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		CategoriaAvaliacaoEstagioProbatorio other = (CategoriaAvaliacaoEstagioProbatorio) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CategoriaAvaliacaoEstagioProbatorio [id=" + id + ", fator=" + fator + ", nome=" + nome + ", descricao="
				+ descricao + "]";
	}

}