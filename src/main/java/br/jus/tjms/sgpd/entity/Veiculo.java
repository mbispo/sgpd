package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.VeiculoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:07
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "veiculo.buscarVeiculosPorPessoa", 
			query = "SELECT v from Veiculo v WHERE v.pessoa.id = :idPessoa")
})
public class Veiculo implements Serializable {

	private static final long serialVersionUID = -8965484447809238476L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String marca;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@Column(length = 200)
	private String cor;

	@Column(length = 200)
	private String modelo;

	@Column(length = 200)
	private String placa;

	private Boolean usaEstacionamento;

	@Column(length = 200)
	private String numeroAdesivo;

	public Veiculo() {
		super();
	}

	public Veiculo(Long id, String marca, Pessoa pessoa, String cor, String modelo, String placa,
			Boolean usaEstacionamento, String numeroAdesivo) {
		super();
		this.id = id;
		this.marca = marca;
		this.pessoa = pessoa;
		this.cor = cor;
		this.modelo = modelo;
		this.placa = placa;
		this.usaEstacionamento = usaEstacionamento;
		this.numeroAdesivo = numeroAdesivo;
	}

	public Veiculo(VeiculoTO veiculoTO) {
		super();
		this.marca = veiculoTO.getMarca();
		this.pessoa = veiculoTO.getPessoa();
		this.cor = veiculoTO.getCor();
		this.modelo = veiculoTO.getModelo();
		this.placa = veiculoTO.getPlaca();
		this.usaEstacionamento = veiculoTO.getUsaEstacionamento();
		this.numeroAdesivo = veiculoTO.getNumeroAdesivo();
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		Veiculo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", marca=" + marca + ", pessoa=" + pessoa + ", cor=" + cor + ", modelo=" + modelo
				+ ", placa=" + placa + ", usaEstacionamento=" + usaEstacionamento + ", numeroAdesivo=" + numeroAdesivo
				+ "]";
	}

	public void alterar(VeiculoTO veiculoTO) {
		this.marca = veiculoTO.getMarca();
		this.pessoa = veiculoTO.getPessoa();
		this.cor = veiculoTO.getCor();
		this.modelo = veiculoTO.getModelo();
		this.placa = veiculoTO.getPlaca();
		this.usaEstacionamento = veiculoTO.getUsaEstacionamento();
		this.numeroAdesivo = veiculoTO.getNumeroAdesivo();
	}

}