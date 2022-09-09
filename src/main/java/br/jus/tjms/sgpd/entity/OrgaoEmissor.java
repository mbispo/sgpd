package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.OrgaoEmissorTO;
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
public class OrgaoEmissor implements Serializable {

	private static final long serialVersionUID = -134770688921151160L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	private String nome;

	@Column(length = 20)
	private String sigla;

	@Column(length = 2)
	private String uf;

	public OrgaoEmissor() {
		super();
	}

	public OrgaoEmissor(Long id, String nome, String sigla, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.uf = uf;
	}

	public OrgaoEmissor(OrgaoEmissorTO orgaoEmissorTO) {
		this.nome = orgaoEmissorTO.getNome();
		this.sigla = orgaoEmissorTO.getSigla();
		this.uf = orgaoEmissorTO.getUf();
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		OrgaoEmissor other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "OrgaoEmissor [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", uf=" + uf + "]";
	}

	public void alterar(OrgaoEmissorTO orgaoEmissorTO) {
		this.nome = orgaoEmissorTO.getNome();
		this.sigla = orgaoEmissorTO.getSigla();
		this.uf = orgaoEmissorTO.getUf();
	}

}