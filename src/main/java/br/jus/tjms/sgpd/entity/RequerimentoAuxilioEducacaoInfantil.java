package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoRequerimentoAuxilioEducacaoInfantil;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
public class RequerimentoAuxilioEducacaoInfantil implements Serializable {

	private static final long serialVersionUID = -4295338730104562566L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "dependente_id", nullable = false)
	private Pessoa dependente;

	private Date data;
	private Integer ano;
	private Date periodoInicio;
	private Date periodoFim;

	@Column(length = 500)
	private String observacoes;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoRequerimentoAuxilioEducacaoInfantil situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public RequerimentoAuxilioEducacaoInfantil() {
		super();
	}

	public RequerimentoAuxilioEducacaoInfantil(Long id, Funcionario funcionario, Pessoa dependente, Date data,
			Integer ano, Date periodoInicio, Date periodoFim, String observacoes,
			SituacaoRequerimentoAuxilioEducacaoInfantil situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.dependente = dependente;
		this.data = data;
		this.ano = ano;
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.observacoes = observacoes;
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

	public Pessoa getDependente() {
		return dependente;
	}

	public void setDependente(Pessoa dependente) {
		this.dependente = dependente;
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

	public SituacaoRequerimentoAuxilioEducacaoInfantil getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoRequerimentoAuxilioEducacaoInfantil situacao) {
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
		RequerimentoAuxilioEducacaoInfantil other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RequerimentoAuxilioEducacaoInfantil [id=" + id + ", funcionario=" + funcionario + ", dependente="
				+ dependente + ", data=" + data + ", ano=" + ano + ", periodoInicio=" + periodoInicio + ", periodoFim="
				+ periodoFim + ", observacoes=" + observacoes + ", situacao=" + situacao + ", dataSituacao="
				+ dataSituacao + ", parecer=" + parecer + "]";
	}

}