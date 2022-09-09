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
 * @created 11-dez-2015 18:15:46
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class ResultadoMonitoracaoBiologica implements Serializable {

	private static final long serialVersionUID = -2811559242712630200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer codigoAgenteQuimico;

	@Column(length = 255)
	private String nomeAgenteQuimico;

	public ResultadoMonitoracaoBiologica() {
		super();
	}

	public ResultadoMonitoracaoBiologica(Long id, Integer codigoAgenteQuimico, String nomeAgenteQuimico) {
		super();
		this.id = id;
		this.codigoAgenteQuimico = codigoAgenteQuimico;
		this.nomeAgenteQuimico = nomeAgenteQuimico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigoAgenteQuimico() {
		return codigoAgenteQuimico;
	}

	public void setCodigoAgenteQuimico(Integer codigoAgenteQuimico) {
		this.codigoAgenteQuimico = codigoAgenteQuimico;
	}

	public String getNomeAgenteQuimico() {
		return nomeAgenteQuimico;
	}

	public void setNomeAgenteQuimico(String nomeAgenteQuimico) {
		this.nomeAgenteQuimico = nomeAgenteQuimico;
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
		ResultadoMonitoracaoBiologica other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ResultadoMonitoracaoBiologica [id=" + id + ", codigoAgenteQuimico=" + codigoAgenteQuimico
				+ ", nomeAgenteQuimico=" + nomeAgenteQuimico + "]";
	}

}