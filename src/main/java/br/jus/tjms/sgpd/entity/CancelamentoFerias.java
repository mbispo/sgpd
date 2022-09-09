package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
public class CancelamentoFerias implements Serializable {

	private static final long serialVersionUID = -6522211198099575166L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacaoCancelamento_id", nullable = true)
	private SolicitacaoCancelamentoFerias solicitacaoCancelamento;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	private Date data;

	@ManyToOne
	@JoinColumn(name = "concessaoFerias_id", nullable = false)
	private ConcessaoFerias concessaoFerias;

	private Boolean efetivado;

	public CancelamentoFerias() {
		super();
	}

	public CancelamentoFerias(Long id, SolicitacaoCancelamentoFerias solicitacaoCancelamento,
			AtoAdministrativo atoAdministrativo, Date data, ConcessaoFerias concessaoFerias, Boolean efetivado) {
		super();
		this.id = id;
		this.solicitacaoCancelamento = solicitacaoCancelamento;
		this.atoAdministrativo = atoAdministrativo;
		this.data = data;
		this.concessaoFerias = concessaoFerias;
		this.efetivado = efetivado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SolicitacaoCancelamentoFerias getSolicitacaoCancelamento() {
		return solicitacaoCancelamento;
	}

	public void setSolicitacaoCancelamento(SolicitacaoCancelamentoFerias solicitacaoCancelamento) {
		this.solicitacaoCancelamento = solicitacaoCancelamento;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public ConcessaoFerias getConcessaoFerias() {
		return concessaoFerias;
	}

	public void setConcessaoFerias(ConcessaoFerias concessaoFerias) {
		this.concessaoFerias = concessaoFerias;
	}

	public Boolean getEfetivado() {
		return efetivado;
	}

	public void setEfetivado(Boolean efetivado) {
		this.efetivado = efetivado;
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
		CancelamentoFerias other = (CancelamentoFerias) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CancelamentoFerias [id=" + id + ", solicitacaoCancelamento=" + solicitacaoCancelamento
				+ ", atoAdministrativo=" + atoAdministrativo + ", concessaoFerias=" + concessaoFerias + ", efetivado="
				+ efetivado + "]";
	}

}