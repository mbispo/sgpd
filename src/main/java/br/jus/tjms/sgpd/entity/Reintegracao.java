package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.FormaProvimento;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;
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
public class Reintegracao implements Serializable {

	private static final long serialVersionUID = -2846133185481381679L;

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
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoReintegracao solicitacao;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	@Column(length = 60)
	private String processo;

	private Date dataEfeito;
	private Date dataReintegracao;

	@Enumerated(EnumType.ORDINAL)
	private FormaProvimento formaProvimento;

	@ManyToOne
	@JoinColumn(name = "regimeJuridico_id", nullable = false)
	private RegimeJuridico regimeJuridico;

	@ManyToOne
	@JoinColumn(name = "regimePrevidencia_id", nullable = false)
	private RegimePrevidencia regimePrevidencia;

	@Enumerated(EnumType.ORDINAL)
	private TipoProvimento tipoProvimento;

	@Column(length = 500)
	private String observacoes;

	public Reintegracao() {
		super();
	}

	public Reintegracao(Long id, CargoArea cargoArea, Funcionario funcionario, SolicitacaoReintegracao solicitacao,
			AtoAdministrativo ato, String processo, Date dataEfeito, Date dataReintegracao,
			FormaProvimento formaProvimento, RegimeJuridico regimeJuridico, RegimePrevidencia regimePrevidencia,
			TipoProvimento tipoProvimento, String observacoes) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.funcionario = funcionario;
		this.solicitacao = solicitacao;
		this.ato = ato;
		this.processo = processo;
		this.dataEfeito = dataEfeito;
		this.dataReintegracao = dataReintegracao;
		this.formaProvimento = formaProvimento;
		this.regimeJuridico = regimeJuridico;
		this.regimePrevidencia = regimePrevidencia;
		this.tipoProvimento = tipoProvimento;
		this.observacoes = observacoes;
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

	public SolicitacaoReintegracao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoReintegracao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public Date getDataReintegracao() {
		return dataReintegracao;
	}

	public void setDataReintegracao(Date dataReintegracao) {
		this.dataReintegracao = dataReintegracao;
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

	public RegimePrevidencia getRegimePrevidencia() {
		return regimePrevidencia;
	}

	public void setRegimePrevidencia(RegimePrevidencia regimePrevidencia) {
		this.regimePrevidencia = regimePrevidencia;
	}

	public TipoProvimento getTipoProvimento() {
		return tipoProvimento;
	}

	public void setTipoProvimento(TipoProvimento tipoProvimento) {
		this.tipoProvimento = tipoProvimento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		Reintegracao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Reintegracao [id=" + id + ", cargoArea=" + cargoArea + ", funcionario=" + funcionario
				+ ", solicitacao=" + solicitacao + ", ato=" + ato + ", processo=" + processo + ", dataEfeito="
				+ dataEfeito + ", dataReintegracao=" + dataReintegracao + ", formaProvimento=" + formaProvimento
				+ ", regimeJuridico=" + regimeJuridico + ", regimePrevidencia=" + regimePrevidencia
				+ ", tipoProvimento=" + tipoProvimento + ", observacoes=" + observacoes + "]";
	}

}