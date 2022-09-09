package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.enumerators.TipoPessoaEndereco;

public class PessoaEnderecoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private EnderecoTO endereco;
	private TipoPessoaEndereco tipo;
	private Boolean correspondencia;

	private Integer numero;
	private String complemento;
	private String cep;
	private String coordenadas;

	private String observacoes;
	private Pessoa pessoa;

	public PessoaEnderecoTO() {
		super();
	}

	public PessoaEnderecoTO(EnderecoTO endereco, TipoPessoaEndereco tipo, Boolean correspondencia, Integer numero,
			String complemento, String cep, String coordenadas, String observacoes, Pessoa pessoa) {
		super();
		this.endereco = endereco;
		this.tipo = tipo;
		this.correspondencia = correspondencia;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.coordenadas = coordenadas;
		this.observacoes = observacoes;
		this.pessoa = pessoa;
	}

	public PessoaEnderecoTO(Long id, EnderecoTO endereco, TipoPessoaEndereco tipo, Boolean correspondencia,
			Integer numero, String complemento, String cep, String coordenadas, String observacoes, Pessoa pessoa) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.tipo = tipo;
		this.correspondencia = correspondencia;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.coordenadas = coordenadas;
		this.observacoes = observacoes;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnderecoTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoTO endereco) {
		this.endereco = endereco;
	}

	public TipoPessoaEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoaEndereco tipo) {
		this.tipo = tipo;
	}

	public Boolean getCorrespondencia() {
		return correspondencia;
	}

	public void setCorrespondencia(Boolean correspondencia) {
		this.correspondencia = correspondencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "PessoaEnderecoTO [id=" + id + ", endereco=" + endereco + ", tipo=" + tipo + ", correspondencia="
				+ correspondencia + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep
				+ ", coordenadas=" + coordenadas + ", observacoes=" + observacoes + ", pessoa=" + pessoa + "]";
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
		PessoaEnderecoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
}