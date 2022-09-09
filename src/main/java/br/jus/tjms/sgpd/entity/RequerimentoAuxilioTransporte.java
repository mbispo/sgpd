package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoRequerimentoAuxilioTransporte;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
public class RequerimentoAuxilioTransporte implements Serializable {

	private static final long serialVersionUID = -5441327137035244962L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "requerente_id", nullable = false)
	private Funcionario requerente;

	private Date dataRequerimento;
	private Integer numeroPasses;
	private Date dataInicio;
	private Date dataTermino;

	@ManyToOne
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoRequerimentoAuxilioTransporte situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public RequerimentoAuxilioTransporte() {
		super();
	}

	public RequerimentoAuxilioTransporte(Long id, Funcionario requerente, Date dataRequerimento, Integer numeroPasses,
			Date dataInicio, Date dataTermino, Endereco endereco, SituacaoRequerimentoAuxilioTransporte situacao,
			Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.requerente = requerente;
		this.dataRequerimento = dataRequerimento;
		this.numeroPasses = numeroPasses;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.endereco = endereco;
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

	public Funcionario getRequerente() {
		return requerente;
	}

	public void setRequerente(Funcionario requerente) {
		this.requerente = requerente;
	}

	public Date getDataRequerimento() {
		return dataRequerimento;
	}

	public void setDataRequerimento(Date dataRequerimento) {
		this.dataRequerimento = dataRequerimento;
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

	public SituacaoRequerimentoAuxilioTransporte getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoRequerimentoAuxilioTransporte situacao) {
		this.situacao = situacao;
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
		RequerimentoAuxilioTransporte other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RequerimentoAuxilioTransporte [id=" + id + ", requerente=" + requerente + ", dataRequerimento="
				+ dataRequerimento + ", numeroPasses=" + numeroPasses + ", dataInicio=" + dataInicio + ", dataTermino="
				+ dataTermino + ", endereco=" + endereco + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao
				+ ", parecer=" + parecer + "]";
	}

}