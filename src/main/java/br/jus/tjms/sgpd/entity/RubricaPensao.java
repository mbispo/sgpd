package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 12-abr-2016 13:36:09
 */

@Entity
@Auditavel
@Cacheable
public class RubricaPensao implements Serializable {

	private static final long serialVersionUID = 3140428167017359776L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pensao_id", nullable = false)
	private Pensao pensao;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = false)
	private Rubrica rubrica;

	private Double valorFixo;
	private Double percentual;
	private Double quantidade;

	@ManyToOne
	@JoinColumn(name = "referencia_id", nullable = true)
	private Referencia referencia;

	public RubricaPensao() {
		super();
	}

	public RubricaPensao(Pensao pensao, Rubrica rubrica, Double valorFixo, Double percentual, Double quantidade,
			Referencia referencia) {
		super();
		this.pensao = pensao;
		this.rubrica = rubrica;
		this.valorFixo = valorFixo;
		this.percentual = percentual;
		this.quantidade = quantidade;
		this.referencia = referencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pensao getPensao() {
		return pensao;
	}

	public void setPensao(Pensao pensao) {
		this.pensao = pensao;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public Double getValorFixo() {
		return valorFixo;
	}

	public void setValorFixo(Double valorFixo) {
		this.valorFixo = valorFixo;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Referencia getReferencia() {
		return referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
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
		RubricaPensao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RubricaPensao [id=" + id + ", pensao=" + pensao + ", rubrica=" + rubrica + ", valorFixo=" + valorFixo
				+ ", percentual=" + percentual + ", quantidade=" + quantidade + ", referencia=" + referencia + "]";
	}

}