package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.CargoAreaEstoqueTO;
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
	@NamedQuery(name = "cargoAreaEstoque.buscarPorCargoArea", 
			query = "SELECT c from CargoAreaEstoque c WHERE c.cargoArea.id = :cargoAreaId")
})
public class CargoAreaEstoque implements Serializable {

	private static final long serialVersionUID = -6827389620608993502L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargoArea_id", nullable = false)
	private CargoArea cargoArea;

	@ManyToOne
	@JoinColumn(name = "ocupacao_id", nullable = false)
	private Ocupacao ocupacao;

	@ManyToOne
	@JoinColumn(name = "especialidade_id", nullable = false)
	private Especialidade especialidade;

	private Date data;

	private Integer estoque;

	public CargoAreaEstoque() {
		super();
	}

	public CargoAreaEstoque(Long id, CargoArea cargoArea, Ocupacao ocupacao, Especialidade especialidade, Date data,
			Integer estoque) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.ocupacao = ocupacao;
		this.especialidade = especialidade;
		this.data = data;
		this.estoque = estoque;
	}

	public CargoAreaEstoque(CargoAreaEstoqueTO cargoAreaEstoqueTO) {
//FIXME this.cargoArea = cargoAreaEstoqueTO.getCargoAreaId();
//FIXME this.ocupacao = cargoAreaEstoqueTO.getOcupacaoId();
//FIXME this.especialidade = cargoAreaEstoqueTO.getEspecialidadeId();
		this.data = cargoAreaEstoqueTO.getData();
		this.estoque = cargoAreaEstoqueTO.getEstoque();
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

	public Ocupacao getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
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
		CargoAreaEstoque other = (CargoAreaEstoque) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CargoAreaEstoque [id=" + id + ", cargoArea=" + cargoArea + ", ocupacao=" + ocupacao
				+ ", especialidade=" + especialidade + ", estoque=" + estoque + "]";
	}

	public void alterar(CargoAreaEstoqueTO cargoAreaEstoqueTO) {
		//FIXME this.cargoArea = cargoAreaEstoqueTO.getCargoAreaId();
		//FIXME this.ocupacao = cargoAreaEstoqueTO.getOcupacaoId();
		//FIXME this.especialidade = cargoAreaEstoqueTO.getEspecialidadeId();
		this.data = cargoAreaEstoqueTO.getData();
		this.estoque = cargoAreaEstoqueTO.getEstoque();
	}

}