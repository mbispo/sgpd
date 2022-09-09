package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class OperadoraPlanoSaudeTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Long pessoaContatoId;
	private EnderecoTO endereco;
	private String outrosContatos;

	public OperadoraPlanoSaudeTO() {
		super();
	}

	public OperadoraPlanoSaudeTO(Long id, String nome, Long pessoaContatoId, EnderecoTO endereco,
			String outrosContatos) {
		super();
		this.id = id;
		this.nome = nome;
		this.pessoaContatoId = pessoaContatoId;
		this.endereco = endereco;
		this.outrosContatos = outrosContatos;
	}

	public OperadoraPlanoSaudeTO(String nome, Long pessoaContatoId, EnderecoTO endereco, String outrosContatos) {
		super();
		this.nome = nome;
		this.pessoaContatoId = pessoaContatoId;
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

	public Long getPessoaContatoId() {
		return pessoaContatoId;
	}

	public void setPessoaContatoId(Long pessoaContatoId) {
		this.pessoaContatoId = pessoaContatoId;
	}

	public EnderecoTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoTO endereco) {
		this.endereco = endereco;
	}

	public String getOutrosContatos() {
		return outrosContatos;
	}

	public void setOutrosContatos(String outrosContatos) {
		this.outrosContatos = outrosContatos;
	}

	@Override
	public String toString() {
		return "OperadoraPlanoSaudeTO [id=" + id + ", nome=" + nome + ", pessoaContatoId=" + pessoaContatoId
				+ ", endereco=" + endereco + ", outrosContatos=" + outrosContatos + "]";
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
		OperadoraPlanoSaudeTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}