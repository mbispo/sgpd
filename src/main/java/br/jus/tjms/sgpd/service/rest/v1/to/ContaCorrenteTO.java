package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoContaCorrente;

public class ContaCorrenteTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long agenciaId;
	private AgenciaBancariaTO agencia;
	private String numero;
	private String digitoVerificador;
	private TipoContaCorrente tipo;
	private Boolean ativa;
	
	public ContaCorrenteTO() {
		super();
	}
	
	public ContaCorrenteTO(Long id) {
		super();
		this.id = id;
	}
	

	public ContaCorrenteTO(Long id, Long agenciaId, String numero, String digitoVerificador,
			TipoContaCorrente tipo, Boolean ativa) {
		super();
		this.id = id;
		this.agenciaId = agenciaId;
		this.numero = numero;
		this.digitoVerificador = digitoVerificador;
		this.tipo = tipo;
		this.ativa = ativa;
	}
	
	public ContaCorrenteTO(Long agenciaId, String numero, String digitoVerificador,
			TipoContaCorrente tipo, Boolean ativa) {
		super();
		this.agenciaId = agenciaId;
		this.numero = numero;
		this.digitoVerificador = digitoVerificador;
		this.tipo = tipo;
		this.ativa = ativa;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getAgenciaId() {
		return agenciaId;
	}

	public void setAgenciaId(Long agenciaId) {
		this.agenciaId = agenciaId;
	}

	public AgenciaBancariaTO getAgencia() {
		return agencia;
	}

	public void setAgencia(AgenciaBancariaTO agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "ContaCorrenteTO [id=" + id + ", agenciaId=" + agenciaId + ", agencia=" + agencia + ", numero=" + numero
				+ ", digitoVerificador=" + digitoVerificador + ", tipo=" + tipo + ", ativa=" + ativa + "]";
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
		ContaCorrenteTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}