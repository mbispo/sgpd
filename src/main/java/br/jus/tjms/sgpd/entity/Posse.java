package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
public class Posse implements Serializable {

	private static final long serialVersionUID = 7037262931129334220L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargoArea_id", nullable = false)
	private CargoArea cargoArea;

	@ManyToOne
	@JoinColumn(name = "nomeacao_id", nullable = false)
	private Nomeacao nomeacao;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativoRelacionado_id", nullable = true)
	private AtoAdministrativo atoRelacionado;

	private Date dataPosse;
	private Date dataInicioExercicio;

	@Column(length = 500)
	private String observacoes;

	public Posse() {
		super();
	}

	public Posse(Long id, CargoArea cargoArea, Nomeacao nomeacao, Funcionario funcionario,
			AtoAdministrativo atoAdministrativo, AtoAdministrativo atoRelacionado, Date dataPosse,
			Date dataInicioExercicio, String observacoes) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.nomeacao = nomeacao;
		this.funcionario = funcionario;
		this.atoAdministrativo = atoAdministrativo;
		this.atoRelacionado = atoRelacionado;
		this.dataPosse = dataPosse;
		this.dataInicioExercicio = dataInicioExercicio;
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

	public Nomeacao getNomeacao() {
		return nomeacao;
	}

	public void setNomeacao(Nomeacao nomeacao) {
		this.nomeacao = nomeacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public AtoAdministrativo getAtoRelacionado() {
		return atoRelacionado;
	}

	public void setAtoRelacionado(AtoAdministrativo atoRelacionado) {
		this.atoRelacionado = atoRelacionado;
	}

	public Date getDataPosse() {
		return dataPosse;
	}

	public void setDataPosse(Date dataPosse) {
		this.dataPosse = dataPosse;
	}

	public Date getDataInicioExercicio() {
		return dataInicioExercicio;
	}

	public void setDataInicioExercicio(Date dataInicioExercicio) {
		this.dataInicioExercicio = dataInicioExercicio;
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
		Posse other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Posse [id=" + id + ", cargoArea=" + cargoArea + ", nomeacao=" + nomeacao + ", funcionario="
				+ funcionario + ", atoAdministrativo=" + atoAdministrativo + ", atoRelacionado=" + atoRelacionado
				+ ", dataPosse=" + dataPosse + ", dataInicioExercicio=" + dataInicioExercicio + ", observacoes="
				+ observacoes + "]";
	}

}