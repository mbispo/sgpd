package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
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
public class MeioLocomocao implements Serializable {

	private static final long serialVersionUID = 7488935117094336770L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	private Boolean indenizacaoTransporte;

	public MeioLocomocao() {
		super();
	}

	public MeioLocomocao(Long id, String descricao, Boolean indenizacaoTransporte) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.indenizacaoTransporte = indenizacaoTransporte;
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

	public Boolean getIndenizacaoTransporte() {
		return indenizacaoTransporte;
	}

	public void setIndenizacaoTransporte(Boolean indenizacaoTransporte) {
		this.indenizacaoTransporte = indenizacaoTransporte;
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
		MeioLocomocao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "MeioLocomocao [id=" + id + ", descricao=" + descricao + ", indenizacaoTransporte="
				+ indenizacaoTransporte + "]";
	}

}