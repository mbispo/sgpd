package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
public class ParametrosFrequencia implements Serializable {

	private static final long serialVersionUID = -1194366036333483536L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer intervaloEnvioDigitais;
	private Integer intervaloEnvioRegistroPonto;
	private Integer intervaloRecebimentoDigitais;
	private Integer intervaloEnvioRegistroOperacoes;
	private Integer nivelToleranciaVerificacao;
	private Integer diasEnvioDigitais;
	private Integer intervaloSincronizacaoRelogio;

	@Column(length = 255)
	private String senhaMasterMD5;

	public ParametrosFrequencia() {
		super();
	}

	public ParametrosFrequencia(Long id, Integer intervaloEnvioDigitais, Integer intervaloEnvioRegistroPonto,
			Integer intervaloRecebimentoDigitais, Integer intervaloEnvioRegistroOperacoes,
			Integer nivelToleranciaVerificacao, Integer diasEnvioDigitais, Integer intervaloSincronizacaoRelogio,
			String senhaMasterMD5) {
		super();
		this.id = id;
		this.intervaloEnvioDigitais = intervaloEnvioDigitais;
		this.intervaloEnvioRegistroPonto = intervaloEnvioRegistroPonto;
		this.intervaloRecebimentoDigitais = intervaloRecebimentoDigitais;
		this.intervaloEnvioRegistroOperacoes = intervaloEnvioRegistroOperacoes;
		this.nivelToleranciaVerificacao = nivelToleranciaVerificacao;
		this.diasEnvioDigitais = diasEnvioDigitais;
		this.intervaloSincronizacaoRelogio = intervaloSincronizacaoRelogio;
		this.senhaMasterMD5 = senhaMasterMD5;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIntervaloEnvioDigitais() {
		return intervaloEnvioDigitais;
	}

	public void setIntervaloEnvioDigitais(Integer intervaloEnvioDigitais) {
		this.intervaloEnvioDigitais = intervaloEnvioDigitais;
	}

	public Integer getIntervaloEnvioRegistroPonto() {
		return intervaloEnvioRegistroPonto;
	}

	public void setIntervaloEnvioRegistroPonto(Integer intervaloEnvioRegistroPonto) {
		this.intervaloEnvioRegistroPonto = intervaloEnvioRegistroPonto;
	}

	public Integer getIntervaloRecebimentoDigitais() {
		return intervaloRecebimentoDigitais;
	}

	public void setIntervaloRecebimentoDigitais(Integer intervaloRecebimentoDigitais) {
		this.intervaloRecebimentoDigitais = intervaloRecebimentoDigitais;
	}

	public Integer getIntervaloEnvioRegistroOperacoes() {
		return intervaloEnvioRegistroOperacoes;
	}

	public void setIntervaloEnvioRegistroOperacoes(Integer intervaloEnvioRegistroOperacoes) {
		this.intervaloEnvioRegistroOperacoes = intervaloEnvioRegistroOperacoes;
	}

	public Integer getNivelToleranciaVerificacao() {
		return nivelToleranciaVerificacao;
	}

	public void setNivelToleranciaVerificacao(Integer nivelToleranciaVerificacao) {
		this.nivelToleranciaVerificacao = nivelToleranciaVerificacao;
	}

	public Integer getDiasEnvioDigitais() {
		return diasEnvioDigitais;
	}

	public void setDiasEnvioDigitais(Integer diasEnvioDigitais) {
		this.diasEnvioDigitais = diasEnvioDigitais;
	}

	public Integer getIntervaloSincronizacaoRelogio() {
		return intervaloSincronizacaoRelogio;
	}

	public void setIntervaloSincronizacaoRelogio(Integer intervaloSincronizacaoRelogio) {
		this.intervaloSincronizacaoRelogio = intervaloSincronizacaoRelogio;
	}

	public String getSenhaMasterMD5() {
		return senhaMasterMD5;
	}

	public void setSenhaMasterMD5(String senhaMasterMD5) {
		this.senhaMasterMD5 = senhaMasterMD5;
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
		ParametrosFrequencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ParametrosFrequencia [id=" + id + ", intervaloEnvioDigitais=" + intervaloEnvioDigitais
				+ ", intervaloEnvioRegistroPonto=" + intervaloEnvioRegistroPonto + ", intervaloRecebimentoDigitais="
				+ intervaloRecebimentoDigitais + ", intervaloEnvioRegistroOperacoes=" + intervaloEnvioRegistroOperacoes
				+ ", nivelToleranciaVerificacao=" + nivelToleranciaVerificacao + ", diasEnvioDigitais="
				+ diasEnvioDigitais + ", intervaloSincronizacaoRelogio=" + intervaloSincronizacaoRelogio
				+ ", senhaMasterMD5=" + senhaMasterMD5 + "]";
	}

}