package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.BancoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "banco.buscarPorNome", 
			query = "SELECT b FROM Banco b WHERE b.nome = :nome" ),
})
public class Banco implements Serializable {

	private static final long serialVersionUID = 9063348431393603850L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer codigo;

	@Column(length = 200)
	private String nome;

	@Column(length = 20)
	private String sigla;

	public Banco() {
		super();
	}
	
	public Banco(Long id) {
		super();
		this.id = id;
	}

	public Banco(Long id, Integer codigo, String nome, String sigla) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Banco(BancoTO bancoTO) {
		
		this.id = bancoTO.getId();
		this.codigo = bancoTO.getCodigo();
		this.nome = bancoTO.getNome();
		this.sigla = bancoTO.getSigla();
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
		Banco other = (Banco) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Banco [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", sigla=" + sigla + "]";
	}

	public void alterar(BancoTO bancoTO) {
		this.codigo = bancoTO.getCodigo();
		this.nome = bancoTO.getNome();
		this.sigla = bancoTO.getSigla();	
	}

	public BancoTO toTO() {
		return new BancoTO(id, codigo, nome, sigla);
	}

}