package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class Concurso implements Serializable {

	private static final long serialVersionUID = -3226077642525953132L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;

	private Date dataInscricaoInicio;
	private Date dataInscricaoFinal;

	private Boolean suspenso;

	public Concurso() {
		super();
	}

	public Concurso(Long id, String descricao, Date dataInscricaoInicio, Date dataInscricaoFinal, Boolean suspenso) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataInscricaoInicio = dataInscricaoInicio;
		this.dataInscricaoFinal = dataInscricaoFinal;
		this.suspenso = suspenso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInscricaoFinal() {
		return dataInscricaoFinal;
	}

	public void setDataInscricaoFinal(Date dataInscricaoFinal) {
		this.dataInscricaoFinal = dataInscricaoFinal;
	}

	public Date getDataInscricaoInicio() {
		return dataInscricaoInicio;
	}

	public void setDataInscricaoInicio(Date dataInscricaoInicio) {
		this.dataInscricaoInicio = dataInscricaoInicio;
	}

	public Boolean getSuspenso() {
		return suspenso;
	}

	public void setSuspenso(Boolean suspenso) {
		this.suspenso = suspenso;
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
		Concurso other = (Concurso) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Concurso [id=" + id + ", descricao=" + descricao + ", dataInscricaoInicio=" + dataInscricaoInicio
				+ ", dataInscricaoFinal=" + dataInscricaoFinal + ", suspenso=" + suspenso + "]";
	}

}