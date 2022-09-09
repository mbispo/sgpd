package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoAbonoJustificativaFrequencia;
import br.jus.tjms.sgpd.enumerators.TipoOcorrenciaFrequenciaApuracao;
import br.jus.tjms.sgpd.service.rest.v1.to.FrequenciaApuracaoDiaOcorrenciaTO;
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
	@NamedQuery(name = "frequenciaApuracaoDiaOcorrencia.buscarPorFrequenciaApuracaoDiaId", 
		query = "SELECT f FROM FrequenciaApuracaoDiaOcorrencia f WHERE f.apuracaoDia.id = :id")
})
public class FrequenciaApuracaoDiaOcorrencia implements Serializable {

	private static final long serialVersionUID = -92156000306501794L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "apuracaoDia_id", nullable = false)
	private FrequenciaApuracaoDia apuracaoDia;

	@Enumerated(EnumType.ORDINAL)
	private TipoOcorrenciaFrequenciaApuracao tipoOcorrencia;

	@Column(length = 200)
	private String descricao;

	@Column(length = 500)
	private String observacoes;

	private Boolean abonadoOuJustificado;
	private Date dataAbonoOuJustificativa;

	@Enumerated(EnumType.ORDINAL)
	private TipoAbonoJustificativaFrequencia tipoAbonoJustificativa;

	@Column(length = 200)
	private String documentoAbonoOuJustificativa;

	@Column(length = 500)
	private String motivoAbonoOuJustificativa;

	@Column(length = 100)
	private String usuarioAbonoOuJustificativa;

	public FrequenciaApuracaoDiaOcorrencia() {
		super();
	}

	public FrequenciaApuracaoDiaOcorrencia(Long id, FrequenciaApuracaoDia apuracaoDia,
			TipoOcorrenciaFrequenciaApuracao tipoOcorrencia, String descricao, String observacoes,
			Boolean abonadoOuJustificado, Date dataAbonoOuJustificativa,
			TipoAbonoJustificativaFrequencia tipoAbonoJustificativa, String documentoAbonoOuJustificativa,
			String motivoAbonoOuJustificativa, String usuarioAbonoOuJustificativa) {
		super();
		this.id = id;
		this.apuracaoDia = apuracaoDia;
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
	
	public FrequenciaApuracaoDiaOcorrencia(FrequenciaApuracaoDiaOcorrenciaTO to) {
		super();
		this.id = to.getId();
		this.apuracaoDia = new FrequenciaApuracaoDia(to.getFrequenciaApuracaoDiaId());
		this.tipoOcorrencia = to.getTipoOcorrencia();
		this.descricao = to.getDescricao();
		this.observacoes = to.getObservacoes();
		this.abonadoOuJustificado = to.getAbonadoOuJustificado();
		this.dataAbonoOuJustificativa = to.getDataAbonoOuJustificativa();
		this.tipoAbonoJustificativa = to.getTipoAbonoJustificativa();
		this.documentoAbonoOuJustificativa = to.getDocumentoAbonoOuJustificativa();
		this.motivoAbonoOuJustificativa = to.getMotivoAbonoOuJustificativa();
		this.usuarioAbonoOuJustificativa = to.getUsuarioAbonoOuJustificativa();
	}
	
	public void alterar(FrequenciaApuracaoDiaOcorrenciaTO to) {
		this.apuracaoDia = new FrequenciaApuracaoDia(to.getFrequenciaApuracaoDiaId());
		this.tipoOcorrencia = to.getTipoOcorrencia();
		this.descricao = to.getDescricao();
		this.observacoes = to.getObservacoes();
		this.abonadoOuJustificado = to.getAbonadoOuJustificado();
		this.dataAbonoOuJustificativa = to.getDataAbonoOuJustificativa();
		this.tipoAbonoJustificativa = to.getTipoAbonoJustificativa();
		this.documentoAbonoOuJustificativa = to.getDocumentoAbonoOuJustificativa();
		this.motivoAbonoOuJustificativa = to.getMotivoAbonoOuJustificativa();
		this.usuarioAbonoOuJustificativa = to.getUsuarioAbonoOuJustificativa();
	}
	
	public FrequenciaApuracaoDiaOcorrenciaTO toTO() {
		return new FrequenciaApuracaoDiaOcorrenciaTO(id, apuracaoDia.getId(),
				tipoOcorrencia, descricao, observacoes,
				abonadoOuJustificado, dataAbonoOuJustificativa,
				tipoAbonoJustificativa, documentoAbonoOuJustificativa,
				motivoAbonoOuJustificativa, usuarioAbonoOuJustificativa);
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
		FrequenciaApuracaoDiaOcorrencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FrequenciaApuracaoDiaOcorrencia [id=" + id + ", apuracaoDia=" + apuracaoDia + ", tipoOcorrencia="
				+ tipoOcorrencia + ", descricao=" + descricao + ", observacoes=" + observacoes
				+ ", abonadoOuJustificado=" + abonadoOuJustificado + ", dataAbonoOuJustificativa="
				+ dataAbonoOuJustificativa + ", tipoAbonoJustificativa=" + tipoAbonoJustificativa
				+ ", documentoAbonoOuJustificativa=" + documentoAbonoOuJustificativa + ", motivoAbonoOuJustificativa="
				+ motivoAbonoOuJustificativa + ", usuarioAbonoOuJustificativa=" + usuarioAbonoOuJustificativa + "]";
	}


}