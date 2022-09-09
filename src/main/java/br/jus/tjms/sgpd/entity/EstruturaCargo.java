package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.EstruturaCargoTO;
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
public class EstruturaCargo implements Serializable {

	private static final long serialVersionUID = -3203030041631538252L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	private String nome;

	private Date data;

	public EstruturaCargo() {
		super();
	}

	public EstruturaCargo(Long id) {
		super();
		this.id = id;
	}

	public EstruturaCargo(Long id, String nome, Date data) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
	}

	public EstruturaCargo(EstruturaCargoTO estruturaCargoTO) {
		this.nome = estruturaCargoTO.getNome();
		this.data = estruturaCargoTO.getData();
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
		EstruturaCargo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "EstruturaCargo [id=" + id + ", nome=" + nome + ", data=" + data + "]";
	}

	public void alterar(EstruturaCargoTO estruturaCargoTO) {
		this.nome = estruturaCargoTO.getNome();
		this.data = estruturaCargoTO.getData();
	}

}