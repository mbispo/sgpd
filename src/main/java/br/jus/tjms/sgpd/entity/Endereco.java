package br.jus.tjms.sgpd.entity;


import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.EnderecoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:57
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "endereco.buscarEnderecosPorDescricao", 
			query = "SELECT e from Endereco e WHERE e.descricao = :descricao")
})
public class Endereco implements Serializable {

	private static final long serialVersionUID = -5699533640933713701L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "localidade_id", nullable = true)
	private Localidade localidade;

	@ManyToOne
	@JoinColumn(name = "logradouro_id", nullable = false)
	private Logradouro logradouro;

	@ManyToOne
	@JoinColumn(name = "bairro_id", nullable = false)
	private Bairro bairro;

	private Integer numero;

	@Column(length = 60)
	private String complemento;

	@Column(length = 10)
	private String cep;

	@Column(length = 50)
	private String coordenadas;

	@Column(length = 60)
	private String descricao;

	public Endereco() {
		super();
	}

	public Endereco(Long id, Localidade localidade, Logradouro logradouro, Bairro bairro, Integer numero,
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

	public Endereco(EnderecoTO enderecoTO) {
		this.id = enderecoTO.getId();
		
		if (enderecoTO.getLocalidade()!=null)
			this.localidade = new Localidade(enderecoTO.getLocalidade());
		
		if (enderecoTO.getLogradouro()!=null)
			this.logradouro = new Logradouro(enderecoTO.getLogradouro());
		
		if (enderecoTO.getBairro()!=null)
			this.bairro = new Bairro(enderecoTO.getBairro());
		
		this.numero = enderecoTO.getNumero();
		this.complemento = enderecoTO.getComplemento();
		this.cep = enderecoTO.getCep();
		this.coordenadas = enderecoTO.getCoordenadas();
		this.descricao = enderecoTO.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
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
		Endereco other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", localidade=" + localidade + ", logradouro=" + logradouro + ", bairro="
				+ bairro + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + ", coordenadas="
				+ coordenadas + ", descricao=" + descricao + "]";
	}

	public void alterar(EnderecoTO enderecoTO) {
		//FIXME	this.localidade = enderecoTO.getLocalidade();
		//FIXME	this.logradouro = enderecoTO.getLogradouro();
		//FIXME	this.bairro = enderecoTO.getBairro();
		this.numero = enderecoTO.getNumero();
		this.complemento = enderecoTO.getComplemento();
		this.cep = enderecoTO.getCep();
		this.coordenadas = enderecoTO.getCoordenadas();
		this.descricao = enderecoTO.getDescricao();
	}

	public EnderecoTO toTO() {
		return new EnderecoTO(id, localidade.toTO(), logradouro.toTO(), bairro.toTO(), numero, 
				complemento, cep, coordenadas, descricao);
	}

}