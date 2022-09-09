package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoAtualizacaoDadosCadastrais;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:04
 */
@Entity
@Auditavel
@Cacheable
public class SolicitacaoAtualizacaoDadosCadastrais implements Serializable {

	private static final long serialVersionUID = -8814276946139014738L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@Column(length = 255)
	private String nome;

	private Date dataNascimento;

	@Column(length = 20)
	private String cpf;

	@Column(length = 50)
	private String rg;

	@Column(length = 255)
	private Endereco enderecoResidencial;

	@Column(length = 255)
	private String email;

	@Column(length = 60)
	private String telefoneContato;

	@Column(length = 60)
	private String telefoneResidencial;

	@Column(length = 60)
	private String celular;

	private Integer exercicio;

	@Column(length = 60)
	private String ramal;
	private Boolean inativo;

	@Column(length = 500)
	private String observacoes;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoAtualizacaoDadosCadastrais situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoAtualizacaoDadosCadastrais() {
		super();
	}

	public SolicitacaoAtualizacaoDadosCadastrais(Long id, Funcionario solicitante, String nome, Date dataNascimento,
			String cpf, String rg, Endereco enderecoResidencial, String email, String telefoneContato,
			String telefoneResidencial, String celular, Integer exercicio, String ramal, Boolean inativo,
			String observacoes, SituacaoSolicitacaoAtualizacaoDadosCadastrais situacao, Date dataSituacao,
			String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.enderecoResidencial = enderecoResidencial;
		this.email = email;
		this.telefoneContato = telefoneContato;
		this.telefoneResidencial = telefoneResidencial;
		this.celular = celular;
		this.exercicio = exercicio;
		this.ramal = ramal;
		this.inativo = inativo;
		this.observacoes = observacoes;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Funcionario solicitante) {
		this.solicitante = solicitante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Endereco getEnderecoResidencial() {
		return enderecoResidencial;
	}

	public void setEnderecoResidencial(Endereco enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getExercicio() {
		return exercicio;
	}

	public void setExercicio(Integer exercicio) {
		this.exercicio = exercicio;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public Boolean getInativo() {
		return inativo;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public SituacaoSolicitacaoAtualizacaoDadosCadastrais getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoAtualizacaoDadosCadastrais situacao) {
		this.situacao = situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
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
		SolicitacaoAtualizacaoDadosCadastrais other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoAtualizacaoDadosCadastrais [id=" + id + ", solicitante=" + solicitante + ", nome=" + nome
				+ ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", rg=" + rg + ", enderecoResidencial="
				+ enderecoResidencial + ", email=" + email + ", telefoneContato=" + telefoneContato
				+ ", telefoneResidencial=" + telefoneResidencial + ", celular=" + celular + ", exercicio=" + exercicio
				+ ", ramal=" + ramal + ", inativo=" + inativo + ", observacoes=" + observacoes + ", situacao="
				+ situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}