package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.QuadroPessoalTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
public class QuadroPessoal implements Serializable {

	private static final long serialVersionUID = -8517229761488935024L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="estruturaCargo_id", nullable = true)
	private EstruturaCargo estruturaCargo;	
	
	@ManyToOne
	@JoinColumn(name="planoCargo_id", nullable = false)
	private PlanoCargo planoCargo;
	
	@Column(length = 200)
	private String nome;

	public QuadroPessoal() {
		super();
	}

	public QuadroPessoal(Long id) {
		super();
		this.id = id;
	}

	public QuadroPessoal(Long id, EstruturaCargo estruturaCargo, PlanoCargo planoCargo, String nome) {
		super();
		this.id = id;
		this.estruturaCargo = estruturaCargo;
		this.planoCargo = planoCargo;
		this.nome = nome;
	}

	public QuadroPessoal(QuadroPessoalTO quadroPessoalTO) {
		this.planoCargo = new PlanoCargo(quadroPessoalTO.getPlanoCargoId());
		this.estruturaCargo = new EstruturaCargo(quadroPessoalTO.getEstruturaCargoId());
		this.nome = quadroPessoalTO.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlanoCargo getPlanoCargo() {
		return planoCargo;
	}

	public void setPlanoCargo(PlanoCargo planoCargo) {
		this.planoCargo = planoCargo;
	}
	
	public EstruturaCargo getEstruturaCargo() {
		return estruturaCargo;
	}

	public void setEstruturaCargo(EstruturaCargo estruturaCargo) {
		this.estruturaCargo = estruturaCargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		QuadroPessoal other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "QuadroPessoal [id=" + id + ", estruturaCargo=" + estruturaCargo + ", planoCargo=" + planoCargo
				+ ", nome=" + nome + "]";
	}

	public void alterar(QuadroPessoalTO quadroPessoalTO) {
		this.planoCargo = new PlanoCargo(quadroPessoalTO.getPlanoCargoId());
		this.estruturaCargo = new EstruturaCargo(quadroPessoalTO.getEstruturaCargoId());
		this.nome = quadroPessoalTO.getNome();
	}
	
}