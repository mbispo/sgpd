package br.jus.tjms.sgpd.engine.calculo.impl;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.jus.tjms.sgpd.engine.calculo.FolhaCalculoApplier;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.engine.to.TipoAcaoItemCalculo;
import br.jus.tjms.sgpd.engine.to.TipoItemCalculo;
import br.jus.tjms.sgpd.entity.ConcessaoGratificacaoEncargosEspeciais;
import br.jus.tjms.sgpd.entity.ContaRecebimento;
import br.jus.tjms.sgpd.entity.DadosConsolidadosDoFuncionario;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.entity.LancamentoAgendado;
import br.jus.tjms.sgpd.entity.LancamentoAvulso;
import br.jus.tjms.sgpd.entity.LancamentoRecorrente;
import br.jus.tjms.sgpd.entity.Pagamento;
import br.jus.tjms.sgpd.entity.ParcelaEmprestimoConsignado;
import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.enumerators.TipoContaRecebimento;
import br.jus.tjms.sgpd.service.consignacaoservices.EmprestimoConsignadoService;
import br.jus.tjms.sgpd.service.dadosconsolidadosservices.DadosConsolidadosService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.GratificacaoEncargosEspeciaisService;
import br.jus.tjms.sgpd.service.folhapagamentoservices.PagamentoService;
import br.jus.tjms.sgpd.service.remuneracaoservices.LancamentoAgendadoService;
import br.jus.tjms.sgpd.service.remuneracaoservices.LancamentoAvulsoService;
import br.jus.tjms.sgpd.service.remuneracaoservices.LancamentoRecorrenteService;
import br.jus.tjms.sgpd.util.DateUtilz;



@Stateless
public class FolhaNormalCalculoApplier implements FolhaCalculoApplier {
	
	private static final long serialVersionUID = 3392857639832312432L;
	
    static FolhaNormalCalculoApplier instance;
	
	@EJB
	private LancamentoRecorrenteService lancamentoRecorrenteService;
	
	@EJB
	private EmprestimoConsignadoService emprestimoConsignadoService;
	
	@EJB
	private LancamentoAvulsoService lancamentoAvulsoService;
	
	@EJB
	private LancamentoAgendadoService lancamentoAgendadoService;
	
	@EJB
	private GratificacaoEncargosEspeciaisService gratificacaoEncargosEspeciaisService;
	
	@EJB
	private PagamentoService pagamentoService;
	
	@EJB
	private DadosConsolidadosService dadosConsolidadosService;
	
	private transient Logger logger = LoggerFactory.getLogger(FolhaNormalCalculoApplier.class);
	
	public static FolhaNormalCalculoApplier newInstance() {
		return new FolhaNormalCalculoApplier();
	}
	
	public static FolhaNormalCalculoApplier instance() {
		if (instance == null) {
			instance = new FolhaNormalCalculoApplier(); 
		}
		
		return instance;
	}
	
	@Override
	public void aplicarResultadoDoCalculo(Contexto contexto, List<ItemCalculo> input, Pessoa pessoa, Funcionario funcionario) {
		// TODO aqui vamos pegar os itens de calculo processados e verificar a acao a ser tomada para cada item, aplicar a ação com base no resultado
		
		/*
		 *   para cada item de cálculo calculado:
		 *     executar ação, 
		 *     aplicar resultado:
		 *     	 criar pagamento(se não existir) e itens;
		 *       setar parcela paga;
		 *       setar lançamento pago;
		 *       etc
		 * fazer totalizações do funcionário
		 */
		
		for (ItemCalculo itemCalculo : input) {
			
			List<TipoAcaoItemCalculo> acoes = itemCalculo.getAcoesAExecutar();
			
			if (acoes!=null) { 
				for (TipoAcaoItemCalculo acao : acoes) {
					switch(acao) {
						case NADA: {
							nada(itemCalculo, pessoa);
							break;
						}
						case BEEP: {
							beep(itemCalculo, pessoa);
							break;
						}
						case LANCAR_CREDITO: {
							lancarCredito(contexto, itemCalculo, pessoa);
							break;
						}
						case LANCAR_DEBITO: {
							lancarDebito(contexto, itemCalculo, pessoa);
							break;
						}
						case LANCAR_SUBTOTAL: {
							lancarSubTotal(contexto, itemCalculo, pessoa);
							break;
						}
						case LANCAR_SUBTOTAL_CREDITO: {
							lancarSubTotalCredito(contexto, itemCalculo, pessoa);
							break;
						}
						case LANCAR_SUBTOTAL_DEBITO: {
							lancarSubTotalDebito(contexto, itemCalculo, pessoa);
							break;
						}
						case LANCAR_TOTAL: {
							lancarTotal(contexto, itemCalculo, pessoa);
							break;
						}
						case PAGAR_GRATIFICACAO_ENCARGOS_ESPECIAIS: {
							pagarGratificaoEncargosEspeciais(contexto, itemCalculo, pessoa);
							break;
						}
						case PAGAR_LANCAMENTO_AGENDADO: {
							pagarLancamentoAgendado(contexto, itemCalculo, pessoa);
							break;
						}
						case PAGAR_LANCAMENTO_AVULSO: {
							pagarLancamentoAvulso(contexto, itemCalculo, pessoa);
							break;
						}
						case PAGAR_PARCELA_EMPRESTIMO_CONSIGNADO: {
							pagarParcelaEmprestimoConsignado(contexto, itemCalculo, pessoa);
							break;
						}
						case REGISTRAR_HISTORICO_DO_LANCAMENTO_RECORRENTE: {
							registrarHistoricoLancamentoRecorrente(contexto, itemCalculo, pessoa);
							break;
						}
						default: {
							executarAcaoDefault(contexto, itemCalculo, pessoa);
							break;
						}
					}
				}
			}
		}
	}

	private FolhaNormalCalculoApplier executarAcaoDefault(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		return this;
	}
	
	private FolhaNormalCalculoApplier registrarHistoricoLancamentoRecorrente(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		LancamentoRecorrente l = itemCalculo.getLancamentoRecorrente();
		lancamentoRecorrenteService.registrarHistoricoPagamento(l);
		return this;
	}
	
	private FolhaNormalCalculoApplier pagarParcelaEmprestimoConsignado(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		ParcelaEmprestimoConsignado p = itemCalculo.getParcelaEmprestimoConsignado();
		Date dataPagamento = null;
		Double valorPago = null;
		emprestimoConsignadoService.pagarParcela(p, dataPagamento, valorPago);
		return this;
	}

	private FolhaNormalCalculoApplier pagarLancamentoAvulso(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		LancamentoAvulso l = itemCalculo.getLancamentoAvulso();
		Date dataPagamento = new Date();
		Double valorPago = itemCalculo.getResultado().getResultado();
		
		lancamentoAvulsoService.pagarLancamento(l, dataPagamento, valorPago);
        logger.debug("FolhaNormalCalculoApplier.pagarLancamentoAvulso: lancamentoAvulso = "+l);
		return this;
	}
	
	private FolhaNormalCalculoApplier pagarLancamentoAgendado(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		LancamentoAgendado l = itemCalculo.getLancamentoAgendado();
		Date dataPagamento = null;
		Double valorPago = null;
		lancamentoAgendadoService.pagarLancamento(l, dataPagamento, valorPago);
		return this;
	}
	
	private FolhaNormalCalculoApplier pagarGratificaoEncargosEspeciais(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		ConcessaoGratificacaoEncargosEspeciais g = itemCalculo.getConcessaoGratificacaoEncargosEspeciais();
		Date dataPagamento = null;
		Double valorPago = null;
		gratificacaoEncargosEspeciaisService.pagarGratificacao(g, dataPagamento, valorPago);
		return this;
	}
	
	private FolhaNormalCalculoApplier lancarTotal(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		Pagamento pagamento = null;
		
		Double quantidade = null;
		String descricao = null;
		String mensagem = null;
		Double valor = null;
		
		pagamentoService.lancarItemTotal(pagamento, quantidade, descricao, mensagem, valor);

		return this;
	}

	private FolhaNormalCalculoApplier lancarSubTotal(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		Pagamento pagamento = null;
		
		Double quantidade = null;
		String descricao = null;
		String mensagem = null;
		Double valor = null;
		
		pagamentoService.lancarItemSubTotal(pagamento, quantidade, descricao, mensagem, valor);

		return this;
	}
	
	private FolhaNormalCalculoApplier lancarSubTotalDebito(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		Pagamento pagamento = null;
		
		Double quantidade = null;
		String descricao = null;
		String mensagem = null;
		Double valor = null;
		
		pagamentoService.lancarItemSubTotalDebito(pagamento, quantidade, descricao, mensagem, valor);

		return this;
		
	}

	private FolhaNormalCalculoApplier lancarSubTotalCredito(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		Pagamento pagamento = null;
		
		Double quantidade = null;
		String descricao = null;
		String mensagem = null;
		Double valor = null;
		
		pagamentoService.lancarItemSubTotalCredito(pagamento, quantidade, descricao, mensagem, valor);

		return this;
	}

	private FolhaNormalCalculoApplier lancarDebito(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		
		Funcionario funcionario = contexto.getFuncionario();
		
		Pagamento pagamento = retornaOuCriaPagamento(pessoa, funcionario, contexto);
		
		Double quantidade = getQuantidadeItemCalculo(itemCalculo, contexto, pessoa);
		String descricao = getDescricaoItemCalculo(itemCalculo, contexto, pessoa);
		String mensagem = getMensagemItemCalculo(itemCalculo, contexto, pessoa);
		Double valor = itemCalculo.getResultado().getResultado();
		
		pagamentoService.lancarItemDebito(pagamento, itemCalculo.getRubrica(), quantidade, descricao, mensagem, valor, itemCalculo.getEntidadeOrigem(), itemCalculo.getIdOrigem());

        logger.debug("FolhaNormalCalculoApplier.lancarCredito: itemCalculo = "+itemCalculo+", pessoa = "+pessoa);
        logger.debug("FolhaNormalCalculoApplier.lancarCredito: pagamento = "+pagamento);

		return this;
		
	}

	private FolhaNormalCalculoApplier lancarCredito(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {		
		Funcionario funcionario = contexto.getFuncionario();
		
		Pagamento pagamento = retornaOuCriaPagamento(pessoa, funcionario, contexto);
		
		Double quantidade = getQuantidadeItemCalculo(itemCalculo, contexto, pessoa);
		String descricao = getDescricaoItemCalculo(itemCalculo, contexto, pessoa);
		String mensagem = getMensagemItemCalculo(itemCalculo, contexto, pessoa);
		Double valor = itemCalculo.getResultado().getResultado();
		
		pagamentoService.lancarItemCredito(pagamento, itemCalculo.getRubrica(), quantidade, descricao, mensagem, valor, itemCalculo.getEntidadeOrigem(), itemCalculo.getIdOrigem());

        logger.debug("FolhaNormalCalculoApplier.lancarCredito: itemCalculo = "+itemCalculo+", pessoa = "+pessoa);
        logger.debug("FolhaNormalCalculoApplier.lancarCredito: pagamento = "+pagamento);

		return this;
	}

	private Pagamento retornaOuCriaPagamento(Pessoa pessoa, Funcionario funcionario, Contexto contexto) {
		
		List<Pagamento> pagamentos = contexto.getFolha().getPagamentos();
		
		for (Pagamento pagamento : pagamentos) {
			if (pagamento.getFuncionario().equals(funcionario)) {
				return pagamento;
			}
		}
		
		Pagamento pagamento = new Pagamento(funcionario, contexto.getFolha());
		
		List<ContaRecebimento> contas = funcionario.getPessoa().getContasRecebimentoAtivasPorTipo(TipoContaRecebimento.SALARIO);
		
		if (contas!=null && !contas.isEmpty()) {
			pagamento.setContaRecebimento(contas.get(0));
		}
		
		pagamento.setMensagem("");

		if (dadosConsolidadosService != null) {
			DadosConsolidadosDoFuncionario d = dadosConsolidadosService.obterUltimaConsolidacao(funcionario.getId());

            if (d == null || (DateUtilz.diasEntre(d.getDataConsolidacao(), new Date()) > 0)) {
				d = dadosConsolidadosService.consolidar(funcionario.getId());
				logger.debug("Dados consolidados criados: "+d.toString());
			}
			
			pagamento.setDadosConsolidadosDoFuncionario(d);
		}
		
		contexto.getFolha().getPagamentos().add(pagamento);
		
		return pagamento;
	}

	private FolhaNormalCalculoApplier beep(ItemCalculo itemCalculo, Pessoa pessoa) {
        logger.debug("BEEP: \n      "+itemCalculo+"\n      "+pessoa);
		return this;
	}
	
	private FolhaNormalCalculoApplier nada(ItemCalculo itemCalculo, Pessoa pessoa) {
        logger.debug("NADA a ser feito: \n      "+itemCalculo+"\n      "+pessoa);
		return this;
	}
	
	private String getMensagemItemCalculo(ItemCalculo itemCalculo, Contexto contexto, Pessoa pessoa) {
		return "";
	}

	private String getDescricaoItemCalculo(ItemCalculo itemCalculo, Contexto contexto, Pessoa pessoa) {
		String retorno = "";
		
		TipoItemCalculo tipo = itemCalculo.getTipo();
		
		switch (tipo) {
			case CONCESSAO_ADICIONAL_INSALUBRIDADE:
				break;
			case CONCESSAO_ADICIONAL_QUALIFICACAO:
				break;
			case CONCESSAO_AUXILIO_EDUCACAO_INFANTIL:
				break;
			case CONCESSAO_AUXILIO_TRANSPORTE:
				break;
			case CONCESSAO_FERIAS:
				break;
			case CONCESSAO_GRATIFICACAO_ENCARGOS_ESPECIAIS:
				break;
			case DESIGNACAO_ADICIONAL_TEMPO_INTEGRAL:
				break;
			case LANCAMENTO_AGENDADO:
				break;
			case LANCAMENTO_AVULSO: {
				if (itemCalculo.getLancamentoAvulso().getRubrica()!=null) {
					retorno = "Lançamento avulso - "+itemCalculo.getLancamentoAvulso().getRubrica().getDescricao();
				} else {
					retorno = "Lançamento avulso - "+itemCalculo.getLancamentoAvulso().getDescricao();
				}
				break;
			}
			case LANCAMENTO_RECORRENTE:
				break;
			case LICENCA:
				break;
			case PARCELA_EMPRESTIMO_CONSIGNADO: {
				if (itemCalculo.getParcelaEmprestimoConsignado().getEmprestimoConsignado().getRubrica() != null) {
					retorno = "Parcela "+itemCalculo.getParcelaEmprestimoConsignado().getSequencial()+"/"+itemCalculo.getParcelaEmprestimoConsignado().getEmprestimoConsignado().getNumeroParcelas()+" empréstimo consignado - "+itemCalculo.getParcelaEmprestimoConsignado().getEmprestimoConsignado().getRubrica().getDescricao();
				} else {
					retorno = "Parcela "+itemCalculo.getParcelaEmprestimoConsignado().getSequencial()+"/"+itemCalculo.getParcelaEmprestimoConsignado().getEmprestimoConsignado().getNumeroParcelas()+" empréstimo consignado";
				}
				break;
			}
			case PLANO_SAUDE_PESSOA_INCLUSA:
				break;
			case PLANO_SAUDE_RESPONSAVEL_FINANCEIRO: {
				retorno = itemCalculo.getContratoPlanoSaude().getPlanoSaude().getDescricao()+"/"+itemCalculo.getContratoPlanoSaude().getPlanoSaude().getModalidade();
				break;
			}
			case RUBRICA_CARGO: {
				retorno = "Rubrica do cargo - "+itemCalculo.getRubrica().getDescricao();
				break;
			}				
			case RUBRICA_FUNCIONARIO:{
				retorno = "Rubrica do funcionário - "+itemCalculo.getRubrica().getDescricao();
				break;
			}
			default:
				break;
		}
		
		return retorno;
	}

	private Double getQuantidadeItemCalculo(ItemCalculo itemCalculo, Contexto contexto, Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}	

	public LancamentoRecorrenteService getLancamentoRecorrenteService() {
		return lancamentoRecorrenteService;
	}

	public void setLancamentoRecorrenteService(LancamentoRecorrenteService lancamentoRecorrenteService) {
		this.lancamentoRecorrenteService = lancamentoRecorrenteService;
	}

	public EmprestimoConsignadoService getEmprestimoConsignadoService() {
		return emprestimoConsignadoService;
	}

	public void setEmprestimoConsignadoService(EmprestimoConsignadoService emprestimoConsignadoService) {
		this.emprestimoConsignadoService = emprestimoConsignadoService;
	}

	public LancamentoAvulsoService getLancamentoAvulsoService() {
		return lancamentoAvulsoService;
	}

	public void setLancamentoAvulsoService(LancamentoAvulsoService lancamentoAvulsoService) {
		this.lancamentoAvulsoService = lancamentoAvulsoService;
	}

	public LancamentoAgendadoService getLancamentoAgendadoService() {
		return lancamentoAgendadoService;
	}

	public void setLancamentoAgendadoService(LancamentoAgendadoService lancamentoAgendadoService) {
		this.lancamentoAgendadoService = lancamentoAgendadoService;
	}

	public GratificacaoEncargosEspeciaisService getGratificacaoEncargosEspeciaisService() {
		return gratificacaoEncargosEspeciaisService;
	}

	public void setGratificacaoEncargosEspeciaisService(
			GratificacaoEncargosEspeciaisService gratificacaoEncargosEspeciaisService) {
		this.gratificacaoEncargosEspeciaisService = gratificacaoEncargosEspeciaisService;
	}

	public PagamentoService getPagamentoService() {
		return pagamentoService;
	}

	public void setPagamentoService(PagamentoService pagamentoService) {
		this.pagamentoService = pagamentoService;
	}

}