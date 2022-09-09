package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
public class MensagemPagamento implements Serializable {

	private static final long serialVersionUID = -1107549116992380880L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Boolean hollerith;

	@Column(length = 500)
	private String mensagem;

	private Date dataFim;
	private Date dataInicio;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Boolean fichaFinanceira;

	public MensagemPagamento() {
		super();
	}

	public MensagemPagamento(Long id, Boolean hollerith, String mensagem, Date dataFim, Date dataInicio,
			Funcionario funcionario, Boolean fichaFinanceira) {
		super();
		this.id = id;
		this.hollerith = hollerith;
		this.mensagem = mensagem;
		this.dataFim = dataFim;
		this.dataInicio = dataInicio;
		this.funcionario = funcionario;
		this.fichaFinanceira = fichaFinanceira;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getHollerith() {
		return hollerith;
	}

	public void setHollerith(Boolean hollerith) {
		this.hollerith = hollerith;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Boolean getFichaFinanceira() {
		return fichaFinanceira;
	}

	public void setFichaFinanceira(Boolean fichaFinanceira) {
		this.fichaFinanceira = fichaFinanceira;
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
		MensagemPagamento other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "MensagemPagamento [id=" + id + ", hollerith=" + hollerith + ", mensagem=" + mensagem + ", dataFim="
				+ dataFim + ", dataInicio=" + dataInicio + ", funcionario=" + funcionario + ", fichaFinanceira="
				+ fichaFinanceira + "]";
	}

}