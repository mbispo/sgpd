package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.EscalaFuncionarioTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:57
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "escalaFuncionario.buscarEscalasFuncionarioPorFuncionario", query = "SELECT e from EscalaFuncionario e WHERE e.funcionario.id = :funcionarioId") })

public class EscalaFuncionario implements Serializable {

	private static final long serialVersionUID = -1647346827123535903L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "escala_id", nullable = false)
	private Escala escala;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Integer sequencial;
	private Date dataHoraEntrada;
	private Date dataHoraSaida;
	private Boolean cumprida;

	public EscalaFuncionario() {
		super();
	}
	
	public EscalaFuncionario(Long id) {
		super();
		this.id = id;
	}

	public EscalaFuncionario(Long id, Escala escala, Funcionario funcionario, Integer sequencial, Date dataHoraEntrada,
			Date dataHoraSaida, Boolean cumprida) {
		super();
		this.id = id;
		this.escala = escala;
		this.funcionario = funcionario;
		this.sequencial = sequencial;
		this.dataHoraEntrada = dataHoraEntrada;
		this.dataHoraSaida = dataHoraSaida;
		this.cumprida = cumprida;
	}
	
	public EscalaFuncionario(Escala escala, Funcionario funcionario, Date dataHoraEntrada, Date dataHoraSaida, Boolean cumprida) {
		super();
		this.escala = escala;
		this.funcionario = funcionario;
		this.dataHoraEntrada = dataHoraEntrada;
		this.dataHoraSaida = dataHoraSaida;
		this.cumprida = cumprida;
	}

	public EscalaFuncionario(EscalaFuncionarioTO escalaFuncionarioTO) {
		this.id = escalaFuncionarioTO.getId();
		this.escala = new Escala(escalaFuncionarioTO.getEscalaId());
		this.funcionario = new Funcionario(escalaFuncionarioTO.getFuncionarioId());
		this.dataHoraEntrada = escalaFuncionarioTO.getDataHoraEntrada();
		this.dataHoraSaida = escalaFuncionarioTO.getDataHoraSaida();
		this.cumprida = escalaFuncionarioTO.getCumprida();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Escala getEscala() {
		return escala;
	}

	public void setEscala(Escala escala) {
		this.escala = escala;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public Date getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Date dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Date getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(Date dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}

	public Boolean getCumprida() {
		return cumprida;
	}

	public void setCumprida(Boolean cumprida) {
		this.cumprida = cumprida;
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
		EscalaFuncionario other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "EscalaFuncionario [id=" + id + ", escala=" + escala + ", funcionario=" + funcionario + ", sequencial="
				+ sequencial + ", dataHoraEntrada=" + dataHoraEntrada + ", dataHoraSaida=" + dataHoraSaida
				+ ", cumprida=" + cumprida + "]";
	}

}