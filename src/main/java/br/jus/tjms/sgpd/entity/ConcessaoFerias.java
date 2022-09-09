package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.FeriasParcela;
import br.jus.tjms.sgpd.enumerators.SituacaoConcessaoFerias;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class ConcessaoFerias implements Serializable {

	private static final long serialVersionUID = -1824353197123089849L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoFerias solicitacao;

	@ManyToOne
	@JoinColumn(name = "autorizador_id", nullable = false)
	private Funcionario autorizador;

	@ManyToOne
	@JoinColumn(name = "aquisicao_id", nullable = false)
	private AquisicaoFerias aquisicao;

	private Date dataAutorizacao;

	@Enumerated(EnumType.ORDINAL)
	private FeriasParcela parcela;

	private Integer numeroDias;
	private Date dataInicio;
	private Date dataFim;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoConcessaoFerias situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public ConcessaoFerias() {
		super();
	}

	public ConcessaoFerias(Long id, SolicitacaoFerias solicitacao, Funcionario autorizador, AquisicaoFerias aquisicao,
			Date dataAutorizacao, FeriasParcela parcela, Integer numeroDias, Date dataInicio, Date dataFim,
			SituacaoConcessaoFerias situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.autorizador = autorizador;
		this.aquisicao = aquisicao;
		this.dataAutorizacao = dataAutorizacao;
		this.parcela = parcela;
		this.numeroDias = numeroDias;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
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

	public SolicitacaoFerias getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoFerias solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Funcionario getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(Funcionario autorizador) {
		this.autorizador = autorizador;
	}

	public AquisicaoFerias getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(AquisicaoFerias aquisicao) {
		this.aquisicao = aquisicao;
	}

	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}

	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}

	public FeriasParcela getParcela() {
		return parcela;
	}

	public void setParcela(FeriasParcela parcela) {
		this.parcela = parcela;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public SituacaoConcessaoFerias getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoConcessaoFerias situacao) {
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
		ConcessaoFerias other = (ConcessaoFerias) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcessaoFerias [id=" + id + ", solicitacao=" + solicitacao + ", autorizador=" + autorizador
				+ ", aquisicao=" + aquisicao + ", parcela=" + parcela + ", numeroDias=" + numeroDias + ", situacao="
				+ situacao + ", parecer=" + parecer + "]";
	}

}