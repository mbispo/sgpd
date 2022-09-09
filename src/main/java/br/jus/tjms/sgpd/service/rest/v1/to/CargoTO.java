package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.GrauInstrucao;
import br.jus.tjms.sgpd.enumerators.NaturezaCargo;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;

public class CargoTO implements Serializable {

	private static final long serialVersionUID = -8851371897333469281L;
	
	private Long id;
	private String nome;
	private Long grupoCargoId;
	private NaturezaCargo natureza;
	private GrauInstrucao grauInstrucao;
	private Long cargoSuperiorHierarquicoId;
	private String simbolo;
	private Long atoAdministrativoCriacaoId;
	private Long atoAdministrativoExtincaoId;
	private List<RubricaCargoTO> rubricas = new ArrayList<RubricaCargoTO>();
	private List<ReferenciaTO> referencias = new ArrayList<ReferenciaTO>();	
	private List<EspecialidadeTO> especialidades = new ArrayList<EspecialidadeTO>();
	private List<TipoProvimento> tiposProvimento = new ArrayList<TipoProvimento>();
	private List<OcupacaoTO> ocupacoes = new ArrayList<OcupacaoTO>();	

	public CargoTO() {
		super();
	}

	public CargoTO(Long id, String nome, Long grupoCargoId, NaturezaCargo natureza, GrauInstrucao grauInstrucao,
			Long cargoSuperiorHierarquicoId, String simbolo, Long atoAdministrativoCriacaoId,
			Long atoAdministrativoExtincaoId, List<RubricaCargoTO> rubricas, List<ReferenciaTO> referencias,
			List<EspecialidadeTO> especialidades, List<TipoProvimento> tiposProvimento, List<OcupacaoTO> ocupacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.grupoCargoId = grupoCargoId;
		this.natureza = natureza;
		this.grauInstrucao = grauInstrucao;
		this.cargoSuperiorHierarquicoId = cargoSuperiorHierarquicoId;
		this.simbolo = simbolo;
		this.atoAdministrativoCriacaoId = atoAdministrativoCriacaoId;
		this.atoAdministrativoExtincaoId = atoAdministrativoExtincaoId;
		this.rubricas = rubricas;
		this.referencias = referencias;
		this.especialidades = especialidades;
		this.tiposProvimento = tiposProvimento;
		this.ocupacoes = ocupacoes;
	}

	public CargoTO(Long id, String nome, Long grupoCargoId, NaturezaCargo natureza, GrauInstrucao grauInstrucao,
			Long cargoSuperiorHierarquicoId, String simbolo, Long atoAdministrativoCriacaoId,
			Long atoAdministrativoExtincaoId) {
		super();
		this.id = id;
		this.nome = nome;
		this.grupoCargoId = grupoCargoId;
		this.natureza = natureza;
		this.grauInstrucao = grauInstrucao;
		this.cargoSuperiorHierarquicoId = cargoSuperiorHierarquicoId;
		this.simbolo = simbolo;
		this.atoAdministrativoCriacaoId = atoAdministrativoCriacaoId;
		this.atoAdministrativoExtincaoId = atoAdministrativoExtincaoId;
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

	public Long getGrupoCargoId() {
		return grupoCargoId;
	}

	public void setGrupoCargoId(Long grupoCargoId) {
		this.grupoCargoId = grupoCargoId;
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

	public Long getCargoSuperiorHierarquicoId() {
		return cargoSuperiorHierarquicoId;
	}

	public void setCargoSuperiorHierarquicoId(Long cargoSuperiorHierarquicoId) {
		this.cargoSuperiorHierarquicoId = cargoSuperiorHierarquicoId;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public Long getAtoAdministrativoCriacaoId() {
		return atoAdministrativoCriacaoId;
	}

	public void setAtoAdministrativoCriacaoId(Long atoAdministrativoCriacaoId) {
		this.atoAdministrativoCriacaoId = atoAdministrativoCriacaoId;
	}

	public Long getAtoAdministrativoExtincaoId() {
		return atoAdministrativoExtincaoId;
	}

	public void setAtoAdministrativoExtincaoId(Long atoAdministrativoExtincaoId) {
		this.atoAdministrativoExtincaoId = atoAdministrativoExtincaoId;
	}

	public List<RubricaCargoTO> getRubricas() {
		return rubricas;
	}

	public void setRubricas(List<RubricaCargoTO> rubricas) {
		this.rubricas = rubricas;
	}

	public List<ReferenciaTO> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<ReferenciaTO> referencias) {
		this.referencias = referencias;
	}

	public List<EspecialidadeTO> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<EspecialidadeTO> especialidades) {
		this.especialidades = especialidades;
	}

	public List<TipoProvimento> getTiposProvimento() {
		return tiposProvimento;
	}

	public void setTiposProvimento(List<TipoProvimento> tiposProvimento) {
		this.tiposProvimento = tiposProvimento;
	}

	public List<OcupacaoTO> getOcupacoes() {
		return ocupacoes;
	}

	public void setOcupacoes(List<OcupacaoTO> ocupacoes) {
		this.ocupacoes = ocupacoes;
	}

	@Override
	public String toString() {
		return "CargoTO [id=" + id + ", nome=" + nome + ", grupoCargoId=" + grupoCargoId + ", natureza=" + natureza
				+ ", grauInstrucao=" + grauInstrucao + ", cargoSuperiorHierarquicoId=" + cargoSuperiorHierarquicoId
				+ ", simbolo=" + simbolo + ", atoAdministrativoCriacaoId=" + atoAdministrativoCriacaoId
				+ ", atoAdministrativoExtincaoId=" + atoAdministrativoExtincaoId + "]";
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
		CargoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}