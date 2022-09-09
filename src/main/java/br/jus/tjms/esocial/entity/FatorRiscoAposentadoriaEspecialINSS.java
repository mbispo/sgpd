package br.jus.tjms.esocial.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class FatorRiscoAposentadoriaEspecialINSS implements Serializable {

	private static final long serialVersionUID = 2189017316162255606L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String codigoFator;

	@Column(length = 255)
	private String descricaoFator;

	private Integer tempoContribuicao;
	private Double aliquota;

	public FatorRiscoAposentadoriaEspecialINSS() {
		super();
	}

	public FatorRiscoAposentadoriaEspecialINSS(Long id, String codigoFator, String descricaoFator,
			Integer tempoContribuicao, Double aliquota) {
		super();
		this.id = id;
		this.codigoFator = codigoFator;
		this.descricaoFator = descricaoFator;
		this.tempoContribuicao = tempoContribuicao;
		this.aliquota = aliquota;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoFator() {
		return codigoFator;
	}

	public void setCodigoFator(String codigoFator) {
		this.codigoFator = codigoFator;
	}

	public String getDescricaoFator() {
		return descricaoFator;
	}

	public void setDescricaoFator(String descricaoFator) {
		this.descricaoFator = descricaoFator;
	}

	public Integer getTempoContribuicao() {
		return tempoContribuicao;
	}

	public void setTempoContribuicao(Integer tempoContribuicao) {
		this.tempoContribuicao = tempoContribuicao;
	}

	public Double getAliquota() {
		return aliquota;
	}

	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
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
		FatorRiscoAposentadoriaEspecialINSS other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FatorRiscoAposentadoriaEspecialINSS [id=" + id + ", codigoFator=" + codigoFator + ", descricaoFator="
				+ descricaoFator + ", tempoContribuicao=" + tempoContribuicao + ", aliquota=" + aliquota + "]";
	}

}