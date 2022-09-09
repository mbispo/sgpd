package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
public class LocalRegistroFrequenciaFuncionario implements Serializable {

	private static final long serialVersionUID = 6831346958698831684L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "local_id", nullable = false)
	private LocalRegistroFrequencia local;

	private Date vigenciaInicio;
	private Date vigenciaFim;

	public LocalRegistroFrequenciaFuncionario() {
		super();
	}

	public LocalRegistroFrequenciaFuncionario(Long id, Funcionario funcionario, LocalRegistroFrequencia local,
			Date vigenciaInicio, Date vigenciaFim) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.local = local;
		this.vigenciaInicio = vigenciaInicio;
		this.vigenciaFim = vigenciaFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalRegistroFrequencia getLocal() {
		return local;
	}

	public void setLocal(LocalRegistroFrequencia local) {
		this.local = local;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
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
		LocalRegistroFrequenciaFuncionario other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "LocalRegistroFrequenciaFuncionario [id=" + id + ", funcionario=" + funcionario + ", local=" + local
				+ ", vigenciaInicio=" + vigenciaInicio + ", vigenciaFim=" + vigenciaFim + "]";
	}

}