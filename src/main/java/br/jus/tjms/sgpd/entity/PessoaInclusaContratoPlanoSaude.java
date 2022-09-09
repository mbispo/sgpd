package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoPessoaInclusaContratoPlanoSaude;
import br.jus.tjms.sgpd.enumerators.TipoCobrancaPlanoSaude;
import br.jus.tjms.sgpd.enumerators.TipoInclusaoPlanoSaude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
public class PessoaInclusaContratoPlanoSaude implements Serializable {

	private static final long serialVersionUID = 7976834178959292204L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "contrato_id", nullable = false)
	private ContratoPlanoSaude contrato;

	@ManyToOne
	@JoinColumn(name = "pessoaInclusa_id", nullable = false)
	private Pessoa pessoaInclusa;

	@ManyToOne
	@JoinColumn(name = "planoSaude_id", nullable = false)
	private PlanoSaude planoSaude;

	@Enumerated(EnumType.ORDINAL)
	private TipoInclusaoPlanoSaude tipoInclusao;

	private Date dataInclusao;

	@Enumerated(EnumType.ORDINAL)
	private TipoCobrancaPlanoSaude tipoCobranca;

	private Double mensalidade;
	private Double percentual;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoPessoaInclusaContratoPlanoSaude situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public PessoaInclusaContratoPlanoSaude() {
		super();
	}

	public PessoaInclusaContratoPlanoSaude(Long id, ContratoPlanoSaude contrato, Pessoa pessoaInclusa,
			PlanoSaude planoSaude, TipoInclusaoPlanoSaude tipoInclusao, Date dataInclusao,
			TipoCobrancaPlanoSaude tipoCobranca, Double mensalidade, Double percentual,
			SituacaoPessoaInclusaContratoPlanoSaude situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.contrato = contrato;
		this.pessoaInclusa = pessoaInclusa;
		this.planoSaude = planoSaude;
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

	public ContratoPlanoSaude getContrato() {
		return contrato;
	}

	public void setContrato(ContratoPlanoSaude contrato) {
		this.contrato = contrato;
	}

	public Pessoa getPessoaInclusa() {
		return pessoaInclusa;
	}

	public void setPessoaInclusa(Pessoa pessoaInclusa) {
		this.pessoaInclusa = pessoaInclusa;
	}

	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
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

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoPessoaInclusaContratoPlanoSaude getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPessoaInclusaContratoPlanoSaude situacao) {
		this.situacao = situacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
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
		PessoaInclusaContratoPlanoSaude other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PessoasInclusasContratoPlanoSaude [id=" + id + ", contrato=" + contrato + ", pessoaInclusa="
				+ pessoaInclusa + ", planoSaude=" + planoSaude + ", tipoInclusao=" + tipoInclusao + ", dataInclusao="
				+ dataInclusao + ", tipoCobranca=" + tipoCobranca + ", mensalidade=" + mensalidade + ", percentual="
				+ percentual + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer
				+ "]";
	}

}