package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoContratoPlanoSaude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class ContratoPlanoSaude implements Serializable {

	private static final long serialVersionUID = -62152268056044669L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "planoSaude_id", nullable = false)
	private PlanoSaude planoSaude;

	@ManyToOne
	@JoinColumn(name = "responsavelFinanceiro_id", nullable = false)
	private Funcionario responsavelFinanceiro;

	@ManyToOne
	@JoinColumn(name = "titular_id", nullable = false)
	private Funcionario titular;

	private Date dataCadastro;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoContratoPlanoSaude situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	@OneToMany(mappedBy = "contrato", fetch = FetchType.LAZY, 
			cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<PessoaInclusaContratoPlanoSaude> pessoasInclusas = new ArrayList<PessoaInclusaContratoPlanoSaude>();

	public ContratoPlanoSaude() {
		super();
	}

	public ContratoPlanoSaude(PlanoSaude planoSaude, Funcionario responsavelFinanceiro, Funcionario titular,
			Date dataCadastro, SituacaoContratoPlanoSaude situacao, Date dataSituacao, String parecer,
			List<PessoaInclusaContratoPlanoSaude> pessoasInclusas) {
		super();
		this.planoSaude = planoSaude;
		this.responsavelFinanceiro = responsavelFinanceiro;
		this.titular = titular;
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

	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}

	public Funcionario getResponsavelFinanceiro() {
		return responsavelFinanceiro;
	}

	public void setResponsavelFinanceiro(Funcionario responsavelFinanceiro) {
		this.responsavelFinanceiro = responsavelFinanceiro;
	}

	public Funcionario getTitular() {
		return titular;
	}

	public void setTitular(Funcionario titular) {
		this.titular = titular;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoContratoPlanoSaude getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoContratoPlanoSaude situacao) {
		this.situacao = situacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public List<PessoaInclusaContratoPlanoSaude> getPessoasInclusas() {
		return pessoasInclusas;
	}

	public void setPessoasInclusas(List<PessoaInclusaContratoPlanoSaude> pessoasInclusas) {
		this.pessoasInclusas = pessoasInclusas;
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
		ContratoPlanoSaude other = (ContratoPlanoSaude) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ContratoPlanoSaude [id=" + id + ", planoSaude=" + planoSaude + ", responsavelFinanceiro="
				+ responsavelFinanceiro + ", titular=" + titular + ", dataCadastro=" + dataCadastro + ", situacao="
				+ situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}