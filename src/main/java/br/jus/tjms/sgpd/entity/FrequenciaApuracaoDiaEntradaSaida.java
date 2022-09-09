package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.PeriodoEntradaSaida;
import br.jus.tjms.sgpd.enumerators.TipoEntradaSaida;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
public class FrequenciaApuracaoDiaEntradaSaida implements Serializable {

	private static final long serialVersionUID = -2279452987413314048L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "apuracaoDia_id", nullable = false)
	private FrequenciaApuracaoDia apuracaoDia;

	private Date dataHora;

	@ManyToOne
	@JoinColumn(name = "registroFrequencia_id", nullable = true)
	private RegistroFrequencia registroFrequencia;

	@Enumerated(EnumType.ORDINAL)
	private PeriodoEntradaSaida periodo;

	@Enumerated(EnumType.ORDINAL)
	private TipoEntradaSaida tipo;

	public FrequenciaApuracaoDiaEntradaSaida() {
		super();
	}

	public FrequenciaApuracaoDiaEntradaSaida(Long id, FrequenciaApuracaoDia apuracaoDia, Date dataHora,
			RegistroFrequencia registroFrequencia, PeriodoEntradaSaida periodo, TipoEntradaSaida tipo) {
		super();
		this.id = id;
		this.apuracaoDia = apuracaoDia;
		this.dataHora = dataHora;
		this.registroFrequencia = registroFrequencia;
		this.periodo = periodo;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FrequenciaApuracaoDia getApuracaoDia() {
		return apuracaoDia;
	}

	public void setApuracaoDia(FrequenciaApuracaoDia apuracaoDia) {
		this.apuracaoDia = apuracaoDia;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public RegistroFrequencia getRegistroFrequencia() {
		return registroFrequencia;
	}

	public void setRegistroFrequencia(RegistroFrequencia registroFrequencia) {
		this.registroFrequencia = registroFrequencia;
	}

	public PeriodoEntradaSaida getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoEntradaSaida periodo) {
		this.periodo = periodo;
	}

	public TipoEntradaSaida getTipo() {
		return tipo;
	}

	public void setTipo(TipoEntradaSaida tipo) {
		this.tipo = tipo;
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
		FrequenciaApuracaoDiaEntradaSaida other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FrequenciaApuracaoDiaEntradaSaida [id=" + id + ", apuracaoDia=" + apuracaoDia + ", dataHora="
				+ dataHora + ", registroFrequencia=" + registroFrequencia + ", periodo=" + periodo + ", tipo=" + tipo
				+ "]";
	}

}