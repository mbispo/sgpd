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
import br.jus.tjms.esocial.enumerators.GrauFatorRisco;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class FatorRiscoInsalubridadePericulosidadePenosidadeMTE implements Serializable {

	private static final long serialVersionUID = -4492624062151850530L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String codigoFator;

	@Column(length = 255)
	private String descricaoFator;

	@Enumerated(EnumType.ORDINAL)
	private GrauFatorRisco grau;

	@Column(length = 500)
	private String atividadesOuOperacoes;

	public FatorRiscoInsalubridadePericulosidadePenosidadeMTE() {
		super();
	}

	public FatorRiscoInsalubridadePericulosidadePenosidadeMTE(Long id, String codigoFator, String descricaoFator,
			GrauFatorRisco grau, String atividadesOuOperacoes) {
		super();
		this.id = id;
		this.codigoFator = codigoFator;
		this.descricaoFator = descricaoFator;
		this.grau = grau;
		this.atividadesOuOperacoes = atividadesOuOperacoes;
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

	public GrauFatorRisco getGrau() {
		return grau;
	}

	public void setGrau(GrauFatorRisco grau) {
		this.grau = grau;
	}

	public String getAtividadesOuOperacoes() {
		return atividadesOuOperacoes;
	}

	public void setAtividadesOuOperacoes(String atividadesOuOperacoes) {
		this.atividadesOuOperacoes = atividadesOuOperacoes;
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
		FatorRiscoInsalubridadePericulosidadePenosidadeMTE other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FatorRiscoInsalubridadePericulosidadePenosidadeMTE [id=" + id + ", codigoFator=" + codigoFator
				+ ", descricaoFator=" + descricaoFator + ", grau=" + grau + ", atividadesOuOperacoes="
				+ atividadesOuOperacoes + "]";
	}

}