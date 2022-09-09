package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoClassificacaoContabil;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaTipoClassificacaoContabilTO;
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
public class RubricaTipoClassificacaoContabil implements Serializable {

	private static final long serialVersionUID = -8676507264720956346L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String classificacaoContabil;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = false)
	private Rubrica rubrica;

	@Enumerated(EnumType.ORDINAL)
	private TipoClassificacaoContabil tipoClassificacaoContabil;

	public RubricaTipoClassificacaoContabil() {
		super();
	}

	public RubricaTipoClassificacaoContabil(Long id, String classificacaoContabil, Rubrica rubrica,
			TipoClassificacaoContabil tipoClassificacaoContabil) {
		super();
		this.id = id;
		this.classificacaoContabil = classificacaoContabil;
		this.rubrica = rubrica;
		this.tipoClassificacaoContabil = tipoClassificacaoContabil;
	}

	public RubricaTipoClassificacaoContabil(RubricaTipoClassificacaoContabilTO rubricaTipoClassificacaoContabilTO) {
		this.id = rubricaTipoClassificacaoContabilTO.getId();
		this.classificacaoContabil = rubricaTipoClassificacaoContabilTO.getClassificacaoContabil();
		this.rubrica = new Rubrica(rubricaTipoClassificacaoContabilTO.getRubricaId());
		this.tipoClassificacaoContabil = rubricaTipoClassificacaoContabilTO.getTipoClassificacaoContabil();
	}
	
	public RubricaTipoClassificacaoContabil(RubricaTipoClassificacaoContabilTO rubricaTipoClassificacaoContabilTO, Rubrica rubrica) {
		this.id = rubricaTipoClassificacaoContabilTO.getId();
		this.classificacaoContabil = rubricaTipoClassificacaoContabilTO.getClassificacaoContabil();
		this.rubrica = rubrica;
		this.tipoClassificacaoContabil = rubricaTipoClassificacaoContabilTO.getTipoClassificacaoContabil();
	}
	
	
	public RubricaTipoClassificacaoContabil(Long id) {
		super();
		this.id = id;
	}
	
	public void alterar(RubricaTipoClassificacaoContabilTO rubricaTipoClassificacaoContabilTO) {
		this.classificacaoContabil = rubricaTipoClassificacaoContabilTO.getClassificacaoContabil();
		this.tipoClassificacaoContabil = rubricaTipoClassificacaoContabilTO.getTipoClassificacaoContabil();		
	}
	
	public RubricaTipoClassificacaoContabilTO toTO() {
		return new RubricaTipoClassificacaoContabilTO(id, classificacaoContabil, rubrica.getId(), tipoClassificacaoContabil);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassificacaoContabil() {
		return classificacaoContabil;
	}

	public void setClassificacaoContabil(String classificacaoContabil) {
		this.classificacaoContabil = classificacaoContabil;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public TipoClassificacaoContabil getTipoClassificacaoContabil() {
		return tipoClassificacaoContabil;
	}

	public void setTipoClassificacaoContabil(TipoClassificacaoContabil tipoClassificacaoContabil) {
		this.tipoClassificacaoContabil = tipoClassificacaoContabil;
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
		RubricaTipoClassificacaoContabil other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RubricaTipoClassificacaoContabil [id=" + id + ", classificacaoContabil=" + classificacaoContabil
				+ ", rubrica=" + rubrica.getDescricao() + ", tipoClassificacaoContabil=" + tipoClassificacaoContabil + "]";
	}

}