package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoReversao;
import br.jus.tjms.sgpd.enumerators.TipoReversao;
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
public class SolicitacaoReversao implements Serializable {

	private static final long serialVersionUID = -8250994440035084383L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@Column(length = 60)
	private String processo;

	@Enumerated(EnumType.ORDINAL)
	private TipoReversao tipoReversao;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoReversao situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoReversao() {
		super();
	}

	public SolicitacaoReversao(Long id, Funcionario funcionario, Funcionario solicitante, String processo,
			TipoReversao tipoReversao, SituacaoSolicitacaoReversao situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.solicitante = solicitante;
		this.processo = processo;
		this.tipoReversao = tipoReversao;
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

	public Funcionario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Funcionario solicitante) {
		this.solicitante = solicitante;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public TipoReversao getTipoReversao() {
		return tipoReversao;
	}

	public void setTipoReversao(TipoReversao tipoReversao) {
		this.tipoReversao = tipoReversao;
	}

	public SituacaoSolicitacaoReversao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoReversao situacao) {
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
		SolicitacaoReversao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoReversao [id=" + id + ", funcionario=" + funcionario + ", solicitante=" + solicitante
				+ ", processo=" + processo + ", tipoReversao=" + tipoReversao + ", situacao=" + situacao
				+ ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}