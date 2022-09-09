package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:05
 */
@Entity
@Auditavel
@Cacheable
public class Suspensao implements Serializable {

	private static final long serialVersionUID = 6407873483786571084L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aplicacaoPena_id", nullable = true)
	private AplicacaoPena aplicacaoPena;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	private Date dataFinal;
	private Date dataInicial;
	private Integer numeroDias;

	@Column(length = 500)
	private String observacoes;

	public Suspensao() {
		super();
	}

	public Suspensao(Long id, AplicacaoPena aplicacaoPena, Funcionario funcionario, AtoAdministrativo ato,
			Date dataFinal, Date dataInicial, Integer numeroDias, String observacoes) {
		super();
		this.id = id;
		this.aplicacaoPena = aplicacaoPena;
		this.funcionario = funcionario;
		this.ato = ato;
		this.dataFinal = dataFinal;
		this.dataInicial = dataInicial;
		this.numeroDias = numeroDias;
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

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		Suspensao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Suspensao [id=" + id + ", aplicacaoPena=" + aplicacaoPena + ", funcionario=" + funcionario + ", ato="
				+ ato + ", dataFinal=" + dataFinal + ", dataInicial=" + dataInicial + ", numeroDias=" + numeroDias
				+ ", observacoes=" + observacoes + "]";
	}

}