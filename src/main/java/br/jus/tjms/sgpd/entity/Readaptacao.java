package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.FormaProvimento;
import br.jus.tjms.sgpd.enumerators.TipoAutoridade;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;
import br.jus.tjms.sgpd.enumerators.TipoReadaptacao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
public class Readaptacao implements Serializable {

	private static final long serialVersionUID = 897548005819171296L;

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
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoReadaptacao solicitacao;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	private Date dataEfeito;

	@Enumerated(EnumType.ORDINAL)
	private TipoAutoridade autoridade;

	@Column(length = 20)
	private String cid;

	@Enumerated(EnumType.ORDINAL)
	private FormaProvimento formaProvimento;

	@Enumerated(EnumType.ORDINAL)
	private TipoProvimento tipoProvimento;

	@ManyToOne
	@JoinColumn(name = "regimeJuridico_id", nullable = false)
	private RegimeJuridico regimeJuridico;

	@ManyToOne
	@JoinColumn(name = "regimePrevidencia_id", nullable = false)
	private RegimePrevidencia regimePrevidencia;

	private Date dataInicio;
	private Date dataFim;
	private Integer dias;

	@Enumerated(EnumType.ORDINAL)
	private TipoReadaptacao tipo;

	public Readaptacao() {
		super();
	}

	public Readaptacao(Long id, CargoArea cargoArea, Funcionario funcionario, SolicitacaoReadaptacao solicitacao,
			AtoAdministrativo atoAdministrativo, Date dataEfeito, TipoAutoridade autoridade, String cid,
			FormaProvimento formaProvimento, TipoProvimento tipoProvimento, RegimeJuridico regimeJuridico,
			RegimePrevidencia regimePrevidencia, Date dataInicio, Date dataFim, Integer dias, TipoReadaptacao tipo) {
		super();
		this.id = id;
		this.cargoArea = cargoArea;
		this.funcionario = funcionario;
		this.solicitacao = solicitacao;
		this.atoAdministrativo = atoAdministrativo;
		this.dataEfeito = dataEfeito;
		this.autoridade = autoridade;
		this.cid = cid;
		this.formaProvimento = formaProvimento;
		this.tipoProvimento = tipoProvimento;
		this.regimeJuridico = regimeJuridico;
		this.regimePrevidencia = regimePrevidencia;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.dias = dias;
		this.tipo = tipo;
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

	public SolicitacaoReadaptacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoReadaptacao solicitacao) {
		this.solicitacao = solicitacao;
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

	public TipoProvimento getTipoProvimento() {
		return tipoProvimento;
	}

	public void setTipoProvimento(TipoProvimento tipoProvimento) {
		this.tipoProvimento = tipoProvimento;
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

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public TipoReadaptacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoReadaptacao tipo) {
		this.tipo = tipo;
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
		Readaptacao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Readaptacao [id=" + id + ", cargoArea=" + cargoArea + ", funcionario=" + funcionario + ", solicitacao="
				+ solicitacao + ", atoAdministrativo=" + atoAdministrativo + ", dataEfeito=" + dataEfeito
				+ ", autoridade=" + autoridade + ", cid=" + cid + ", formaProvimento=" + formaProvimento
				+ ", tipoProvimento=" + tipoProvimento + ", regimeJuridico=" + regimeJuridico + ", regimePrevidencia="
				+ regimePrevidencia + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", dias=" + dias
				+ ", tipo=" + tipo + "]";
	}

}