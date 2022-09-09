package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoAbonoJustificativaFrequencia;
import br.jus.tjms.sgpd.enumerators.TipoOcorrenciaFrequenciaApuracao;

public class FrequenciaApuracaoDiaOcorrenciaTO implements Serializable {

	private static final long serialVersionUID = 7562723423353372123L;

	private Long id;
	private Long frequenciaApuracaoDiaId;
	private TipoOcorrenciaFrequenciaApuracao tipoOcorrencia;
	private String descricao;
	private String observacoes;
	private Boolean abonadoOuJustificado;
	private Date dataAbonoOuJustificativa;
	private TipoAbonoJustificativaFrequencia tipoAbonoJustificativa;
	private String documentoAbonoOuJustificativa;
	private String motivoAbonoOuJustificativa;
	private String usuarioAbonoOuJustificativa;

	public FrequenciaApuracaoDiaOcorrenciaTO() {
		super();
	}

	public FrequenciaApuracaoDiaOcorrenciaTO(Long id, Long frequenciaApuracaoDiaId,
			TipoOcorrenciaFrequenciaApuracao tipoOcorrencia, String descricao, String observacoes,
			Boolean abonadoOuJustificado, Date dataAbonoOuJustificativa,
			TipoAbonoJustificativaFrequencia tipoAbonoJustificativa, String documentoAbonoOuJustificativa,
			String motivoAbonoOuJustificativa, String usuarioAbonoOuJustificativa) {
		super();
		this.id = id;
		this.frequenciaApuracaoDiaId = frequenciaApuracaoDiaId;
		this.tipoOcorrencia = tipoOcorrencia;
		this.descricao = descricao;
		this.observacoes = observacoes;
		this.abonadoOuJustificado = abonadoOuJustificado;
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

	public TipoOcorrenciaFrequenciaApuracao getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(TipoOcorrenciaFrequenciaApuracao tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Boolean getAbonadoOuJustificado() {
		return abonadoOuJustificado;
	}

	public void setAbonadoOuJustificado(Boolean abonadoOuJustificado) {
		this.abonadoOuJustificado = abonadoOuJustificado;
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
		return "FrequenciaApuracaoDiaOcorrenciaTO [id=" + id + ", frequenciaApuracaoDiaId=" + frequenciaApuracaoDiaId
				+ ", tipoOcorrencia=" + tipoOcorrencia + ", descricao=" + descricao + ", observacoes=" + observacoes
				+ ", abonadoOuJustificado=" + abonadoOuJustificado + ", dataAbonoOuJustificativa="
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
		FrequenciaApuracaoDiaOcorrenciaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}