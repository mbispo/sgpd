package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoConcessaoAuxilioEducacaoInfantil;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
public class ConcessaoAuxilioEducacaoInfantil implements Serializable {

	private static final long serialVersionUID = -7301058864774397646L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "requerimento_id", nullable = true)
	private RequerimentoAuxilioEducacaoInfantil requerimento;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@ManyToOne
	@JoinColumn(name = "dependente_id", nullable = false)
	private Pessoa dependente;

	@Column(length = 60)
	private String processo;

	private Date data;
	private Date dataEfeito;
	private Date periodoInicio;
	private Date periodoFim;

	@Column(length = 500)
	private String observacoes;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoConcessaoAuxilioEducacaoInfantil situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public ConcessaoAuxilioEducacaoInfantil() {
		super();
	}

	public ConcessaoAuxilioEducacaoInfantil(Long id, Funcionario funcionario,
			RequerimentoAuxilioEducacaoInfantil requerimento, AtoAdministrativo atoAdministrativo, Pessoa dependente,
			String processo, Date data, Date dataEfeito, Date periodoInicio, Date periodoFim, String observacoes,
			SituacaoConcessaoAuxilioEducacaoInfantil situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.requerimento = requerimento;
		this.atoAdministrativo = atoAdministrativo;
		this.dependente = dependente;
		this.processo = processo;
		this.data = data;
		this.dataEfeito = dataEfeito;
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

	public RequerimentoAuxilioEducacaoInfantil getRequerimento() {
		return requerimento;
	}

	public void setRequerimento(RequerimentoAuxilioEducacaoInfantil requerimento) {
		this.requerimento = requerimento;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public Pessoa getDependente() {
		return dependente;
	}

	public void setDependente(Pessoa dependente) {
		this.dependente = dependente;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
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

	public SituacaoConcessaoAuxilioEducacaoInfantil getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoConcessaoAuxilioEducacaoInfantil situacao) {
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
		ConcessaoAuxilioEducacaoInfantil other = (ConcessaoAuxilioEducacaoInfantil) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcessaoAuxilioEducacaoInfantil [id=" + id + ", funcionario=" + funcionario + ", requerimento="
				+ requerimento + ", atoAdministrativo=" + atoAdministrativo + ", dependente=" + dependente
				+ ", processo=" + processo + ", observacoes=" + observacoes + ", situacao=" + situacao + ", parecer="
				+ parecer + "]";
	}

}