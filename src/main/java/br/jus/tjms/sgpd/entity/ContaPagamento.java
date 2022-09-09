package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoContaPagamento;
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
public class ContaPagamento implements Serializable {

	private static final long serialVersionUID = -2216020332704575146L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "contaCorrente_id", nullable = false)
	private ContaCorrente contaCorrente;

	@ManyToOne
	@JoinColumn(name = "convenio_id", nullable = false)
	private ConvenioBancario convenio;

	@Enumerated(EnumType.ORDINAL)
	private TipoContaPagamento tipo;

	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable = false)
	private Empresa empresa;

	public ContaPagamento() {
		super();
	}

	public ContaPagamento(Long id, ContaCorrente contaCorrente, ConvenioBancario convenio, TipoContaPagamento tipo,
			Empresa empresa) {
		super();
		this.id = id;
		this.contaCorrente = contaCorrente;
		this.convenio = convenio;
		this.tipo = tipo;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public ConvenioBancario getConvenio() {
		return convenio;
	}

	public void setConvenio(ConvenioBancario convenio) {
		this.convenio = convenio;
	}

	public TipoContaPagamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoContaPagamento tipo) {
		this.tipo = tipo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
		ContaPagamento other = (ContaPagamento) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ContaPagamento [id=" + id + ", contaCorrente=" + contaCorrente + ", convenio=" + convenio + ", tipo="
				+ tipo + ", empresa=" + empresa + "]";
	}

}