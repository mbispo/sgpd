package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.ReferenciaValorTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "referenciaValor.buscarPorCargo", query = "SELECT v FROM ReferenciaValor v JOIN v.referencia r WHERE r.cargo.id = :cargoId")
})
public class ReferenciaValor implements Serializable {

	private static final long serialVersionUID = 5647499457504299353L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "refererencia_id")
	@JsonIgnore
	private Referencia referencia;

	private Double valor;
	private Date vigenciaInicio;
	private Date vigenciaFim;

	public ReferenciaValor() {
		super();
	}

	public ReferenciaValor(Long id, Referencia referencia, Double valor, Date vigenciaInicio, Date vigenciaFim) {
		super();
		this.id = id;
		this.referencia = referencia;
		this.valor = valor;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
	}

	public ReferenciaValor(ReferenciaValorTO referenciaValorTO) {
		this.referencia = new Referencia(referenciaValorTO.getRefererenciaId());
		this.valor = referenciaValorTO.getValor();
		this.vigenciaInicio = referenciaValorTO.getVigenciaInicio();
		this.vigenciaFim = referenciaValorTO.getVigenciaFim();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Referencia getReferencia() {
		return referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
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
		ReferenciaValor other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ReferenciaValor [id=" + id + ", referencia=" + referencia + ", valor=" + valor
				+ ", vigenciaInicio=" + vigenciaInicio + ", vigenciaFim=" + vigenciaFim + "]";
	}

	public void alterar(ReferenciaValorTO referenciaValorTO) {
		this.referencia = new Referencia(referenciaValorTO.getRefererenciaId());
		this.valor = referenciaValorTO.getValor();
		this.vigenciaInicio = referenciaValorTO.getVigenciaInicio();
		this.vigenciaFim = referenciaValorTO.getVigenciaFim();
	}
}