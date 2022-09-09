package br.jus.tjms.sgpd.engine.to;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.jus.tjms.sgpd.entity.Cargo;
import br.jus.tjms.sgpd.entity.ConcessaoAdicionalInsalubridade;
import br.jus.tjms.sgpd.entity.ConcessaoAdicionalQualificacao;
import br.jus.tjms.sgpd.entity.ConcessaoAuxilioEducacaoInfantil;
import br.jus.tjms.sgpd.entity.ConcessaoAuxilioTransporte;
import br.jus.tjms.sgpd.entity.ConcessaoFerias;
import br.jus.tjms.sgpd.entity.ConcessaoGratificacaoEncargosEspeciais;
import br.jus.tjms.sgpd.entity.ContratoPlanoSaude;
import br.jus.tjms.sgpd.entity.DesignacaoAdicionalTempoIntegral;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.LancamentoAgendado;
import br.jus.tjms.sgpd.entity.LancamentoAvulso;
import br.jus.tjms.sgpd.entity.LancamentoRecorrente;
import br.jus.tjms.sgpd.entity.Licenca;
import br.jus.tjms.sgpd.entity.ParcelaEmprestimoConsignado;
import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.entity.PessoaInclusaContratoPlanoSaude;
import br.jus.tjms.sgpd.entity.ReferenciaValor;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.entity.RubricaPlanoSaude;

public class ItemCalculo implements Serializable, Comparable<ItemCalculo> {

	private static final long serialVersionUID = -7434783726222240576L;

	private Long id;
	private Integer ordem;
	private TipoItemCalculo tipo;
	private Cargo cargo;
	private FuncionarioCargo funcionarioCargo;
	private ReferenciaValor referenciaValor;
	private Date periodoInicio;
	private Date periodoFim;

	private Rubrica rubrica;
	private RubricaFuncionario rubricaFuncionario;

	private LancamentoAvulso lancamentoAvulso;
	private LancamentoAgendado lancamentoAgendado;
	private LancamentoRecorrente lancamentoRecorrente;

	private ParcelaEmprestimoConsignado parcelaEmprestimoConsignado;

	private ContratoPlanoSaude contratoPlanoSaude;
	private List<RubricaPlanoSaude> rubricasPlanoSaude;
	private List<PessoaInclusaContratoPlanoSaude> pessoasInclusasContratoPlanoSaude;

	private ConcessaoAuxilioEducacaoInfantil concessaoAuxilioEducacaoInfantil;
	private ConcessaoAdicionalQualificacao concessaoAdicionalQualificacao;
	private ConcessaoFerias concessaoFerias;
	private ConcessaoAdicionalInsalubridade concessaoAdicionalInsalubridade;
	private ConcessaoGratificacaoEncargosEspeciais concessaoGratificacaoEncargosEspeciais;
	private ConcessaoAuxilioTransporte concessaoAuxilioTransporte;
	
	private DesignacaoAdicionalTempoIntegral designacaoAdicionalTempoIntegral;

	private Licenca licenca;
	
	private String entidadeOrigem;
	private Long idOrigem;

	private ItemCalculoResultado resultado;
	private List<TipoAcaoItemCalculo> acoesAExecutar;
	
	private List<ItemCalculo> listaMae;
	private transient Map<Pessoa,List<ItemCalculo>> hashMaeDaLista;
	

	public ItemCalculo() {
		super();
	}

	public ItemCalculo(Long id) {
		super();
		this.id = id;
	}

	public ItemCalculo(Long id, Integer ordem, TipoItemCalculo tipo, Cargo cargo, FuncionarioCargo funcionarioCargo, 
			ReferenciaValor referenciaValor, Date periodoInicio, Date periodoFim, Rubrica rubrica, 
			RubricaFuncionario rubricaFuncionario, LancamentoAvulso lancamentoAvulso, LancamentoAgendado lancamentoAgendado,
			LancamentoRecorrente lancamentoRecorrente, ParcelaEmprestimoConsignado parcelaEmprestimoConsignado,
			ContratoPlanoSaude contratoPlanoSaude, List<RubricaPlanoSaude> rubricasPlanoSaude,
			List<PessoaInclusaContratoPlanoSaude> pessoasInclusasContratoPlanoSaude,
			ConcessaoAuxilioEducacaoInfantil concessaoAuxilioEducacaoInfantil,
			ConcessaoAdicionalQualificacao concessaoAdicionalQualificacao,
			ConcessaoFerias concessaoFerias,
			ConcessaoAdicionalInsalubridade concessaoAdicionalInsalubridade,
			ConcessaoGratificacaoEncargosEspeciais concessaoGratificacaoEncargosEspeciais,
			ConcessaoAuxilioTransporte concessaoAuxilioTransporte,
			DesignacaoAdicionalTempoIntegral designacaoAdicionalTempoIntegral,
			Licenca licenca,
			String entidadeOrigem, Long idOrigem) {
		super();
		this.id = id;
		this.ordem = ordem;
		this.tipo = tipo;
		this.cargo = cargo;
		this.funcionarioCargo = funcionarioCargo;
		this.referenciaValor = referenciaValor;
		this.periodoInicio = periodoInicio;
		this.periodoFim = periodoFim;
		this.rubrica = rubrica;
		this.rubricaFuncionario = rubricaFuncionario;
		this.lancamentoAvulso = lancamentoAvulso;
		this.lancamentoAgendado = lancamentoAgendado;
		this.lancamentoRecorrente = lancamentoRecorrente;
		this.parcelaEmprestimoConsignado = parcelaEmprestimoConsignado;
		this.contratoPlanoSaude = contratoPlanoSaude;
		this.rubricasPlanoSaude = rubricasPlanoSaude;
		this.pessoasInclusasContratoPlanoSaude = pessoasInclusasContratoPlanoSaude;
		this.concessaoAuxilioEducacaoInfantil = concessaoAuxilioEducacaoInfantil;
		this.concessaoAdicionalQualificacao = concessaoAdicionalQualificacao;
		this.concessaoFerias = concessaoFerias;
		this.concessaoAdicionalInsalubridade = concessaoAdicionalInsalubridade;
		this.concessaoGratificacaoEncargosEspeciais = concessaoGratificacaoEncargosEspeciais;
		this.concessaoAuxilioTransporte = concessaoAuxilioTransporte;
		this.designacaoAdicionalTempoIntegral = designacaoAdicionalTempoIntegral;
		this.licenca = licenca;
		this.entidadeOrigem = entidadeOrigem;
		this.idOrigem = idOrigem;
	}

	public Long getId() {
		return id;
	}

	public ItemCalculo setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public ItemCalculo setOrdem(Integer ordem) {
		this.ordem = ordem;
		return this;
	}

	public TipoItemCalculo getTipo() {
		return tipo;
	}

	public ItemCalculo setTipo(TipoItemCalculo tipo) {
		this.tipo = tipo;
		return this;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public ItemCalculo setCargo(Cargo cargo) {
		this.cargo = cargo;
		return this;
	}

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public ItemCalculo setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
		return this;
	}

	public ReferenciaValor getReferenciaValor() {
		return referenciaValor;
	}

	public ItemCalculo setReferenciaValor(ReferenciaValor referenciaValor) {
		this.referenciaValor = referenciaValor;
		return this;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public ItemCalculo setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
		return this;
	}

	public Date getPeriodoFim() {
		return periodoFim;
	}

	public ItemCalculo setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
		return this;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public ItemCalculo setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
		return this;
	}

	public RubricaFuncionario getRubricaFuncionario() {
		return rubricaFuncionario;
	}

	public ItemCalculo setRubricaFuncionario(RubricaFuncionario rubricaFuncionario) {
		this.rubricaFuncionario = rubricaFuncionario;
		return this;
	}

	public LancamentoAvulso getLancamentoAvulso() {
		return lancamentoAvulso;
	}

	public ItemCalculo setLancamentoAvulso(LancamentoAvulso lancamentoAvulso) {
		this.lancamentoAvulso = lancamentoAvulso;
		return this;
	}

	public LancamentoAgendado getLancamentoAgendado() {
		return lancamentoAgendado;
	}

	public ItemCalculo setLancamentoAgendado(LancamentoAgendado lancamentoAgendado) {
		this.lancamentoAgendado = lancamentoAgendado;
		return this;
	}

	public LancamentoRecorrente getLancamentoRecorrente() {
		return lancamentoRecorrente;
	}

	public ItemCalculo setLancamentoRecorrente(LancamentoRecorrente lancamentoRecorrente) {
		this.lancamentoRecorrente = lancamentoRecorrente;
		return this;
	}

	public ParcelaEmprestimoConsignado getParcelaEmprestimoConsignado() {
		return parcelaEmprestimoConsignado;
	}

	public ItemCalculo setParcelaEmprestimoConsignado(ParcelaEmprestimoConsignado parcelaEmprestimoConsignado) {
		this.parcelaEmprestimoConsignado = parcelaEmprestimoConsignado;
		return this;
	}

	public ContratoPlanoSaude getContratoPlanoSaude() {
		return contratoPlanoSaude;
	}

	public ItemCalculo setContratoPlanoSaude(ContratoPlanoSaude contratoPlanoSaude) {
		this.contratoPlanoSaude = contratoPlanoSaude;
		return this;
	}

	public List<RubricaPlanoSaude> getRubricasPlanoSaude() {
		return rubricasPlanoSaude;
	}

	public ItemCalculo setRubricasPlanoSaude(List<RubricaPlanoSaude> rubricasPlanoSaude) {
		this.rubricasPlanoSaude = rubricasPlanoSaude;
		return this;
	}

	public List<PessoaInclusaContratoPlanoSaude> getPessoasInclusasContratoPlanoSaude() {
		return pessoasInclusasContratoPlanoSaude;
	}

	public ItemCalculo setPessoasInclusasContratoPlanoSaude(
			List<PessoaInclusaContratoPlanoSaude> pessoasInclusasContratoPlanoSaude) {
		this.pessoasInclusasContratoPlanoSaude = pessoasInclusasContratoPlanoSaude;
		return this;
	}

	public ConcessaoAuxilioEducacaoInfantil getConcessaoAuxilioEducacaoInfantil() {
		return concessaoAuxilioEducacaoInfantil;
	}

	public ItemCalculo setConcessaoAuxilioEducacaoInfantil(ConcessaoAuxilioEducacaoInfantil concessaoAuxilioEducacaoInfantil) {
		this.concessaoAuxilioEducacaoInfantil = concessaoAuxilioEducacaoInfantil;
		return this;
	}

	public ConcessaoAdicionalQualificacao getConcessaoAdicionalQualificacao() {
		return concessaoAdicionalQualificacao;
	}

	public ItemCalculo setConcessaoAdicionalQualificacao(ConcessaoAdicionalQualificacao concessaoAdicionalQualificacao) {
		this.concessaoAdicionalQualificacao = concessaoAdicionalQualificacao;
		return this;
	}

	public ConcessaoFerias getConcessaoFerias() {
		return concessaoFerias;
	}

	public ItemCalculo setConcessaoFerias(ConcessaoFerias concessaoFerias) {
		this.concessaoFerias = concessaoFerias;
		return this;
	}

	public ConcessaoAdicionalInsalubridade getConcessaoAdicionalInsalubridade() {
		return concessaoAdicionalInsalubridade;
	}

	public ItemCalculo setConcessaoAdicionalInsalubridade(ConcessaoAdicionalInsalubridade concessaoAdicionalInsalubridade) {
		this.concessaoAdicionalInsalubridade = concessaoAdicionalInsalubridade;
		return this;
	}

	public ConcessaoGratificacaoEncargosEspeciais getConcessaoGratificacaoEncargosEspeciais() {
		return concessaoGratificacaoEncargosEspeciais;
	}

	public ItemCalculo setConcessaoGratificacaoEncargosEspeciais(
			ConcessaoGratificacaoEncargosEspeciais concessaoGratificacaoEncargosEspeciais) {
		this.concessaoGratificacaoEncargosEspeciais = concessaoGratificacaoEncargosEspeciais;
		return this;
	}

	public ConcessaoAuxilioTransporte getConcessaoAuxilioTransporte() {
		return concessaoAuxilioTransporte;
	}

	public ItemCalculo setConcessaoAuxilioTransporte(ConcessaoAuxilioTransporte concessaoAuxilioTransporte) {
		this.concessaoAuxilioTransporte = concessaoAuxilioTransporte;
		return this;
	}

	public DesignacaoAdicionalTempoIntegral getDesignacaoAdicionalTempoIntegral() {
		return designacaoAdicionalTempoIntegral;
	}

	public ItemCalculo setDesignacaoAdicionalTempoIntegral(DesignacaoAdicionalTempoIntegral designacaoAdicionalTempoIntegral) {
		this.designacaoAdicionalTempoIntegral = designacaoAdicionalTempoIntegral;
		return this;
	}

	public String getEntidadeOrigem() {
		return entidadeOrigem;
	}

	public ItemCalculo setEntidadeOrigem(String entidadeOrigem) {
		this.entidadeOrigem = entidadeOrigem;
		return this;
	}

	public Long getIdOrigem() {
		return idOrigem;
	}

	public ItemCalculo setIdOrigem(Long idOrigem) {
		this.idOrigem = idOrigem;
		return this;
	}

	public Licenca getLicenca() {
		return licenca;
	}

	public ItemCalculo setLicenca(Licenca licenca) {
		this.licenca = licenca;
		return this;
	}

	public ItemCalculoResultado getResultado() {
		return resultado;
	}

	public ItemCalculo setResultado(ItemCalculoResultado resultado) {
		this.resultado = resultado;
		return this;
	}

	public List<TipoAcaoItemCalculo> getAcoesAExecutar() {
		return acoesAExecutar;
	}

	public ItemCalculo setAcoesAExecutar(List<TipoAcaoItemCalculo> acoesAExecutar) {
		this.acoesAExecutar = acoesAExecutar;
		return this;
	}

	public ItemCalculo setResultadoEAcoesAExecutar(ItemCalculoResultado resultado, List<TipoAcaoItemCalculo> acoesExecutar) {
		setResultado(resultado);
		setAcoesAExecutar(acoesExecutar);
		return this;
	}

	public List<ItemCalculo> getListaMae() {
		return listaMae;
	}

	public ItemCalculo setListaMae(List<ItemCalculo> listaMae) {
		this.listaMae = listaMae;
		return this;
	}

	public Map<Pessoa,List<ItemCalculo>> getHashMaeDaLista() {
		return hashMaeDaLista;
	}

	public ItemCalculo setHashMaeDaLista(Map<Pessoa,List<ItemCalculo>> hashMaeDaLista) {
		this.hashMaeDaLista = hashMaeDaLista;
		return this;
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
		ItemCalculo other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "ItemCalculo [id=" + id + ", ordem=" + ordem + ", tipo=" + tipo + ", cargo=" + cargo
				+ ", funcionarioCargo=" + funcionarioCargo + ", referenciaValor=" + referenciaValor + ", periodoInicio="
				+ periodoInicio + ", periodoFim=" + periodoFim + ", rubrica=" + rubrica + ", rubricaFuncionario="
				+ rubricaFuncionario + ", lancamentoAvulso=" + lancamentoAvulso + ", lancamentoAgendado="
				+ lancamentoAgendado + ", lancamentoRecorrente=" + lancamentoRecorrente
				+ ", parcelaEmprestimoConsignado=" + parcelaEmprestimoConsignado + ", contratoPlanoSaude="
				+ contratoPlanoSaude + ", rubricasPlanoSaude=" + rubricasPlanoSaude
				+ ", pessoasInclusasContratoPlanoSaude=" + pessoasInclusasContratoPlanoSaude
				+ ", concessaoAuxilioEducacaoInfantil=" + concessaoAuxilioEducacaoInfantil
				+ ", concessaoAdicionalQualificacao=" + concessaoAdicionalQualificacao + ", concessaoFerias="
				+ concessaoFerias + ", concessaoAdicionalInsalubridade=" + concessaoAdicionalInsalubridade
				+ ", concessaoGratificacaoEncargosEspeciais=" + concessaoGratificacaoEncargosEspeciais
				+ ", concessaoAuxilioTransporte=" + concessaoAuxilioTransporte + ", designacaoAdicionalTempoIntegral="
				+ designacaoAdicionalTempoIntegral + ", licenca=" + licenca + ", entidadeOrigem=" + entidadeOrigem
				+ ", idOrigem=" + idOrigem + ", resultado=" + resultado + ", acoesAExecutar=" + acoesAExecutar + "]";
	}

	@Override
	public int compareTo(ItemCalculo o) {
		/*
		 * ordenar pela ordem de cálculo, base de cálculo, etc
		 */

		return this.ordem.compareTo(o.getOrdem());
	}

}