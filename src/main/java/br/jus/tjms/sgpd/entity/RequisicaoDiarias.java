package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoRequisicaoDiarias;
import br.jus.tjms.sgpd.enumerators.TipoRequisicaoDiarias;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
public class RequisicaoDiarias implements Serializable {

	private static final long serialVersionUID = -2846715049307154654L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "requisitante_id", nullable = false)
	private Funcionario requisitante;

	@Enumerated(EnumType.ORDINAL)
	private TipoRequisicaoDiarias tipo;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoRequisicaoDiarias situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public RequisicaoDiarias() {
		super();
	}

	public RequisicaoDiarias(Long id, Funcionario requisitante, TipoRequisicaoDiarias tipo,
			SituacaoRequisicaoDiarias situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.requisitante = requisitante;
		this.tipo = tipo;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getRequisitante() {
		return requisitante;
	}

	public void setRequisitante(Funcionario requisitante) {
		this.requisitante = requisitante;
	}

	public TipoRequisicaoDiarias getTipo() {
		return tipo;
	}

	public void setTipo(TipoRequisicaoDiarias tipo) {
		this.tipo = tipo;
	}

	public SituacaoRequisicaoDiarias getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoRequisicaoDiarias situacao) {
		this.situacao = situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
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
		RequisicaoDiarias other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RequisicaoDiarias [id=" + id + ", requisitante=" + requisitante + ", tipo=" + tipo + ", situacao="
				+ situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}