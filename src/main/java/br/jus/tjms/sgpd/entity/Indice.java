package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.Periodo;
import br.jus.tjms.sgpd.service.rest.v1.to.IndiceTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({ 
	@NamedQuery(name = "indice.buscarAtivos", query = "SELECT i FROM Indice i WHERE i.ativo = true"),
	@NamedQuery(name = "indice.buscarPorDescricao", query = "SELECT i FROM Indice i WHERE i.descricao like :descricao"),
	@NamedQuery(name = "indice.buscarPorSigla", query = "SELECT i FROM Indice i WHERE i.sigla like :sigla") 
})
public class Indice implements Serializable {

	private static final long serialVersionUID = -8115335762646578897L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	private String descricao;

	@Column(length = 10)
	private String sigla;

	@Enumerated(EnumType.ORDINAL)
	private Periodo periodo;

	private Boolean ativo;

	public Indice() {
		super();
	}

	public Indice(String descricao, String sigla, Periodo periodo, Boolean ativo) {
		super();
		this.descricao = descricao;
		this.sigla = sigla;
		this.periodo = periodo;
		this.ativo = ativo;
	}

	public Indice(IndiceTO to) {
		super();
		this.id = to.getId();
		this.descricao = to.getDescricao();
		this.sigla = to.getSigla();
		this.periodo = to.getPeriodo();
		this.ativo = to.getAtivo();
	}
	
	public void alterar(IndiceTO to) {
		this.descricao = to.getDescricao();
		this.sigla = to.getSigla();
		this.periodo = to.getPeriodo();
		this.ativo = to.getAtivo();
	}

	public Indice(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Indice [id=" + id + ", descricao=" + descricao + ", sigla=" + sigla + ", periodo=" + periodo
				+ ", ativo=" + ativo + "]";
	}

	public IndiceTO toTO() {
		return new IndiceTO(id, descricao, sigla, periodo, ativo);
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
		Indice other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}