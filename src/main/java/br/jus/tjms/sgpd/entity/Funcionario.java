package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoFuncionario;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;
import br.jus.tjms.sgpd.enumerators.TipoRecorrencia;
import br.jus.tjms.sgpd.service.rest.v1.to.FuncionarioTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "funcionario.buscarPorPessoaId", 
			query = "SELECT f FROM Funcionario f WHERE f.pessoa.id = :id" ),	
	@NamedQuery(name = "funcionario.buscarPorNome", 
			query = "SELECT f FROM Funcionario f WHERE f.pessoa.nome = :nome" ),
	@NamedQuery(name = "funcionario.buscarPorMatricula", 
			query = "SELECT f FROM Funcionario f WHERE f.matricula = :matricula" )
})
public class Funcionario implements Serializable {

	private static final long serialVersionUID = -7620795042229304331L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer matricula;

	@Enumerated(EnumType.ORDINAL)
	private TipoFuncionario tipoFuncionario;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;
	
	//----------------------------------------------------------------------------------------------------------------
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<FuncionarioCargo> cargos = new ArrayList<FuncionarioCargo>();
	
	@OrderBy("dataInicio desc, id desc")
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<FuncionarioArea> areas = new ArrayList<FuncionarioArea>();	
	
	//----------------------------------------------------------------------------------------------------------------
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<RubricaFuncionario> rubricas = new ArrayList<RubricaFuncionario>();
	
	@Where(clause="pago = 0")
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<LancamentoAvulso> lancamentosAvulsos = new ArrayList<LancamentoAvulso>();
	
	@Where(clause="pago = 0")
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<LancamentoAgendado> lancamentosAgendados = new ArrayList<LancamentoAgendado>();	

	@Where(clause="ativo = 1")
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<LancamentoRecorrente> lancamentosRecorrentes = new ArrayList<LancamentoRecorrente>();	

	public Funcionario() {
		super();
	}

	public Funcionario(Long id) {
		super();
		this.id = id;
	}
	
	public Funcionario(Long id, Integer matricula, TipoFuncionario tipoFuncionario, Pessoa pessoa) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.tipoFuncionario = tipoFuncionario;
		this.pessoa = pessoa;
	}

	public Funcionario(Integer matricula, TipoFuncionario tipoFuncionario, Pessoa pessoa) {
		super();
		this.matricula = matricula;
		this.tipoFuncionario = tipoFuncionario;
		this.pessoa = pessoa;
	}

	public Funcionario(Long id, Integer matricula, TipoFuncionario tipoFuncionario, Pessoa pessoa,
			List<FuncionarioCargo> cargos, List<FuncionarioArea> areas, List<RubricaFuncionario> rubricas,
			List<LancamentoAvulso> lancamentosAvulsos, List<LancamentoAgendado> lancamentosAgendados,
			List<LancamentoRecorrente> lancamentosRecorrentes) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.tipoFuncionario = tipoFuncionario;
		this.pessoa = pessoa;
		this.cargos = cargos;
		this.areas = areas;
		this.rubricas = rubricas;
		this.lancamentosAvulsos = lancamentosAvulsos;
		this.lancamentosAgendados = lancamentosAgendados;
		this.lancamentosRecorrentes = lancamentosRecorrentes;
	}

	public Funcionario(Integer matricula, TipoFuncionario tipoFuncionario, Pessoa pessoa, List<FuncionarioCargo> cargos,
			List<FuncionarioArea> areas, List<RubricaFuncionario> rubricas, List<LancamentoAvulso> lancamentosAvulsos,
			List<LancamentoAgendado> lancamentosAgendados, List<LancamentoRecorrente> lancamentosRecorrentes) {
		super();
		this.matricula = matricula;
		this.tipoFuncionario = tipoFuncionario;
		this.pessoa = pessoa;
		this.cargos = cargos;
		this.areas = areas;
		this.rubricas = rubricas;
		this.lancamentosAvulsos = lancamentosAvulsos;
		this.lancamentosAgendados = lancamentosAgendados;
		this.lancamentosRecorrentes = lancamentosRecorrentes;
	}

	public Funcionario(FuncionarioTO funcionarioTO) {
		super();
		this.id = funcionarioTO.getId();
		this.matricula = funcionarioTO.getMatricula();
		this.tipoFuncionario = funcionarioTO.getTipoFuncionario();
		this.pessoa = new Pessoa(funcionarioTO.getPessoa());
	}
	
	public FuncionarioTO toTO() {
		return new FuncionarioTO(id,matricula,tipoFuncionario,pessoa.toTO());
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

	public List<FuncionarioCargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<FuncionarioCargo> cargos) {
		this.cargos = cargos;
	}

	public List<FuncionarioArea> getAreas() {
		return areas;
	}

	public void setAreas(List<FuncionarioArea> areas) {
		this.areas = areas;
	}

	@Transient
	public List<FuncionarioCargo> getCargosAtivos(final Date inicio, final Date fim) {
		/* usando guava */

		if (cargos != null) {
			Collection<FuncionarioCargo> c = Collections2.filter(cargos, new Predicate<FuncionarioCargo>() {
				@Override
				public boolean apply(FuncionarioCargo fc) {
					return (fc.getDataInicio().before(fim)&&(fc.getDataFim()==null||(fc.getDataFim().after(inicio)&&fc.getDataFim().before(fim))));
				}
			});
			
			return new ArrayList<>(c);
		}

		// usando lambda
		/*
		if (cargos != null) {
			return cargos.stream()
					.filter(fc -> fc.getDataInicio().before(fim)&&(fc.getDataFim()==null||(fc.getDataFim().after(inicio)&&fc.getDataFim().before(fim))))
					.collect(Collectors.toList());
		}
		*/

		return new ArrayList<>();
	}
	
	@Transient
	public List<FuncionarioCargo> getCargosAtivos(final Date data) {
		/* usando guava */

		if (cargos != null) {
			Collection<FuncionarioCargo> c = Collections2.filter(cargos, new Predicate<FuncionarioCargo>() {
				@Override
				public boolean apply(FuncionarioCargo fc) {
					return (fc.getDataInicio().before(data)&&(fc.getDataFim()==null||fc.getDataFim().after(data)));
				}
			});
			
			return new ArrayList<>(c);
		}

		// usando lambda
		/*
		if (cargos != null) {
			return cargos.stream()
					.filter(fc -> fc.getDataInicio().before(data)&&(fc.getDataFim()==null||fc.getDataFim().after(data)))
					.collect(Collectors.toList());
		}
		*/

		
		return new ArrayList<>();
	}
	
	@Transient
	public List<FuncionarioCargo> getCargosAtivosPorTiposProvimento(final Date data, final List<TipoProvimento> tiposProvimento) {
		/* usando guava */

		if (cargos != null) {
			Collection<FuncionarioCargo> c = Collections2.filter(cargos, new Predicate<FuncionarioCargo>() {
				@Override
				public boolean apply(FuncionarioCargo fc) {
					return (tiposProvimento.contains(fc.getTipoProvimento())&&fc.getDataInicio().before(data)&&(fc.getDataFim()==null||fc.getDataFim().after(data)));
				}
			});
			
			return new ArrayList<>(c);
		}
		
		return new ArrayList<>();
	}
	
	@Transient
	public List<FuncionarioCargo> getCargosAtivosPorExclusaoTiposProvimento(final Date data, final List<TipoProvimento> tiposProvimento) {

		if (cargos != null) {
			Collection<FuncionarioCargo> c = Collections2.filter(cargos, new Predicate<FuncionarioCargo>() {
				@Override
				public boolean apply(FuncionarioCargo fc) {
					return ((!tiposProvimento.contains(fc.getTipoProvimento()))&&fc.getDataInicio().before(data)&&(fc.getDataFim()==null||fc.getDataFim().after(data)));
				}
			});
			
			return new ArrayList<>(c);
		}
		
		return new ArrayList<>();
	}
	
	

	public List<RubricaFuncionario> getRubricas() {
		return rubricas;
	}

	public void setRubricas(List<RubricaFuncionario> rubricas) {
		this.rubricas = rubricas;
	}

	public List<LancamentoAvulso> getLancamentosAvulsos() {
		return lancamentosAvulsos;
	}

	public void setLancamentosAvulsos(List<LancamentoAvulso> lancamentosAvulsos) {
		this.lancamentosAvulsos = lancamentosAvulsos;
	}

	@Transient
	public List<LancamentoAvulso> getLancamentosAvulsosEmAberto() {
		/* usando guava */

		if (lancamentosAvulsos != null) {
			Collection<LancamentoAvulso> c = Collections2.filter(lancamentosAvulsos, new Predicate<LancamentoAvulso>() {
				@Override
				public boolean apply(LancamentoAvulso p) {
					return (!p.getPago());
				}
			});
		
			if (c != null && !c.isEmpty()) {
				return new ArrayList<>(c); 
			}

		}

		return null;
	}
	
	@Transient
	public List<LancamentoAgendado> getLancamentosAgendadosParaOPeriodo(final Date periodoInicio, final Date periodoFim) {
		/* usando guava */

		if (lancamentosAgendados != null) {
			Collection<LancamentoAgendado> c = Collections2.filter(lancamentosAgendados, new Predicate<LancamentoAgendado>() {
				@Override
				public boolean apply(LancamentoAgendado l) {
					return (!l.getPago()&&l.getAgendadoPara().after(periodoInicio)&&l.getAgendadoPara().before(periodoFim));
				}
			});
		
			if (c != null && !c.isEmpty()) {
				return new ArrayList<>(c); 
			}

		}

		return null;
	}
	
	@Transient
	public List<LancamentoRecorrente> getLancamentosRecorrentesValidosParaOPeriodo(final Date periodoInicio, final Date periodoFim) {
		if (lancamentosRecorrentes != null) {
			Collection<LancamentoRecorrente> c = Collections2.filter(lancamentosRecorrentes, new Predicate<LancamentoRecorrente>() {
				@Override
				public boolean apply(LancamentoRecorrente l) {
					return (l.getAtivo()&&l.getDataInicio().before(periodoFim)&&l.getRecorrencia().equals(TipoRecorrencia.MENSAL));
				}
			});
		
			if (c != null && !c.isEmpty()) {
				return new ArrayList<>(c); 
			}

		}

		return null;
	}

	public List<LancamentoAgendado> getLancamentosAgendados() {
		return lancamentosAgendados;
	}

	public void setLancamentosAgendados(List<LancamentoAgendado> lancamentosAgendados) {
		this.lancamentosAgendados = lancamentosAgendados;
	}

	public List<LancamentoRecorrente> getLancamentosRecorrentes() {
		return lancamentosRecorrentes;
	}

	public void setLancamentosRecorrentes(List<LancamentoRecorrente> lancamentosRecorrentes) {
		this.lancamentosRecorrentes = lancamentosRecorrentes;
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
		Funcionario other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}


	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", matricula=" + matricula + ", tipoFuncionario=" + tipoFuncionario
				+ ", pessoa=" + pessoa + "]";
	}

	public void alterar(FuncionarioTO funcionarioTO) {
		this.matricula = funcionarioTO.getMatricula();
		this.tipoFuncionario = funcionarioTO.getTipoFuncionario();
		this.pessoa = new Pessoa(funcionarioTO.getPessoa());
	}


}