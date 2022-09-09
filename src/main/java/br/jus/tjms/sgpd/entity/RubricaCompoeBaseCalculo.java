package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoBaseCalculo;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaCompoeBaseCalculoTO;
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
	@NamedQuery(name = "rubricaCompoeBaseCalculoService.buscarRubricaCompoeBaseCalculoPorRubrica", 
			query = "SELECT r FROM RubricaCompoeBaseCalculo r WHERE r.rubrica.id = :rubricaId"),
})
public class RubricaCompoeBaseCalculo implements Serializable {

	private static final long serialVersionUID = -4735977792744250748L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = false)
	private Rubrica rubrica;

	@Enumerated(EnumType.ORDINAL)
	private TipoBaseCalculo tipoBaseCalculo;

	public RubricaCompoeBaseCalculo() {
		super();
	}

	public RubricaCompoeBaseCalculo(Long id, Rubrica rubrica, TipoBaseCalculo tipoBaseCalculo) {
		super();
		this.id = id;
		this.rubrica = rubrica;
		this.tipoBaseCalculo = tipoBaseCalculo;
	}
	
	public RubricaCompoeBaseCalculo(Rubrica rubrica, TipoBaseCalculo tipoBaseCalculo) {
		super();
		this.rubrica = rubrica;
		this.tipoBaseCalculo = tipoBaseCalculo;
	}

	public RubricaCompoeBaseCalculo(RubricaCompoeBaseCalculoTO rubricaCompoeBaseCalculoTO, Rubrica rubrica) {
		this.id = rubricaCompoeBaseCalculoTO.getId();
		this.rubrica = rubrica;
		this.tipoBaseCalculo = rubricaCompoeBaseCalculoTO.getTipoBaseCalculo();
	}
	
	public RubricaCompoeBaseCalculo(RubricaCompoeBaseCalculoTO rubricaCompoeBaseCalculoTO) {
		this.id = rubricaCompoeBaseCalculoTO.getId();
		this.rubrica = new Rubrica(rubricaCompoeBaseCalculoTO.getRubricaId());
		this.tipoBaseCalculo = rubricaCompoeBaseCalculoTO.getTipoBaseCalculo();
	}
	
	public void alterar(RubricaCompoeBaseCalculoTO rubricaCompoeBaseCalculoTO) {
		this.tipoBaseCalculo = rubricaCompoeBaseCalculoTO.getTipoBaseCalculo();		
	}

	public RubricaCompoeBaseCalculoTO toTO() {
		return new RubricaCompoeBaseCalculoTO(id, rubrica.getId(), tipoBaseCalculo);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public TipoBaseCalculo getTipoBaseCalculo() {
		return tipoBaseCalculo;
	}

	public void setTipoBaseCalculo(TipoBaseCalculo tipoBaseCalculo) {
		this.tipoBaseCalculo = tipoBaseCalculo;
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
		RubricaCompoeBaseCalculo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RubricaCompoeBaseCalculo [id=" + id + ", rubrica=" + rubrica + ", tipoBaseCalculo=" + tipoBaseCalculo
				+ "]";
	}

}