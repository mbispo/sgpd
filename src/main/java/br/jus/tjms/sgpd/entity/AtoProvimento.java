package br.jus.tjms.sgpd.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.FormaProvimento;
import br.jus.tjms.sgpd.enumerators.SituacaoAtoProvimento;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AtoProvimento implements Serializable {

	private static final long serialVersionUID = 8432554725704207075L;

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
	@JoinColumn(name = "ato_id", nullable = false)
	private AtoAdministrativo ato;

	@ManyToOne
	@JoinColumn(name = "atoRelacionado_id", nullable = false)
	private AtoAdministrativo atoRelacionado;

	private Date dataEfeito;
	
	@ManyToOne
	@JoinColumn(name = "especialidade_id", nullable = true)
	private Especialidade especialidade;

	@ManyToOne
	@JoinColumn(name = "ocupacao_id", nullable = true)
	private Ocupacao ocupacao;	

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

	@Column(length = 500)
	private String observacoes;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoAtoProvimento situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public AtoProvimento() {
		super();
	}
	
	public AtoProvimento(Long id) {
		super();
		this.id = id;
	}

	public AtoProvimento(Long id, CargoArea cargoArea, Funcionario funcionario, AtoAdministrativo ato,
			AtoAdministrativo atoRelacionado, Date dataEfeito, 
			Especialidade especialidade, Ocupacao ocupacao,
			TipoProvimento tipoProvimento,
			FormaProvimento formaProvimento, RegimeJuridico regimeJuridico, RegimePrevidencia regimePrevidencia,
			String observacoes, SituacaoAtoProvimento situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.funcionario = funcionario;
		this.ato = ato;
		this.atoRelacionado = atoRelacionado;
		this.dataEfeito = dataEfeito;
		this.especialidade = especialidade;
		this.ocupacao = ocupacao;
		this.tipoProvimento = tipoProvimento;
		this.formaProvimento = formaProvimento;
		this.regimeJuridico = regimeJuridico;
		this.regimePrevidencia = regimePrevidencia;
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

	public SituacaoAtoProvimento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAtoProvimento situacao) {
		this.situacao = situacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		AtoProvimento other = (AtoProvimento) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "AtoProvimento [id=" + id + ", cargoArea=" + cargoArea + ", funcionario=" + funcionario + ", ato=" + ato
				+ ", atoRelacionado=" + atoRelacionado + ", dataEfeito=" + dataEfeito + ", especialidade="
				+ especialidade + ", ocupacao=" + ocupacao + ", tipoProvimento=" + tipoProvimento + ", formaProvimento="
				+ formaProvimento + ", regimeJuridico=" + regimeJuridico + ", regimePrevidencia=" + regimePrevidencia
				+ ", observacoes=" + observacoes + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao
				+ ", parecer=" + parecer + "]";
	}

	

}