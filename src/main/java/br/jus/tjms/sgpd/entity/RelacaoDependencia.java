package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.MotivoInicioRelacaoDependencia;
import br.jus.tjms.sgpd.enumerators.MotivoTerminoRelacaoDependencia;
import br.jus.tjms.sgpd.enumerators.TipoRelacaoDependencia;
import br.jus.tjms.sgpd.service.rest.v1.to.RelacaoDependenciaTO;
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
@NamedQueries({
		@NamedQuery(name = "relacaoDependencia.buscarRelacoesDeDependenciaPorPessoa", query = "SELECT r from RelacaoDependencia r WHERE r.pessoa.id = :idPessoa") })
public class RelacaoDependencia implements Serializable {

	private static final long serialVersionUID = -5130853292897471317L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "relacionada_id", nullable = false)
	private Pessoa relacionada;

	@Enumerated(EnumType.ORDINAL)
	private TipoRelacaoDependencia tipo;

	@Enumerated(EnumType.ORDINAL)
	private MotivoInicioRelacaoDependencia motivoInicio;

	@Enumerated(EnumType.ORDINAL)
	private MotivoTerminoRelacaoDependencia motivoTermino;

	private Boolean economica;
	private Boolean previdenciaria;
	private Boolean impostoDeRenda;

	private Date inicio;
	private Date fim;

	public RelacaoDependencia() {
		super();
	}

	public RelacaoDependencia(Long id, Pessoa pessoa, Pessoa relacionada, TipoRelacaoDependencia tipo,
			MotivoInicioRelacaoDependencia motivoInicio, MotivoTerminoRelacaoDependencia motivoTermino,
			Boolean economica, Boolean previdenciaria, Boolean impostoDeRenda, Date inicio, Date fim) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.relacionada = relacionada;
		this.tipo = tipo;
		this.motivoInicio = motivoInicio;
		this.motivoTermino = motivoTermino;
		this.economica = economica;
		this.previdenciaria = previdenciaria;
		this.impostoDeRenda = impostoDeRenda;
		this.inicio = inicio;
		this.fim = fim;
	}

	public RelacaoDependencia(RelacaoDependenciaTO relacaoDependenciaTO) {
		super();
		this.pessoa = new Pessoa(relacaoDependenciaTO.getPessoaId());
		this.relacionada = new Pessoa(relacaoDependenciaTO.getPessoaRelacionadaId());
		this.tipo = relacaoDependenciaTO.getTipo();
		this.motivoInicio = relacaoDependenciaTO.getMotivoInicio();
		this.motivoTermino = relacaoDependenciaTO.getMotivoTermino();
		this.economica = relacaoDependenciaTO.getEconomica();
		this.previdenciaria = relacaoDependenciaTO.getPrevidenciaria();
		this.impostoDeRenda = relacaoDependenciaTO.getImpostoDeRenda();
		this.inicio = relacaoDependenciaTO.getInicio();
		this.fim = relacaoDependenciaTO.getFim();
	}

	public Long getId() {
		return id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getRelacionada() {
		return relacionada;
	}

	public void setRelacionada(Pessoa relacionada) {
		this.relacionada = relacionada;
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

	public void setId(Long id) {
		this.id = id;
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
		RelacaoDependencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RelacaoDependencia [id=" + id + ", pessoa=" + pessoa + ", relacionada=" + relacionada + ", tipo=" + tipo
				+ ", motivoInicio=" + motivoInicio + ", motivoTermino=" + motivoTermino + ", economica=" + economica
				+ ", previdenciaria=" + previdenciaria + ", impostoDeRenda=" + impostoDeRenda + ", inicio=" + inicio
				+ ", fim=" + fim + "]";
	}

	public void alterar(RelacaoDependenciaTO relacaoDependenciaTO) {
		this.pessoa = new Pessoa(relacaoDependenciaTO.getPessoaId());
		this.relacionada = new Pessoa(relacaoDependenciaTO.getPessoaRelacionadaId());
		this.tipo = relacaoDependenciaTO.getTipo();
		this.motivoInicio = relacaoDependenciaTO.getMotivoInicio();
		this.motivoTermino = relacaoDependenciaTO.getMotivoTermino();
		this.economica = relacaoDependenciaTO.getEconomica();
		this.previdenciaria = relacaoDependenciaTO.getPrevidenciaria();
		this.impostoDeRenda = relacaoDependenciaTO.getImpostoDeRenda();
		this.inicio = relacaoDependenciaTO.getInicio();
		this.fim = relacaoDependenciaTO.getFim();
	}

}