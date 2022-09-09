package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoLogFrequenciaApuracao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:58
 */
@Entity
@Auditavel
@Cacheable
public class FrequenciaApuracaoDiaLog implements Serializable {

	private static final long serialVersionUID = 7676172248279324584L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "apuracaoDia_id", nullable = false)
	private FrequenciaApuracaoDia apuracaoDia;

	@Column(length = 200)
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	private TipoLogFrequenciaApuracao tipoLog;

	@Column(length = 500)
	private String mensagem;

	public FrequenciaApuracaoDiaLog() {
		super();
	}

	public FrequenciaApuracaoDiaLog(Long id, FrequenciaApuracaoDia apuracaoDia, String descricao,
			TipoLogFrequenciaApuracao tipoLog, String mensagem) {
		super();
		this.id = id;
		this.apuracaoDia = apuracaoDia;
		this.descricao = descricao;
		this.tipoLog = tipoLog;
		this.mensagem = mensagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FrequenciaApuracaoDia getApuracaoDia() {
		return apuracaoDia;
	}

	public void setApuracaoDia(FrequenciaApuracaoDia apuracaoDia) {
		this.apuracaoDia = apuracaoDia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoLogFrequenciaApuracao getTipoLog() {
		return tipoLog;
	}

	public void setTipoLog(TipoLogFrequenciaApuracao tipoLog) {
		this.tipoLog = tipoLog;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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
		FrequenciaApuracaoDiaLog other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "FrequenciaApuracaoDiaLog [id=" + id + ", apuracaoDia=" + apuracaoDia + ", descricao=" + descricao
				+ ", tipoLog=" + tipoLog + ", mensagem=" + mensagem + "]";
	}

}