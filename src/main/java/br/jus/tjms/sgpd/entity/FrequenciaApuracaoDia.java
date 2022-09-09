package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.service.rest.v1.to.FrequenciaApuracaoDiaTO;
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
	@NamedQuery(name = "frequenciaApuracaoDia.buscarPorFrequenciaApuracaoMesId", 
		query = "SELECT f FROM FrequenciaApuracaoDia f WHERE f.apuracaoMes.id = :id order by f.sequencial")
})
public class FrequenciaApuracaoDia implements Serializable {

	private static final long serialVersionUID = 2221795670669131643L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "apuracaoMes_id", nullable = false)
	private FrequenciaApuracaoMes apuracaoMes;

	private Integer dia;
	private Integer sequencial;
	private Date inicioReferencia;
	private Date fimReferencia;
	private Date data;

	@Column(length = 200)
	private String descricao;

	@Column(length = 500)
	private String observacoes;

	public FrequenciaApuracaoDia() {
		super();
	}

	public FrequenciaApuracaoDia(Long id, FrequenciaApuracaoMes apuracaoMes, Integer dia, Integer sequencial,
			Date inicioReferencia, Date fimReferencia, Date data, String descricao, String observacoes) {
		super();
		this.id = id;
		this.apuracaoMes = apuracaoMes;
		this.dia = dia;
		this.sequencial = sequencial;
		this.inicioReferencia = inicioReferencia;
		this.fimReferencia = fimReferencia;
		this.data = data;
		this.descricao = descricao;
		this.observacoes = observacoes;
	}
	
	public FrequenciaApuracaoDia(Long id) {
		super();
		this.id = id;
	}

	public FrequenciaApuracaoDia(FrequenciaApuracaoDiaTO to) {
		super();
		this.id = to.getId();
		this.apuracaoMes = new FrequenciaApuracaoMes(to.getFrequenciaApuracaoMesId());
		this.dia = to.getDia();
		this.sequencial = to.getSequencial();
		this.inicioReferencia = to.getInicioReferencia();
		this.fimReferencia = to.getFimReferencia();
		this.data = to.getData();
		this.descricao = to.getDescricao();
		this.observacoes = to.getObservacoes();
	}
	
	public void alterar(FrequenciaApuracaoDiaTO to) {
		this.apuracaoMes = new FrequenciaApuracaoMes(to.getFrequenciaApuracaoMesId());
		this.dia = to.getDia();
		this.sequencial = to.getSequencial();
		this.inicioReferencia = to.getInicioReferencia();
		this.fimReferencia = to.getFimReferencia();
		this.data = to.getData();
		this.descricao = to.getDescricao();
		this.observacoes = to.getObservacoes();		
	}
	
	public FrequenciaApuracaoDiaTO toTO() {
		return new FrequenciaApuracaoDiaTO(id, apuracaoMes.getId(), dia, sequencial,
				inicioReferencia, fimReferencia, data, descricao, observacoes); 		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FrequenciaApuracaoMes getApuracaoMes() {
		return apuracaoMes;
	}

	public void setApuracaoMes(FrequenciaApuracaoMes apuracaoMes) {
		this.apuracaoMes = apuracaoMes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public Date getInicioReferencia() {
		return inicioReferencia;
	}

	public void setInicioReferencia(Date inicioReferencia) {
		this.inicioReferencia = inicioReferencia;
	}

	public Date getFimReferencia() {
		return fimReferencia;
	}

	public void setFimReferencia(Date fimReferencia) {
		this.fimReferencia = fimReferencia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		FrequenciaApuracaoDia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FrequenciaApuracaoDia [id=" + id + ", apuracaoMes=" + apuracaoMes + ", dia=" + dia + ", sequencial="
				+ sequencial + ", inicioReferencia=" + inicioReferencia + ", fimReferencia=" + fimReferencia
				+ ", data=" + data + ", descricao=" + descricao + ", observacoes=" + observacoes + "]";
	}

}