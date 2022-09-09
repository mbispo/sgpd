package br.jus.tjms.esocial.entity;

import java.io.Serializable;
import java.util.Date;

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
 * @created 11-dez-2015 18:15:43
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial")
public class PaisESocial implements Serializable {

	private static final long serialVersionUID = -3735465586468900533L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer codigo;
	
	private Date dataCriacao;
	
	@Column(length = 255)
	private String nome;
	
	private Date dataExtincao;

	public PaisESocial(){
		super();
	}

	public PaisESocial(Long id, Integer codigo, Date dataCriacao, String nome, Date dataExtincao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.dataCriacao = dataCriacao;
		this.nome = nome;
		this.dataExtincao = dataExtincao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataExtincao() {
		return dataExtincao;
	}

	public void setDataExtincao(Date dataExtincao) {
		this.dataExtincao = dataExtincao;
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
		PaisESocial other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PaisESocial [id=" + id + ", codigo=" + codigo + ", dataCriacao=" + dataCriacao + ", nome=" + nome
				+ ", dataExtincao=" + dataExtincao + "]";
	}

}