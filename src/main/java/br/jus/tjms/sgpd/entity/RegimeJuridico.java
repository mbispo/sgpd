package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.RegimeJuridicoTO;
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
public class RegimeJuridico implements Serializable {

	private static final long serialVersionUID = -7017347884052456401L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255)
	private String descricao;

	public RegimeJuridico() {
		super();
	}
	
	public RegimeJuridico(Long id) {
		super();
		this.id = id;
	}

	public RegimeJuridico(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public RegimeJuridico(RegimeJuridicoTO regimeJuridicoTO) {
		this.descricao = regimeJuridicoTO.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		RegimeJuridico other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	@Override
	public String toString() {
		return "RegimeJuridico [id=" + id + ", descricao=" + descricao + "]";
	}

	public void alterar(RegimeJuridicoTO regimeJuridicoTO) {
		this.descricao = regimeJuridicoTO.getDescricao();
	}

}