package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class FrequenciaApuracaoDiaTO implements Serializable {

	private static final long serialVersionUID = -2124103472948396245L;

	private Long id;
	private Long frequenciaApuracaoMesId;
	private Integer dia;
	private Integer sequencial;
	private Date inicioReferencia;
	private Date fimReferencia;
	private Date data;
	private String descricao;
	private String observacoes;

	public FrequenciaApuracaoDiaTO() {
		super();
	}

	public FrequenciaApuracaoDiaTO(Long id, Long frequenciaApuracaoMesId, Integer dia, Integer sequencial,
			Date inicioReferencia, Date fimReferencia, Date data, String descricao, String observacoes) {
		super();
		this.id = id;
		this.frequenciaApuracaoMesId = frequenciaApuracaoMesId;
		this.dia = dia;
		this.sequencial = sequencial;
		this.inicioReferencia = inicioReferencia;
		this.fimReferencia = fimReferencia;
		this.data = data;
		this.descricao = descricao;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFrequenciaApuracaoMesId() {
		return frequenciaApuracaoMesId;
	}

	public void setFrequenciaApuracaoMesId(Long frequenciaApuracaoMesId) {
		this.frequenciaApuracaoMesId = frequenciaApuracaoMesId;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public Date getInicioReferencia() {
		return inicioReferencia;
	}

	public void setInicioReferencia(Date inicioReferencia) {
		this.inicioReferencia = inicioReferencia;
	}

	public Date getFimReferencia() {
		return fimReferencia;
	}

	public void setFimReferencia(Date fimReferencia) {
		this.fimReferencia = fimReferencia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	@Override
	public String toString() {
		return "FrequenciaApuracaoDiaTO [id=" + id + ", frequenciaApuracaoMesId=" + frequenciaApuracaoMesId + ", dia="
				+ dia + ", sequencial=" + sequencial + ", inicioReferencia=" + inicioReferencia + ", fimReferencia="
				+ fimReferencia + ", data=" + data + ", descricao=" + descricao + ", observacoes=" + observacoes + "]";
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
		FrequenciaApuracaoDiaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}