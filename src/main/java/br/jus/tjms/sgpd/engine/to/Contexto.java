package br.jus.tjms.sgpd.engine.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.engine.calculo.InputParam;
import br.jus.tjms.sgpd.engine.calculo.ItemCalculoResultadoRubricaFuncionarioFolhaCache;
import br.jus.tjms.sgpd.entity.Area;
import br.jus.tjms.sgpd.entity.Cargo;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.entity.FormulaInput;
import br.jus.tjms.sgpd.entity.FormulaOutput;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.entity.FuncionarioArea;
import br.jus.tjms.sgpd.entity.FuncionarioCargo;
import br.jus.tjms.sgpd.entity.Pagamento;
import br.jus.tjms.sgpd.entity.PagamentoItem;
import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.enumerators.MotivoAposentadoria;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.enumerators.TipoBaseCalculo;
import br.jus.tjms.sgpd.enumerators.TipoPagamentoItem;
import br.jus.tjms.sgpd.util.DateUtilz;

public class Contexto implements Serializable {

	private static final long serialVersionUID = -1222707550498890193L;
	
	private transient EntityManager em;

	@FolowField
	private Pessoa pessoa;
	
	@FolowField
	private Funcionario funcionario;
	
	@FolowField
	private Area area;
	
	@FolowField
	private FuncionarioArea funcionarioArea;
	
	@FolowField
	private Cargo cargo;
	
	@FolowField
	private FuncionarioCargo funcionarioCargo;
	
	@FolowField
	private FolhaPagamento folha;
	
	@FolowField
	private Rubrica rubrica;
	
	@FolowField
	private RubricaFuncionario rubricaFuncionario;
	
	private Boolean pessoaEstaAposentada = false;
	
	private MotivoAposentadoria motivoAposentadoria;

	List<Pagamento> pagamentos = new ArrayList<>();
	
	List<FormulaOutput> formulaOutputs = new ArrayList<>();
	List<FormulaInput> formulaInputs = new ArrayList<>();

    private int faltas;

    private int cargaHoraria;

	public Contexto() {
		super();
	}

	public Contexto(EntityManager em) {
		super();
		this.em = em;
	}
	
	public EntityManager getEm() {
		return em;
	}

	public Contexto setEm(EntityManager em) {
		this.em = em;
		return this;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public Contexto setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		return this;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Contexto setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		return this;
	}

	public Area getArea() {
		return area;
	}

	public Contexto setArea(Area area) {
		this.area = area;
		return this;
	}

	public FuncionarioArea getFuncionarioArea() {
		return funcionarioArea;
	}

	public Contexto setFuncionarioArea(FuncionarioArea funcionarioArea) {
		this.funcionarioArea = funcionarioArea;
		return this;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public Contexto setCargo(Cargo cargo) {
		this.cargo = cargo;
		return this;
	}

	public FuncionarioCargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public Contexto setFuncionarioCargo(FuncionarioCargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
		return this;
	}

	public FolhaPagamento getFolha() {
		return folha;
	}

	public Contexto setFolha(FolhaPagamento folha) {
		this.folha = folha;
		return this;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public Contexto setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
		return this;
	}

	public RubricaFuncionario getRubricaFuncionario() {
		return rubricaFuncionario;
	}

	public Contexto setRubricaFuncionario(RubricaFuncionario rubricaFuncionario) {
		this.rubricaFuncionario = rubricaFuncionario;
		return this;
	}

	public Boolean getPessoaEstaAposentada() {
		return pessoaEstaAposentada;
	}

	public Contexto setPessoaEstaAposentada(Boolean pessoaEstaAposentada) {
		this.pessoaEstaAposentada = pessoaEstaAposentada;
		return this;
	}

	public MotivoAposentadoria getMotivoAposentadoria() {
		return motivoAposentadoria;
	}

	public Contexto setMotivoAposentadoria(MotivoAposentadoria motivoAposentadoria) {
		this.motivoAposentadoria = motivoAposentadoria;
		return this;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public Contexto setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
		return this;
	}

	public List<FormulaOutput> getFormulaOutputs() {
		return formulaOutputs;
	}

	public Contexto setFormulaOutputs(List<FormulaOutput> formulaOutputs) {
		this.formulaOutputs = formulaOutputs;
		return this;
	}

	public List<FormulaInput> getFormulaInputs() {
		return formulaInputs;
	}

	public Contexto setFormulaInputs(List<FormulaInput> formulaInputs) {
		this.formulaInputs = formulaInputs;
		return this;
	}

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
    //------------------------------------------------------------------------------------------------------------------
	
	public InputParam input(String nome) {
		for (InputParam formulaInput : formulaInputs) {
			if (formulaInput.getNome().equals(nome)) {
				return formulaInput; 
			}
		}
		return null;
	}
	
	public FormulaOutput output(String nome) {
		for (FormulaOutput formulaOutput : formulaOutputs) {
			if (formulaOutput.getNome().equals(nome)) {
				return formulaOutput; 
			}
		}
		return null;
	}
	
	public Date dataInicioCargo() {
		return funcionarioCargo!=null?funcionarioCargo.getDataInicio():null;
	}
	
	public Date dataFimCargo() {
		return funcionarioCargo!=null?funcionarioCargo.getDataFim():null;
	}
	
	public Boolean aposentadoPorIdade() {
		return (pessoaEstaAposentada && motivoAposentadoria!=null && motivoAposentadoria.equals(MotivoAposentadoria.IDADE));
	}
	
	public Boolean aposentadoPorDoenca() {
		return (pessoaEstaAposentada && motivoAposentadoria!=null && motivoAposentadoria.equals(MotivoAposentadoria.DOENCA));
	}
	
	public Double baseCalculoContribuicaoSindicalAssociadoNaFolha() {
		return totalItensPorTipoComposicaoBaseCalculoNaFolha(TipoBaseCalculo.CONTRIBUICAO_SINDICAL);
	}

	public Double baseCalculoPlanoSaudeNaFolha() {
		return totalItensPorTipoComposicaoBaseCalculoNaFolha(TipoBaseCalculo.PLANO_SAUDE);
	}
	
	public Double baseCalculoPrevidenciaRegimeGeralNaFolha() {
		return totalItensPorTipoComposicaoBaseCalculoNaFolha(TipoBaseCalculo.PREVIDENCIA_GERAL);
	}

	public Double baseCalculoPrevidenciaRegimeProprioNaFolha() {
		return totalItensPorTipoComposicaoBaseCalculoNaFolha(TipoBaseCalculo.PREVIDENCIA_PROPRIA);
	}
	
	public Double baseCalculoIrrfNaFolha() {
		return totalItensPorTipoComposicaoBaseCalculoNaFolha(TipoBaseCalculo.IMPOSTO_RENDA);
	}
	
	public Double totalItensPorTipoComposicaoBaseCalculoNaFolha(TipoBaseCalculo tipo) {		
		return (totalItensPorTipoComposicaoBaseCalculoNaFolha(tipo, Sinal.POSITIVO) - totalItensPorTipoComposicaoBaseCalculoNaFolha(tipo, Sinal.NEGATIVO));
	}
	
	public Double totalItensPorTipoComposicaoBaseCalculoNaFolha(TipoBaseCalculo tipo, Sinal sinal) {
		List<ItemCalculoResultado> itens = ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache().obterResultadosPorComposicaoTipoBaseCalculo(folha, pessoa, tipo, sinal);
		Double total = 0.0;
		for (ItemCalculoResultado item : itens) { total = total + item.getResultado(); }
		return total;
	}
	
	public Double totalItensPorRubricasBaseNaFolha() {
		return totalItensPorRubricasBaseNaFolha(rubrica, Sinal.POSITIVO) - totalItensPorRubricasBaseNaFolha(rubrica, Sinal.NEGATIVO); 
	}

	public Double totalItensPorRubricasBaseNaFolha(Rubrica rubrica) {
		return totalItensPorRubricasBaseNaFolha(rubrica, Sinal.POSITIVO) - totalItensPorRubricasBaseNaFolha(rubrica, Sinal.NEGATIVO); 
	}
	
	public Double totalItensPorRubricasBaseNaFolha(Rubrica rubrica, Sinal sinal) {
		List<ItemCalculoResultado> itens = ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache().obterResultadosPorRubricasBase(folha, pessoa, rubrica, sinal);
		Double total = 0.0;
		for (ItemCalculoResultado item : itens) { total = total + item.getResultado(); }
		return total;
	}

	public Double totalItensPorRubricasFuncionarioBaseNaFolha() {
		return totalItensPorRubricasFuncionarioBaseNaFolha(rubricaFuncionario, Sinal.POSITIVO) - totalItensPorRubricasFuncionarioBaseNaFolha(rubricaFuncionario, Sinal.NEGATIVO); 
	}

	public Double totalItensPorRubricasFuncionarioBaseNaFolha(RubricaFuncionario rubricaFuncionario) {
		return totalItensPorRubricasFuncionarioBaseNaFolha(rubricaFuncionario, Sinal.POSITIVO) - totalItensPorRubricasFuncionarioBaseNaFolha(rubricaFuncionario, Sinal.NEGATIVO); 
	}
	
	public Double totalItensPorRubricasFuncionarioBaseNaFolha(RubricaFuncionario rubricaFuncionario, Sinal sinal) {
		List<ItemCalculoResultado> itens = ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache().obterResultadosPorRubricasFuncionarioBase(folha, pessoa, rubricaFuncionario, sinal);
		Double total = 0.0;
		for (ItemCalculoResultado item : itens) { total = total + item.getResultado(); }
		return total;
	}	
	
	public Double previdenciaRegimeGeralNoMes(Integer ano, Integer mes) {
		return totalPagamentoPorTipoItemNoMes(TipoPagamentoItem.PREVIDENCIA_REGIME_GERAL, ano, mes);
	}

	public Double baseCalculoPrevidenciaRegimeGeralNoMes(Integer ano, Integer mes) {
		return totalPagamentoPorTipoItemNoMes(TipoPagamentoItem.BASE_CALCULO_PREVIDENCIA_REGIME_GERAL, ano, mes);
	}

	public Double previdenciaRegimeProprioNoMes(Integer ano, Integer mes) {
		return totalPagamentoPorTipoItemNoMes(TipoPagamentoItem.PREVIDENCIA_REGIME_PROPRIO, ano, mes);
	}

	public Double baseCalculoPrevidenciaRegimeProprioNoMes(Integer ano, Integer mes) {
		return totalPagamentoPorTipoItemNoMes(TipoPagamentoItem.BASE_CALCULO_PREVIDENCIA_REGIME_PROPRIO, ano, mes);
	}
	
	public Double irrfNoMes(Integer ano, Integer mes) {
		return totalPagamentoPorTipoItemNoMes(TipoPagamentoItem.IRRF, ano, mes);
	}

	public Double baseCalculoIrrfNoMes(Integer ano, Integer mes) {
		return totalPagamentoPorTipoItemNoMes(TipoPagamentoItem.BASE_CALCULO_IRRF, ano, mes);
	}
	
	public Double totalPagamentoPorTipoItemNoMes(TipoPagamentoItem tipo, Integer ano, Integer mes) {
		Double total = 0.0;
		for (Pagamento pagamento : pagamentosNoMes(ano, mes)) { total = total + pagamento.getTotalPorTipoItem(tipo); }
		return total;
	}
	
	public List<Pagamento> pagamentosNoMes(Integer ano, Integer mes) {
		final Date inicio = DateUtilz.primeiroDiaDoMes(mes, ano);
		final Date fim = DateUtilz.ultimoDiaDoMesAoFinalDoDia(mes, ano);
		return pagamentosNoIntervalo(inicio, fim);
	}
	
	public List<Pagamento> pagamentosNoIntervalo(final Date inicio, final Date fim) {
		if (pagamentos != null) {
			Collection<Pagamento> c = Collections2.filter(pagamentos, new Predicate<Pagamento>() {
				@Override
				public boolean apply(Pagamento p) {
					return (p.getDataPagamento()!=null&&p.getDataPagamento().getTime()>=inicio.getTime()&&p.getDataPagamento().getTime()<=fim.getTime());
				}
			});
			
			return new ArrayList<>(c);
		}
		return null;
	}
	
	
	public Date retornaMenorDataPagamentoDosItensPorRubricaNoUltimoAno(Rubrica rubrica, TipoPagamentoItem tipo) {
		final Date fim = DateUtilz.criaDataAoFinalDoDia(new Date());
		final Date inicio = DateUtilz.adicionaAnosNaData(fim, -1, false);		
		return retornaMenorDataPagamentoDosItensPorRubricaNoIntervalo(inicio, fim, rubrica, tipo);
	}

    public Integer obterNumeroDependentes(Date dataInicialFolha) {
        return this.getPessoa().getNumeroDependentesImpostoRendaNaData(dataInicialFolha);
    }

    public Double obterParametroDeducaoPorDependente(Date dataInicialFolha) {
        if(getRubrica() == null || getRubrica().getParametrosAtivos(dataInicialFolha).isEmpty()) {
            return 0.0;
        }

        return this.getRubrica().getParametrosAtivos(dataInicialFolha).get(0).getValorDeducaoPorDependente();
    }

    public Double obterParametroDeducaoPorAposentadoriaOuIdade(Date dataInicialFolha) {
        if(getRubrica() == null || getRubrica().getParametrosAtivos(dataInicialFolha).isEmpty()) {
            return 0.0;
        }

        //retorna 0 se não aposentado ou idade >= 65
        Double deducao = this.getRubrica().getParametrosAtivos(dataInicialFolha).get(0).getValorDeducaoPorIdade();
        return (this.getPessoa().getIdadeNaData(dataInicialFolha) >= 65 ? deducao:(getPessoaEstaAposentada() ? deducao : 0));
    }

    public Double getBaseIrrfNoMes(Integer ano, Integer mes) {
        Double baseIrrfNoMes = baseCalculoIrrfNoMes(ano, mes);
        Double baseIrrfNaFolha = baseCalculoIrrfNaFolha();
        return baseIrrfNoMes + baseIrrfNaFolha;
    }

    public Double getPercentualIrrfNaFaixa(Double baseIrrf, Date dataInicialFolha) {
        if(getRubrica() == null || getRubrica().getParametrosAtivos(dataInicialFolha).isEmpty()) {
            return 0.0;
        }
        return this.getRubrica().getParametrosAtivos(dataInicialFolha, baseIrrf).get(0).getPercentual();
    }

    public Double getDeducaoIrrfNaFaixa(Double baseIrrf, Date dataInicialFolha) {
        if(getRubrica() == null || getRubrica().getParametrosAtivos(dataInicialFolha).isEmpty()) {
            return 0.0;
        }
        return this.getRubrica().getParametrosAtivos(dataInicialFolha, baseIrrf).get(0).getValorDeducao();
    }
	
	public Date retornaMenorDataPagamentoDosItensPorRubricaNoIntervalo(final Date inicio, final Date fim, Rubrica rubrica, TipoPagamentoItem tipo) {
		Date data = new Date(Long.MAX_VALUE);
		List<PagamentoItem> itens = pagamentoItensPorRubricaNoIntervalo(inicio, fim, rubrica, tipo);
		if (itens!=null) {
			for (PagamentoItem item : itens) {
				if (item.getDataPagamento()!=null && (item.getDataPagamento().getTime()<=data.getTime())) {
					data = item.getDataPagamento();
				}
			}
			if (data.compareTo(new Date(Long.MAX_VALUE)) == 0) {
				return null;
			}
		}
		return null;
	}
	
	public List<PagamentoItem> pagamentoItensPorRubricaNoMes(Integer ano, Integer mes, Rubrica rubrica, TipoPagamentoItem tipo) {
		final Date inicio = DateUtilz.primeiroDiaDoMes(mes, ano);
		final Date fim = DateUtilz.ultimoDiaDoMesAoFinalDoDia(mes, ano);
		return pagamentoItensPorRubricaNoIntervalo(inicio, fim, rubrica, tipo);
	}
	
	public List<PagamentoItem> pagamentoItensPorRubricaNoIntervalo(final Date inicio, final Date fim, Rubrica rubrica, TipoPagamentoItem tipo) {
		List<PagamentoItem> retorno = new ArrayList<>();
		List<Pagamento> pagamentosNoIntervalo = pagamentosNoIntervalo(inicio, fim);
		for (Pagamento pagamento : pagamentosNoIntervalo) {
			for (PagamentoItem item : pagamento.getItens()) {
				if (item.getRubrica()!=null&&item.getRubrica().equals(rubrica)&&item.getTipo().equals(tipo)) {
					retorno.add(item);
				}
			}
		}
		return retorno;		
	}

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Contexto{" +
                "pessoa=" + pessoa +
                ", funcionario=" + funcionario +
                ", area=" + area +
                ", funcionarioArea=" + funcionarioArea +
                ", cargo=" + cargo +
                ", funcionarioCargo=" + funcionarioCargo +
                ", folha=" + folha +
                ", rubrica=" + rubrica +
                ", rubricaFuncionario=" + rubricaFuncionario +
                ", pessoaEstaAposentada=" + pessoaEstaAposentada +
                ", motivoAposentadoria=" + motivoAposentadoria +
                ", pagamentos=" + pagamentos +
                '}';
    }
}