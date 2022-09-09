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
import br.jus.tjms.sgpd.enumerators.FormaProvimento;
import br.jus.tjms.sgpd.enumerators.SituacaoAproveitamento;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class Aproveitamento implements Serializable {

	private static final long serialVersionUID = -3405997151650299384L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargoArea_id", nullable = false)
	private CargoArea cargoArea;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "solicitacai_id", nullable = true)
	private SolicitacaoAproveitamento solicitacao;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	private Date dataEfeito;
	private Date dataAproveitamento;
	private Date dataLimiteInicioExercicio;

	@Enumerated(EnumType.ORDINAL)
	private FormaProvimento formaProvimento;

	private RegimeJuridico regimeJuridico;

	@Enumerated(EnumType.ORDINAL)
	private TipoProvimento tipoProvimento;

	private RegimePrevidencia regimePrevidencia;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoAproveitamento situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public Aproveitamento() {
		super();
	}

	public Aproveitamento(Long id, CargoArea cargoArea, Funcionario funcionario, SolicitacaoAproveitamento solicitacao,
			AtoAdministrativo ato, Date dataEfeito, Date dataAproveitamento, Date dataLimiteInicioExercicio,
			FormaProvimento formaProvimento, RegimeJuridico regimeJuridico, TipoProvimento tipoProvimento,
			RegimePrevidencia regimePrevidencia, SituacaoAproveitamento situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.funcionario = funcionario;
		this.solicitacao = solicitacao;
		this.ato = ato;
		this.dataEfeito = dataEfeito;
		this.dataAproveitamento = dataAproveitamento;
		this.dataLimiteInicioExercicio = dataLimiteInicioExercicio;
		this.formaProvimento = formaProvimento;
		this.regimeJuridico = regimeJuridico;
		this.tipoProvimento = tipoProvimento;
		this.regimePrevidencia = regimePrevidencia;
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

	public CargoArea getCargoArea() {
		return cargoArea;
	}

	public void setCargoArea(CargoArea cargoArea) {
		this.cargoArea = cargoArea;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public SolicitacaoAproveitamento getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoAproveitamento solicitacao) {
		this.solicitacao = solicitacao;
	}

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public Date getDataAproveitamento() {
		return dataAproveitamento;
	}

	public void setDataAproveitamento(Date dataAproveitamento) {
		this.dataAproveitamento = dataAproveitamento;
	}

	public Date getDataLimiteInicioExercicio() {
		return dataLimiteInicioExercicio;
	}

	public void setDataLimiteInicioExercicio(Date dataLimiteInicioExercicio) {
		this.dataLimiteInicioExercicio = dataLimiteInicioExercicio;
	}

	public FormaProvimento getFormaProvimento() {
		return formaProvimento;
	}

	public void setFormaProvimento(FormaProvimento formaProvimento) {
		this.formaProvimento = formaProvimento;
	}

	public RegimeJuridico getRegimeJuridico() {
		return regimeJuridico;
	}

	public void setRegimeJuridico(RegimeJuridico regimeJuridico) {
		this.regimeJuridico = regimeJuridico;
	}

	public TipoProvimento getTipoProvimento() {
		return tipoProvimento;
	}

	public void setTipoProvimento(TipoProvimento tipoProvimento) {
		this.tipoProvimento = tipoProvimento;
	}

	public RegimePrevidencia getRegimePrevidencia() {
		return regimePrevidencia;
	}

	public void setRegimePrevidencia(RegimePrevidencia regimePrevidencia) {
		this.regimePrevidencia = regimePrevidencia;
	}

	public SituacaoAproveitamento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAproveitamento situacao) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aproveitamento that = (Aproveitamento) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cargoArea, that.cargoArea) &&
                Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(solicitacao, that.solicitacao) &&
                Objects.equals(ato, that.ato) &&
                Objects.equals(dataEfeito, that.dataEfeito) &&
                Objects.equals(dataAproveitamento, that.dataAproveitamento) &&
                Objects.equals(dataLimiteInicioExercicio, that.dataLimiteInicioExercicio) &&
                formaProvimento == that.formaProvimento &&
                Objects.equals(regimeJuridico, that.regimeJuridico) &&
                tipoProvimento == that.tipoProvimento &&
                Objects.equals(regimePrevidencia, that.regimePrevidencia) &&
                situacao == that.situacao &&
                Objects.equals(dataSituacao, that.dataSituacao) &&
                Objects.equals(parecer, that.parecer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cargoArea, funcionario, solicitacao, ato, dataEfeito, dataAproveitamento, dataLimiteInicioExercicio, formaProvimento, regimeJuridico, tipoProvimento, regimePrevidencia, situacao, dataSituacao, parecer);
    }

    @Override
	public String toString() {
		return "Aproveitamento [id=" + id + ", cargoArea=" + cargoArea + ", funcionario=" + funcionario
				+ ", solicitacao=" + solicitacao + ", ato=" + ato + ", dataEfeito=" + dataEfeito
				+ ", dataAproveitamento=" + dataAproveitamento + ", dataLimiteInicioExercicio="
				+ dataLimiteInicioExercicio + ", formaProvimento=" + formaProvimento + ", regimeJuridico="
				+ regimeJuridico + ", tipoProvimento=" + tipoProvimento + ", regimePrevidencia=" + regimePrevidencia
				+ ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}