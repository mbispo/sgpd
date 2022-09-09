package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoOcorrenciaRequisicaoDiaria;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
public class RequisicaoDiariaOcorrencias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "requisicao_id", nullable = false)
	private RequisicaoDiarias requisicao;

	private Date data;

	@Enumerated(EnumType.ORDINAL)
	private TipoOcorrenciaRequisicaoDiaria tipoOcorrencia;

	public RequisicaoDiariaOcorrencias() {
		super();
	}

	public RequisicaoDiariaOcorrencias(Long id, RequisicaoDiarias requisicao, Date data,
			TipoOcorrenciaRequisicaoDiaria tipoOcorrencia) {
		super();
		this.id = id;
		this.requisicao = requisicao;
		this.data = data;
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RequisicaoDiarias getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(RequisicaoDiarias requisicao) {
		this.requisicao = requisicao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoOcorrenciaRequisicaoDiaria getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(TipoOcorrenciaRequisicaoDiaria tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
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
		RequisicaoDiariaOcorrencias other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RequisicaoDiariaOcorrencias [id=" + id + ", requisicao=" + requisicao + ", data=" + data
				+ ", tipoOcorrencia=" + tipoOcorrencia + "]";
	}

}