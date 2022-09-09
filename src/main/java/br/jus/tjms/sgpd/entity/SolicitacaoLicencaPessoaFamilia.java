package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoLicenca;
import br.jus.tjms.sgpd.enumerators.TipoLicenca;
import br.jus.tjms.sgpd.enumerators.TipoParentescoLicencaPessoaFamilia;
import br.jus.tjms.sgpd.enumerators.TipoSolicitacaoLicenca;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:04
 */
@Entity
@Auditavel
@Cacheable
@DiscriminatorValue("SOLICITACAO_LICENCA_PESSOA_FAMILIA")
public class SolicitacaoLicencaPessoaFamilia extends SolicitacaoLicenca {

	private static final long serialVersionUID = 2629254343672782527L;

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

	public SolicitacaoLicencaPessoaFamilia() {
		super();
	}

	public SolicitacaoLicencaPessoaFamilia(Long id, Funcionario solicitante, Date dataSolicitacao,
			TipoSolicitacaoLicenca tipoSolicitacao, Licenca licencaProrrogada, TipoLicenca tipoLicenca, String cid,
			Boolean comRemuneracao, Boolean comPermissaoExercicio, Date dataInicioLicenca, Integer numeroDiasLicenca,
			String motivo, Date dataRecebimento, SituacaoSolicitacaoLicenca situacao, Date dataSituacao,
			String parecer, String nomeEnfermo, Integer idade, TipoParentescoLicencaPessoaFamilia tipoParentesco,
			String condicoesEnfermo, Boolean outraPessoaPodeAcompanharOEnfermo, String porQue) {
		super(id, solicitante, dataSolicitacao, tipoSolicitacao, licencaProrrogada, tipoLicenca, cid, comRemuneracao,
				comPermissaoExercicio, dataInicioLicenca, numeroDiasLicenca, motivo, dataRecebimento, situacao,
				dataSituacao, parecer);
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
		SolicitacaoLicencaPessoaFamilia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(super.getId(), other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoLicencaPessoaFamilia [nomeEnfermo=" + nomeEnfermo + ", idade=" + idade + ", tipoParentesco="
				+ tipoParentesco + ", condicoesEnfermo=" + condicoesEnfermo + ", outraPessoaPodeAcompanharOEnfermo="
				+ outraPessoaPodeAcompanharOEnfermo + ", porQue=" + porQue + ", solicitacaoLicenca ="
				+ super.toString() + "]";
	}

}