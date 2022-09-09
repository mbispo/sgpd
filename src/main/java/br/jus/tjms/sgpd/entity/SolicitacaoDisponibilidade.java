package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoDisponibilidade;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:04
 */
@Entity
@Auditavel
@Cacheable
public class SolicitacaoDisponibilidade implements Serializable {

	private static final long serialVersionUID = -335794152145694340L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@ManyToOne
	@JoinColumn(name = "solicitado_id", nullable = false)
	private Funcionario solicitado;

	private Integer numeroDias;
	private Boolean prorrogacao;

	@ManyToOne
	@JoinColumn(name = "disponibilidadeProrrogada_id", nullable = true)
	private Disponibilidade disponibilidadeProrrogada;

	@Column(length = 500)
	private String motivo;

	@Column(length = 60)
	private String processo;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoDisponibilidade situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoDisponibilidade() {
		super();
	}

	public SolicitacaoDisponibilidade(Long id, Funcionario solicitante, Funcionario solicitado, Integer numeroDias,
			Boolean prorrogacao, Disponibilidade disponibilidadeProrrogada, String motivo, String processo,
			SituacaoSolicitacaoDisponibilidade situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.solicitado = solicitado;
		this.numeroDias = numeroDias;
		this.prorrogacao = prorrogacao;
		this.disponibilidadeProrrogada = disponibilidadeProrrogada;
		this.motivo = motivo;
		this.processo = processo;
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

	public Funcionario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Funcionario solicitante) {
		this.solicitante = solicitante;
	}

	public Funcionario getSolicitado() {
		return solicitado;
	}

	public void setSolicitado(Funcionario solicitado) {
		this.solicitado = solicitado;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Boolean getProrrogacao() {
		return prorrogacao;
	}

	public void setProrrogacao(Boolean prorrogacao) {
		this.prorrogacao = prorrogacao;
	}

	public Disponibilidade getDisponibilidadeProrrogada() {
		return disponibilidadeProrrogada;
	}

	public void setDisponibilidadeProrrogada(Disponibilidade disponibilidadeProrrogada) {
		this.disponibilidadeProrrogada = disponibilidadeProrrogada;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public SituacaoSolicitacaoDisponibilidade getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoDisponibilidade situacao) {
		this.situacao = situacao;
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
		SolicitacaoDisponibilidade other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoDisponibilidade [id=" + id + ", solicitante=" + solicitante + ", solicitado=" + solicitado
				+ ", numeroDias=" + numeroDias + ", prorrogacao=" + prorrogacao + ", disponibilidadeProrrogada="
				+ disponibilidadeProrrogada + ", motivo=" + motivo + ", processo=" + processo + ", situacao="
				+ situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}