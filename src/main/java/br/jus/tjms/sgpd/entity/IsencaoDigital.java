package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
public class IsencaoDigital implements Serializable {

	private static final long serialVersionUID = -3700703848891800871L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Date dataConcessao;

	@Column(length = 255)
	private String senhaMD5;

	private Date vigenciaInicio;

	public IsencaoDigital() {
		super();
	}

	public IsencaoDigital(Long id, Funcionario funcionario, Date dataConcessao, String senhaMD5, Date vigenciaInicio) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.dataConcessao = dataConcessao;
		this.senhaMD5 = senhaMD5;
		this.vigenciaInicio = vigenciaInicio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataConcessao() {
		return dataConcessao;
	}

	public void setDataConcessao(Date dataConcessao) {
		this.dataConcessao = dataConcessao;
	}

	public String getSenhaMD5() {
		return senhaMD5;
	}

	public void setSenhaMD5(String senhaMD5) {
		this.senhaMD5 = senhaMD5;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
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
		IsencaoDigital other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "IsencaoDigital [id=" + id + ", funcionario=" + funcionario + ", dataConcessao=" + dataConcessao
				+ ", senhaMD5=" + senhaMD5 + ", vigenciaInicio=" + vigenciaInicio + "]";
	}

}