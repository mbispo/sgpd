package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.AgenciaBancariaTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "agenciaBancaria.buscarPorId", 
			query = "SELECT a FROM AgenciaBancaria a WHERE a.id = :id" ),
	@NamedQuery(name = "agenciaBancaria.buscarPorBanco", 
			query = "SELECT a FROM AgenciaBancaria a WHERE a.banco.id = :bancoId" ),
})
public class AgenciaBancaria implements Serializable {

	private static final long serialVersionUID = -8267183421672132685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "banco_id", nullable = false)
	private Banco banco;

	@Column(length = 10)
	private String codigo;

	@Column(length = 10)
	private String digitoVerificador;

	@Column(length = 20)
	private String cnpj;

	@Column(length = 200)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public AgenciaBancaria() {
		super();
	}
	
	public AgenciaBancaria(Long id) {
		super();
		this.id = id;
	}

	public AgenciaBancaria(Long id, Banco banco, String codigo, String digitoVerificador, String cnpj, String nome,
			Endereco endereco) {
		super();
		this.id = id;
		this.banco = banco;
		this.codigo = codigo;
		this.digitoVerificador = digitoVerificador;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	public AgenciaBancaria(AgenciaBancariaTO agenciaBancariaTO) {
		
		this.id = agenciaBancariaTO.getId();
		this.codigo = agenciaBancariaTO.getCodigo();
		this.digitoVerificador = agenciaBancariaTO.getDigitoVerificador();
		this.cnpj = agenciaBancariaTO.getCnpj();
		this.nome = agenciaBancariaTO.getNome();
		this.banco = new Banco(agenciaBancariaTO.getBancoId());
		
		//FIXME this.endereco = agenciaBancariaTO.getEndereco();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgenciaBancaria that = (AgenciaBancaria) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(banco, that.banco) &&
                Objects.equals(codigo, that.codigo) &&
                Objects.equals(digitoVerificador, that.digitoVerificador) &&
                Objects.equals(cnpj, that.cnpj) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(endereco, that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, banco, codigo, digitoVerificador, cnpj, nome, endereco);
    }

    @Override
	public String toString() {
		return "AgenciaBancaria [id=" + id + ", banco=" + banco + ", codigo=" + codigo + ", digitoVerificador="
				+ digitoVerificador + ", cnpj=" + cnpj + ", nome=" + nome + ", endereco=" + endereco + "]";
	}

	public void alterar(AgenciaBancariaTO agenciaBancariaTO) {
		//FIXME this.banco = agenciaBancariaTO.getBanco();
		this.codigo = agenciaBancariaTO.getCodigo();
		this.digitoVerificador = agenciaBancariaTO.getDigitoVerificador();
		this.cnpj = agenciaBancariaTO.getCnpj();
		this.nome = agenciaBancariaTO.getNome();
		//FIXME this.endereco = agenciaBancariaTO.getEndereco();
	}

	public AgenciaBancariaTO toTO() {		
		return new AgenciaBancariaTO(id, banco!=null?banco.toTO():null, banco!=null?banco.getId():null, codigo, digitoVerificador, cnpj, nome, endereco!=null?endereco.toTO():null);
	}

}