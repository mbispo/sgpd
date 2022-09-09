package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoCancelamentoFerias;
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
public class SolicitacaoCancelamentoFerias implements Serializable {

	private static final long serialVersionUID = -6805171769227644173L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@ManyToOne
	@JoinColumn(name = "concessaoFerias_id", nullable = false)
	private ConcessaoFerias concessaoFerias;

	private Date data;

	@Column(length = 500)
	private String motivo;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoCancelamentoFerias situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoCancelamentoFerias() {
		super();
	}

	public SolicitacaoCancelamentoFerias(Long id, Funcionario solicitante, ConcessaoFerias concessaoFerias, Date data,
			String motivo, SituacaoSolicitacaoCancelamentoFerias situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.concessaoFerias = concessaoFerias;
		this.data = data;
		this.motivo = motivo;
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

	public ConcessaoFerias getConcessaoFerias() {
		return concessaoFerias;
	}

	public void setConcessaoFerias(ConcessaoFerias concessaoFerias) {
		this.concessaoFerias = concessaoFerias;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public SituacaoSolicitacaoCancelamentoFerias getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoCancelamentoFerias situacao) {
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
		SolicitacaoCancelamentoFerias other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoCancelamentoFerias [id=" + id + ", solicitante=" + solicitante + ", concessaoFerias="
				+ concessaoFerias + ", data=" + data + ", motivo=" + motivo + ", situacao=" + situacao
				+ ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}