package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class DestituicaoCargo implements Serializable {

	private static final long serialVersionUID = 5675239519566343361L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aplicacaoPena_id", nullable = true)
	private AplicacaoPena aplicacaoPena;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;

	private Date dataEfeito;

	public DestituicaoCargo() {
		super();
	}

	public DestituicaoCargo(Long id, AplicacaoPena aplicacaoPena, Funcionario funcionario, AtoAdministrativo ato,
			FuncionarioCargo funcionarioCargo, Date dataEfeito) {
		super();
		this.id = id;
		this.aplicacaoPena = aplicacaoPena;
		this.funcionario = funcionario;
		this.ato = ato;
		this.funcionarioCargo = funcionarioCargo;
		this.dataEfeito = dataEfeito;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AplicacaoPena getAplicacaoPena() {
		return aplicacaoPena;
	}

	public void setAplicacaoPena(AplicacaoPena aplicacaoPena) {
		this.aplicacaoPena = aplicacaoPena;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
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
		DestituicaoCargo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DestituicaoCargo [id=" + id + ", aplicacaoPena=" + aplicacaoPena + ", funcionario=" + funcionario
				+ ", ato=" + ato + ", funcionarioCargo=" + funcionarioCargo + ", dataEfeito=" + dataEfeito + "]";
	}

}