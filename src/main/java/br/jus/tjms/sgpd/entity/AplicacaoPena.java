package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoAutoridade;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AplicacaoPena implements Serializable {

	private static final long serialVersionUID = -774030211097678798L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@Column(length = 60)
	private String processoAdministrativo;

	@Enumerated(EnumType.ORDINAL)
	private TipoAutoridade autoridade;

	public AplicacaoPena() {
		super();
	}

	public AplicacaoPena(Long id, Funcionario funcionario, String processoAdministrativo, TipoAutoridade autoridade) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.processoAdministrativo = processoAdministrativo;
		this.autoridade = autoridade;
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

	public String getProcessoAdministrativo() {
		return processoAdministrativo;
	}

	public void setProcessoAdministrativo(String processoAdministrativo) {
		this.processoAdministrativo = processoAdministrativo;
	}

	public TipoAutoridade getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(TipoAutoridade autoridade) {
		this.autoridade = autoridade;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AplicacaoPena that = (AplicacaoPena) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(processoAdministrativo, that.processoAdministrativo) &&
                autoridade == that.autoridade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, funcionario, processoAdministrativo, autoridade);
    }

    @Override
	public String toString() {
		return "AplicacaoPena [id=" + id + ", funcionario=" + funcionario + ", processoAdministrativo="
				+ processoAdministrativo + ", autoridade=" + autoridade + "]";
	}

}