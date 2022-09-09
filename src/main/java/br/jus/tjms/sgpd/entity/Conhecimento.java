package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.ConhecimentoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "conhecimento.buscarConhecimentosPorNome", 
			query = "SELECT c from Conhecimento c WHERE c.descricao = :nome")
})
public class Conhecimento implements Serializable {

	private static final long serialVersionUID = 6274882549586572747L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	public Conhecimento() {
		super();
	}

	public Conhecimento(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Conhecimento(ConhecimentoTO conhecimentoTO) {
		this.descricao = conhecimentoTO.getDescricao();
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
		Conhecimento other = (Conhecimento) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Conhecimento [id=" + id + ", descricao=" + descricao + "]";
	}

	public void alterar(ConhecimentoTO conhecimentoTO) {
		this.descricao = conhecimentoTO.getDescricao();
	}

}