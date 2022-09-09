package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoAprovacaoEmprestimoConsignado;
import br.jus.tjms.sgpd.service.rest.v1.to.AprovacaoEmprestimoConsignadoTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "aprovacaoEmprestimoConsignado.buscarAprovacoesPorFuncionario",
			query = "SELECT a FROM AprovacaoEmprestimoConsignado a WHERE a.funcionario.id = :funcionarioId")
})
public class AprovacaoEmprestimoConsignado implements Serializable {

	private static final long serialVersionUID = -7884045788060042714L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "simulacao_id", nullable = false)
	private SimulacaoEmprestimoConsignado simulacao;

	private Date dataAprovacao;

	@Column(length = 500)
	private String observacoes;

	private Date dataSituacao;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoAprovacaoEmprestimoConsignado situacao;

	private Boolean notificacaoPendente;

	public AprovacaoEmprestimoConsignado() {
		super();
	}

	public AprovacaoEmprestimoConsignado(Long id, Funcionario funcionario, SimulacaoEmprestimoConsignado simulacao,
			Date dataAprovacao, String observacoes, Date dataSituacao, SituacaoAprovacaoEmprestimoConsignado situacao,
			Boolean notificacaoPendente) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.simulacao = simulacao;
		this.dataAprovacao = dataAprovacao;
		this.observacoes = observacoes;
		this.dataSituacao = dataSituacao;
		this.situacao = situacao;
		this.notificacaoPendente = notificacaoPendente;
	}

	public AprovacaoEmprestimoConsignado(AprovacaoEmprestimoConsignadoTO aprovacaoEmprestimoConsignadoTO) {
		//FIXME this.funcionario = aprovacaoEmprestimoConsignadoTO.getFuncionarioId();
		//FIXME this.simulacao = aprovacaoEmprestimoConsignadoTO.getSimulacaoEmprestimoConsignadoId();
		this.dataAprovacao = aprovacaoEmprestimoConsignadoTO.getDataAprovacao();
		this.observacoes = aprovacaoEmprestimoConsignadoTO.getObservacoes();
		this.dataSituacao = aprovacaoEmprestimoConsignadoTO.getDataSituacao();
		this.situacao = aprovacaoEmprestimoConsignadoTO.getSituacao();
		this.notificacaoPendente = aprovacaoEmprestimoConsignadoTO.getNotificacaoPendente();
	}

	public Long getId() {
		return id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public SimulacaoEmprestimoConsignado getSimulacao() {
		return simulacao;
	}

	public void setSimulacao(SimulacaoEmprestimoConsignado simulacao) {
		this.simulacao = simulacao;
	}

	public Date getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(Date dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoAprovacaoEmprestimoConsignado getSituacao() {
		return situacao;
	}

	public Boolean getNotificacaoPendente() {
		return notificacaoPendente;
	}

	public void setNotificacaoPendente(Boolean notificacaoPendente) {
		this.notificacaoPendente = notificacaoPendente;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AprovacaoEmprestimoConsignado that = (AprovacaoEmprestimoConsignado) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(simulacao, that.simulacao) &&
                Objects.equals(dataAprovacao, that.dataAprovacao) &&
                Objects.equals(observacoes, that.observacoes) &&
                Objects.equals(dataSituacao, that.dataSituacao) &&
                situacao == that.situacao &&
                Objects.equals(notificacaoPendente, that.notificacaoPendente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, funcionario, simulacao, dataAprovacao, observacoes, dataSituacao, situacao, notificacaoPendente);
    }

    @Override
	public String toString() {
		return "AprovacaoEmprestimoConsignado [id=" + id + ", funcionario=" + funcionario + ", simulacao=" + simulacao
				+ ", dataAprovacao=" + dataAprovacao + ", observacoes=" + observacoes + ", dataSituacao="
				+ dataSituacao + ", situacao=" + situacao + ", notificacaoPendente=" + notificacaoPendente + "]";
	}
	
	public void alterar(AprovacaoEmprestimoConsignadoTO aprovacaoEmprestimoConsignadoTO) {
		//FIXME this.funcionario = aprovacaoEmprestimoConsignadoTO.getFuncionarioId();
		//FIXME this.simulacao = aprovacaoEmprestimoConsignadoTO.getSimulacaoEmprestimoConsignadoId();
		this.dataAprovacao = aprovacaoEmprestimoConsignadoTO.getDataAprovacao();
		this.observacoes = aprovacaoEmprestimoConsignadoTO.getObservacoes();
		this.dataSituacao = aprovacaoEmprestimoConsignadoTO.getDataSituacao();
		this.situacao = aprovacaoEmprestimoConsignadoTO.getSituacao();
		this.notificacaoPendente = aprovacaoEmprestimoConsignadoTO.getNotificacaoPendente();
	}

	public void averbar(String observacoes) {
		this.observacoes = observacoes;
		this.situacao = SituacaoAprovacaoEmprestimoConsignado.AVERBADO;
	}

	public void indeferir(String observacoes) {
		this.observacoes = observacoes;
		this.situacao = SituacaoAprovacaoEmprestimoConsignado.INDEFERIDO;
	}

	public void definirSituacaoAprovacaoEmprestimoConsignado(String observacoes,
			SituacaoAprovacaoEmprestimoConsignado situacao) {
		this.observacoes = observacoes;
		this.situacao = situacao;
	}

}