package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoNomeacao;
import br.jus.tjms.sgpd.enumerators.TipoNecessidadeEspecial;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
public class Nomeacao implements Serializable {

	private static final long serialVersionUID = 2161297145658628168L;

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
	@JoinColumn(name = "atoProvimento_id", nullable = true)
	private AtoProvimento atoProvimento;

	private Date dataEfeito;
	private Date dataLimitePosse;
	private Date dataLimitePosseProrrogada;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativoRelacionado_id", nullable = false)
	private AtoAdministrativo atoRelacionado;

	private Integer classificacao;

	@Enumerated(EnumType.ORDINAL)
	private TipoNecessidadeEspecial necessidadesEspeciais;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoNomeacao situacao;

	@Column(length = 500)
	private String observacoes;

	public Nomeacao() {
		super();
	}

	public Nomeacao(Long id, CargoArea cargoArea, Funcionario funcionario, AtoProvimento atoProvimento,
			Date dataEfeito, Date dataLimitePosse, Date dataLimitePosseProrrogada, AtoAdministrativo ato,
			AtoAdministrativo atoRelacionado, Integer classificacao, TipoNecessidadeEspecial necessidadesEspeciais,
			SituacaoNomeacao situacao, String observacoes) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.funcionario = funcionario;
		this.atoProvimento = atoProvimento;
		this.dataEfeito = dataEfeito;
		this.dataLimitePosse = dataLimitePosse;
		this.dataLimitePosseProrrogada = dataLimitePosseProrrogada;
		this.ato = ato;
		this.atoRelacionado = atoRelacionado;
		this.classificacao = classificacao;
		this.necessidadesEspeciais = necessidadesEspeciais;
		this.situacao = situacao;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public AtoProvimento getAtoProvimento() {
		return atoProvimento;
	}

	public void setAtoProvimento(AtoProvimento atoProvimento) {
		this.atoProvimento = atoProvimento;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public Date getDataLimitePosse() {
		return dataLimitePosse;
	}

	public void setDataLimitePosse(Date dataLimitePosse) {
		this.dataLimitePosse = dataLimitePosse;
	}

	public Date getDataLimitePosseProrrogada() {
		return dataLimitePosseProrrogada;
	}

	public void setDataLimitePosseProrrogada(Date dataLimitePosseProrrogada) {
		this.dataLimitePosseProrrogada = dataLimitePosseProrrogada;
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

	public Integer getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

	public TipoNecessidadeEspecial getNecessidadesEspeciais() {
		return necessidadesEspeciais;
	}

	public void setNecessidadesEspeciais(TipoNecessidadeEspecial necessidadesEspeciais) {
		this.necessidadesEspeciais = necessidadesEspeciais;
	}

	public SituacaoNomeacao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoNomeacao situacao) {
		this.situacao = situacao;
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
		Nomeacao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Nomeacao [id=" + id + ", cargoArea=" + cargoArea + ", funcionario=" + funcionario + ", atoProvimento="
				+ atoProvimento + ", dataEfeito=" + dataEfeito + ", dataLimitePosse=" + dataLimitePosse
				+ ", dataLimitePosseProrrogada=" + dataLimitePosseProrrogada + ", ato=" + ato + ", atoRelacionado="
				+ atoRelacionado + ", classificacao=" + classificacao + ", necessidadesEspeciais="
				+ necessidadesEspeciais + ", situacao=" + situacao + ", observacoes=" + observacoes + "]";
	}

}