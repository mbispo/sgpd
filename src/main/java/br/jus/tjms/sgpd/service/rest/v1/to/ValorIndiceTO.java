package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ValorIndiceTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Double valor;
	private Date inicio;
	private Date fim;
	private Long indiceId;

	public ValorIndiceTO() {
		super();
	}

	public ValorIndiceTO(Long id, Double valor, Date inicio, Date fim, Long indiceId) {
		super();
		this.id = id;
		this.valor = valor;
		this.inicio = inicio;
		this.fim = fim;
		this.indiceId = indiceId;
	}
	
	public ValorIndiceTO(Double valor, Date inicio, Date fim, Long indiceId) {
		super();
		this.valor = valor;
		this.inicio = inicio;
		this.fim = fim;
		this.indiceId = indiceId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Long getIndiceId() {
		return indiceId;
	}

	public void setIndiceId(Long indiceId) {
		this.indiceId = indiceId;
	}

	@Override
	public String toString() {
		return "ValorIndiceTO [id=" + id + ", valor=" + valor + ", inicio=" + inicio + ", fim=" + fim + ", indiceId="
				+ indiceId + "]";
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
		ValorIndiceTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}