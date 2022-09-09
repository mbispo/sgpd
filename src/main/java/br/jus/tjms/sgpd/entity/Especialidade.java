package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.EspecialidadeTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:57
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "especialidade.buscarEspecialidadesPorNome", 
			query = "SELECT e from Especialidade e WHERE e.descricao = :nome")
})
public class Especialidade implements Serializable {

	private static final long serialVersionUID = -1603167100643618317L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	public Especialidade() {
		super();
	}
	
	public Especialidade(Long id) {
		super();
		this.id = id;
	}

	public Especialidade(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Especialidade(EspecialidadeTO especialidadeTO) {
		this.id = especialidadeTO.getId();
		this.descricao = especialidadeTO.getDescricao();
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
		Especialidade other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Especialidade [id=" + id + ", descricao=" + descricao + "]";
	}

	public void alterar(EspecialidadeTO especialidadeTO) {
		this.descricao = especialidadeTO.getDescricao();
	}

}