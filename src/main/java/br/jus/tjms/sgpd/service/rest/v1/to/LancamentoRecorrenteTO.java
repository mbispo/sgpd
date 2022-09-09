package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.enumerators.TipoRecorrencia;

public class LancamentoRecorrenteTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long funcionarioId;
	private Long rubricaId;
	private Sinal sinal;
	private Double quantidade;
	private Double percentual;
	private Double valor;
	private Date dataInicio;
	private TipoRecorrencia recorrencia;
	private Boolean ativo;

	public LancamentoRecorrenteTO() {
		super();

	}

	public LancamentoRecorrenteTO(Long id, Long funcionarioId, Long rubricaId, Sinal sinal, Double quantidade,
			Double percentual, Double valor, Date dataInicio, TipoRecorrencia recorrencia, Boolean ativo) {
		super();
		this.id = id;
		this.funcionarioId = funcionarioId;
		this.rubricaId = rubricaId;
		this.sinal = sinal;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.recorrencia = recorrencia;
		this.ativo = ativo;
	}

	public LancamentoRecorrenteTO(Long funcionarioId, Long rubricaId, Sinal sinal, Double quantidade, Double percentual,
			Double valor, Date dataInicio, TipoRecorrencia recorrencia, Boolean ativo) {
		super();
		this.funcionarioId = funcionarioId;
		this.rubricaId = rubricaId;
		this.sinal = sinal;
		this.quantidade = quantidade;
		this.percentual = percentual;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.recorrencia = recorrencia;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Long getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Long rubricaId) {
		this.rubricaId = rubricaId;
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

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "LancamentoRecorrenteTO [id=" + id + ", funcionarioId=" + funcionarioId + ", rubricaId=" + rubricaId
				+ ", sinal=" + sinal + ", quantidade=" + quantidade + ", percentual=" + percentual + ", valor=" + valor
				+ ", dataInicio=" + dataInicio + ", recorrencia=" + recorrencia + ", ativo=" + ativo + "]";
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
		LancamentoRecorrenteTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}