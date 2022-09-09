package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoPagamentoItem;
import br.jus.tjms.sgpd.service.rest.v1.to.PagamentoItemTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PagamentoTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "pagamento.buscarPorFolhaEFuncionario", 
			query = "SELECT p FROM Pagamento p WHERE p.funcionario.id = :funcionarioId and p.folhaPagamento.id = :folhaPagamentoId"),
	@NamedQuery(name = "pagamento.buscarPorFuncionario", 
			query = "SELECT p FROM Pagamento p WHERE p.funcionario.id = :funcionarioId")
})
public class Pagamento implements Serializable {

	private static final long serialVersionUID = -8897034734734780722L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "folhaPagamento_id", nullable = false)
	private FolhaPagamento folhaPagamento;
	
	private Date dataPagamento;

	@ManyToOne
	@JoinColumn(name = "contaRecebimento_id", nullable = true)
	private ContaRecebimento contaRecebimento;

	@Column(length = 500)
	private String mensagem;

	@ManyToOne
	@JoinColumn(name = "dadosConsolidados_id", nullable = true)
	private DadosConsolidadosDoFuncionario dadosConsolidadosDoFuncionario;

	@OneToMany(mappedBy = "pagamento", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<PagamentoItem> itens = new ArrayList<PagamentoItem>();

	private Double ganhos;
	private Double descontos;
	private Double liquido;

	public Pagamento() {
		super();
	}

	public Pagamento(Funcionario funcionario, FolhaPagamento folhaPagamento, Date dataPagamento, ContaRecebimento contaRecebimento,
			String mensagem, DadosConsolidadosDoFuncionario dadosConsolidadosDoFuncionario, List<PagamentoItem> itens,
			Double ganhos, Double descontos, Double liquido) {
		super();
		this.funcionario = funcionario;
		this.folhaPagamento = folhaPagamento;
		this.dataPagamento = dataPagamento;
		this.contaRecebimento = contaRecebimento;
		this.mensagem = mensagem;
		this.dadosConsolidadosDoFuncionario = dadosConsolidadosDoFuncionario;
		this.itens = itens;
		this.ganhos = ganhos;
		this.descontos = descontos;
		this.liquido = liquido;
	}
	
	public Pagamento(Funcionario funcionario, FolhaPagamento folhaPagamento) {
		super();
		this.funcionario = funcionario;
		this.folhaPagamento = folhaPagamento;
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

	public FolhaPagamento getFolhaPagamento() {
		return folhaPagamento;
	}

	public void setFolhaPagamento(FolhaPagamento folhaPagamento) {
		this.folhaPagamento = folhaPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public ContaRecebimento getContaRecebimento() {
		return contaRecebimento;
	}

	public void setContaRecebimento(ContaRecebimento contaRecebimento) {
		this.contaRecebimento = contaRecebimento;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public DadosConsolidadosDoFuncionario getDadosConsolidadosDoFuncionario() {
		return dadosConsolidadosDoFuncionario;
	}

	public void setDadosConsolidadosDoFuncionario(DadosConsolidadosDoFuncionario dadosConsolidadosDoFuncionario) {
		this.dadosConsolidadosDoFuncionario = dadosConsolidadosDoFuncionario;
	}

	public List<PagamentoItem> getItens() {
		return itens;
	}

	public void setItens(List<PagamentoItem> itens) {
		this.itens = itens;
	}

	public Double getGanhos() {
		return ganhos;
	}

	public void setGanhos(Double ganhos) {
		this.ganhos = ganhos;
	}

	public Double getDescontos() {
		return descontos;
	}

	public void setDescontos(Double descontos) {
		this.descontos = descontos;
	}

	public Double getLiquido() {
		return liquido;
	}

	public void setLiquido(Double liquido) {
		this.liquido = liquido;
	}
	
	@Transient
	public Double getBaseCalculoIrrf() {
		return getTotalPorTipoItem(TipoPagamentoItem.BASE_CALCULO_IRRF);
	}
	
	@Transient
	public Double getIrrf() {
		return getTotalPorTipoItem(TipoPagamentoItem.IRRF);
	}
	
	
	@Transient
	public Double getTotalPorTipoItem(TipoPagamentoItem tipo) {
		Double total = 0.0;
		
		for (PagamentoItem pagamentoItem : itens) {
			if (pagamentoItem.getTipo().equals(tipo)) {
				total = total + pagamentoItem.getValor();
			}
		}
		
		return total;
	}
	
	@Transient
	public Pagamento totalizar() {
		
		Double debitar = 0.0;
		Double creditar = 0.0;
		
		for (PagamentoItem pagamentoItem : itens) {
			if (pagamentoItem.getTipo().equals(TipoPagamentoItem.CREDITO)) {
				creditar = creditar + pagamentoItem.getValor();
			}
			if (pagamentoItem.getTipo().equals(TipoPagamentoItem.DEBITO)) {
				debitar = debitar + pagamentoItem.getValor();
			}
		}
		
		setGanhos(creditar);
		setDescontos(debitar);
		setLiquido(creditar - debitar);

		return this;
		
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
		Pagamento other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", funcionario=" + funcionario + ", folhaPagamento=" + folhaPagamento
				+ ", dataPagamento=" + dataPagamento + ", contaRecebimento=" + contaRecebimento + ", mensagem="
				+ mensagem + ", ganhos=" + ganhos + ", descontos=" + descontos + ", liquido="
				+ liquido + "]";
	}
	
	public PagamentoTO toTO() {
		List<PagamentoItemTO> itensTO = new ArrayList<>();
		
		for (PagamentoItem pagamentoItem : itens) {
			itensTO.add(pagamentoItem.toTO());
		}
		
		PagamentoTO to = new PagamentoTO(id, funcionario.getId(), folhaPagamento.getId(), dataPagamento, 
				contaRecebimento!=null?contaRecebimento.getId():null, mensagem, 
				dadosConsolidadosDoFuncionario!=null?dadosConsolidadosDoFuncionario.getId():null, itensTO, ganhos,
				descontos, liquido, getBaseCalculoIrrf(), getIrrf());
		return to;
	}

}