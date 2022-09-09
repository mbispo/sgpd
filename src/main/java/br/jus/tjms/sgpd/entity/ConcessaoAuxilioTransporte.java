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
public class ConcessaoAuxilioTransporte implements Serializable {

	private static final long serialVersionUID = -3601665128789553806L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "requerimento_id", nullable = true)
	private RequerimentoAuxilioTransporte requerimento;

	@ManyToOne
	@JoinColumn(name = "beneficiario_id", nullable = false)
	private Funcionario beneficiario;

	private Date dataConcessao;
	private Integer numeroPasses;
	private Date dataInicio;
	private Date dataTermino;

	@ManyToOne
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;

	public ConcessaoAuxilioTransporte() {
		super();
	}

	public ConcessaoAuxilioTransporte(Long id, RequerimentoAuxilioTransporte requerimento, Funcionario beneficiario,
			Date dataConcessao, Integer numeroPasses, Date dataInicio, Date dataTermino, Endereco endereco) {
		super();
		this.id = id;
		this.requerimento = requerimento;
		this.beneficiario = beneficiario;
		this.dataConcessao = dataConcessao;
		this.numeroPasses = numeroPasses;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Funcionario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Date getDataConcessao() {
		return dataConcessao;
	}

	public void setDataConcessao(Date dataConcessao) {
		this.dataConcessao = dataConcessao;
	}

	public Integer getNumeroPasses() {
		return numeroPasses;
	}

	public void setNumeroPasses(Integer numeroPasses) {
		this.numeroPasses = numeroPasses;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public RequerimentoAuxilioTransporte getRequerimento() {
		return requerimento;
	}

	public void setRequerimento(RequerimentoAuxilioTransporte requerimento) {
		this.requerimento = requerimento;
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
		ConcessaoAuxilioTransporte other = (ConcessaoAuxilioTransporte) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ConcessaoAuxilioTransporte [id=" + id + ", requerimento=" + requerimento + ", beneficiario="
				+ beneficiario + ", dataConcessao=" + dataConcessao + ", numeroPasses=" + numeroPasses
				+ ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", endereco=" + endereco + "]";
	}

}