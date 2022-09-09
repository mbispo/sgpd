package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoAutoridade;
import br.jus.tjms.sgpd.enumerators.TipoOperacaoAverbacao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AverbacaoTempo implements Serializable {

	private static final long serialVersionUID = -8439639134504282656L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "averbacaoRelacionada_id", nullable = true)
	private AverbacaoTempo averbacaoRelacionada;

	@ManyToOne
	@JoinColumn(name = "solicitacai_id", nullable = true)
	private SolicitacaoAverbacaoTempo solicitacao;

	private Date dataEfeito;

	@Enumerated(EnumType.ORDINAL)
	private TipoOperacaoAverbacao tipoOperacao;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;

	@Column(length = 60)
	private String certidao;
	
	@Column(length = 60)
	private String processo;
	
	@Column(length = 200)
	private String emissor;

	private Date inicioPeriodoReferencia;
	private Date fimPeriodoFererencia;

	@Column(length = 200)
	private String descricaoPeriodoReferencia;

	private Integer numeroReferencia;

	@Column(length = 200)
	private String descricaoNumeroReferencia;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@Enumerated(EnumType.ORDINAL)
	private TipoAutoridade autoridade;

	public AverbacaoTempo() {
		super();
	}

	public AverbacaoTempo(Long id, Funcionario funcionario, AverbacaoTempo averbacaoRelacionada,
			SolicitacaoAverbacaoTempo solicitacao, Date dataEfeito, TipoOperacaoAverbacao tipoOperacao, Area area,
			FuncionarioCargo funcionarioCargo, String certidao, String processo, String emissor,
			Date inicioPeriodoReferencia, Date fimPeriodoFererencia, String descricaoPeriodoReferencia,
			Integer numeroReferencia, String descricaoNumeroReferencia, AtoAdministrativo atoAdministrativo,
			TipoAutoridade autoridade) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.averbacaoRelacionada = averbacaoRelacionada;
		this.solicitacao = solicitacao;
		this.dataEfeito = dataEfeito;
		this.tipoOperacao = tipoOperacao;
		this.area = area;
		this.funcionarioCargo = funcionarioCargo;
		this.certidao = certidao;
		this.processo = processo;
		this.emissor = emissor;
		this.inicioPeriodoReferencia = inicioPeriodoReferencia;
		this.fimPeriodoFererencia = fimPeriodoFererencia;
		this.descricaoPeriodoReferencia = descricaoPeriodoReferencia;
		this.numeroReferencia = numeroReferencia;
		this.descricaoNumeroReferencia = descricaoNumeroReferencia;
		this.atoAdministrativo = atoAdministrativo;
		this.autoridade = autoridade;
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

	public AverbacaoTempo getAverbacaoRelacionada() {
		return averbacaoRelacionada;
	}

	public void setAverbacaoRelacionada(AverbacaoTempo averbacaoRelacionada) {
		this.averbacaoRelacionada = averbacaoRelacionada;
	}

	public SolicitacaoAverbacaoTempo getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoAverbacaoTempo solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public TipoOperacaoAverbacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacaoAverbacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public String getCertidao() {
		return certidao;
	}

	public void setCertidao(String certidao) {
		this.certidao = certidao;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public Date getInicioPeriodoReferencia() {
		return inicioPeriodoReferencia;
	}

	public void setInicioPeriodoReferencia(Date inicioPeriodoReferencia) {
		this.inicioPeriodoReferencia = inicioPeriodoReferencia;
	}

	public Date getFimPeriodoFererencia() {
		return fimPeriodoFererencia;
	}

	public void setFimPeriodoFererencia(Date fimPeriodoFererencia) {
		this.fimPeriodoFererencia = fimPeriodoFererencia;
	}

	public String getDescricaoPeriodoReferencia() {
		return descricaoPeriodoReferencia;
	}

	public void setDescricaoPeriodoReferencia(String descricaoPeriodoReferencia) {
		this.descricaoPeriodoReferencia = descricaoPeriodoReferencia;
	}

	public Integer getNumeroReferencia() {
		return numeroReferencia;
	}

	public void setNumeroReferencia(Integer numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	public String getDescricaoNumeroReferencia() {
		return descricaoNumeroReferencia;
	}

	public void setDescricaoNumeroReferencia(String descricaoNumeroReferencia) {
		this.descricaoNumeroReferencia = descricaoNumeroReferencia;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public TipoAutoridade getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(TipoAutoridade autoridade) {
		this.autoridade = autoridade;
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
		AverbacaoTempo other = (AverbacaoTempo) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "AverbacaoTempo [id=" + id + ", funcionario=" + funcionario + ", averbacaoRelacionada="
				+ averbacaoRelacionada + ", solicitacao=" + solicitacao + ", tipoOperacao=" + tipoOperacao + ", area="
				+ area + ", funcionarioCargo=" + funcionarioCargo + ", certidao=" + certidao + ", processo=" + processo
				+ ", emissor=" + emissor + ", descricaoPeriodoReferencia=" + descricaoPeriodoReferencia
				+ ", numeroReferencia=" + numeroReferencia + ", descricaoNumeroReferencia=" + descricaoNumeroReferencia
				+ ", atoAdministrativo=" + atoAdministrativo + ", autoridade=" + autoridade + "]";
	}

}