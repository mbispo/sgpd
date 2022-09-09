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
public class JuntaMedicaPerito implements Serializable {

	private static final long serialVersionUID = -4122100102013745071L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "juntaMedica_id", nullable = false)
	private JuntaMedica juntaMedica;

	@ManyToOne
	@JoinColumn(name = "perito_id", nullable = false)
	private Funcionario perito;

	public JuntaMedicaPerito() {
		super();
	}

	public JuntaMedicaPerito(Long id, JuntaMedica juntaMedica, Funcionario perito) {
		super();
		this.id = id;
		this.juntaMedica = juntaMedica;
		this.perito = perito;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JuntaMedica getJuntaMedica() {
		return juntaMedica;
	}

	public void setJuntaMedica(JuntaMedica juntaMedica) {
		this.juntaMedica = juntaMedica;
	}

	public Funcionario getPerito() {
		return perito;
	}

	public void setPerito(Funcionario perito) {
		this.perito = perito;
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
		JuntaMedicaPerito other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "JuntaMedicaPerito [id=" + id + ", juntaMedica=" + juntaMedica + ", perito=" + perito + "]";
	}

}