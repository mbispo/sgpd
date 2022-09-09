package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoAbonoJustificativaFrequencia;
import br.jus.tjms.sgpd.enumerators.TipoCargaHorariaFrequenciaApuracao;

public class FrequenciaApuracaoDiaCargaHorariaTO implements Serializable {

	private static final long serialVersionUID = 5098866109335819443L;

	private Long id;
	private Long frequenciaApuracaoDiaId;
	private TipoCargaHorariaFrequenciaApuracao tipoCargaHoraria;
	private Date tempo;
	private Integer horas;
	private Long tempoMilis;
	private Integer minutos;
	private Integer segundos;
	private Boolean extra;
	private Boolean abonadoOuJustificado;
	private Double percentualExtra;
	private Double percentualAdicionalNoturno;
	private Date dataAbonoOuJustificativa;
	private TipoAbonoJustificativaFrequencia tipoAbonoJustificativa;
	private String documentoAbonoOuJustificativa;
	private String motivoAbonoOuJustificativa;
	private String usuarioAbonoOuJustificativa;

	public FrequenciaApuracaoDiaCargaHorariaTO() {
		super();
	}

	public FrequenciaApuracaoDiaCargaHorariaTO(Long id, Long frequenciaApuracaoDiaId,
			TipoCargaHorariaFrequenciaApuracao tipoCargaHoraria, Date tempo, Integer horas, Long tempoMilis,
			Integer minutos, Integer segundos, Boolean extra, Boolean abonadoOuJustificado, Double percentualExtra,
			Double percentualAdicionalNoturno, Date dataAbonoOuJustificativa,
			TipoAbonoJustificativaFrequencia tipoAbonoJustificativa, String documentoAbonoOuJustificativa,
			String motivoAbonoOuJustificativa, String usuarioAbonoOuJustificativa) {
		super();
		this.id = id;
		this.frequenciaApuracaoDiaId = frequenciaApuracaoDiaId;
		this.tipoCargaHoraria = tipoCargaHoraria;
		this.tempo = tempo;
		this.horas = horas;
		this.tempoMilis = tempoMilis;
		this.minutos = minutos;
		this.segundos = segundos;
		this.extra = extra;
		this.abonadoOuJustificado = abonadoOuJustificado;
		this.percentualExtra = percentualExtra;
		this.percentualAdicionalNoturno = percentualAdicionalNoturno;
		this.dataAbonoOuJustificativa = dataAbonoOuJustificativa;
		this.tipoAbonoJustificativa = tipoAbonoJustificativa;
		this.documentoAbonoOuJustificativa = documentoAbonoOuJustificativa;
		this.motivoAbonoOuJustificativa = motivoAbonoOuJustificativa;
		this.usuarioAbonoOuJustificativa = usuarioAbonoOuJustificativa;
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

	public TipoCargaHorariaFrequenciaApuracao getTipoCargaHoraria() {
		return tipoCargaHoraria;
	}

	public void setTipoCargaHoraria(TipoCargaHorariaFrequenciaApuracao tipoCargaHoraria) {
		this.tipoCargaHoraria = tipoCargaHoraria;
	}

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
		this.tempo = tempo;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Long getTempoMilis() {
		return tempoMilis;
	}

	public void setTempoMilis(Long tempoMilis) {
		this.tempoMilis = tempoMilis;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

	public Integer getSegundos() {
		return segundos;
	}

	public void setSegundos(Integer segundos) {
		this.segundos = segundos;
	}

	public Boolean getExtra() {
		return extra;
	}

	public void setExtra(Boolean extra) {
		this.extra = extra;
	}

	public Boolean getAbonadoOuJustificado() {
		return abonadoOuJustificado;
	}

	public void setAbonadoOuJustificado(Boolean abonadoOuJustificado) {
		this.abonadoOuJustificado = abonadoOuJustificado;
	}

	public Double getPercentualExtra() {
		return percentualExtra;
	}

	public void setPercentualExtra(Double percentualExtra) {
		this.percentualExtra = percentualExtra;
	}

	public Double getPercentualAdicionalNoturno() {
		return percentualAdicionalNoturno;
	}

	public void setPercentualAdicionalNoturno(Double percentualAdicionalNoturno) {
		this.percentualAdicionalNoturno = percentualAdicionalNoturno;
	}

	public Date getDataAbonoOuJustificativa() {
		return dataAbonoOuJustificativa;
	}

	public void setDataAbonoOuJustificativa(Date dataAbonoOuJustificativa) {
		this.dataAbonoOuJustificativa = dataAbonoOuJustificativa;
	}

	public TipoAbonoJustificativaFrequencia getTipoAbonoJustificativa() {
		return tipoAbonoJustificativa;
	}

	public void setTipoAbonoJustificativa(TipoAbonoJustificativaFrequencia tipoAbonoJustificativa) {
		this.tipoAbonoJustificativa = tipoAbonoJustificativa;
	}

	public String getDocumentoAbonoOuJustificativa() {
		return documentoAbonoOuJustificativa;
	}

	public void setDocumentoAbonoOuJustificativa(String documentoAbonoOuJustificativa) {
		this.documentoAbonoOuJustificativa = documentoAbonoOuJustificativa;
	}

	public String getMotivoAbonoOuJustificativa() {
		return motivoAbonoOuJustificativa;
	}

	public void setMotivoAbonoOuJustificativa(String motivoAbonoOuJustificativa) {
		this.motivoAbonoOuJustificativa = motivoAbonoOuJustificativa;
	}

	public String getUsuarioAbonoOuJustificativa() {
		return usuarioAbonoOuJustificativa;
	}

	public void setUsuarioAbonoOuJustificativa(String usuarioAbonoOuJustificativa) {
		this.usuarioAbonoOuJustificativa = usuarioAbonoOuJustificativa;
	}

	@Override
	public String toString() {
		return "FrequenciaApuracaoDiaCargaHorariaTO [id=" + id + ", frequenciaApuracaoDiaId=" + frequenciaApuracaoDiaId
				+ ", tipoCargaHoraria=" + tipoCargaHoraria + ", tempo=" + tempo + ", horas=" + horas + ", tempoMilis="
				+ tempoMilis + ", minutos=" + minutos + ", segundos=" + segundos + ", extra=" + extra
				+ ", abonadoOuJustificado=" + abonadoOuJustificado + ", percentualExtra=" + percentualExtra
				+ ", percentualAdicionalNoturno=" + percentualAdicionalNoturno + ", dataAbonoOuJustificativa="
				+ dataAbonoOuJustificativa + ", tipoAbonoJustificativa=" + tipoAbonoJustificativa
				+ ", documentoAbonoOuJustificativa=" + documentoAbonoOuJustificativa + ", motivoAbonoOuJustificativa="
				+ motivoAbonoOuJustificativa + ", usuarioAbonoOuJustificativa=" + usuarioAbonoOuJustificativa + "]";
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
		FrequenciaApuracaoDiaCargaHorariaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}