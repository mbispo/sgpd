package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoContaCorrente;
import br.jus.tjms.sgpd.service.rest.v1.to.ContaCorrenteTO;
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
@NamedQueries({
	@NamedQuery(name = "contaCorrente.buscarContasCorrentePorAgencia", 
			query = "SELECT c FROM ContaCorrente c WHERE c.agencia.id = :agenciaId" ),
	@NamedQuery(name = "contaCorrente.buscarContasCorrentePorNumero", 
			query = "SELECT c FROM ContaCorrente c WHERE c.numero = :numero" ),
})
public class ContaCorrente implements Serializable {

	private static final long serialVersionUID = 7261117955440248239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "agencia_id", nullable = false)
	private AgenciaBancaria agencia;

	@Column(length = 20)
	private String numero;
	
	private String digitoVerificador;

	@Enumerated(EnumType.ORDINAL)
	private TipoContaCorrente tipo;

	private Boolean ativa;

	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(Long id) {
		super();
		this.id = id;
	}

	public ContaCorrente(Long id, AgenciaBancaria agencia, String numero, String digitoVerificador,
			TipoContaCorrente tipo, Boolean ativa) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.numero = numero;
		this.digitoVerificador = digitoVerificador;
		this.tipo = tipo;
		this.ativa = ativa;
	}

	public ContaCorrente(ContaCorrenteTO contaCorrenteTO) {
		if (contaCorrenteTO.getId()!=null) {
			this.id = contaCorrenteTO.getId();
		}
		this.agencia = new AgenciaBancaria(contaCorrenteTO.getAgenciaId());
		this.numero = contaCorrenteTO.getNumero();
		this.digitoVerificador = contaCorrenteTO.getDigitoVerificador();
		this.tipo = contaCorrenteTO.getTipo();
		this.ativa = contaCorrenteTO.getAtiva();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AgenciaBancaria getAgencia() {
		return agencia;
	}

	public void setAgencia(AgenciaBancaria agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(String digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	public TipoContaCorrente getTipo() {
		return tipo;
	}

	public void setTipo(TipoContaCorrente tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
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
		ContaCorrente other = (ContaCorrente) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ContaCorrente [id=" + id + ", agencia=" + agencia + ", numero=" + numero + ", digitoVerificador="
				+ digitoVerificador + ", tipo=" + tipo + ", ativa=" + ativa + "]";
	}

	public void alterar(ContaCorrenteTO contaCorrenteTO) {
		this.agencia = new AgenciaBancaria(contaCorrenteTO.getAgenciaId());
		this.numero = contaCorrenteTO.getNumero();
		this.digitoVerificador = contaCorrenteTO.getDigitoVerificador();
		this.tipo = contaCorrenteTO.getTipo();
		this.ativa = contaCorrenteTO.getAtiva();
	}

	public ContaCorrenteTO toTO() {
		ContaCorrenteTO to = new ContaCorrenteTO(id, agencia.getId(), numero, digitoVerificador, tipo, ativa);
		to.setAgencia(agencia.toTO());
		return to; 
	}

}