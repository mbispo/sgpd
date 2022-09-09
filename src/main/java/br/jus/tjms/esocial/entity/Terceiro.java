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
 * @created 11-dez-2015 18:15:49
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class Terceiro implements Serializable {

	private static final long serialVersionUID = 4339911747935743807L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer codigo;
	
	@Column(length = 255)
	private String nome;
	
	private Double aliquota;

	public Terceiro() {
		super();
	}

	public Terceiro(Long id, Integer codigo, String nome, Double aliquota) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.aliquota = aliquota;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getAliquota() {
		return aliquota;
	}

	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
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
		Terceiro other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Terceiro [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", aliquota=" + aliquota + "]";
	}

}