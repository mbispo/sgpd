package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:07
 */
@Entity
@Auditavel
@Cacheable
public class TransicaoEstado implements Serializable {

	private static final long serialVersionUID = -6442590937306990098L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	private String entidade;

	@Column(length = 255)
	private String estado;

	@Column(length = 255)
	private String usuario;

	private Date dataHora;

	private Long tempo;

	public TransicaoEstado() {
		super();
	}

	public TransicaoEstado(String entidade, String estado, String usuario, Date dataHora, Long tempo) {
		super();
		this.entidade = entidade;
		this.estado = estado;
		this.usuario = usuario;
		this.dataHora = dataHora;
		this.tempo = tempo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntidade() {
		return entidade;
	}

	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Long getTempo() {
		return tempo;
	}

	public void setTempo(Long tempo) {
		this.tempo = tempo;
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
		TransicaoEstado other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "TransicaoEstado [id=" + id + ", entidade=" + entidade + ", estado=" + estado + ", usuario=" + usuario
				+ ", dataHora=" + dataHora + ", tempo=" + tempo + "]";
	}

}