package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AutorizacaoHoraExtraFuncionario implements Serializable {

	private static final long serialVersionUID = -2909856464195467915L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "autorizacao_id", nullable = false)
	private AutorizacaoHoraExtra autorizacao;

	@ManyToOne
	@JoinColumn(name = "autorizado_id", nullable = false)
	private Funcionario autorizado;

	public AutorizacaoHoraExtraFuncionario() {
		super();
	}

	public AutorizacaoHoraExtraFuncionario(Long id, AutorizacaoHoraExtra autorizacao, Funcionario autorizado) {
		super();
		this.id = id;
		this.autorizacao = autorizacao;
		this.autorizado = autorizado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AutorizacaoHoraExtra getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(AutorizacaoHoraExtra autorizacao) {
		this.autorizacao = autorizacao;
	}

	public Funcionario getAutorizado() {
		return autorizado;
	}

	public void setAutorizado(Funcionario autorizado) {
		this.autorizado = autorizado;
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
		AutorizacaoHoraExtraFuncionario other = (AutorizacaoHoraExtraFuncionario) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "AutorizacaoHoraExtraFuncionario [id=" + id + ", autorizacao=" + autorizacao + ", autorizado="
				+ autorizado + "]";
	}

}