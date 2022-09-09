package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
public class RequisicaoDiariaComplementacao implements Serializable {

	private static final long serialVersionUID = 2274735508388585162L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "complementada_id", nullable = false)
	private RequisicaoDiarias complementada;

	@ManyToOne
	@JoinColumn(name = "complemento_id", nullable = false)
	private RequisicaoDiarias complemento;

	@ManyToOne
	@JoinColumn(name = "requisitante_id", nullable = false)
	private Funcionario requisitante;

	public RequisicaoDiariaComplementacao() {
		super();
	}

	public RequisicaoDiariaComplementacao(Long id, RequisicaoDiarias complementada, RequisicaoDiarias complemento,
			Funcionario requisitante) {
		super();
		this.id = id;
		this.complementada = complementada;
		this.complemento = complemento;
		this.requisitante = requisitante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RequisicaoDiarias getComplementada() {
		return complementada;
	}

	public void setComplementada(RequisicaoDiarias complementada) {
		this.complementada = complementada;
	}

	public RequisicaoDiarias getComplemento() {
		return complemento;
	}

	public void setComplemento(RequisicaoDiarias complemento) {
		this.complemento = complemento;
	}

	public Funcionario getRequisitante() {
		return requisitante;
	}

	public void setRequisitante(Funcionario requisitante) {
		this.requisitante = requisitante;
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
		RequisicaoDiariaComplementacao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RequisicaoDiariaComplementacao [id=" + id + ", complementada=" + complementada + ", complemento="
				+ complemento + ", requisitante=" + requisitante + "]";
	}

}