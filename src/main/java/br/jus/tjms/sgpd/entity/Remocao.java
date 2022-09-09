package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.SituacaoRemocao;
import br.jus.tjms.sgpd.enumerators.TipoRemocao;
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
public class Remocao implements Serializable {

	private static final long serialVersionUID = 1504436638071503140L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "atoAdministrativo_id", nullable = false)
	private AtoAdministrativo ato;

	private Date dataEfeito;
	private Date dataInicioExercicio;

	@Enumerated(EnumType.ORDINAL)
	private TipoRemocao tipo;

	@ManyToOne
	@JoinColumn(name = "remocaoRelacionada_id", nullable = true)
	private Remocao remocaoRelacionada;

	@ManyToOne
	@JoinColumn(name = "pedido_id", nullable = true)
	private PedidoRemocao pedido;

	private Date dataSituacao;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoRemocao situacao;

	@Column(length = 500)
	private String parecer;

	public Remocao() {
		super();
	}

	public Remocao(Long id, Area area, Funcionario funcionario, AtoAdministrativo ato, Date dataEfeito,
			Date dataInicioExercicio, TipoRemocao tipo, Remocao remocaoRelacionada, PedidoRemocao pedido,
			Date dataSituacao, SituacaoRemocao situacao, String parecer) {
		super();
		this.id = id;
		this.area = area;
		this.funcionario = funcionario;
		this.ato = ato;
		this.dataEfeito = dataEfeito;
		this.dataInicioExercicio = dataInicioExercicio;
		this.tipo = tipo;
		this.remocaoRelacionada = remocaoRelacionada;
		this.pedido = pedido;
		this.dataSituacao = dataSituacao;
		this.situacao = situacao;
		this.parecer = parecer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
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

	public TipoRemocao getTipo() {
		return tipo;
	}

	public void setTipo(TipoRemocao tipo) {
		this.tipo = tipo;
	}

	public Remocao getRemocaoRelacionada() {
		return remocaoRelacionada;
	}

	public void setRemocaoRelacionada(Remocao remocaoRelacionada) {
		this.remocaoRelacionada = remocaoRelacionada;
	}

	public PedidoRemocao getPedido() {
		return pedido;
	}

	public void setPedido(PedidoRemocao pedido) {
		this.pedido = pedido;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public SituacaoRemocao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoRemocao situacao) {
		this.situacao = situacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
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
		Remocao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Remocao [id=" + id + ", area=" + area + ", funcionario=" + funcionario + ", ato=" + ato
				+ ", dataEfeito=" + dataEfeito + ", dataInicioExercicio=" + dataInicioExercicio + ", tipo=" + tipo
				+ ", remocaoRelacionada=" + remocaoRelacionada + ", pedido=" + pedido + ", dataSituacao="
				+ dataSituacao + ", situacao=" + situacao + ", parecer=" + parecer + "]";
	}

}