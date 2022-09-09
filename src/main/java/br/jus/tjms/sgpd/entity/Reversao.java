package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.FormaProvimento;
import br.jus.tjms.sgpd.enumerators.SituacaoReversao;
import br.jus.tjms.sgpd.enumerators.TipoAutoridade;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
public class Reversao implements Serializable {

	private static final long serialVersionUID = 3948325081060110929L;

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
	@JoinColumn(name = "solicitacaoReversao_id", nullable = true)
	private SolicitacaoReversao solicitacaoReversao;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	private Date dataEfeito;
	private Date dataInicioExercicio;

	@Enumerated(EnumType.ORDINAL)
	private TipoAutoridade autoridade;

	@Column(length = 20)
	private String cid;

	@Enumerated(EnumType.ORDINAL)
	private FormaProvimento formaProvimento;

	@ManyToOne
	@JoinColumn(name = "regimeJuridico_id", nullable = false)
	private RegimeJuridico regimeJuridico;

	@Enumerated(EnumType.ORDINAL)
	private TipoProvimento tipoProvimento;

	@ManyToOne
	@JoinColumn(name = "regimePrevidencia_id", nullable = false)
	private RegimePrevidencia regimePrevidencia;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoReversao situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public Reversao() {
		super();
	}

	public Reversao(Long id, CargoArea cargoArea, Funcionario funcionario, SolicitacaoReversao solicitacaoReversao,
			AtoAdministrativo ato, Date dataEfeito, Date dataInicioExercicio, TipoAutoridade autoridade, String cid,
			FormaProvimento formaProvimento, RegimeJuridico regimeJuridico, TipoProvimento tipoProvimento,
			RegimePrevidencia regimePrevidencia, SituacaoReversao situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.funcionario = funcionario;
		this.solicitacaoReversao = solicitacaoReversao;
		this.ato = ato;
		this.dataEfeito = dataEfeito;
		this.dataInicioExercicio = dataInicioExercicio;
		this.autoridade = autoridade;
		this.cid = cid;
		this.formaProvimento = formaProvimento;
		this.regimeJuridico = regimeJuridico;
		this.tipoProvimento = tipoProvimento;
		this.regimePrevidencia = regimePrevidencia;
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

	public SolicitacaoReversao getSolicitacaoReversao() {
		return solicitacaoReversao;
	}

	public void setSolicitacaoReversao(SolicitacaoReversao solicitacaoReversao) {
		this.solicitacaoReversao = solicitacaoReversao;
	}

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public Date getDataInicioExercicio() {
		return dataInicioExercicio;
	}

	public void setDataInicioExercicio(Date dataInicioExercicio) {
		this.dataInicioExercicio = dataInicioExercicio;
	}

	public TipoAutoridade getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(TipoAutoridade autoridade) {
		this.autoridade = autoridade;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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

	public TipoProvimento getTipoProvimento() {
		return tipoProvimento;
	}

	public void setTipoProvimento(TipoProvimento tipoProvimento) {
		this.tipoProvimento = tipoProvimento;
	}

	public RegimePrevidencia getRegimePrevidencia() {
		return regimePrevidencia;
	}

	public void setRegimePrevidencia(RegimePrevidencia regimePrevidencia) {
		this.regimePrevidencia = regimePrevidencia;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoReversao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoReversao situacao) {
		this.situacao = situacao;
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
		Reversao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Reversao [id=" + id + ", cargoArea=" + cargoArea + ", funcionario=" + funcionario
				+ ", solicitacaoReversao=" + solicitacaoReversao + ", ato=" + ato + ", dataEfeito=" + dataEfeito
				+ ", dataInicioExercicio=" + dataInicioExercicio + ", autoridade=" + autoridade + ", cid=" + cid
				+ ", formaProvimento=" + formaProvimento + ", regimeJuridico=" + regimeJuridico + ", tipoProvimento="
				+ tipoProvimento + ", regimePrevidencia=" + regimePrevidencia + ", situacao=" + situacao
				+ ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}