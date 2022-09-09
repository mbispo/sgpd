package br.jus.tjms.esocial.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class AgenteCausadorAcidenteTrabalho implements Serializable {

	private static final long serialVersionUID = 6353902329281856888L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String codigo;

	@Column(length = 255)
	private String descricao;

	public AgenteCausadorAcidenteTrabalho() {
		super();
	}

	public AgenteCausadorAcidenteTrabalho(Long id, String codigo, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		AgenteCausadorAcidenteTrabalho other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "AgenteCausadorAcidenteTrabalho [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}