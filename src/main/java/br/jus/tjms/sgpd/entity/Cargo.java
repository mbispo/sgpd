package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.engine.annotations.FolowList;
import br.jus.tjms.sgpd.enumerators.GrauInstrucao;
import br.jus.tjms.sgpd.enumerators.NaturezaCargo;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;
import br.jus.tjms.sgpd.service.rest.v1.to.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "cargo.buscarCargosPorNome", 
			query = "SELECT c from Cargo c WHERE c.nome = :nome")
})
public class Cargo implements Serializable {

	private static final long serialVersionUID = 5920965869940559531L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "grupo_id", nullable = false)
	private GrupoCargo grupo;

	@Enumerated(EnumType.ORDINAL)
	private NaturezaCargo natureza;

	@Enumerated(EnumType.ORDINAL)
	private GrauInstrucao grauInstrucao;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "superiorHierarquico_id", nullable = true)
	private Cargo superiorHierarquico;

	@Column(length = 20)
	private String simbolo;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "atoCriacao_id", nullable = false)
	private AtoAdministrativo atoCriacao;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "atoExtincao_id", nullable = true)
	private AtoAdministrativo atoExtincao;
	
	@FolowList
	@OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<RubricaCargo> rubricas = new ArrayList<RubricaCargo>();
	
	@FolowList
	@OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<Referencia> referencias = new ArrayList<Referencia>();
	
	@FolowList
	@OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<CargoEspecialidade> especialidades = new ArrayList<CargoEspecialidade>();
	
	@FolowList
	@OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<CargoTipoProvimento> tiposProvimento = new ArrayList<CargoTipoProvimento>();
	
	@FolowList
	@OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<CargoOcupacao> ocupacoes = new ArrayList<CargoOcupacao>();
	

	public Cargo() {
		super();
	}

	public Cargo(Long id) {
		super();
		this.id = id;
	}
	
	public Cargo(Long id, String nome, GrupoCargo grupo, NaturezaCargo natureza, GrauInstrucao grauInstrucao,
			Cargo superiorHierarquico, String simbolo, AtoAdministrativo atoCriacao, AtoAdministrativo atoExtincao,
			List<RubricaCargo> rubricas, List<Referencia> referencias, List<CargoEspecialidade> especialidades,
			List<CargoTipoProvimento> tiposProvimento, List<CargoOcupacao> ocupacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.grupo = grupo;
		this.natureza = natureza;
		this.grauInstrucao = grauInstrucao;
		this.superiorHierarquico = superiorHierarquico;
		this.simbolo = simbolo;
		this.atoCriacao = atoCriacao;
		this.atoExtincao = atoExtincao;
		this.rubricas = rubricas;
		this.referencias = referencias;
		this.especialidades = especialidades;
		this.tiposProvimento = tiposProvimento;
		this.ocupacoes = ocupacoes;
	}

	public Cargo(String nome, String simbolo) {
		super();
		this.nome = nome;
		this.simbolo = simbolo;
	}

	public Cargo(CargoTO cargoTO) {
		this.id = cargoTO.getId();
		this.nome = cargoTO.getNome();
		this.grupo = new GrupoCargo(cargoTO.getGrupoCargoId());
		this.natureza = cargoTO.getNatureza();
		this.grauInstrucao = cargoTO.getGrauInstrucao();
		
		if (cargoTO.getCargoSuperiorHierarquicoId()!=null) {
			this.superiorHierarquico = new Cargo(cargoTO.getCargoSuperiorHierarquicoId());
		}
		
		this.simbolo = cargoTO.getSimbolo();
		this.atoCriacao = new AtoAdministrativo(cargoTO.getAtoAdministrativoCriacaoId());
		
		if (cargoTO.getAtoAdministrativoExtincaoId()!=null) {
			this.atoExtincao = new AtoAdministrativo(cargoTO.getAtoAdministrativoExtincaoId());
		}

		if (cargoTO.getRubricas()!=null) {
			for (RubricaCargoTO rubricaCargoTO : cargoTO.getRubricas()) {
				this.rubricas.add(new RubricaCargo(rubricaCargoTO));
				
			}
		}
		if (cargoTO.getReferencias()!=null) {
			for (ReferenciaTO referenciaTO : cargoTO.getReferencias()) {
				this.referencias.add(new Referencia(this,referenciaTO));
			}
		}
		
		if (cargoTO.getEspecialidades()!=null) {
			for (EspecialidadeTO especialidadeTO: cargoTO.getEspecialidades()) {
				this.especialidades.add(new CargoEspecialidade(this,especialidadeTO));				
			}
		}

		if (cargoTO.getTiposProvimento()!=null) {
			for (TipoProvimento tipoProvimento: cargoTO.getTiposProvimento()) {
				this.tiposProvimento.add(new CargoTipoProvimento(this, tipoProvimento));
			}
		}
		
		if (cargoTO.getOcupacoes()!=null) {
			for (OcupacaoTO ocupacaoTO: cargoTO.getOcupacoes()) {
				this.ocupacoes.add(new CargoOcupacao(this, ocupacaoTO));
			}
		}

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

	public GrupoCargo getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoCargo grupo) {
		this.grupo = grupo;
	}

	public NaturezaCargo getNatureza() {
		return natureza;
	}

	public void setNatureza(NaturezaCargo natureza) {
		this.natureza = natureza;
	}

	public GrauInstrucao getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(GrauInstrucao grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	public Cargo getSuperiorHierarquico() {
		return superiorHierarquico;
	}

	public void setSuperiorHierarquico(Cargo superiorHierarquico) {
		this.superiorHierarquico = superiorHierarquico;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public AtoAdministrativo getAtoCriacao() {
		return atoCriacao;
	}

	public void setAtoCriacao(AtoAdministrativo atoCriacao) {
		this.atoCriacao = atoCriacao;
	}

	public AtoAdministrativo getAtoExtincao() {
		return atoExtincao;
	}

	public void setAtoExtincao(AtoAdministrativo atoExtincao) {
		this.atoExtincao = atoExtincao;
	}

	public List<RubricaCargo> getRubricas() {
        return rubricas;
    }

    public List<Rubrica> getRubricasBase() {
        return rubricas.stream().map(RubricaCargo::getRubrica).collect(Collectors.toList());
    }

	public void setRubricas(List<RubricaCargo> rubricas) {
		this.rubricas = rubricas;
	}

	public List<Referencia> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}

	public List<CargoEspecialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<CargoEspecialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<CargoTipoProvimento> getTiposProvimento() {
		return tiposProvimento;
	}

	public void setTiposProvimento(List<CargoTipoProvimento> tiposProvimento) {
		this.tiposProvimento = tiposProvimento;
	}

	public List<CargoOcupacao> getOcupacoes() {
		return ocupacoes;
	}

	public void setOcupacoes(List<CargoOcupacao> ocupacoes) {
		this.ocupacoes = ocupacoes;
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
		Cargo other = (Cargo) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome=" + nome + ", grupo=" + grupo + ", natureza=" + natureza
				+ ", grauInstrucao=" + grauInstrucao + ", superiorHierarquico=" + superiorHierarquico + ", simbolo="
				+ simbolo + ", atoCriacao=" + atoCriacao + ", atoExtincao=" + atoExtincao + "]";
	}

	public void alterar(CargoTO cargoTO) {
		this.nome = cargoTO.getNome();
		this.grupo = new GrupoCargo(cargoTO.getGrupoCargoId());
		this.natureza = cargoTO.getNatureza();
		this.grauInstrucao = cargoTO.getGrauInstrucao();
		
		if (cargoTO.getCargoSuperiorHierarquicoId()!=null) {
			this.superiorHierarquico = new Cargo(cargoTO.getCargoSuperiorHierarquicoId());
		}
		
		this.simbolo = cargoTO.getSimbolo();
		this.atoCriacao = new AtoAdministrativo(cargoTO.getAtoAdministrativoCriacaoId());
		
		if (cargoTO.getAtoAdministrativoExtincaoId()!=null) {
			this.atoExtincao = new AtoAdministrativo(cargoTO.getAtoAdministrativoExtincaoId());
		}

		if (cargoTO.getRubricas()!=null) {
			for (RubricaCargoTO rubricaCargoTO : cargoTO.getRubricas()) {
				this.rubricas.add(new RubricaCargo(rubricaCargoTO));
				
			}
		}

		if (cargoTO.getReferencias()!=null) {
			for (ReferenciaTO referenciaTO : cargoTO.getReferencias()) {
				this.referencias.add(new Referencia(this,referenciaTO));
			}
		}
		
		if (cargoTO.getEspecialidades()!=null) {
			for (EspecialidadeTO especialidadeTO: cargoTO.getEspecialidades()) {
				this.especialidades.add(new CargoEspecialidade(this,especialidadeTO));
			}
		}

		if (cargoTO.getTiposProvimento()!=null) {
			for (TipoProvimento tipoProvimento: cargoTO.getTiposProvimento()) {
				this.tiposProvimento.add(new CargoTipoProvimento(this, tipoProvimento));
			}
		}
		
		if (cargoTO.getOcupacoes()!=null) {
			for (OcupacaoTO ocupacaoTO: cargoTO.getOcupacoes()) {
				this.ocupacoes.add(new CargoOcupacao(this, ocupacaoTO));
			}
		}
		
	}
	
	public CargoTO toTO() {
		return new CargoTO(id, nome, grupo.getId(), natureza, grauInstrucao,
				superiorHierarquico!=null?superiorHierarquico.getId():null, simbolo, atoCriacao!=null?atoCriacao.getId():null,
				atoExtincao!=null?atoExtincao.getId():null);
	}

}