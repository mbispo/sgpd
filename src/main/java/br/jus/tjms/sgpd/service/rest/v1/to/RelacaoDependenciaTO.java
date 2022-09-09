package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.MotivoInicioRelacaoDependencia;
import br.jus.tjms.sgpd.enumerators.MotivoTerminoRelacaoDependencia;
import br.jus.tjms.sgpd.enumerators.TipoRelacaoDependencia;

public class RelacaoDependenciaTO implements Serializable {

	private static final long serialVersionUID = -7498773928268078450L;
	
	private Long id;
	private Long pessoaId;
	private Long pessoaRelacionadaId;
	private TipoRelacaoDependencia tipo;
	private MotivoInicioRelacaoDependencia motivoInicio;
	private MotivoTerminoRelacaoDependencia motivoTermino;
	private Boolean economica;
	private Boolean previdenciaria;
	private Boolean impostoDeRenda;
	private Date inicio;
	private Date fim;

	public RelacaoDependenciaTO() {
		super();
	}

	public RelacaoDependenciaTO(Long id, Long pessoaId, Long pessoaRelacionadaId, TipoRelacaoDependencia tipo,
			MotivoInicioRelacaoDependencia motivoInicio, MotivoTerminoRelacaoDependencia motivoTermino, Boolean economica, Boolean previdenciaria, Boolean impostoDeRenda,
			Date inicio, Date fim) {
		super();
		this.id = id;
		this.pessoaId = pessoaId;
		this.pessoaRelacionadaId = pessoaRelacionadaId;
		this.tipo = tipo;
		this.motivoInicio = motivoInicio;
		this.motivoTermino = motivoTermino;
		this.economica = economica;
		this.previdenciaria = previdenciaria;
		this.impostoDeRenda = impostoDeRenda;
		this.inicio = inicio;
		this.fim = fim;
	}

	public RelacaoDependenciaTO(Long pessoaId, Long pessoaRelacionadaId, TipoRelacaoDependencia tipo,
			MotivoInicioRelacaoDependencia motivoInicio, MotivoTerminoRelacaoDependencia motivoTermino, Boolean economica, Boolean previdenciaria, Boolean impostoDeRenda,
			Date inicio, Date fim) {
		super();
		this.pessoaId = pessoaId;
		this.pessoaRelacionadaId = pessoaRelacionadaId;
		this.tipo = tipo;
		this.motivoInicio = motivoInicio;
		this.motivoTermino = motivoTermino;
		this.economica = economica;
		this.previdenciaria = previdenciaria;
		this.impostoDeRenda = impostoDeRenda;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Long getPessoaRelacionadaId() {
		return pessoaRelacionadaId;
	}

	public void setPessoaRelacionadaId(Long pessoaRelacionadaId) {
		this.pessoaRelacionadaId = pessoaRelacionadaId;
	}

	public TipoRelacaoDependencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoRelacaoDependencia tipo) {
		this.tipo = tipo;
	}

	public MotivoInicioRelacaoDependencia getMotivoInicio() {
		return motivoInicio;
	}

	public void setMotivoInicio(MotivoInicioRelacaoDependencia motivoInicio) {
		this.motivoInicio = motivoInicio;
	}

	public MotivoTerminoRelacaoDependencia getMotivoTermino() {
		return motivoTermino;
	}

	public void setMotivoTermino(MotivoTerminoRelacaoDependencia motivoTermino) {
		this.motivoTermino = motivoTermino;
	}

	public Boolean getEconomica() {
		return economica;
	}

	public void setEconomica(Boolean economica) {
		this.economica = economica;
	}

	public Boolean getPrevidenciaria() {
		return previdenciaria;
	}

	public void setPrevidenciaria(Boolean previdenciaria) {
		this.previdenciaria = previdenciaria;
	}

	public Boolean getImpostoDeRenda() {
		return impostoDeRenda;
	}

	public void setImpostoDeRenda(Boolean impostoDeRenda) {
		this.impostoDeRenda = impostoDeRenda;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	@Override
	public String toString() {
		return "RelacaoDependenciaTO [id=" + id + ", pessoaId=" + pessoaId + ", pessoaRelacionadaId="
				+ pessoaRelacionadaId + ", tipo=" + tipo + ", motivoInicio=" + motivoInicio + ", motivoTermino="
				+ motivoTermino + ", economica=" + economica + ", previdenciaria=" + previdenciaria
				+ ", impostoDeRenda=" + impostoDeRenda + ", inicio=" + inicio + ", fim=" + fim+ "]";
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
		RelacaoDependenciaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}