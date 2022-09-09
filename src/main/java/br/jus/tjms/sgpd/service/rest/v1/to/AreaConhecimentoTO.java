package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.TipoAreaConhecimento;

public class AreaConhecimentoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private TipoAreaConhecimento tipo;
	private Long areaConhecimentoSuperiorId;
	private String nome;
	private String descricao;

	public AreaConhecimentoTO() {
		super();
	}

	public AreaConhecimentoTO(Long id, TipoAreaConhecimento tipo, Long areaConhecimentoSuperiorId, String nome,
			String descricao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.areaConhecimentoSuperiorId = areaConhecimentoSuperiorId;
		this.nome = nome;
		this.descricao = descricao;
	}

	public AreaConhecimentoTO(TipoAreaConhecimento tipo, Long areaConhecimentoSuperiorId, String nome,
			String descricao) {
		super();
		this.tipo = tipo;
		this.areaConhecimentoSuperiorId = areaConhecimentoSuperiorId;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoAreaConhecimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoAreaConhecimento tipo) {
		this.tipo = tipo;
	}

	public Long getAreaConhecimentoSuperiorId() {
		return areaConhecimentoSuperiorId;
	}

	public void setAreaConhecimentoSuperiorId(Long areaConhecimentoSuperiorId) {
		this.areaConhecimentoSuperiorId = areaConhecimentoSuperiorId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "AreaConhecimentoTO [id=" + id + ", tipo=" + tipo + ", areaConhecimentoSuperiorId="
				+ areaConhecimentoSuperiorId + ", nome=" + nome + ", descricao=" + descricao + "]";
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
		AreaConhecimentoTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}