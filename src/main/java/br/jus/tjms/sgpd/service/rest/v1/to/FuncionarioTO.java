package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoFuncionario;

public class FuncionarioTO implements Serializable {

	private static final long serialVersionUID = -6137531163291629487L;

	private Long id;
	private Integer matricula;
	private TipoFuncionario tipoFuncionario;
	private PessoaTO pessoa;

	public FuncionarioTO() {
		super();
	}

	public FuncionarioTO(Long id, Integer matricula, TipoFuncionario tipoFuncionario, PessoaTO pessoa) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.tipoFuncionario = tipoFuncionario;
		this.pessoa = pessoa;
	}

	public FuncionarioTO(Integer matricula, TipoFuncionario tipoFuncionario, PessoaTO pessoa) {
		super();
		this.matricula = matricula;
		this.tipoFuncionario = tipoFuncionario;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public PessoaTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaTO pessoa) {
		this.pessoa = pessoa;
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
		FuncionarioTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FuncionarioTO [id=" + id + ", matricula=" + matricula + ", tipoFuncionario=" + tipoFuncionario
				+ ", pessoa=" + pessoa + "]";
	}

}