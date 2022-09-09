package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoAverbacaoTempo;
import br.jus.tjms.sgpd.enumerators.TipoOperacaoAverbacao;
import br.jus.tjms.sgpd.enumerators.TipoTempoAverbacao;
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
@Auditavel
@Cacheable
public class SolicitacaoAverbacaoTempo implements Serializable {

	private static final long serialVersionUID = -4077589458969566968L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@Enumerated(EnumType.ORDINAL)
	private TipoOperacaoAverbacao tipoOperacao;

	@ManyToOne
	@JoinColumn(name = "solicitacaoRelacionada_id", nullable = true)
	private SolicitacaoAverbacaoTempo solicitacaoRelacionada;

	@Enumerated(EnumType.ORDINAL)
	private TipoTempoAverbacao tipoTempo;

	private Date dataSolicitacao;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;

	@Column(length = 60)
	private String processo;

	@Column(length = 200)
	private String certidao;

	@Column(length = 255)
	private String emissor;

	@Column(length = 500)
	private String motivo;

	private Date inicioPeriodoReferencia;
	private Date fimPeriodoReferencia;

	@Column(length = 60)
	private String descricaoPeriodoReferencia;
	private Integer numeroReferencia;

	@Column(length = 60)
	private Integer descricaoNumeroFererencia;
	private Date dataSituacao;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoAverbacaoTempo situacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoAverbacaoTempo() {
		super();
	}

	public SolicitacaoAverbacaoTempo(Long id, Funcionario solicitante, TipoOperacaoAverbacao tipoOperacao,
			SolicitacaoAverbacaoTempo solicitacaoRelacionada, TipoTempoAverbacao tipoTempo, Date dataSolicitacao,
			Funcionario funcionario, Area area, FuncionarioCargo funcionarioCargo, String processo, String certidao,
			String emissor, String motivo, Date inicioPeriodoReferencia, Date fimPeriodoReferencia,
			String descricaoPeriodoReferencia, Integer numeroReferencia, Integer descricaoNumeroFererencia,
			Date dataSituacao, SituacaoSolicitacaoAverbacaoTempo situacao, String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.tipoOperacao = tipoOperacao;
		this.solicitacaoRelacionada = solicitacaoRelacionada;
		this.tipoTempo = tipoTempo;
		this.dataSolicitacao = dataSolicitacao;
		this.funcionario = funcionario;
		this.area = area;
		this.funcionarioCargo = funcionarioCargo;
		this.processo = processo;
		this.certidao = certidao;
		this.emissor = emissor;
		this.motivo = motivo;
		this.inicioPeriodoReferencia = inicioPeriodoReferencia;
		this.fimPeriodoReferencia = fimPeriodoReferencia;
		this.descricaoPeriodoReferencia = descricaoPeriodoReferencia;
		this.numeroReferencia = numeroReferencia;
		this.descricaoNumeroFererencia = descricaoNumeroFererencia;
		this.dataSituacao = dataSituacao;
		this.situacao = situacao;
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

	public TipoOperacaoAverbacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacaoAverbacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public SolicitacaoAverbacaoTempo getSolicitacaoRelacionada() {
		return solicitacaoRelacionada;
	}

	public void setSolicitacaoRelacionada(SolicitacaoAverbacaoTempo solicitacaoRelacionada) {
		this.solicitacaoRelacionada = solicitacaoRelacionada;
	}

	public TipoTempoAverbacao getTipoTempo() {
		return tipoTempo;
	}

	public void setTipoTempo(TipoTempoAverbacao tipoTempo) {
		this.tipoTempo = tipoTempo;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public String getCertidao() {
		return certidao;
	}

	public void setCertidao(String certidao) {
		this.certidao = certidao;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getInicioPeriodoReferencia() {
		return inicioPeriodoReferencia;
	}

	public void setInicioPeriodoReferencia(Date inicioPeriodoReferencia) {
		this.inicioPeriodoReferencia = inicioPeriodoReferencia;
	}

	public Date getFimPeriodoReferencia() {
		return fimPeriodoReferencia;
	}

	public void setFimPeriodoReferencia(Date fimPeriodoReferencia) {
		this.fimPeriodoReferencia = fimPeriodoReferencia;
	}

	public String getDescricaoPeriodoReferencia() {
		return descricaoPeriodoReferencia;
	}

	public void setDescricaoPeriodoReferencia(String descricaoPeriodoReferencia) {
		this.descricaoPeriodoReferencia = descricaoPeriodoReferencia;
	}

	public Integer getNumeroReferencia() {
		return numeroReferencia;
	}

	public void setNumeroReferencia(Integer numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	public Integer getDescricaoNumeroFererencia() {
		return descricaoNumeroFererencia;
	}

	public void setDescricaoNumeroFererencia(Integer descricaoNumeroFererencia) {
		this.descricaoNumeroFererencia = descricaoNumeroFererencia;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoSolicitacaoAverbacaoTempo getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoAverbacaoTempo situacao) {
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
		SolicitacaoAverbacaoTempo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoAverbacaoTempo [id=" + id + ", solicitante=" + solicitante + ", tipoOperacao="
				+ tipoOperacao + ", solicitacaoRelacionada=" + solicitacaoRelacionada + ", tipoTempo=" + tipoTempo
				+ ", dataSolicitacao=" + dataSolicitacao + ", funcionario=" + funcionario + ", area=" + area
				+ ", funcionarioCargo=" + funcionarioCargo + ", processo=" + processo + ", certidao=" + certidao
				+ ", emissor=" + emissor + ", motivo=" + motivo + ", inicioPeriodoReferencia="
				+ inicioPeriodoReferencia + ", fimPeriodoReferencia=" + fimPeriodoReferencia
				+ ", descricaoPeriodoReferencia=" + descricaoPeriodoReferencia + ", numeroReferencia="
				+ numeroReferencia + ", descricaoNumeroFererencia=" + descricaoNumeroFererencia + ", dataSituacao="
				+ dataSituacao + ", situacao=" + situacao + ", parecer=" + parecer + "]";
	}

}