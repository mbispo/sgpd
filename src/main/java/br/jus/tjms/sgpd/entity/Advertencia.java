package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class Advertencia implements Serializable {

	private static final long serialVersionUID = -5373771605982331872L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aplicacaoPena_id", nullable = true)
	private AplicacaoPena aplicacaoPena;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Date data;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	@Column(length = 500)
	private String observacoes;

	public Advertencia() {
		super();
	}

	public Advertencia(Long id, AplicacaoPena aplicacaoPena, Funcionario funcionario, Date data, AtoAdministrativo ato,
			String observacoes) {
		super();
		this.id = id;
		this.aplicacaoPena = aplicacaoPena;
		this.funcionario = funcionario;
		this.data = data;
		this.ato = ato;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AplicacaoPena getAplicacaoPena() {
		return aplicacaoPena;
	}

	public void setAplicacaoPena(AplicacaoPena aplicacaoPena) {
		this.aplicacaoPena = aplicacaoPena;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertencia that = (Advertencia) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(aplicacaoPena, that.aplicacaoPena) &&
                Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(data, that.data) &&
                Objects.equals(ato, that.ato) &&
                Objects.equals(observacoes, that.observacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aplicacaoPena, funcionario, data, ato, observacoes);
    }

    @Override
	public String toString() {
		return "Advertencia [id=" + id + ", aplicacaoPena=" + aplicacaoPena + ", funcionario=" + funcionario
				+ ", data=" + data + ", ato=" + ato + ", observacoes=" + observacoes + "]";
	}

}