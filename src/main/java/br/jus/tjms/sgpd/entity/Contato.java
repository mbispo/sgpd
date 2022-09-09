package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.MidiaContato;
import br.jus.tjms.sgpd.service.rest.v1.to.ContatoTO;
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
	@NamedQuery(name = "contato.buscarContatosPorPessoa", 
			query = "SELECT c from Contato c WHERE c.pessoa.id = :idPessoa")
})
public class Contato implements Serializable {

	private static final long serialVersionUID = -4929270004774845571L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@Enumerated(EnumType.ORDINAL)
	private MidiaContato midia;

	@Column(length = 200)
	private String descricao;

	@Column(length = 200)
	private String contato;

	public Contato() {
		super();
	}

	public Contato(Long id, Pessoa pessoa, MidiaContato midia, String descricao, String contato) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.midia = midia;
		this.descricao = descricao;
		this.contato = contato;
	}

	public Contato(ContatoTO contatoTO) {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public MidiaContato getMidia() {
		return midia;
	}

	public void setMidia(MidiaContato midia) {
		this.midia = midia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
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
		Contato other = (Contato) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", pessoa=" + pessoa + ", midia=" + midia + ", descricao=" + descricao
				+ ", contato=" + contato + "]";
	}

	public void alterar(ContatoTO contatoTO) {
		this.pessoa = contatoTO.getPessoa();
		this.midia = contatoTO.getMidia();
		this.descricao = contatoTO.getDescricao();
		this.contato = contatoTO.getContato();
	}

}