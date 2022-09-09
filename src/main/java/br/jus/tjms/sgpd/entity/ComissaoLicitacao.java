package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:57
 */
@Entity
@Auditavel
@Cacheable
public class ComissaoLicitacao implements Serializable {

	private static final long serialVersionUID = 5504857905176578582L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String pregao;

	@Column(length = 60)
	private String processo;

	private Date dataConclusao;

	public ComissaoLicitacao() {
		super();
	}

	public ComissaoLicitacao(Long id, String pregao, String processo, Date dataConclusao) {
		super();
		this.id = id;
		this.pregao = pregao;
		this.processo = processo;
		this.dataConclusao = dataConclusao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPregao() {
		return pregao;
	}

	public void setPregao(String pregao) {
		this.pregao = pregao;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
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
		ComissaoLicitacao other = (ComissaoLicitacao) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ComissaoLicitacao [id=" + id + ", pregao=" + pregao + ", processo=" + processo + "]";
	}

}