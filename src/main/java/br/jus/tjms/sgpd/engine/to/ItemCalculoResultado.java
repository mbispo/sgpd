package br.jus.tjms.sgpd.engine.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ItemCalculoResultado implements Serializable {

	private static final long serialVersionUID = -6929451273221195439L;

	private Long id;
	private String uuid;
	private transient Object objeto;
	private Class<?> classe;
	private Double resultado;

	public ItemCalculoResultado() {
		super();
	}

	public ItemCalculoResultado(Long id, String uuid, Object objeto, Class<?> classe, Double resultado) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.objeto = objeto;
		this.classe = classe;
		this.resultado = resultado;
	}

	public ItemCalculoResultado(Double resultado) {
		super();
		this.resultado = resultado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public Class<?> getClasse() {
		return classe;
	}

	public void setClasse(Class<?> classe) {
		this.classe = classe;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
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
		ItemCalculoResultado other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ItemCalculoResultado [id=" + id + ", uuid=" + uuid + ", objeto=" + objeto + ", classe=" + classe
				+ ", resultado=" + resultado + "]";
	}

}