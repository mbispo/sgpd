package br.jus.tjms.esocial.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.esocial.enumerators.TipoBaseCalculoFPASTerceiros;
import br.jus.tjms.esocial.enumerators.TipoPessoaFPAS;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class CodigoAliquotaFPASTerceiros implements Serializable {

	private static final long serialVersionUID = -4516234855458464760L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer codigoFPAS;

	@Column(length = 255)
	private String descricaoAtividades;

	@Enumerated(EnumType.ORDINAL)
	private TipoBaseCalculoFPASTerceiros baseCalculo;

	@Enumerated(EnumType.ORDINAL)
	private TipoPessoaFPAS tipoPessoaFPAS;

	private Integer codigoTerceiros;
	private Double aliquotaTerceiros;

	public CodigoAliquotaFPASTerceiros() {
		super();
	}

	public CodigoAliquotaFPASTerceiros(Long id, Integer codigoFPAS, String descricaoAtividades,
			TipoBaseCalculoFPASTerceiros baseCalculo, TipoPessoaFPAS tipoPessoaFPAS, Integer codigoTerceiros,
			Double aliquotaTerceiros) {
		super();
		this.id = id;
		this.codigoFPAS = codigoFPAS;
		this.descricaoAtividades = descricaoAtividades;
		this.baseCalculo = baseCalculo;
		this.tipoPessoaFPAS = tipoPessoaFPAS;
		this.codigoTerceiros = codigoTerceiros;
		this.aliquotaTerceiros = aliquotaTerceiros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigoFPAS() {
		return codigoFPAS;
	}

	public void setCodigoFPAS(Integer codigoFPAS) {
		this.codigoFPAS = codigoFPAS;
	}

	public String getDescricaoAtividades() {
		return descricaoAtividades;
	}

	public void setDescricaoAtividades(String descricaoAtividades) {
		this.descricaoAtividades = descricaoAtividades;
	}

	public TipoBaseCalculoFPASTerceiros getBaseCalculo() {
		return baseCalculo;
	}

	public void setBaseCalculo(TipoBaseCalculoFPASTerceiros baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public TipoPessoaFPAS getTipoPessoaFPAS() {
		return tipoPessoaFPAS;
	}

	public void setTipoPessoaFPAS(TipoPessoaFPAS tipoPessoaFPAS) {
		this.tipoPessoaFPAS = tipoPessoaFPAS;
	}

	public Integer getCodigoTerceiros() {
		return codigoTerceiros;
	}

	public void setCodigoTerceiros(Integer codigoTerceiros) {
		this.codigoTerceiros = codigoTerceiros;
	}

	public Double getAliquotaTerceiros() {
		return aliquotaTerceiros;
	}

	public void setAliquotaTerceiros(Double aliquotaTerceiros) {
		this.aliquotaTerceiros = aliquotaTerceiros;
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
		CodigoAliquotaFPASTerceiros other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CodigoAliquotaFPASTerceiros [id=" + id + ", codigoFPAS=" + codigoFPAS + ", descricaoAtividades="
				+ descricaoAtividades + ", baseCalculo=" + baseCalculo + ", tipoPessoaFPAS=" + tipoPessoaFPAS
				+ ", codigoTerceiros=" + codigoTerceiros + ", aliquotaTerceiros=" + aliquotaTerceiros + "]";
	}

}