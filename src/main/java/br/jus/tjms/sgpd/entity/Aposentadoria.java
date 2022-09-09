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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoAposentadoria;
import br.jus.tjms.sgpd.enumerators.TipoAposentadoria;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class Aposentadoria implements Serializable {

	private static final long serialVersionUID = -2638584976545655141L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoAposentadoria solicitacao;

	@Enumerated(EnumType.ORDINAL)
	private TipoAposentadoria tipoAposentadoria;

	private Date dataEfeito;
	private Boolean paridade;
	private Date dataConcessaoParidade;
	private Double percentual;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoAposentadoria situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public Aposentadoria() {
		super();
	}

	public Aposentadoria(Long id, Funcionario funcionario, FuncionarioCargo funcionarioCargo,
			SolicitacaoAposentadoria solicitacao, TipoAposentadoria tipoAposentadoria, Date dataEfeito,
			Boolean paridade, Date dataConcessaoParidade, Double percentual, AtoAdministrativo atoAdministrativo,
			SituacaoAposentadoria situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.funcionarioCargo = funcionarioCargo;
		this.solicitacao = solicitacao;
		this.tipoAposentadoria = tipoAposentadoria;
		this.dataEfeito = dataEfeito;
		this.paridade = paridade;
		this.dataConcessaoParidade = dataConcessaoParidade;
		this.percentual = percentual;
		this.atoAdministrativo = atoAdministrativo;
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

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public SolicitacaoAposentadoria getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoAposentadoria solicitacao) {
		this.solicitacao = solicitacao;
	}

	public TipoAposentadoria getTipoAposentadoria() {
		return tipoAposentadoria;
	}

	public void setTipoAposentadoria(TipoAposentadoria tipoAposentadoria) {
		this.tipoAposentadoria = tipoAposentadoria;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public Boolean getParidade() {
		return paridade;
	}

	public void setParidade(Boolean paridade) {
		this.paridade = paridade;
	}

	public Date getDataConcessaoParidade() {
		return dataConcessaoParidade;
	}

	public void setDataConcessaoParidade(Date dataConcessaoParidade) {
		this.dataConcessaoParidade = dataConcessaoParidade;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public SituacaoAposentadoria getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAposentadoria situacao) {
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
	public String toString() {
		return "Aposentadoria [id=" + id + ", funcionario=" + funcionario + ", funcionarioCargo=" + funcionarioCargo
				+ ", solicitacao=" + solicitacao + ", tipoAposentadoria=" + tipoAposentadoria + ", dataEfeito="
				+ dataEfeito + ", paridade=" + paridade + ", dataConcessaoParidade=" + dataConcessaoParidade
				+ ", percentual=" + percentual + ", atoAdministrativo=" + atoAdministrativo + ", situacao=" + situacao
				+ ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aposentadoria that = (Aposentadoria) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(funcionarioCargo, that.funcionarioCargo) &&
                Objects.equals(solicitacao, that.solicitacao) &&
                tipoAposentadoria == that.tipoAposentadoria &&
                Objects.equals(dataEfeito, that.dataEfeito) &&
                Objects.equals(paridade, that.paridade) &&
                Objects.equals(dataConcessaoParidade, that.dataConcessaoParidade) &&
                Objects.equals(percentual, that.percentual) &&
                Objects.equals(atoAdministrativo, that.atoAdministrativo) &&
                situacao == that.situacao &&
                Objects.equals(dataSituacao, that.dataSituacao) &&
                Objects.equals(parecer, that.parecer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, funcionario, funcionarioCargo, solicitacao, tipoAposentadoria, dataEfeito, paridade, dataConcessaoParidade, percentual, atoAdministrativo, situacao, dataSituacao, parecer);
    }
}