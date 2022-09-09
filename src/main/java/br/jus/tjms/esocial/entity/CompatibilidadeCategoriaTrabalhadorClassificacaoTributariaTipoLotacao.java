package br.jus.tjms.esocial.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.auditor.annotation.Auditavel;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:36
 */
@Entity
@Auditavel
@Cacheable
@Table(schema="esocial", name = "CompatCatTrabalhadorClassTribTipoLotacao")
public class CompatibilidadeCategoriaTrabalhadorClassificacaoTributariaTipoLotacao implements Serializable {

	private static final long serialVersionUID = 6950464383300708897L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "categoriaTrabalhador_id", nullable = false)
	private CategoriaTrabalhador categoriaTrabalhador;

	@ManyToOne
	@JoinColumn(name = "classificacaoTributaria_id", nullable = false)
	private ClassificacaoTributaria classificacaoTributaria;

	@ManyToOne
	@JoinColumn(name = "tipoLotacaoTributaria_id", nullable = false)
	private TipoLotacaoTributaria tipoLotacaoTributaria;

	public CompatibilidadeCategoriaTrabalhadorClassificacaoTributariaTipoLotacao() {
		super();
	}

	public CompatibilidadeCategoriaTrabalhadorClassificacaoTributariaTipoLotacao(Long id,
			CategoriaTrabalhador categoriaTrabalhador, ClassificacaoTributaria classificacaoTributaria,
			TipoLotacaoTributaria tipoLotacaoTributaria) {
		super();
		this.id = id;
		this.categoriaTrabalhador = categoriaTrabalhador;
		this.classificacaoTributaria = classificacaoTributaria;
		this.tipoLotacaoTributaria = tipoLotacaoTributaria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoriaTrabalhador getCategoriaTrabalhador() {
		return categoriaTrabalhador;
	}

	public void setCategoriaTrabalhador(CategoriaTrabalhador categoriaTrabalhador) {
		this.categoriaTrabalhador = categoriaTrabalhador;
	}

	public ClassificacaoTributaria getClassificacaoTributaria() {
		return classificacaoTributaria;
	}

	public void setClassificacaoTributaria(ClassificacaoTributaria classificacaoTributaria) {
		this.classificacaoTributaria = classificacaoTributaria;
	}

	public TipoLotacaoTributaria getTipoLotacaoTributaria() {
		return tipoLotacaoTributaria;
	}

	public void setTipoLotacaoTributaria(TipoLotacaoTributaria tipoLotacaoTributaria) {
		this.tipoLotacaoTributaria = tipoLotacaoTributaria;
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
		CompatibilidadeCategoriaTrabalhadorClassificacaoTributariaTipoLotacao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "CompatibilidadeCategoriaTrabalhadorClassificacaoTributariaTipoLotacao [id=" + id
				+ ", categoriaTrabalhador=" + categoriaTrabalhador + ", classificacaoTributaria="
				+ classificacaoTributaria + ", tipoLotacaoTributaria=" + tipoLotacaoTributaria + "]";
	}

}