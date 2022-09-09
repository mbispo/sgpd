package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.LogradouroTipo;
import br.jus.tjms.sgpd.service.rest.v1.to.LogradouroTO;
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
public class Logradouro implements Serializable {

	private static final long serialVersionUID = 6924535910573849477L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	@Enumerated(EnumType.ORDINAL)
	private LogradouroTipo tipo;

	public Logradouro() {
		super();
	}

	public Logradouro(Long id, String nome, LogradouroTipo tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Logradouro(LogradouroTO logradouroTO) {
		super();
		this.id = logradouroTO.getId();
		this.nome = logradouroTO.getNome();
		this.tipo = logradouroTO.getTipo();
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

	public LogradouroTipo getTipo() {
		return tipo;
	}

	public void setTipo(LogradouroTipo tipo) {
		this.tipo = tipo;
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
		Logradouro other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Logradouro [id=" + id + ", nome=" + nome + ", tipo=" + tipo + "]";
	}

	public LogradouroTO toTO() {
		return new LogradouroTO(id, nome, tipo);
	}

}