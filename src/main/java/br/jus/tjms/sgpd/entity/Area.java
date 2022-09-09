package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "area.buscarAreasPorNome", 
			query = "SELECT a from Area a WHERE a.nome = :nome")
})
public class Area implements Serializable {

	private static final long serialVersionUID = -8928279045732848119L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	private Boolean ativo;
	private Date vigenciaInicio;
	private Date vigenciaFim;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "atoAdministrativoCriacao_id", nullable = false)
	private AtoAdministrativo atoAdministrativoCriacao;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "atoAdministrativoExtincao_id", nullable = true)
	private AtoAdministrativo atoAdministrativoExtincao;
	
	@OrderBy("dataInicio desc, id desc")
	@OneToMany(mappedBy = "area", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<AreaSuperior> areasSuperiores = new ArrayList<AreaSuperior>();		

	public Area() {
		super();
	}

	public Area(Long id) {
		super();
		this.id = id;
	}

	public Area(Long id, String nome, Boolean ativo, Date vigenciaInicio, Date vigenciaFim,
			AtoAdministrativo atoAdministrativoCriacao, AtoAdministrativo atoAdministrativoExtincao) {
		super();
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
		this.atoAdministrativoCriacao = atoAdministrativoCriacao;
		this.atoAdministrativoExtincao = atoAdministrativoExtincao;
	}

	public Area(AreaTO areaTO) {
		this.id = areaTO.getId();
		this.nome = areaTO.getNome();
		this.ativo = areaTO.getAtivo();
		this.vigenciaInicio = areaTO.getVigenciaInicio();
		this.vigenciaFim = areaTO.getVigenciaFim();
		this.atoAdministrativoCriacao = new AtoAdministrativo(areaTO.getAtoAdministrativoCriacaoId());
		if (areaTO.getAtoAdministrativoExtincaoId()!=null) {
			this.atoAdministrativoExtincao = new AtoAdministrativo(areaTO.getAtoAdministrativoExtincaoId());
		}
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

	public AtoAdministrativo getAtoAdministrativoCriacao() {
		return atoAdministrativoCriacao;
	}

	public void setAtoAdministrativoCriacao(AtoAdministrativo atoAdministrativoCriacao) {
		this.atoAdministrativoCriacao = atoAdministrativoCriacao;
	}

	public AtoAdministrativo getAtoAdministrativoExtincao() {
		return atoAdministrativoExtincao;
	}

	public void setAtoAdministrativoExtincao(AtoAdministrativo atoAdministrativoExtincao) {
		this.atoAdministrativoExtincao = atoAdministrativoExtincao;
	}
	
	@Transient
	public AreaSuperior getAreaSuperiorAtivaNaData(final Date data) {
		/* usando guava */

		if (areasSuperiores != null) {
			Collection<AreaSuperior> c = Collections2.filter(areasSuperiores, new Predicate<AreaSuperior>() {
				@Override
				public boolean apply(AreaSuperior a) {					
					return ((a.getDataInicio()==null||a.getDataInicio().before(data))&&(a.getDataFim()==null||a.getDataFim().after(data)));
				}
			});
			
			if (c!=null&&!c.isEmpty()) {
				return (AreaSuperior) c.toArray()[0];
			}
			

		}
		
		return null;
	}
	
	@Transient
	public String getNomeCompleto() {
		String nomeCompleto = nome;
		
		AreaSuperior superior = getAreaSuperiorAtivaNaData(new Date());
		
		while (superior != null) {
			nomeCompleto = superior.getAreaSuperior().getNome() + ", "+nomeCompleto;
			superior = superior.getAreaSuperior().getAreaSuperiorAtivaNaData(new Date());
			System.out.println("nomeCompleto="+nomeCompleto);
		}
		
		return nomeCompleto;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(id, area.id) &&
                Objects.equals(nome, area.nome) &&
                Objects.equals(ativo, area.ativo) &&
                Objects.equals(vigenciaInicio, area.vigenciaInicio) &&
                Objects.equals(vigenciaFim, area.vigenciaFim) &&
                Objects.equals(atoAdministrativoCriacao, area.atoAdministrativoCriacao) &&
                Objects.equals(atoAdministrativoExtincao, area.atoAdministrativoExtincao) &&
                Objects.equals(areasSuperiores, area.areasSuperiores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, ativo, vigenciaInicio, vigenciaFim, atoAdministrativoCriacao, atoAdministrativoExtincao, areasSuperiores);
    }

    @Override
	public String toString() {
		return "Area [id=" + id + ", nome=" + nome + ", ativo=" + ativo + ", atoAdministrativoCriacao="
				+ atoAdministrativoCriacao + ", atoAdministrativoExtincao=" + atoAdministrativoExtincao + "]";
	}

	public void alterar(AreaTO areaTO) {
		this.nome = areaTO.getNome();
		this.ativo = areaTO.getAtivo();
		this.vigenciaInicio = areaTO.getVigenciaInicio();
		this.vigenciaFim = areaTO.getVigenciaFim();
		this.atoAdministrativoCriacao = new AtoAdministrativo(areaTO.getAtoAdministrativoCriacaoId());
		if (areaTO.getAtoAdministrativoExtincaoId()!=null) {
			this.atoAdministrativoExtincao = new AtoAdministrativo(areaTO.getAtoAdministrativoExtincaoId());
		}
		
	}

}