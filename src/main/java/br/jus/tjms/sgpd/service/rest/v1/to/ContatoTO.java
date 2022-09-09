package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.enumerators.MidiaContato;

public class ContatoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long pessoaId;
	private Long pessoaRelacionadaId;
	private MidiaContato midia;
	private String descricao;
	private String contato;
	private Pessoa pessoa;
	private Pessoa pessoaRelacionada;

	public ContatoTO() {
		super();
	}

	public ContatoTO(Long id, MidiaContato midia, String descricao, String contato) {
		super();
		this.id = id;
		this.midia = midia;
		this.descricao = descricao;
		this.contato = contato;
	}

	public ContatoTO(MidiaContato midia, String descricao, String contato) {
		super();
		this.midia = midia;
		this.descricao = descricao;
		this.contato = contato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "ContatoTO [id=" + id + ", midia=" + midia + ", descricao=" + descricao + ", contato=" + contato + "]";
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
		ContatoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}