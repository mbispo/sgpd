package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class FuncionarioFolhaPagamentoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long funcionarioId;
	private Long folhaPagamentoId;

	public FuncionarioFolhaPagamentoTO() {
		super();
	}

	public FuncionarioFolhaPagamentoTO(Long id, Long funcionarioId, Long folhaPagamentoId) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.folhaPagamentoId = folhaPagamentoId;
	}

	public FuncionarioFolhaPagamentoTO(Long funcionarioId, Long folhaPagamentoId) {
		super();
		this.funcionarioId = funcionarioId;
		this.folhaPagamentoId = folhaPagamentoId;
	}

	public FuncionarioFolhaPagamentoTO(Long funcionarioId) {
		super();
		this.funcionarioId = funcionarioId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Long getFolhaPagamentoId() {
		return folhaPagamentoId;
	}

	public void setFolhaPagamentoId(Long folhaPagamentoId) {
		this.folhaPagamentoId = folhaPagamentoId;
	}

	@Override
	public String toString() {
		return "FuncionarioFolhaPagamentoTO [id=" + id + ", funcionarioId=" + funcionarioId + ", folhaPagamentoId="
				+ folhaPagamentoId + "]";
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
		FuncionarioFolhaPagamentoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}