package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoParametroHoraExtra;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
public class ParametrosHoraExtra implements Serializable {

	private static final long serialVersionUID = -527775569406540397L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date inicioVigencia;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoParametroHoraExtra tipoParametro;
	
	private Boolean ativo;
	private Date faixaHorasInicio;
	private Date faixaHorasFim;
	private Date horarioInicio;
	private Date horarioFim;
	private Double percentualExtra;
	private Double percentualAdicional;

	public ParametrosHoraExtra() {
		super();
	}

	public ParametrosHoraExtra(Long id, Date inicioVigencia, TipoParametroHoraExtra tipoParametro, Boolean ativo,
			Date faixaHorasInicio, Date faixaHorasFim, Date horarioInicio, Date horarioFim, Double percentualExtra,
			Double percentualAdicional) {
		super();
		this.id = id;
		this.inicioVigencia = inicioVigencia;
		this.tipoParametro = tipoParametro;
		this.ativo = ativo;
		this.faixaHorasInicio = faixaHorasInicio;
		this.faixaHorasFim = faixaHorasFim;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.percentualExtra = percentualExtra;
		this.percentualAdicional = percentualAdicional;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public TipoParametroHoraExtra getTipoParametro() {
		return tipoParametro;
	}

	public void setTipoParametro(TipoParametroHoraExtra tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getFaixaHorasInicio() {
		return faixaHorasInicio;
	}

	public void setFaixaHorasInicio(Date faixaHorasInicio) {
		this.faixaHorasInicio = faixaHorasInicio;
	}

	public Date getFaixaHorasFim() {
		return faixaHorasFim;
	}

	public void setFaixaHorasFim(Date faixaHorasFim) {
		this.faixaHorasFim = faixaHorasFim;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Double getPercentualExtra() {
		return percentualExtra;
	}

	public void setPercentualExtra(Double percentualExtra) {
		this.percentualExtra = percentualExtra;
	}

	public Double getPercentualAdicional() {
		return percentualAdicional;
	}

	public void setPercentualAdicional(Double percentualAdicional) {
		this.percentualAdicional = percentualAdicional;
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
		ParametrosHoraExtra other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	@Override
	public String toString() {
		return "ParametrosHoraExtra [id=" + id + ", inicioVigencia=" + inicioVigencia + ", tipoParametro="
				+ tipoParametro + ", ativo=" + ativo + ", faixaHorasInicio=" + faixaHorasInicio + ", faixaHorasFim="
				+ faixaHorasFim + ", horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim
				+ ", percentualExtra=" + percentualExtra + ", percentualAdicional=" + percentualAdicional + "]";
	}

}