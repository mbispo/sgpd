package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoItinerario;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:02
 */
@Entity
@Auditavel
@Cacheable
public class RequisicaoDiariaItinerario implements Serializable {

	private static final long serialVersionUID = -3780992074310921259L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "origem_id", nullable = false)
	private Localidade origem;

	@ManyToOne
	@JoinColumn(name = "destino_id", nullable = false)
	private Localidade destino;

	@ManyToOne
	@JoinColumn(name = "meioLocomocao_id", nullable = false)
	private MeioLocomocao meioLocomocao;

	@Enumerated(EnumType.ORDINAL)
	private TipoItinerario tipo;

	public RequisicaoDiariaItinerario() {
		super();
	}

	public RequisicaoDiariaItinerario(Long id, Localidade origem, Localidade destino, MeioLocomocao meioLocomocao,
			TipoItinerario tipo) {
		super();
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.meioLocomocao = meioLocomocao;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Localidade getOrigem() {
		return origem;
	}

	public void setOrigem(Localidade origem) {
		this.origem = origem;
	}

	public Localidade getDestino() {
		return destino;
	}

	public void setDestino(Localidade destino) {
		this.destino = destino;
	}

	public MeioLocomocao getMeioLocomocao() {
		return meioLocomocao;
	}

	public void setMeioLocomocao(MeioLocomocao meioLocomocao) {
		this.meioLocomocao = meioLocomocao;
	}

	public TipoItinerario getTipo() {
		return tipo;
	}

	public void setTipo(TipoItinerario tipo) {
		this.tipo = tipo;
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
		RequisicaoDiariaItinerario other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "RequisicaoDiariaItinerario [id=" + id + ", origem=" + origem + ", destino=" + destino
				+ ", meioLocomocao=" + meioLocomocao + ", tipo=" + tipo + "]";
	}

}