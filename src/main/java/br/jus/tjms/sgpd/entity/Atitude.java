package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.AtitudeTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "atitude.buscarPorNome", 
			query = "SELECT a FROM Atitude a WHERE a.descricao = :nome" ),
})
public class Atitude implements Serializable {

	private static final long serialVersionUID = -745218366753612624L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	public Atitude() {
		super();
	}

	public Atitude(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Atitude(AtitudeTO atitudeTO) {
		this.descricao = atitudeTO.getDescricao();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atitude atitude = (Atitude) o;
        return Objects.equals(id, atitude.id) &&
                Objects.equals(descricao, atitude.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }

    @Override
	public String toString() {
		return "Atitude [id=" + id + ", descricao=" + descricao + "]";
	}

	public void alterar(AtitudeTO atitudeTO) {
		this.descricao = atitudeTO.getDescricao();
	}

}