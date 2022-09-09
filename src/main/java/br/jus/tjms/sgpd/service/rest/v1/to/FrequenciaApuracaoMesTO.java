package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class FrequenciaApuracaoMesTO implements Serializable {

	private static final long serialVersionUID = 6802185403037192442L;
	
	private Long id;
	private Long funcionarioId;
	private Integer ano;
	private Integer mes;
	private Date referenciaInicio;
	private Date referenciaFim;
	private Boolean apurado;
	private Date dataApuracao;

	public FrequenciaApuracaoMesTO() {
		super();
	}

	public FrequenciaApuracaoMesTO(Long id, Long funcionarioId, Integer ano, Integer mes, Date referenciaInicio,
			Date referenciaFim, Boolean apurado, Date dataApuracao) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.ano = ano;
		this.mes = mes;
		this.referenciaInicio = referenciaInicio;
		this.referenciaFim = referenciaFim;
		this.apurado = apurado;
		this.dataApuracao = dataApuracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Date getReferenciaInicio() {
		return referenciaInicio;
	}

	public void setReferenciaInicio(Date referenciaInicio) {
		this.referenciaInicio = referenciaInicio;
	}

	public Date getReferenciaFim() {
		return referenciaFim;
	}

	public void setReferenciaFim(Date referenciaFim) {
		this.referenciaFim = referenciaFim;
	}

	public Boolean getApurado() {
		return apurado;
	}

	public void setApurado(Boolean apurado) {
		this.apurado = apurado;
	}

	public Date getDataApuracao() {
		return dataApuracao;
	}

	public void setDataApuracao(Date dataApuracao) {
		this.dataApuracao = dataApuracao;
	}
	
	@Override
	public String toString() {
		return "FrequenciaApuracaoMesTO [id=" + id + ", funcionarioId=" + funcionarioId + ", ano=" + ano + ", mes="
				+ mes + ", referenciaInicio=" + referenciaInicio + ", referenciaFim=" + referenciaFim + ", apurado="
				+ apurado + ", dataApuracao=" + dataApuracao + "]";
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
		FrequenciaApuracaoMesTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}