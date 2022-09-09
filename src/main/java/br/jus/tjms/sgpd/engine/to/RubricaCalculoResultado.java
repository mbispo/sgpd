package br.jus.tjms.sgpd.engine.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RubricaCalculoResultado implements Serializable {

	private static final long serialVersionUID = 6131021027002903280L;

	private transient Object objeto;
	private Double resultado;

	public RubricaCalculoResultado() {
		super();
	}

	public RubricaCalculoResultado(Object objeto, Double resultado) {
		super();
		this.objeto = objeto;
		this.resultado = resultado;
	}

	public RubricaCalculoResultado(Double resultado) {
		super();
		this.resultado = resultado;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(objeto).append(resultado).toHashCode();
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
		RubricaCalculoResultado other = this.getClass().cast(obj);
		return new EqualsBuilder().append(objeto, other.getObjeto()).append(resultado, other.getResultado()).isEquals();
	}

	@Override
	public String toString() {
		return "RubricaCalculoResultado [objeto=" + objeto + ", resultado=" + resultado + "]";
	}

}