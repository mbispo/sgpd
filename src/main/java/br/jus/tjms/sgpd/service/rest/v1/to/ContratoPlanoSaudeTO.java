package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.SituacaoContratoPlanoSaude;

public class ContratoPlanoSaudeTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long planoSaudeId;
	private Long responsavelId;
	private Long titularId;
	private Date dataCadastro;
	private SituacaoContratoPlanoSaude situacao;
	private Date dataSituacao;
	private String parecer;
	private List<PessoaInclusaContratoPlanoSaudeTO> pessoasInclusas = new ArrayList<PessoaInclusaContratoPlanoSaudeTO>();

	public ContratoPlanoSaudeTO() {
		super();
	}

	public ContratoPlanoSaudeTO(Long id, Long planoSaudeId, Long responsavelId, Long titularId, Date dataCadastro,
			SituacaoContratoPlanoSaude situacao, Date dataSituacao, String parecer,
			List<PessoaInclusaContratoPlanoSaudeTO> pessoasInclusas) {
		super();
		this.id = id;
		this.planoSaudeId = planoSaudeId;
		this.responsavelId = responsavelId;
		this.titularId = titularId;
		this.dataCadastro = dataCadastro;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
		this.pessoasInclusas = pessoasInclusas;
	}

	public ContratoPlanoSaudeTO(Long planoSaudeId, Long responsavelId, Long titularId, Date dataCadastro,
			SituacaoContratoPlanoSaude situacao, Date dataSituacao, String parecer,
			List<PessoaInclusaContratoPlanoSaudeTO> pessoasInclusas) {
		super();
		this.planoSaudeId = planoSaudeId;
		this.responsavelId = responsavelId;
		this.titularId = titularId;
		this.dataCadastro = dataCadastro;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
		this.pessoasInclusas = pessoasInclusas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlanoSaudeId() {
		return planoSaudeId;
	}

	public void setPlanoSaudeId(Long planoSaudeId) {
		this.planoSaudeId = planoSaudeId;
	}

	public Long getResponsavelId() {
		return responsavelId;
	}

	public void setResponsavelId(Long responsavelId) {
		this.responsavelId = responsavelId;
	}

	public Long getTitularId() {
		return titularId;
	}

	public void setTitularId(Long titularId) {
		this.titularId = titularId;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public SituacaoContratoPlanoSaude getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoContratoPlanoSaude situacao) {
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

	public List<PessoaInclusaContratoPlanoSaudeTO> getPessoasInclusas() {
		return pessoasInclusas;
	}

	public void setPessoasInclusas(List<PessoaInclusaContratoPlanoSaudeTO> pessoasInclusas) {
		this.pessoasInclusas = pessoasInclusas;
	}

	@Override
	public String toString() {
		return "ContratoPlanoSaudeTO [id=" + id + ", planoSaudeId=" + planoSaudeId + ", responsavelId=" + responsavelId
				+ ", titularId=" + titularId + ", dataCadastro=" + dataCadastro + ", situacao=" + situacao
				+ ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + ", pessoasInclusas=" + pessoasInclusas
				+ "]";
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
		ContratoPlanoSaudeTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}