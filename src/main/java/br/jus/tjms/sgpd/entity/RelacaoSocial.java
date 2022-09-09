package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoRelacaoSocial;
import br.jus.tjms.sgpd.service.rest.v1.to.RelacaoSocialTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "relacaoSocial.buscarRelacoesSociaisPorPessoa", 
			query = "SELECT r from RelacaoSocial r WHERE r.pessoa.id = :idPessoa")
})
public class RelacaoSocial implements Serializable {

	private static final long serialVersionUID = 5931780676112939744L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "relacionada_id", nullable = false)
	private Pessoa relacionada;

	private Date inicio;
	private Date fim;

	@Enumerated(EnumType.ORDINAL)
	private TipoRelacaoSocial tipo;

	public RelacaoSocial() {
		super();
	}

	public RelacaoSocial(Long id, Pessoa pessoa, Pessoa relacionada, Date inicio, Date fim, TipoRelacaoSocial tipo) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.relacionada = relacionada;
		this.inicio = inicio;
		this.fim = fim;
		this.tipo = tipo;
	}

	public RelacaoSocial(RelacaoSocialTO relacaoSocialTO) {
		super();
		this.pessoa = relacaoSocialTO.getPessoa();
		this.relacionada = relacaoSocialTO.getPessoaRelacionada();
		this.inicio = relacaoSocialTO.getInicio();
		this.fim = relacaoSocialTO.getFim();
		this.tipo = relacaoSocialTO.getTipo();
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

	public Pessoa getRelacionada() {
		return relacionada;
	}

	public void setRelacionada(Pessoa relacionada) {
		this.relacionada = relacionada;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public TipoRelacaoSocial getTipo() {
		return tipo;
	}

	public void setTipo(TipoRelacaoSocial tipo) {
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
		RelacaoSocial other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RelacaoSocial [id=" + id + ", pessoa=" + pessoa + ", relacionada=" + relacionada + ", inicio=" + inicio
				+ ", fim=" + fim + ", tipo=" + tipo + "]";
	}

	public void alterar(RelacaoSocialTO relacaoSocialTO) {
		this.pessoa = relacaoSocialTO.getPessoa();
		this.relacionada = relacaoSocialTO.getPessoaRelacionada();
		this.inicio = relacaoSocialTO.getInicio();
		this.fim = relacaoSocialTO.getFim();
		this.tipo = relacaoSocialTO.getTipo();
	}

}