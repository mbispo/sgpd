package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoAutorizacaoHoraExtra;
import br.jus.tjms.sgpd.enumerators.TipoAutorizacaoHoraExtra;
import br.jus.tjms.sgpd.enumerators.TipoDocumento;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AutorizacaoHoraExtra implements Serializable {

	private static final long serialVersionUID = 6431669090915187951L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoHoraExtra solicitacao;

	@Enumerated(EnumType.ORDINAL)
	private TipoAutorizacaoHoraExtra tipo;

	@ManyToOne
	@JoinColumn(name = "autorizador_id", nullable = false)
	private Funcionario autorizador;

	private Date dataAutorizacao;

	@Column(length = 60)
	private String documento;

	@Enumerated(EnumType.ORDINAL)
	private TipoDocumento tipoDocumento;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	private Date periodoInicio;
	private Date periodoFim;
	private Boolean incluiSabado;
	private Boolean incluiDomingo;
	private Boolean incluiFeriado;
	private Boolean preTurno;
	private Boolean posTurno;
	private Date horaInicio;
	private Date horaFim;
	private Date minimoHorasAutorizado;
	private Date maximoHorasAutorizado;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoAutorizacaoHoraExtra situacao;
	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public AutorizacaoHoraExtra() {
		super();
	}

	public AutorizacaoHoraExtra(Long id, SolicitacaoHoraExtra solicitacao, TipoAutorizacaoHoraExtra tipo,
			Funcionario autorizador, Date dataAutorizacao, String documento, TipoDocumento tipoDocumento,
			AtoAdministrativo atoAdministrativo, Date periodoInicio, Date periodoFim, Boolean incluiSabado,
			Boolean incluiDomingo, Boolean incluiFeriado, Boolean preTurno, Boolean posTurno, Date horaInicio,
			Date horaFim, Date minimoHorasAutorizado, Date maximoHorasAutorizado,
			SituacaoAutorizacaoHoraExtra situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.tipo = tipo;
		this.autorizador = autorizador;
		this.dataAutorizacao = dataAutorizacao;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.atoAdministrativo = atoAdministrativo;
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.incluiSabado = incluiSabado;
		this.incluiDomingo = incluiDomingo;
		this.incluiFeriado = incluiFeriado;
		this.preTurno = preTurno;
		this.posTurno = posTurno;
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

	public SolicitacaoHoraExtra getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoHoraExtra solicitacao) {
		this.solicitacao = solicitacao;
	}

	public TipoAutorizacaoHoraExtra getTipo() {
		return tipo;
	}

	public void setTipo(TipoAutorizacaoHoraExtra tipo) {
		this.tipo = tipo;
	}

	public Funcionario getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(Funcionario autorizador) {
		this.autorizador = autorizador;
	}

	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}

	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
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

	public Boolean getPreTurno() {
		return preTurno;
	}

	public void setPreTurno(Boolean preTurno) {
		this.preTurno = preTurno;
	}

	public Boolean getPosTurno() {
		return posTurno;
	}

	public void setPosTurno(Boolean posTurno) {
		this.posTurno = posTurno;
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

	public SituacaoAutorizacaoHoraExtra getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAutorizacaoHoraExtra situacao) {
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
		AutorizacaoHoraExtra other = (AutorizacaoHoraExtra) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "AutorizacaoHoraExtra [id=" + id + ", solicitacao=" + solicitacao + ", tipo=" + tipo + ", autorizador="
				+ autorizador + ", documento=" + documento + ", tipoDocumento=" + tipoDocumento
				+ ", atoAdministrativo=" + atoAdministrativo + ", incluiSabado=" + incluiSabado + ", incluiDomingo="
				+ incluiDomingo + ", incluiFeriado=" + incluiFeriado + ", preTurno=" + preTurno + ", posTurno="
				+ posTurno + ", situacao=" + situacao + ", parecer=" + parecer + "]";
	}

}