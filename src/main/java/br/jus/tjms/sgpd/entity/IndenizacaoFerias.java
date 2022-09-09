package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.IndenizacaoFeriasParcela;
import br.jus.tjms.sgpd.enumerators.TipoIndenizacaoFerias;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
public class IndenizacaoFerias implements Serializable {

	private static final long serialVersionUID = 6536205425596717132L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@ManyToOne
	@JoinColumn(name = "aquisicao_id", nullable = false)
	private AquisicaoFerias aquisicao;

	private Integer numeroDias;

	@Column(length = 60)
	private String processo;

	@Enumerated(EnumType.ORDINAL)
	private IndenizacaoFeriasParcela parcela;

	@Enumerated(EnumType.ORDINAL)
	private TipoIndenizacaoFerias tipoIndenizacao;

	private Boolean pagamentoAgendado;
	private Date dataEfeito;
	private Boolean anotadoCTPS;

	public IndenizacaoFerias() {
		super();
	}

	public IndenizacaoFerias(Long id, Funcionario funcionario, AtoAdministrativo atoAdministrativo,
			AquisicaoFerias aquisicao, Integer numeroDias, String processo, IndenizacaoFeriasParcela parcela,
			TipoIndenizacaoFerias tipoIndenizacao, Boolean pagamentoAgendado, Date dataEfeito, Boolean anotadoCTPS) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.atoAdministrativo = atoAdministrativo;
		this.aquisicao = aquisicao;
		this.numeroDias = numeroDias;
		this.processo = processo;
		this.parcela = parcela;
		this.tipoIndenizacao = tipoIndenizacao;
		this.pagamentoAgendado = pagamentoAgendado;
		this.dataEfeito = dataEfeito;
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

	public AquisicaoFerias getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(AquisicaoFerias aquisicao) {
		this.aquisicao = aquisicao;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public IndenizacaoFeriasParcela getParcela() {
		return parcela;
	}

	public void setParcela(IndenizacaoFeriasParcela parcela) {
		this.parcela = parcela;
	}

	public TipoIndenizacaoFerias getTipoIndenizacao() {
		return tipoIndenizacao;
	}

	public void setTipoIndenizacao(TipoIndenizacaoFerias tipoIndenizacao) {
		this.tipoIndenizacao = tipoIndenizacao;
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
		IndenizacaoFerias other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "IndenizacaoFerias [id=" + id + ", funcionario=" + funcionario + ", atoAdministrativo="
				+ atoAdministrativo + ", aquisicao=" + aquisicao + ", numeroDias=" + numeroDias + ", processo="
				+ processo + ", parcela=" + parcela + ", tipoIndenizacao=" + tipoIndenizacao + ", pagamentoAgendado="
				+ pagamentoAgendado + ", dataEfeito=" + dataEfeito + ", anotadoCTPS=" + anotadoCTPS + "]";
	}

}