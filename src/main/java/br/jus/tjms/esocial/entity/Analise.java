package br.jus.tjms.esocial.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class Analise implements Serializable {

	private static final long serialVersionUID = -2588198420023144395L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="agenteQuimico_id", nullable = false)
	private ResultadoMonitoracaoBiologica agenteQuimico;
	
	@Column(length = 50)
	private String codigo;
	
	@Column(length = 255)
	private String nome;

	public Analise() {
		super();
	}

	public Analise(Long id, ResultadoMonitoracaoBiologica agenteQuimico, String codigo, String nome) {
		super();
		this.id = id;
		this.agenteQuimico = agenteQuimico;
		this.codigo = codigo;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ResultadoMonitoracaoBiologica getAgenteQuimico() {
		return agenteQuimico;
	}

	public void setAgenteQuimico(ResultadoMonitoracaoBiologica agenteQuimico) {
		this.agenteQuimico = agenteQuimico;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		Analise other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Analise [id=" + id + ", agenteQuimico=" + agenteQuimico + ", codigo=" + codigo + ", nome=" + nome + "]";
	}

}