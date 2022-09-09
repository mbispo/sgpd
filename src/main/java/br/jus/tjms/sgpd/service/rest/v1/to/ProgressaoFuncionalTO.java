package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProgressaoFuncionalTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long funcionarioCargoId;
	private Long referenciaId;
	private Date dataProgressao;

	public ProgressaoFuncionalTO() {
		super();
	}

	public ProgressaoFuncionalTO(Long id, Long funcionarioCargoId, Long referenciaId, Date dataProgressao) {
		super();
		this.id = id;
		this.funcionarioCargoId = funcionarioCargoId;
		this.referenciaId = referenciaId;
		this.dataProgressao = dataProgressao;
	}

	public ProgressaoFuncionalTO(Long funcionarioCargoId, Long referenciaId, Date dataProgressao) {
		super();
		this.funcionarioCargoId = funcionarioCargoId;
		this.referenciaId = referenciaId;
		this.dataProgressao = dataProgressao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFuncionarioCargoId() {
		return funcionarioCargoId;
	}

	public void setFuncionarioCargoId(Long funcionarioCargoId) {
		this.funcionarioCargoId = funcionarioCargoId;
	}

	public Long getReferenciaId() {
		return referenciaId;
	}

	public void setReferenciaId(Long referenciaId) {
		this.referenciaId = referenciaId;
	}

	public Date getDataProgressao() {
		return dataProgressao;
	}

	public void setDataProgressao(Date dataProgressao) {
		this.dataProgressao = dataProgressao;
	}

	@Override
	public String toString() {
		return "ProgressaoFuncionalTO [id=" + id + ", funcionarioCargoId=" + funcionarioCargoId + ", referenciaId="
				+ referenciaId + ", dataProgressao=" + dataProgressao + "]";
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
		ProgressaoFuncionalTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}