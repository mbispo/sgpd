package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.NaturezaGrupoCargo;
import br.jus.tjms.sgpd.service.rest.v1.to.GrupoCargoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
public class GrupoCargo implements Serializable {

	private static final long serialVersionUID = -9013601748125028200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "quadro_id", nullable = false)
	private QuadroPessoal quadro;

	@Enumerated(EnumType.ORDINAL)
	private NaturezaGrupoCargo natureza;

	@Column(length = 200)
	private String nome;

	public GrupoCargo() {
		super();

	}
	
	public GrupoCargo(Long id) {
		super();
		this.id = id;
	}

	public GrupoCargo(Long id, QuadroPessoal quadro, NaturezaGrupoCargo natureza, String nome) {
		super();
		this.id = id;
		this.quadro = quadro;
		this.natureza = natureza;
		this.nome = nome;
	}
	
	public GrupoCargo(QuadroPessoal quadroPessoal, GrupoCargoTO grupoCargoTO) {
		this.quadro = quadroPessoal;
		this.natureza = grupoCargoTO.getNatureza();
		this.nome = grupoCargoTO.getNome();
	}

	public GrupoCargo(Long quadroPessoalId, GrupoCargoTO grupoCargoTO) {
		this.id = grupoCargoTO.getId();
		this.quadro = new QuadroPessoal(quadroPessoalId);
		this.natureza = grupoCargoTO.getNatureza();
		this.nome = grupoCargoTO.getNome();
	}

	public GrupoCargo(GrupoCargoTO grupoCargoTO) {
		this.id = grupoCargoTO.getId();
		this.quadro = new QuadroPessoal(grupoCargoTO.getQuadroId());
		this.natureza = grupoCargoTO.getNatureza();
		this.nome = grupoCargoTO.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QuadroPessoal getQuadro() {
		return quadro;
	}

	public void setQuadro(QuadroPessoal quadro) {
		this.quadro = quadro;
	}

	public NaturezaGrupoCargo getNatureza() {
		return natureza;
	}

	public void setNatureza(NaturezaGrupoCargo natureza) {
		this.natureza = natureza;
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
		GrupoCargo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "GrupoCargo [id=" + id + ", quadro=" + quadro + ", natureza=" + natureza + ", nome=" + nome + "]";
	}

	public void alterar(QuadroPessoal quadroPessoal, GrupoCargoTO grupoCargoTO) {
		this.quadro = new QuadroPessoal(grupoCargoTO.getQuadroId());
		this.natureza = grupoCargoTO.getNatureza();
		this.nome = grupoCargoTO.getNome();
	}

}