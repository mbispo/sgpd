package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.FeriasParcela;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:57
 */
@Entity
@Auditavel
@Cacheable
public class Ferias implements Serializable {

	private static final long serialVersionUID = -9010005621643301109L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@Column(length = 60)
	private String processo;

	@ManyToOne
	@JoinColumn(name = "concessao_id", nullable = true)
	private ConcessaoFerias concessao;

	@ManyToOne
	@JoinColumn(name = "aquisicao_id", nullable = false)
	private AquisicaoFerias aquisicao;

	@Enumerated(EnumType.ORDINAL)
	private FeriasParcela parcela;

	private Boolean recebeAdicional;
	private Boolean pagamentoAgendado;
	private Date dataEfeito;
	private Integer numeroDias;
	private Date dataInicio;
	private Date dataFim;
	private Boolean anotadoCTPS;

	public Ferias() {
		super();

	}

	public Ferias(Long id, Funcionario funcionario, AtoAdministrativo atoAdministrativo, String processo,
			ConcessaoFerias concessao, AquisicaoFerias aquisicao, FeriasParcela parcela, Boolean recebeAdicional,
			Boolean pagamentoAgendado, Date dataEfeito, Integer numeroDias, Date dataInicio, Date dataFim,
			Boolean anotadoCTPS) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.atoAdministrativo = atoAdministrativo;
		this.processo = processo;
		this.concessao = concessao;
		this.aquisicao = aquisicao;
		this.parcela = parcela;
		this.recebeAdicional = recebeAdicional;
		this.pagamentoAgendado = pagamentoAgendado;
		this.dataEfeito = dataEfeito;
		this.numeroDias = numeroDias;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.anotadoCTPS = anotadoCTPS;
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

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public ConcessaoFerias getConcessao() {
		return concessao;
	}

	public void setConcessao(ConcessaoFerias concessao) {
		this.concessao = concessao;
	}

	public AquisicaoFerias getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(AquisicaoFerias aquisicao) {
		this.aquisicao = aquisicao;
	}

	public FeriasParcela getParcela() {
		return parcela;
	}

	public void setParcela(FeriasParcela parcela) {
		this.parcela = parcela;
	}

	public Boolean getRecebeAdicional() {
		return recebeAdicional;
	}

	public void setRecebeAdicional(Boolean recebeAdicional) {
		this.recebeAdicional = recebeAdicional;
	}

	public Boolean getPagamentoAgendado() {
		return pagamentoAgendado;
	}

	public void setPagamentoAgendado(Boolean pagamentoAgendado) {
		this.pagamentoAgendado = pagamentoAgendado;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Boolean getAnotadoCTPS() {
		return anotadoCTPS;
	}

	public void setAnotadoCTPS(Boolean anotadoCTPS) {
		this.anotadoCTPS = anotadoCTPS;
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
		Ferias other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Ferias [id=" + id + ", funcionario=" + funcionario + ", atoAdministrativo=" + atoAdministrativo
				+ ", processo=" + processo + ", concessao=" + concessao + ", aquisicao=" + aquisicao + ", parcela="
				+ parcela + ", recebeAdicional=" + recebeAdicional + ", pagamentoAgendado=" + pagamentoAgendado
				+ ", dataEfeito=" + dataEfeito + ", numeroDias=" + numeroDias + ", dataInicio=" + dataInicio
				+ ", dataFim=" + dataFim + ", anotadoCTPS=" + anotadoCTPS + "]";
	}

}