package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.PlanoCargoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
public class PlanoCargo implements Serializable {

	private static final long serialVersionUID = -293074623159744950L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	private String nome;

	private Date data;

	public PlanoCargo() {
		super();
	}

	public PlanoCargo(Long id) {
		super();
		this.id = id;
	}

	public PlanoCargo(Long id, String nome, Date data) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
	}

	public PlanoCargo(PlanoCargoTO planoCargoTO) {
		this.nome = planoCargoTO.getNome();
		this.data = planoCargoTO.getData();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		PlanoCargo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PlanoCargo [id=" + id + ", nome=" + nome + ", data=" + data + "]";
	}

	public void alterar(PlanoCargoTO planoCargoTO) {
		this.nome = planoCargoTO.getNome();
		this.data = planoCargoTO.getData();
	}

}