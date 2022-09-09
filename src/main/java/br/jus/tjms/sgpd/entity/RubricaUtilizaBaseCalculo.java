package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoBaseCalculo;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaUtilizaBaseCalculoTO;
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
public class RubricaUtilizaBaseCalculo implements Serializable {

	private static final long serialVersionUID = 4931592424754268434L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = false)
	private Rubrica rubrica;

	@Enumerated(EnumType.ORDINAL)
	private TipoBaseCalculo tipoBaseCalculo;

	public RubricaUtilizaBaseCalculo() {
		super();
	}

	public RubricaUtilizaBaseCalculo(Long id, Rubrica rubrica, TipoBaseCalculo tipoBaseCalculo) {
		super();
		this.id = id;
		this.rubrica = rubrica;
		this.tipoBaseCalculo = tipoBaseCalculo;
	}
	
	public RubricaUtilizaBaseCalculo(Rubrica rubrica, TipoBaseCalculo tipoBaseCalculo) {
		super();
		this.rubrica = rubrica;
		this.tipoBaseCalculo = tipoBaseCalculo;
	}

	public RubricaUtilizaBaseCalculo(RubricaUtilizaBaseCalculoTO rubricaUtilizaBaseCalculoTO, Rubrica rubrica) {
		this.id = rubricaUtilizaBaseCalculoTO.getId();
		this.rubrica = rubrica;
		this.tipoBaseCalculo = rubricaUtilizaBaseCalculoTO.getTipoBaseCalculo();
	}

	public RubricaUtilizaBaseCalculo(RubricaUtilizaBaseCalculoTO rubricaUtilizaBaseCalculoTO) {
		this.id = rubricaUtilizaBaseCalculoTO.getId();
		this.rubrica = new Rubrica(rubricaUtilizaBaseCalculoTO.getRubricaId());
		this.tipoBaseCalculo = rubricaUtilizaBaseCalculoTO.getTipoBaseCalculo();
	}
	
	public RubricaUtilizaBaseCalculoTO toTO() {
		return new RubricaUtilizaBaseCalculoTO(id, rubrica.getId(), tipoBaseCalculo);
	}

	public Long getId() {
		return id;
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
		RubricaUtilizaBaseCalculo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RubricaUtilizaBaseCalculo [id=" + id + ", rubrica=" + rubrica + ", tipoBaseCalculo=" + tipoBaseCalculo
				+ "]";
	}

	public void alterar(RubricaUtilizaBaseCalculoTO rubricaUtilizaBaseCalculoTO) {
		this.tipoBaseCalculo = rubricaUtilizaBaseCalculoTO.getTipoBaseCalculo();
	}

}