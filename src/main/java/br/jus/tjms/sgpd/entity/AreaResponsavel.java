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
import br.jus.tjms.sgpd.service.rest.v1.to.AreaResponsavelTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AreaResponsavel implements Serializable {

	private static final long serialVersionUID = -3261148213672003433L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;
	
	private Date dataInicio;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	private Date dataFim;

	public AreaResponsavel() {
		super();
	}

	public AreaResponsavel(Long id, Area area, Date dataInicio,
			Funcionario funcionario, Date dataFim) {
		super();
		this.id = id;
		this.area = area;
		this.dataInicio = dataInicio;
		this.funcionario = funcionario;
		this.dataFim = dataFim;
	}

	public AreaResponsavel(Area area, AreaResponsavelTO areaResponsavelTO) {
		this.area = area;
		this.dataInicio = areaResponsavelTO.getDataInicio();
		this.dataFim = areaResponsavelTO.getDataFim();
		//FIXME this.funcionario = areaResponsavelTO.getFuncionarioId();
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
        AreaResponsavel that = (AreaResponsavel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(area, that.area) &&
                Objects.equals(dataInicio, that.dataInicio) &&
                Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(dataFim, that.dataFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, dataInicio, funcionario, dataFim);
    }

    @Override
	public String toString() {
		return "AreaResponsavel [id=" + id + ", area=" + area
				+ ", funcionario=" + funcionario + "]";
	}

	public void alterar(Area area, AreaResponsavelTO areaResponsavelTO) {
		this.area = area;
		this.dataInicio = areaResponsavelTO.getDataInicio();
		this.dataFim = areaResponsavelTO.getDataFim();
		//FIXME this.funcionario = areaResponsavelTO.getFuncionarioId();
	}

}