package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.SituacaoPessoaInclusaContratoPlanoSaude;
import br.jus.tjms.sgpd.enumerators.TipoCobrancaPlanoSaude;
import br.jus.tjms.sgpd.enumerators.TipoInclusaoPlanoSaude;

public class PessoaInclusaContratoPlanoSaudeTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long contratoPlanoSaudeId;
	private Long pessoaInclusaId;
	private Long planoSaudeId;
	private TipoInclusaoPlanoSaude tipoInclusao;
	private Date dataInclusao;
	private TipoCobrancaPlanoSaude tipoCobranca;
	private Double mensalidade;
	private Double percentual;
	private SituacaoPessoaInclusaContratoPlanoSaude situacao;
	private Date dataSituacao;
	private String parecer;

	public PessoaInclusaContratoPlanoSaudeTO() {
		super();
	}

	public PessoaInclusaContratoPlanoSaudeTO(Long id, Long contratoPlanoSaudeId, Long pessoaInclusaId,
			Long planoSaudeId, TipoInclusaoPlanoSaude tipoInclusao, Date dataInclusao,
			TipoCobrancaPlanoSaude tipoCobranca, Double mensalidade, Double percentual,
			SituacaoPessoaInclusaContratoPlanoSaude situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.contratoPlanoSaudeId = contratoPlanoSaudeId;
		this.pessoaInclusaId = pessoaInclusaId;
		this.planoSaudeId = planoSaudeId;
		this.tipoInclusao = tipoInclusao;
		this.dataInclusao = dataInclusao;
		this.tipoCobranca = tipoCobranca;
		this.mensalidade = mensalidade;
		this.percentual = percentual;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
	}

	public PessoaInclusaContratoPlanoSaudeTO(Long contratoPlanoSaudeId, Long pessoaInclusaId, Long planoSaudeId,
			TipoInclusaoPlanoSaude tipoInclusao, Date dataInclusao, TipoCobrancaPlanoSaude tipoCobranca,
			Double mensalidade, Double percentual, SituacaoPessoaInclusaContratoPlanoSaude situacao, Date dataSituacao,
			String parecer) {
		super();
		this.contratoPlanoSaudeId = contratoPlanoSaudeId;
		this.pessoaInclusaId = pessoaInclusaId;
		this.planoSaudeId = planoSaudeId;
		this.tipoInclusao = tipoInclusao;
		this.dataInclusao = dataInclusao;
		this.tipoCobranca = tipoCobranca;
		this.mensalidade = mensalidade;
		this.percentual = percentual;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContratoPlanoSaudeId() {
		return contratoPlanoSaudeId;
	}

	public void setContratoPlanoSaudeId(Long contratoPlanoSaudeId) {
		this.contratoPlanoSaudeId = contratoPlanoSaudeId;
	}

	public Long getPessoaInclusaId() {
		return pessoaInclusaId;
	}

	public void setPessoaInclusaId(Long pessoaInclusaId) {
		this.pessoaInclusaId = pessoaInclusaId;
	}

	public Long getPlanoSaudeId() {
		return planoSaudeId;
	}

	public void setPlanoSaudeId(Long planoSaudeId) {
		this.planoSaudeId = planoSaudeId;
	}

	public TipoInclusaoPlanoSaude getTipoInclusao() {
		return tipoInclusao;
	}

	public void setTipoInclusao(TipoInclusaoPlanoSaude tipoInclusao) {
		this.tipoInclusao = tipoInclusao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public TipoCobrancaPlanoSaude getTipoCobranca() {
		return tipoCobranca;
	}

	public void setTipoCobranca(TipoCobrancaPlanoSaude tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public SituacaoPessoaInclusaContratoPlanoSaude getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPessoaInclusaContratoPlanoSaude situacao) {
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

	@Override
	public String toString() {
		return "PessoaInclusaContratoPlanoSaudeTO [id=" + id + ", contratoPlanoSaudeId=" + contratoPlanoSaudeId
				+ ", pessoaInclusaId=" + pessoaInclusaId + ", planoSaudeId=" + planoSaudeId + ", tipoInclusao="
				+ tipoInclusao + ", dataInclusao=" + dataInclusao + ", tipoCobranca=" + tipoCobranca + ", mensalidade="
				+ mensalidade + ", percentual=" + percentual + ", situacao=" + situacao + ", dataSituacao="
				+ dataSituacao + ", parecer=" + parecer + "]";
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
		PessoaInclusaContratoPlanoSaudeTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}