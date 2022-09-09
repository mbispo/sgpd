package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.OcupacaoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "ocupacao.buscarPorNome", 
			query = "SELECT o from Ocupacao o WHERE o.descricao = :nome")
})
public class Ocupacao implements Serializable {

	private static final long serialVersionUID = 8910319528089713587L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	private String descricao;

	public Ocupacao() {
		super();
	}

	public Ocupacao(Long id) {
		super();
		this.id = id;
	}

	public Ocupacao(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Ocupacao(OcupacaoTO ocupacaoTO) {
		this.id = ocupacaoTO.getId();
		this.descricao = ocupacaoTO.getDescricao();
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
		Ocupacao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Ocupacao [id=" + id + ", descricao=" + descricao + "]";
	}

	public void alterar(OcupacaoTO ocupacaoTO) {
		this.descricao = ocupacaoTO.getDescricao();
	}

}