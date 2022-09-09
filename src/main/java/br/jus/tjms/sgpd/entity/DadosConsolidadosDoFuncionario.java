package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.DadosConsolidadosDoFuncionarioTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "dadosConsolidadosDoFuncionario.buscarPorFuncionarioIdAteADataLimite", 
			query = "SELECT d FROM DadosConsolidadosDoFuncionario d WHERE d.funcionario.id = :funcionarioId and d.dataConsolidacao <= :dataLimite order by d.id desc") 
})
public class DadosConsolidadosDoFuncionario implements Serializable {

	private static final long serialVersionUID = -8172678020401185010L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Date dataConsolidacao;

	@ManyToOne
	@JoinColumn(name = "contaRecebimento_id", nullable = true)
	private ContaRecebimento contaRecebimento;

	@ManyToOne
	@JoinColumn(name = "funcionarioArea_id", nullable = true)
	private FuncionarioArea funcionarioArea;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargoPrincipal_id", nullable = true)
	private FuncionarioCargo funcionarioCargoPrincipal;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargoAcumulado1_id", nullable = true)
	private FuncionarioCargo funcionarioCargoAcumulado1;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargoAcumulado2_id", nullable = true)
	private FuncionarioCargo funcionarioCargoAcumulado2;

	@Column(length = 250)
	private String lotacao;

	@Column(length = 250)
	private String cargoPrincipal;

	@Column(length = 250)
	private String cargoAcumulado1;
	
	@Column(length = 250)
	private String cargoAcumulado2;
	
	@Column(length = 250)
	private String observacoes;

	public DadosConsolidadosDoFuncionario() {
		super();
	}

	public DadosConsolidadosDoFuncionario(Long id) {
		super();
		this.id = id;
	}

	public DadosConsolidadosDoFuncionario(Long id, Funcionario funcionario, Date dataConsolidacao,
			ContaRecebimento contaRecebimento, FuncionarioArea funcionarioArea,
			FuncionarioCargo funcionarioCargoPrincipal, FuncionarioCargo funcionarioCargoAcumulado1,
			FuncionarioCargo funcionarioCargoAcumulado2, String lotacao, String cargoPrincipal, String cargoAcumulado1,
			String cargoAcumulado2, String observacoes) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.dataConsolidacao = dataConsolidacao;
		this.contaRecebimento = contaRecebimento;
		this.funcionarioArea = funcionarioArea;
		this.funcionarioCargoPrincipal = funcionarioCargoPrincipal;
		this.funcionarioCargoAcumulado1 = funcionarioCargoAcumulado1;
		this.funcionarioCargoAcumulado2 = funcionarioCargoAcumulado2;
		this.lotacao = lotacao;
		this.cargoPrincipal = cargoPrincipal;
		this.cargoAcumulado1 = cargoAcumulado1;
		this.cargoAcumulado2 = cargoAcumulado2;
		this.observacoes = observacoes;
	}
	
	public DadosConsolidadosDoFuncionarioTO toTO() {
		return new DadosConsolidadosDoFuncionarioTO(id, funcionario.toTO(), dataConsolidacao,
				contaRecebimento!=null?contaRecebimento.toTO():null, funcionarioArea!=null?funcionarioArea.toTO():null,
				funcionarioCargoPrincipal!=null?funcionarioCargoPrincipal.toTO():null, 
				funcionarioCargoAcumulado1!=null?funcionarioCargoAcumulado1.toTO():null,
				funcionarioCargoAcumulado2!=null?funcionarioCargoAcumulado2.toTO():null, lotacao, cargoPrincipal,
				cargoAcumulado1, cargoAcumulado2, observacoes);
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

	public Date getDataConsolidacao() {
		return dataConsolidacao;
	}

	public void setDataConsolidacao(Date dataConsolidacao) {
		this.dataConsolidacao = dataConsolidacao;
	}

	public ContaRecebimento getContaRecebimento() {
		return contaRecebimento;
	}

	public void setContaRecebimento(ContaRecebimento contaRecebimento) {
		this.contaRecebimento = contaRecebimento;
	}

	public FuncionarioArea getFuncionarioArea() {
		return funcionarioArea;
	}

	public void setFuncionarioArea(FuncionarioArea funcionarioArea) {
		this.funcionarioArea = funcionarioArea;
	}

	public FuncionarioCargo getFuncionarioCargoPrincipal() {
		return funcionarioCargoPrincipal;
	}

	public void setFuncionarioCargoPrincipal(FuncionarioCargo funcionarioCargoPrincipal) {
		this.funcionarioCargoPrincipal = funcionarioCargoPrincipal;
	}

	public FuncionarioCargo getFuncionarioCargoAcumulado1() {
		return funcionarioCargoAcumulado1;
	}

	public void setFuncionarioCargoAcumulado1(FuncionarioCargo funcionarioCargoAcumulado1) {
		this.funcionarioCargoAcumulado1 = funcionarioCargoAcumulado1;
	}

	public FuncionarioCargo getFuncionarioCargoAcumulado2() {
		return funcionarioCargoAcumulado2;
	}

	public void setFuncionarioCargoAcumulado2(FuncionarioCargo funcionarioCargoAcumulado2) {
		this.funcionarioCargoAcumulado2 = funcionarioCargoAcumulado2;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

	public String getCargoPrincipal() {
		return cargoPrincipal;
	}

	public void setCargoPrincipal(String cargoPrincipal) {
		this.cargoPrincipal = cargoPrincipal;
	}

	public String getCargoAcumulado1() {
		return cargoAcumulado1;
	}

	public void setCargoAcumulado1(String cargoAcumulado1) {
		this.cargoAcumulado1 = cargoAcumulado1;
	}

	public String getCargoAcumulado2() {
		return cargoAcumulado2;
	}

	public void setCargoAcumulado2(String cargoAcumulado2) {
		this.cargoAcumulado2 = cargoAcumulado2;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		DadosConsolidadosDoFuncionario other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DadosConsolidadosDoFuncionario [id=" + id + ", funcionario=" + funcionario + ", dataConsolidacao="
				+ dataConsolidacao + ", contaRecebimento=" + contaRecebimento + ", funcionarioArea=" + funcionarioArea
				+ ", funcionarioCargoPrincipal=" + funcionarioCargoPrincipal + ", funcionarioCargoAcumulado1="
				+ funcionarioCargoAcumulado1 + ", funcionarioCargoAcumulado2=" + funcionarioCargoAcumulado2
				+ ", lotacao=" + lotacao + ", cargoPrincipal=" + cargoPrincipal + ", cargoAcumulado1=" + cargoAcumulado1
				+ ", cargoAcumulado2=" + cargoAcumulado2 + ", observacoes=" + observacoes + "]";
	}
	
}