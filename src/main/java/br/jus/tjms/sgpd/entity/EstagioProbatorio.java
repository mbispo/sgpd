package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoEstagioProbatorio;
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
public class EstagioProbatorio implements Serializable {

	private static final long serialVersionUID = 2789045207804262542L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;

	private Date fim;
	private Date inicio;

	private Boolean estavel;
	private Date dataDeclaracaoEstabilidade;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoEstagioProbatorio situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public EstagioProbatorio() {
		super();
	}

	public EstagioProbatorio(Long id, FuncionarioCargo funcionarioCargo, Date fim, Date inicio, Boolean estavel,
			Date dataDeclaracaoEstabilidade, SituacaoEstagioProbatorio situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.funcionarioCargo = funcionarioCargo;
		this.fim = fim;
		this.inicio = inicio;
		this.estavel = estavel;
		this.dataDeclaracaoEstabilidade = dataDeclaracaoEstabilidade;
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

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Boolean getEstavel() {
		return estavel;
	}

	public void setEstavel(Boolean estavel) {
		this.estavel = estavel;
	}

	public Date getDataDeclaracaoEstabilidade() {
		return dataDeclaracaoEstabilidade;
	}

	public void setDataDeclaracaoEstabilidade(Date dataDeclaracaoEstabilidade) {
		this.dataDeclaracaoEstabilidade = dataDeclaracaoEstabilidade;
	}

	public SituacaoEstagioProbatorio getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEstagioProbatorio situacao) {
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
		EstagioProbatorio other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "EstagioProbatorio [id=" + id + ", funcionarioCargo=" + funcionarioCargo + ", fim=" + fim + ", inicio="
				+ inicio + ", estavel=" + estavel + ", dataDeclaracaoEstabilidade=" + dataDeclaracaoEstabilidade
				+ ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}