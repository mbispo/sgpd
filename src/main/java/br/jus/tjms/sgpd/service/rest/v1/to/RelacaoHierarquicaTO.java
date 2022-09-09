package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.enumerators.TipoRelacaoHierarquica;

public class RelacaoHierarquicaTO implements Serializable {

	private static final long serialVersionUID = -776908604374877214L;

	private Long id;
	private Long pessoaId;
	private Long pessoaRelacionadaId;
	private Date inicio;
	private Date fim;
	private TipoRelacaoHierarquica tipo;
	private Pessoa pessoa;
	private Pessoa pessoaRelacionada;
	
	public RelacaoHierarquicaTO() {
		super();
	}

	public RelacaoHierarquicaTO(Long id, Long pessoaId, Long pessoaRelacionadaId, Date inicio, Date fim,
			TipoRelacaoHierarquica tipo) {
		super();
		this.id = id;
		this.pessoaId = pessoaId;
		this.pessoaRelacionadaId = pessoaRelacionadaId;
		this.inicio = inicio;
		this.fim = fim;
		this.tipo = tipo;
	}

	public RelacaoHierarquicaTO(Long pessoaId, Long pessoaRelacionadaId, Date inicio, Date fim,
			TipoRelacaoHierarquica tipo) {
		super();
		this.pessoaId = pessoaId;
		this.pessoaRelacionadaId = pessoaRelacionadaId;
		this.inicio = inicio;
		this.fim = fim;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Long getPessoaRelacionadaId() {
		return pessoaRelacionadaId;
	}

	public void setPessoaRelacionadaId(Long pessoaRelacionadaId) {
		this.pessoaRelacionadaId = pessoaRelacionadaId;
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

	public TipoRelacaoHierarquica getTipo() {
		return tipo;
	}

	public void setTipo(TipoRelacaoHierarquica tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoaRelacionada() {
		return pessoaRelacionada;
	}

	public void setPessoaRelacionada(Pessoa pessoaRelacionada) {
		this.pessoaRelacionada = pessoaRelacionada;
	}

	@Override
	public String toString() {
		return "RelacaoHierarquicaTO [id=" + id + ", pessoaId=" + pessoaId + ", pessoaRelacionadaId="
				+ pessoaRelacionadaId + ", inicio=" + inicio + ", fim=" + fim + ", tipo=" + tipo + "]";
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
		RelacaoHierarquicaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}