package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaPlanoSaudeTO;
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
public class RubricaPlanoSaude implements Serializable {

	private static final long serialVersionUID = 1138993641842887640L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = false)
	private Rubrica rubrica;

	@ManyToOne
	@JoinColumn(name = "planoSaude_id", nullable = false)
	private PlanoSaude planoSaude;

	private Double percentual;

	public RubricaPlanoSaude() {
		super();
	}

	public RubricaPlanoSaude(Long id, Rubrica rubrica, PlanoSaude planoSaude, Double percentual) {
		super();
		this.id = id;
		this.rubrica = rubrica;
		this.planoSaude = planoSaude;
		this.percentual = percentual;
	}

	public RubricaPlanoSaude(RubricaPlanoSaudeTO r, PlanoSaude planoSaude) {
		this.id = r.getId();
		this.percentual = r.getPercentual();
		this.planoSaude = planoSaude;
		this.rubrica = new Rubrica(r.getRubricaId());
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

	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
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
		RubricaPlanoSaude other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RubricaPlanoSaude [id=" + id + ", rubrica=" + rubrica + ", planoSaude=" + planoSaude + ", percentual="
				+ percentual + "]";
	}

}