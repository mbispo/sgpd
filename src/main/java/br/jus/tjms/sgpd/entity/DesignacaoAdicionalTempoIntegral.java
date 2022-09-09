package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class DesignacaoAdicionalTempoIntegral implements Serializable {

	private static final long serialVersionUID = 3480907765490101930L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = true)
	private SolicitacaoDesignacaoTempoIntegral solicitacao;

	private Date dataEfeito;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@Column(length = 500)
	private String motivo;

	@Column(length = 60)
	private String processo;

	public DesignacaoAdicionalTempoIntegral() {
		super();
	}

	public DesignacaoAdicionalTempoIntegral(Long id, SolicitacaoDesignacaoTempoIntegral solicitacao, Date dataEfeito,
			AtoAdministrativo atoAdministrativo, String motivo, String processo) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
		this.dataEfeito = dataEfeito;
		this.atoAdministrativo = atoAdministrativo;
		this.motivo = motivo;
		this.processo = processo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SolicitacaoDesignacaoTempoIntegral getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoDesignacaoTempoIntegral solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
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
		DesignacaoAdicionalTempoIntegral other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DesignacaoAdicionalTempoIntegral [id=" + id + ", solicitacao=" + solicitacao + ", dataEfeito="
				+ dataEfeito + ", atoAdministrativo=" + atoAdministrativo + ", motivo=" + motivo + ", processo="
				+ processo + "]";
	}

}