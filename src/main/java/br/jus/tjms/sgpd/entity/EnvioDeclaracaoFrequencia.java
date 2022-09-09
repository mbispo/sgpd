package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoEnvioDeclaracaoFrequencia;
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
public class EnvioDeclaracaoFrequencia implements Serializable {

	private static final long serialVersionUID = -3689371828058494831L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "concessao_id", nullable = false)
	private ConcessaoAuxilioEducacaoInfantil concessao;

	private Date data;
	private Integer ano;
	private Integer semestre;
	private Date frequenciaInicio;
	private Date frequenciaFim;
	private Integer faltasInjustificadas;
	
	@Column(length = 60)
	private String processo;
	
	@Column(length = 500)
	private String observacoes;

	private Integer idDocumentoGerdoc;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoEnvioDeclaracaoFrequencia situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public EnvioDeclaracaoFrequencia() {
		super();
	}

	public EnvioDeclaracaoFrequencia(Long id, Funcionario funcionario, ConcessaoAuxilioEducacaoInfantil concessao,
			Date data, Integer ano, Integer semestre, Date frequenciaInicio, Date frequenciaFim,
			Integer faltasInjustificadas, String processo, String observacoes, Integer idDocumentoGerdoc,
			SituacaoEnvioDeclaracaoFrequencia situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.concessao = concessao;
		this.data = data;
		this.ano = ano;
		this.semestre = semestre;
		this.frequenciaInicio = frequenciaInicio;
		this.frequenciaFim = frequenciaFim;
		this.faltasInjustificadas = faltasInjustificadas;
		this.processo = processo;
		this.observacoes = observacoes;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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

	public Date getFrequenciaInicio() {
		return frequenciaInicio;
	}

	public void setFrequenciaInicio(Date frequenciaInicio) {
		this.frequenciaInicio = frequenciaInicio;
	}

	public Date getFrequenciaFim() {
		return frequenciaFim;
	}

	public void setFrequenciaFim(Date frequenciaFim) {
		this.frequenciaFim = frequenciaFim;
	}

	public Integer getFaltasInjustificadas() {
		return faltasInjustificadas;
	}

	public void setFaltasInjustificadas(Integer faltasInjustificadas) {
		this.faltasInjustificadas = faltasInjustificadas;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getIdDocumentoGerdoc() {
		return idDocumentoGerdoc;
	}

	public void setIdDocumentoGerdoc(Integer idDocumentoGerdoc) {
		this.idDocumentoGerdoc = idDocumentoGerdoc;
	}

	public SituacaoEnvioDeclaracaoFrequencia getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnvioDeclaracaoFrequencia situacao) {
		this.situacao = situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
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
		EnvioDeclaracaoFrequencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "EnvioDeclaracaoFrequencia [id=" + id + ", funcionario=" + funcionario + ", concessao=" + concessao
				+ ", data=" + data + ", ano=" + ano + ", semestre=" + semestre + ", frequenciaInicio="
				+ frequenciaInicio + ", frequenciaFim=" + frequenciaFim + ", faltasInjustificadas="
				+ faltasInjustificadas + ", processo=" + processo + ", observacoes=" + observacoes
				+ ", idDocumentoGerdoc=" + idDocumentoGerdoc + ", situacao=" + situacao + ", dataSituacao="
				+ dataSituacao + ", parecer=" + parecer + "]";
	}

}