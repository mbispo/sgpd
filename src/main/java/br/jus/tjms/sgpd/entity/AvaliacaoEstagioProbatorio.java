package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.ResultadoAvaliacaoEstagioProbatorio;
import br.jus.tjms.sgpd.enumerators.SituacaoAvaliacaoEstagioProbatorio;
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
public class AvaliacaoEstagioProbatorio implements Serializable {

	private static final long serialVersionUID = -7037857825574141605L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "estagioProbatorio_id", nullable = false)
	private EstagioProbatorio estagioProbatorio;

	private Integer sequencial;
	private Date inicio;
	private Date fim;

	@ManyToOne
	@JoinColumn(name = "avaliador_id", nullable = false)
	private Funcionario avaliador;

	private Date dataAvaliacao;
	private Date dataAssinaturaAvaliador;
	private Date dataEnvio;
	private Date dataRecepcao;
	private Date dataCiencia;
	private Date dataAssinaturaComissao;
	private Boolean houveRecurso;

	@Column(length = 500)
	private String parecerComissao;

	@Column(length = 500)
	private String parecerComissaoAposRecurso;

	@Column(length = 60)
	private String processo;

	private Integer pontosPrevistos;
	private Integer pontosObtidos;

	@Enumerated(EnumType.ORDINAL)
	private ResultadoAvaliacaoEstagioProbatorio resultado;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoAvaliacaoEstagioProbatorio situacao;

	public AvaliacaoEstagioProbatorio() {
		super();
	}

	public AvaliacaoEstagioProbatorio(Long id, EstagioProbatorio estagioProbatorio, Integer sequencial, Date inicio,
			Date fim, Funcionario avaliador, Date dataAvaliacao, Date dataAssinaturaAvaliador, Date dataEnvio,
			Date dataRecepcao, Date dataCiencia, Date dataAssinaturaComissao, Boolean houveRecurso,
			String parecerComissao, String parecerComissaoAposRecurso, String processo, Integer pontosPrevistos,
			Integer pontosObtidos, ResultadoAvaliacaoEstagioProbatorio resultado,
			SituacaoAvaliacaoEstagioProbatorio situacao) {
		super();
		this.id = id;
		this.estagioProbatorio = estagioProbatorio;
		this.sequencial = sequencial;
		this.inicio = inicio;
		this.fim = fim;
		this.avaliador = avaliador;
		this.dataAvaliacao = dataAvaliacao;
		this.dataAssinaturaAvaliador = dataAssinaturaAvaliador;
		this.dataEnvio = dataEnvio;
		this.dataRecepcao = dataRecepcao;
		this.dataCiencia = dataCiencia;
		this.dataAssinaturaComissao = dataAssinaturaComissao;
		this.houveRecurso = houveRecurso;
		this.parecerComissao = parecerComissao;
		this.parecerComissaoAposRecurso = parecerComissaoAposRecurso;
		this.processo = processo;
		this.pontosPrevistos = pontosPrevistos;
		this.pontosObtidos = pontosObtidos;
		this.resultado = resultado;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstagioProbatorio getEstagioProbatorio() {
		return estagioProbatorio;
	}

	public void setEstagioProbatorio(EstagioProbatorio estagioProbatorio) {
		this.estagioProbatorio = estagioProbatorio;
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Funcionario getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Funcionario avaliador) {
		this.avaliador = avaliador;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public Date getDataAssinaturaAvaliador() {
		return dataAssinaturaAvaliador;
	}

	public void setDataAssinaturaAvaliador(Date dataAssinaturaAvaliador) {
		this.dataAssinaturaAvaliador = dataAssinaturaAvaliador;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Date getDataRecepcao() {
		return dataRecepcao;
	}

	public void setDataRecepcao(Date dataRecepcao) {
		this.dataRecepcao = dataRecepcao;
	}

	public Date getDataCiencia() {
		return dataCiencia;
	}

	public void setDataCiencia(Date dataCiencia) {
		this.dataCiencia = dataCiencia;
	}

	public Date getDataAssinaturaComissao() {
		return dataAssinaturaComissao;
	}

	public void setDataAssinaturaComissao(Date dataAssinaturaComissao) {
		this.dataAssinaturaComissao = dataAssinaturaComissao;
	}

	public Boolean getHouveRecurso() {
		return houveRecurso;
	}

	public void setHouveRecurso(Boolean houveRecurso) {
		this.houveRecurso = houveRecurso;
	}

	public String getParecerComissao() {
		return parecerComissao;
	}

	public void setParecerComissao(String parecerComissao) {
		this.parecerComissao = parecerComissao;
	}

	public String getParecerComissaoAposRecurso() {
		return parecerComissaoAposRecurso;
	}

	public void setParecerComissaoAposRecurso(String parecerComissaoAposRecurso) {
		this.parecerComissaoAposRecurso = parecerComissaoAposRecurso;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Integer getPontosPrevistos() {
		return pontosPrevistos;
	}

	public void setPontosPrevistos(Integer pontosPrevistos) {
		this.pontosPrevistos = pontosPrevistos;
	}

	public Integer getPontosObtidos() {
		return pontosObtidos;
	}

	public void setPontosObtidos(Integer pontosObtidos) {
		this.pontosObtidos = pontosObtidos;
	}

	public ResultadoAvaliacaoEstagioProbatorio getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoAvaliacaoEstagioProbatorio resultado) {
		this.resultado = resultado;
	}

	public SituacaoAvaliacaoEstagioProbatorio getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAvaliacaoEstagioProbatorio situacao) {
		this.situacao = situacao;
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
		AvaliacaoEstagioProbatorio other = (AvaliacaoEstagioProbatorio) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "AvaliacaoEstagioProbatorio [id=" + id + ", estagioProbatorio=" + estagioProbatorio + ", sequencial="
				+ sequencial + ", avaliador=" + avaliador + ", houveRecurso=" + houveRecurso + ", parecerComissao="
				+ parecerComissao + ", parecerComissaoAposRecurso=" + parecerComissaoAposRecurso + ", processo="
				+ processo + ", pontosPrevistos=" + pontosPrevistos + ", pontosObtidos=" + pontosObtidos
				+ ", resultado=" + resultado + ", situacao=" + situacao + "]";
	}

}