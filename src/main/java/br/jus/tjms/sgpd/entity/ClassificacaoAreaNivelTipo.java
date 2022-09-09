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
public class ClassificacaoAreaNivelTipo implements Serializable {

	private static final long serialVersionUID = 1636770485326507439L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "classificacaoAreaNivel_id", nullable = false)
	private ClassificacaoAreaNivel classificacaoAreaNivel;

	@Column(length = 200)
	private String descricao;

	public ClassificacaoAreaNivelTipo() {
		super();
	}

	public ClassificacaoAreaNivelTipo(Long id, ClassificacaoAreaNivel classificacaoAreaNivel, String descricao) {
		super();
		this.id = id;
		this.classificacaoAreaNivel = classificacaoAreaNivel;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClassificacaoAreaNivel getClassificacaoAreaNivel() {
		return classificacaoAreaNivel;
	}

	public void setClassificacaoAreaNivel(ClassificacaoAreaNivel classificacaoAreaNivel) {
		this.classificacaoAreaNivel = classificacaoAreaNivel;
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
		ClassificacaoAreaNivelTipo other = (ClassificacaoAreaNivelTipo) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ClassificacaoAreaNivelTipo [id=" + id + ", classificacaoAreaNivel=" + classificacaoAreaNivel
				+ ", descricao=" + descricao + "]";
	}

}