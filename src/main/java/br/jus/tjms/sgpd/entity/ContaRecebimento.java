package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoContaRecebimento;
import br.jus.tjms.sgpd.service.rest.v1.to.ContaRecebimentoTO;
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
	@NamedQuery(name = "contaRecebimento.buscarContasRecebimentoPorPessoa", 
			query = "SELECT c from ContaRecebimento c WHERE c.pessoa.id = :idPessoa")
})
public class ContaRecebimento implements Serializable {

	private static final long serialVersionUID = -1534066372777328416L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "contaCorrente_id", nullable = false)
	private ContaCorrente contaCorrente;

	@Enumerated(EnumType.ORDINAL)
	private TipoContaRecebimento tipo;

	private Boolean ativa;

	public ContaRecebimento() {
		super();
	}
	
	public ContaRecebimento(Pessoa pessoa, ContaCorrente contaCorrente, TipoContaRecebimento tipo, Boolean ativa) {
		super();
		this.pessoa = pessoa;
		this.contaCorrente = contaCorrente;
		this.tipo = tipo;
		this.ativa = ativa;
	}

	public ContaRecebimento(ContaRecebimentoTO contaRecebimentoTO) {
		super();
		if (contaRecebimentoTO.getId()!=null) {
			this.id = contaRecebimentoTO.getId();
		}
		this.pessoa = new Pessoa(contaRecebimentoTO.getPessoaId());
		this.contaCorrente = new ContaCorrente(contaRecebimentoTO.getContaCorrenteId());
		this.tipo = contaRecebimentoTO.getTipo();
		this.ativa = contaRecebimentoTO.getAtiva();
	}

	public ContaRecebimentoTO toTO() {
		ContaRecebimentoTO to = new ContaRecebimentoTO(id, contaCorrente.getId(), pessoa.getId(), tipo, ativa);
		to.setContaCorrente(contaCorrente.toTO());
		
		return to;
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

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public TipoContaRecebimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoContaRecebimento tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
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
		
		ContaRecebimento other = (ContaRecebimento) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ContaRecebimento [id=" + id + ", pessoa=" + pessoa + ", contaCorrente=" + contaCorrente + ", tipo="
				+ tipo + ", ativa=" + ativa + "]";
	}

	public void alterar(ContaRecebimentoTO contaRecebimentoTO) {
		this.pessoa = new Pessoa(contaRecebimentoTO.getPessoaId());
		this.contaCorrente = new ContaCorrente(contaRecebimentoTO.getContaCorrenteId());
		this.tipo = contaRecebimentoTO.getTipo();
		this.ativa = contaRecebimentoTO.getAtiva();
	}

}