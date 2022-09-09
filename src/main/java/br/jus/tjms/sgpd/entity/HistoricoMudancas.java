package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:07
 */
@Entity
@Auditavel
@Cacheable
public class HistoricoMudancas implements Serializable {

	private static final long serialVersionUID = 2090244994960690183L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	private String entidade;

	@Column(length = 255)
	private String campo;

	@Column(length = 255)
	private String classe;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] valorSerializado;

	@Column(length = 255)
	private String usuario;

	private Date dataHora;

	public HistoricoMudancas() {
		super();
	}

	public HistoricoMudancas(String entidade, String campo, String classe, byte[] valorSerializado,
			String usuario, Date dataHora) {
		super();
		this.entidade = entidade;
		this.campo = campo;
		this.classe = classe;
		this.valorSerializado = valorSerializado;
		this.usuario = usuario;
		this.dataHora = dataHora;
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

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public byte[] getValorSerializado() {
		return valorSerializado;
	}

	public void setValorSerializado(byte[] valorSerializado) {
		this.valorSerializado = valorSerializado;
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
		HistoricoMudancas other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "HistoricoMudancas [id=" + id + ", entidade=" + entidade + ", campo=" + campo + ", classe="
				+ classe + ", valorSerializado=" + Arrays.toString(valorSerializado) + ", usuario=" + usuario
				+ ", dataHora=" + dataHora + "]";
	}

}