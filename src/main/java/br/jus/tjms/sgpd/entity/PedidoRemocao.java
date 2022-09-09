package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoPedidoRemocao;
import br.jus.tjms.sgpd.enumerators.TipoRemocao;
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
public class PedidoRemocao implements Serializable {

	private static final long serialVersionUID = 6887667747501868995L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Funcionario solicitante;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@Enumerated(EnumType.ORDINAL)
	private TipoRemocao tipoRemocao;

	@ManyToOne
	@JoinColumn(name = "pedidoRelacionado_id", nullable = true)
	private PedidoRemocao pedidoRelacionado;

	@Column(length = 60)
	private String processo;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoPedidoRemocao situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public PedidoRemocao() {
		super();
	}

	public PedidoRemocao(Long id, Funcionario solicitante, Funcionario funcionario, TipoRemocao tipoRemocao,
			PedidoRemocao pedidoRelacionado, String processo, SituacaoPedidoRemocao situacao, Date dataSituacao,
			String parecer) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.funcionario = funcionario;
		this.tipoRemocao = tipoRemocao;
		this.pedidoRelacionado = pedidoRelacionado;
		this.processo = processo;
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

	public Funcionario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Funcionario solicitante) {
		this.solicitante = solicitante;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public TipoRemocao getTipoRemocao() {
		return tipoRemocao;
	}

	public void setTipoRemocao(TipoRemocao tipoRemocao) {
		this.tipoRemocao = tipoRemocao;
	}

	public PedidoRemocao getPedidoRelacionado() {
		return pedidoRelacionado;
	}

	public void setPedidoRelacionado(PedidoRemocao pedidoRelacionado) {
		this.pedidoRelacionado = pedidoRelacionado;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoPedidoRemocao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedidoRemocao situacao) {
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
		PedidoRemocao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PedidoRemocao [id=" + id + ", solicitante=" + solicitante + ", funcionario=" + funcionario
				+ ", tipoRemocao=" + tipoRemocao + ", pedidoRelacionado=" + pedidoRelacionado + ", processo="
				+ processo + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}