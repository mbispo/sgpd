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
public class DeclaracaoEstabilidade implements Serializable {

	private static final long serialVersionUID = -3441071393007079440L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "estagioProbatorio_id", nullable = false)
	private EstagioProbatorio estagioProbatorio;

	private Date data;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	public DeclaracaoEstabilidade() {
		super();
	}

	public DeclaracaoEstabilidade(Long id, EstagioProbatorio estagioProbatorio, Date data,
			AtoAdministrativo atoAdministrativo) {
		super();
		this.id = id;
		this.estagioProbatorio = estagioProbatorio;
		this.data = data;
		this.atoAdministrativo = atoAdministrativo;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
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
		DeclaracaoEstabilidade other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DeclaracaoEstabilidade [id=" + id + ", estagioProbatorio=" + estagioProbatorio + ", data=" + data
				+ ", atoAdministrativo=" + atoAdministrativo + "]";
	}

}