package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoAbonoJustificativaFrequencia;
import br.jus.tjms.sgpd.enumerators.TipoCargaHorariaFrequenciaApuracao;
import br.jus.tjms.sgpd.service.rest.v1.to.FrequenciaApuracaoDiaCargaHorariaTO;
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
@NamedQueries({
	@NamedQuery(name = "frequenciaApuracaoDiaCargaHoraria.buscarPorFrequenciaApuracaoDiaId", 
		query = "SELECT f FROM FrequenciaApuracaoDiaCargaHoraria f WHERE f.apuracaoDia.id = :id")
})
public class FrequenciaApuracaoDiaCargaHoraria implements Serializable {

	private static final long serialVersionUID = 3345068978256507971L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "apuracaoDia_id", nullable = false)
	private FrequenciaApuracaoDia apuracaoDia;

	@Enumerated(EnumType.ORDINAL)
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
	//TODO quando um débito é descontado e depois é abonado, deve haver uma forma de reverter o processo, gerando um lançamento inverso.
	@Enumerated(EnumType.ORDINAL)
	private TipoAbonoJustificativaFrequencia tipoAbonoJustificativa;

	@Column(length = 200)
	private String documentoAbonoOuJustificativa;

	@Column(length = 500)
	private String motivoAbonoOuJustificativa;

	@Column(length = 100)
	private String usuarioAbonoOuJustificativa;

	public FrequenciaApuracaoDiaCargaHoraria() {
		super();
	}
	
	public FrequenciaApuracaoDiaCargaHoraria(Long id, FrequenciaApuracaoDia apuracaoDia,
			TipoCargaHorariaFrequenciaApuracao tipoCargaHoraria, Date tempo, Integer horas, Long tempoMilis,
			Integer minutos, Integer segundos, Boolean extra, Boolean abonadoOuJustificado, Double percentualExtra,
			Double percentualAdicionalNoturno, Date dataAbonoOuJustificativa,
			TipoAbonoJustificativaFrequencia tipoAbonoJustificativa, String documentoAbonoOuJustificativa,
			String motivoAbonoOuJustificativa, String usuarioAbonoOuJustificativa) {
		super();
		this.id = id;
		this.apuracaoDia = apuracaoDia;
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

	public FrequenciaApuracaoDiaCargaHoraria(FrequenciaApuracaoDiaCargaHorariaTO to) {
		super();
		this.id = to.getId();
		this.apuracaoDia = new FrequenciaApuracaoDia(to.getFrequenciaApuracaoDiaId());
		this.tipoCargaHoraria = to.getTipoCargaHoraria();
		this.tempo = to.getTempo();
		this.horas = to.getHoras();
		this.tempoMilis = to.getTempoMilis();
		this.minutos = to.getMinutos();
		this.segundos = to.getSegundos();
		this.extra = to.getExtra();
		this.abonadoOuJustificado = to.getAbonadoOuJustificado();
		this.percentualExtra = to.getPercentualExtra();
		this.percentualAdicionalNoturno = to.getPercentualAdicionalNoturno(); 
		this.dataAbonoOuJustificativa = to.getDataAbonoOuJustificativa();
		this.tipoAbonoJustificativa = to.getTipoAbonoJustificativa();
		this.documentoAbonoOuJustificativa = to.getDocumentoAbonoOuJustificativa();
		this.motivoAbonoOuJustificativa = to.getMotivoAbonoOuJustificativa();
		this.usuarioAbonoOuJustificativa = to.getUsuarioAbonoOuJustificativa();
	}
	
	public void alterar(FrequenciaApuracaoDiaCargaHorariaTO to) {
		this.apuracaoDia = new FrequenciaApuracaoDia(to.getFrequenciaApuracaoDiaId());
		this.tipoCargaHoraria = to.getTipoCargaHoraria();
		this.tempo = to.getTempo();
		this.horas = to.getHoras();
		this.tempoMilis = to.getTempoMilis();
		this.minutos = to.getMinutos();
		this.segundos = to.getSegundos();
		this.extra = to.getExtra();
		this.abonadoOuJustificado = to.getAbonadoOuJustificado();
		this.percentualExtra = to.getPercentualExtra();
		this.percentualAdicionalNoturno = to.getPercentualAdicionalNoturno();
		this.dataAbonoOuJustificativa = to.getDataAbonoOuJustificativa();
		this.tipoAbonoJustificativa = to.getTipoAbonoJustificativa();
		this.documentoAbonoOuJustificativa = to.getDocumentoAbonoOuJustificativa();
		this.motivoAbonoOuJustificativa = to.getMotivoAbonoOuJustificativa();
		this.usuarioAbonoOuJustificativa = to.getUsuarioAbonoOuJustificativa();		
	}
	
	public FrequenciaApuracaoDiaCargaHorariaTO toTO() {
		return new FrequenciaApuracaoDiaCargaHorariaTO(id, apuracaoDia.getId(),
				tipoCargaHoraria, tempo, horas, tempoMilis,
				minutos, segundos, extra, abonadoOuJustificado, percentualExtra,
				percentualAdicionalNoturno, dataAbonoOuJustificativa, tipoAbonoJustificativa,
				documentoAbonoOuJustificativa, motivoAbonoOuJustificativa,
				usuarioAbonoOuJustificativa);
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
		FrequenciaApuracaoDiaCargaHoraria other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FrequenciaApuracaoDiaCargaHoraria [id=" + id + ", tipoCargaHoraria=" + tipoCargaHoraria + ", tempo="
				+ tempo + ", horas=" + horas + ", tempoMilis=" + tempoMilis + ", minutos=" + minutos + ", segundos="
				+ segundos + ", extra=" + extra + ", abonadoOuJustificado=" + abonadoOuJustificado
				+ ", percentualExtra=" + percentualExtra + ", percentualAdicionalNoturno=" + percentualAdicionalNoturno
				+ ", dataAbonoOuJustificativa=" + dataAbonoOuJustificativa + ", tipoAbonoJustificativa="
				+ tipoAbonoJustificativa + ", documentoAbonoOuJustificativa=" + documentoAbonoOuJustificativa
				+ ", motivoAbonoOuJustificativa=" + motivoAbonoOuJustificativa + ", usuarioAbonoOuJustificativa="
				+ usuarioAbonoOuJustificativa + "]";
	}
	
}