package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoParticipacaoComissaoLicitacao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
public class ParticipacaoComissaoLicitacao implements Serializable {

	private static final long serialVersionUID = 344411068290125947L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "participante_id", nullable = false)
	private Funcionario participante;

	@ManyToOne
	@JoinColumn(name = "comissao_id", nullable = false)
	private ComissaoLicitacao comissao;

	@Enumerated(EnumType.ORDINAL)
	private TipoParticipacaoComissaoLicitacao tipo;

	private Date data;

	public ParticipacaoComissaoLicitacao() {
		super();
	}

	public ParticipacaoComissaoLicitacao(Long id, Funcionario participante, ComissaoLicitacao comissao,
			TipoParticipacaoComissaoLicitacao tipo, Date data) {
		super();
		this.id = id;
		this.participante = participante;
		this.comissao = comissao;
		this.tipo = tipo;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getParticipante() {
		return participante;
	}

	public void setParticipante(Funcionario participante) {
		this.participante = participante;
	}

	public ComissaoLicitacao getComissao() {
		return comissao;
	}

	public void setComissao(ComissaoLicitacao comissao) {
		this.comissao = comissao;
	}

	public TipoParticipacaoComissaoLicitacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoParticipacaoComissaoLicitacao tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		ParticipacaoComissaoLicitacao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ParticipacaoComissaoLicitacao [id=" + id + ", participante=" + participante + ", comissao=" + comissao
				+ ", tipo=" + tipo + ", data=" + data + "]";
	}

}