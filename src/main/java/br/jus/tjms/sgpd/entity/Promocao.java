package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.FormaProvimento;
import br.jus.tjms.sgpd.enumerators.PromocaoCriterio;
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
public class Promocao implements Serializable {

	private static final long serialVersionUID = -1010191699175650234L;

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

	private Date dataEfeito;
	private Date dataInicioExercicio;

	@Enumerated(EnumType.ORDINAL)
	private PromocaoCriterio criterio;

	@Enumerated(EnumType.ORDINAL)
	private FormaProvimento formaProvimento;

	@ManyToOne
	@JoinColumn(name = "regimeJuridico_id", nullable = false)
	private RegimeJuridico regimeJuridico;

	@Enumerated(EnumType.ORDINAL)
	private TipoProvimento tipoProvimento;

	@ManyToOne
	@JoinColumn(name = "regimePrevidencia_id", nullable = false)
	private RegimePrevidencia regimePrevidencia;

	public Promocao() {
		super();
	}

	public Promocao(Long id, CargoArea cargoArea, Funcionario funcionario, AtoAdministrativo ato, Date dataEfeito,
			Date dataInicioExercicio, PromocaoCriterio criterio, FormaProvimento formaProvimento,
			RegimeJuridico regimeJuridico, TipoProvimento tipoProvimento, RegimePrevidencia regimePrevidencia) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.funcionario = funcionario;
		this.ato = ato;
		this.dataEfeito = dataEfeito;
		this.dataInicioExercicio = dataInicioExercicio;
		this.criterio = criterio;
		this.formaProvimento = formaProvimento;
		this.regimeJuridico = regimeJuridico;
		this.tipoProvimento = tipoProvimento;
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

	public PromocaoCriterio getCriterio() {
		return criterio;
	}

	public void setCriterio(PromocaoCriterio criterio) {
		this.criterio = criterio;
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
		Promocao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Promocao [id=" + id + ", cargoArea=" + cargoArea + ", funcionario=" + funcionario + ", ato=" + ato
				+ ", dataEfeito=" + dataEfeito + ", dataInicioExercicio=" + dataInicioExercicio + ", criterio="
				+ criterio + ", formaProvimento=" + formaProvimento + ", regimeJuridico=" + regimeJuridico
				+ ", tipoProvimento=" + tipoProvimento + ", regimePrevidencia=" + regimePrevidencia + "]";
	}

}