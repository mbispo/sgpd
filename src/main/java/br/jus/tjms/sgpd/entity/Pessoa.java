package br.jus.tjms.sgpd.entity;


import br.jus.tjms.sgpd.enumerators.*;
import br.jus.tjms.sgpd.service.rest.v1.to.PessoaTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "discriminador")
@DiscriminatorValue("PESSOA")
@NamedQueries({
	@NamedQuery(name = "pessoa.buscarPorNome", 
			query = "SELECT p FROM Pessoa p WHERE p.nome = :nome" ),
@NamedQuery(name = "pessoa.buscarEnderecosPorPessoa", 
	query = "SELECT e FROM Pessoa p JOIN p.enderecos e WHERE p.id = :id" )
})
public class Pessoa implements Serializable {

	private static final long serialVersionUID = -3894740767637633507L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	private String nome;

	private Date dataNascimento;

	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;

	@Enumerated(EnumType.ORDINAL)
	private Raca raca;

	private Boolean doadorDeOrgaos;

	@Enumerated(EnumType.ORDINAL)
	private EstadoCivil estadoCivil;

	@Enumerated(EnumType.ORDINAL)
	private TipoSanguineo tipoSanguineo;

	@ManyToOne
	@JoinColumn(name = "naturalidade_id")
	private Localidade naturalidade;

	@ManyToOne
	@JoinColumn(name = "nacionalidade_id")
	private Pais nacionalidade;

	private Integer anoChegadaAoPais;

	@Enumerated(EnumType.ORDINAL)
	private GrauInstrucao grauInstrucao;

	@Column(length = 255)
	private String nomeMae;

	@Column(length = 255)
	private String nomePai;

	@Column(length = 255)
	private String nomeConjuge;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<Documento> documentos = new ArrayList<Documento>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<Contato> contatos = new ArrayList<Contato>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<PessoaEndereco> enderecos = new ArrayList<PessoaEndereco>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<ContaRecebimento> contasRecebimento = new ArrayList<ContaRecebimento>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<PessoaAtitude> atitudes = new ArrayList<PessoaAtitude>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<PessoaCompetencia> competencias = new ArrayList<PessoaCompetencia>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<PessoaConhecimento> conhecimentos = new ArrayList<PessoaConhecimento>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<PessoaCurso> cursos = new ArrayList<PessoaCurso>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<PessoaFormacao> formacoes = new ArrayList<PessoaFormacao>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<PessoaHabilidade> habilidades = new ArrayList<PessoaHabilidade>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RelacaoDependencia> relacoesDependencia = new ArrayList<RelacaoDependencia>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RelacaoHierarquica> relacoesHierarquicas = new ArrayList<RelacaoHierarquica>();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RelacaoSocial> relacoesSociais = new ArrayList<RelacaoSocial>();	

	public Pessoa() {
		super();
	}

	public Pessoa(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Pessoa(Long id) {
		super();
		this.id = id;
	}

	public Pessoa(Long id, String nome, Date dataNascimento, Sexo sexo, Raca raca, Boolean doadorDeOrgaos,
			EstadoCivil estadoCivil, TipoSanguineo tipoSanguineo, Localidade naturalidade, Pais nacionalidade,
			Integer anoChegadaAoPais, GrauInstrucao grauInstrucao, String nomeMae, String nomePai, String nomeConjuge) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.raca = raca;
		this.doadorDeOrgaos = doadorDeOrgaos;
		this.estadoCivil = estadoCivil;
		this.tipoSanguineo = tipoSanguineo;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.anoChegadaAoPais = anoChegadaAoPais;
		this.grauInstrucao = grauInstrucao;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		this.nomeConjuge = nomeConjuge;
	}
	
	public Pessoa(PessoaTO pessoaTO) {
		this.id = pessoaTO.getId();
		this.nome = pessoaTO.getNome();
		this.dataNascimento = pessoaTO.getDataNascimento();
		this.sexo = pessoaTO.getSexo();
		this.raca = pessoaTO.getRaca();
		this.doadorDeOrgaos = pessoaTO.getDoadorDeOrgaos();
		this.estadoCivil = pessoaTO.getEstadoCivil();
		this.tipoSanguineo = pessoaTO.getTipoSanguineo();
		this.anoChegadaAoPais = pessoaTO.getAnoChegadaAoPais();
		this.grauInstrucao = pessoaTO.getGrauInstrucao();
		this.nomeMae = pessoaTO.getNomeMae();
		this.nomePai = pessoaTO.getNomePai();
		this.nomeConjuge = pessoaTO.getNomeConjuge();

		if(pessoaTO.getNaturalidade() != null){
			this.naturalidade = new Localidade(pessoaTO.getNaturalidade());
		}
		
		if (pessoaTO.getNacionalidade()!=null) {
			this.nacionalidade = new Pais(pessoaTO.getNacionalidade());
		}

	}
	
	public PessoaTO toTO() {
		PessoaTO to = new PessoaTO(id, nome, dataNascimento, sexo, raca, doadorDeOrgaos,
				estadoCivil, tipoSanguineo, naturalidade!=null?naturalidade.toTO():null, nacionalidade!=null?nacionalidade.toTO():null,
				anoChegadaAoPais, grauInstrucao, nomeMae, nomePai, nomeConjuge);
		return to;
	}

	public Long getId() {
		return id;
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
	
	@Transient
	public Integer getIdade() {
		return 0;
	}
	
	@Transient
	public Integer getIdadeNaData(Date data) {
		return 0;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Boolean getDoadorDeOrgaos() {
		return doadorDeOrgaos;
	}

	public void setDoadorDeOrgaos(Boolean doadorDeOrgaos) {
		this.doadorDeOrgaos = doadorDeOrgaos;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public Localidade getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(Localidade naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Pais getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Pais nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Integer getAnoChegadaAoPais() {
		return anoChegadaAoPais;
	}

	public void setAnoChegadaAoPais(Integer anoChegadaAoPais) {
		this.anoChegadaAoPais = anoChegadaAoPais;
	}

	public GrauInstrucao getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(GrauInstrucao grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	@JsonIgnore
	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	@JsonIgnore
	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	@JsonIgnore
	public List<PessoaEndereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<PessoaEndereco> enderecos) {
		this.enderecos = enderecos;
	}

	@JsonIgnore
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@JsonIgnore
	public List<ContaRecebimento> getContasRecebimento() {
		return contasRecebimento;
	}

	public void setContasRecebimento(List<ContaRecebimento> contasRecebimento) {
		this.contasRecebimento = contasRecebimento;
	}

	@JsonIgnore
	public List<PessoaAtitude> getAtitudes() {
		return atitudes;
	}

	public void setAtitudes(List<PessoaAtitude> atitudes) {
		this.atitudes = atitudes;
	}

	@JsonIgnore
	public List<PessoaCompetencia> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<PessoaCompetencia> competencias) {
		this.competencias = competencias;
	}

	@JsonIgnore
	public List<PessoaConhecimento> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(List<PessoaConhecimento> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}

	@JsonIgnore
	public List<PessoaCurso> getCursos() {
		return cursos;
	}

	public void setCursos(List<PessoaCurso> cursos) {
		this.cursos = cursos;
	}

	@JsonIgnore
	public List<PessoaFormacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<PessoaFormacao> formacoes) {
		this.formacoes = formacoes;
	}

	@JsonIgnore
	public List<PessoaHabilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<PessoaHabilidade> habilidades) {
		this.habilidades = habilidades;
	}
	
	@JsonIgnore
	public List<RelacaoDependencia> getRelacoesDependencia() {
		return relacoesDependencia;
	}

	public void setRelacoesDependencia(List<RelacaoDependencia> relacoesDependencia) {
		this.relacoesDependencia = relacoesDependencia;
	}
	
	@JsonIgnore
	public List<RelacaoHierarquica> getRelacoesHierarquicas() {
		return relacoesHierarquicas;
	}

	public void setRelacoesHierarquicas(List<RelacaoHierarquica> relacoesHierarquicas) {
		this.relacoesHierarquicas = relacoesHierarquicas;
	}

	@JsonIgnore
	public List<RelacaoSocial> getRelacoesSociais() {
		return relacoesSociais;
	}

	public void setRelacoesSociais(List<RelacaoSocial> relacoesSociais) {
		this.relacoesSociais = relacoesSociais;
	}

	@Transient
	public Integer getNumeroDependentesImpostoRendaNaData(Date data) {
		List<RelacaoDependencia> lista = getRelacoesDependenciaNaDataPorFlag(false, false, true, data);
		return lista!=null?lista.size():0;
	}
	
	@Transient
	public List<RelacaoDependencia> getRelacoesDependenciaNaDataPorFlag(final Boolean economica, final Boolean previdenciaria, final Boolean impostoDeRenda, final Date data) {

		/* usando guava */

		if (relacoesDependencia != null) {
			Collection<RelacaoDependencia> c = Collections2.filter(relacoesDependencia, new Predicate<RelacaoDependencia>() {
				@Override
				public boolean apply(RelacaoDependencia r) {
					return ((r.getInicio().before(data)&&(r.getFim()==null||r.getFim().after(data)))&&(economica&&r.getEconomica() || previdenciaria&&r.getPrevidenciaria() || impostoDeRenda&&r.getImpostoDeRenda()));
				}
			});
			
			return new ArrayList<>(c);
		}

		// usando lambda
		/*
		if (relacoesDependencia != null) {
			return relacoesDependencia.stream()
					.filter(r -> (r.getInicio().before(data)&&(r.getFim()==null||r.getFim().after(data)))&&(economica&&r.getEconomica() || previdenciaria&&r.getPrevidenciaria() || impostoDeRenda&&r.getImpostoDeRenda()))
					.collect(Collectors.toList());
		}
		*/

		return null;
	}	
	
	@Transient
	public List<RelacaoDependencia> getRelacoesDependenciaPorTipo(final TipoRelacaoDependencia tipo) {

		/* usando guava */

		if (relacoesDependencia != null) {
			Collection<RelacaoDependencia> c = Collections2.filter(relacoesDependencia, new Predicate<RelacaoDependencia>() {
				@Override
				public boolean apply(RelacaoDependencia r) {
					return (r.getTipo().equals(tipo));
				}
			});
			
			return new ArrayList<>(c);
		}

		// usando lambda
		/*
		if (relacoesDependencia != null) {
			return relacoesDependencia.stream()
					.filter(r -> r.getTipo().equals(tipo))
					.collect(Collectors.toList());
		}
		*/

		return null;
	}
	
	@Transient
	public List<ContaRecebimento> getContasRecebimentoAtivasPorTipo(final TipoContaRecebimento tipo) {

		/* usando guava */

		if (contasRecebimento != null) {
			Collection<ContaRecebimento> c = Collections2.filter(contasRecebimento, new Predicate<ContaRecebimento>() {
				@Override
				public boolean apply(ContaRecebimento c) {
					return (c.getTipo().equals(tipo)&&c.getAtiva());
				}
			});
			
			return new ArrayList<>(c);
		}

		// usando lambda
		/*
		if (contasRecebimento != null) {
			return contasRecebimento.stream()
					.filter(c -> (c.getTipo().equals(tipo)&&c.getAtiva()))
					.collect(Collectors.toList());
		}
		*/

		return null;
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
		Pessoa other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", raca=" + raca + ", doadorDeOrgaos=" + doadorDeOrgaos + ", estadoCivil=" + estadoCivil
				+ ", tipoSanguineo=" + tipoSanguineo + ", naturalidade=" + naturalidade + ", nacionalidade="
				+ nacionalidade + ", anoChegadaAoPais=" + anoChegadaAoPais + ", grauInstrucao=" + grauInstrucao
				+ ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + ", nomeConjuge=" + nomeConjuge + "]";
	}

	public void atualizarDados(PessoaTO pessoaTO) {
		this.nome = pessoaTO.getNome();
		this.dataNascimento = pessoaTO.getDataNascimento();
		this.sexo = pessoaTO.getSexo();
		this.raca = pessoaTO.getRaca();
		this.doadorDeOrgaos = pessoaTO.getDoadorDeOrgaos();
		this.estadoCivil = pessoaTO.getEstadoCivil();
		this.tipoSanguineo = pessoaTO.getTipoSanguineo();
		this.anoChegadaAoPais = pessoaTO.getAnoChegadaAoPais();
		this.grauInstrucao = pessoaTO.getGrauInstrucao();
		this.nomeMae = pessoaTO.getNomeMae();
		this.nomePai = pessoaTO.getNomePai();
		this.nomeConjuge = pessoaTO.getNomeConjuge();
		
		if (pessoaTO.getNaturalidade() != null) {
			this.naturalidade = new Localidade(pessoaTO.getNaturalidade());
		}

		if (pessoaTO.getNacionalidade() != null) {
			this.nacionalidade = new Pais(pessoaTO.getNacionalidade());
		}
		
	}

}