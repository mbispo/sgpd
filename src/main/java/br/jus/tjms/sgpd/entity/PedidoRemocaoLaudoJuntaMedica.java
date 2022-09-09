package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
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
public class PedidoRemocaoLaudoJuntaMedica implements Serializable {

	private static final long serialVersionUID = -1088305016961830167L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "juntaMedica_id", nullable = false)
	private JuntaMedica juntaMedica;

	@ManyToOne
	@JoinColumn(name = "pedidoRemocao_id", nullable = false)
	private PedidoRemocao pedidoRemocao;

	private Date data;
	private Date dataFimValidade;
	private Boolean favoravel;

	private Integer idDocumentoGerdoc;

	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] integra;

	public PedidoRemocaoLaudoJuntaMedica() {
		super();
	}

	public PedidoRemocaoLaudoJuntaMedica(Long id, JuntaMedica juntaMedica, PedidoRemocao pedidoRemocao, Date data,
			Date dataFimValidade, Boolean favoravel, Integer idDocumentoGerdoc, byte[] integra) {
		super();
		this.id = id;
		this.juntaMedica = juntaMedica;
		this.pedidoRemocao = pedidoRemocao;
		this.data = data;
		this.dataFimValidade = dataFimValidade;
		this.favoravel = favoravel;
		this.idDocumentoGerdoc = idDocumentoGerdoc;
		this.integra = integra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JuntaMedica getJuntaMedica() {
		return juntaMedica;
	}

	public void setJuntaMedica(JuntaMedica juntaMedica) {
		this.juntaMedica = juntaMedica;
	}

	public PedidoRemocao getPedidoRemocao() {
		return pedidoRemocao;
	}

	public void setPedidoRemocao(PedidoRemocao pedidoRemocao) {
		this.pedidoRemocao = pedidoRemocao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataFimValidade() {
		return dataFimValidade;
	}

	public void setDataFimValidade(Date dataFimValidade) {
		this.dataFimValidade = dataFimValidade;
	}

	public Boolean getFavoravel() {
		return favoravel;
	}

	public void setFavoravel(Boolean favoravel) {
		this.favoravel = favoravel;
	}

	public byte[] getIntegra() {
		return integra;
	}

	public void setIntegra(byte[] integra) {
		this.integra = integra;
	}

	public Integer getIdDocumentoGerdoc() {
		return idDocumentoGerdoc;
	}

	public void setIdDocumentoGerdoc(Integer idDocumentoGerdoc) {
		this.idDocumentoGerdoc = idDocumentoGerdoc;
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
		PedidoRemocaoLaudoJuntaMedica other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PedidoRemocaoLaudoJuntaMedica [id=" + id + ", juntaMedica=" + juntaMedica + ", pedidoRemocao="
				+ pedidoRemocao + ", data=" + data + ", dataFimValidade=" + dataFimValidade + ", favoravel="
				+ favoravel + ", idDocumentoGerdoc=" + idDocumentoGerdoc + "]";
	}

}