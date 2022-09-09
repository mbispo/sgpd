package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:05
 */
@Entity
@Auditavel
@Cacheable
public class SuspensaoAuxilioEducacaoInfantil implements Serializable {

	private static final long serialVersionUID = 8302787460428568604L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "concessao_id", nullable = false)
	private ConcessaoAuxilioEducacaoInfantil concessao;

	private Date data;
	private Date dataEfeito;
	private Integer ano;
	private Integer semestre;
	private Date periodoInicio;
	private Date periodoFim;

	@Column(length = 500)
	private String observacoes;

	public SuspensaoAuxilioEducacaoInfantil() {
		super();
	}

	public SuspensaoAuxilioEducacaoInfantil(Long id, ConcessaoAuxilioEducacaoInfantil concessao, Date data,
			Date dataEfeito, Integer ano, Integer semestre, Date periodoInicio, Date periodoFim, String observacoes) {
		super();
		this.id = id;
		this.concessao = concessao;
		this.data = data;
		this.dataEfeito = dataEfeito;
		this.ano = ano;
		this.semestre = semestre;
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConcessaoAuxilioEducacaoInfantil getConcessao() {
		return concessao;
	}

	public void setConcessao(ConcessaoAuxilioEducacaoInfantil concessao) {
		this.concessao = concessao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public Date getPeriodoFim() {
		return periodoFim;
	}

	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		SuspensaoAuxilioEducacaoInfantil other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SuspensaoAuxilioEducacaoInfantil [id=" + id + ", concessao=" + concessao + ", data=" + data
				+ ", dataEfeito=" + dataEfeito + ", ano=" + ano + ", semestre=" + semestre + ", periodoInicio="
				+ periodoInicio + ", periodoFim=" + periodoFim + ", observacoes=" + observacoes + "]";
	}

}