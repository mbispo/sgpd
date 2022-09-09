package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:04
 */
@Entity
@Auditavel
@Cacheable
public class SolicitacaoHoraExtraFuncionario implements Serializable {

	private static final long serialVersionUID = 2542243031583850460L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitado_id", nullable = false)
	private Funcionario solicitado;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoHoraExtra solicitacao;

	public SolicitacaoHoraExtraFuncionario() {
		super();
	}

	public SolicitacaoHoraExtraFuncionario(Long id, Funcionario solicitado, SolicitacaoHoraExtra solicitacao) {
		super();
		this.id = id;
		this.solicitado = solicitado;
		this.solicitacao = solicitacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getSolicitado() {
		return solicitado;
	}

	public void setSolicitado(Funcionario solicitado) {
		this.solicitado = solicitado;
	}

	public SolicitacaoHoraExtra getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoHoraExtra solicitacao) {
		this.solicitacao = solicitacao;
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
		SolicitacaoHoraExtraFuncionario other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoHoraExtraFuncionario [id=" + id + ", solicitado=" + solicitado + ", solicitacao="
				+ solicitacao + "]";
	}

}