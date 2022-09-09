package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
public class LocalRegistroFrequencia implements Serializable {

	private static final long serialVersionUID = 8347165510013949283L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	public LocalRegistroFrequencia() {
		super();
	}

	public LocalRegistroFrequencia(Long id, String descricao, Area area) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.area = area;
	}
	
	public LocalRegistroFrequencia(Long id) {
		super();
		this.id = id;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
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
		LocalRegistroFrequencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "LocalRegistroFrequencia [id=" + id + ", descricao=" + descricao + ", area=" + area + "]";
	}

}