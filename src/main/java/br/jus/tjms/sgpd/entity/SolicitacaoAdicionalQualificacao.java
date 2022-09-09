package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoAdicionalQualificacao;
import br.jus.tjms.sgpd.enumerators.TipoFormacaoAcademica;
import br.jus.tjms.sgpd.service.rest.v1.to.AdicionalQualificacaoTO;
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
public class SolicitacaoAdicionalQualificacao implements Serializable {

	private static final long serialVersionUID = 8197502510331226817L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date dataSolicitacao;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@Column(length = 255)
	private String instituicaoEnsino;

	private Integer anoInicio;
	private Integer anoConclusao;

	@Enumerated(EnumType.ORDINAL)
	private TipoFormacaoAcademica tipoFormacaoAcademica;

	@Column(length = 500)
	private String observacoes;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoAdicionalQualificacao situacao;
	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoAdicionalQualificacao() {
		super();
	}

	public SolicitacaoAdicionalQualificacao(Long id, Date dataSolicitacao, Funcionario funcionario,
			String instituicaoEnsino, Integer anoInicio, Integer anoConclusao,
			TipoFormacaoAcademica tipoFormacaoAcademica, String observacoes,
			SituacaoSolicitacaoAdicionalQualificacao situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.dataSolicitacao = dataSolicitacao;
		this.funcionario = funcionario;
		this.instituicaoEnsino = instituicaoEnsino;
		this.anoInicio = anoInicio;
		this.anoConclusao = anoConclusao;
		this.tipoFormacaoAcademica = tipoFormacaoAcademica;
		this.observacoes = observacoes;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
	}
	
	public SolicitacaoAdicionalQualificacao(Date dataSolicitacao, Funcionario funcionario) {
		super();
		this.dataSolicitacao = dataSolicitacao;
		this.funcionario = funcionario;
	}

	public SolicitacaoAdicionalQualificacao(AdicionalQualificacaoTO adicionalQualificacaoTO) {
		this.dataSolicitacao = adicionalQualificacaoTO.getDataSolicitacao();
		this.dataSituacao = adicionalQualificacaoTO.getDataSituacao();
		this.funcionario = new Funcionario(adicionalQualificacaoTO.getIdFuncionario());
		this.situacao = adicionalQualificacaoTO.getSituacao();
		this.observacoes = adicionalQualificacaoTO.getObservacoes();
	}
	
	public void alterar(AdicionalQualificacaoTO adicionalQualificacaoTO) {
		this.dataSolicitacao = adicionalQualificacaoTO.getDataSolicitacao();
		this.dataSituacao = adicionalQualificacaoTO.getDataSituacao();
		this.funcionario = new Funcionario(adicionalQualificacaoTO.getIdFuncionario());
		this.situacao = adicionalQualificacaoTO.getSituacao();
		this.observacoes = adicionalQualificacaoTO.getObservacoes();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public Integer getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(Integer anoInicio) {
		this.anoInicio = anoInicio;
	}

	public Integer getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(Integer anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public TipoFormacaoAcademica getTipoFormacaoAcademica() {
		return tipoFormacaoAcademica;
	}

	public void setTipoFormacaoAcademica(TipoFormacaoAcademica tipoFormacaoAcademica) {
		this.tipoFormacaoAcademica = tipoFormacaoAcademica;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public SituacaoSolicitacaoAdicionalQualificacao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoAdicionalQualificacao situacao) {
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
		SolicitacaoAdicionalQualificacao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoAdicionalQualificacao [id=" + id + ", dataSolicitacao=" + dataSolicitacao + ", funcionario="
				+ funcionario + ", instituicaoEnsino=" + instituicaoEnsino + ", anoInicio=" + anoInicio
				+ ", anoConclusao=" + anoConclusao + ", tipoFormacaoAcademica=" + tipoFormacaoAcademica
				+ ", observacoes=" + observacoes + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao
				+ ", parecer=" + parecer + "]";
	}

}