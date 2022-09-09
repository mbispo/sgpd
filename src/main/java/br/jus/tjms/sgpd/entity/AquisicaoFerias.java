package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Cacheable;
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
import br.jus.tjms.sgpd.enumerators.MotivoFechamentoAquisicaoFerias;
import br.jus.tjms.sgpd.enumerators.SituacaoAquisicaoFerias;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AquisicaoFerias implements Serializable {

	private static final long serialVersionUID = -6894189924274576451L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Date fimPeriodoAquisitivo;
	private Date inicioPeriodoAquisitivo;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoAquisicaoFerias situacao;

	private Integer numeroDias;
	private Integer numeroDiasIndenizados;
	private Integer numeroDiasUtilizados;
	private Integer numeroDiasDisponiveis;

	@Enumerated(EnumType.ORDINAL)
	private MotivoFechamentoAquisicaoFerias motivoFechamento;

	public AquisicaoFerias() {
		super();
	}

    public AquisicaoFerias(Long id, Funcionario funcionario, Date fimPeriodoAquisitivo, Date inicioPeriodoAquisitivo,
                           SituacaoAquisicaoFerias situacao, Integer numeroDias, Integer numeroDiasIndenizados,
                           Integer numeroDiasUtilizados, Integer numeroDiasDisponiveis,
                           MotivoFechamentoAquisicaoFerias motivoFechamento) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.fimPeriodoAquisitivo = fimPeriodoAquisitivo;
		this.inicioPeriodoAquisitivo = inicioPeriodoAquisitivo;
		this.situacao = situacao;
		this.numeroDias = numeroDias;
		this.numeroDiasIndenizados = numeroDiasIndenizados;
		this.numeroDiasUtilizados = numeroDiasUtilizados;
		this.numeroDiasDisponiveis = numeroDiasDisponiveis;
		this.motivoFechamento = motivoFechamento;
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

	public Date getFimPeriodoAquisitivo() {
		return fimPeriodoAquisitivo;
	}

	public void setFimPeriodoAquisitivo(Date fimPeriodoAquisitivo) {
		this.fimPeriodoAquisitivo = fimPeriodoAquisitivo;
	}

	public Date getInicioPeriodoAquisitivo() {
		return inicioPeriodoAquisitivo;
	}

	public void setInicioPeriodoAquisitivo(Date inicioPeriodoAquisitivo) {
		this.inicioPeriodoAquisitivo = inicioPeriodoAquisitivo;
	}

	public SituacaoAquisicaoFerias getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAquisicaoFerias situacao) {
		this.situacao = situacao;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Integer getNumeroDiasIndenizados() {
		return numeroDiasIndenizados;
	}

	public void setNumeroDiasIndenizados(Integer numeroDiasIndenizados) {
		this.numeroDiasIndenizados = numeroDiasIndenizados;
	}

	public Integer getNumeroDiasUtilizados() {
		return numeroDiasUtilizados;
	}

	public void setNumeroDiasUtilizados(Integer numeroDiasUtilizados) {
		this.numeroDiasUtilizados = numeroDiasUtilizados;
	}

	public Integer getNumeroDiasDisponiveis() {
		return numeroDiasDisponiveis;
	}

	public void setNumeroDiasDisponiveis(Integer numeroDiasDisponiveis) {
		this.numeroDiasDisponiveis = numeroDiasDisponiveis;
	}

	public MotivoFechamentoAquisicaoFerias getMotivoFechamento() {
		return motivoFechamento;
	}

	public void setMotivoFechamento(MotivoFechamentoAquisicaoFerias motivoFechamento) {
		this.motivoFechamento = motivoFechamento;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AquisicaoFerias that = (AquisicaoFerias) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(fimPeriodoAquisitivo, that.fimPeriodoAquisitivo) &&
                Objects.equals(inicioPeriodoAquisitivo, that.inicioPeriodoAquisitivo) &&
                situacao == that.situacao &&
                Objects.equals(numeroDias, that.numeroDias) &&
                Objects.equals(numeroDiasIndenizados, that.numeroDiasIndenizados) &&
                Objects.equals(numeroDiasUtilizados, that.numeroDiasUtilizados) &&
                Objects.equals(numeroDiasDisponiveis, that.numeroDiasDisponiveis) &&
                motivoFechamento == that.motivoFechamento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, funcionario, fimPeriodoAquisitivo, inicioPeriodoAquisitivo, situacao, numeroDias, numeroDiasIndenizados, numeroDiasUtilizados, numeroDiasDisponiveis, motivoFechamento);
    }

    @Override
	public String toString() {
		return "AquisicaoFerias [id=" + id + ", funcionario=" + funcionario + ", situacao=" + situacao
				+ ", numeroDias=" + numeroDias + ", numeroDiasIndenizados=" + numeroDiasIndenizados
				+ ", numeroDiasUtilizados=" + numeroDiasUtilizados + ", numeroDiasDisponiveis=" + numeroDiasDisponiveis
				+ ", motivoFechamento=" + motivoFechamento + "]";
	}

}