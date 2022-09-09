package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.ModalidadePlanoSaude;
import br.jus.tjms.sgpd.enumerators.SituacaoPlanoSaude;
import br.jus.tjms.sgpd.enumerators.TipoPlanoSaude;
import br.jus.tjms.sgpd.service.rest.v1.to.PlanoSaudeTO;
import br.jus.tjms.sgpd.service.rest.v1.to.RubricaPlanoSaudeTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @created 06-nov-2015 16:31:00
 */
@Entity
@Auditavel
@Cacheable
@NamedQueries({
	@NamedQuery(name = "planoSaude.buscarPorDescricao", 
			query = "SELECT p FROM PlanoSaude p WHERE p.descricao like :descricao" )
})
public class PlanoSaude implements Serializable {

	private static final long serialVersionUID = -362484957827930737L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "operadora_id", nullable = false)
	private OperadoraPlanoSaude operadora;

	@Enumerated(EnumType.ORDINAL)
	private TipoPlanoSaude tipo;

	@Enumerated(EnumType.ORDINAL)
	private ModalidadePlanoSaude modalidade;

	@Column(length = 255)
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	private SituacaoPlanoSaude situacao;

	private Date dataSituacao;

	@Column(length = 500)
	private String parecer;

	@OneToMany(mappedBy = "planoSaude", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.REFRESH }, orphanRemoval = true)
	private List<RubricaPlanoSaude> rubricas = new ArrayList<RubricaPlanoSaude>();

	public PlanoSaude() {
		super();
	}

	public PlanoSaude(OperadoraPlanoSaude operadora, TipoPlanoSaude tipo, ModalidadePlanoSaude modalidade,
			String descricao, SituacaoPlanoSaude situacao, Date dataSituacao, String parecer,
			List<RubricaPlanoSaude> rubricas) {
		super();
		this.operadora = operadora;
		this.tipo = tipo;
		this.modalidade = modalidade;
		this.descricao = descricao;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.parecer = parecer;
		this.rubricas = rubricas;
	}

	public PlanoSaude(PlanoSaudeTO planoSaudeTO, OperadoraPlanoSaude operadora) {
		
		this.id = planoSaudeTO.getId();
		this.operadora = operadora;
		this.tipo = planoSaudeTO.getTipo();
		this.modalidade = planoSaudeTO.getModalidade();
		this.descricao = planoSaudeTO.getDescricao();
		this.situacao = planoSaudeTO.getSituacao();
		this.dataSituacao = planoSaudeTO.getDataSituacao();
		this.parecer = planoSaudeTO.getParecer();
		
		if (planoSaudeTO.getRubricas()!=null) {
			for (RubricaPlanoSaudeTO rubricaPlanoSaudeTO : planoSaudeTO.getRubricas()) {
				this.getRubricas().add(new RubricaPlanoSaude(rubricaPlanoSaudeTO,this));
			}
		}
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OperadoraPlanoSaude getOperadora() {
		return operadora;
	}

	public void setOperadora(OperadoraPlanoSaude operadora) {
		this.operadora = operadora;
	}

	public TipoPlanoSaude getTipo() {
		return tipo;
	}

	public void setTipo(TipoPlanoSaude tipo) {
		this.tipo = tipo;
	}

	public ModalidadePlanoSaude getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadePlanoSaude modalidade) {
		this.modalidade = modalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public SituacaoPlanoSaude getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPlanoSaude situacao) {
		this.situacao = situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public List<RubricaPlanoSaude> getRubricas() {
		return rubricas;
	}

	public void setRubricas(List<RubricaPlanoSaude> rubricas) {
		this.rubricas = rubricas;
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
		PlanoSaude other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "PlanoSaude [id=" + id + ", operadora=" + operadora + ", tipo=" + tipo + ", modalidade=" + modalidade
				+ ", descricao=" + descricao + ", situacao=" + situacao + ", dataSituacao=" + dataSituacao
				+ ", parecer=" + parecer + "]";
	}

}