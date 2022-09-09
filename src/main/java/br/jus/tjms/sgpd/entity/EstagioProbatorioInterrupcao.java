package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:57
 */
@Entity
@Auditavel
@Cacheable
public class EstagioProbatorioInterrupcao implements Serializable {

	private static final long serialVersionUID = -8639571071439247706L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "estagioProbatorio_id", nullable = false)
	private EstagioProbatorio estagioProbatorio;

	private Integer dias;
	private Date inicio;
	private Date fim;

	@Column(length = 500)
	private String motivo;

	public EstagioProbatorioInterrupcao() {
		super();
	}

	public EstagioProbatorioInterrupcao(Long id, EstagioProbatorio estagioProbatorio, Integer dias, Date inicio,
			Date fim, String motivo) {
		super();
		this.id = id;
		this.estagioProbatorio = estagioProbatorio;
		this.dias = dias;
		this.inicio = inicio;
		this.fim = fim;
		this.motivo = motivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstagioProbatorio getEstagioProbatorio() {
		return estagioProbatorio;
	}

	public void setEstagioProbatorio(EstagioProbatorio estagioProbatorio) {
		this.estagioProbatorio = estagioProbatorio;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
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

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
		EstagioProbatorioInterrupcao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "EstagioProbatorioInterrupcao [id=" + id + ", estagioProbatorio=" + estagioProbatorio + ", dias=" + dias
				+ ", inicio=" + inicio + ", fim=" + fim + ", motivo=" + motivo + "]";
	}

}