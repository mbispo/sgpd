package br.jus.tjms.sgpd.engine.calculo.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.ejb.AccessTimeout;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.jus.tjms.sgpd.entity.*;
import org.jboss.ejb3.annotation.TransactionTimeout;

import br.jus.tjms.sgpd.engine.calculo.FolhaCalculo;
import br.jus.tjms.sgpd.engine.calculo.FolhaCalculoApplier;
import br.jus.tjms.sgpd.engine.calculo.FolhaCalculoProcessor;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.engine.to.TipoItemCalculo;
import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;
import br.jus.tjms.sgpd.service.adicionalqualificacaoservices.ConcessaoAdicionalQualificacaoService;
import br.jus.tjms.sgpd.service.auxilioeducacaoservices.ConcessaoAuxilioEducacaoService;
import br.jus.tjms.sgpd.service.consignacaoservices.EmprestimoConsignadoService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.AdicionalInsalubridadeService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.AdicionalTempoIntegralService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.AuxilioTransporteService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.GratificacaoEncargosEspeciaisService;
import br.jus.tjms.sgpd.service.feriasservices.ConcessaoFeriasService;
import br.jus.tjms.sgpd.service.licencaservices.LicencaService;
import br.jus.tjms.sgpd.service.planosaudeservices.ContratoPlanoSaudeService;

@Stateless
@TransactionTimeout(value = 9999999)
public class FolhaNormalCalculo implements FolhaCalculo {
	
	private static final long serialVersionUID = 3180533163045568673L;

	static FolhaCalculo instance;
	
	@PersistenceContext
	private transient EntityManager em;
	
	@EJB
	private LicencaService licencaService;
	
	@EJB
	private ConcessaoFeriasService concessaoFeriasService;
	
	@EJB
	private ConcessaoAdicionalQualificacaoService concessaoAdicionalQualificacaoService;
	
	@EJB
	private ConcessaoAuxilioEducacaoService concessaoAuxilioEducacaoService;
	
	@EJB
	private ContratoPlanoSaudeService contratoPlanoSaudeService;
	
	@EJB
	private EmprestimoConsignadoService emprestimoConsignadoService;
	
	@EJB
	private AdicionalTempoIntegralService adicionalTempoIntegralService;
	
	@EJB
	private AuxilioTransporteService auxilioTransporteService;
	
	@EJB
	private GratificacaoEncargosEspeciaisService gratificacaoEncargosEspeciaisService;
	
	@EJB
	private AdicionalInsalubridadeService adicionalInsalubridadeService;
	
	@EJB(beanName="FolhaNormalCalculoApplier")
	private FolhaCalculoApplier folhaCalculoApplier;
	
	@EJB(beanName="FolhaNormalCalculoProcessor")
	private FolhaCalculoProcessor folhaCalculoProcessor;	
	
	public static FolhaCalculo newInstance() {
		return new FolhaNormalCalculo();
	}
	
	public static FolhaCalculo instance() {
		if (instance == null) {
			instance = new FolhaNormalCalculo(); 
		}
		
		return instance;
	}

	@Override
	@TransactionTimeout(value=9999999)
	@AccessTimeout(unit=TimeUnit.MINUTES,value=30)
	public Object calcular(Contexto contextoGlobal, FolhaPagamento folha) {

		Map<FuncionarioFolhaPagamento,List<ItemCalculo>> mapaFuncionarioItensCalculo = new HashMap<>();
		
		List<FuncionarioFolhaPagamento> funcionariosFolhaPagamento = folha.getFuncionarios();

		// para cada funcion??rio na folha
		for (FuncionarioFolhaPagamento funcionarioFolhaPagamento : funcionariosFolhaPagamento) {
			
			Date periodoInicio = folha.getDataInicial();
			Date periodoFim = folha.getDataFinal();
			
			List<ItemCalculo> itens = new ArrayList<>();
			
			criaItensDoCargo(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensDoFuncionario(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensAvulsos(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensAgendados(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensRecorrentes(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensConsignados(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensPlanoSaude(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensAuxilioEducacaoInfantil(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);

			criaItensAdicionalQualificacao(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensFerias(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensLicencas(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensAuxilioFuneral(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensConcessaoGratificaoEncargosEspeciais(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensConcessaoAuxilioTransporte(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			criaItensDesignacaoAdicionalTempoIntegral(funcionarioFolhaPagamento, periodoInicio, periodoFim, itens);
			
			// passo N: 
			/*
			 *     
			 *     Aposentadoria
			 *     AbonoPermanencia
			 *     
			 *     **** Plantao **** 
			 *     	  => Criar entidade plant??o (ver nome correto)
			 *           -> ato administrativo, tipo (normal, extraordin??rio), tipo pagamento (normal, com acrescimo), tipo cart??rio (C??vel, criminal, etc), confirmado?, celular, horas, minutos, noturno?
			 *     
			 *        OU
			 *       
			 *        => usar escala de plant??o 
			 *          <observar>: funcionario.escalaFuncionario(filtro: cumprida).escala(filtro: tipo=PLANTAO)
			 *        => apura????o de horas de plant??o
			 *          <observar>: funcionario.frequenciaApuracaoMes.frequenciaApuracaoDia.cargaHoraria(filtro: tipo=PLANTAO)
			 *     
			 *     	  OU
			 *     
			 *        => usar lan??amentos avulsos gerados a partir da apura????o de horas:
			 *           - apura????o de horas apura horas normais, extras, escalas de plant??o, de acordo com as regras de valor por local, periodo de recesso e tipo de plant??o 
			 *             (ver PORTARIA N. 494, DE 18 DE OUTUBRO DE 2013  http://www.tjms.jus.br/sistemas/biblioteca/legislacao_comp.php?lei=28815)
			 *           - tem a quest??o do plant??o extraordin??rio em horas (esp??cie de hora extra)
			 *             (ver PORTARIA N. 585, DE 2 DE JUNHO DE 2014 http://www.tjms.jus.br/sistemas/biblioteca/legislacao_comp.php?lei=29376)
			 *               
			 *     Pens??o, cad?? a pens??o?    
			 *       => Criar entidade para tratar as pens??es... (benefici??rio, instituidor, etc)
			 *     
			 *     FrequenciaApuracaoDia(filtrar: no per??odo) -> descontos e extras
			 *     Afastamento -> gera desconto?
			 *     Suspensao -> gera desconto?
			 *     Substituicao -> gera pagamento de sal??rio por substitui????o
			 *     Substituicao.renovacaoSubstituicao  -> gera pagamento de sal??rio por substitui????o
			 */
			
			// guarda itens de c??lculo do funcion??rio no mapa para processamento posteriormente
			mapaFuncionarioItensCalculo.put(funcionarioFolhaPagamento, itens);
			
		}
		
		processarMapaItens(contextoGlobal, folha, mapaFuncionarioItensCalculo);
		
		System.out.println("Folha "+folha+" calculada!");
		
		return null;
	}

	private void processarMapaItens(Contexto contextoGlobal, FolhaPagamento folha, Map<FuncionarioFolhaPagamento, List<ItemCalculo>> mapaFuncionarioItensCalculo) {

		// ap??s a montagem dos itens de c??lculo para cada funcion??rio na folha de pagamento, processa o c??lculo de cada item
		
		for (FuncionarioFolhaPagamento funcionarioFolhaPagamento : mapaFuncionarioItensCalculo.keySet()) {

            List<ItemCalculo> itensAProcessar = mapaFuncionarioItensCalculo.get(funcionarioFolhaPagamento);

			Contexto contextoDoFuncionario =
				new Contexto(em)
					.setPessoa(funcionarioFolhaPagamento.getFuncionario().getPessoa())
					.setFuncionario(funcionarioFolhaPagamento.getFuncionario())
					.setFolha(folha);

			List<ItemCalculo> itensProcessados = folhaCalculoProcessor.processarCalculo(contextoDoFuncionario, itensAProcessar, funcionarioFolhaPagamento.getFuncionario().getPessoa(), funcionarioFolhaPagamento.getFuncionario());
			folhaCalculoApplier.aplicarResultadoDoCalculo(contextoDoFuncionario, itensProcessados, funcionarioFolhaPagamento.getFuncionario().getPessoa(), funcionarioFolhaPagamento.getFuncionario());

		}
		
	}

	private void criaItensDesignacaoAdicionalTempoIntegral(
			FuncionarioFolhaPagamento funcionarioFolhaPagamento, Date periodoInicio, Date periodoFim,
			List<ItemCalculo> itens) {

		// passo 16: DesignacaoAdicionalTempoIntegral
		
		List<DesignacaoAdicionalTempoIntegral> designacoesAdicionalTempoIntegral = adicionalTempoIntegralService.obterDesignacoesAdicionalTempoIntegralVigentesNoPeriodo(funcionarioFolhaPagamento.getFuncionario(), periodoInicio, periodoFim);  

		if (designacoesAdicionalTempoIntegral!=null) {
			for (DesignacaoAdicionalTempoIntegral designacaoAdicionalTempoIntegral : designacoesAdicionalTempoIntegral) {
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setTipo(TipoItemCalculo.DESIGNACAO_ADICIONAL_TEMPO_INTEGRAL)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setDesignacaoAdicionalTempoIntegral(designacaoAdicionalTempoIntegral)
						);				
			}
		}

	}

	private void criaItensConcessaoAuxilioTransporte(FuncionarioFolhaPagamento funcionarioFolhaPagamento,
			Date periodoInicio, Date periodoFim, List<ItemCalculo> itens) {
		// passo 15: ConcessaoAuxilioTransporte		
		List<ConcessaoAuxilioTransporte> auxiliosTransporte = auxilioTransporteService.obterConcessoesAuxilioTransporteVigentesNoPeriodo(funcionarioFolhaPagamento.getFuncionario(), periodoInicio, periodoFim);
		
		if (auxiliosTransporte!=null) { 
			for (ConcessaoAuxilioTransporte concessaoAuxilioTransporte : auxiliosTransporte) {
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setTipo(TipoItemCalculo.CONCESSAO_AUXILIO_TRANSPORTE)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setConcessaoAuxilioTransporte(concessaoAuxilioTransporte)
						);
			}
		}

	}

	private void criaItensConcessaoGratificaoEncargosEspeciais(
			FuncionarioFolhaPagamento funcionarioFolhaPagamento, Date periodoInicio, Date periodoFim,
			List<ItemCalculo> itens) {
		// passo 14: ConcessaoGratificaoEncargosEspeciais
		
		List<ConcessaoGratificacaoEncargosEspeciais> gratificacoesEncargosEspeciais = gratificacaoEncargosEspeciaisService.obterConcessoesGratificacaoEncargosEspeciaisVigentesNoPeriodo(funcionarioFolhaPagamento.getFuncionario(), periodoInicio, periodoFim);
		
		if (gratificacoesEncargosEspeciais!=null) {
			for (ConcessaoGratificacaoEncargosEspeciais gratificacaoEncargosEspeciais : gratificacoesEncargosEspeciais) {
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setTipo(TipoItemCalculo.CONCESSAO_GRATIFICACAO_ENCARGOS_ESPECIAIS)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setConcessaoGratificacaoEncargosEspeciais(gratificacaoEncargosEspeciais)
						);				
			}
		}

	}

	private void criaItensAuxilioFuneral(FuncionarioFolhaPagamento funcionarioFolhaPagamento,
			Date periodoInicio, Date periodoFim, List<ItemCalculo> itens) {
		// passo 12: ConcessaoAuxilioFuneral -> gera benef??cio para o benefici??rio... 
		
		// ConcessaoAuxilioFuneral c = new ConcessaoAuxilioFuneral();
		// mapaFuncionarioItensCalculo.get(c.)
		

		// passo 13: ConcessaoAdicionalInsalubridade
		
		List<ConcessaoAdicionalInsalubridade> adicionaisInsalubridade = adicionalInsalubridadeService.obterConcessoesAdicionalInsalubridadeVigentesNoPeriodo(funcionarioFolhaPagamento.getFuncionario(), periodoInicio, periodoFim);
		
		if (adicionaisInsalubridade!=null) {
			for (ConcessaoAdicionalInsalubridade adicionalInsalubridade : adicionaisInsalubridade) {
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setTipo(TipoItemCalculo.CONCESSAO_ADICIONAL_INSALUBRIDADE)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setConcessaoAdicionalInsalubridade(adicionalInsalubridade)
						);				
			}
		}

	}

	private void criaItensLicencas(FuncionarioFolhaPagamento funcionarioFolhaPagamento, Date periodoInicio,
			Date periodoFim, List<ItemCalculo> itens) {
		// passo 11: licen??as com desconto no periodo
		
		// ConcessaoLicenca(filtrar: sem remunera????o no per??odo) -> descontos
		// Ser?? ???
		
		List<Licenca> licencas = licencaService.obterLicencasNoPeriodo(funcionarioFolhaPagamento.getFuncionario(), periodoInicio, periodoFim);
		
		if (licencas!=null) {
			for (Licenca licenca : licencas) {
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setTipo(TipoItemCalculo.LICENCA)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setLicenca(licenca)
						);				
			}
		}

	}

	private void criaItensFerias(FuncionarioFolhaPagamento funcionarioFolhaPagamento, Date periodoInicio,
			Date periodoFim, List<ItemCalculo> itens) {
		// TODO mover isso para FolhaFeriasCalculo
		// passo 10: adicional de f??rias (1/3) 
		
		// ConcessaoFerias(filtrar: confirmada) -> cr??dito de adicional de f??rias
		
		List<ConcessaoFerias> concessoesFerias = concessaoFeriasService.obterConcessoesFeriasNoPeriodo(funcionarioFolhaPagamento.getFuncionario(), periodoInicio, periodoFim);
		
		if (concessoesFerias!=null) {
			for (ConcessaoFerias ferias : concessoesFerias) {
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setTipo(TipoItemCalculo.CONCESSAO_FERIAS)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setConcessaoFerias(ferias)
						);
				
			}
		}

	}

	private void criaItensAdicionalQualificacao(FuncionarioFolhaPagamento funcionarioFolhaPagamento,
			Date periodoInicio, Date periodoFim, List<ItemCalculo> itens) {
		// passo 9: concess??o de adicional de qualifica????o 
		
		// ConcessaoAdicionalQualificacao -> cr??dito de adicional de qualifica????o

		List<ConcessaoAdicionalQualificacao> concessoesAdicionalQualificacao = concessaoAdicionalQualificacaoService.obterConcessoesAdicionalQualificacaoVigentesNoPeriodo(funcionarioFolhaPagamento.getFuncionario(), periodoInicio, periodoFim);
		
		if (concessoesAdicionalQualificacao!=null) {
			for (ConcessaoAdicionalQualificacao concessaoAdicionalQualificacao : concessoesAdicionalQualificacao) {
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setTipo(TipoItemCalculo.CONCESSAO_ADICIONAL_QUALIFICACAO)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setConcessaoAdicionalQualificacao(concessaoAdicionalQualificacao)
						);
				
			}
		}

	}

	private void criaItensAuxilioEducacaoInfantil(FuncionarioFolhaPagamento funcionarioFolhaPagamento,
			Date periodoInicio, Date periodoFim, List<ItemCalculo> itens) {
		// passo 8: concess??o de aux??lio educa??ao infantil 
		
		// ConcessaoAuxilioEducacaoInfantil(filtrar: v??lido no per??odo) -> cr??dito de aux??lio educa????o infantil
		
		// TODO aux??lio educa????o infantil possui uma rubrica fixa (cd_rbc = 324) com valor fixo nos par??metros (possui vig??ncia)
		
		List<ConcessaoAuxilioEducacaoInfantil> concessoesAuxilioEducacaoInfantil = concessaoAuxilioEducacaoService.obterConcessoesAuxilioEducacaoInfantilVigentesNoPeriodo(funcionarioFolhaPagamento.getFuncionario(), periodoInicio, periodoFim);
		
		if (concessoesAuxilioEducacaoInfantil!=null) {
			for (ConcessaoAuxilioEducacaoInfantil concessaoAuxilioEducacaoInfantil : concessoesAuxilioEducacaoInfantil) {
				
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setOrdem(0)
							.setTipo(TipoItemCalculo.CONCESSAO_AUXILIO_EDUCACAO_INFANTIL)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setConcessaoAuxilioEducacaoInfantil(concessaoAuxilioEducacaoInfantil)					
						);
	
			}
		}

	}

	private void criaItensPlanoSaude(FuncionarioFolhaPagamento funcionarioFolhaPagamento,
			Date periodoInicio, Date periodoFim, List<ItemCalculo> itens) {
		// passo 7: 
		/*
		 *   pegar lista de contratos de plano de sa??de ativos
		 *     <observar>: funcionario.contratoPlanoSaude(filtrar: ativo).pessoasInclusas(filtrar: ativa).planoSaude.rubricaPlanoSaude.*
		 *     <observar>: titular.planoSaude.rubricaPlanoSaude.*
		 *     colocar na lista de itens para c??lculo
		 */
		
		// TODO lista de despesas avulsas por operadora de plano de sa??de
		// TODO lista de faixa et??ria e valor por plano/operadora
		List<ContratoPlanoSaude> contratosPlanoSaude = contratoPlanoSaudeService.obterContratosPlanoSaudeAtivosDoFuncionario(funcionarioFolhaPagamento.getFuncionario(), periodoInicio, periodoFim);
		
		if (contratosPlanoSaude!=null) {
			for (ContratoPlanoSaude contratoPlanoSaude : contratosPlanoSaude) {
	
				List<RubricaPlanoSaude> rubricasPlanoSaude = contratoPlanoSaude.getPlanoSaude().getRubricas();
				
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setOrdem(rubricasPlanoSaude.get(0).getRubrica().getSequenciaCalculo())
							.setRubrica(rubricasPlanoSaude.get(0).getRubrica())
							.setTipo(TipoItemCalculo.PLANO_SAUDE_RESPONSAVEL_FINANCEIRO)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setContratoPlanoSaude(contratoPlanoSaude)
							.setRubricasPlanoSaude(rubricasPlanoSaude)
	
						);
				
				
				List<PessoaInclusaContratoPlanoSaude> pessoasInclusas = contratoPlanoSaude.getPessoasInclusas();
				
				if (pessoasInclusas != null) {
				
					itens.add(
							new ItemCalculo(Long.valueOf(itens.size()))
								.setOrdem(rubricasPlanoSaude.get(0).getRubrica().getSequenciaCalculo())
								.setTipo(TipoItemCalculo.PLANO_SAUDE_PESSOA_INCLUSA)
								.setPeriodoInicio(periodoInicio)
								.setPeriodoFim(periodoFim)
								.setContratoPlanoSaude(contratoPlanoSaude)
								.setRubricasPlanoSaude(rubricasPlanoSaude)
								.setPessoasInclusasContratoPlanoSaude(pessoasInclusas)
							);
	
				}
				
				/*
				 * 
				 * Plano de sa??de possui List<RubricaPlanoSaude>, RubricaPlanoSaude possui percentual
				 *   -> valor do plano ?? o somat??rio dos valores calculados de cada RubricaPlanoSaude multiplicado pelo percentual
				 * 
				 * Pessoas inclusas no plano de sa??de:
				 *   -> cada PessoasInclusasContratoPlanoSaude possui tipoCobranca(VALOR,PORCENTAGEM)
				 *      -> se PessoasInclusasContratoPlanoSaude.tipoCobranca=VALOR ent??o usar o valor calculado do plano, conforme a f??rmula anterior
				 *      -> se PessoasInclusasContratoPlanoSaude.tipoCobranca=PORCENTAGEM ent??o usar o valor calculado do plano, conforme a f??rmula anterior, multiplicado pelo percentual
				 * 
				 */
			}
		}

	}

	private void criaItensConsignados(FuncionarioFolhaPagamento funcionarioFolhaPagamento,
			Date periodoInicio, Date periodoFim, List<ItemCalculo> itens) {
		// passo 6: emprestimos consignados
		/*
		 *   pegar lista de emprestimos consignados, pegar parcelas a descontar
		 *     <observar>: ??parcelas a descontar que seriam lan??amentos agendados??
		 *     <observar>: funcionario.emprestimoConsignado(filtrar: ativo).parcelaEmprestimoConsignado(filtrar: aberta, vencida no per??odo)
		 *     colocar na lista de itens para c??lculo
		 */

		List<ParcelaEmprestimoConsignado> parcelasEmprestimoConsignado = emprestimoConsignadoService.obterParcelasEmprestimoConsigandoEmAbertoNoPeriodo(funcionarioFolhaPagamento.getFuncionario(),periodoInicio,periodoFim);
		
		if (parcelasEmprestimoConsignado!=null) {
			for (ParcelaEmprestimoConsignado parcelaEmprestimoConsignado : parcelasEmprestimoConsignado) {
				Rubrica rubricaDoEmprestimo = parcelaEmprestimoConsignado.getEmprestimoConsignado().getRubrica();
	
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setOrdem(rubricaDoEmprestimo != null ? rubricaDoEmprestimo.getSequenciaCalculo() : 0)
							.setTipo(TipoItemCalculo.PARCELA_EMPRESTIMO_CONSIGNADO)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setRubrica(rubricaDoEmprestimo)
							.setParcelaEmprestimoConsignado(parcelaEmprestimoConsignado)
						);
				
			}
		}

	}

	private void criaItensRecorrentes(FuncionarioFolhaPagamento funcionarioFolhaPagamento,
			Date periodoInicio, Date periodoFim, List<ItemCalculo> itens) {
		// passo 5: lan??amentos recorrentes
		/*
		 *   pegar lista de lan??amentos recorrentes ativos no per??odo
		 *     <observar>: funcionario.lancamentoRecorrente(filtrar: v??lido para o per??odo)
		 *     colocar lan??amento na lista de itens para c??lculo
		 */
		
		List<LancamentoRecorrente> lancamentosRecorrentes = funcionarioFolhaPagamento.getFuncionario().getLancamentosRecorrentesValidosParaOPeriodo(periodoInicio, periodoFim);
		
		if (lancamentosRecorrentes!=null) {
			for (LancamentoRecorrente lancamentoRecorrente : lancamentosRecorrentes) {
				
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setOrdem(lancamentoRecorrente.getRubrica() != null ? lancamentoRecorrente.getRubrica().getSequenciaCalculo() : 0)
							.setTipo(TipoItemCalculo.LANCAMENTO_RECORRENTE)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setRubrica(lancamentoRecorrente.getRubrica())
							.setLancamentoRecorrente(lancamentoRecorrente)
						);
				
			}
		}

	}

	private void criaItensAgendados(FuncionarioFolhaPagamento funcionarioFolhaPagamento,
			Date periodoInicio, Date periodoFim, List<ItemCalculo> itens) {
		// passo 4: lan??amentos agendados
		/*
		 *   pegar lista de lan??amentos agendados para o per??odo
		 *     <observar>: funcionario.lancamentoAgendado(filtrar: agendado para o per??odo)
		 *     colocar lan??amento na lista de itens para c??lculo
		 */
		
		List<LancamentoAgendado> lancamentosAgendados = funcionarioFolhaPagamento.getFuncionario().getLancamentosAgendadosParaOPeriodo(periodoInicio, periodoFim);
		
		if (lancamentosAgendados!=null) {
			for (LancamentoAgendado lancamentoAgendado : lancamentosAgendados) {
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setOrdem(lancamentoAgendado.getRubrica() != null ? lancamentoAgendado.getRubrica().getSequenciaCalculo() : 0)
							.setTipo(TipoItemCalculo.LANCAMENTO_AGENDADO)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setRubrica(lancamentoAgendado.getRubrica())
							.setLancamentoAgendado(lancamentoAgendado)
						);
			}
		}

	}

	private void criaItensAvulsos(FuncionarioFolhaPagamento funcionarioFolhaPagamento, Date periodoInicio,
			Date periodoFim, List<ItemCalculo> itens) {
		// passo 3: lan??amentos avulsos
		/*
		 *   pegar lista de lan??amentos avulsos
		 *     <observar>: funcionario.lancamentoAvulso(filtrar: em aberto)
		 *     colocar lan??amento na lista de itens para c??lculo
		 */

		List<LancamentoAvulso> lancamentosAvulsos = funcionarioFolhaPagamento.getFuncionario().getLancamentosAvulsosEmAberto();
		
		if (lancamentosAvulsos!=null) {
			for (LancamentoAvulso lancamentoAvulso : lancamentosAvulsos) {
				
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setOrdem(lancamentoAvulso.getRubrica() != null ? (lancamentoAvulso.getRubrica().getSequenciaCalculo()!=null?lancamentoAvulso.getRubrica().getSequenciaCalculo():0) : 0)
							.setTipo(TipoItemCalculo.LANCAMENTO_AVULSO)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setRubrica(lancamentoAvulso.getRubrica())
							.setLancamentoAvulso(lancamentoAvulso)
						);
				
			}
		}

	}

	private void criaItensDoFuncionario(FuncionarioFolhaPagamento funcionarioFolhaPagamento,
			Date periodoInicio, Date periodoFim, List<ItemCalculo> itens) {
		// passo 2: rubricas do funcion??rio
		/*
		 *   pegar lista de rubricas do funcion??rio
		 *   para cada rubrica do funcion??rio:
		 *     <observar>: funcionario.rubricaFuncionario.rubrica
		 *     colocar rubrica do funcion??rio na lista de itens para c??lculo
		 */
		List<RubricaFuncionario> rubricasFuncionario = funcionarioFolhaPagamento.getFuncionario().getRubricas();
		
		for (RubricaFuncionario rubricaFuncionario : rubricasFuncionario) {
			if (rubricaFuncionario.getTipoFolhaPagamento() == null || rubricaFuncionario.getTipoFolhaPagamento().equals(TipoFolhaPagamento.NORMAL)){
				itens.add(
						new ItemCalculo(Long.valueOf(itens.size()))
							.setOrdem(rubricaFuncionario.getRubrica().getSequenciaCalculo())
							.setTipo(TipoItemCalculo.RUBRICA_FUNCIONARIO)
							.setPeriodoInicio(periodoInicio)
							.setPeriodoFim(periodoFim)
							.setRubrica(rubricaFuncionario.getRubrica())
							.setRubricaFuncionario(rubricaFuncionario)
						);
			}
			
		}

	}

	private void criaItensDoCargo(FuncionarioFolhaPagamento funcionarioFolhaPagamento, Date periodoInicio,
			Date periodoFim, List<ItemCalculo> itens) {
		// passo 1: cargos, rubricas do cargo
		/*
		 *   pegar lista de cargos ativos 
		 *   para cada cargo ativo:
		 *     pegar a lista de rubricas do cargo
		 *     <observar>: funcionario.funcionarioCargo.cargo(filtrar: ativos no per??odo).rubricaCargo.rubrica, funcionario.funcionarioCargo.progressaoFuncional.referencia.referenciaValor(filtrar: ativo no per??odo)
		 *     colocar na lista de itens para c??lculo*
		 */

		List<FuncionarioCargo> funcionarioCargos = funcionarioFolhaPagamento.getFuncionario().getCargosAtivos(periodoInicio, periodoFim);
		
		for (FuncionarioCargo funcionarioCargo : funcionarioCargos) {
			
			List<RubricaCargo> rubricasCargo = funcionarioCargo.getCargo().getRubricas();
			
			ReferenciaValor referenciaValor = funcionarioCargo.getProgressaoAtual()!=null?funcionarioCargo.getProgressaoAtual().getReferencia().getValorAtual(new Date()):null;
			
			for (RubricaCargo rubricaCargo : rubricasCargo) {
				if (rubricaCargo.getTipoFolhaPagamento() == null || rubricaCargo.getTipoFolhaPagamento().equals(TipoFolhaPagamento.NORMAL)){
					itens.add(
							new ItemCalculo(Long.valueOf(itens.size()))
								.setOrdem(rubricaCargo.getRubrica().getSequenciaCalculo())
								.setTipo(TipoItemCalculo.RUBRICA_CARGO)
								.setCargo(funcionarioCargo.getCargo())
								.setFuncionarioCargo(funcionarioCargo)								
								.setReferenciaValor(referenciaValor)
								.setPeriodoInicio(funcionarioCargo.getDataInicio())
								.setPeriodoFim(funcionarioCargo.getDataInicio())
								.setRubrica(rubricaCargo.getRubrica())								
							);
				}
				
			}
			
		}

	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public LicencaService getLicencaService() {
		return licencaService;
	}

	public FolhaNormalCalculo setLicencaService(LicencaService licencaService) {
		this.licencaService = licencaService;
		return this;
	}

	public ConcessaoFeriasService getConcessaoFeriasService() {
		return concessaoFeriasService;
	}

	public FolhaNormalCalculo setConcessaoFeriasService(ConcessaoFeriasService concessaoFeriasService) {
		this.concessaoFeriasService = concessaoFeriasService;
		return this;
	}

	public ConcessaoAdicionalQualificacaoService getConcessaoAdicionalQualificacaoService() {
		return concessaoAdicionalQualificacaoService;
	}

	public FolhaNormalCalculo setConcessaoAdicionalQualificacaoService(
			ConcessaoAdicionalQualificacaoService concessaoAdicionalQualificacaoService) {
		this.concessaoAdicionalQualificacaoService = concessaoAdicionalQualificacaoService;
		return this;
	}

	public ConcessaoAuxilioEducacaoService getConcessaoAuxilioEducacaoService() {
		return concessaoAuxilioEducacaoService;
	}

	public FolhaNormalCalculo setConcessaoAuxilioEducacaoService(ConcessaoAuxilioEducacaoService concessaoAuxilioEducacaoService) {
		this.concessaoAuxilioEducacaoService = concessaoAuxilioEducacaoService;
		return this;
	}

	public ContratoPlanoSaudeService getContratoPlanoSaudeService() {
		return contratoPlanoSaudeService;
	}

	public FolhaNormalCalculo setContratoPlanoSaudeService(ContratoPlanoSaudeService contratoPlanoSaudeService) {
		this.contratoPlanoSaudeService = contratoPlanoSaudeService;
		return this;
	}

	public EmprestimoConsignadoService getEmprestimoConsignadoService() {
		return emprestimoConsignadoService;
	}

	public FolhaNormalCalculo setEmprestimoConsignadoService(EmprestimoConsignadoService emprestimoConsignadoService) {
		this.emprestimoConsignadoService = emprestimoConsignadoService;
		return this;
	}

	public AdicionalTempoIntegralService getAdicionalTempoIntegralService() {
		return adicionalTempoIntegralService;
	}

	public FolhaNormalCalculo setAdicionalTempoIntegralService(AdicionalTempoIntegralService adicionalTempoIntegralService) {
		this.adicionalTempoIntegralService = adicionalTempoIntegralService;
		return this;
	}

	public AuxilioTransporteService getAuxilioTransporteService() {
		return auxilioTransporteService;
	}

	public FolhaNormalCalculo setAuxilioTransporteService(AuxilioTransporteService auxilioTransporteService) {
		this.auxilioTransporteService = auxilioTransporteService;
		return this;
	}

	public GratificacaoEncargosEspeciaisService getGratificacaoEncargosEspeciaisService() {
		return gratificacaoEncargosEspeciaisService;
	}

	public FolhaNormalCalculo setGratificacaoEncargosEspeciaisService(
			GratificacaoEncargosEspeciaisService gratificacaoEncargosEspeciaisService) {
		this.gratificacaoEncargosEspeciaisService = gratificacaoEncargosEspeciaisService;
		return this;
	}

	public AdicionalInsalubridadeService getAdicionalInsalubridadeService() {
		return adicionalInsalubridadeService;
	}

	public FolhaNormalCalculo setAdicionalInsalubridadeService(AdicionalInsalubridadeService adicionalInsalubridadeService) {
		this.adicionalInsalubridadeService = adicionalInsalubridadeService;
		return this;
	}

	public FolhaCalculoApplier getFolhaCalculoApplier() {
		return folhaCalculoApplier;
	}

	public FolhaNormalCalculo setFolhaCalculoApplier(FolhaNormalCalculoApplier folhaCalculoApplier) {
		this.folhaCalculoApplier = folhaCalculoApplier;
		return this;
	}

	public FolhaCalculoProcessor getFolhaCalculoProcessor() {
		return folhaCalculoProcessor;
	}

	public FolhaNormalCalculo setFolhaCalculoProcessor(FolhaNormalCalculoProcessor folhaCalculoProcessor) {
		this.folhaCalculoProcessor = folhaCalculoProcessor;
		return this;
	}

}