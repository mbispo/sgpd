package br.jus.tjms.sgpd.engine.calculo.impl;

import br.jus.tjms.sgpd.engine.calculo.FolhaCalculoProcessor;
import br.jus.tjms.sgpd.engine.calculo.ItemCalculoResultadoRubricaFuncionarioFolhaCache;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.engine.to.TipoItemCalculo;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.entity.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.util.Collections;
import java.util.List;

@Stateless
public class FolhaNormalCalculoProcessor implements FolhaCalculoProcessor {
	
	private static final long serialVersionUID = -6482975222721475945L;
	
	static FolhaNormalCalculoProcessor instance;

    public transient Logger logger = LoggerFactory.getLogger(FolhaNormalCalculoProcessor.class);
	
	public static FolhaNormalCalculoProcessor newInstance() {
		return new FolhaNormalCalculoProcessor();
	}
	
	public static FolhaNormalCalculoProcessor instance() {
		if (instance == null) {
			instance = new FolhaNormalCalculoProcessor(); 
		}
		
		return instance;
	}
	
	@Override
	public List<ItemCalculo> processarCalculo(Contexto contexto, List<ItemCalculo> input, Pessoa pessoa, Funcionario funcionario) {
		
		/*
		 * Montar o contexo de cálculo
		 *   para cada item da lista de cálculo:
		 *     calcular o item
		 *     associar resultado do cálculo ao item
		 *     associar ação a ser tomada com o resultado
		 */
		List<ItemCalculo> output = ordenarItensDeCalculo(input);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache().limpar();

		for (ItemCalculo itemCalculo : output) {
			
			TipoItemCalculo tipo = itemCalculo.getTipo();
			/*
				RUBRICA_CARGO,
				RUBRICA_FUNCIONARIO,
				LANCAMENTO_AVULSO,
				LANCAMENTO_AGENDADO,
				LANCAMENTO_RECORRENTE,
				PARCELA_EMPRESTIMO_CONSIGNADO,
				PLANO_SAUDE_RESPONSAVEL_FINANCEIRO,
				PLANO_SAUDE_PESSOA_INCLUSA,
				CONCESSAO_AUXILIO_EDUCACAO_INFANTIL,
				CONCESSAO_ADICIONAL_QUALIFICACAO,
				CONCESSAO_FERIAS,
				LICENCA,
			 */
			
			switch (tipo) {
				case RUBRICA_CARGO: {
					processarRubricaCargo(contexto, itemCalculo, pessoa);
					break;
				}
				case RUBRICA_FUNCIONARIO: {
					processarRubricaFuncionario(contexto, itemCalculo, pessoa);
					break;
				}
				case LANCAMENTO_AVULSO: {
					processarLancamentoAvulso(contexto, itemCalculo, pessoa);
					break;
				}
				case LANCAMENTO_AGENDADO: {
					processarLancamentoAgendado(contexto, itemCalculo, pessoa);
					break;
				}
				case LANCAMENTO_RECORRENTE: {
					processarLancamentoRecorrente(contexto, itemCalculo, pessoa);
					break;
				}
				case PARCELA_EMPRESTIMO_CONSIGNADO: {
					processarParcelaEmprestimoConsignado(contexto, itemCalculo, pessoa);
					break;
				}
				case PLANO_SAUDE_RESPONSAVEL_FINANCEIRO: {
					processarPlanoSaudeResponsavelFinanceiro(contexto, itemCalculo, pessoa);
					break;
				}
				case PLANO_SAUDE_PESSOA_INCLUSA: {
					processarPlanoSaudePessoaInclusa(contexto, itemCalculo, pessoa);
					break;
				}
				case CONCESSAO_AUXILIO_EDUCACAO_INFANTIL: {
					processarConcessaoAuxilioEducacaoInfantil(contexto, itemCalculo, pessoa);
					break;
				}
				case CONCESSAO_ADICIONAL_QUALIFICACAO: {
					processarConcessaoAdicionalQualificacao(contexto, itemCalculo, pessoa);
					break;
				}
				case CONCESSAO_FERIAS: {
					processarConcessaoFerias(contexto, itemCalculo, pessoa);
					break;
				}
				case LICENCA: {
					processarLicenca(contexto, itemCalculo, pessoa);
					break;
				}
	
				default: {
					processarDefault(contexto, itemCalculo, pessoa);					
					break;
				}
			}
			
		}
		
		return output;
		
	}
	
	private List<ItemCalculo> ordenarItensDeCalculo(List<ItemCalculo> input) {
		Collections.sort(input);
		return input;
	}

	private FolhaNormalCalculoProcessor processarDefault(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		// TODO ação padrão...
		return this;
	}

	private FolhaNormalCalculoProcessor processarLicenca(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Licença, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = LicencaCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());

        logger.debug("Licença processada, output: "+itemCalculado);
		return this;
	}

	private FolhaNormalCalculoProcessor processarConcessaoFerias(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
        logger.debug("Concessão férias, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = ConcessaoFeriasCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());

        logger.debug("Concessão férias processada, output: "+itemCalculado);
		return this;
	}

	private FolhaNormalCalculoProcessor processarConcessaoAdicionalQualificacao(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Concessão adicional qualificação, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = ConcessaoAdicionalQualificacaoCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);

		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());
		
		logger.debug("Concessão adicional qualificação processado, output: "+itemCalculado);
		return this;
	}

	private FolhaNormalCalculoProcessor processarConcessaoAuxilioEducacaoInfantil(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Concessão auxílio educação infantil, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = ConcessaoAuxilioEducacaoInfantilCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());		
		
		logger.debug("Concessão auxílio educação infantil processada, output: "+itemCalculado);
		return this;
	}
	
	private FolhaNormalCalculoProcessor processarPlanoSaudePessoaInclusa(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Plano saúde pessoa inclusa, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = PlanoSaudePessoaInclusaCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());
		
		logger.debug("Plano saúde pessoa inclusa processado, output: "+itemCalculado);
		return this;
	}

	private FolhaNormalCalculoProcessor processarPlanoSaudeResponsavelFinanceiro(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Plano saúde responsável financeiro, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = PlanoSaudeResponsavelFinanceiroCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());		

		logger.debug("Plano saúde responsável financeiro processado, output: "+itemCalculado);
		return this;
	}

	private FolhaNormalCalculoProcessor processarParcelaEmprestimoConsignado(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Parcela empréstimo consignado, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = ParcelaEmprestimoConsignadoCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());		
		
		logger.debug("Parcela empréstimo consignado processada, output: "+itemCalculado);
		return this;
	}

	private FolhaNormalCalculoProcessor processarLancamentoRecorrente(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Lançamento recorrente, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = LancamentoRecorrenteCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());		
		
		logger.debug("Lançamento recorrente processado, output: "+itemCalculado);
		return this;
	}

	private FolhaNormalCalculoProcessor processarLancamentoAgendado(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Lançamento agendado, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = LancamentoAgendadoCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());		
		
		logger.debug("Lançamento agendado processado, output: "+itemCalculado);
		return this;
	}

	private FolhaNormalCalculoProcessor processarLancamentoAvulso(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Lançamento avulso, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = LancamentoAvulsoCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());
		
		logger.debug("Lançamento avulso processado, output: "+itemCalculado);
		return this;
	}

	private FolhaNormalCalculoProcessor processarRubricaFuncionario(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Rubrica do funcionário, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = RubricaFuncionarioCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());
		
		logger.debug("Rubrica do funcionário processada, output: "+itemCalculado);
		return this;
	}

	private FolhaNormalCalculoProcessor processarRubricaCargo(Contexto contexto, ItemCalculo itemCalculo, Pessoa pessoa) {
		logger.debug("Rubrica do cargo, processando input: "+itemCalculo);
		ItemCalculo itemCalculado = RubricaCargoCalculoProcessor.newInstance().processar(contexto, itemCalculo, pessoa);
		
		ItemCalculoResultadoRubricaFuncionarioFolhaCache
			.cache().adicionar(contexto.getFolha(), pessoa, contexto.getRubrica(), itemCalculado.getResultado());
		
		logger.debug("Rubrica do cargo processada, output: "+itemCalculado);
		return this;
	}

}