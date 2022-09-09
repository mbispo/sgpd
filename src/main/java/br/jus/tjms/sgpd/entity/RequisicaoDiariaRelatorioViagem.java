package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
public class RequisicaoDiariaRelatorioViagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "requisicao_id", nullable = false)
	private RequisicaoDiarias requisicao;

	public RequisicaoDiariaRelatorioViagem() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RequisicaoDiarias getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(RequisicaoDiarias requisicao) {
		this.requisicao = requisicao;
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
		RequisicaoDiariaRelatorioViagem other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RequisicaoDiariaRelatorioViagem [id=" + id + ", requisicao=" + requisicao + "]";
	}

}