package br.jus.tjms.sgpd.entity;

import br.jus.tjms.sgpd.enumerators.SituacaoLicenca;
import br.jus.tjms.sgpd.enumerators.TipoAutoridade;
import br.jus.tjms.sgpd.enumerators.TipoLicenca;
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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "discriminador")
@DiscriminatorValue("LICENCA")
public class Licenca implements Serializable {

	private static final long serialVersionUID = 1031635776866830686L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@Enumerated(EnumType.ORDINAL)
	private TipoLicenca tipoLicenca;

	@ManyToOne
	@JoinColumn(name = "concessao_id", nullable = true)
	private ConcessaoLicenca concessao;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo atoAdministrativo;

	@Column(length = 60)
	private String processo;

	@Column(length = 20)
	private String cid;

	@Enumerated(EnumType.ORDINAL)
	private TipoAutoridade autoridade;

	@ManyToOne
	@JoinColumn(name = "licencaProrrogada_id", nullable = true)
	private Licenca licencaProrrogada;

	private Boolean comPermissaoExercicio;
	private Boolean comRemuneracao;
	private Boolean comOnus;
	private Boolean descontaContagemTempo;
	private Integer numeroDias;

	private Date dataInicio;
	private Date dataFim;
	
	@Enumerated(EnumType.ORDINAL)
	private SituacaoLicenca situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public Licenca() {
		super();
	}

	public Licenca(Long id, Funcionario funcionario, TipoLicenca tipoLicenca, ConcessaoLicenca concessao,
			AtoAdministrativo atoAdministrativo, String processo, String cid, TipoAutoridade autoridade,
			Licenca licencaProrrogada, Boolean comPermissaoExercicio, Boolean comRemuneracao, Boolean comOnus,
			Boolean descontaContagemTempo, Integer numeroDias, Date dataInicio, Date dataFim, SituacaoLicenca situacao,
			Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.tipoLicenca = tipoLicenca;
		this.concessao = concessao;
		this.atoAdministrativo = atoAdministrativo;
		this.processo = processo;
		this.cid = cid;
		this.autoridade = autoridade;
		this.licencaProrrogada = licencaProrrogada;
		this.comPermissaoExercicio = comPermissaoExercicio;
		this.comRemuneracao = comRemuneracao;
		this.comOnus = comOnus;
		this.descontaContagemTempo = descontaContagemTempo;
		this.numeroDias = numeroDias;
		
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
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

	public TipoLicenca getTipoLicenca() {
		return tipoLicenca;
	}

	public void setTipoLicenca(TipoLicenca tipoLicenca) {
		this.tipoLicenca = tipoLicenca;
	}

	public ConcessaoLicenca getConcessao() {
		return concessao;
	}

	public void setConcessao(ConcessaoLicenca concessao) {
		this.concessao = concessao;
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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public TipoAutoridade getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(TipoAutoridade autoridade) {
		this.autoridade = autoridade;
	}

	public Licenca getLicencaProrrogada() {
		return licencaProrrogada;
	}

	public void setLicencaProrrogada(Licenca licencaProrrogada) {
		this.licencaProrrogada = licencaProrrogada;
	}

	public Boolean getComPermissaoExercicio() {
		return comPermissaoExercicio;
	}

	public void setComPermissaoExercicio(Boolean comPermissaoExercicio) {
		this.comPermissaoExercicio = comPermissaoExercicio;
	}

	public Boolean getComRemuneracao() {
		return comRemuneracao;
	}

	public void setComRemuneracao(Boolean comRemuneracao) {
		this.comRemuneracao = comRemuneracao;
	}

	public Boolean getComOnus() {
		return comOnus;
	}

	public void setComOnus(Boolean comOnus) {
		this.comOnus = comOnus;
	}

	public Boolean getDescontaContagemTempo() {
		return descontaContagemTempo;
	}

	public void setDescontaContagemTempo(Boolean descontaContagemTempo) {
		this.descontaContagemTempo = descontaContagemTempo;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoLicenca getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoLicenca situacao) {
		this.situacao = situacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
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
		Licenca other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Licenca [id=" + id + ", funcionario=" + funcionario + ", tipoLicenca=" + tipoLicenca + ", concessao="
				+ concessao + ", atoAdministrativo=" + atoAdministrativo + ", processo=" + processo + ", cid=" + cid
				+ ", autoridade=" + autoridade + ", licencaProrrogada=" + licencaProrrogada
				+ ", comPermissaoExercicio=" + comPermissaoExercicio + ", comRemuneracao=" + comRemuneracao
				+ ", comOnus=" + comOnus + ", descontaContagemTempo=" + descontaContagemTempo + ", numeroDias="
				+ numeroDias + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", situacao=" + situacao
				+ ", dataSituacao=" + dataSituacao + ", parecer=" + parecer + "]";
	}

}