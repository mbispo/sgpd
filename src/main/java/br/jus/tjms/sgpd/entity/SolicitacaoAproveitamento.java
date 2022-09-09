package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoAproveitamento;
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
public class SolicitacaoAproveitamento implements Serializable {

	private static final long serialVersionUID = -8472197499725236312L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@ManyToOne
	@JoinColumn(name = "solicitado_id", nullable = false)
	private Funcionario solicitado;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoAproveitamento situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoAproveitamento() {
		super();
	}

	public SolicitacaoAproveitamento(Long id, Funcionario solicitante, Funcionario solicitado,
			SituacaoSolicitacaoAproveitamento situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.solicitado = solicitado;
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

	public SituacaoSolicitacaoAproveitamento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoAproveitamento situacao) {
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
		SolicitacaoAproveitamento other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoAproveitamento [id=" + id + ", solicitante=" + solicitante + ", solicitado=" + solicitado
				+ ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}