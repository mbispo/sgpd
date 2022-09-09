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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaLocalidadeTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
@NamedQuery(name = "areaLocalidade.buscarLocalidadesPorArea", 
		query = "SELECT a.localidade from AreaLocalidade a WHERE a.area.id = :areaId")
})
public class AreaLocalidade implements Serializable {

	private static final long serialVersionUID = -2301098245916082758L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	@ManyToOne
	@JoinColumn(name = "localidade_id", nullable = false)
	private Localidade localidade;

	private Date dataInicio;
	private Date dataFim;

	public AreaLocalidade() {
		super();
	}

	public AreaLocalidade(Long id, Area area, Localidade localidade, Date dataInicio, Date dataFim) {
		super();
		this.id = id;
		this.area = area;
		this.localidade = localidade;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	public AreaLocalidade(AreaLocalidadeTO areaLocalidadeTO) {
		//FIXME this.area = areaLocalidadeTO.getAreaId();
		//FIXME this.localidade = areaLocalidadeTO.getLocalidadeId();
		this.dataInicio = areaLocalidadeTO.getDataInicio();
		this.dataFim = areaLocalidadeTO.getDataFim();
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

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaLocalidade that = (AreaLocalidade) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(area, that.area) &&
                Objects.equals(localidade, that.localidade) &&
                Objects.equals(dataInicio, that.dataInicio) &&
                Objects.equals(dataFim, that.dataFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, localidade, dataInicio, dataFim);
    }

    @Override
	public String toString() {
		return "AreaLocalidade [id=" + id + ", area=" + area + ", localidade=" + localidade + "]";
	}

	public void alterar(AreaLocalidadeTO areaLocalidadeTO) {
		//FIXME this.area = areaLocalidadeTO.getAreaId();
		//FIXME this.localidade = areaLocalidadeTO.getLocalidadeId();
		this.dataInicio = areaLocalidadeTO.getDataInicio();
		this.dataFim = areaLocalidadeTO.getDataFim();
	}
}