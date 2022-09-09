package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaSuperiorTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AreaSuperior implements Serializable {

	private static final long serialVersionUID = -9071168987256684306L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	@ManyToOne
	@JoinColumn(name = "areaSuperior_id", nullable = false)
	private Area areaSuperior;

	private Date dataFim;
	private Date dataInicio;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	public AreaSuperior() {
		super();
	}

	public AreaSuperior(Long id, Area area, Area areaSuperior, Date dataFim, Date dataInicio,
			AtoAdministrativo atoAdministrativo) {
		super();
		this.id = id;
		this.area = area;
		this.areaSuperior = areaSuperior;
		this.dataFim = dataFim;
		this.dataInicio = dataInicio;
		this.atoAdministrativo = atoAdministrativo;
	}

	public AreaSuperior(Area area, AreaSuperiorTO areaSuperiorTO) {
		this.area = area;
		this.areaSuperior = new Area(areaSuperiorTO.getAreaSuperiorId());
		this.dataFim = areaSuperiorTO.getDataFim();
		this.dataInicio = areaSuperiorTO.getDataFim();
		this.atoAdministrativo = new AtoAdministrativo(areaSuperiorTO.getAtoAdministrativoId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Area getAreaSuperior() {
		return areaSuperior;
	}

	public void setAreaSuperior(Area areaSuperior) {
		this.areaSuperior = areaSuperior;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaSuperior that = (AreaSuperior) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(area, that.area) &&
                Objects.equals(areaSuperior, that.areaSuperior) &&
                Objects.equals(dataFim, that.dataFim) &&
                Objects.equals(dataInicio, that.dataInicio) &&
                Objects.equals(atoAdministrativo, that.atoAdministrativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, areaSuperior, dataFim, dataInicio, atoAdministrativo);
    }

    @Override
	public String toString() {
		return "AreaSuperior [id=" + id + ", area=" + area + ", areaSuperior=" + areaSuperior + ", atoAdministrativo="
				+ atoAdministrativo + "]";
	}

	public void alterar(Area area, AreaSuperiorTO areaSuperiorTO) {
		this.area = area;
		this.areaSuperior = new Area(areaSuperiorTO.getAreaSuperiorId());
		this.dataFim = areaSuperiorTO.getDataFim();
		this.dataInicio = areaSuperiorTO.getDataFim();
		this.atoAdministrativo = new AtoAdministrativo(areaSuperiorTO.getAtoAdministrativoId());
	}
}