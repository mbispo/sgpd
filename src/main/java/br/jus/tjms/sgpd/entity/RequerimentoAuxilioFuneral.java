package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoRequerimentoAuxilioFuneral;
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
public class RequerimentoAuxilioFuneral implements Serializable {

	private static final long serialVersionUID = 231298526465649477L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="solicitante_id", nullable = false)
	private Pessoa solicitante;
	
	@ManyToOne
	@JoinColumn(name="funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	private Date dataObito;
	private Date dataRequerimento;
	
	@Column(length = 60)
	private String processo;
	
	private Date dataSituacao;
	
	@Enumerated(EnumType.ORDINAL)
	private SituacaoRequerimentoAuxilioFuneral situacao;
	
	@Column(length = 500)
	private String parecer;

	public RequerimentoAuxilioFuneral() {
		super();
	}

	public RequerimentoAuxilioFuneral(Long id, Pessoa solicitante, Funcionario funcionario, Date dataObito,
			Date dataRequerimento, String processo, Date dataSituacao, SituacaoRequerimentoAuxilioFuneral situacao,
			String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.funcionario = funcionario;
		this.dataObito = dataObito;
		this.dataRequerimento = dataRequerimento;
		this.processo = processo;
		this.dataSituacao = dataSituacao;
		this.situacao = situacao;
		this.parecer = parecer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataObito() {
		return dataObito;
	}

	public void setDataObito(Date dataObito) {
		this.dataObito = dataObito;
	}

	public Date getDataRequerimento() {
		return dataRequerimento;
	}

	public void setDataRequerimento(Date dataRequerimento) {
		this.dataRequerimento = dataRequerimento;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoRequerimentoAuxilioFuneral getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoRequerimentoAuxilioFuneral situacao) {
		this.situacao = situacao;
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
		RequerimentoAuxilioFuneral other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	@Override
	public String toString() {
		return "RequerimentoAuxilioFuneral [id=" + id + ", solicitante=" + solicitante + ", funcionario=" + funcionario
				+ ", dataObito=" + dataObito + ", dataRequerimento=" + dataRequerimento + ", processo=" + processo
				+ ", dataSituacao=" + dataSituacao + ", situacao=" + situacao + ", parecer=" + parecer + "]";
	}

}