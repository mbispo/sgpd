package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:59
 */
@Entity
@Auditavel
@Cacheable
public class Direito implements Serializable {

	private static final long serialVersionUID = 6920710832575272815L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "regimeJuridico_id", nullable = false)
	private RegimeJuridico regimeJuridico;

	public Direito() {
		super();
	}

	public Direito(Long id, String descricao, RegimeJuridico regimeJuridico) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.regimeJuridico = regimeJuridico;
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

	public RegimeJuridico getRegimeJuridico() {
		return regimeJuridico;
	}

	public void setRegimeJuridico(RegimeJuridico regimeJuridico) {
		this.regimeJuridico = regimeJuridico;
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
		Direito other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Direito [id=" + id + ", descricao=" + descricao + ", regimeJuridico=" + regimeJuridico + "]";
	}

}