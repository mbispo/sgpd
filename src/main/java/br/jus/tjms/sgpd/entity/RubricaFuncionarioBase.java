package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaFuncionarioBaseTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
		@NamedQuery(name = "rubricaFuncionarioBase.buscarPorRubricaFuncionarioId", 
				query = "SELECT r FROM RubricaFuncionarioBase r WHERE r.rubricaFuncionario.id = :rubricaFuncionarioId"), 
})
public class RubricaFuncionarioBase implements Serializable {

	private static final long serialVersionUID = -8710531844704956892L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rubricaBase_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private RubricaFuncionario rubricaFuncionario;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = false)
	private Rubrica rubrica;
	
	public RubricaFuncionarioBase() {
		super();
	}

	public RubricaFuncionarioBase(RubricaFuncionario rubricaFuncionario, Rubrica rubrica) {
		super();
		this.rubricaFuncionario = rubricaFuncionario;
		this.rubrica = rubrica;
	}

	public RubricaFuncionarioBase(Long id) {
		super();
		this.id = id;
	}
	
	public RubricaFuncionarioBase(RubricaFuncionarioBaseTO to, RubricaFuncionario rubricaFuncionario) {
		this.rubrica = new Rubrica(to.getRubricaId());
		this.rubricaFuncionario = rubricaFuncionario;
	}

	public RubricaFuncionarioBase(RubricaFuncionarioBaseTO to) {
		this.id = to.getId();
		this.rubrica = new Rubrica(to.getRubricaId());
		this.rubricaFuncionario = new RubricaFuncionario(to.getRubricaFuncionarioId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RubricaFuncionario getRubricaFuncionario() {
		return rubricaFuncionario;
	}

	public void setRubricaFuncionario(RubricaFuncionario rubricaFuncionario) {
		this.rubricaFuncionario = rubricaFuncionario;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	@Override
	public String toString() {
		return "RubricaFuncionarioBase [id=" + id + ", rubricaFuncionario=" + rubricaFuncionario + ", rubrica="
				+ rubrica + "]";
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
		RubricaFuncionarioBase other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}