package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoIsencaoFrequencia;
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
public class IsencaoFrequencia implements Serializable {

	private static final long serialVersionUID = -5080113272344181447L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = true)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "especialidade_id", nullable = true)
	private Especialidade especialidade;

	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = true)
	private Cargo cargo;

	@Enumerated(EnumType.ORDINAL)
	private TipoIsencaoFrequencia tipo;

	private Date inicioVigencia;
	private Date fimVigencia;

	public IsencaoFrequencia() {
		super();
	}

	public IsencaoFrequencia(Long id, Funcionario funcionario, Especialidade especialidade, Cargo cargo,
			TipoIsencaoFrequencia tipo, Date inicioVigencia, Date fimVigencia) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.especialidade = especialidade;
		this.cargo = cargo;
		this.tipo = tipo;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public TipoIsencaoFrequencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoIsencaoFrequencia tipo) {
		this.tipo = tipo;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Date getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
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
		IsencaoFrequencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "IsencaoFrequencia [id=" + id + ", funcionario=" + funcionario + ", especialidade=" + especialidade
				+ ", cargo=" + cargo + ", tipo=" + tipo + ", inicioVigencia=" + inicioVigencia + ", fimVigencia="
				+ fimVigencia + "]";
	}

}