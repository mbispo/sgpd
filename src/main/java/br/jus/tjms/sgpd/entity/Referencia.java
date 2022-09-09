package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.ReferenciaTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ReferenciaValorTO;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "referencia.buscarPorSigla", 
			query = "SELECT r FROM Referencia r WHERE r.sigla = :sigla")
})
public class Referencia implements Serializable {

	private static final long serialVersionUID = 1066521504526950666L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String sigla;

	private Integer nivel;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = true)
	private Cargo cargo;
	
	@OrderBy("vigenciaInicio, vigenciaFim")
	@OneToMany(mappedBy = "referencia", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<ReferenciaValor> valores = new ArrayList<ReferenciaValor>();

	public Referencia() {
		super();
	}
	
	public Referencia(Long id) {
		super();
		this.id = id;
	}

	public Referencia(Long id, String sigla, Integer nivel, Cargo cargo, List<ReferenciaValor> valores) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nivel = nivel;
		this.cargo = cargo;
		this.valores = valores;
	}

	public Referencia(Cargo cargo, ReferenciaTO referenciaTO) {
		this.sigla = referenciaTO.getSigla();
		this.nivel = referenciaTO.getNivel();
		this.cargo = cargo;
		if (referenciaTO.getValores()!=null) {
			for (ReferenciaValorTO referenciaValorTO : referenciaTO.getValores()) {
				this.valores.add(new ReferenciaValor(referenciaValorTO));	
			}
			
		}
	}
	
	public Referencia(ReferenciaTO referenciaTO) {
		this.sigla = referenciaTO.getSigla();
		this.nivel = referenciaTO.getNivel();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<ReferenciaValor> getValores() {
		return valores;
	}

	public void setValores(List<ReferenciaValor> valores) {
		this.valores = valores;
	}
	
	@Transient
	public ReferenciaValor getValorAtual(final Date data) {
		ReferenciaValor referenciaValorAtual = null;
		
		if (valores != null) {
			Collection<ReferenciaValor> c = Collections2.filter(valores, new Predicate<ReferenciaValor>() {
				@Override
				public boolean apply(ReferenciaValor r) {
					return (r.getVigenciaInicio().before(data) && ((r.getVigenciaFim()!=null&&r.getVigenciaFim().after(data))||r.getVigenciaFim()==null)); 
				}
			});
			
			if (c != null && !c.isEmpty()) {
				List<ReferenciaValor> lista = new ArrayList<>(c);
				referenciaValorAtual = lista.get(0);
			}
		}
		
		return referenciaValorAtual;
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
		Referencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Referencia [id=" + id + ", sigla=" + sigla + ", nivel=" + nivel + ", cargo=" + cargo + "]";
	}

	public void alterar (Cargo cargo, ReferenciaTO referenciaTO) {
		this.sigla = referenciaTO.getSigla();
		this.nivel = referenciaTO.getNivel();
		this.cargo = cargo;
		if (referenciaTO.getValores()!=null) {
			for (ReferenciaValorTO referenciaValorTO : referenciaTO.getValores()) {
				this.valores.add(new ReferenciaValor(referenciaValorTO));	
			}
			
		}
	}
	
	public void alterar (ReferenciaTO referenciaTO) {
		this.sigla = referenciaTO.getSigla();
		this.nivel = referenciaTO.getNivel();
		if (referenciaTO.getValores()!=null) {
			for (ReferenciaValorTO referenciaValorTO : referenciaTO.getValores()) {
				this.valores.add(new ReferenciaValor(referenciaValorTO));	
			}
			
		}
	}
}