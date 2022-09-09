package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.BairroTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class Bairro implements Serializable {

	private static final long serialVersionUID = -6867718956128520016L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	/*@ManyToOne
	@JoinColumn(name = "localidade_id", nullable = false)
	private Localidade localidade;*/

	public Bairro() {
		super();
	}

	public Bairro(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Bairro(BairroTO bairroTO) {
		super();
		this.id = bairroTO.getId();
		this.nome = bairroTO.getNome();
		
		/*if (bairroTO.getLocalidade()!=null)
			this.localidade = new Localidade(bairroTO.getLocalidade());*/
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

/*	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}*/

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
		Bairro other = (Bairro) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Bairro [id=" + id + ", nome=" + nome + "]";
	}

	public BairroTO toTO() {
		return new BairroTO(id, nome);
	}

}