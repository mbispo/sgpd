package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.PeriodoEntradaSaida;
import br.jus.tjms.sgpd.enumerators.TipoEntradaSaida;

public class FrequenciaApuracaoDiaEntradaSaidaTO implements Serializable {

	private static final long serialVersionUID = 1717283644910287117L;

	private Long id;
	private Long frequenciaApuracaoDiaId;
	private Date dataHora;
	private Long registroFrequenciaId;
	private PeriodoEntradaSaida periodo;
	private TipoEntradaSaida tipo;

	public FrequenciaApuracaoDiaEntradaSaidaTO() {
		super();
	}

	public FrequenciaApuracaoDiaEntradaSaidaTO(Long id, Long frequenciaApuracaoDiaId, Date dataHora,
			Long registroFrequenciaId, PeriodoEntradaSaida periodo, TipoEntradaSaida tipo) {
		super();
		this.id = id;
		this.frequenciaApuracaoDiaId = frequenciaApuracaoDiaId;
		this.dataHora = dataHora;
		this.registroFrequenciaId = registroFrequenciaId;
		this.periodo = periodo;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFrequenciaApuracaoDiaId() {
		return frequenciaApuracaoDiaId;
	}

	public void setFrequenciaApuracaoDiaId(Long frequenciaApuracaoDiaId) {
		this.frequenciaApuracaoDiaId = frequenciaApuracaoDiaId;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Long getRegistroFrequenciaId() {
		return registroFrequenciaId;
	}

	public void setRegistroFrequenciaId(Long registroFrequenciaId) {
		this.registroFrequenciaId = registroFrequenciaId;
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
	public String toString() {
		return "FrequenciaApuracaoDiaEntradaSaidaTO [id=" + id + ", frequenciaApuracaoDiaId=" + frequenciaApuracaoDiaId
				+ ", dataHora=" + dataHora + ", registroFrequenciaId=" + registroFrequenciaId + ", periodo=" + periodo
				+ ", tipo=" + tipo + "]";
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
		FrequenciaApuracaoDiaEntradaSaidaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}