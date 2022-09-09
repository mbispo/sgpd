package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.RegistroFrequenciaTO;
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
	@NamedQuery(name = "registroFrequencia.buscarPorFuncionarioId", 
		query = "SELECT f FROM RegistroFrequencia f WHERE f.funcionario.id = :id order by f.dataHora" )
})
public class RegistroFrequencia implements Serializable {

	private static final long serialVersionUID = -1752131013855498569L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "local_id", nullable = false)
	private LocalRegistroFrequencia local;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Date dataHora;

	public RegistroFrequencia() {
		super();
	}

	public RegistroFrequencia(Long id, LocalRegistroFrequencia local, Funcionario funcionario, Date dataHora) {
		super();
		this.id = id;
		this.local = local;
		this.funcionario = funcionario;
		this.dataHora = dataHora;
	}
	
	public RegistroFrequencia(RegistroFrequenciaTO to) {
		super();
		this.id = to.getId();
		this.local = to.getLocalRegistroFrequenciaId()!=null?new LocalRegistroFrequencia(to.getLocalRegistroFrequenciaId()):null;
		this.funcionario = new Funcionario(to.getFuncionarioId());
		this.dataHora = to.getDataHora();
	}
	
	public void alterar(RegistroFrequenciaTO to) {
		this.local = to.getLocalRegistroFrequenciaId()!=null?new LocalRegistroFrequencia(to.getLocalRegistroFrequenciaId()):null;
		this.funcionario = new Funcionario(to.getFuncionarioId());
		this.dataHora = to.getDataHora();
	}
	
	public RegistroFrequenciaTO toTO() {
		return new RegistroFrequenciaTO(id, local!=null?local.getId():null, funcionario.getId(), dataHora);
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalRegistroFrequencia getLocal() {
		return local;
	}

	public void setLocal(LocalRegistroFrequencia local) {
		this.local = local;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
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
		RegistroFrequencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RegistroFrequencia [id=" + id + ", local=" + local + ", funcionario=" + funcionario + ", dataHora="
				+ dataHora + "]";
	}

}