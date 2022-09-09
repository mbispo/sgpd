package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
public class ConcessaoAdicionalQualificacao implements Serializable {

	private static final long serialVersionUID = 702678986952745943L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoAdicionalQualificacao solicitacao;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "pessoaFormacao_id", nullable = false)
	private PessoaFormacao pessoaFormacao;

	@Column(length = 60)
	private String processo;

	private Double percentual;
	private Date data;
	private Date dataEfeito;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	private Boolean pagamentoConfigurado;

	public ConcessaoAdicionalQualificacao() {
		super();

	}

	public ConcessaoAdicionalQualificacao(Long id, SolicitacaoAdicionalQualificacao solicitacao,
			Funcionario funcionario, PessoaFormacao pessoaFormacao, String processo, Double percentual, Date data,
			Date dataEfeito, AtoAdministrativo atoAdministrativo, Boolean pagamentoConfigurado) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.funcionario = funcionario;
		this.pessoaFormacao = pessoaFormacao;
		this.processo = processo;
		this.percentual = percentual;
		this.data = data;
		this.dataEfeito = dataEfeito;
		this.atoAdministrativo = atoAdministrativo;
		this.pagamentoConfigurado = pagamentoConfigurado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SolicitacaoAdicionalQualificacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoAdicionalQualificacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public PessoaFormacao getPessoaFormacao() {
		return pessoaFormacao;
	}

	public void setPessoaFormacao(PessoaFormacao pessoaFormacao) {
		this.pessoaFormacao = pessoaFormacao;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public Boolean getPagamentoConfigurado() {
		return pagamentoConfigurado;
	}

	public void setPagamentoConfigurado(Boolean pagamentoConfigurado) {
		this.pagamentoConfigurado = pagamentoConfigurado;
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
		ConcessaoAdicionalQualificacao other = (ConcessaoAdicionalQualificacao) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcessaoAdicionalQualificacao [id=" + id + ", solicitacao=" + solicitacao + ", funcionario="
				+ funcionario + ", pessoaFormacao=" + pessoaFormacao + ", processo=" + processo + ", percentual="
				+ percentual + ", atoAdministrativo=" + atoAdministrativo + ", pagamentoConfigurado="
				+ pagamentoConfigurado + "]";
	}

}