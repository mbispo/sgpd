package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
public class OperadoraPlanoSaude implements Serializable {

	private static final long serialVersionUID = -6199302998339936228L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "contato_id", nullable = true)
	private Pessoa contato;

	@ManyToOne
	@JoinColumn(name = "endereco_id", nullable = true)
	private Endereco endereco;

	@Column(length = 255)
	private String outrosContatos;

	@OneToMany(mappedBy = "operadora", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<PlanoSaude> planos = new ArrayList<PlanoSaude>();

	public OperadoraPlanoSaude() {
		super();
	}

	public OperadoraPlanoSaude(String nome, Pessoa contato, Endereco endereco, String outrosContatos,
			List<PlanoSaude> planos) {
		super();
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
		this.outrosContatos = outrosContatos;
		this.planos = planos;
	}
	
	public OperadoraPlanoSaude(String nome, Pessoa contato, Endereco endereco, String outrosContatos) {
		super();
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
		this.outrosContatos = outrosContatos;
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

	public Pessoa getContato() {
		return contato;
	}

	public void setContato(Pessoa contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getOutrosContatos() {
		return outrosContatos;
	}

	public void setOutrosContatos(String outrosContatos) {
		this.outrosContatos = outrosContatos;
	}

	public List<PlanoSaude> getPlanos() {
		return planos;
	}

	public void setPlanos(List<PlanoSaude> planos) {
		this.planos = planos;
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
		OperadoraPlanoSaude other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "OperadoraPlanoSaude [id=" + id + ", nome=" + nome + ", contato=" + contato + ", endereco=" + endereco
				+ ", outrosContatos=" + outrosContatos + "]";
	}

}