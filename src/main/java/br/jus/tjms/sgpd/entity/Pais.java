package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.PaisTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "pais.buscarPaisesPorNome", 
			query = "SELECT p from Pais p WHERE p.nome = :nome")
})
public class Pais implements Serializable {

	private static final long serialVersionUID = -8348997794030768840L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	@Column(length = 20)
	private String sigla;

	@Column(length = 200)
	private String nacionalidade;

	public Pais() {
		super();
	}

	public Pais(Long id, String nome, String sigla, String nacionalidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.nacionalidade = nacionalidade;
	}
	
	public Pais(PaisTO paisTO) {
		this.id = paisTO.getId();
		this.nome = paisTO.getNome();
		this.sigla = paisTO.getSigla();
		this.nacionalidade = paisTO.getNacionalidade();
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
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
		Pais other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", nacionalidade=" + nacionalidade + "]";
	}

	public void alterar(PaisTO paisTO) {
		this.nome = paisTO.getNome();
		this.sigla =  paisTO.getSigla();
		this.nacionalidade =  paisTO.getNacionalidade();
	}

	public PaisTO toTO() {
		return new PaisTO(id,nome,sigla,nacionalidade);
	}

}