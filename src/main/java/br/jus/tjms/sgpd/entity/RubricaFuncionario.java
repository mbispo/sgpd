package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.engine.annotations.FolowList;
import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaFuncionarioBaseTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaFuncionarioTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "rubricaFuncionario.buscarRubricasPorFuncionario", 
			query = "SELECT r FROM RubricaFuncionario r WHERE r.funcionario.id = :funcionarioId"),
})
public class RubricaFuncionario implements Serializable {

	private static final long serialVersionUID = -73108104442420344L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = true)
	private Pessoa contraParte;	

	@FolowField
	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = false)
	private Rubrica rubrica;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoFolhaPagamento tipoFolhaPagamento;	

	private Double quantidade;
	private Double percentual;
	private Double valor;
	
	@FolowList
	@OneToMany(mappedBy = "rubricaFuncionario")
	private List<RubricaFuncionarioBase> rubricasBase = new ArrayList<>();

	public RubricaFuncionario() {
		super();
	}

	public RubricaFuncionario(Long id, Funcionario funcionario, FuncionarioCargo funcionarioCargo, Pessoa contraParte, Rubrica rubrica,
			TipoFolhaPagamento tipoFolhaPagamento, Double quantidade, Double percentual, Double valor, List<RubricaFuncionarioBase> rubricasBase) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.funcionarioCargo = funcionarioCargo;
		this.contraParte = contraParte;
		this.rubrica = rubrica;
		this.tipoFolhaPagamento = tipoFolhaPagamento;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.valor = valor;
		this.rubricasBase = rubricasBase;
	}
	
	public RubricaFuncionario(Funcionario funcionario, FuncionarioCargo funcionarioCargo, Pessoa contraParte, Rubrica rubrica,
			TipoFolhaPagamento tipoFolhaPagamento, Double quantidade, Double percentual, Double valor, List<RubricaFuncionarioBase> rubricasBase) {
		super();
		this.funcionario = funcionario;
		this.funcionarioCargo = funcionarioCargo;
		this.contraParte = contraParte;
		this.rubrica = rubrica;
		this.tipoFolhaPagamento = tipoFolhaPagamento;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.valor = valor;
		this.rubricasBase = rubricasBase;
	}

	public RubricaFuncionario(RubricaFuncionarioTO rubricaFuncionarioTO) {
		this.id = rubricaFuncionarioTO.getId();
		this.funcionario = rubricaFuncionarioTO.getFuncionarioId()!=null?new Funcionario(rubricaFuncionarioTO.getFuncionarioId()):null;
		this.funcionarioCargo = rubricaFuncionarioTO.getFuncionarioCargoId()!=null?new FuncionarioCargo(rubricaFuncionarioTO.getFuncionarioCargoId()):null;
		this.contraParte = rubricaFuncionarioTO.getContraParteId()!=null?new Pessoa(rubricaFuncionarioTO.getContraParteId()):null;
		this.rubrica = rubricaFuncionarioTO.getRubricaId()!=null?new Rubrica(rubricaFuncionarioTO.getRubricaId()):null;
		this.tipoFolhaPagamento = rubricaFuncionarioTO.getTipoFolhaPagamento();
		this.quantidade = rubricaFuncionarioTO.getQuantidade();
		this.percentual = rubricaFuncionarioTO.getPercentual();
		this.valor = rubricaFuncionarioTO.getValor();

		if (rubricaFuncionarioTO.getRubricasBase()!=null) {
			for (RubricaFuncionarioBaseTO to : rubricaFuncionarioTO.getRubricasBase()) {
				this.rubricasBase.add(new RubricaFuncionarioBase(to,this));
			}
		} 
	}
	
	public RubricaFuncionario(Long id) {
		super();
		this.id = id;
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

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public Pessoa getContraParte() {
		return contraParte;
	}

	public void setContraParte(Pessoa contraParte) {
		this.contraParte = contraParte;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public TipoFolhaPagamento getTipoFolhaPagamento() {
		return tipoFolhaPagamento;
	}

	public void setTipoFolhaPagamento(TipoFolhaPagamento tipoFolhaPagamento) {
		this.tipoFolhaPagamento = tipoFolhaPagamento;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<RubricaFuncionarioBase> getRubricasBase() {
		return rubricasBase;
	}

	public void setRubricasBase(List<RubricaFuncionarioBase> rubricasBase) {
		this.rubricasBase = rubricasBase;
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
		RubricaFuncionario other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	@Override
	public String toString() {
		return "RubricaFuncionario [id=" + id + ", funcionario=" + funcionario + ", funcionarioCargo="
				+ funcionarioCargo + ", contraParte=" + contraParte + ", rubrica=" + rubrica + ", tipoFolhaPagamento="
				+ tipoFolhaPagamento + ", quantidade=" + quantidade + ", percentual=" + percentual + ", valor=" + valor
				+ "]";
	}

	public void alterar(RubricaFuncionarioTO rubricaFuncionarioTO) {
		this.funcionario = rubricaFuncionarioTO.getFuncionarioId()!=null?new Funcionario(rubricaFuncionarioTO.getFuncionarioId()):null;
		this.funcionarioCargo = rubricaFuncionarioTO.getFuncionarioCargoId()!=null?new FuncionarioCargo(rubricaFuncionarioTO.getFuncionarioCargoId()):null;
		this.contraParte = rubricaFuncionarioTO.getContraParteId()!=null?new Pessoa(rubricaFuncionarioTO.getContraParteId()):null;
		this.rubrica = rubricaFuncionarioTO.getRubricaId()!=null?new Rubrica(rubricaFuncionarioTO.getRubricaId()):null;
		this.tipoFolhaPagamento = rubricaFuncionarioTO.getTipoFolhaPagamento();
		this.quantidade = rubricaFuncionarioTO.getQuantidade();
		this.percentual = rubricaFuncionarioTO.getPercentual();
		this.valor = rubricaFuncionarioTO.getValor();

		if (rubricaFuncionarioTO.getRubricasBase()!=null) {
			for (RubricaFuncionarioBaseTO to : rubricaFuncionarioTO.getRubricasBase()) {
				this.rubricasBase.add(new RubricaFuncionarioBase(to,this));
			}
		}
	}
	
}