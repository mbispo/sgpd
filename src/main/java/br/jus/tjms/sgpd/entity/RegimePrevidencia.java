package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoRegimePrevidenciario;
import br.jus.tjms.sgpd.service.rest.v1.to.RegimePrevidenciaTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "regimePrecidencia.buscarPorEntidade",
			query = "SELECT r FROM RegimePrevidencia r WHERE r.entidadePrevidenciaria.id = :entidadePrevidenciariaId"),
	@NamedQuery(name = "regimePrecidencia.buscarPorRegimeJuridico",
			query = "SELECT r FROM RegimePrevidencia r WHERE r.regimeJuridico.id = :regimeJuridicoId")
})
public class RegimePrevidencia implements Serializable {

	private static final long serialVersionUID = -6435992496169134199L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "regimeJuridico_id", nullable = false)
	private RegimeJuridico regimeJuridico;

	@ManyToOne
	@JoinColumn(name = "entidadePrevidenciaria_id", nullable = false)
	private EntidadePrevidenciaria entidadePrevidenciaria;

	@Enumerated(EnumType.ORDINAL)
	private TipoRegimePrevidenciario tipoRegimePrevidenciario;

	public RegimePrevidencia() {
		super();
	}
	
	public RegimePrevidencia(Long id) {
		super();
		this.id = id;
	}

	public RegimePrevidencia(Long id, String descricao, RegimeJuridico regimeJuridico,
			EntidadePrevidenciaria entidadePrevidenciaria, TipoRegimePrevidenciario tipoRegimePrevidenciario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.regimeJuridico = regimeJuridico;
		this.entidadePrevidenciaria = entidadePrevidenciaria;
		this.tipoRegimePrevidenciario = tipoRegimePrevidenciario;
	}

	public RegimePrevidencia(RegimePrevidenciaTO regimePrevidenciaTO) {
		this.descricao = regimePrevidenciaTO.getDescricao();
//FIXME	this.regimeJuridico = regimePrevidenciaTO.getRegimeJuridicoId();
//FIXME	this.entidadePrevidenciaria = regimePrevidenciaTO.getEntidadePrevidenciariaId();
		this.tipoRegimePrevidenciario = regimePrevidenciaTO.getTipoRegimePrevidenciario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public RegimeJuridico getRegimeJuridico() {
		return regimeJuridico;
	}

	public void setRegimeJuridico(RegimeJuridico regimeJuridico) {
		this.regimeJuridico = regimeJuridico;
	}

	public EntidadePrevidenciaria getEntidadePrevidenciaria() {
		return entidadePrevidenciaria;
	}

	public void setEntidadePrevidenciaria(EntidadePrevidenciaria entidadePrevidenciaria) {
		this.entidadePrevidenciaria = entidadePrevidenciaria;
	}

	public TipoRegimePrevidenciario getTipoRegimePrevidenciario() {
		return tipoRegimePrevidenciario;
	}

	public void setTipoRegimePrevidenciario(TipoRegimePrevidenciario tipoRegimePrevidenciario) {
		this.tipoRegimePrevidenciario = tipoRegimePrevidenciario;
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
		RegimePrevidencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RegimePrevidencia [id=" + id + ", descricao=" + descricao + ", regimeJuridico=" + regimeJuridico
				+ ", entidadePrevidenciaria=" + entidadePrevidenciaria + ", tipoRegimePrevidenciario="
				+ tipoRegimePrevidenciario + "]";
	}

	public void alterar(RegimePrevidenciaTO regimePrevidenciaTO) {
		this.descricao = regimePrevidenciaTO.getDescricao();
//FIXME	this.regimeJuridico = regimePrevidenciaTO.getRegimeJuridicoId();
//FIXME	this.entidadePrevidenciaria = regimePrevidenciaTO.getEntidadePrevidenciariaId();
		this.tipoRegimePrevidenciario = regimePrevidenciaTO.getTipoRegimePrevidenciario();
	}
}