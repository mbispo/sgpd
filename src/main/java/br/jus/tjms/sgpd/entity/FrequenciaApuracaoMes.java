package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.FrequenciaApuracaoMesTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "frequenciaApuracaoMes.buscarPorFuncionarioId", 
		query = "SELECT f FROM FrequenciaApuracaoMes f WHERE f.funcionario.id = :id order by f.ano, f.mes" ),	
	@NamedQuery(name = "frequenciaApuracaoMes.buscarPorFuncionarioIdAnoMes", 
		query = "SELECT f FROM FrequenciaApuracaoMes f WHERE f.funcionario.id = :id and f.ano = :ano and f.mes = :mes order by f.ano, f.mes"),
	@NamedQuery(name = "frequenciaApuracaoMes.buscarPorFuncionarioIdAno", 
		query = "SELECT f FROM FrequenciaApuracaoMes f WHERE f.funcionario.id = :id and f.ano = :ano order by f.ano, f.mes")
})
public class FrequenciaApuracaoMes implements Serializable {

	private static final long serialVersionUID = -4753716984879213625L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Integer ano;
	private Integer mes;
	private Date referenciaInicio;
	private Date referenciaFim;
	private Boolean apurado;
	private Date dataApuracao;

	public FrequenciaApuracaoMes() {
		super();
	}

	public FrequenciaApuracaoMes(Long id, Funcionario funcionario, Integer ano, Integer mes, Date referenciaInicio,
			Date referenciaFim, Boolean apurado, Date dataApuracao) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.ano = ano;
		this.mes = mes;
		this.referenciaInicio = referenciaInicio;
		this.referenciaFim = referenciaFim;
		this.apurado = apurado;
		this.dataApuracao = dataApuracao;
	}
	
	public FrequenciaApuracaoMes(Long id) {
		super();
		this.id = id;
	}

	public FrequenciaApuracaoMes(FrequenciaApuracaoMesTO to) {
		this.id = to.getId();
		this.funcionario = new Funcionario(to.getFuncionarioId());
		this.ano = to.getAno();
		this.mes = to.getMes();
		this.referenciaInicio = to.getReferenciaInicio();
		this.referenciaFim = to.getReferenciaFim();
		this.apurado = to.getApurado();
		this.dataApuracao = to.getDataApuracao();		
	}
	
	public void alterar(FrequenciaApuracaoMesTO to) {
		this.funcionario = new Funcionario(to.getFuncionarioId());
		this.ano = to.getAno();
		this.mes = to.getMes();
		this.referenciaInicio = to.getReferenciaInicio();
		this.referenciaFim = to.getReferenciaFim();
		this.apurado = to.getApurado();
		this.dataApuracao = to.getDataApuracao();				
	}
	
	public FrequenciaApuracaoMesTO toTO() {
		return new FrequenciaApuracaoMesTO(id, funcionario.getId(), ano, mes, referenciaInicio,
				referenciaFim, apurado, dataApuracao);
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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Date getReferenciaInicio() {
		return referenciaInicio;
	}

	public void setReferenciaInicio(Date referenciaInicio) {
		this.referenciaInicio = referenciaInicio;
	}

	public Date getReferenciaFim() {
		return referenciaFim;
	}

	public void setReferenciaFim(Date referenciaFim) {
		this.referenciaFim = referenciaFim;
	}

	public Boolean getApurado() {
		return apurado;
	}

	public void setApurado(Boolean apurado) {
		this.apurado = apurado;
	}

	public Date getDataApuracao() {
		return dataApuracao;
	}

	public void setDataApuracao(Date dataApuracao) {
		this.dataApuracao = dataApuracao;
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
		FrequenciaApuracaoMes other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FrequenciaApuracaoMes [id=" + id + ", funcionario=" + funcionario + ", ano=" + ano + ", mes=" + mes
				+ ", referenciaInicio=" + referenciaInicio + ", referenciaFim=" + referenciaFim + ", apurado="
				+ apurado + ", dataApuracao=" + dataApuracao + "]";
	}

}