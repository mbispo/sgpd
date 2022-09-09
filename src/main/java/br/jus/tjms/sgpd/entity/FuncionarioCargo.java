package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.enumerators.FormaProvimento;
import br.jus.tjms.sgpd.enumerators.TipoProvimento;
import br.jus.tjms.sgpd.service.rest.v1.to.FuncionarioCargoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.ProgressaoFuncionalTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
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
	@NamedQuery(name = "funcionarioCargo.buscarFuncionarioCargosPorFuncionario", 
			query = "SELECT f from FuncionarioCargo f WHERE f.funcionario.id = :funcionarioId order by f.dataInicio"),
	@NamedQuery(name = "funcionarioCargo.buscarCargosPorFuncionario", 
			query = "SELECT c from FuncionarioCargo f JOIN f.cargo c WHERE f.funcionario.id = :funcionarioId"),
	@NamedQuery(name = "funcionarioCargo.buscarProgressoesPorFuncionario", 
	query = "SELECT p from FuncionarioCargo f JOIN f.progressoes p WHERE f.funcionario.id = :funcionarioId"),
	@NamedQuery(name = "funcionarioCargo.buscarDataInicioPrimeiroCargo", 
	query = "SELECT min(f.dataInicio) from FuncionarioCargo f WHERE f.funcionario.id = :funcionarioId")
})
public class FuncionarioCargo implements Serializable {

	private static final long serialVersionUID = -7003600289706044992L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@FolowField
	@ManyToOne
	@JoinColumn(name="cargo_id", nullable = false)
	private Cargo cargo;
	
	@FolowField
	@ManyToOne
	@JoinColumn(name="atoProvimento_id", nullable = true)
	private AtoProvimento atoProvimento;
	
	@FolowField
	@ManyToOne
	@JoinColumn(name = "especialidade_id", nullable = true)
	private Especialidade especialidade;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "ocupacao_id", nullable = true)
	private Ocupacao ocupacao;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoProvimento tipoProvimento;
	
	@Enumerated(EnumType.ORDINAL)
	private FormaProvimento formaProvimento;
	
	@ManyToOne
	@JoinColumn(name="regimePrevidencia_id", nullable = true)
	private RegimePrevidencia regimePrevidencia;
	
	@ManyToOne
	@JoinColumn(name="regimeJuridico_id", nullable = true)
	private RegimeJuridico regimeJuridico;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	@ManyToOne
	@JoinColumn(name="funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	
	@OrderBy("dataProgressao, id")
	@OneToMany(mappedBy = "funcionarioCargo", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	@JsonIgnore
	private List<ProgressaoFuncional> progressoes = new ArrayList<ProgressaoFuncional>();

	public FuncionarioCargo() {
	}
	
	public FuncionarioCargo(Long id) {
		super();
		this.id = id;
	}

	public FuncionarioCargo(Long id, Funcionario funcionario, Cargo cargo, AtoProvimento atoProvimento,
			Especialidade especialidade, Ocupacao ocupacao,
			TipoProvimento tipoProvimento, FormaProvimento formaProvimento, RegimePrevidencia regimePrevidencia,
			RegimeJuridico regimeJuridico, Date dataInicio, Date dataFim, List<ProgressaoFuncional> progressoes) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.cargo = cargo;
		this.atoProvimento = atoProvimento;
		this.especialidade = especialidade;
		this.ocupacao = ocupacao;
		this.tipoProvimento = tipoProvimento;
		this.formaProvimento = formaProvimento;
		this.regimePrevidencia = regimePrevidencia;
		this.regimeJuridico = regimeJuridico;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.progressoes = progressoes;
	}

	public FuncionarioCargo(FuncionarioCargoTO funcionarioCargoTO) {
		this.id = funcionarioCargoTO.getId();
		
		this.funcionario = new Funcionario(funcionarioCargoTO.getFuncionarioId());
		this.cargo = new Cargo(funcionarioCargoTO.getCargoId());
		
		this.atoProvimento = funcionarioCargoTO.getAtoProvimentoId()!=null?new AtoProvimento(funcionarioCargoTO.getAtoProvimentoId()):null;
		this.especialidade = funcionarioCargoTO.getEspecialidadeId()!=null?new Especialidade(funcionarioCargoTO.getEspecialidadeId()):null;
		this.ocupacao = funcionarioCargoTO.getOcupacaoId()!=null?new Ocupacao(funcionarioCargoTO.getOcupacaoId()):null;
		
		this.tipoProvimento = funcionarioCargoTO.getTipoProvimento();
		this.formaProvimento = funcionarioCargoTO.getFormaProvimento();
		
		this.regimePrevidencia = funcionarioCargoTO.getRegimePrevidenciaId()!=null?new RegimePrevidencia(funcionarioCargoTO.getRegimePrevidenciaId()):null;
		this.regimeJuridico = funcionarioCargoTO.getRegimeJuridicoId()!=null?new RegimeJuridico(funcionarioCargoTO.getRegimeJuridicoId()):null;
		
		this.dataInicio = funcionarioCargoTO.getDataInicio();
		this.dataFim = funcionarioCargoTO.getDataFim();
		
		if (funcionarioCargoTO.getProgressoes()!=null) {
			for (ProgressaoFuncionalTO p : funcionarioCargoTO.getProgressoes()) {				
				this.progressoes.add(new ProgressaoFuncional(p));				
			}
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public AtoProvimento getAtoProvimento() {
		return atoProvimento;
	}

	public void setAtoProvimento(AtoProvimento atoProvimento) {
		this.atoProvimento = atoProvimento;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Ocupacao getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
	}

	public TipoProvimento getTipoProvimento() {
		return tipoProvimento;
	}

	public void setTipoProvimento(TipoProvimento tipoProvimento) {
		this.tipoProvimento = tipoProvimento;
	}

	public FormaProvimento getFormaProvimento() {
		return formaProvimento;
	}

	public void setFormaProvimento(FormaProvimento formaProvimento) {
		this.formaProvimento = formaProvimento;
	}

	public RegimePrevidencia getRegimePrevidencia() {
		return regimePrevidencia;
	}

	public void setRegimePrevidencia(RegimePrevidencia regimePrevidencia) {
		this.regimePrevidencia = regimePrevidencia;
	}

	public RegimeJuridico getRegimeJuridico() {
		return regimeJuridico;
	}

	public void setRegimeJuridico(RegimeJuridico regimeJuridico) {
		this.regimeJuridico = regimeJuridico;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public void setDataInicio(Timestamp dataInicio) {
		this.dataInicio = new Date(dataInicio.getTime());
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public List<ProgressaoFuncional> getProgressoes() {
		return progressoes;
	}

	public void setProgressoes(List<ProgressaoFuncional> progressoes) {
		this.progressoes = progressoes;
	}
	
	@Transient
	public ProgressaoFuncional getProgressaoNaData(final Date data) {

		/* usando guava */

		if (progressoes != null) {
			Collection<ProgressaoFuncional> c = Collections2.filter(progressoes, new Predicate<ProgressaoFuncional>() {
				@Override
				public boolean apply(ProgressaoFuncional p) {
					return (p.getDataProgressao().before(data));
				}
			});
			
			List<ProgressaoFuncional> l = new ArrayList<>(c);
			
			if (l.size()>0) {
				return l.get(l.size()-1);	
			}
		}

		return null;
	}

	@Transient
	public ProgressaoFuncional getProgressaoAtual() {
		if ((progressoes != null) && (progressoes.size()>0)) {
			return progressoes.get(progressoes.size()-1);
		}

		return null;
	}
	
	@Transient
	public ProgressaoFuncional getProgressaoInicial() {
		if ((progressoes != null) && (progressoes.size()>0)) {
			return progressoes.get(0);
		}

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
		FuncionarioCargo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	public FuncionarioCargoTO toTO() {
		return new FuncionarioCargoTO(id, funcionario.getId(), cargo.getId(), atoProvimento!=null?atoProvimento.getId():null,
				especialidade!=null?especialidade.getId():null, ocupacao!=null?ocupacao.getId():null,
				tipoProvimento, formaProvimento, regimePrevidencia!=null?regimePrevidencia.getId():null,
				regimeJuridico!=null?regimeJuridico.getId():null, dataInicio, dataFim, null);
	}

	
	@Override
	public String toString() {
		return "FuncionarioCargo [id=" + id + ", funcionario=" + funcionario + ", cargo=" + cargo + ", atoProvimento="
				+ atoProvimento + ", especialidade=" + especialidade + ", ocupacao=" + ocupacao + ", tipoProvimento="
				+ tipoProvimento + ", formaProvimento=" + formaProvimento + ", regimePrevidencia=" + regimePrevidencia
				+ ", regimeJuridico=" + regimeJuridico + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim
				+ ", progressoes=" + progressoes + "]";
	}

	public void alterar(FuncionarioCargoTO funcionarioCargoTO) {

		this.funcionario = new Funcionario(funcionarioCargoTO.getFuncionarioId());
		this.cargo = new Cargo(funcionarioCargoTO.getCargoId());
		
		this.atoProvimento = funcionarioCargoTO.getAtoProvimentoId()!=null?new AtoProvimento(funcionarioCargoTO.getAtoProvimentoId()):null;
		this.especialidade = funcionarioCargoTO.getEspecialidadeId()!=null?new Especialidade(funcionarioCargoTO.getEspecialidadeId()):null;
		this.ocupacao = funcionarioCargoTO.getOcupacaoId()!=null?new Ocupacao(funcionarioCargoTO.getOcupacaoId()):null;
		
		this.tipoProvimento = funcionarioCargoTO.getTipoProvimento();
		this.formaProvimento = funcionarioCargoTO.getFormaProvimento();
		
		this.regimePrevidencia = funcionarioCargoTO.getRegimePrevidenciaId()!=null?new RegimePrevidencia(funcionarioCargoTO.getRegimePrevidenciaId()):null;
		this.regimeJuridico = funcionarioCargoTO.getRegimeJuridicoId()!=null?new RegimeJuridico(funcionarioCargoTO.getRegimeJuridicoId()):null;
		
		this.dataInicio = funcionarioCargoTO.getDataInicio();		
		this.dataFim = funcionarioCargoTO.getDataFim();
		
		if (funcionarioCargoTO.getProgressoes()!=null) {
			this.progressoes.clear();
			for (ProgressaoFuncionalTO p : funcionarioCargoTO.getProgressoes()) {				
				this.progressoes.add(new ProgressaoFuncional(p));				
			}
		}
	}
	
}