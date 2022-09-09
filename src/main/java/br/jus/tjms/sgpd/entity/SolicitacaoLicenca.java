package br.jus.tjms.sgpd.entity;

import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoLicenca;
import br.jus.tjms.sgpd.enumerators.TipoLicenca;
import br.jus.tjms.sgpd.enumerators.TipoSolicitacaoLicenca;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:04
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "discriminador")
@DiscriminatorValue("SOLICITACAO_LICENCA")
public class SolicitacaoLicenca implements Serializable {

	private static final long serialVersionUID = 4855894217964567257L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	private Date dataSolicitacao;

	@Enumerated(EnumType.ORDINAL)
	private TipoSolicitacaoLicenca tipoSolicitacao;

	@ManyToOne
	@JoinColumn(name = "licencaProrrogada_id", nullable = true)
	private Licenca licencaProrrogada;

	@Enumerated(EnumType.ORDINAL)
	private TipoLicenca tipoLicenca;

	@Column(length = 20)
	private String cid;

	private Boolean comRemuneracao;
	private Boolean comPermissaoExercicio;
	private Date dataInicioLicenca;
	private Integer numeroDiasLicenca;

	@Column(length = 500)
	private String motivo;

	private Date dataRecebimento;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoLicenca situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoLicenca() {
		super();
	}

	public SolicitacaoLicenca(Long id, Funcionario solicitante, Date dataSolicitacao,
			TipoSolicitacaoLicenca tipoSolicitacao, Licenca licencaProrrogada, TipoLicenca tipoLicenca, String cid,
			Boolean comRemuneracao, Boolean comPermissaoExercicio, Date dataInicioLicenca, Integer numeroDiasLicenca,
			String motivo, Date dataRecebimento, SituacaoSolicitacaoLicenca situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.dataSolicitacao = dataSolicitacao;
		this.tipoSolicitacao = tipoSolicitacao;
		this.licencaProrrogada = licencaProrrogada;
		this.tipoLicenca = tipoLicenca;
		this.cid = cid;
		this.comRemuneracao = comRemuneracao;
		this.comPermissaoExercicio = comPermissaoExercicio;
		this.dataInicioLicenca = dataInicioLicenca;
		this.numeroDiasLicenca = numeroDiasLicenca;
		this.motivo = motivo;
		this.dataRecebimento = dataRecebimento;
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

	public Funcionario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Funcionario solicitante) {
		this.solicitante = solicitante;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public TipoSolicitacaoLicenca getTipoSolicitacao() {
		return tipoSolicitacao;
	}

	public void setTipoSolicitacao(TipoSolicitacaoLicenca tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}

	public Licenca getLicencaProrrogada() {
		return licencaProrrogada;
	}

	public void setLicencaProrrogada(Licenca licencaProrrogada) {
		this.licencaProrrogada = licencaProrrogada;
	}

	public TipoLicenca getTipoLicenca() {
		return tipoLicenca;
	}

	public void setTipoLicenca(TipoLicenca tipoLicenca) {
		this.tipoLicenca = tipoLicenca;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Boolean getComRemuneracao() {
		return comRemuneracao;
	}

	public void setComRemuneracao(Boolean comRemuneracao) {
		this.comRemuneracao = comRemuneracao;
	}

	public Boolean getComPermissaoExercicio() {
		return comPermissaoExercicio;
	}

	public void setComPermissaoExercicio(Boolean comPermissaoExercicio) {
		this.comPermissaoExercicio = comPermissaoExercicio;
	}

	public Date getDataInicioLicenca() {
		return dataInicioLicenca;
	}

	public void setDataInicioLicenca(Date dataInicioLicenca) {
		this.dataInicioLicenca = dataInicioLicenca;
	}

	public Integer getNumeroDiasLicenca() {
		return numeroDiasLicenca;
	}

	public void setNumeroDiasLicenca(Integer numeroDiasLicenca) {
		this.numeroDiasLicenca = numeroDiasLicenca;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public SituacaoSolicitacaoLicenca getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoLicenca situacao) {
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
		SolicitacaoLicenca other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoLicenca [id=" + id + ", solicitante=" + solicitante + ", dataSolicitacao=" + dataSolicitacao
				+ ", tipoSolicitacao=" + tipoSolicitacao + ", licencaProrrogada=" + licencaProrrogada
				+ ", tipoLicenca=" + tipoLicenca + ", cid=" + cid + ", comRemuneracao=" + comRemuneracao
				+ ", comPermissaoExercicio=" + comPermissaoExercicio + ", dataInicioLicenca=" + dataInicioLicenca
				+ ", numeroDiasLicenca=" + numeroDiasLicenca + ", motivo=" + motivo + ", dataRecebimento="
				+ dataRecebimento + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer="
				+ parecer + "]";
	}

}