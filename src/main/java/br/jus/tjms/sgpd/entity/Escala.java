package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoEscala;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:57
 */
@Entity
@Auditavel
@Cacheable
public class Escala implements Serializable {

	private static final long serialVersionUID = -4899846409475915515L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoEscala tipoEscala;
	
	@ManyToOne
	@JoinColumn(name="localidade_id")
	private Localidade localidade;
	
	@Column(length = 60)
	private String descricao;
	
	private Date vigenciaFim;
	private Date vigenciaInicio;
	private Date horaEntrada;
	private Date horaSaida;
	private Integer horasDescanso;
	private Integer horasTrabalho;
	private Boolean ativa;

	public Escala() {
		super();
	}

	public Escala(Long id, TipoEscala tipoEscala, Localidade localidade, String descricao, Date vigenciaFim,
			Date vigenciaInicio, Date horaEntrada, Date horaSaida, Integer horasDescanso, Integer horasTrabalho,
			Boolean ativa) {
		super();
		this.id = id;
		this.tipoEscala = tipoEscala;
		this.localidade = localidade;
		this.descricao = descricao;
		this.vigenciaFim = vigenciaFim;
		this.vigenciaInicio = vigenciaInicio;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.horasDescanso = horasDescanso;
		this.horasTrabalho = horasTrabalho;
		this.ativa = ativa;
	}

	public Escala(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEscala getTipoEscala() {
		return tipoEscala;
	}

	public void setTipoEscala(TipoEscala tipoEscala) {
		this.tipoEscala = tipoEscala;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Integer getHorasDescanso() {
		return horasDescanso;
	}

	public void setHorasDescanso(Integer horasDescanso) {
		this.horasDescanso = horasDescanso;
	}

	public Integer getHorasTrabalho() {
		return horasTrabalho;
	}

	public void setHorasTrabalho(Integer horasTrabalho) {
		this.horasTrabalho = horasTrabalho;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
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
		Escala other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	@Override
	public String toString() {
		return "Escala [id=" + id + ", tipoEscala=" + tipoEscala + ", localidade=" + localidade + ", descricao="
				+ descricao + ", vigenciaFim=" + vigenciaFim + ", vigenciaInicio=" + vigenciaInicio + ", horaEntrada="
				+ horaEntrada + ", horaSaida=" + horaSaida + ", horasDescanso=" + horasDescanso + ", horasTrabalho="
				+ horasTrabalho + ", ativa=" + ativa + "]";
	}


	
}