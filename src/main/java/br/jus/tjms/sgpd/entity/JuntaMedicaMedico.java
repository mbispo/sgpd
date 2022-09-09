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
public class JuntaMedicaMedico implements Serializable {

	private static final long serialVersionUID = -6284936984601503635L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "juntaMedica_id", nullable = false)
	private JuntaMedica juntaMedica;

	@ManyToOne
	@JoinColumn(name = "medico_id", nullable = false)
	private Funcionario medico;

	public JuntaMedicaMedico() {
		super();
	}

	public JuntaMedicaMedico(Long id, JuntaMedica juntaMedica, Funcionario medico) {
		super();
		this.id = id;
		this.juntaMedica = juntaMedica;
		this.medico = medico;
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

	public Funcionario getMedico() {
		return medico;
	}

	public void setMedico(Funcionario medico) {
		this.medico = medico;
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
		JuntaMedicaMedico other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "JuntaMedicaMedico [id=" + id + ", juntaMedica=" + juntaMedica + ", medico=" + medico + "]";
	}

}