package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoDemissao;
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
public class Demissao implements Serializable {

	private static final long serialVersionUID = -6202338510372474822L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;

	@ManyToOne
	@JoinColumn(name = "aplicacaoPena_id", nullable = true)
	private AplicacaoPena aplicacaoPena;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	private Date dataEfeito;

	@Enumerated(EnumType.ORDINAL)
	private TipoDemissao tipo;

	public Demissao() {
		super();
	}

	public Demissao(Long id, Funcionario funcionario, FuncionarioCargo funcionarioCargo, AplicacaoPena aplicacaoPena,
			AtoAdministrativo ato, Date dataEfeito, TipoDemissao tipo) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.funcionarioCargo = funcionarioCargo;
		this.aplicacaoPena = aplicacaoPena;
		this.ato = ato;
		this.dataEfeito = dataEfeito;
		this.tipo = tipo;
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

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public AplicacaoPena getAplicacaoPena() {
		return aplicacaoPena;
	}

	public void setAplicacaoPena(AplicacaoPena aplicacaoPena) {
		this.aplicacaoPena = aplicacaoPena;
	}

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public TipoDemissao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDemissao tipo) {
		this.tipo = tipo;
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
		Demissao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Demissao [id=" + id + ", funcionario=" + funcionario + ", funcionarioCargo=" + funcionarioCargo
				+ ", aplicacaoPena=" + aplicacaoPena + ", ato=" + ato + ", dataEfeito=" + dataEfeito + ", tipo=" + tipo
				+ "]";
	}

}