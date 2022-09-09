package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoNomeacao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
public class NomeacaoTransicao implements Serializable {

	private static final long serialVersionUID = 5083466892079315162L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "nomeacao_id", nullable = false)
	private Nomeacao nomeacao;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoNomeacao situacao;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativoRelacionado_id", nullable = true)
	private AtoAdministrativo atoRelacionado;

	private Date data;
	private Date dataEfeito;

	@Column(length = 500)
	private String motivo;

	@Column(length = 500)
	private String observacoes;

	public NomeacaoTransicao() {
		super();
	}

	public NomeacaoTransicao(Long id, Nomeacao nomeacao, SituacaoNomeacao situacao, AtoAdministrativo ato,
			AtoAdministrativo atoRelacionado, Date data, Date dataEfeito, String motivo, String observacoes) {
		super();
		this.id = id;
		this.nomeacao = nomeacao;
		this.situacao = situacao;
		this.ato = ato;
		this.atoRelacionado = atoRelacionado;
		this.data = data;
		this.dataEfeito = dataEfeito;
		this.motivo = motivo;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nomeacao getNomeacao() {
		return nomeacao;
	}

	public void setNomeacao(Nomeacao nomeacao) {
		this.nomeacao = nomeacao;
	}

	public SituacaoNomeacao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoNomeacao situacao) {
		this.situacao = situacao;
	}

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public AtoAdministrativo getAtoRelacionado() {
		return atoRelacionado;
	}

	public void setAtoRelacionado(AtoAdministrativo atoRelacionado) {
		this.atoRelacionado = atoRelacionado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		NomeacaoTransicao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "NomeacaoTransicao [id=" + id + ", nomeacao=" + nomeacao + ", situacao=" + situacao + ", ato=" + ato
				+ ", atoRelacionado=" + atoRelacionado + ", data=" + data + ", dataEfeito=" + dataEfeito + ", motivo="
				+ motivo + ", observacoes=" + observacoes + "]";
	}

}