package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.LocalidadeTipo;
import br.jus.tjms.sgpd.service.rest.v1.to.LocalidadeTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "localidade.buscarLocalidadesPorNome", 
			query = "SELECT l from Localidade l WHERE l.nome = :nome"),
})
public class Localidade implements Serializable {

	private static final long serialVersionUID = -7653452418873826464L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;
	
	@Column
	private Integer codigoIBGE;
	
	@Column
	private Integer codigoSICAP;

	@Enumerated(EnumType.ORDINAL)
	private LocalidadeTipo tipo;

	@ManyToOne
	@JoinColumn(name = "estado_id", nullable = true)
	private Estado estado;

	@ManyToOne
	@JoinColumn(name = "regiao_id", nullable = true)
	private Regiao regiao;

	public Localidade() {
		super();
	}

	public Localidade(Long id) {
		super();
		this.id = id;
	}



	public Localidade(Long id, String nome, Integer codigoIBGE, Integer codigoSICAP, LocalidadeTipo tipo,
			Estado estado, Regiao regiao) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigoIBGE = codigoIBGE;
		this.codigoSICAP = codigoSICAP;
		this.tipo = tipo;
		this.estado = estado;
		this.regiao = regiao;
	}

	public Localidade(LocalidadeTO localidadeTO) {
		this.id = localidadeTO.getId();
		this.nome = localidadeTO.getNome();
		this.tipo = localidadeTO.getTipo();
		this.codigoIBGE = localidadeTO.getCodigoIBGE();
		this.codigoSICAP = localidadeTO.getCodigoSICAP();
		
		if (localidadeTO.getEstado()!=null)
			this.estado = new Estado(localidadeTO.getEstado());
		
		if (localidadeTO.getRegiao()!=null)
			this.regiao = new Regiao(localidadeTO.getRegiao());
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
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
		Localidade other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Localidade [id=" + id + ", nome=" + nome + ", codigoIBGE=" + codigoIBGE + ", codigoSICAP=" + codigoSICAP
				+ ", tipo=" + tipo + ", estado=" + estado + ", regiao=" + regiao + "]";
	}

	public void alterar(LocalidadeTO localidadeTO) {
		this.nome = localidadeTO.getNome();
		this.tipo = localidadeTO.getTipo();
		//FIXME	this.cidade = localidadeTO.getCidade();
		//FIXME	this.estado = localidadeTO.getEstado();
		//FIXME	this.regiao = localidadeTO.getRegiao();
	}

	public LocalidadeTO toTO() {
		return new LocalidadeTO(id,nome,codigoIBGE,codigoSICAP,tipo,estado!=null?estado.toTO():null,regiao!=null?regiao.toTO():null);
	}

}