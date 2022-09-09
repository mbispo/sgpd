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
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
public class RequerimentoCancelamentoAuxilioEducacaoInfantil implements Serializable {

	private static final long serialVersionUID = 1147292772529722476L;

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

	@Column(length = 500)
	private String observacoes;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoRequerimentoAuxilioEducacaoInfantil situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public RequerimentoCancelamentoAuxilioEducacaoInfantil() {
		super();
	}

	public RequerimentoCancelamentoAuxilioEducacaoInfantil(Long id, Funcionario funcionario,
			ConcessaoAuxilioEducacaoInfantil concessao, Date data, String observacoes,
			SituacaoRequerimentoAuxilioEducacaoInfantil situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.concessao = concessao;
		this.data = data;
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
		RequerimentoCancelamentoAuxilioEducacaoInfantil other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RequerimentoCancelamentoAuxilioEducacaoInfantil [id=" + id + ", funcionario=" + funcionario
				+ ", concessao=" + concessao + ", data=" + data + ", observacoes=" + observacoes + ", situacao="
				+ situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}