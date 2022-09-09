package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
public class BancoHora implements Serializable {

	private static final long serialVersionUID = 5712706657971482174L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	private Integer ano;
	private Integer mes;
	private Date saldo;

	public BancoHora() {
		super();
	}

	public BancoHora(Long id, Funcionario funcionario, Integer ano,
			Integer mes, Date saldo) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.ano = ano;
		this.mes = mes;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Date getSaldo() {
		return saldo;
	}

	public void setSaldo(Date saldo) {
		this.saldo = saldo;
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
		BancoHora other = (BancoHora) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "BancoHora [id=" + id + ", funcionario=" + funcionario
				+ ", ano=" + ano + ", mes=" + mes + ", saldo=" + saldo + "]";
	}

}