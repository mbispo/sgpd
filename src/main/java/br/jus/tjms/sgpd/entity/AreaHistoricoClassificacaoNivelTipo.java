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
import br.jus.tjms.sgpd.service.rest.v1.to.AreaHistoricoClassificacaoNivelTipoTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "areaHistoricoClassificacaoNivelTipo.buscarPorArea", 
			query = "SELECT a from AreaHistoricoClassificacaoNivelTipo a WHERE a.area.id = :areaId")
})
public class AreaHistoricoClassificacaoNivelTipo implements Serializable {

	private static final long serialVersionUID = -6336505533570193993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date dataFim;
	private Date dataInicio;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	@ManyToOne
	@JoinColumn(name = "classificacao_id", nullable = false)
	private ClassificacaoAreaNivelTipo classificacao;

	public AreaHistoricoClassificacaoNivelTipo() {
		super();
	}

	public AreaHistoricoClassificacaoNivelTipo(Date dataFim, Date dataInicio, Area area,
			ClassificacaoAreaNivelTipo classificacao) {
		super();
		this.dataFim = dataFim;
		this.dataInicio = dataInicio;
		this.area = area;
		this.classificacao = classificacao;
	}

	public AreaHistoricoClassificacaoNivelTipo(Area area,
			AreaHistoricoClassificacaoNivelTipoTO areaHistoricoClassificacaoNivelTipoTO) {
		this.dataFim = areaHistoricoClassificacaoNivelTipoTO.getDataFim();
		this.dataInicio = areaHistoricoClassificacaoNivelTipoTO.getDataInicio();
		this.area = area;
		//FIXME this.classificacao = areaHistoricoClassificacaoNivelTipoTO.getClassificacaoAreaNivelTipoId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ClassificacaoAreaNivelTipo getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoAreaNivelTipo classificacao) {
		this.classificacao = classificacao;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaHistoricoClassificacaoNivelTipo that = (AreaHistoricoClassificacaoNivelTipo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataFim, that.dataFim) &&
                Objects.equals(dataInicio, that.dataInicio) &&
                Objects.equals(area, that.area) &&
                Objects.equals(classificacao, that.classificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataFim, dataInicio, area, classificacao);
    }

    @Override
	public String toString() {
		return "AreaHistoricoClassificacaoNivelTipo [id=" + id + ", dataFim=" + dataFim + ", dataInicio=" + dataInicio
				+ ", area=" + area + ", classificacao=" + classificacao + "]";
	}
	
	public void alterar(Area area,
			AreaHistoricoClassificacaoNivelTipoTO areaHistoricoClassificacaoNivelTipoTO) {
		this.dataFim = areaHistoricoClassificacaoNivelTipoTO.getDataFim();
		this.dataInicio = areaHistoricoClassificacaoNivelTipoTO.getDataInicio();
		this.area = area;
		//FIXME this.classificacao = areaHistoricoClassificacaoNivelTipoTO.getClassificacaoAreaNivelTipoId();
	}
}