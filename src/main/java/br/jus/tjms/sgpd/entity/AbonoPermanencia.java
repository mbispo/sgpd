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
public class AbonoPermanencia implements Serializable {

	private static final long serialVersionUID = 8102907171947415649L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "solicitacao_id", nullable = true, unique = true)
	private SolicitacaoAbonoPermanencia solicitacao;

	private Date dataEfeito;

	@Column(length = 60)
	private String processo;

	@Enumerated(EnumType.ORDINAL)
	private TipoAutoridade autoridade;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	public AbonoPermanencia() {
		super();
	}

	public AbonoPermanencia(Long id, Funcionario funcionario, SolicitacaoAbonoPermanencia solicitacao, Date dataEfeito,
			String processo, TipoAutoridade autoridade, AtoAdministrativo atoAdministrativo) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.solicitacao = solicitacao;
		this.dataEfeito = dataEfeito;
		this.processo = processo;
		this.autoridade = autoridade;
		this.atoAdministrativo = atoAdministrativo;
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

	public SolicitacaoAbonoPermanencia getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoAbonoPermanencia solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
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

	public AtoAdministrativo getAtoAdministrativo() {
		return atoAdministrativo;
	}

	public void setAtoAdministrativo(AtoAdministrativo atoAdministrativo) {
		this.atoAdministrativo = atoAdministrativo;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbonoPermanencia that = (AbonoPermanencia) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(solicitacao, that.solicitacao) &&
                Objects.equals(dataEfeito, that.dataEfeito) &&
                Objects.equals(processo, that.processo) &&
                autoridade == that.autoridade &&
                Objects.equals(atoAdministrativo, that.atoAdministrativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, funcionario, solicitacao, dataEfeito, processo, autoridade, atoAdministrativo);
    }

    @Override
	public String toString() {
		return "AbonoPermanencia [id=" + id + ", funcionario=" + funcionario + ", solicitacao=" + solicitacao
				+ ", dataEfeito=" + dataEfeito + ", processo=" + processo + ", autoridade=" + autoridade
				+ ", atoAdministrativo=" + atoAdministrativo + "]";
	}

}