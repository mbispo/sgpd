package br.jus.tjms.sgpd.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoAreaConhecimento;
import br.jus.tjms.sgpd.service.rest.v1.to.AreaConhecimentoTO;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:56
 */
@Entity
@Auditavel
@Cacheable
public class AreaConhecimento implements Serializable {

	private static final long serialVersionUID = -281346160493180709L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	private TipoAreaConhecimento tipo;

	@ManyToOne
	@JoinColumn(name = "areaConhecimentoSuperior_id", nullable = true)
	private AreaConhecimento areaConhecimentoSuperior;

	@Column(length = 200)
	private String nome;

	@Column(length = 200)
	private String descricao;

	public AreaConhecimento() {
		super();
	}

	public AreaConhecimento(Long id, TipoAreaConhecimento tipo, AreaConhecimento areaConhecimentoSuperior, String nome,
			String descricao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.areaConhecimentoSuperior = areaConhecimentoSuperior;
		this.nome = nome;
		this.descricao = descricao;
	}

	public AreaConhecimento(AreaConhecimentoTO areaConhecimentoTO) {
		super();
		this.tipo = areaConhecimentoTO.getTipo();
		//FIXME this.areaConhecimentoSuperior = areaConhecimentoTO.getAreaConhecimentoSuperiorId();
		this.nome = areaConhecimentoTO.getNome();
		this.descricao = areaConhecimentoTO.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaConhecimento that = (AreaConhecimento) o;
        return Objects.equals(id, that.id) &&
                tipo == that.tipo &&
                Objects.equals(areaConhecimentoSuperior, that.areaConhecimentoSuperior) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, areaConhecimentoSuperior, nome, descricao);
    }

    @Override
	public String toString() {
		return "AreaConhecimento [id=" + id + ", tipo=" + tipo + ", areaConhecimentoSuperior="
				+ areaConhecimentoSuperior + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

	public void alterar(AreaConhecimentoTO areaConhecimentoTO) {
		this.tipo = areaConhecimentoTO.getTipo();
		//FIXME this.areaConhecimentoSuperior = areaConhecimentoTO.getAreaConhecimentoSuperiorId();
		this.nome = areaConhecimentoTO.getNome();
		this.descricao = areaConhecimentoTO.getDescricao();
	}

}