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
public class ConceitoAvaliacaoEstagioProbatorio implements Serializable {

	private static final long serialVersionUID = -7813066100389999317L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "conceito_id", nullable = false)
	private ItemCategoriaAvaliacaoEstagioProbatorio conceito;

	@ManyToOne
	@JoinColumn(name = "avaliacaoEstagioProbatorio_id", nullable = false)
	private AvaliacaoEstagioProbatorio avaliacaoEstagioProbatorio;

	public ConceitoAvaliacaoEstagioProbatorio() {
		super();
	}

	public ConceitoAvaliacaoEstagioProbatorio(Long id, ItemCategoriaAvaliacaoEstagioProbatorio conceito,
			AvaliacaoEstagioProbatorio avaliacaoEstagioProbatorio) {
		super();
		this.id = id;
		this.conceito = conceito;
		this.avaliacaoEstagioProbatorio = avaliacaoEstagioProbatorio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemCategoriaAvaliacaoEstagioProbatorio getConceito() {
		return conceito;
	}

	public void setConceito(ItemCategoriaAvaliacaoEstagioProbatorio conceito) {
		this.conceito = conceito;
	}

	public AvaliacaoEstagioProbatorio getAvaliacaoEstagioProbatorio() {
		return avaliacaoEstagioProbatorio;
	}

	public void setAvaliacaoEstagioProbatorio(AvaliacaoEstagioProbatorio avaliacaoEstagioProbatorio) {
		this.avaliacaoEstagioProbatorio = avaliacaoEstagioProbatorio;
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
		ConceitoAvaliacaoEstagioProbatorio other = (ConceitoAvaliacaoEstagioProbatorio) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConceitoAvaliacaoEstagioProbatorio [id=" + id + ", conceito=" + conceito
				+ ", avaliacaoEstagioProbatorio=" + avaliacaoEstagioProbatorio + "]";
	}

}