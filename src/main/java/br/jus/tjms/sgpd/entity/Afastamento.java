package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Date;
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
public class Afastamento implements Serializable {

	private static final long serialVersionUID = -3321278369951895797L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Date dataInicial;
	private Date dataFinal;

	private Integer numeroDias;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@Column(length = 60)
	private String processo;

	@Enumerated(EnumType.ORDINAL)
	private TipoAutoridade autoridade;

	public Afastamento() {
		super();
	}

	public Afastamento(Long id, Funcionario funcionario, Date dataInicial, Date dataFinal, Integer numeroDias,
			AtoAdministrativo atoAdministrativo, String processo, TipoAutoridade autoridade) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.numeroDias = numeroDias;
		this.atoAdministrativo = atoAdministrativo;
		this.processo = processo;
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

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
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
        Afastamento that = (Afastamento) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(dataInicial, that.dataInicial) &&
                Objects.equals(dataFinal, that.dataFinal) &&
                Objects.equals(numeroDias, that.numeroDias) &&
                Objects.equals(atoAdministrativo, that.atoAdministrativo) &&
                Objects.equals(processo, that.processo) &&
                autoridade == that.autoridade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, funcionario, dataInicial, dataFinal, numeroDias, atoAdministrativo, processo, autoridade);
    }

    @Override
	public String toString() {
		return "Afastamento [id=" + id + ", funcionario=" + funcionario + ", dataInicial=" + dataInicial
				+ ", dataFinal=" + dataFinal + ", numeroDias=" + numeroDias + ", atoAdministrativo="
				+ atoAdministrativo + ", processo=" + processo + ", autoridade=" + autoridade + "]";
	}

}