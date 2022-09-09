package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoPessoaEndereco;
import br.jus.tjms.sgpd.service.rest.v1.to.PessoaEnderecoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Auditavel
@Cacheable
@NamedQueries({
		@NamedQuery(name = "pessoaEndereco.buscarEnderecosPorPessoa", query = "SELECT pe.endereco from PessoaEndereco pe WHERE pe.pessoa.id = :pessoaId") })
public class PessoaEndereco implements Serializable {

	private static final long serialVersionUID = -8221540092790312807L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@Enumerated(EnumType.ORDINAL)
	private TipoPessoaEndereco tipo;

	private Boolean correspondencia;

	private Integer numero;

	@Column(length = 60)
	private String complemento;

	@Column(length = 10)
	private String cep;

	@Column(length = 50)
	private String coordenadas;

	@Column(length = 500)
	private String observacoes;

	public PessoaEndereco() {
		super();
	}

	public PessoaEndereco(Endereco endereco, Pessoa pessoa, TipoPessoaEndereco tipo, Boolean correspondencia,
			Integer numero, String complemento, String cep, String coordenadas, String observacoes) {
		super();
		this.endereco = endereco;
		this.pessoa = pessoa;
		this.tipo = tipo;
		this.correspondencia = correspondencia;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.coordenadas = coordenadas;
		this.observacoes = observacoes;
	}

	public PessoaEndereco(Long id, Endereco endereco, Pessoa pessoa, TipoPessoaEndereco tipo, Boolean correspondencia,
			Integer numero, String complemento, String cep, String coordenadas, String observacoes) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.pessoa = pessoa;
		this.tipo = tipo;
		this.correspondencia = correspondencia;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.coordenadas = coordenadas;
		this.observacoes = observacoes;
	}

	public PessoaEndereco(PessoaEnderecoTO pessoaEnderecoTO) {
		this.id = pessoaEnderecoTO.getId();
		
		if (pessoaEnderecoTO.getEndereco()!=null)
			this.endereco = new Endereco(pessoaEnderecoTO.getEndereco());
		
		this.pessoa = pessoaEnderecoTO.getPessoa();
		this.tipo = pessoaEnderecoTO.getTipo();
		this.correspondencia = pessoaEnderecoTO.getCorrespondencia();

		this.numero = pessoaEnderecoTO.getNumero();
		this.complemento = pessoaEnderecoTO.getComplemento();
		this.cep = pessoaEnderecoTO.getCep();
		this.coordenadas = pessoaEnderecoTO.getCoordenadas();

		this.observacoes = pessoaEnderecoTO.getObservacoes();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		PessoaEndereco other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PessoaEndereco [id=" + id + ", endereco=" + endereco + ", pessoa=" + pessoa + ", tipo=" + tipo
				+ ", correspondencia=" + correspondencia + ", numero=" + numero + ", complemento=" + complemento
				+ ", cep=" + cep + ", coordenadas=" + coordenadas + ", observacoes=" + observacoes + "]";
	}

	public void alterar(PessoaEnderecoTO pessoaEnderecoTO) {
		// FIXME this.endereco = pessoaEnderecoTO.getEndereco();
		this.pessoa = pessoaEnderecoTO.getPessoa();
		this.tipo = pessoaEnderecoTO.getTipo();
		this.correspondencia = pessoaEnderecoTO.getCorrespondencia();
		this.observacoes = pessoaEnderecoTO.getObservacoes();
	}

}