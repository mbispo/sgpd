package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.SituacaoFolhaPagamento;
import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;

public class FolhaPagamentoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer ano;
	private Integer mes;
	private String descricao;
	private TipoFolhaPagamento tipo;
	private Long grupoFolhaPagamentoId;
	private SituacaoFolhaPagamento situacao;
	private Date dataSituacao;
	private String parecer;
	private List<FuncionarioFolhaPagamentoTO> funcionarios = new ArrayList<FuncionarioFolhaPagamentoTO>();
	private List<PagamentoTO> pagamentos = new ArrayList<PagamentoTO>();

	public FolhaPagamentoTO() {
		super();
	}

	public FolhaPagamentoTO(Long id, Integer ano, Integer mes, String descricao, TipoFolhaPagamento tipo,
			Long grupoFolhaPagamentoId, SituacaoFolhaPagamento situacao, Date dataSituacao, String parecer,
			List<FuncionarioFolhaPagamentoTO> funcionarios, List<PagamentoTO> pagamentos) {
		super();
		this.id = id;
		this.ano = ano;
		this.mes = mes;
		this.descricao = descricao;
		this.tipo = tipo;
		this.grupoFolhaPagamentoId = grupoFolhaPagamentoId;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
		this.funcionarios = funcionarios;
		this.pagamentos = pagamentos;
	}

	public FolhaPagamentoTO(Integer ano, Integer mes, String descricao, TipoFolhaPagamento tipo,
			Long grupoFolhaPagamentoId, SituacaoFolhaPagamento situacao, Date dataSituacao, String parecer,
			List<FuncionarioFolhaPagamentoTO> funcionarios, List<PagamentoTO> pagamentos) {
		super();
		this.ano = ano;
		this.mes = mes;
		this.descricao = descricao;
		this.tipo = tipo;
		this.grupoFolhaPagamentoId = grupoFolhaPagamentoId;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
		this.funcionarios = funcionarios;
		this.pagamentos = pagamentos;
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

	public Long getGrupoFolhaPagamentoId() {
		return grupoFolhaPagamentoId;
	}

	public void setGrupoFolhaPagamentoId(Long grupoFolhaPagamentoId) {
		this.grupoFolhaPagamentoId = grupoFolhaPagamentoId;
	}

	public SituacaoFolhaPagamento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoFolhaPagamento situacao) {
		this.situacao = situacao;
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

	public List<FuncionarioFolhaPagamentoTO> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioFolhaPagamentoTO> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<PagamentoTO> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<PagamentoTO> pagamentos) {
		this.pagamentos = pagamentos;
	}

	@Override
	public String toString() {
		return "FolhaPagamentoTO [id=" + id + ", ano=" + ano + ", mes=" + mes + ", descricao=" + descricao + ", tipo="
				+ tipo + ", grupoFolhaPagamentoId=" + grupoFolhaPagamentoId + ", situacao=" + situacao
				+ ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + ", funcionarios=" + funcionarios
				+ ", pagamentos=" + pagamentos + "]";
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
		FolhaPagamentoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}