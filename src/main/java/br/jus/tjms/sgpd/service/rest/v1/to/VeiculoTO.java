package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.entity.Pessoa;

public class VeiculoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String marca;
	private Long pessoaId;
	private String cor;
	private String modelo;
	private String placa;
	private Boolean usaEstacionamento;
	private String numeroAdesivo;
	private Pessoa pessoa;

	public VeiculoTO() {
		super();
	}

	public VeiculoTO(Long id, String marca, Long pessoaId, String cor, String modelo, String placa,
			Boolean usaEstacionamento, String numeroAdesivo) {
		super();
		this.id = id;
		this.marca = marca;
		this.pessoaId = pessoaId;
		this.cor = cor;
		this.modelo = modelo;
		this.placa = placa;
		this.usaEstacionamento = usaEstacionamento;
		this.numeroAdesivo = numeroAdesivo;
	}

	public VeiculoTO(String marca, Long pessoaId, String cor, String modelo, String placa, Boolean usaEstacionamento,
			String numeroAdesivo) {
		super();
		this.marca = marca;
		this.pessoaId = pessoaId;
		this.cor = cor;
		this.modelo = modelo;
		this.placa = placa;
		this.usaEstacionamento = usaEstacionamento;
		this.numeroAdesivo = numeroAdesivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Boolean getUsaEstacionamento() {
		return usaEstacionamento;
	}

	public void setUsaEstacionamento(Boolean usaEstacionamento) {
		this.usaEstacionamento = usaEstacionamento;
	}

	public String getNumeroAdesivo() {
		return numeroAdesivo;
	}

	public void setNumeroAdesivo(String numeroAdesivo) {
		this.numeroAdesivo = numeroAdesivo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "VeiculoTO [id=" + id + ", marca=" + marca + ", pessoaId=" + pessoaId + ", cor=" + cor + ", modelo="
				+ modelo + ", placa=" + placa + ", usaEstacionamento=" + usaEstacionamento + ", numeroAdesivo="
				+ numeroAdesivo + "]";
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
		VeiculoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}