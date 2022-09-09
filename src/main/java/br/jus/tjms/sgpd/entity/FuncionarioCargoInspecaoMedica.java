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
public class FuncionarioCargoInspecaoMedica implements Serializable {

	private static final long serialVersionUID = -4528841566097024827L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionarioCargo_id", nullable = false)
	private FuncionarioCargo funcionarioCargo;

	@ManyToOne
	@JoinColumn(name = "juntaMedica_id", nullable = false)
	private JuntaMedica juntaMedica;

	private Date data;

	@Column(length = 500)
	private String parecer;

	public FuncionarioCargoInspecaoMedica() {
		super();
	}

	public FuncionarioCargoInspecaoMedica(Long id, FuncionarioCargo funcionarioCargo, JuntaMedica juntaMedica,
			Date data, String parecer) {
		super();
		this.id = id;
		this.funcionarioCargo = funcionarioCargo;
		this.juntaMedica = juntaMedica;
		this.data = data;
		this.parecer = parecer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public JuntaMedica getJuntaMedica() {
		return juntaMedica;
	}

	public void setJuntaMedica(JuntaMedica juntaMedica) {
		this.juntaMedica = juntaMedica;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		FuncionarioCargoInspecaoMedica other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FuncionarioCargoInspecaoMedica [id=" + id + ", funcionarioCargo=" + funcionarioCargo + ", juntaMedica="
				+ juntaMedica + ", data=" + data + ", parecer=" + parecer + "]";
	}

}