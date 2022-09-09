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
public class ClassificacaoAreaNivel implements Serializable {

	private static final long serialVersionUID = 3025567192452568247L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer nivel;

	@Column(length = 200)
	private String descricao;

	public ClassificacaoAreaNivel() {
		super();
	}

	public ClassificacaoAreaNivel(Long id) {
		super();
		this.id = id;
	}

	public ClassificacaoAreaNivel(Long id, Integer nivel, String descricao) {
		super();
		this.id = id;
		this.nivel = nivel;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
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
		ClassificacaoAreaNivel other = (ClassificacaoAreaNivel) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ClassificacaoAreaNivel [id=" + id + ", nivel=" + nivel + ", descricao=" + descricao + "]";
	}

}