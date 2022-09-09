package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.GrupoFolhaPagamentoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
public class GrupoFolhaPagamento implements Serializable {

	private static final long serialVersionUID = -3857524961762155910L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "grupoSuperior_id", nullable = true)
	private GrupoFolhaPagamento grupoSuperior;

	public GrupoFolhaPagamento() {
		super();
	}
	
	public GrupoFolhaPagamento(Long id) {
		super();
		this.id = id;
	}

	public GrupoFolhaPagamento(Long id, String descricao, GrupoFolhaPagamento grupoSuperior) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.grupoSuperior = grupoSuperior;
	}

	public GrupoFolhaPagamento(GrupoFolhaPagamentoTO grupoFolhaPagamentoTO) {
		this.id = grupoFolhaPagamentoTO.getId();
		this.descricao = grupoFolhaPagamentoTO.getDescricao();		
		if (grupoFolhaPagamentoTO.getGrupoSuperiorId()!=null) {
			this.grupoSuperior = new GrupoFolhaPagamento(grupoFolhaPagamentoTO.getGrupoSuperiorId());
		}
	}
	
	public void alterar(GrupoFolhaPagamentoTO grupoFolhaPagamentoTO) {
		this.descricao = grupoFolhaPagamentoTO.getDescricao();
		
		if (grupoFolhaPagamentoTO.getGrupoSuperiorId()!=null) {
			this.grupoSuperior = new GrupoFolhaPagamento(grupoFolhaPagamentoTO.getGrupoSuperiorId());
		} else {
			this.grupoSuperior = null;
		}
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

	public GrupoFolhaPagamento getGrupoSuperior() {
		return grupoSuperior;
	}

	public void setGrupoSuperior(GrupoFolhaPagamento grupoSuperior) {
		this.grupoSuperior = grupoSuperior;
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
		GrupoFolhaPagamento other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "GrupoFolhaPagamento [id=" + id + ", descricao=" + descricao + ", grupoSuperior=" + grupoSuperior + "]";
	}
	
	public GrupoFolhaPagamentoTO toTO() {
		return new GrupoFolhaPagamentoTO(id, descricao, grupoSuperior!=null?grupoSuperior.getId():null);
	}

}