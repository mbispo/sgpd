package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
public class ItemCategoriaAvaliacaoEstagioProbatorio implements Serializable {

	private static final long serialVersionUID = 8182033226075191764L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private CategoriaAvaliacaoEstagioProbatorio categoria;

	@Column(length = 200)
	private String grau;

	@Column(length = 200)
	private String codigo;

	public ItemCategoriaAvaliacaoEstagioProbatorio() {
		super();
	}

	public ItemCategoriaAvaliacaoEstagioProbatorio(Long id, CategoriaAvaliacaoEstagioProbatorio categoria, String grau,
			String codigo) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.grau = grau;
		this.codigo = codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoriaAvaliacaoEstagioProbatorio getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaAvaliacaoEstagioProbatorio categoria) {
		this.categoria = categoria;
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		ItemCategoriaAvaliacaoEstagioProbatorio other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ItemCategoriaAvaliacaoEstagioProbatorio [id=" + id + ", categoria=" + categoria + ", grau=" + grau
				+ ", codigo=" + codigo + "]";
	}

}