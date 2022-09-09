package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoCargoAreaMovimento;

public class CargoAreaMovimentoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long cargoAreaId;
	private Long cargoAreaMovimentoRelacionadoId;
	private Long especialidadeId;
	private Long ocupacaoId;
	private Long atoAdministrativoId;
	private TipoCargoAreaMovimento tipoMovimento;
	private Date data;
	private Integer quantidade;
	private String observacoes;

	public CargoAreaMovimentoTO() {
		super();
	}

	public CargoAreaMovimentoTO(Long id, Long cargoAreaId, Long cargoAreaMovimentoRelacionadoId, Long especialidadeId,
			Long ocupacaoId, Long atoAdministrativoId, TipoCargoAreaMovimento tipoMovimento, Date data,
			Integer quantidade, String observacoes) {
		super();
		this.id = id;
		this.cargoAreaId = cargoAreaId;
		this.cargoAreaMovimentoRelacionadoId = cargoAreaMovimentoRelacionadoId;
		this.especialidadeId = especialidadeId;
		this.ocupacaoId = ocupacaoId;
		this.atoAdministrativoId = atoAdministrativoId;
		this.tipoMovimento = tipoMovimento;
		this.data = data;
		this.quantidade = quantidade;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCargoAreaId() {
		return cargoAreaId;
	}

	public void setCargoAreaId(Long cargoAreaId) {
		this.cargoAreaId = cargoAreaId;
	}

	public Long getCargoAreaMovimentoRelacionadoId() {
		return cargoAreaMovimentoRelacionadoId;
	}

	public void setCargoAreaMovimentoRelacionadoId(Long cargoAreaMovimentoRelacionadoId) {
		this.cargoAreaMovimentoRelacionadoId = cargoAreaMovimentoRelacionadoId;
	}

	public Long getEspecialidadeId() {
		return especialidadeId;
	}

	public void setEspecialidadeId(Long especialidadeId) {
		this.especialidadeId = especialidadeId;
	}

	public Long getOcupacaoId() {
		return ocupacaoId;
	}

	public void setOcupacaoId(Long ocupacaoId) {
		this.ocupacaoId = ocupacaoId;
	}

	public Long getAtoAdministrativoId() {
		return atoAdministrativoId;
	}

	public void setAtoAdministrativoId(Long atoAdministrativoId) {
		this.atoAdministrativoId = atoAdministrativoId;
	}

	public TipoCargoAreaMovimento getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(TipoCargoAreaMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "CargoAreaMovimentoTO [id=" + id + ", cargoAreaId=" + cargoAreaId + ", cargoAreaMovimentoRelacionadoId="
				+ cargoAreaMovimentoRelacionadoId + ", especialidadeId=" + especialidadeId + ", ocupacaoId="
				+ ocupacaoId + ", atoAdministrativoId=" + atoAdministrativoId + ", tipoMovimento=" + tipoMovimento
				+ ", data=" + data + ", quantidade=" + quantidade + ", observacoes=" + observacoes + "]";
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
		CargoAreaMovimentoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}