package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.EstadoTO;
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
	@NamedQuery(name = "estado.buscarEstadosPorNome", 
			query = "SELECT e from Estado e WHERE e.nome = :nome")
})
public class Estado implements Serializable {

	private static final long serialVersionUID = -4202803224381582295L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	@Column(length = 10)
	private String sigla;

	@ManyToOne
	@JoinColumn(name = "pais_id", nullable = false)
	private Pais pais;

	public Estado() {
		super();
	}

	public Estado(Long id, String nome, String sigla, Pais pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.pais = pais;
	}

	public Estado(EstadoTO estadoTO) {
		this.id = estadoTO.getId();
		this.nome = estadoTO.getNome();
		this.sigla = estadoTO.getSigla();
		
		if (estadoTO.getPais()!=null)
			this.pais = new Pais(estadoTO.getPais());
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
		Estado other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", pais=" + pais + "]";
	}

	public void alterar(EstadoTO estadoTO) {
		this.nome = estadoTO.getNome();
		this.sigla = estadoTO.getSigla();
		//FIXME this.pais = estadoTO.getPais();
	}

	public EstadoTO toTO() {
		return new EstadoTO(id,nome,sigla,pais.toTO());
	}

}