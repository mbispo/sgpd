package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RelacaoSolicitacaoEmprestimoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long solicitacaoEmprestimoConsignadoId;
	private Long emprestimoConsignadoId;

	public RelacaoSolicitacaoEmprestimoTO() {
		super();
	}

	public RelacaoSolicitacaoEmprestimoTO(Long id, Long solicitacaoEmprestimoConsignadoId,
			Long emprestimoConsignadoId) {
		super();
		this.id = id;
		this.solicitacaoEmprestimoConsignadoId = solicitacaoEmprestimoConsignadoId;
		this.emprestimoConsignadoId = emprestimoConsignadoId;
	}

	public RelacaoSolicitacaoEmprestimoTO(Long solicitacaoEmprestimoConsignadoId, Long emprestimoConsignadoId) {
		super();
		this.solicitacaoEmprestimoConsignadoId = solicitacaoEmprestimoConsignadoId;
		this.emprestimoConsignadoId = emprestimoConsignadoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSolicitacaoEmprestimoConsignadoId() {
		return solicitacaoEmprestimoConsignadoId;
	}

	public void setSolicitacaoEmprestimoConsignadoId(Long solicitacaoEmprestimoConsignadoId) {
		this.solicitacaoEmprestimoConsignadoId = solicitacaoEmprestimoConsignadoId;
	}

	public Long getEmprestimoConsignadoId() {
		return emprestimoConsignadoId;
	}

	public void setEmprestimoConsignadoId(Long emprestimoConsignadoId) {
		this.emprestimoConsignadoId = emprestimoConsignadoId;
	}

	@Override
	public String toString() {
		return "RelacaoSolicitacaoEmprestimoTO [id=" + id + ", solicitacaoEmprestimoConsignadoId="
				+ solicitacaoEmprestimoConsignadoId + ", emprestimoConsignadoId=" + emprestimoConsignadoId + "]";
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
		RelacaoSolicitacaoEmprestimoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}