package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.FormaProvimento;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;

public class FuncionarioCargoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long funcionarioId;
	private Long cargoId;
	private Long atoProvimentoId;
	private Long especialidadeId;
	private Long ocupacaoId;
	private TipoProvimento tipoProvimento;
	private FormaProvimento formaProvimento;
	private Long regimePrevidenciaId;
	private Long regimeJuridicoId;
	private Date dataInicio;
	private Date dataFim;

	private List<ProgressaoFuncionalTO> progressoes = new ArrayList<ProgressaoFuncionalTO>();

	public FuncionarioCargoTO() {
		super();
	}

	public FuncionarioCargoTO(Long id, Long funcionarioId, Long cargoId, Long atoProvimentoId,
			Long especialidadeId, Long ocupacaoId,
			TipoProvimento tipoProvimento, FormaProvimento formaProvimento, Long regimePrevidenciaId,
			Long regimeJuridicoId, Date dataInicio, Date dataFim, List<ProgressaoFuncionalTO> progressoes) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.cargoId = cargoId;
		this.atoProvimentoId = atoProvimentoId;
		this.especialidadeId = especialidadeId;
		this.ocupacaoId = ocupacaoId;
		this.tipoProvimento = tipoProvimento;
		this.formaProvimento = formaProvimento;
		this.regimePrevidenciaId = regimePrevidenciaId;
		this.regimeJuridicoId = regimeJuridicoId;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.progressoes = progressoes;
	}

	public FuncionarioCargoTO(Long funcionarioId, Long cargoId, Long atoProvimentoId, 
			Long especialidadeId, Long ocupacaoId, TipoProvimento tipoProvimento, FormaProvimento formaProvimento, 
			Long regimePrevidenciaId, Long regimeJuridicoId, Date dataInicio,
			Date dataFim, List<ProgressaoFuncionalTO> progressoes) {
		super();
		this.funcionarioId = funcionarioId;
		this.cargoId = cargoId;
		this.atoProvimentoId = atoProvimentoId;
		this.especialidadeId = especialidadeId;
		this.ocupacaoId = ocupacaoId;
		this.tipoProvimento = tipoProvimento;
		this.formaProvimento = formaProvimento;
		this.regimePrevidenciaId = regimePrevidenciaId;
		this.regimeJuridicoId = regimeJuridicoId;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.progressoes = progressoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Long getCargoId() {
		return cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	public Long getAtoProvimentoId() {
		return atoProvimentoId;
	}

	public void setAtoProvimentoId(Long atoProvimentoId) {
		this.atoProvimentoId = atoProvimentoId;
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

	public Long getRegimePrevidenciaId() {
		return regimePrevidenciaId;
	}

	public void setRegimePrevidenciaId(Long regimePrevidenciaId) {
		this.regimePrevidenciaId = regimePrevidenciaId;
	}

	public Long getRegimeJuridicoId() {
		return regimeJuridicoId;
	}

	public void setRegimeJuridicoId(Long regimeJuridicoId) {
		this.regimeJuridicoId = regimeJuridicoId;
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

	public List<ProgressaoFuncionalTO> getProgressoes() {
		return progressoes;
	}

	public void setProgressoes(List<ProgressaoFuncionalTO> progressoes) {
		this.progressoes = progressoes;
	}

	@Override
	public String toString() {
		return "FuncionarioCargoTO [id=" + id + ", funcionarioId=" + funcionarioId + ", cargoId=" + cargoId
				+ ", atoProvimentoId=" + atoProvimentoId + ", especialidadeId=" + especialidadeId + ", ocupacaoId="
				+ ocupacaoId + ", tipoProvimento=" + tipoProvimento + ", formaProvimento=" + formaProvimento
				+ ", regimePrevidenciaId=" + regimePrevidenciaId + ", regimeJuridicoId=" + regimeJuridicoId
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
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
		FuncionarioCargoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}