package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoAutoridade;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:05
 */
@Entity
@Auditavel
@Cacheable
public class Substituicao implements Serializable {

	private static final long serialVersionUID = 7370775254367717857L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "substituto_id", nullable = false)
	private Funcionario substituto;

	@ManyToOne
	@JoinColumn(name = "substituido_id", nullable = false)
	private Funcionario substituido;

	private Date dataInicio;
	private Date dataFim;

	@ManyToOne
	@JoinColumn(name = "cargoArea_id", nullable = false)
	private CargoArea cargoArea;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@Column(length = 60)
	private String processo;

	@Enumerated(EnumType.ORDINAL)
	private TipoAutoridade autoridade;

	@Column(length = 500)
	private String motivo;

	public Substituicao() {
		super();
	}

	public Substituicao(Long id, Funcionario substituto, Funcionario substituido, Date dataInicio, Date dataFim,
			CargoArea cargoArea, AtoAdministrativo atoAdministrativo, String processo, TipoAutoridade autoridade,
			String motivo) {
		super();
		this.id = id;
		this.substituto = substituto;
		this.substituido = substituido;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.cargoArea = cargoArea;
		this.atoAdministrativo = atoAdministrativo;
		this.processo = processo;
		this.autoridade = autoridade;
		this.motivo = motivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getSubstituto() {
		return substituto;
	}

	public void setSubstituto(Funcionario substituto) {
		this.substituto = substituto;
	}

	public Funcionario getSubstituido() {
		return substituido;
	}

	public void setSubstituido(Funcionario substituido) {
		this.substituido = substituido;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public CargoArea getCargoArea() {
		return cargoArea;
	}

	public void setCargoArea(CargoArea cargoArea) {
		this.cargoArea = cargoArea;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public TipoAutoridade getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(TipoAutoridade autoridade) {
		this.autoridade = autoridade;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
		Substituicao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Substituicao [id=" + id + ", substituto=" + substituto + ", substituido=" + substituido
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", cargoArea=" + cargoArea
				+ ", atoAdministrativo=" + atoAdministrativo + ", processo=" + processo + ", autoridade=" + autoridade
				+ ", motivo=" + motivo + "]";
	}

}