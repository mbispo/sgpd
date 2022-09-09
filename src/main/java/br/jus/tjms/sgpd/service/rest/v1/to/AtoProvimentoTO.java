package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.FormaProvimento;
import br.jus.tjms.sgpd.enumerators.SituacaoAtoProvimento;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;

public class AtoProvimentoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long cargoAreaId;
	private Long funcionarioId;
	private Long atoAdministrativoId;
	private Long atoAdministrativoRelacionadoId;
	private Date dataEfeito;
	private Long especialidadeId;
	private Long ocupacaoId;
	private TipoProvimento tipoProvimento;
	private FormaProvimento formaProvimento;
	private Long regimeJuridicoId;
	private Long regimePrevidenciaId;
	private String observacoes;
	private SituacaoAtoProvimento situacao;
	private Date dataSituacao;
	private String parecer;

	public AtoProvimentoTO() {
		super();
	}

	public AtoProvimentoTO(Long id, Long cargoAreaId, Long funcionarioId, Long atoAdministrativoId,
			Long atoAdministrativoRelacionadoId, Date dataEfeito, Long especialidadeId, Long ocupacaoId,
			TipoProvimento tipoProvimento, FormaProvimento formaProvimento, Long regimeJuridicoId, 
			Long regimePrevidenciaId, String observacoes, SituacaoAtoProvimento situacao, Date dataSituacao, 
			String parecer) {
		super();
		this.id = id;
		this.cargoAreaId = cargoAreaId;
		this.funcionarioId = funcionarioId;
		this.atoAdministrativoId = atoAdministrativoId;
		this.atoAdministrativoRelacionadoId = atoAdministrativoRelacionadoId;
		this.dataEfeito = dataEfeito;
		this.especialidadeId = especialidadeId;
		this.ocupacaoId = ocupacaoId;
		this.tipoProvimento = tipoProvimento;
		this.formaProvimento = formaProvimento;
		this.regimeJuridicoId = regimeJuridicoId;
		this.regimePrevidenciaId = regimePrevidenciaId;
		this.observacoes = observacoes;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
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

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Long getAtoAdministrativoId() {
		return atoAdministrativoId;
	}

	public void setAtoAdministrativoId(Long atoAdministrativoId) {
		this.atoAdministrativoId = atoAdministrativoId;
	}

	public Long getAtoAdministrativoRelacionadoId() {
		return atoAdministrativoRelacionadoId;
	}

	public void setAtoAdministrativoRelacionadoId(Long atoAdministrativoRelacionadoId) {
		this.atoAdministrativoRelacionadoId = atoAdministrativoRelacionadoId;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
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

	public Long getRegimeJuridicoId() {
		return regimeJuridicoId;
	}

	public void setRegimeJuridicoId(Long regimeJuridicoId) {
		this.regimeJuridicoId = regimeJuridicoId;
	}

	public Long getRegimePrevidenciaId() {
		return regimePrevidenciaId;
	}

	public void setRegimePrevidenciaId(Long regimePrevidenciaId) {
		this.regimePrevidenciaId = regimePrevidenciaId;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public SituacaoAtoProvimento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAtoProvimento situacao) {
		this.situacao = situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	@Override
	public String toString() {
		return "AtoProvimentoTO [id=" + id + ", cargoAreaId=" + cargoAreaId + ", funcionarioId=" + funcionarioId
				+ ", atoAdministrativoId=" + atoAdministrativoId + ", atoAdministrativoRelacionadoId="
				+ atoAdministrativoRelacionadoId + ", dataEfeito=" + dataEfeito + ", especialidadeId=" + especialidadeId
				+ ", ocupacaoId=" + ocupacaoId + ", tipoProvimento=" + tipoProvimento + ", formaProvimento="
				+ formaProvimento + ", regimeJuridicoId=" + regimeJuridicoId + ", regimePrevidenciaId="
				+ regimePrevidenciaId + ", observacoes=" + observacoes + ", situacao=" + situacao + ", dataSituacao="
				+ dataSituacao + ", parecer=" + parecer + "]";
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
		AtoProvimentoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}