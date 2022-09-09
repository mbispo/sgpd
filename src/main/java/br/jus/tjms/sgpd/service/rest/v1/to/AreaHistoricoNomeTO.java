package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AreaHistoricoNomeTO implements Serializable {

	private static final long serialVersionUID = -3341359546712496986L;
	
	private Long id;
	private Long areaId;
	private String nome;
	private Date vigenciaInicio;
	private Date vigenciaFim;
	private Long atoAdministrativoId;

	public AreaHistoricoNomeTO() {
		super();
	}

	public AreaHistoricoNomeTO(Long id, Long areaId, String nome, Date vigenciaInicio, Date vigenciaFim,
			Long atoAdministrativoId) {
		super();
		this.id = id;
		this.areaId = areaId;
		this.nome = nome;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.atoAdministrativoId = atoAdministrativoId;
	}

	public AreaHistoricoNomeTO(Long areaId, String nome, Date vigenciaInicio, Date vigenciaFim,
			Long atoAdministrativoId) {
		super();
		this.areaId = areaId;
		this.nome = nome;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.atoAdministrativoId = atoAdministrativoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Long getAtoAdministrativoId() {
		return atoAdministrativoId;
	}

	public void setAtoAdministrativoId(Long atoAdministrativoId) {
		this.atoAdministrativoId = atoAdministrativoId;
	}

	@Override
	public String toString() {
		return "AreaHistoricoNomeTO [id=" + id + ", areaId=" + areaId + ", nome=" + nome + ", vigenciaInicio="
				+ vigenciaInicio + ", vigenciaFim=" + vigenciaFim + ", atoAdministrativoId=" + atoAdministrativoId
				+ "]";
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
		AreaHistoricoNomeTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}