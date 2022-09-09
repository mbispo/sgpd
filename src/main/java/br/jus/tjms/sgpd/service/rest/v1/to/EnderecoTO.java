package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EnderecoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalidadeTO localidade;
	private LogradouroTO logradouro;
	private BairroTO bairro;
	private Integer numero;
	private String complemento;
	private String cep;
	private String coordenadas;
	private String descricao;

	public EnderecoTO() {
		super();
	}

	public EnderecoTO(Long id, LocalidadeTO localidade, LogradouroTO logradouro, BairroTO bairro, Integer numero,
			String complemento, String cep, String coordenadas, String descricao) {
		super();
		this.id = id;
		this.localidade = localidade;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.coordenadas = coordenadas;
		this.descricao = descricao;
	}

	public EnderecoTO(LocalidadeTO localidade, LogradouroTO logradouro, BairroTO bairro, Integer numero,
			String complemento, String cep, String coordenadas, String descricao) {
		super();
		this.localidade = localidade;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.coordenadas = coordenadas;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalidadeTO getLocalidade() {
		return localidade;
	}

	public void setLocalidade(LocalidadeTO localidade) {
		this.localidade = localidade;
	}

	public LogradouroTO getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(LogradouroTO logradouro) {
		this.logradouro = logradouro;
	}
	
	public void setLogradouroString(String logradouro) {
		this.logradouro = new LogradouroTO(logradouro, null);
	}

	public BairroTO getBairro() {
		return bairro;
	}

	public void setBairro(BairroTO bairro) {
		this.bairro = bairro;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "EnderecoTO [id=" + id + ", localidade=" + localidade + ", logradouro=" + logradouro + ", bairro="
				+ bairro + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + ", coordenadas="
				+ coordenadas + ", descricao=" + descricao + "]";
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
		EnderecoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}