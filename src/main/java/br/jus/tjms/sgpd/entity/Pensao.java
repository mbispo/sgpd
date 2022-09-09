package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoPensao;
import br.jus.tjms.sgpd.enumerators.TipoPensao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 12-abr-2016 13:36:06
 */
@Entity
@Auditavel
@Cacheable
public class Pensao implements Serializable {

	private static final long serialVersionUID = 2386214208285146792L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	private TipoPensao tipoPensao;

	@ManyToOne
	@JoinColumn(name = "beneficiario_id", nullable = false)
	private Pessoa beneficiario;

	@ManyToOne
	@JoinColumn(name = "instituidor_id", nullable = true)
	private Funcionario instituidor;

	private Boolean descontaDoInstituidor;

	private Date inicioPagamento;

	private Date fimPagamento;

	@Column(length = 200)
	private String processo;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativoTermino_id", nullable = false)
	private AtoAdministrativo atoAdministrativoTermino;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoPensao situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public Pensao() {
		super();
	}

	public Pensao(TipoPensao tipoPensao, Pessoa beneficiario, Funcionario instituidor, Boolean descontaDoInstituidor,
			Date inicioPagamento, Date fimPagamento, String processo, AtoAdministrativo atoAdministrativo,
			AtoAdministrativo atoAdministrativoTermino, SituacaoPensao situacao, Date dataSituacao, String parecer) {
		super();
		this.tipoPensao = tipoPensao;
		this.beneficiario = beneficiario;
		this.instituidor = instituidor;
		this.descontaDoInstituidor = descontaDoInstituidor;
		this.inicioPagamento = inicioPagamento;
		this.fimPagamento = fimPagamento;
		this.processo = processo;
		this.atoAdministrativo = atoAdministrativo;
		this.atoAdministrativoTermino = atoAdministrativoTermino;
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

	public TipoPensao getTipoPensao() {
		return tipoPensao;
	}

	public void setTipoPensao(TipoPensao tipoPensao) {
		this.tipoPensao = tipoPensao;
	}

	public Pessoa getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Pessoa beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Funcionario getInstituidor() {
		return instituidor;
	}

	public void setInstituidor(Funcionario instituidor) {
		this.instituidor = instituidor;
	}

	public Boolean getDescontaDoInstituidor() {
		return descontaDoInstituidor;
	}

	public void setDescontaDoInstituidor(Boolean descontaDoInstituidor) {
		this.descontaDoInstituidor = descontaDoInstituidor;
	}

	public Date getInicioPagamento() {
		return inicioPagamento;
	}

	public void setInicioPagamento(Date inicioPagamento) {
		this.inicioPagamento = inicioPagamento;
	}

	public Date getFimPagamento() {
		return fimPagamento;
	}

	public void setFimPagamento(Date fimPagamento) {
		this.fimPagamento = fimPagamento;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public AtoAdministrativo getAtoAdministrativoTermino() {
		return atoAdministrativoTermino;
	}

	public void setAtoAdministrativoTermino(AtoAdministrativo atoAdministrativoTermino) {
		this.atoAdministrativoTermino = atoAdministrativoTermino;
	}

	public SituacaoPensao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPensao situacao) {
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
		Pensao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Pensao [id=" + id + ", tipoPensao=" + tipoPensao + ", beneficiario=" + beneficiario + ", instituidor="
				+ instituidor + ", descontaDoInstituidor=" + descontaDoInstituidor + ", inicioPagamento="
				+ inicioPagamento + ", fimPagamento=" + fimPagamento + ", processo=" + processo + ", atoAdministrativo="
				+ atoAdministrativo + ", atoAdministrativoTermino=" + atoAdministrativoTermino + ", situacao="
				+ situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}