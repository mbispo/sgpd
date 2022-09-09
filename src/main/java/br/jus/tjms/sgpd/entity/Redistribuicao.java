package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoRedistribuicao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:01
 */
@Entity
@Auditavel
@Cacheable
public class Redistribuicao implements Serializable {

	private static final long serialVersionUID = 7401372723731032025L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	private Date dataEfeito;
	private Date dataInicioExercicio;

	@Enumerated(EnumType.ORDINAL)
	private TipoRedistribuicao tipo;

	public Redistribuicao() {
		super();
	}

	public Redistribuicao(Long id, Funcionario funcionario, AtoAdministrativo ato, Area area, Date dataEfeito,
			Date dataInicioExercicio, TipoRedistribuicao tipo) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.ato = ato;
		this.area = area;
		this.dataEfeito = dataEfeito;
		this.dataInicioExercicio = dataInicioExercicio;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public AtoAdministrativo getAto() {
		return ato;
	}

	public void setAto(AtoAdministrativo ato) {
		this.ato = ato;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Date getDataEfeito() {
		return dataEfeito;
	}

	public void setDataEfeito(Date dataEfeito) {
		this.dataEfeito = dataEfeito;
	}

	public Date getDataInicioExercicio() {
		return dataInicioExercicio;
	}

	public void setDataInicioExercicio(Date dataInicioExercicio) {
		this.dataInicioExercicio = dataInicioExercicio;
	}

	public TipoRedistribuicao getTipo() {
		return tipo;
	}

	public void setTipo(TipoRedistribuicao tipo) {
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
		Redistribuicao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Redistribuicao [id=" + id + ", funcionario=" + funcionario + ", ato=" + ato + ", area=" + area
				+ ", dataEfeito=" + dataEfeito + ", dataInicioExercicio=" + dataInicioExercicio + ", tipo=" + tipo
				+ "]";
	}

}