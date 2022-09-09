package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.ValorIndiceTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "valorIndice.buscarPorIndiceId", 
			query = "SELECT v FROM ValorIndice v WHERE v.indice.id = :indiceId order by v.inicio, v.fim")
})
public class ValorIndice implements Serializable {

	private static final long serialVersionUID = 7200679094808459796L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valor;
	private Date inicio;
	private Date fim;

	@ManyToOne
	@JoinColumn(name = "indice_id", nullable = false)
	private Indice indice;

	public ValorIndice() {
		super();
	}

	public ValorIndice(Double valor, Date inicio, Date fim, Indice indice) {
		super();
		this.valor = valor;
		this.inicio = inicio;
		this.fim = fim;
		this.indice = indice;
	}
	
	public ValorIndice(ValorIndiceTO to) {
		this.id = to.getId();
		this.valor = to.getValor();
		this.inicio = to.getInicio();
		this.fim = to.getFim();
		this.indice = new Indice(to.getIndiceId());		
	}
	
	public void alterar(ValorIndiceTO to) {
		this.valor = to.getValor();
		this.inicio = to.getInicio();
		this.fim = to.getFim();
		
		if (this.indice.getId() != to.getIndiceId())
			this.indice = new Indice(to.getIndiceId());		
	}	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Indice getIndice() {
		return indice;
	}

	public void setIndice(Indice indice) {
		this.indice = indice;
	}

	@Override
	public String toString() {
		return "ValorIndice [id=" + id + ", valor=" + valor + ", inicio=" + inicio + ", fim=" + fim + ", indice="
				+ indice + "]";
	}
	
	public ValorIndiceTO toTO() {
		return new ValorIndiceTO(id, valor, inicio, fim, indice.getId());
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
		ValorIndice other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
}