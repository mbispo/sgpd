package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.OrgaoRegionalClasseTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "preRequisitoRegistroOrgaoClasse.buscarPorCargo", 
			query = "SELECT p from PreRequisitoRegistroOrgaoClasse p WHERE p.cargo.id = :cargoId"),
})
public class PreRequisitoRegistroOrgaoClasse implements Serializable {

	private static final long serialVersionUID = 6086127732656649930L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "orgao_id", nullable = false)
	private OrgaoRegionalClasse orgao;

	public PreRequisitoRegistroOrgaoClasse() {
		super();
	}

	public PreRequisitoRegistroOrgaoClasse(Long id, Cargo cargo, OrgaoRegionalClasse orgao) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.orgao = orgao;
	}

	public PreRequisitoRegistroOrgaoClasse(Cargo cargo, OrgaoRegionalClasseTO orgaoRegionalClasseTO) {
		this.cargo = cargo;
		this.orgao = new OrgaoRegionalClasse(orgaoRegionalClasseTO);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public OrgaoRegionalClasse getOrgao() {
		return orgao;
	}

	public void setOrgao(OrgaoRegionalClasse orgao) {
		this.orgao = orgao;
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
		PreRequisitoRegistroOrgaoClasse other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PreRequisitoRegistroOrgaoClasse [id=" + id + ", cargo=" + cargo + ", orgao=" + orgao + "]";
	}

	public void alterar(Cargo cargo, OrgaoRegionalClasseTO orgaoRegionalClasseTO) {
		this.cargo = cargo;
		this.orgao = new OrgaoRegionalClasse(orgaoRegionalClasseTO);
	}

}