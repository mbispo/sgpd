package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.FeriasParcela;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoFerias;
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
public class SolicitacaoFerias implements Serializable {

	private static final long serialVersionUID = 1596113620618701824L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@ManyToOne
	@JoinColumn(name = "aquisicao_id", nullable = false)
	private AquisicaoFerias aquisicao;

	private Date data;

	@Enumerated(EnumType.ORDINAL)
	private FeriasParcela parcela;

	private Integer numeroDias;
	private Date dataInicio;
	private Date dataFim;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoFerias situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoFerias() {
		super();
	}

	public SolicitacaoFerias(Long id, Funcionario solicitante, AquisicaoFerias aquisicao, Date data,
			FeriasParcela parcela, Integer numeroDias, Date dataInicio, Date dataFim,
			SituacaoSolicitacaoFerias situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.aquisicao = aquisicao;
		this.data = data;
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

	public Funcionario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Funcionario solicitante) {
		this.solicitante = solicitante;
	}

	public AquisicaoFerias getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(AquisicaoFerias aquisicao) {
		this.aquisicao = aquisicao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public SituacaoSolicitacaoFerias getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoFerias situacao) {
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
		SolicitacaoFerias other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoFerias [id=" + id + ", solicitante=" + solicitante + ", aquisicao=" + aquisicao + ", data="
				+ data + ", parcela=" + parcela + ", numeroDias=" + numeroDias + ", dataInicio=" + dataInicio
				+ ", dataFim=" + dataFim + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer="
				+ parecer + "]";
	}

}