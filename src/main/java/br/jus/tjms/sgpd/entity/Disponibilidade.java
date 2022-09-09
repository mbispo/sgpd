package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoDisponibilidade;
import br.jus.tjms.sgpd.enumerators.TipoRemuneracao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:59
 */
@Entity
@Auditavel
@Cacheable
public class Disponibilidade implements Serializable {

	private static final long serialVersionUID = -591579417868471783L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoDisponibilidade solicitacao;

	private Boolean prorrogacao;

	@ManyToOne
	@JoinColumn(name = "disponibilidadeProrrogada_id", nullable = true)
	private Disponibilidade disponibilidadeProrrogada;

	private Integer numeroDias;

	@ManyToOne
	@JoinColumn(name = "cargoArea_id", nullable = false)
	private CargoArea cargoArea;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	private Date dataEfeito;

	@Enumerated(EnumType.ORDINAL)
	private TipoRemuneracao tipoRemuneracao;

	private Double proporcaoRemuneracao;

	@Column(length = 500)
	private String motivo;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoDisponibilidade situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativoTermino_id", nullable = true)
	private AtoAdministrativo atoAdministrativoTermino;

	public Disponibilidade() {
		super();
	}

	public Disponibilidade(Long id, Funcionario funcionario, SolicitacaoDisponibilidade solicitacao,
			Boolean prorrogacao, Disponibilidade disponibilidadeProrrogada, Integer numeroDias, CargoArea cargoArea,
			FuncionarioCargo funcionarioCargo, AtoAdministrativo atoAdministrativo, Date dataEfeito,
			TipoRemuneracao tipoRemuneracao, Double proporcaoRemuneracao, String motivo,
			SituacaoDisponibilidade situacao, Date dataSituacao, String parecer,
			AtoAdministrativo atoAdministrativoTermino) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.solicitacao = solicitacao;
		this.prorrogacao = prorrogacao;
		this.disponibilidadeProrrogada = disponibilidadeProrrogada;
		this.numeroDias = numeroDias;
		this.cargoArea = cargoArea;
		this.funcionarioCargo = funcionarioCargo;
		this.atoAdministrativo = atoAdministrativo;
		this.dataEfeito = dataEfeito;
		this.tipoRemuneracao = tipoRemuneracao;
		this.proporcaoRemuneracao = proporcaoRemuneracao;
		this.motivo = motivo;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
		this.atoAdministrativoTermino = atoAdministrativoTermino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public SolicitacaoDisponibilidade getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoDisponibilidade solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Boolean getProrrogacao() {
		return prorrogacao;
	}

	public void setProrrogacao(Boolean prorrogacao) {
		this.prorrogacao = prorrogacao;
	}

	public Disponibilidade getDisponibilidadeProrrogada() {
		return disponibilidadeProrrogada;
	}

	public void setDisponibilidadeProrrogada(Disponibilidade disponibilidadeProrrogada) {
		this.disponibilidadeProrrogada = disponibilidadeProrrogada;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public CargoArea getCargoArea() {
		return cargoArea;
	}

	public void setCargoArea(CargoArea cargoArea) {
		this.cargoArea = cargoArea;
	}

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public TipoRemuneracao getTipoRemuneracao() {
		return tipoRemuneracao;
	}

	public void setTipoRemuneracao(TipoRemuneracao tipoRemuneracao) {
		this.tipoRemuneracao = tipoRemuneracao;
	}

	public Double getProporcaoRemuneracao() {
		return proporcaoRemuneracao;
	}

	public void setProporcaoRemuneracao(Double proporcaoRemuneracao) {
		this.proporcaoRemuneracao = proporcaoRemuneracao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public SituacaoDisponibilidade getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoDisponibilidade situacao) {
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

	public AtoAdministrativo getAtoAdministrativoTermino() {
		return atoAdministrativoTermino;
	}

	public void setAtoAdministrativoTermino(AtoAdministrativo atoAdministrativoTermino) {
		this.atoAdministrativoTermino = atoAdministrativoTermino;
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
		Disponibilidade other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Disponibilidade [id=" + id + ", funcionario=" + funcionario + ", solicitacao=" + solicitacao
				+ ", prorrogacao=" + prorrogacao + ", disponibilidadeProrrogada=" + disponibilidadeProrrogada
				+ ", numeroDias=" + numeroDias + ", cargoArea=" + cargoArea + ", funcionarioCargo=" + funcionarioCargo
				+ ", atoAdministrativo=" + atoAdministrativo + ", dataEfeito=" + dataEfeito + ", tipoRemuneracao="
				+ tipoRemuneracao + ", proporcaoRemuneracao=" + proporcaoRemuneracao + ", motivo=" + motivo
				+ ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer
				+ ", atoAdministrativoTermino=" + atoAdministrativoTermino + "]";
	}

}