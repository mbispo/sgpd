package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoContaRecebimento;

public class ContaRecebimentoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long contaCorrenteId;
	private ContaCorrenteTO contaCorrente;
	private Long pessoaId;
	private TipoContaRecebimento tipo;
	private Boolean ativa;


	public ContaRecebimentoTO() {
		super();
	}

	public ContaRecebimentoTO(Long id, Long contaCorrenteId, Long pessoaId, TipoContaRecebimento tipo, Boolean ativa) {
		super();
		this.id = id;
		this.contaCorrenteId = contaCorrenteId;
		this.pessoaId = pessoaId;
		this.tipo = tipo;
		this.ativa = ativa;
	}
	
	public ContaRecebimentoTO(Long contaCorrenteId, Long pessoaId, TipoContaRecebimento tipo, Boolean ativa) {
		super();
		this.contaCorrenteId = contaCorrenteId;
		this.pessoaId = pessoaId;
		this.tipo = tipo;
		this.ativa = ativa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContaCorrenteId() {
		return contaCorrenteId;
	}

	public void setContaCorrenteId(Long contaCorrenteId) {
		this.contaCorrenteId = contaCorrenteId;
	}

	public ContaCorrenteTO getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrenteTO contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
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
	public String toString() {
		return "ContaRecebimentoTO [id=" + id + ", contaCorrenteId=" + contaCorrenteId + ", contaCorrente="
				+ contaCorrente + ", pessoaId=" + pessoaId + ", tipo=" + tipo + ", ativa=" + ativa + "]";
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
		ContaRecebimentoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}