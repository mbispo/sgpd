package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoDeclaracaoBens;
import br.jus.tjms.sgpd.service.rest.v1.to.DeclaracaoBensTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "declaracaoBens.buscarDeclaracoesBensPorPessoa", 
			query = "SELECT d from DeclaracaoBens d WHERE d.pessoa.id = :pessoaId")
})
public class DeclaracaoBens implements Serializable {

	private static final long serialVersionUID = 3854019992042382171L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@Enumerated(EnumType.ORDINAL)
	private TipoDeclaracaoBens tipo;

	private Integer anoDeclaracao;
	private Integer anoExercicio;
	private Boolean enviada;

	@Column(length = 500)
	private String declaracao;

	private Integer idDocumentoGerdoc;

	public DeclaracaoBens() {
		super();
	}

	public DeclaracaoBens(Long id, Pessoa pessoa, TipoDeclaracaoBens tipo, Integer anoDeclaracao, Integer anoExercicio,
			Boolean enviada, String declaracao, Integer idDocumentoGerdoc) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.tipo = tipo;
		this.anoDeclaracao = anoDeclaracao;
		this.anoExercicio = anoExercicio;
		this.enviada = enviada;
		this.declaracao = declaracao;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
	}

	public DeclaracaoBens(DeclaracaoBensTO declaracaoBensTO) {
		super();
		this.pessoa = declaracaoBensTO.getPessoa();
		this.tipo = declaracaoBensTO.getTipo();
		this.anoDeclaracao = declaracaoBensTO.getAnoDeclaracao();
		this.anoExercicio = declaracaoBensTO.getAnoExercicio();
		this.enviada = declaracaoBensTO.getEnviada();
		this.declaracao = declaracaoBensTO.getDeclaracao();
		this.idDocumentoGerdoc = declaracaoBensTO.getIdDocumentoGerdoc();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	public String getDeclaracao() {
		return declaracao;
	}

	public void setDeclaracao(String declaracao) {
		this.declaracao = declaracao;
	}

	public Boolean getEnviada() {
		return enviada;
	}

	public void setEnviada(Boolean enviada) {
		this.enviada = enviada;
	}

	public Integer getIdDocumentoGerdoc() {
		return idDocumentoGerdoc;
	}

	public void setIdDocumentoGerdoc(Integer idDocumentoGerdoc) {
		this.idDocumentoGerdoc = idDocumentoGerdoc;
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
		DeclaracaoBens other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DeclaracaoBens [id=" + id + ", pessoa=" + pessoa + ", tipo=" + tipo + ", anoDeclaracao="
				+ anoDeclaracao + ", anoExercicio=" + anoExercicio + ", enviada=" + enviada + ", declaracao="
				+ declaracao + ", idDocumentoGerdoc=" + idDocumentoGerdoc + "]";
	}

}