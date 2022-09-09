package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AgenciaBancariaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private BancoTO banco;
	private Long bancoId;
	private String codigo;
	private String digitoVerificador;
	private String cnpj;
	private String nome;
	private EnderecoTO endereco;
	
	public AgenciaBancariaTO() {
		super();
	}
	
	public AgenciaBancariaTO(Long id) {
		super();
		this.id = id;
	}

	public AgenciaBancariaTO(Long id, BancoTO banco, Long bancoId, String codigo, String digitoVerificador, String cnpj,
			String nome, EnderecoTO endereco) {
		super();
		this.id = id;
		this.banco = banco;
		this.bancoId = bancoId;
		this.codigo = codigo;
		this.digitoVerificador = digitoVerificador;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	public AgenciaBancariaTO(Long bancoId, String codigo, String digitoVerificador, String cnpj, String nome,
			EnderecoTO endereco) {
		super();
		this.bancoId = bancoId;
		this.codigo = codigo;
		this.digitoVerificador = digitoVerificador;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BancoTO getBanco() {
		return banco;
	}

	public void setBanco(BancoTO banco) {
		this.banco = banco;
	}

	public Long getBancoId() {
		return bancoId;
	}

	public void setBancoId(Long bancoId) {
		this.bancoId = bancoId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(String digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EnderecoTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoTO endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "AgenciaBancariaTO [id=" + id + ", banco=" + banco + ", codigo=" + codigo + ", digitoVerificador="
				+ digitoVerificador + ", cnpj=" + cnpj + ", nome=" + nome + ", endereco=" + endereco + "]";
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
		AgenciaBancariaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}