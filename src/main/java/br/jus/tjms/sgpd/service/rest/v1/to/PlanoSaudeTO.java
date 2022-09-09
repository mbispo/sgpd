package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.ModalidadePlanoSaude;
import br.jus.tjms.sgpd.enumerators.SituacaoPlanoSaude;
import br.jus.tjms.sgpd.enumerators.TipoPlanoSaude;

public class PlanoSaudeTO implements Serializable {

	private static final long serialVersionUID = -8233945227484460976L;

	private Long id;
	private OperadoraPlanoSaudeTO operadora;
	private TipoPlanoSaude tipo;
	private ModalidadePlanoSaude modalidade;
	private String descricao;
	private SituacaoPlanoSaude situacao;
	private Date dataSituacao;
	private String parecer;
	private List<RubricaPlanoSaudeTO> rubricas = new ArrayList<RubricaPlanoSaudeTO>();

	public PlanoSaudeTO() {
		super();
	}

	public PlanoSaudeTO(Long id, OperadoraPlanoSaudeTO operadora, TipoPlanoSaude tipo, ModalidadePlanoSaude modalidade,
			String descricao, SituacaoPlanoSaude situacao, Date dataSituacao, String parecer,
			List<RubricaPlanoSaudeTO> rubricas) {
		super();
		this.id = id;
		this.operadora = operadora;
		this.tipo = tipo;
		this.modalidade = modalidade;
		this.descricao = descricao;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
		this.rubricas = rubricas;
	}

	public PlanoSaudeTO(OperadoraPlanoSaudeTO operadora, TipoPlanoSaude tipo, ModalidadePlanoSaude modalidade,
			String descricao, SituacaoPlanoSaude situacao, Date dataSituacao, String parecer,
			List<RubricaPlanoSaudeTO> rubricas) {
		super();
		this.operadora = operadora;
		this.tipo = tipo;
		this.modalidade = modalidade;
		this.descricao = descricao;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
		this.rubricas = rubricas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OperadoraPlanoSaudeTO getOperadora() {
		return operadora;
	}

	public void setOperadora(OperadoraPlanoSaudeTO operadora) {
		this.operadora = operadora;
	}

	public TipoPlanoSaude getTipo() {
		return tipo;
	}

	public void setTipo(TipoPlanoSaude tipo) {
		this.tipo = tipo;
	}

	public ModalidadePlanoSaude getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadePlanoSaude modalidade) {
		this.modalidade = modalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public SituacaoPlanoSaude getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPlanoSaude situacao) {
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

	public List<RubricaPlanoSaudeTO> getRubricas() {
		return rubricas;
	}

	public void setRubricas(List<RubricaPlanoSaudeTO> rubricas) {
		this.rubricas = rubricas;
	}

	@Override
	public String toString() {
		return "PlanoSaudeTO [id=" + id + ", operadora=" + operadora + ", tipo=" + tipo + ", modalidade=" + modalidade
				+ ", descricao=" + descricao + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao
				+ ", parecer=" + parecer + ", rubricas=" + rubricas + "]";
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
		PlanoSaudeTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}