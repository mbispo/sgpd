package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.CertificacaoTO;
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
	@NamedQuery(name = "certificacao.buscarPorNome", 
			query = "SELECT c FROM Certificacao c WHERE c.nome = :nome"),
	@NamedQuery(name = "certificacao.buscarPorEntidadeCertificadora", 
			query = "SELECT c FROM Certificacao c WHERE c.entidade.id = :entidadeCertificadoraId")
})
public class Certificacao implements Serializable {

	private static final long serialVersionUID = -1453987733693852466L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "entidadeCertificadora_id", nullable = false)
	private EntidadeCertificadora entidade;

	@Column(length = 200)
	private String nome;

	public Certificacao() {
		super();
	}

	public Certificacao(Long id, EntidadeCertificadora entidade, String nome) {
		super();
		this.id = id;
		this.entidade = entidade;
		this.nome = nome;
	}

	public Certificacao(CertificacaoTO certificacaoTO) {
		//FIXME this.entidade = certificacaoTO.getEntidadeCertificadoraId();
		this.nome = certificacaoTO.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EntidadeCertificadora getEntidade() {
		return entidade;
	}

	public void setEntidade(EntidadeCertificadora entidade) {
		this.entidade = entidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Certificacao other = (Certificacao) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Certificacao [id=" + id + ", entidade=" + entidade + ", nome=" + nome + "]";
	}

	public void alterar(CertificacaoTO certificacaoTO) {
		//FIXME this.entidade = certificacaoTO.getEntidadeCertificadoraId();
		this.nome = certificacaoTO.getNome();
	}

}