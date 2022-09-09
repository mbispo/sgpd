package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoTransporteLinha;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
public class RequerimentoAuxilioTransporteLinha implements Serializable {

	private static final long serialVersionUID = -8390104135202796784L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="requerimento_id", nullable = false)
	private RequerimentoAuxilioTransporte requerimento;
	
	private Integer sequencia;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoTransporteLinha tipo;
	
	@Column(length = 200)
	private String linha;
	
	@Column(length = 255)
	private String descricao;
	
	private Boolean requerPasse;

	public RequerimentoAuxilioTransporteLinha() {
		super();
	}

	public RequerimentoAuxilioTransporteLinha(Long id, RequerimentoAuxilioTransporte requerimento, Integer sequencia,
			TipoTransporteLinha tipo, String linha, String descricao, Boolean requerPasse) {
		super();
		this.id = id;
		this.requerimento = requerimento;
		this.sequencia = sequencia;
		this.tipo = tipo;
		this.linha = linha;
		this.descricao = descricao;
		this.requerPasse = requerPasse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RequerimentoAuxilioTransporte getRequerimento() {
		return requerimento;
	}

	public void setRequerimento(RequerimentoAuxilioTransporte requerimento) {
		this.requerimento = requerimento;
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

	public TipoTransporteLinha getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransporteLinha tipo) {
		this.tipo = tipo;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getRequerPasse() {
		return requerPasse;
	}

	public void setRequerPasse(Boolean requerPasse) {
		this.requerPasse = requerPasse;
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
		RequerimentoAuxilioTransporteLinha other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}
	
	@Override
	public String toString() {
		return "RequerimentoAuxilioTransporteLinha [id=" + id + ", requerimento=" + requerimento + ", sequencia="
				+ sequencia + ", tipo=" + tipo + ", linha=" + linha + ", descricao=" + descricao + ", requerPasse="
				+ requerPasse + "]";
	}

}