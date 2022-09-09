package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class ConvenioBancario implements Serializable {

	private static final long serialVersionUID = -5966863464074562812L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "agenciaBancaria_id", nullable = false)
	private AgenciaBancaria agenciaBancaria;

	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable = false)
	private Empresa empresa;

	@Column(length = 20)
	private String numero;

	private Boolean ativo;

	public ConvenioBancario() {
		super();
	}

	public ConvenioBancario(Long id, AgenciaBancaria agenciaBancaria, Empresa empresa, String numero, Boolean ativo) {
		super();
		this.id = id;
		this.agenciaBancaria = agenciaBancaria;
		this.empresa = empresa;
		this.numero = numero;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AgenciaBancaria getAgenciaBancaria() {
		return agenciaBancaria;
	}

	public void setAgenciaBancaria(AgenciaBancaria agenciaBancaria) {
		this.agenciaBancaria = agenciaBancaria;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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
		ConvenioBancario other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConvenioBancario [id=" + id + ", agenciaBancaria=" + agenciaBancaria + ", empresa=" + empresa
				+ ", numero=" + numero + ", ativo=" + ativo + "]";
	}

}