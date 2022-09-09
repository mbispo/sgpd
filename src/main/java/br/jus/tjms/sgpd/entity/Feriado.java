package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoFeriado;
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
public class Feriado implements Serializable {

	private static final long serialVersionUID = 182438549355074302L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date data;

	@ManyToOne
	@JoinColumn(name = "localidade_id", nullable = true)
	private Localidade localidade;

	@Enumerated(EnumType.ORDINAL)
	private TipoFeriado tipo;

	@Column(length = 200)
	private String descricao;

	public Feriado() {
		super();
	}

	public Feriado(Long id, Date data, Localidade localidade, TipoFeriado tipo, String descricao) {
		super();
		this.id = id;
		this.data = data;
		this.localidade = localidade;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public TipoFeriado getTipo() {
		return tipo;
	}

	public void setTipo(TipoFeriado tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Feriado other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Feriado [id=" + id + ", data=" + data + ", localidade=" + localidade + ", tipo=" + tipo
				+ ", descricao=" + descricao + "]";
	}

}