package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Column;
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
import br.jus.tjms.sgpd.service.rest.v1.to.AreaHistoricoNomeTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "areaHistoricoNome.buscarPorArea", 
			query = "SELECT a from AreaHistoricoNome a WHERE a.area.id = :areaId")
})
public class AreaHistoricoNome implements Serializable {

	private static final long serialVersionUID = -6753510740596346648L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	@Column(length = 200)
	private String nome;

	private Date vigenciaInicio;
	private Date vigenciaFim;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	public AreaHistoricoNome() {
		super();
	}

	public AreaHistoricoNome(Long id, Area area, String nome, Date vigenciaInicio, Date vigenciaFim,
			AtoAdministrativo atoAdministrativo) {
		super();
		this.id = id;
		this.area = area;
		this.nome = nome;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.atoAdministrativo = atoAdministrativo;
	}

	public AreaHistoricoNome(Area area, AreaHistoricoNomeTO areaHistoricoNomeTO) {
		this.area = area;
		this.nome = areaHistoricoNomeTO.getNome();
		this.vigenciaInicio = areaHistoricoNomeTO.getVigenciaInicio();
		this.vigenciaFim = areaHistoricoNomeTO.getVigenciaFim();
		//FIXME this.atoAdministrativo = areaHistoricoNomeTO.getAtoAdministrativoId();
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
        AreaHistoricoNome that = (AreaHistoricoNome) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(area, that.area) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(vigenciaInicio, that.vigenciaInicio) &&
                Objects.equals(vigenciaFim, that.vigenciaFim) &&
                Objects.equals(atoAdministrativo, that.atoAdministrativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, nome, vigenciaInicio, vigenciaFim, atoAdministrativo);
    }

    @Override
	public String toString() {
		return "AreaHistoricoNome [id=" + id + ", area=" + area + ", nome=" + nome + ", atoAdministrativo="
				+ atoAdministrativo + "]";
	}

	public void alterar(Area area, AreaHistoricoNomeTO areaHistoricoNomeTO) {
		this.area = area;
		this.nome = areaHistoricoNomeTO.getNome();
		this.vigenciaInicio = areaHistoricoNomeTO.getVigenciaInicio();
		this.vigenciaFim = areaHistoricoNomeTO.getVigenciaFim();
		//FIXME this.atoAdministrativo = areaHistoricoNomeTO.getAtoAdministrativoId();
	}
}