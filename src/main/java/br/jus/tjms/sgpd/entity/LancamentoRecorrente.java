package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.enumerators.TipoRecorrencia;
import br.jus.tjms.sgpd.service.rest.v1.to.LancamentoRecorrenteTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "lancamentoRecorrente.buscarPorFuncionario", 
			query = "SELECT l FROM LancamentoRecorrente l WHERE l.funcionario.id = :funcionarioId")
})
public class LancamentoRecorrente implements Serializable {

	private static final long serialVersionUID = 7608004643119271552L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "rubrica_id", nullable = true)
	private Rubrica rubrica;

	@Enumerated(EnumType.ORDINAL)
	private Sinal sinal;

	private Double quantidade;
	private Double percentual;
	private Double valor;
	private Date dataInicio;

	@Enumerated(EnumType.ORDINAL)
	private TipoRecorrencia recorrencia;

	private Boolean ativo;

	public LancamentoRecorrente() {
		super();
	}

	public LancamentoRecorrente(Long id, Funcionario funcionario, Rubrica rubrica, Sinal sinal, Double quantidade,
			Double percentual, Double valor, Date dataInicio, TipoRecorrencia recorrencia, Boolean ativo) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.rubrica = rubrica;
		this.sinal = sinal;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.recorrencia = recorrencia;
		this.ativo = ativo;
	}

	public LancamentoRecorrente(LancamentoRecorrenteTO lancamentoRecorrenteTO) {
		this.id = lancamentoRecorrenteTO.getId();

		this.funcionario = new Funcionario(lancamentoRecorrenteTO.getFuncionarioId());
		
		if (lancamentoRecorrenteTO.getRubricaId()!=null) {
			this.rubrica = new Rubrica(lancamentoRecorrenteTO.getRubricaId());
		}
		
		this.sinal = lancamentoRecorrenteTO.getSinal();
		this.quantidade = lancamentoRecorrenteTO.getQuantidade();
		this.percentual = lancamentoRecorrenteTO.getPercentual();
		this.valor = lancamentoRecorrenteTO.getValor();
		this.dataInicio = lancamentoRecorrenteTO.getDataInicio();
		this.recorrencia = lancamentoRecorrenteTO.getRecorrencia();
		this.ativo = lancamentoRecorrenteTO.getAtivo();
	}

	public Long getId() {
		return id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public Sinal getSinal() {
		return sinal;
	}

	public void setSinal(Sinal sinal) {
		this.sinal = sinal;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public TipoRecorrencia getRecorrencia() {
		return recorrencia;
	}

	public void setRecorrencia(TipoRecorrencia recorrencia) {
		this.recorrencia = recorrencia;
	}

	public Boolean getAtivo() {
		return ativo;
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
		LancamentoRecorrente other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "LancamentoRecorrente [id=" + id + ", funcionario=" + funcionario + ", rubrica=" + rubrica + ", sinal="
				+ sinal + ", quantidade=" + quantidade + ", percentual=" + percentual + ", valor=" + valor
				+ ", dataInicio=" + dataInicio + ", recorrencia=" + recorrencia + ", ativo=" + ativo + "]";
	}
	
	public LancamentoRecorrenteTO toTO() {
		return new LancamentoRecorrenteTO(id, funcionario.getId(), rubrica!=null?rubrica.getId():null, sinal, quantidade,
				percentual, valor, dataInicio, recorrencia, ativo);
	}

	public void alterar(LancamentoRecorrenteTO lancamentoRecorrenteTO) {
		this.funcionario = new Funcionario(lancamentoRecorrenteTO.getFuncionarioId());
		
		if (lancamentoRecorrenteTO.getRubricaId()!=null) {
			this.rubrica = new Rubrica(lancamentoRecorrenteTO.getRubricaId());
		} else {
			this.rubrica = null;
		}
		
		this.sinal = lancamentoRecorrenteTO.getSinal();
		this.quantidade = lancamentoRecorrenteTO.getQuantidade();
		this.percentual = lancamentoRecorrenteTO.getPercentual();
		this.valor = lancamentoRecorrenteTO.getValor();
		this.dataInicio = lancamentoRecorrenteTO.getDataInicio();
		this.recorrencia = lancamentoRecorrenteTO.getRecorrencia();
		this.ativo = lancamentoRecorrenteTO.getAtivo();
	}

	public void ativar() {
		this.ativo = Boolean.TRUE;
	}

	public void desativar() {
		this.ativo = Boolean.FALSE;
	}
}