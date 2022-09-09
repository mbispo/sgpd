package br.jus.tjms.sgpd.tests.calculo;



import static org.junit.Assert.fail;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.*;
import br.jus.tjms.sgpd.enumerators.ModalidadePlanoSaude;
import br.jus.tjms.sgpd.enumerators.MotivoInicioRelacaoDependencia;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.enumerators.SituacaoContratoPlanoSaude;
import br.jus.tjms.sgpd.enumerators.SituacaoParcelaEmprestimoConsignado;
import br.jus.tjms.sgpd.enumerators.SituacaoPlanoSaude;
import br.jus.tjms.sgpd.enumerators.TipoBaseCalculo;
import br.jus.tjms.sgpd.enumerators.TipoEmprestimoConsignado;
import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.enumerators.TipoFuncionario;
import br.jus.tjms.sgpd.enumerators.TipoInputOutput;
import br.jus.tjms.sgpd.enumerators.TipoPlanoSaude;
import br.jus.tjms.sgpd.enumerators.TipoRelacaoDependencia;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;
import br.jus.tjms.sgpd.formulas.FormulaMSPREV;
import br.jus.tjms.sgpd.service.consignacaoservices.EmprestimoConsignadoService;
import br.jus.tjms.sgpd.service.planosaudeservices.ContratoPlanoSaudeService;
import br.jus.tjms.sgpd.tests.util.ExcelUtil;
import br.jus.tjms.sgpd.util.DateUtilz;

public class CalculoFolhaTestHelper {

	private static final String CARGO_NOME_TNS = "Técnico de nível superior";
	private static final String CARGO_SIMBOLO_TNS = "TNSU";


	public Contexto montaContextoParaTesteCalcularFolhaDecimoTerceiroFulanoDaSilvaDezembro2015(FolhaPagamento folha) {
		return new Contexto().setFolha(folha);
	}

	public FolhaPagamento montaFolhaParaTesteCalcularFolhaDecimoTerceiroFulanoDaSilvaDezembro2015() {
		// cria folha de pagamento
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		folhaPagamento.setAno(2015);
		folhaPagamento.setMes(12);
		folhaPagamento.setDescricao("Décimo terceiro de dezembro/2015");
		folhaPagamento.setTipo(TipoFolhaPagamento.DECIMO_TERCEIRO);
		// TODO criar folha de décimo terceiro para o teste
		
		return folhaPagamento;
	}
	
	public Contexto montaContextoParaTesteCalcularFolhaFeriasFulanoDaSilvaMarco2016(FolhaPagamento folha) {
		return new Contexto().setFolha(folha);
	}

	public FolhaPagamento montaFolhaParaTesteCalcularFolhaFeriasFulanoDaSilvaMarco2016() {
		// cria folha de pagamento
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		folhaPagamento.setAno(2016);
		folhaPagamento.setMes(3);
		folhaPagamento.setDescricao("Férias março/2016");
		folhaPagamento.setTipo(TipoFolhaPagamento.DECIMO_TERCEIRO);
		// TODO criar folha de férias para o teste
		
		return folhaPagamento;
	}
	
	public Contexto montaContextoParaTesteCalcularFolhaNormal(FolhaPagamento folha) {
		return new Contexto().setFolha(folha);
	}

	public FolhaPagamento montaFolhaParaTesteCalcularFolhaNormalMarcosAbril2016() {
		
		// cria folha de pagamento
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		folhaPagamento.setAno(2016);
		folhaPagamento.setMes(5);
		folhaPagamento.setDescricao("Normal de março/2016");
		folhaPagamento.setTipo(TipoFolhaPagamento.NORMAL);

		// roteiro:
		/*
		 * Criar funcionário Marcos
		 * Funcionário possui cargo 'Técnico de nível superior'
		 * Montar tabela de referências do TNSU com valores atuais
		 * Vincular referência atual do cargo
		 * Funcionário possui empréstimos consignados
		 * Funcionário possui plano de saúde cassems
		 * Descontar MS-PREV
		 * ...
		 */

		/*
		 * Montar configuração do cálculo:
		 *
		    -Ganhos-----------------------------------------

			Vencimento evetivo					5.591,44  	Valor atual da referência do cargo, TNSU - referencia 5 (inicial 1 5065,56)
			Adicional tempo serviço				  559,14   	10%, percentual variável sobre outras rubricas
			Abono lei 4835/2016					  500,00   	Programada (ver o cálculo, reproduzir no teste)

			Bruto								6.650,58

			-Descontos--------------------------------------

			Emprestimo consignado				1.032,31	Parcela de empréstimo consignado
			MS-PREV								  676,56	Programado, percentual sobre base de cálculo (ver o cálculo, reproduzir no teste)
			IRRF								  669,22	Programado, percentual sobre base de cálculo (ver o cálculo, reproduzir no teste)
			CASSEMS								  369,03	Na folha é programado, aqui deve ser com base em contrato de plano de saúde

			Descontos							2.747,12

			------------------------------------------------
			Líquido								3.903,46

		 *
		 */

		Double valorReferenciaInicial = 4000.0;
		Double valorReferenciaAtual = 5591.44;
		
		// cria o funcionario
		// Funcionario(Long id, Integer matricula, TipoFuncionario tipoFuncionario, Pessoa pessoa)
		Funcionario funcionario = new Funcionario(1l, 1, TipoFuncionario.SERVIDOR, new Pessoa(1l, "Marcos Bispo de Oliveira"));
		Pessoa mariana = new Pessoa(2l,"Mariana");
		Pessoa maria = new Pessoa(2l,"Maria Eduarda");
		
		funcionario.getPessoa().getRelacoesDependencia().add(new RelacaoDependencia(1l, funcionario.getPessoa(), maria, TipoRelacaoDependencia.MENOR, MotivoInicioRelacaoDependencia.NASCIMENTO, null, true, true, true, DateUtilz.criaData(11, 12, 2007), null));
		funcionario.getPessoa().getRelacoesDependencia().add(new RelacaoDependencia(1l, funcionario.getPessoa(), mariana, TipoRelacaoDependencia.MENOR, MotivoInicioRelacaoDependencia.NASCIMENTO, null, true, true, true, DateUtilz.criaData(20, 12, 2012), null));
		
		// cria o cargo
		Cargo cargo = new Cargo();
		cargo.setNome("Técnico de nível superior");
		cargo.setSimbolo("TNSU");

		Long idRubrica = 0l;
		// define as rubricas do cargo
		Rubrica vencimentoEfetivo = montaRubricaVencimentoEfetivo(++idRubrica,1);
		Rubrica msPrev = montaRubricaMSPrev(++idRubrica,998, TipoFormula.SCRIPT_GROOVY);
		Rubrica irrf = montaRubricaIrrf(++idRubrica,999);
		
		// associa ao cargo
		Long idRubricaCargo = 0l;
		cargo.getRubricas().add(new RubricaCargo(++idRubricaCargo, vencimentoEfetivo, cargo, TipoFolhaPagamento.NORMAL));
		cargo.getRubricas().add(new RubricaCargo(++idRubricaCargo, msPrev, cargo, TipoFolhaPagamento.NORMAL));
		cargo.getRubricas().add(new RubricaCargo(++idRubricaCargo, irrf, cargo, TipoFolhaPagamento.NORMAL));
		
		// vincula cargo ao funcionário
		FuncionarioCargo funcionarioCargo = montaCargoFuncionario(
				funcionario, cargo, valorReferenciaInicial, valorReferenciaAtual
			);
		funcionario.getCargos().add(funcionarioCargo);
		
		// define as rubricas do funcionário		
		Rubrica adicionalTempoServico = montaRubricaAdicionalTempoServico(++idRubrica,2,Arrays.asList(vencimentoEfetivo));
		Rubrica abono = montaRubricaAbono(++idRubrica,3);
		
		Long idRubricaFuncionario = 0l;
		funcionario.getRubricas().add(new RubricaFuncionario(++idRubricaFuncionario, funcionario, null, null, adicionalTempoServico, TipoFolhaPagamento.NORMAL, null, 10.0, null, null));
		funcionario.getRubricas().add(new RubricaFuncionario(++idRubricaFuncionario, funcionario, null, null, abono, TipoFolhaPagamento.NORMAL, null, null, null, null));
		
		// cria o empréstimo consignado, vinculado ao funcionário
		//Rubrica rubricaEmprestimoConsignado = montaRubricaEmprestimoConsignado(++idRubrica,997);
		
		Long idParcela = 0l; Integer sequencialParcela = 0;
		EmprestimoConsignado emprestimo = new EmprestimoConsignado(funcionario, null, 
				TipoEmprestimoConsignado.EMPRESTIMO, 10, 50000.0, 96, 1032.31, 
				DateUtilz.criaData(10, 1, 2016), null, new ArrayList<ParcelaEmprestimoConsignado>());
		emprestimo.ativar();
		emprestimo.getParcelas().add(new ParcelaEmprestimoConsignado(++idParcela, emprestimo, ++sequencialParcela, SituacaoParcelaEmprestimoConsignado.PAGA, 
				DateUtilz.criaData(10, 1, 2016), DateUtilz.criaData(10, 1, 2016), 1032.31, 1032.31));
		emprestimo.getParcelas().add(new ParcelaEmprestimoConsignado(++idParcela, emprestimo, ++sequencialParcela, SituacaoParcelaEmprestimoConsignado.PAGA, 
				DateUtilz.criaData(10, 2, 2016), DateUtilz.criaData(10, 2, 2016), 1032.31, 1032.31));
		emprestimo.getParcelas().add(new ParcelaEmprestimoConsignado(++idParcela, emprestimo, ++sequencialParcela, SituacaoParcelaEmprestimoConsignado.PAGA, 
				DateUtilz.criaData(10, 3, 2016), DateUtilz.criaData(10, 3, 2016), 1032.31, 1032.31));
		emprestimo.getParcelas().add(new ParcelaEmprestimoConsignado(++idParcela, emprestimo, ++sequencialParcela, SituacaoParcelaEmprestimoConsignado.PAGA, 
				DateUtilz.criaData(10, 4, 2016), DateUtilz.criaData(10, 4, 2016), 1032.31, 1032.31));
		
		emprestimo.getParcelas().add(new ParcelaEmprestimoConsignado(++idParcela, emprestimo, ++sequencialParcela, SituacaoParcelaEmprestimoConsignado.PENDENTE, 
				DateUtilz.criaData(10, 5, 2016), null, 1032.31, null));
		emprestimo.getParcelas().add(new ParcelaEmprestimoConsignado(++idParcela, emprestimo, ++sequencialParcela, SituacaoParcelaEmprestimoConsignado.PENDENTE, 
				DateUtilz.criaData(10, 6, 2016), null, 1032.31, null));
		emprestimo.getParcelas().add(new ParcelaEmprestimoConsignado(++idParcela, emprestimo, ++sequencialParcela, SituacaoParcelaEmprestimoConsignado.PENDENTE, 
				DateUtilz.criaData(10, 7, 2016), null, 1032.31, null));		

		// guarda dados de empréstimos para o teste
		EmprestimoConsignadoService.setTestingMode(true, Arrays.asList(emprestimo));
		
		// cria o plano de saúde cassems, vinculado ao funcionário		
		Rubrica cassems = montaRubricaCassems(++idRubrica,996);		
		
		PlanoSaude planoSaude = new PlanoSaude(new OperadoraPlanoSaude("Cassems", null, null, null),TipoPlanoSaude.BASICO, 
				ModalidadePlanoSaude.ENFERMARIA, "Cassems", SituacaoPlanoSaude.ATIVO, DateUtilz.criaData(1, 1, 2000), "", 
				Arrays.asList(new RubricaPlanoSaude(1l, cassems, null, 100.0)));

		ContratoPlanoSaude contratoPlanoSaude = new ContratoPlanoSaude(planoSaude, funcionario, funcionario, 
				DateUtilz.criaData(10, 4, 2006), SituacaoContratoPlanoSaude.ATIVO, DateUtilz.criaData(10, 4, 2006), "", 
				null);
		
		// guarda dados de planos de saúde para o teste
		ContratoPlanoSaudeService.setTestingMode(true, Arrays.asList(contratoPlanoSaude));
		
		// adiciona funcionário na folha para calcular
		folhaPagamento.getFuncionarios().add(new FuncionarioFolhaPagamento(1l, funcionario, folhaPagamento));
		
		return folhaPagamento;
	}
	
	@SuppressWarnings("unused")
	private Rubrica montaRubricaEmprestimoConsignado(Long id, Integer sequencial) {
		// Emprestimo consignado	1.032,31	Parcela de empréstimo consignado
		Rubrica rubrica = new Rubrica();
		rubrica.setId(id);
		rubrica.setDescricao("Empréstimo consignado");
		rubrica.setAtiva(true);
		rubrica.setSinal(Sinal.NEGATIVO);
		rubrica.setTipo(TipoRubrica.VALOR_FIXO);
		rubrica.setSequenciaCalculo(sequencial);
		return rubrica;
	}

	private Rubrica montaRubricaIrrf(Long id, Integer sequencial) {
		// IRRF						669,22	Programado, percentual sobre base de cálculo (ver o cálculo, reproduzir no teste)
		Rubrica irrf = new Rubrica();
		irrf.setId(id);
		irrf.setDescricao("Imposto de renda retido na fonte (IRRF)");
		irrf.setAtiva(true);
		irrf.setSinal(Sinal.NEGATIVO);
		irrf.setTipo(TipoRubrica.FORMULA);
		irrf.setSigla("IRRF");
		irrf.setUtilizaTiposBaseCalculo(Arrays.asList(new RubricaUtilizaBaseCalculo(1l, irrf, TipoBaseCalculo.IMPOSTO_RENDA)));
		irrf.setSequenciaCalculo(sequencial);
		
		irrf.setParametros(montaParametrosRubricaIrrf(irrf));	
		irrf.setFormulas(montaFormulasRubricaIrrf(irrf));
		
		return irrf;
	}

	private List<RubricaFormula> montaFormulasRubricaIrrf(Rubrica rubrica) {
		Formula formula = new Formula();
		formula.setTipo(TipoFormula.SCRIPT_GROOVY);
		formula.setScript(montaScriptGroovyIrrf());		
		formula.setInputs(montaInputsFormulaIrrf(formula));
		formula.setOutputs(montaOutputsFormulaIrrf(formula));
		formula.setNome("IRRF");
		formula.setGlobal(false);
		return Arrays.asList(new RubricaFormula(rubrica, formula));
	}
	
	private String montaScriptGroovyIrrf() {
		// script de cálculo do IRRF
		StringBuffer sb = new StringBuffer();
		
		/*
			ver o que precisa ir pelo contexto, exemplo: idade, aposentado, dependentes, base de irrf no mês, etc
			obs.: valor mínimo é 10,00
			
		 */
		
		/*
		 * Funções de data:
		 * 
			br.jus.tjms.sgpd.util.DateUtilz.primeiroDiaDoMes(Integer mes, Integer ano)
			br.jus.tjms.sgpd.util.DateUtilz.primeiroDiaDoMesAoFinalDoDia(Integer mes, Integer ano)
			br.jus.tjms.sgpd.util.DateUtilz.ultimoDiaDoMes(Integer mes, Integer ano)
			br.jus.tjms.sgpd.util.DateUtilz.ultimoDiaDoMesAoFinalDoDia(Integer mes, Integer ano)
			br.jus.tjms.sgpd.util.DateUtilz.criaData(Integer dia, Integer mes, Integer ano)
			br.jus.tjms.sgpd.util.DateUtilz.criaDataAoFinalDoDia(Integer dia, Integer mes, Integer ano)
			br.jus.tjms.sgpd.util.DateUtilz.retornaUltimoDiaMes(Integer mes, Integer ano)
		 *
		 */
		
		sb
			.append("\ndef obterNumeroDependentes(data) {")
			.append("\n	return contexto.pessoa.getNumeroDependentesImpostoRendaNaData(data)")
			.append("\n}")
			
			.append("\ndef obterParametroDeducaoPorDependente(data) {")
			.append("\n	return contexto.rubrica.getParametrosAtivos(data).first().valorDeducaoPorDependente")
			.append("\n}")
			
			.append("\ndef obterParametroDeducaoPorAposentadoriaOuIdade(data) {")
			.append("\n	//retorna 0 se não aposentado ou idade >= 65")
			.append("\n	deducao = contexto.rubrica.getParametrosAtivos(data).first().valorDeducaoPorIdade")
			.append("\n	return (contexto.pessoa.getIdadeNaData(data)>=65?deducao:(contexto.pessoaEstaAposentada?deducao:0))")			
			.append("\n}")
			
			.append("\ndef getTotalIrrfRetidoNoMes(ano,mes) {")
			.append("\n	return contexto.irrfNoMes(ano,mes)")			
			.append("\n}")
			
			.append("\ndef getBaseIrrfNoMes(ano, mes) {")
			.append("\n	baseIrrfNoMes = contexto.baseCalculoIrrfNoMes(ano, mes)")
			.append("\n	baseIrrfNaFolha = contexto.baseCalculoIrrfNaFolha()")
			.append("\n	return baseIrrfNoMes + baseIrrfNaFolha")			
			.append("\n}")
			
			.append("\ndef getPercentualIrrfNaFaixa(baseIrrf, data) {")
			.append("\n	return contexto.rubrica.getParametrosAtivos(data, baseIrrf).first().percentual")
			.append("\n}")
			
			.append("\ndef getDeducaoIrrfNaFaixa(baseIrrf, data) {")
			.append("\n	return contexto.rubrica.getParametrosAtivos(data, baseIrrf).first().valorDeducao")
			.append("\n}")

			.append("\nmes = contexto.folha.mes")
			.append("\nano = contexto.folha.ano")
			.append("\n")
			
			.append("\ndataFinalFolha = br.jus.tjms.sgpd.util.DateUtilz.ultimoDiaDoMesAoFinalDoDia(mes, ano)")
			.append("\ndataInicialFolha = br.jus.tjms.sgpd.util.DateUtilz.primeiroDiaDoMes(mes, ano)")
			.append("\n")
			
			.append("\nnumeroDependentes = obterNumeroDependentes(dataInicialFolha)")
			.append("\ndeducaoPorDependentes = obterParametroDeducaoPorDependente(dataInicialFolha)")
			.append("\ndeducaoPorAposentadoriaOuIdade = obterParametroDeducaoPorAposentadoriaOuIdade(dataInicialFolha)")
			.append("\n")
			
			.append("\ndescontoIrrfNoMes = getTotalIrrfRetidoNoMes(ano,mes)")
			.append("\nbaseIrrfNoMes = getBaseIrrfNoMes(ano, mes)")
			.append("\n")
			
			.append("\nbaseIrrf = baseIrrfNoMes - (deducaoPorDependentes*numeroDependentes) - deducaoPorAposentadoriaOuIdade")
			.append("\n")
			
			.append("\npercentualIrrfNaFaixa = getPercentualIrrfNaFaixa(baseIrrf, dataInicialFolha)")
			.append("\ndeducaoNaFaixa = getDeducaoIrrfNaFaixa(baseIrrf, dataInicialFolha)")
			
			.append("\nvlirrf = (baseIrrf * (percentualIrrfNaFaixa/100.0)) - (deducaoNaFaixa + descontoIrrfNoMes)")
			.append("\n")
			
			.append("\nDouble irrf = (vlirrf<10.0?0.0:vlirrf)")
			.append("\n")
			
			.append("\ncontexto.output('irrf').valor = irrf")
			.append("\ncontexto.output('baseIrrf').valor = baseIrrf")
			.append("\ncontexto.output('numeroDependentes').valor = numeroDependentes")
			.append("\ncontexto.output('deducaoPorDependentes').valor = deducaoPorDependentes")
			.append("\ncontexto.output('deducaoPorIdadeAposentadoria').valor = deducaoPorAposentadoriaOuIdade")
			
			.append("\nreturn irrf");
		
		System.out.println("\n\nScript do IRRF:\n\n"+sb.toString());
		
		return sb.toString();
	}
	
	private List<FormulaOutput> montaOutputsFormulaIrrf(Formula formula) {
		List<FormulaOutput> lista = new ArrayList<>();
		Integer seq = 0;
		lista.add(new FormulaOutput(formula, ++seq, true, "irrf", TipoInputOutput.DECIMAL, Double.class.getName()));
		lista.add(new FormulaOutput(formula, ++seq, true, "baseIrrf", TipoInputOutput.DECIMAL, Double.class.getName()));		
		lista.add(new FormulaOutput(formula, ++seq, true, "numeroDependentes", TipoInputOutput.INTEIRO, Integer.class.getName()));
		lista.add(new FormulaOutput(formula, ++seq, true, "deducaoPorDependentes", TipoInputOutput.DECIMAL, Double.class.getName()));
		lista.add(new FormulaOutput(formula, ++seq, true, "deducaoPorIdadeAposentadoria", TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}

	private List<FormulaInput> montaInputsFormulaIrrf(Formula formula) {
		// inputs da fórmula de IRRF
		List<FormulaInput> lista = new ArrayList<>();
		lista.add(new FormulaInput(formula, 1, "xyz", true, TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}

	private List<RubricaParametro> montaParametrosRubricaIrrf(Rubrica rubrica) {
		List<RubricaParametro> lista = new ArrayList<>();
		// definir parâmetros ativos (faixas do imposto de renda)
		lista.add(new RubricaParametro(rubrica, DateUtilz.criaData(1, 4, 2015), DateUtilz.criaData(31, 12, 2018),
				true, 1903.99, 2826.65, 7.5, null, null, 142.8, null, 189.59, 1903.98, null, null, null, null));
		lista.add(new RubricaParametro(rubrica, DateUtilz.criaData(1, 4, 2015), DateUtilz.criaData(31, 12, 2018),
				true, 2826.65, 3751.05, 15.0, null, null, 354.8, null, 189.59, 1903.98, null, null, null, null));
		lista.add(new RubricaParametro(rubrica, DateUtilz.criaData(1, 4, 2015), DateUtilz.criaData(31, 12, 2018),
				true, 3751.06, 4664.68, 22.5, null, null, 636.13, null, 189.59, 1903.98, null, null, null, null));
		lista.add(new RubricaParametro(rubrica, DateUtilz.criaData(1, 4, 2015), DateUtilz.criaData(31, 12, 2018),
				true, 4664.69, 9999999.99, 27.5, null, null, 869.36, null, 189.59, 1903.98, null, null, null, null));
		return lista;
	}

	private Rubrica montaRubricaMSPrev(Long id, Integer sequencial, TipoFormula tipoFormula) {
		// MS-PREV					676,56	Programado, percentual sobre base de cálculo (ver o cálculo, reproduzir no teste)
		Rubrica msPrev = new Rubrica();
		msPrev.setId(id);
		msPrev.setDescricao("Previdência RPPS (MS-PREV)");
		msPrev.setAtiva(true);
		msPrev.setSinal(Sinal.NEGATIVO);
		msPrev.setTipo(TipoRubrica.FORMULA);
		msPrev.setSigla("MS-PREV");
		msPrev.setUtilizaTiposBaseCalculo(Arrays.asList(new RubricaUtilizaBaseCalculo(2l, msPrev, TipoBaseCalculo.PREVIDENCIA_PROPRIA)));
		msPrev.setSequenciaCalculo(sequencial);
		
		// define a participação desta rubrica na composição da base de cálculo para impostos
		msPrev.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(msPrev, TipoBaseCalculo.IMPOSTO_RENDA));

		msPrev.setParametros(montaParametrosRubricaMSPrev(msPrev));

        if (TipoFormula.SCRIPT_GROOVY == tipoFormula) {
		    msPrev.setFormulas(montaFormulasRubricaMSPrev(msPrev));
        } else  if (TipoFormula.CLASSE == tipoFormula) {
            msPrev.setFormulas(montaFormulasRubricaMSPrevJava(msPrev));
        } else {
            throw new IllegalArgumentException("Tipo Formula informado não suportado: " + tipoFormula);
        }
		
		return msPrev;
	}

    private Formula montaFormulaRubricaMSPrevBasica(){
        Formula formula = new Formula();
        formula.setInputs(montaInputsFormulaMSPrev(formula));
        formula.setOutputs(montaOutputsFormulaMSPrev(formula));
        formula.setNome("MSPREV");
        formula.setGlobal(false);
        return formula;
    }

	private List<RubricaFormula> montaFormulasRubricaMSPrevJava(Rubrica rubrica) {
		Formula formula = montaFormulaRubricaMSPrevBasica();
        formula.setTipo(TipoFormula.CLASSE);
        formula.setExpressao(FormulaMSPREV.class.getName());
		return Arrays.asList(new RubricaFormula(rubrica, formula));
	}

    private List<RubricaFormula> montaFormulasRubricaMSPrev(Rubrica rubrica) {
        Formula formula = montaFormulaRubricaMSPrevBasica();
        formula.setTipo(TipoFormula.SCRIPT_GROOVY);
        formula.setScript(montaScriptGroovyMSPrev());
        return Arrays.asList(new RubricaFormula(rubrica, formula));
    }

	private String montaScriptGroovyMSPrev() {
		// script groovy do MSPREV
		StringBuffer sb = new StringBuffer();
		
		sb
			.append("\nmes = contexto.folha.mes")
			.append("\nano = contexto.folha.ano")
			.append("\n")
			.append("\ndataFinalFolha = br.jus.tjms.sgpd.util.DateUtilz.ultimoDiaDoMesAoFinalDoDia(mes, ano)")
			.append("\ndataInicialFolha = br.jus.tjms.sgpd.util.DateUtilz.primeiroDiaDoMes(mes, ano)")
			.append("\n")
			.append("\ndef  getTotalDescontosMSPrevNoMes(ano,mes) {")
			.append("\n	return contexto.previdenciaRegimeProprioNoMes(ano,mes)")
			.append("\n}")
			.append("\n")
			.append("\ndef getBaseMSPrevNoMes(ano, mes) {")
			.append("\n	baseNoMes = contexto.baseCalculoPrevidenciaRegimeProprioNoMes(ano, mes)")
			.append("\n	baseNaFolha = contexto.baseCalculoPrevidenciaRegimeProprioNaFolha()")
			.append("\n	return baseNoMes + baseNaFolha")
			.append("\n}")
			.append("\n")
			.append("\ndef getPercentualMSPrevNaFaixa(base, data) {")
			.append("\n	return contexto.rubrica.getParametrosAtivos(data, base).first().percentual")
			.append("\n}")
			.append("\n")
			.append("\ndef getTetoMSPrevNaFaixa(baseIrrf, data) {")
			.append("\n	return contexto.rubrica.getParametrosAtivos(data, baseIrrf).first().valorTeto")
			.append("\n}")
			.append("\n")
			.append("\ndef getFatorDeducaoTeto() {")
			.append("\n	return contexto.rubricaFuncionario!=null?contexto.rubricaFuncionario.quantidade:0.0")
			.append("\n}")
			.append("\n")
			.append("\ndef getDeducaoTetoMSPrev(teto) {")
			.append("\n	fatorDeducaoTeto = getFatorDeducaoTeto()")
			.append("\n	fator = (fatorDeducaoTeto>0.0?fatorDeducaoTeto:1.0)")
			.append("\n")
			.append("\n	if (contexto.aposentadoPorIdade()) {")
			.append("\n		return (teto * fator)")
			.append("\n	}")
			.append("\n	if (contexto.aposentadoPorDoenca()) {")
			.append("\n		return ((teto * fator) * 2)")
			.append("\n	}")
			.append("\n	return 0.0")
			.append("\n}")
			.append("\n")
			.append("\ndescontosMSPrevNoMes = getTotalDescontosMSPrevNoMes(ano,mes)")
			.append("\nbaseMSPrevNoMes = getBaseMSPrevNoMes(ano, mes)")
			.append("\n")
			.append("\npercentualMSPrev = getPercentualMSPrevNaFaixa(baseMSPrevNoMes, dataInicialFolha)")
			.append("\ntetoMSPrev = getTetoMSPrevNaFaixa(baseMSPrevNoMes, dataInicialFolha)")
			.append("\ndeducaoTetoMSPrev = getDeducaoTetoMSPrev(tetoMSPrev)")
			.append("\n")
			.append("\nbaseMSPrev = baseMSPrevNoMes - deducaoTetoMSPrev")
			.append("\n")
			.append("\n// cálculo da contribuição")
			.append("\nmsprevCalculado = (baseMSPrev * (percentualMSPrev/100.0)) - descontosMSPrevNoMes")
			.append("\nDouble msprev = msprevCalculado>0.0?msprevCalculado:0.0")
			.append("\n")
			.append("\n// retorno")
			.append("\ncontexto.output('msprev').valor = msprev")
			.append("\nmsprev");		
		
		System.out.println("\n\nScript do MSPREV:\n\n"+sb.toString());
		
		return sb.toString();
	}	

	private List<FormulaOutput> montaOutputsFormulaMSPrev(Formula formula) {
		// outputs da fórmula de MSPREV
		List<FormulaOutput> lista = new ArrayList<>();
		lista.add(new FormulaOutput(formula, 1, true, "msprev", TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}

	private List<FormulaInput> montaInputsFormulaMSPrev(Formula formula) {
		// inputs da fórmula de MSPREV
		List<FormulaInput> lista = new ArrayList<>();
		lista.add(new FormulaInput(formula, 1, "xyz", true, TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}
	
	private List<RubricaParametro> montaParametrosRubricaMSPrev(Rubrica rubrica) {
		List<RubricaParametro> lista = new ArrayList<>();
		// definir parâmetros da rubrica MSPrev
		lista.add(new RubricaParametro(rubrica, DateUtilz.criaData(1, 1, 2016), DateUtilz.criaData(31, 3, 2020),
				true, 0.0, 9999999.99, 11.0, 20.0, 5189.82, null, null, null, null, null, null, null, null));
		return lista;
	}

	private Rubrica montaRubricaVencimentoEfetivo(Long id, Integer sequencial) {
		// Vencimento evetivo  		5.591,44  	Valor atual da referência do cargo, TNSU - referencia 5 (inicial 1 5065,56)
		Rubrica vencimentoEfetivo = new Rubrica();
		vencimentoEfetivo.setId(id);
		vencimentoEfetivo.setAtiva(true);
		vencimentoEfetivo.setSinal(Sinal.POSITIVO);
		vencimentoEfetivo.setDescricao("Vencimento efetivo");
		vencimentoEfetivo.setTipo(TipoRubrica.BASE_ATUAL);

		// define a participação desta rubrica na composição da base de cálculo para impostos
		vencimentoEfetivo.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(vencimentoEfetivo, TipoBaseCalculo.PREVIDENCIA_PROPRIA));
		vencimentoEfetivo.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(vencimentoEfetivo, TipoBaseCalculo.IMPOSTO_RENDA));
		vencimentoEfetivo.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(vencimentoEfetivo, TipoBaseCalculo.PLANO_SAUDE));
		
		vencimentoEfetivo.setSigla("VNC EFE");
		vencimentoEfetivo.setSequenciaCalculo(sequencial);
		
		return vencimentoEfetivo;
	}

	private Rubrica montaRubricaAbono(Long id, Integer sequencial) {
		// Abono lei 4835/2016		500,00   	Programada (ver o cálculo, reproduzir no teste)
		Rubrica abono = new Rubrica();
		abono.setId(id);
		abono.setAtiva(true);
		abono.setSinal(Sinal.POSITIVO);
		abono.setDescricao("Abono lei 4835/2016");		
		abono.setTipo(TipoRubrica.FORMULA);
		abono.setSigla("ABN");		
		abono.setSequenciaCalculo(sequencial);

		// define a participação desta rubrica na composição da base de cálculo para impostos
		abono.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(abono, TipoBaseCalculo.IMPOSTO_RENDA));
		
		abono.setFormulas(montaFormulasRubricaAbono(abono));
		
		return abono;
	}
	
	private List<RubricaFormula> montaFormulasRubricaAbono(Rubrica rubrica) {
		Formula formula = new Formula();
		formula.setTipo(TipoFormula.SCRIPT_GROOVY);
		formula.setScript(montaScriptGroovyAbono());		
		formula.setInputs(montaInputsFormulaAbono(formula));
		formula.setOutputs(montaOutputsFormulaAbono(formula));
		formula.setNome("AbonoLei4835De2016");
		formula.setGlobal(false);
		return Arrays.asList(new RubricaFormula(rubrica, formula));
	}
	
	private String montaScriptGroovyAbono() {
		// script de cálculo do Abono
		StringBuffer sb = new StringBuffer();
		
		sb	
			.append("\nDouble abono = 500.0")
			.append("\ncontexto.output('abono').valor = abono")
			.append("\nabono");
		
		System.out.println("\n\nScript do Abono:\n\n"+sb.toString());
		
		return sb.toString();
	}
	
	private List<FormulaOutput> montaOutputsFormulaAbono(Formula formula) {
		// outputs da fórmula de Abono
		List<FormulaOutput> lista = new ArrayList<>();
		lista.add(new FormulaOutput(formula, 1, true, "abono", TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}

	private List<FormulaInput> montaInputsFormulaAbono(Formula formula) {
		// inputs da fórmula de Abono
		List<FormulaInput> lista = new ArrayList<>();
		lista.add(new FormulaInput(formula, 1, "xyz", true, TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}

	private Rubrica montaRubricaAdicionalTempoServico(Long id, Integer sequencial, List<Rubrica> base) {
		// Adicional tempo serviço		559,14   	10%, percentual variável sobre outras rubricas
		Rubrica adicionalTempoServico = new Rubrica();
		adicionalTempoServico.setId(id);
		adicionalTempoServico.setAtiva(true);
		adicionalTempoServico.setSinal(Sinal.POSITIVO);
		adicionalTempoServico.setDescricao("Adicional tempo serviço");
		adicionalTempoServico.setTipo(TipoRubrica.PERCENTUAL_SOMA_RUBRICAS_BASE);
		adicionalTempoServico.setPercentual(10.0);
		adicionalTempoServico.setSequenciaCalculo(sequencial);

		// define a participação desta rubrica na composição da base de cálculo para impostos
		adicionalTempoServico.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(adicionalTempoServico, TipoBaseCalculo.IMPOSTO_RENDA));
		adicionalTempoServico.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(adicionalTempoServico, TipoBaseCalculo.PREVIDENCIA_PROPRIA));
		adicionalTempoServico.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(adicionalTempoServico, TipoBaseCalculo.PLANO_SAUDE));
		
		Long idBase = 0l;
		for (Rubrica rubrica : base) {
			adicionalTempoServico.getRubricasBase().add(new RubricaBase(++idBase, adicionalTempoServico, rubrica));
		}
 
		return adicionalTempoServico;
	}

	private Rubrica montaRubricaCassems(Long id, Integer sequencial) {		
		// CASSEMS						369,03	Na folha é programado, aqui deve ser com base em contrato de plano de saúde
		Rubrica cassems = new Rubrica();
		cassems.setId(id);
		cassems.setAtiva(true);
		cassems.setTipo(TipoRubrica.FORMULA);
		cassems.setDescricao("CASSEMS");
		cassems.setSinal(Sinal.NEGATIVO);
		cassems.setSequenciaCalculo(sequencial);
		
		cassems.setFormulas(montaFormulasRubricaCassems(cassems));
		cassems.setParametros(montaParametrosRubricaCassems(cassems));
		
		return cassems;
	}

	private List<RubricaFormula> montaFormulasRubricaCassems(Rubrica rubrica) {
		Formula formula = new Formula();
		formula.setTipo(TipoFormula.SCRIPT_GROOVY);
		formula.setScript(montaScriptGroovyCassems());		
		formula.setInputs(montaInputsFormulaCassems(formula));
		formula.setOutputs(montaOutputsFormulaCassems(formula));
		formula.setNome("CASSEMS");
		formula.setGlobal(false);
		return Arrays.asList(new RubricaFormula(rubrica, formula));
	}
	
	private String montaScriptGroovyCassems() {
		// script de cálculo da Cassems
		StringBuffer sb = new StringBuffer();
		sb
			.append("\ndataFinalFolha = br.jus.tjms.sgpd.util.DateUtilz.ultimoDiaDoMesAoFinalDoDia(contexto.folha.mes, contexto.folha.ano)")
			.append("\ndataInicialFolha = br.jus.tjms.sgpd.util.DateUtilz.primeiroDiaDoMes(contexto.folha.mes, contexto.folha.ano)")
			.append("\n")
			.append("\nbaseCalculo = contexto.baseCalculoPlanoSaudeNaFolha()")
			.append("\n")
			.append("\npercentual = contexto.rubrica.getParametrosAtivos(dataInicialFolha, baseCalculo).first().percentual")
			.append("\n")
			.append("\n// cálculo da contribuição")
			.append("\nDouble cassems = (baseCalculo * (percentual/100.0))")
			.append("\n")
			.append("\n// retorno")
			.append("\ncontexto.output('cassems').valor = cassems")
			.append("\ncassems");
		
		System.out.println("Script da Cassems:\n\n"+sb.toString());
		
		return sb.toString();
	}
	
	private List<FormulaOutput> montaOutputsFormulaCassems(Formula formula) {
		// outputs da fórmula de Cassems
		List<FormulaOutput> lista = new ArrayList<>();
		lista.add(new FormulaOutput(formula, 1, true, "cassems", TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}

	private List<FormulaInput> montaInputsFormulaCassems(Formula formula) {
		// inputs da fórmula de Cassems
		List<FormulaInput> lista = new ArrayList<>();
		lista.add(new FormulaInput(formula, 1, "xyz", true, TipoInputOutput.DECIMAL, Double.class.getName()));
		return lista;
	}	

	private List<RubricaParametro> montaParametrosRubricaCassems(Rubrica rubrica) {
		List<RubricaParametro> lista = new ArrayList<>();
		// definir parâmetros da rubrica cassems
		lista.add(new RubricaParametro(rubrica, DateUtilz.criaData(1, 12, 2015), DateUtilz.criaData(30, 11, 2020),
				true, 0.0, 9999999.99, 6.0, 4.0, null, null, null, null, null, null, null, null, null));
		return lista;
	}

	private FuncionarioCargo montaCargoFuncionario(final Funcionario funcionario, Cargo cargo, 
			final Double valorInicial, final Double valorAtual) {

		// vincula cargo ao funcionário
		FuncionarioCargo fc = new FuncionarioCargo();	
		fc.setFuncionario(funcionario);
		fc.setCargo(cargo);
		fc.setDataInicio(DateUtilz.criaData(6, 4, 2006));
		fc.setDataFim(null);
		
		// cria referência salarial inicial
		Referencia r1 = new Referencia();
		r1.setCargo(cargo);
		r1.setNivel(1);
		r1.setSigla("TNS1");
		// cria referência salarial atual
		Referencia r2 = new Referencia();
		r2.setCargo(cargo);
		r2.setNivel(2);
		r2.setSigla("TNS2");
		
		// cria valor para a referência inicial
		ReferenciaValor rv1 = new ReferenciaValor();
		rv1.setValor(valorInicial);
		rv1.setReferencia(r1);
		rv1.setVigenciaInicio(DateUtilz.criaData(1, 4, 2016));
		rv1.setVigenciaFim(null);		
		
		// cria valor para a referência atual
		ReferenciaValor rv2 = new ReferenciaValor();
		rv2.setValor(valorAtual);
		rv2.setReferencia(r2);
		rv2.setVigenciaInicio(DateUtilz.criaData(1, 4, 2016));
		rv2.setVigenciaFim(null);
		
		r1.getValores().add(rv1);
		r2.getValores().add(rv2);

		// cria progressões funcionais
		ProgressaoFuncional pf1 = new ProgressaoFuncional();		
		pf1.setDataProgressao(DateUtilz.criaData(1, 8, 2009));		
		pf1.setReferencia(r1);
		
		ProgressaoFuncional pf2 = new ProgressaoFuncional();		
		pf2.setDataProgressao(DateUtilz.criaData(1, 8, 2011));
		pf2.setReferencia(r2);
		
		fc.getProgressoes().add(pf1);
		fc.getProgressoes().add(pf2);
		
		return fc;
	}	

	public FolhaPagamento montaFolhaParaTesteCalcularFolhaDePlantaoComLancamentosAvulsos() {

		int arquivoFolhasColunaCD_Fnc = 0;
		int arquivoFolhasColunaNM_Fnc = 1;
		String arquivoFolhas = "/folhas_teste_plantao_8605_2016_03.xls";

		int arqLanctosAvulsosColunaCD_Fnc = 1;
		int arqLanctosAvulsosColunaVL_Clc = 4;
		int arqLanctosAvulsosColunaCD_Rbc = 5;
		String arquivoLancamentosAvulsos = "/lancamentos_avulsos_teste_folha_plantao_8605_2016_03.xls";

		// cria folha de pagamento
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		folhaPagamento.setAno(2016);
		folhaPagamento.setMes(3);
		folhaPagamento.setDescricao("Plantões de março/2016");
		folhaPagamento.setTipo(TipoFolhaPagamento.NORMAL);
		
		Long id = 0L;

		try {

			List<List<String>> listaFolhas = ExcelUtil.lerColunasDaPlanilha(
					this.getClass().getResource(arquivoFolhas).toURI(),
					new int[] { arquivoFolhasColunaCD_Fnc, arquivoFolhasColunaNM_Fnc }
				);

			List<List<String>> listaLancamentosAvulsos = ExcelUtil.lerColunasDaPlanilha(
					this.getClass().getResource(arquivoLancamentosAvulsos).toURI(),
					new int[] { arqLanctosAvulsosColunaCD_Fnc, arqLanctosAvulsosColunaVL_Clc, arqLanctosAvulsosColunaCD_Rbc }
				);

			// adiciona funcionarios e lançamentos avulsos
			for (List<String> folha : listaFolhas) {
				// Funcionario(Long id, Integer matricula, TipoFuncionario tipoFuncionario, Pessoa pessoa)
				Funcionario funcionario = new Funcionario(Double.valueOf(folha.get(0)).longValue(), Double.valueOf(folha.get(0)).intValue(), TipoFuncionario.SERVIDOR, new Pessoa(Double.valueOf(folha.get(0)).longValue(), folha.get(1)));
	
				for (List<String> lancamentoAvulso : listaLancamentosAvulsos) {
					if (funcionario.getMatricula() == Double.valueOf(lancamentoAvulso.get(0)).intValue()) {
						funcionario.getLancamentosAvulsos().add(new LancamentoAvulso(funcionario, "", Double.valueOf(lancamentoAvulso.get(1)), Double.valueOf(lancamentoAvulso.get(1))>0.0?Sinal.POSITIVO:Sinal.NEGATIVO));
					}
				}
	
				FuncionarioFolhaPagamento funcionarioFolhaPagamento = new FuncionarioFolhaPagamento(++id, funcionario, folhaPagamento);
	
				folhaPagamento.getFuncionarios().add(funcionarioFolhaPagamento);

			}

			return folhaPagamento;
			
		} catch (URISyntaxException e) {
			fail("Uma ou mais planilhas não encontradas!");
			e.printStackTrace();
		}

		return null;
	}

	public Contexto montaContextoParaTesteCalcularFolhaDePlantaoComLancamentosAvulsos(FolhaPagamento folha) {		
		return new Contexto().setFolha(folha);
	}

	public FolhaPagamento montaFolhaParaTesteCalcularFolhaNormalRoberto2018() {
		return montaFolhaParaTesteCalcularFolhaNormalBasica2018();
	}


	private Rubrica  montaRubricaAdicionalQualificacao(Long id, Integer sequencial, List<Rubrica> base) {
		// Adicional Qualificacao	8%, percentual variável sobre outras rubricas
		Rubrica AdicionalQualificacao = new Rubrica();
		AdicionalQualificacao.setId(id);
		AdicionalQualificacao.setAtiva(true);
		AdicionalQualificacao.setSinal(Sinal.POSITIVO);
		AdicionalQualificacao.setDescricao("Adicional Qualificacão");
		AdicionalQualificacao.setTipo(TipoRubrica.PERCENTUAL_SOMA_RUBRICAS_BASE);
		AdicionalQualificacao.setPercentual(8.0);
		AdicionalQualificacao.setSequenciaCalculo(sequencial);

		// define a participação desta rubrica na composição da base de cálculo para impostos
		AdicionalQualificacao.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(AdicionalQualificacao, TipoBaseCalculo.IMPOSTO_RENDA));
		AdicionalQualificacao.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(AdicionalQualificacao, TipoBaseCalculo.PREVIDENCIA_PROPRIA));

		Long idBase = 0l;
		for (Rubrica rubrica : base) {
			AdicionalQualificacao.getRubricasBase().add(new RubricaBase(++idBase, AdicionalQualificacao, rubrica));
		}

		return AdicionalQualificacao;
	}


    public FolhaPagamento montaFolhaParaTesteCalcularFolhaNormalBasica2018() {
        FolhaPagamento folhaPagamento = new FolhaPagamento(2018, 4, "Normal de março/2018", TipoFolhaPagamento.NORMAL);
        Funcionario funcionario = new Funcionario(1l, 1, TipoFuncionario.SERVIDOR, new Pessoa(1l, "Roberto"));
        Cargo cargo = new Cargo(CARGO_NOME_TNS, CARGO_SIMBOLO_TNS);

        Long idRubrica = 0l;
        // define as rubricas do cargo
        Rubrica vencimentoEfetivo = montaRubricaVencimentoEfetivo(++idRubrica,1);
        Rubrica adicionalQualificacao = montaRubricaAdicionalQualificacao(++idRubrica,2,Arrays.asList(vencimentoEfetivo));
        Rubrica msPrev = montaRubricaMSPrev(++idRubrica,998, TipoFormula.CLASSE);
        Rubrica irrf = montaRubricaIrrf(++idRubrica,999);

        // associa ao cargo
        Long idRubricaCargo = 0l;
        cargo.getRubricas().add(new RubricaCargo(++idRubricaCargo, vencimentoEfetivo, cargo, TipoFolhaPagamento.NORMAL));
        cargo.getRubricas().add(new RubricaCargo(++idRubricaCargo, adicionalQualificacao, cargo, TipoFolhaPagamento.NORMAL));
        cargo.getRubricas().add(new RubricaCargo(++idRubricaCargo, msPrev, cargo, TipoFolhaPagamento.NORMAL));
        cargo.getRubricas().add(new RubricaCargo(++idRubricaCargo, irrf, cargo, TipoFolhaPagamento.NORMAL));

        // vincula cargo ao funcionário
        Double valorReferenciaInicial = 6061.99;
        Double valorReferenciaAtual = 6061.99;
        FuncionarioCargo funcionarioCargo = montaCargoFuncionario(
                funcionario, cargo, valorReferenciaInicial, valorReferenciaAtual
        );
        funcionario.getCargos().add(funcionarioCargo);

        // adiciona funcionário na folha para calcular
        folhaPagamento.getFuncionarios().add(new FuncionarioFolhaPagamento(1l, funcionario, folhaPagamento));

        return folhaPagamento;
    }
}