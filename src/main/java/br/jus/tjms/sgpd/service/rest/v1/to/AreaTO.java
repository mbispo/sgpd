package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AreaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Boolean ativo;
	private Date vigenciaInicio;
	private Date vigenciaFim;
	private Long atoAdministrativoCriacaoId;
	private Long atoAdministrativoExtincaoId;

	public AreaTO() {
		super();
	}

	public AreaTO(Long id, String nome, Boolean ativo, Date vigenciaInicio, Date vigenciaFim,
			Long atoAdministrativoCriacaoId, Long atoAdministrativoExtincaoId) {
		super();
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.atoAdministrativoCriacaoId = atoAdministrativoCriacaoId;
		this.atoAdministrativoExtincaoId = atoAdministrativoExtincaoId;
	}

	public AreaTO(String nome, Boolean ativo, Date vigenciaInicio, Date vigenciaFim, Long atoAdministrativoCriacaoId,
			Long atoAdministrativoExtincaoId) {
		super();
		this.nome = nome;
		this.ativo = ativo;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.atoAdministrativoCriacaoId = atoAdministrativoCriacaoId;
		this.atoAdministrativoExtincaoId = atoAdministrativoExtincaoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	public Long getAtoAdministrativoCriacaoId() {
		return atoAdministrativoCriacaoId;
	}

	public void setAtoAdministrativoCriacaoId(Long atoAdministrativoCriacaoId) {
		this.atoAdministrativoCriacaoId = atoAdministrativoCriacaoId;
	}

	public Long getAtoAdministrativoExtincaoId() {
		return atoAdministrativoExtincaoId;
	}

	public void setAtoAdministrativoExtincaoId(Long atoAdministrativoExtincaoId) {
		this.atoAdministrativoExtincaoId = atoAdministrativoExtincaoId;
	}

	@Override
	public String toString() {
		return "AreaTO [id=" + id + ", nome=" + nome + ", ativo=" + ativo + ", vigenciaInicio=" + vigenciaInicio
				+ ", vigenciaFim=" + vigenciaFim + ", atoAdministrativoCriacaoId=" + atoAdministrativoCriacaoId
				+ ", atoAdministrativoExtincaoId=" + atoAdministrativoExtincaoId + "]";
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
		AreaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}