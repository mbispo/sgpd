package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.EstadoCivil;
import br.jus.tjms.sgpd.enumerators.GrauInstrucao;
import br.jus.tjms.sgpd.enumerators.Raca;
import br.jus.tjms.sgpd.enumerators.Sexo;
import br.jus.tjms.sgpd.enumerators.TipoSanguineo;

@XmlRootElement
public class PessoaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Date dataNascimento;
	private Sexo sexo;
	private Raca raca;
	private Boolean doadorDeOrgaos;
	private EstadoCivil estadoCivil;
	private TipoSanguineo tipoSanguineo;
	private LocalidadeTO naturalidade;
	private PaisTO nacionalidade;
	private Integer anoChegadaAoPais;
	private GrauInstrucao grauInstrucao;
	private String nomeMae;
	private String nomePai;
	private String nomeConjuge;

	private List<DocumentoTO> documentos = new ArrayList<DocumentoTO>();
	private List<ContatoTO> contatos = new ArrayList<ContatoTO>();
	private List<PessoaEnderecoTO> enderecos = new ArrayList<PessoaEnderecoTO>();
	private List<ContaRecebimentoTO> contasRecebimento = new ArrayList<ContaRecebimentoTO>();

	private List<RelacaoDependenciaTO> relacoesDependencia = new ArrayList<RelacaoDependenciaTO>();
	private List<RelacaoHierarquicaTO> relacoesHierarquicas = new ArrayList<RelacaoHierarquicaTO>();
	private List<RelacaoSocialTO> relacoesSociais = new ArrayList<RelacaoSocialTO>();
	
	private List<VeiculoTO> veiculos = new ArrayList<VeiculoTO>();

	private List<AtitudeTO> atitudes = new ArrayList<AtitudeTO>();
	private List<CompetenciaTO> competencias = new ArrayList<CompetenciaTO>();
	private List<ConhecimentoTO> conhecimentos = new ArrayList<ConhecimentoTO>();
	private List<CursoTO> cursos = new ArrayList<CursoTO>();
	private List<PessoaFormacaoTO> formacoes = new ArrayList<PessoaFormacaoTO>();
	private List<HabilidadeTO> habilidades = new ArrayList<HabilidadeTO>();	
	
	public PessoaTO() {
		super();
	}

	public PessoaTO(Long id) {
		super();
		this.id = id;
	}

	public PessoaTO(Long id, String nome, Date dataNascimento, Sexo sexo, Raca raca, Boolean doadorDeOrgaos,
			EstadoCivil estadoCivil, TipoSanguineo tipoSanguineo, LocalidadeTO naturalidade, PaisTO nacionalidade,
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

	public PessoaTO(String nome, Date dataNascimento, Sexo sexo, Raca raca, Boolean doadorDeOrgaos,
			EstadoCivil estadoCivil, TipoSanguineo tipoSanguineo, LocalidadeTO naturalidade, PaisTO nacionalidade,
			Integer anoChegadaAoPais, GrauInstrucao grauInstrucao, String nomeMae, String nomePai, String nomeConjuge) {
		super();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalidadeTO getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(LocalidadeTO naturalidade) {
		this.naturalidade = naturalidade;
	}

	public PaisTO getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(PaisTO nacionalidade) {
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

	public List<DocumentoTO> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoTO> documentos) {
		this.documentos = documentos;
	}

	public List<ContatoTO> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoTO> contatos) {
		this.contatos = contatos;
	}

	public List<PessoaEnderecoTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<PessoaEnderecoTO> enderecos) {
		this.enderecos = enderecos;
	}

	public List<ContaRecebimentoTO> getContasRecebimento() {
		return contasRecebimento;
	}

	public void setContasRecebimento(List<ContaRecebimentoTO> contasRecebimento) {
		this.contasRecebimento = contasRecebimento;
	}

	public List<RelacaoDependenciaTO> getRelacoesDependencia() {
		return relacoesDependencia;
	}

	public void setRelacoesDependencia(List<RelacaoDependenciaTO> relacoesDependencia) {
		this.relacoesDependencia = relacoesDependencia;
	}

	public List<RelacaoHierarquicaTO> getRelacoesHierarquicas() {
		return relacoesHierarquicas;
	}

	public void setRelacoesHierarquicas(List<RelacaoHierarquicaTO> relacoesHierarquicas) {
		this.relacoesHierarquicas = relacoesHierarquicas;
	}

	public List<RelacaoSocialTO> getRelacoesSociais() {
		return relacoesSociais;
	}

	public void setRelacoesSociais(List<RelacaoSocialTO> relacoesSociais) {
		this.relacoesSociais = relacoesSociais;
	}

	public List<VeiculoTO> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoTO> veiculos) {
		this.veiculos = veiculos;
	}

	public List<AtitudeTO> getAtitudes() {
		return atitudes;
	}

	public void setAtitudes(List<AtitudeTO> atitudes) {
		this.atitudes = atitudes;
	}

	public List<CompetenciaTO> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<CompetenciaTO> competencias) {
		this.competencias = competencias;
	}

	public List<ConhecimentoTO> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(List<ConhecimentoTO> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}

	public List<CursoTO> getCursos() {
		return cursos;
	}

	public void setCursos(List<CursoTO> cursos) {
		this.cursos = cursos;
	}

	public List<PessoaFormacaoTO> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<PessoaFormacaoTO> formacoes) {
		this.formacoes = formacoes;
	}

	public List<HabilidadeTO> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<HabilidadeTO> habilidades) {
		this.habilidades = habilidades;
	}

	@Override
	public String toString() {
		return "PessoaTO [nome=" + nome + "]";
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
		PessoaTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}