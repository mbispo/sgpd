package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.enumerators.TipoDeclaracaoBens;

public class DeclaracaoBensTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long pessoaId;
	private TipoDeclaracaoBens tipo;
	private Integer anoDeclaracao;
	private Integer anoExercicio;
	private Boolean enviada;
	private String declaracao;
	private Integer idDocumentoGerdoc;
	private Pessoa pessoa;
	
	public DeclaracaoBensTO() {
		super();
	}

	public DeclaracaoBensTO(Long id, Long pessoaId, TipoDeclaracaoBens tipo, Integer anoDeclaracao,
			Integer anoExercicio, Boolean enviada, String declaracao, Integer idDocumentoGerdoc) {
		super();
		this.id = id;
		this.pessoaId = pessoaId;
		this.tipo = tipo;
		this.anoDeclaracao = anoDeclaracao;
		this.anoExercicio = anoExercicio;
		this.enviada = enviada;
		this.declaracao = declaracao;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
	}

	public DeclaracaoBensTO(Long pessoaId, TipoDeclaracaoBens tipo, Integer anoDeclaracao, Integer anoExercicio,
			Boolean enviada, String declaracao, Integer idDocumentoGerdoc) {
		super();
		this.pessoaId = pessoaId;
		this.tipo = tipo;
		this.anoDeclaracao = anoDeclaracao;
		this.anoExercicio = anoExercicio;
		this.enviada = enviada;
		this.declaracao = declaracao;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public TipoDeclaracaoBens getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeclaracaoBens tipo) {
		this.tipo = tipo;
	}

	public Integer getAnoDeclaracao() {
		return anoDeclaracao;
	}

	public void setAnoDeclaracao(Integer anoDeclaracao) {
		this.anoDeclaracao = anoDeclaracao;
	}

	public Integer getAnoExercicio() {
		return anoExercicio;
	}

	public void setAnoExercicio(Integer anoExercicio) {
		this.anoExercicio = anoExercicio;
	}

	public Boolean getEnviada() {
		return enviada;
	}

	public void setEnviada(Boolean enviada) {
		this.enviada = enviada;
	}

	public String getDeclaracao() {
		return declaracao;
	}

	public void setDeclaracao(String declaracao) {
		this.declaracao = declaracao;
	}

	public Integer getIdDocumentoGerdoc() {
		return idDocumentoGerdoc;
	}

	public void setIdDocumentoGerdoc(Integer idDocumentoGerdoc) {
		this.idDocumentoGerdoc = idDocumentoGerdoc;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "DeclaracaoBensTO [id=" + id + ", pessoaId=" + pessoaId + ", tipo=" + tipo + ", anoDeclaracao="
				+ anoDeclaracao + ", anoExercicio=" + anoExercicio + ", enviada=" + enviada + ", declaracao="
				+ declaracao + ", idDocumentoGerdoc=" + idDocumentoGerdoc + "]";
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
		DeclaracaoBensTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}