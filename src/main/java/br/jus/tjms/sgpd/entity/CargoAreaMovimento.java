package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoCargoAreaMovimento;
import br.jus.tjms.sgpd.service.rest.v1.to.CargoAreaMovimentoTO;
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
	@NamedQuery(name = "cargoAreaMovimento.buscarPorCargoArea", 
			query = "SELECT c from CargoAreaMovimento c WHERE c.cargoArea.id = :cargoAreaId")
})
public class CargoAreaMovimento implements Serializable {

	private static final long serialVersionUID = 5412486712817154648L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargoArea_id", nullable = false)
	private CargoArea cargoArea;

	@ManyToOne
	@JoinColumn(name = "movimentoRelacionado_id", nullable = true)
	private CargoAreaMovimento movimentoRelacionado;

	@ManyToOne
	@JoinColumn(name = "especialidade_id", nullable = false)
	private Especialidade especialidade;

	@ManyToOne
	@JoinColumn(name = "ocupacao_id", nullable = false)
	private Ocupacao ocupacao;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoCargoAreaMovimento tipoMovimento;

	private Date data;

	private Integer quantidade;
	
	private String observacoes;

	public CargoAreaMovimento() {
		super();
	}

	public CargoAreaMovimento(Long id) {
		super();
		this.id = id;
	}

	public CargoAreaMovimento(Long id, CargoArea cargoArea, CargoAreaMovimento movimentoRelacionado,
			Especialidade especialidade, Ocupacao ocupacao, AtoAdministrativo atoAdministrativo,
			TipoCargoAreaMovimento tipoMovimento, Date data, Integer quantidade, String observacoes) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.movimentoRelacionado = movimentoRelacionado;
		this.especialidade = especialidade;
		this.ocupacao = ocupacao;
		this.atoAdministrativo = atoAdministrativo;
		this.tipoMovimento = tipoMovimento;
		this.data = data;
		this.quantidade = quantidade;
		this.observacoes = observacoes;
	}

	public CargoAreaMovimento(CargoAreaMovimentoTO cargoAreaMovimentoTO) {
		this.id = cargoAreaMovimentoTO.getId();
		this.cargoArea = new CargoArea(cargoAreaMovimentoTO.getCargoAreaId());
		if (cargoAreaMovimentoTO.getCargoAreaMovimentoRelacionadoId()!=null) {
			this.movimentoRelacionado = new CargoAreaMovimento(cargoAreaMovimentoTO.getCargoAreaMovimentoRelacionadoId());
		}
		this.especialidade = new Especialidade(cargoAreaMovimentoTO.getEspecialidadeId());
		this.ocupacao = new Ocupacao(cargoAreaMovimentoTO.getOcupacaoId());
		this.atoAdministrativo = new AtoAdministrativo(cargoAreaMovimentoTO.getAtoAdministrativoId());
		this.tipoMovimento = cargoAreaMovimentoTO.getTipoMovimento();
		this.data = cargoAreaMovimentoTO.getData();
		this.quantidade = cargoAreaMovimentoTO.getQuantidade();
		this.observacoes = cargoAreaMovimentoTO.getObservacoes();
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

	public CargoAreaMovimento getMovimentoRelacionado() {
		return movimentoRelacionado;
	}

	public void setMovimentoRelacionado(CargoAreaMovimento movimentoRelacionado) {
		this.movimentoRelacionado = movimentoRelacionado;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Ocupacao getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		CargoAreaMovimento other = (CargoAreaMovimento) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CargoAreaMovimento [id=" + id + ", cargoArea=" + cargoArea + ", movimentoRelacionado="
				+ movimentoRelacionado + ", especialidade=" + especialidade + ", ocupacao=" + ocupacao
				+ ", atoAdministrativo=" + atoAdministrativo + ", tipoMovimento=" + tipoMovimento + ", data=" + data
				+ ", quantidade=" + quantidade + ", observacoes=" + observacoes + "]";
	}

	public void alterar(CargoAreaMovimentoTO cargoAreaMovimentoTO) {
		this.cargoArea = new CargoArea(cargoAreaMovimentoTO.getCargoAreaId());
		if (cargoAreaMovimentoTO.getCargoAreaMovimentoRelacionadoId()!=null) {
			this.movimentoRelacionado = new CargoAreaMovimento(cargoAreaMovimentoTO.getCargoAreaMovimentoRelacionadoId());
		}
		this.especialidade = new Especialidade(cargoAreaMovimentoTO.getEspecialidadeId());
		this.ocupacao = new Ocupacao(cargoAreaMovimentoTO.getOcupacaoId());
		this.atoAdministrativo = new AtoAdministrativo(cargoAreaMovimentoTO.getAtoAdministrativoId());
		this.tipoMovimento = cargoAreaMovimentoTO.getTipoMovimento();
		this.data = cargoAreaMovimentoTO.getData();
		this.quantidade = cargoAreaMovimentoTO.getQuantidade();
		this.observacoes = cargoAreaMovimentoTO.getObservacoes();
	}

}