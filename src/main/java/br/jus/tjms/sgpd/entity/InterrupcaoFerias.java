package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
public class InterrupcaoFerias implements Serializable {

	private static final long serialVersionUID = 2471908537737261277L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitacaoInterrupcao_id", nullable = true)
	private SolicitacaoInterrupcaoFerias solicitacaoInterrupcao;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	private Date data;

	@ManyToOne
	@JoinColumn(name = "concessaoFerias_id", nullable = false)
	private ConcessaoFerias concessaoFerias;

	private Boolean efetivado;

	public InterrupcaoFerias() {
		super();
	}

	public InterrupcaoFerias(Long id, SolicitacaoInterrupcaoFerias solicitacaoInterrupcao,
			AtoAdministrativo atoAdministrativo, Date data, ConcessaoFerias concessaoFerias, Boolean efetivado) {
		super();
		this.id = id;
		this.solicitacaoInterrupcao = solicitacaoInterrupcao;
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

	public SolicitacaoInterrupcaoFerias getSolicitacaoInterrupcao() {
		return solicitacaoInterrupcao;
	}

	public void setSolicitacaoInterrupcao(SolicitacaoInterrupcaoFerias solicitacaoInterrupcao) {
		this.solicitacaoInterrupcao = solicitacaoInterrupcao;
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
		InterrupcaoFerias other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "InterrupcaoFerias [id=" + id + ", solicitacaoInterrupcao=" + solicitacaoInterrupcao
				+ ", atoAdministrativo=" + atoAdministrativo + ", data=" + data + ", concessaoFerias="
				+ concessaoFerias + ", efetivado=" + efetivado + "]";
	}

}