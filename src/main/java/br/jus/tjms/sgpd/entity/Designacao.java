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
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class Designacao implements Serializable {

	private static final long serialVersionUID = -2768503147124909175L;

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
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativoRelacionado_id", nullable = true)
	private AtoAdministrativo atoRelacionado;

	private Date dataEfeito;
	private Date dataInicioExercicio;

	@Enumerated(EnumType.ORDINAL)
	private TipoProvimento tipoProvimento;

	@Enumerated(EnumType.ORDINAL)
	private FormaProvimento formaProvimento;

	@ManyToOne
	@JoinColumn(name = "regimeJuridico_id", nullable = false)
	private RegimeJuridico regimeJuridico;

	@ManyToOne
	@JoinColumn(name = "regimePrevidencia_id", nullable = false)
	private RegimePrevidencia regimePrevidencia;

	public Designacao() {
		super();
	}

	public Designacao(Long id, CargoArea cargoArea, Funcionario funcionario, AtoAdministrativo ato,
			AtoAdministrativo atoRelacionado, Date dataEfeito, Date dataInicioExercicio, TipoProvimento tipoProvimento,
			FormaProvimento formaProvimento, RegimeJuridico regimeJuridico, RegimePrevidencia regimePrevidencia) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.funcionario = funcionario;
		this.ato = ato;
		this.atoRelacionado = atoRelacionado;
		this.dataEfeito = dataEfeito;
		this.dataInicioExercicio = dataInicioExercicio;
		this.tipoProvimento = tipoProvimento;
		this.formaProvimento = formaProvimento;
		this.regimeJuridico = regimeJuridico;
		this.regimePrevidencia = regimePrevidencia;
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

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public AtoAdministrativo getAtoRelacionado() {
		return atoRelacionado;
	}

	public void setAtoRelacionado(AtoAdministrativo atoRelacionado) {
		this.atoRelacionado = atoRelacionado;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public Date getDataInicioExercicio() {
		return dataInicioExercicio;
	}

	public void setDataInicioExercicio(Date dataInicioExercicio) {
		this.dataInicioExercicio = dataInicioExercicio;
	}

	public TipoProvimento getTipoProvimento() {
		return tipoProvimento;
	}

	public void setTipoProvimento(TipoProvimento tipoProvimento) {
		this.tipoProvimento = tipoProvimento;
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
		Designacao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Designacao [id=" + id + ", cargoArea=" + cargoArea + ", funcionario=" + funcionario + ", ato=" + ato
				+ ", atoRelacionado=" + atoRelacionado + ", dataEfeito=" + dataEfeito + ", dataInicioExercicio="
				+ dataInicioExercicio + ", tipoProvimento=" + tipoProvimento + ", formaProvimento=" + formaProvimento
				+ ", regimeJuridico=" + regimeJuridico + ", regimePrevidencia=" + regimePrevidencia + "]";
	}

}