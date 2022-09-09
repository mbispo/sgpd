package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoSolicitacaoReadaptacao;
import br.jus.tjms.sgpd.enumerators.TipoReadaptacao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:04
 */
@Entity
@Auditavel
@Cacheable
public class SolicitacaoReadaptacao implements Serializable {

	private static final long serialVersionUID = -5108478464800100010L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "juntaMedica_id", nullable = false)
	private JuntaMedica juntaMedica;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Date data;

	@Enumerated(EnumType.ORDINAL)
	private TipoReadaptacao tipo;

	private Integer numeroDias;
	private Date dataInicio;
	private Date dataFim;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoSolicitacaoReadaptacao situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	public SolicitacaoReadaptacao() {
		super();
	}

	public SolicitacaoReadaptacao(Long id, JuntaMedica juntaMedica, Funcionario funcionario, Date data,
			TipoReadaptacao tipo, Integer numeroDias, Date dataInicio, Date dataFim,
			SituacaoSolicitacaoReadaptacao situacao, Date dataSituacao, String parecer) {
		super();
		this.id = id;
		this.juntaMedica = juntaMedica;
		this.funcionario = funcionario;
		this.data = data;
		this.tipo = tipo;
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

	public JuntaMedica getJuntaMedica() {
		return juntaMedica;
	}

	public void setJuntaMedica(JuntaMedica juntaMedica) {
		this.juntaMedica = juntaMedica;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoReadaptacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoReadaptacao tipo) {
		this.tipo = tipo;
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

	public SituacaoSolicitacaoReadaptacao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoSolicitacaoReadaptacao situacao) {
		this.situacao = situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
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
		SolicitacaoReadaptacao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "SolicitacaoReadaptacao [id=" + id + ", juntaMedica=" + juntaMedica + ", funcionario=" + funcionario
				+ ", data=" + data + ", tipo=" + tipo + ", numeroDias=" + numeroDias + ", dataInicio=" + dataInicio
				+ ", dataFim=" + dataFim + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao + ", parecer="
				+ parecer + "]";
	}

}