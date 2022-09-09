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
public class BancoHoraMovimento implements Serializable {

	private static final long serialVersionUID = 6908003738719751315L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "bancoHora_id", nullable = false)
	private BancoHora bancoHora;

	private Integer dia;
	private Date tempo;

	public BancoHoraMovimento() {
		super();
	}

	public BancoHoraMovimento(Long id, BancoHora bancoHora, Integer dia, Date tempo) {
		super();
		this.id = id;
		this.bancoHora = bancoHora;
		this.dia = dia;
		this.tempo = tempo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BancoHora getBancoHora() {
		return bancoHora;
	}

	public void setBancoHora(BancoHora bancoHora) {
		this.bancoHora = bancoHora;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
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
		BancoHoraMovimento other = (BancoHoraMovimento) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "BancoHoraMovimento [id=" + id + ", bancoHora=" + bancoHora + ", dia=" + dia + ", tempo=" + tempo + "]";
	}

}