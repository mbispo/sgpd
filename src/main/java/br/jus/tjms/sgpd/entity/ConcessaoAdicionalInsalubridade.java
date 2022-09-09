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
public class ConcessaoAdicionalInsalubridade implements Serializable {

	private static final long serialVersionUID = -2582432884844631676L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoAdicionalInsalubridade solicitacao;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	private Date dataEfeito;

	private Double percentual;

	public ConcessaoAdicionalInsalubridade() {
		super();

	}

	public ConcessaoAdicionalInsalubridade(Long id, Funcionario funcionario,
			SolicitacaoAdicionalInsalubridade solicitacao, FuncionarioCargo funcionarioCargo,
			AtoAdministrativo atoAdministrativo, Date dataEfeito, Double percentual) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.solicitacao = solicitacao;
		this.funcionarioCargo = funcionarioCargo;
		this.atoAdministrativo = atoAdministrativo;
		this.dataEfeito = dataEfeito;
		this.percentual = percentual;
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

	public SolicitacaoAdicionalInsalubridade getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoAdicionalInsalubridade solicitacao) {
		this.solicitacao = solicitacao;
	}

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
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
		ConcessaoAdicionalInsalubridade other = (ConcessaoAdicionalInsalubridade) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcessaoAdicionalInsalubridade [id=" + id + ", funcionario=" + funcionario + ", solicitacao="
				+ solicitacao + ", funcionarioCargo=" + funcionarioCargo + ", atoAdministrativo=" + atoAdministrativo
				+ ", percentual=" + percentual + "]";
	}

}