package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.ProgressaoFuncionalTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "progressaoFuncional.buscarProgressaoFuncional", 
			query = "SELECT p from ProgressaoFuncional p JOIN p.funcionarioCargo f WHERE f.funcionario.id =:funcionarioId order by p.dataProgressao DESC")
})
public class ProgressaoFuncional implements Serializable {

	private static final long serialVersionUID = 1156827536172573273L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;

	@ManyToOne
	@JoinColumn(name = "referencia_id", nullable = false)
	private Referencia referencia;

	private Date dataProgressao;

	public ProgressaoFuncional() {
		super();
	}

	public ProgressaoFuncional(Long id, FuncionarioCargo funcionarioCargo, Referencia referencia, Date dataProgressao) {
		super();
		this.id = id;
		this.funcionarioCargo = funcionarioCargo;
		this.referencia = referencia;
		this.dataProgressao = dataProgressao;
	}

	public ProgressaoFuncional(ProgressaoFuncionalTO progressaoFuncionalTO) {
		this.funcionarioCargo = new FuncionarioCargo(progressaoFuncionalTO.getFuncionarioCargoId());
		this.referencia = new Referencia(progressaoFuncionalTO.getReferenciaId());
		this.dataProgressao = progressaoFuncionalTO.getDataProgressao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public Referencia getReferencia() {
		return referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}

	public Date getDataProgressao() {
		return dataProgressao;
	}

	public void setDataProgressao(Date dataProgressao) {
		this.dataProgressao = dataProgressao;
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
		ProgressaoFuncional other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ProgressaoFuncional [id=" + id + ", funcionarioCargo=" + funcionarioCargo + ", referencia="
				+ referencia + ", dataProgressao=" + dataProgressao + "]";
	}

	public void alterar(ProgressaoFuncionalTO progressaoFuncionalTO) {
		//FIXME this.funcionarioCargo = progressaoFuncionalTO.getFuncionarioCargoId();
		//FIXME this.referencia = progressaoFuncionalTO.getReferenciaId();
		this.dataProgressao = progressaoFuncionalTO.getDataProgressao();
	}

}