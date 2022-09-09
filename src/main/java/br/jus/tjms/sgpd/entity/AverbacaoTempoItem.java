package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoTempoAverbacao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AverbacaoTempoItem implements Serializable {

	private static final long serialVersionUID = 6450586214655299101L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "averbacao_id", nullable = false)
	private AverbacaoTempo averbacao;

	@Enumerated(EnumType.ORDINAL)
	private TipoTempoAverbacao tipoTempo;

	private Date dataInicio;
	private Date dataFim;

	private Integer numeroDiasDesconto;
	private Integer numeroDias;
	private Integer numeroDiasLiquido;

	@Column(length = 500)
	private String observacoes;

	public AverbacaoTempoItem() {
		super();
	}

	public AverbacaoTempoItem(Long id, AverbacaoTempo averbacao, TipoTempoAverbacao tipoTempo, Date dataInicio,
			Date dataFim, Integer numeroDiasDesconto, Integer numeroDias, Integer numeroDiasLiquido, String observacoes) {
		super();
		this.id = id;
		this.averbacao = averbacao;
		this.tipoTempo = tipoTempo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.numeroDiasDesconto = numeroDiasDesconto;
		this.numeroDias = numeroDias;
		this.numeroDiasLiquido = numeroDiasLiquido;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AverbacaoTempo getAverbacao() {
		return averbacao;
	}

	public void setAverbacao(AverbacaoTempo averbacao) {
		this.averbacao = averbacao;
	}

	public TipoTempoAverbacao getTipoTempo() {
		return tipoTempo;
	}

	public void setTipoTempo(TipoTempoAverbacao tipoTempo) {
		this.tipoTempo = tipoTempo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getNumeroDiasDesconto() {
		return numeroDiasDesconto;
	}

	public void setNumeroDiasDesconto(Integer numeroDiasDesconto) {
		this.numeroDiasDesconto = numeroDiasDesconto;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Integer getNumeroDiasLiquido() {
		return numeroDiasLiquido;
	}

	public void setNumeroDiasLiquido(Integer numeroDiasLiquido) {
		this.numeroDiasLiquido = numeroDiasLiquido;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		AverbacaoTempoItem other = (AverbacaoTempoItem) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "AverbacaoTempoItem [id=" + id + ", averbacao=" + averbacao + ", tipoTempo=" + tipoTempo
				+ ", numeroDiasDesconto=" + numeroDiasDesconto + ", numeroDias=" + numeroDias + ", numeroDiasLiquido="
				+ numeroDiasLiquido + ", observacoes=" + observacoes + "]";
	}

}