package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.service.rest.v1.to.FuncionarioAreaTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "funcionarioArea.buscarFuncionariosPorArea", 
			query = "SELECT f FROM FuncionarioArea f WHERE f.area.id = :areaId" ),
	@NamedQuery(name = "funcionarioArea.buscarAreasPorFuncionario", 
			query = "SELECT f FROM FuncionarioArea f WHERE f.funcionario.id = :funcionarioId" ),
})
public class FuncionarioArea implements Serializable {

	private static final long serialVersionUID = -1705533473108289307L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	private Date dataInicio;
	private Date dataFim;

	public FuncionarioArea() {
		super();
	}

	public FuncionarioArea(Long id) {
		super();
		this.id = id;
	}

	public FuncionarioArea(Long id, Funcionario funcionario, Area area, Date dataInicio, Date dataFim) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.area = area;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public FuncionarioArea(FuncionarioAreaTO funcionarioAreaTO) {
		super();
		this.id = funcionarioAreaTO.getId();
		this.funcionario = new Funcionario(funcionarioAreaTO.getFuncionarioId());
		this.area = new Area(funcionarioAreaTO.getAreaId());
		this.dataInicio = funcionarioAreaTO.getDataInicio();
		this.dataFim = funcionarioAreaTO.getDataFim();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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
		FuncionarioArea other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FuncionarioArea [id=" + id + ", funcionario=" + funcionario + ", area=" + area + ", dataInicio="
				+ dataInicio + ", dataFim=" + dataFim + "]";
	}

	public void alterar(FuncionarioAreaTO funcionarioAreaTO) {
		this.funcionario = new Funcionario(funcionarioAreaTO.getFuncionarioId());
		this.area = new Area(funcionarioAreaTO.getAreaId());
		this.dataInicio = funcionarioAreaTO.getDataInicio();
		this.dataFim = funcionarioAreaTO.getDataFim();
	}
	
	public FuncionarioAreaTO toTO() {
		return new FuncionarioAreaTO(id,funcionario.getId(),this.area.getId(),dataInicio,dataFim);
	}

}