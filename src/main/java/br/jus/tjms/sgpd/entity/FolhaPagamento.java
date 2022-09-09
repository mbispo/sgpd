package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.enumerators.SituacaoFolhaPagamento;
import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;
import br.jus.tjms.sgpd.service.rest.v1.to.FolhaPagamentoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.FuncionarioFolhaPagamentoTO;
import br.jus.tjms.sgpd.service.rest.v1.to.PagamentoTO;
import br.jus.tjms.sgpd.util.DateUtilz;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:57
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "folhaPagamento.buscarFolhasPorAnoMes", 
			query = "SELECT f FROM FolhaPagamento f WHERE f.ano = :ano and f.mes =:mes")
})
public class FolhaPagamento implements Serializable {

	private static final long serialVersionUID = 4316288539442333541L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer ano;
	private Integer mes;

	@Column(length = 50)
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	private TipoFolhaPagamento tipo;

	@FolowField
	@ManyToOne
	@JoinColumn(name = "grupo_id", nullable = false)
	private GrupoFolhaPagamento grupo;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoFolhaPagamento situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;
	
	@OneToMany(mappedBy = "folhaPagamento", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<FuncionarioFolhaPagamento> funcionarios = new ArrayList<FuncionarioFolhaPagamento>();
	
	@OneToMany(mappedBy = "folhaPagamento", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();	

	public FolhaPagamento() {
		super();
	}
	
	public FolhaPagamento(Long id) {
		super();
		this.id = id;
	}

	public FolhaPagamento(Integer ano, Integer mes, String descricao, TipoFolhaPagamento tipo) {
		this.setAno(ano);
		this.setMes(mes);
		this.setDescricao(descricao);
		this.setTipo(tipo);
	}

	public FolhaPagamento(Integer ano, Integer mes, String descricao, TipoFolhaPagamento tipo,
						  GrupoFolhaPagamento grupo, SituacaoFolhaPagamento situacao, Date dataSituacao, String parecer,
						  List<FuncionarioFolhaPagamento> funcionarios,
						  List<Pagamento> pagamentos) {
		super();
		this.ano = ano;
		this.mes = mes;
		this.descricao = descricao;
		this.tipo = tipo;
		this.grupo = grupo;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
		this.funcionarios = funcionarios;
		this.pagamentos = pagamentos;
	}

	public FolhaPagamento(FolhaPagamentoTO folhaPagamentoTO) {
		this.id = folhaPagamentoTO.getId();
		this.ano = folhaPagamentoTO.getAno();
		this.mes = folhaPagamentoTO.getMes();
		this.descricao = folhaPagamentoTO.getDescricao();
		this.tipo = folhaPagamentoTO.getTipo();
		
		this.grupo = new GrupoFolhaPagamento(folhaPagamentoTO.getGrupoFolhaPagamentoId());
		
		this.situacao = folhaPagamentoTO.getSituacao();
		this.dataSituacao = folhaPagamentoTO.getDataSituacao();
		this.parecer = folhaPagamentoTO.getParecer();
		
		if (folhaPagamentoTO.getFuncionarios()!=null) {
			for (FuncionarioFolhaPagamentoTO ff : folhaPagamentoTO.getFuncionarios()) {
				this.getFuncionarios().add(new FuncionarioFolhaPagamento(ff.getFuncionarioId(), this));				
			}
		}
	}
	
	public void alterar(FolhaPagamentoTO folhaPagamentoTO) {
		this.ano = folhaPagamentoTO.getAno();
		this.mes = folhaPagamentoTO.getMes();
		this.descricao = folhaPagamentoTO.getDescricao();
		this.tipo = folhaPagamentoTO.getTipo();
		this.grupo = new GrupoFolhaPagamento(folhaPagamentoTO.getGrupoFolhaPagamentoId());
		this.situacao = folhaPagamentoTO.getSituacao();
		this.dataSituacao = folhaPagamentoTO.getDataSituacao();
		this.parecer = folhaPagamentoTO.getParecer();
		
		if (folhaPagamentoTO.getFuncionarios()!=null) {
			for (FuncionarioFolhaPagamentoTO ff : folhaPagamentoTO.getFuncionarios()) {
				this.getFuncionarios().add(new FuncionarioFolhaPagamento(ff.getFuncionarioId(), this));				
			}
		}
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoFolhaPagamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoFolhaPagamento tipo) {
		this.tipo = tipo;
	}

	public GrupoFolhaPagamento getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoFolhaPagamento grupo) {
		this.grupo = grupo;
	}

	public SituacaoFolhaPagamento getSituacao() {
		return situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public List<FuncionarioFolhaPagamento> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioFolhaPagamento> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	@Transient
	public Date getDataInicial() {
		return DateUtilz.primeiroDiaDoMes(mes, ano);
	}
	
	@Transient
	public Date getDataFinal() {
		return DateUtilz.ultimoDiaDoMesAoFinalDoDia(mes, ano);
	}
	
	@Transient
	public Double getTotalLiquido() {
		Double total = 0.0;
		if (pagamentos!=null) for (Pagamento pagamento : pagamentos) {
			total = total + pagamento.getLiquido();
		}
		return total;
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
		FolhaPagamento other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FolhaPagamento [id=" + id + ", ano=" + ano + ", mes=" + mes + ", descricao=" + descricao + ", tipo="
				+ tipo + ", grupo=" + grupo + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao
				+ ", parecer=" + parecer + "]";
	}

	public void alterarSituacao(SituacaoFolhaPagamento situacao) {
		this.situacao = situacao;
	}
	
	public FolhaPagamentoTO toTO() {
		return new FolhaPagamentoTO(id, ano, mes, descricao, tipo,
				grupo.getId(), situacao, dataSituacao, parecer,
				funcionariosToTO(), pagamentosToTO());
	}
	
	public List<FuncionarioFolhaPagamentoTO> funcionariosToTO() {
		List<FuncionarioFolhaPagamentoTO> funcionariosTO = new ArrayList<>();
		for (FuncionarioFolhaPagamento f : funcionarios) {
			funcionariosTO.add(f.toTO());
		}
		return funcionariosTO;
	}
	
	public List<PagamentoTO> pagamentosToTO() {
		List<PagamentoTO> pagamentosTO = new ArrayList<>();
		for (Pagamento p : pagamentos) {
			pagamentosTO.add(p.toTO());
		}
		return pagamentosTO;
	}
}