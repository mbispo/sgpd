package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.CargoHistoricoNomeTO;
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
@NamedQueries({
	@NamedQuery(name = "cargoHistoricoNome.buscarPorCargo", 
			query = "SELECT c from CargoHistoricoNome c WHERE c.cargo.id = :cargoId")
})
public class CargoHistoricoNome implements Serializable {

	private static final long serialVersionUID = 1610709592918460989L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@Column(length = 200)
	private String nome;

	private Date vigenciaInicio;
	private Date vigenciaFim;

	public CargoHistoricoNome() {
		super();
	}

	public CargoHistoricoNome(Long id, Cargo cargo, AtoAdministrativo atoAdministrativo, String nome,
			Date vigenciaInicio, Date vigenciaFim) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.atoAdministrativo = atoAdministrativo;
		this.nome = nome;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
	}

	public CargoHistoricoNome(CargoHistoricoNomeTO cargoHistoricoNomeTO) {
		//FIXME this.cargo = cargoHistoricoNomeTO.getCargoId();
		//FIXME this.atoAdministrativo = cargoHistoricoNomeTO.getAtoAdministrativoId();
		this.nome = cargoHistoricoNomeTO.getNome();
		this.vigenciaInicio = cargoHistoricoNomeTO.getVigenciaInicio();
		this.vigenciaFim = cargoHistoricoNomeTO.getVigenciaFim();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
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
		CargoHistoricoNome other = (CargoHistoricoNome) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CargoHistoricoNome [id=" + id + ", cargo=" + cargo + ", atoAdministrativo=" + atoAdministrativo
				+ ", nome=" + nome + "]";
	}
	
	public void alterar(CargoHistoricoNomeTO cargoHistoricoNomeTO) {
		//FIXME this.cargo = cargoHistoricoNomeTO.getCargoId();
		//FIXME this.atoAdministrativo = cargoHistoricoNomeTO.getAtoAdministrativoId();
		this.nome = cargoHistoricoNomeTO.getNome();
		this.vigenciaInicio = cargoHistoricoNomeTO.getVigenciaInicio();
		this.vigenciaFim = cargoHistoricoNomeTO.getVigenciaFim();
	}
}