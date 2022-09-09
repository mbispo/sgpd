package br.jus.tjms.sgpd.service.rest.v1.to;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.enumerators.LocalidadeTipo;

public class LocalidadeTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Integer codigoIBGE;
	private Integer codigoSICAP;	
	private LocalidadeTipo tipo;
	private EstadoTO estado;
	private RegiaoTO regiao;
	
	public LocalidadeTO() {
		super();
	}
	
	public LocalidadeTO(String nome, Integer codigoIBGE, Integer codigoSICAP, LocalidadeTipo tipo, 
			EstadoTO estado, RegiaoTO regiao) {
		super();
		this.nome = nome;
		this.codigoIBGE = codigoIBGE;
		this.codigoSICAP = codigoSICAP;
		this.tipo = tipo;
		this.estado = estado;
		this.regiao = regiao;
	}

	public LocalidadeTO(Long id, String nome, Integer codigoIBGE, Integer codigoSICAP, LocalidadeTipo tipo,
			EstadoTO estado, RegiaoTO regiao) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigoIBGE = codigoIBGE;
		this.codigoSICAP = codigoSICAP;
		this.tipo = tipo;
		this.estado = estado;
		this.regiao = regiao;
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

	public Integer getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(Integer codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public Integer getCodigoSICAP() {
		return codigoSICAP;
	}

	public void setCodigoSICAP(Integer codigoSICAP) {
		this.codigoSICAP = codigoSICAP;
	}

	public LocalidadeTipo getTipo() {
		return tipo;
	}

	public void setTipo(LocalidadeTipo tipo) {
		this.tipo = tipo;
	}

	public EstadoTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoTO estado) {
		this.estado = estado;
	}

	public RegiaoTO getRegiao() {
		return regiao;
	}

	public void setRegiao(RegiaoTO regiao) {
		this.regiao = regiao;
	}
	
	@Override
	public String toString() {
		return "LocalidadeTO [id=" + id + ", nome=" + nome + ", codigoIBGE=" + codigoIBGE + ", codigoSICAP="
				+ codigoSICAP + ", tipo=" + tipo + ", estado=" + estado + ", regiao=" + regiao
				+ "]";
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
		LocalidadeTO other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

}