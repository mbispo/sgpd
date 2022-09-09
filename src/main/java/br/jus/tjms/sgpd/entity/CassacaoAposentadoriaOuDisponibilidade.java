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
public class CassacaoAposentadoriaOuDisponibilidade implements Serializable {

	private static final long serialVersionUID = 8005404706856906460L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aplicacaoPena_id", nullable = true)
	private AplicacaoPena aplicacaoPena;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Date dataEfeito;
	private Integer numeroDias;

	@Column(length = 500)
	private String observacoes;

	public CassacaoAposentadoriaOuDisponibilidade() {
		super();
	}

	public CassacaoAposentadoriaOuDisponibilidade(Long id, AplicacaoPena aplicacaoPena, AtoAdministrativo ato,
			Funcionario funcionario, Date dataEfeito, Integer numeroDias, String observacoes) {
		super();
		this.id = id;
		this.aplicacaoPena = aplicacaoPena;
		this.ato = ato;
		this.funcionario = funcionario;
		this.dataEfeito = dataEfeito;
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

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
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
		CassacaoAposentadoriaOuDisponibilidade other = (CassacaoAposentadoriaOuDisponibilidade) obj;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CassacaoAposentadoriaOuDisponibilidade [id=" + id + ", aplicacaoPena=" + aplicacaoPena + ", ato=" + ato
				+ ", funcionario=" + funcionario + ", numeroDias=" + numeroDias + ", observacoes=" + observacoes + "]";
	}

}