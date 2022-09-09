package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.RegiaoTO;
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
@NamedQueries({
	@NamedQuery(name = "regiao.buscarRegiaosPorNome", 
			query = "SELECT r from Regiao r WHERE r.nome = :nome")
})
public class Regiao implements Serializable {

	private static final long serialVersionUID = 7211689316828047998L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "pais_id", nullable = false)
	private Pais pais;

	public Regiao() {
		super();
	}

	public Regiao(Long id, String nome, Pais pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}

	public Regiao(RegiaoTO regiaoTO) {
		this.id = regiaoTO.getId();
		this.nome = regiaoTO.getNome();
		if (regiaoTO.getPais()!=null)
			this.pais = new Pais(regiaoTO.getPais());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
		Regiao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Regiao [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}

	public void alterar(RegiaoTO regiaoTO) {
		this.nome = regiaoTO.getNome();
//		this.pais = regiaoTO.getPais();
	}

	public RegiaoTO toTO() {
		return new RegiaoTO(id,nome,pais.toTO());
	}

}