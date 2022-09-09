package br.jus.tjms.esocial.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.esocial.enumerators.GrupoCategoriaTrabalhador;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class CategoriaTrabalhador implements Serializable {

	private static final long serialVersionUID = 3949478914483019779L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer codigo;
	
	@Column(length = 255)
	private String descricao;
	
	@Enumerated(EnumType.ORDINAL)
	private GrupoCategoriaTrabalhador grupo;

	public CategoriaTrabalhador() {
		super();
	}

	public CategoriaTrabalhador(Long id, Integer codigo, String descricao, GrupoCategoriaTrabalhador grupo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.grupo = grupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GrupoCategoriaTrabalhador getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoCategoriaTrabalhador grupo) {
		this.grupo = grupo;
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
		CategoriaTrabalhador other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CategoriaTrabalhador [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", grupo="
				+ grupo + "]";
	}

}