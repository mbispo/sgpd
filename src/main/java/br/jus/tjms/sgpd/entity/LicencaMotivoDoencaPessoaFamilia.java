package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoLicenca;
import br.jus.tjms.sgpd.enumerators.TipoAutoridade;
import br.jus.tjms.sgpd.enumerators.TipoLicenca;
import br.jus.tjms.sgpd.enumerators.TipoParentescoLicencaPessoaFamilia;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
@DiscriminatorValue("LICENCA_MOTIVO_DOENCA_PESSOA_FAMILIA")
public class LicencaMotivoDoencaPessoaFamilia extends Licenca {

	private static final long serialVersionUID = 5329235895126144294L;

	@Column(length = 255)
	private String nomeEnfermo;

	private Integer idade;

	@Enumerated(EnumType.ORDINAL)
	private TipoParentescoLicencaPessoaFamilia tipoParentesco;

	@Column(length = 500)
	private String condicoesEnfermo;

	private Boolean outraPessoaPodeAcompanharOEnfermo;

	@Column(length = 500)
	private String porQue;

	public LicencaMotivoDoencaPessoaFamilia() {
		super();
	}

	public LicencaMotivoDoencaPessoaFamilia(Long id, Funcionario funcionario, TipoLicenca tipoLicenca,
			ConcessaoLicenca concessao, AtoAdministrativo atoAdministrativo, String processo, String cid,
			TipoAutoridade autoridade, Licenca licencaProrrogada, Boolean comPermissaoExercicio,
			Boolean comRemuneracao, Boolean comOnus, Boolean descontaContagemTempo, Integer numeroDias, Date dataFim,
			Date dataInicio, SituacaoLicenca situacao, Date dataSituacao, String parecer, String nomeEnfermo,
			Integer idade, TipoParentescoLicencaPessoaFamilia tipoParentesco, String condicoesEnfermo,
			Boolean outraPessoaPodeAcompanharOEnfermo, String porQue) {
		super(id, funcionario, tipoLicenca, concessao, atoAdministrativo, processo, cid, autoridade, licencaProrrogada,
				comPermissaoExercicio, comRemuneracao, comOnus, descontaContagemTempo, numeroDias, dataInicio, dataFim,
				situacao, dataSituacao, parecer);
		this.nomeEnfermo = nomeEnfermo;
		this.idade = idade;
		this.tipoParentesco = tipoParentesco;
		this.condicoesEnfermo = condicoesEnfermo;
		this.outraPessoaPodeAcompanharOEnfermo = outraPessoaPodeAcompanharOEnfermo;
		this.porQue = porQue;
	}

	public String getNomeEnfermo() {
		return nomeEnfermo;
	}

	public void setNomeEnfermo(String nomeEnfermo) {
		this.nomeEnfermo = nomeEnfermo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public TipoParentescoLicencaPessoaFamilia getTipoParentesco() {
		return tipoParentesco;
	}

	public void setTipoParentesco(TipoParentescoLicencaPessoaFamilia tipoParentesco) {
		this.tipoParentesco = tipoParentesco;
	}

	public String getCondicoesEnfermo() {
		return condicoesEnfermo;
	}

	public void setCondicoesEnfermo(String condicoesEnfermo) {
		this.condicoesEnfermo = condicoesEnfermo;
	}

	public Boolean getOutraPessoaPodeAcompanharOEnfermo() {
		return outraPessoaPodeAcompanharOEnfermo;
	}

	public void setOutraPessoaPodeAcompanharOEnfermo(Boolean outraPessoaPodeAcompanharOEnfermo) {
		this.outraPessoaPodeAcompanharOEnfermo = outraPessoaPodeAcompanharOEnfermo;
	}

	public String getPorQue() {
		return porQue;
	}

	public void setPorQue(String porQue) {
		this.porQue = porQue;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(super.getId()).toHashCode();
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
		LicencaMotivoDoencaPessoaFamilia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(super.getId(), other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "LicencaMotivoDoencaPessoaFamilia [nomeEnfermo=" + nomeEnfermo + ", idade=" + idade
				+ ", tipoParentesco=" + tipoParentesco + ", condicoesEnfermo=" + condicoesEnfermo
				+ ", outraPessoaPodeAcompanharOEnfermo=" + outraPessoaPodeAcompanharOEnfermo + ", porQue=" + porQue
				+ ", licenca =" + super.toString() + "]";
	}

}