package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.MotivoCancelamentoAuxilioEducacaoInfantil;
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
public class CancelamentoAuxilioEducacaoInfantil implements Serializable {

	private static final long serialVersionUID = 5210403050466223074L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@ManyToOne
	@JoinColumn(name = "concessao_id", nullable = false)
	private ConcessaoAuxilioEducacaoInfantil concessao;

	@Enumerated(EnumType.ORDINAL)
	private MotivoCancelamentoAuxilioEducacaoInfantil motivo;

	private Date data;
	private Date dataEfeito;

	@Column(length = 500)
	private String observacoes;

	public CancelamentoAuxilioEducacaoInfantil() {
		super();
	}

	public CancelamentoAuxilioEducacaoInfantil(Long id, AtoAdministrativo atoAdministrativo,
			ConcessaoAuxilioEducacaoInfantil concessao, MotivoCancelamentoAuxilioEducacaoInfantil motivo, Date data,
			Date dataEfeito, String observacoes) {
		super();
		this.id = id;
		this.atoAdministrativo = atoAdministrativo;
		this.concessao = concessao;
		this.motivo = motivo;
		this.data = data;
		this.dataEfeito = dataEfeito;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public ConcessaoAuxilioEducacaoInfantil getConcessao() {
		return concessao;
	}

	public void setConcessao(ConcessaoAuxilioEducacaoInfantil concessao) {
		this.concessao = concessao;
	}

	public MotivoCancelamentoAuxilioEducacaoInfantil getMotivo() {
		return motivo;
	}

	public void setMotivo(MotivoCancelamentoAuxilioEducacaoInfantil motivo) {
		this.motivo = motivo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
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
		CancelamentoAuxilioEducacaoInfantil other = (CancelamentoAuxilioEducacaoInfantil) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CancelamentoAuxilioEducacaoInfantil [id=" + id + ", atoAdministrativo=" + atoAdministrativo
				+ ", concessao=" + concessao + ", motivo=" + motivo + ", data=" + data + ", dataEfeito=" + dataEfeito
				+ ", observacoes=" + observacoes + "]";
	}

}