package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoHoraExtra;
import br.jus.tjms.sgpd.enumerators.TipoDocumento;
import br.jus.tjms.sgpd.enumerators.TipoSolicitacaoHoraExtra;
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
public class SolicitacaoHoraExtra implements Serializable {

	private static final long serialVersionUID = 3064930151694148473L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@Enumerated(EnumType.ORDINAL)
	private TipoSolicitacaoHoraExtra tipo;

	private Date data;

	@Column(length = 500)
	private String justificativa;

	@Enumerated(EnumType.ORDINAL)
	private TipoDocumento tipoDocumento;

	@Column(length = 200)
	private String documento;

	private Date periodoInicio;
	private Date periodoFim;
	private Boolean incluiSabado;
	private Boolean incluiDomingo;
	private Boolean incluiFeriado;
	private Boolean posTurno;
	private Boolean preTurno;
	private Date horaInicio;
	private Date horaFim;
	private Date minimoHorasAutorizado;
	private Date maximoHorasAutorizado;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoHoraExtra situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoHoraExtra() {
		super();
	}

	public SolicitacaoHoraExtra(Long id, Funcionario solicitante, TipoSolicitacaoHoraExtra tipo, Date data,
			String justificativa, TipoDocumento tipoDocumento, String documento, Date periodoInicio, Date periodoFim,
			Boolean incluiSabado, Boolean incluiDomingo, Boolean incluiFeriado, Boolean posTurno, Boolean preTurno,
			Date horaInicio, Date horaFim, Date minimoHorasAutorizado, Date maximoHorasAutorizado,
			SituacaoSolicitacaoHoraExtra situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.tipo = tipo;
		this.data = data;
		this.justificativa = justificativa;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.incluiSabado = incluiSabado;
		this.incluiDomingo = incluiDomingo;
		this.incluiFeriado = incluiFeriado;
		this.posTurno = posTurno;
		this.preTurno = preTurno;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.minimoHorasAutorizado = minimoHorasAutorizado;
		this.maximoHorasAutorizado = maximoHorasAutorizado;
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

	public TipoSolicitacaoHoraExtra getTipo() {
		return tipo;
	}

	public void setTipo(TipoSolicitacaoHoraExtra tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public Date getPeriodoFim() {
		return periodoFim;
	}

	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}

	public Boolean getIncluiSabado() {
		return incluiSabado;
	}

	public void setIncluiSabado(Boolean incluiSabado) {
		this.incluiSabado = incluiSabado;
	}

	public Boolean getIncluiDomingo() {
		return incluiDomingo;
	}

	public void setIncluiDomingo(Boolean incluiDomingo) {
		this.incluiDomingo = incluiDomingo;
	}

	public Boolean getIncluiFeriado() {
		return incluiFeriado;
	}

	public void setIncluiFeriado(Boolean incluiFeriado) {
		this.incluiFeriado = incluiFeriado;
	}

	public Boolean getPosTurno() {
		return posTurno;
	}

	public void setPosTurno(Boolean posTurno) {
		this.posTurno = posTurno;
	}

	public Boolean getPreTurno() {
		return preTurno;
	}

	public void setPreTurno(Boolean preTurno) {
		this.preTurno = preTurno;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public Date getMinimoHorasAutorizado() {
		return minimoHorasAutorizado;
	}

	public void setMinimoHorasAutorizado(Date minimoHorasAutorizado) {
		this.minimoHorasAutorizado = minimoHorasAutorizado;
	}

	public Date getMaximoHorasAutorizado() {
		return maximoHorasAutorizado;
	}

	public void setMaximoHorasAutorizado(Date maximoHorasAutorizado) {
		this.maximoHorasAutorizado = maximoHorasAutorizado;
	}

	public SituacaoSolicitacaoHoraExtra getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoHoraExtra situacao) {
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
		SolicitacaoHoraExtra other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoHoraExtra [id=" + id + ", solicitante=" + solicitante + ", tipo=" + tipo + ", data=" + data
				+ ", justificativa=" + justificativa + ", tipoDocumento=" + tipoDocumento + ", documento=" + documento
				+ ", periodoInicio=" + periodoInicio + ", periodoFim=" + periodoFim + ", incluiSabado=" + incluiSabado
				+ ", incluiDomingo=" + incluiDomingo + ", incluiFeriado=" + incluiFeriado + ", posTurno=" + posTurno
				+ ", preTurno=" + preTurno + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim
				+ ", minimoHorasAutorizado=" + minimoHorasAutorizado + ", maximoHorasAutorizado="
				+ maximoHorasAutorizado + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer="
				+ parecer + "]";
	}

}