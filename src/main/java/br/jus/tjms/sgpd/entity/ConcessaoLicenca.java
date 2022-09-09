package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoConcessaoLicenca;
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
public class ConcessaoLicenca implements Serializable {

	private static final long serialVersionUID = -8085782494990894697L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoLicenca solicitacao;

	@ManyToOne
	@JoinColumn(name = "autorizador_id", nullable = false)
	private Funcionario autorizador;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	private Date dataConcessao;
	private Integer numeroDias;
	private Date dataInicio;
	private Date dataFim;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoConcessaoLicenca situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public ConcessaoLicenca() {
		super();
	}

	public ConcessaoLicenca(Long id, SolicitacaoLicenca solicitacao, Funcionario autorizador,
			AtoAdministrativo atoAdministrativo, Date dataConcessao, Integer numeroDias, Date dataInicio, Date dataFim,
			SituacaoConcessaoLicenca situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.autorizador = autorizador;
		this.atoAdministrativo = atoAdministrativo;
		this.dataConcessao = dataConcessao;
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

	public SolicitacaoLicenca getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoLicenca solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Funcionario getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(Funcionario autorizador) {
		this.autorizador = autorizador;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public Date getDataConcessao() {
		return dataConcessao;
	}

	public void setDataConcessao(Date dataConcessao) {
		this.dataConcessao = dataConcessao;
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

	public SituacaoConcessaoLicenca getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoConcessaoLicenca situacao) {
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
		ConcessaoLicenca other = (ConcessaoLicenca) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcessaoLicenca [id=" + id + ", solicitacao=" + solicitacao + ", autorizador=" + autorizador
				+ ", atoAdministrativo=" + atoAdministrativo + ", numeroDias=" + numeroDias + ", situacao=" + situacao
				+ ", parecer=" + parecer + "]";
	}

}