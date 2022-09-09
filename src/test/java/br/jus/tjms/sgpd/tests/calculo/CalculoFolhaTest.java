package br.jus.tjms.sgpd.tests.calculo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.jus.tjms.sgpd.engine.calculo.FolhaCalculo;
import br.jus.tjms.sgpd.engine.calculo.FolhaCalculoFactory;
import br.jus.tjms.sgpd.engine.calculo.impl.FolhaNormalCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FolhaNormalCalculoApplier;
import br.jus.tjms.sgpd.engine.calculo.impl.FolhaNormalCalculoProcessor;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.entity.Pagamento;
import br.jus.tjms.sgpd.entity.PagamentoItem;
import br.jus.tjms.sgpd.enumerators.TipoFolhaPagamento;
import br.jus.tjms.sgpd.service.adicionalqualificacaoservices.ConcessaoAdicionalQualificacaoService;
import br.jus.tjms.sgpd.service.auxilioeducacaoservices.ConcessaoAuxilioEducacaoService;
import br.jus.tjms.sgpd.service.consignacaoservices.EmprestimoConsignadoService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.AdicionalInsalubridadeService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.AdicionalTempoIntegralService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.AuxilioTransporteService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.GratificacaoEncargosEspeciaisService;
import br.jus.tjms.sgpd.service.feriasservices.ConcessaoFeriasService;
import br.jus.tjms.sgpd.service.folhapagamentoservices.PagamentoService;
import br.jus.tjms.sgpd.service.licencaservices.LicencaService;
import br.jus.tjms.sgpd.service.planosaudeservices.ContratoPlanoSaudeService;
import br.jus.tjms.sgpd.service.remuneracaoservices.LancamentoAvulsoService;
import br.jus.tjms.sgpd.tests.util.ExcelUtil;

public class CalculoFolhaTest {

	private LicencaService licencaService;
	private ConcessaoFeriasService concessaoFeriasService;
	private ConcessaoAdicionalQualificacaoService concessaoAdicionalQualificacaoService;
	private ConcessaoAuxilioEducacaoService concessaoAuxilioEducacaoService;
	private ContratoPlanoSaudeService contratoPlanoSaudeService;
	private EmprestimoConsignadoService emprestimoConsignadoService;
	private PagamentoService pagamentoService;
	private LancamentoAvulsoService lancamentoAvulsoService;
	private AdicionalTempoIntegralService adicionalTempoIntegralService;
	private AuxilioTransporteService auxilioTransporteService;
	private GratificacaoEncargosEspeciaisService gratificacaoEncargosEspeciaisService;
	private AdicionalInsalubridadeService adicionalInsalubridadeService;
	
	private FolhaCalculo folhaNormalCalculo;
	private FolhaCalculo folhaDecimoTerceiroCalculo;
	private FolhaCalculo folhaFeriasCalculo;
	private FolhaNormalCalculoProcessor folhaNormalCalculoProcessor;
	private FolhaNormalCalculoApplier folhaNormalCalculoApplier;
	
	private CalculoFolhaTestHelper calculoFolhaTestHelper = new CalculoFolhaTestHelper();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		licencaService = new LicencaService();
		concessaoFeriasService = new ConcessaoFeriasService();
		concessaoAdicionalQualificacaoService = new ConcessaoAdicionalQualificacaoService();
		concessaoAuxilioEducacaoService = new ConcessaoAuxilioEducacaoService();
		contratoPlanoSaudeService = new ContratoPlanoSaudeService();
		emprestimoConsignadoService = new EmprestimoConsignadoService();
		pagamentoService = new PagamentoService();
		lancamentoAvulsoService = new LancamentoAvulsoService();
		adicionalTempoIntegralService = new AdicionalTempoIntegralService();
		auxilioTransporteService = new AuxilioTransporteService();
		gratificacaoEncargosEspeciaisService = new GratificacaoEncargosEspeciaisService();
		adicionalInsalubridadeService = new AdicionalInsalubridadeService();
		
		folhaNormalCalculo = FolhaCalculoFactory.fabricar(TipoFolhaPagamento.NORMAL);
		folhaNormalCalculoApplier = FolhaNormalCalculoApplier.newInstance();
		folhaNormalCalculoProcessor = FolhaNormalCalculoProcessor.newInstance();
		folhaNormalCalculoApplier.setEmprestimoConsignadoService(emprestimoConsignadoService);
		folhaNormalCalculoApplier.setPagamentoService(pagamentoService);
		folhaNormalCalculoApplier.setLancamentoAvulsoService(lancamentoAvulsoService);
		
		
		((FolhaNormalCalculo)folhaNormalCalculo)
			.setFolhaCalculoProcessor(folhaNormalCalculoProcessor)
			.setFolhaCalculoApplier(folhaNormalCalculoApplier)			
			.setLicencaService(licencaService)
			.setConcessaoFeriasService(concessaoFeriasService)
			.setConcessaoAdicionalQualificacaoService(concessaoAdicionalQualificacaoService)
			.setConcessaoAuxilioEducacaoService(concessaoAuxilioEducacaoService)
			.setContratoPlanoSaudeService(contratoPlanoSaudeService)
			.setEmprestimoConsignadoService(emprestimoConsignadoService)
			.setAdicionalTempoIntegralService(adicionalTempoIntegralService)
			.setAuxilioTransporteService(auxilioTransporteService)
			.setGratificacaoEncargosEspeciaisService(gratificacaoEncargosEspeciaisService)
			.setAdicionalInsalubridadeService(adicionalInsalubridadeService);
		

		folhaDecimoTerceiroCalculo = FolhaCalculoFactory.fabricar(TipoFolhaPagamento.DECIMO_TERCEIRO);
		folhaFeriasCalculo = FolhaCalculoFactory.fabricar(TipoFolhaPagamento.FERIAS);
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void deveLerDadosDaPlanilhaExcel() {
		String arquivo = "/folhas_teste_plantao_8605_2016_03.xls";
		int colunaCD_Fnc = 0;
		int colunaVL_Lqd = 15;

		Double resultadoEsperado = 163376.0;

		
		URI uri;

		try {

			uri = this.getClass().getResource(arquivo).toURI();

			System.out.println(ExcelUtil.lerColunaDaPlanilha(uri, colunaCD_Fnc));

			System.out.println(ExcelUtil.lerColunasDaPlanilha(uri, new int[] { colunaCD_Fnc, colunaVL_Lqd }));

			Double total = ExcelUtil.retornaTotalDaPlanilhaNaColuna(uri, colunaVL_Lqd);

			System.out.println(total);

			assertTrue("Soma da coluna VL_Lqd diferente do esperado.", 
					total.doubleValue() == resultadoEsperado.doubleValue());

		} catch (URISyntaxException e) {
			fail("Arquivo " + arquivo + " não encontrado!");
			e.printStackTrace();
		}

	}
	
	@Test
	public void deveCalcularFolhaNormalMarcosAbril2016() {
		Double resultadoEsperadoTotal = 3903.46;
		
		/*
		 *  montar configuração do cálculo:
		 * 
		    Ganhos

			3-Vencimento evetivo				5591,44	  	Valor atual da referência do cargo, TNSU - referencia 5 (inicial 1 5065,56)	
			14-Adicional tempo serviço			559,14    	10%, percentual variável sobre outras rubricas
			394-Abono lei 4835/2016				500,00    	Programada (ver o cálculo, reproduzir no teste)
			
			Descontos
			
			Emprestimo consignado				1032,31		Parcela de empréstimo consignado
			940-MS PREV							676,56		Programado, percentual sobre base de cálculo (ver o cálculo, reproduzir no teste)
			941-IRRF							669,22		Programado, percentual sobre base de cálculo (ver o cálculo, reproduzir no teste)
			944-CASSEMS							369,03		Na folha é programado, aqui deve ser com base em contrato de plano de saúde
			
			
			Líquido								3903,46
			
		 * 
		 */
		
		FolhaPagamento folha = calculoFolhaTestHelper.montaFolhaParaTesteCalcularFolhaNormalMarcosAbril2016();
		Contexto contexto = calculoFolhaTestHelper.montaContextoParaTesteCalcularFolhaNormal(folha);
		
		folhaNormalCalculo.calcular(contexto, folha);
	
		Double total = totalizarPagamentos(folha);
		assertTrue(String.format("Cálculo da folha não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperadoTotal, total), total.doubleValue() == resultadoEsperadoTotal.doubleValue());
	}
	
	@Ignore("Contexto não implementado")
	@Test
	public void deveCalcularFolhaDecimoTerceiroFulanoDaSilvaDezembro2015() {
		Double resultadoEsperadoTotal = 4386.95;
		
		/*
		 *  montar configuração do cálculo:
		 * 
		 *  Folha: 8373- 11/2015 13º SALÁRIO 2015 Dt. Pgto.:07/12/2015
		 *  9310
		 *  
			Ganhos
			
			Referência			Cálculo		Rubrica												Valor		Prazo
											287-13º SALARIO ABONO 								  100,00
											406-13º SALÁRIO 									3.168,69
											460-13º SALÁRIO S/PREVID 							3.130,84
			Descontos
			
			Referência			Cálculo		Rubrica												Valor		Prazo
								1,000000 	948- IRRF S/13º SALÁRIO 							1.664,02
											949-MS-PREV S/13º SALÁRIO 							  348,56
			
			
			Bruto:		6.399,53		Margem Consignável:		    0,00	Previdência Regime Próprio: 	3.168,69
			Desconto:	2.012,58		Base para IRRF:			3.201,35	Previdência Regime Geral:
			Líquido:	4.386,95
			
			Observações: 
				**************** DE 02/02/2009 A 02/04/2012 - COORDENADOR
				DE 03/04/12 EM DIANTE - DIRETOR DE DEPTO *****************
		 * 
		 */
		
		FolhaPagamento folha = calculoFolhaTestHelper.montaFolhaParaTesteCalcularFolhaDecimoTerceiroFulanoDaSilvaDezembro2015();
		Contexto contexto = calculoFolhaTestHelper.montaContextoParaTesteCalcularFolhaDecimoTerceiroFulanoDaSilvaDezembro2015(folha);
		
		folhaDecimoTerceiroCalculo.calcular(contexto, folha);

		Double total = totalizarPagamentos(folha);

		assertTrue(String.format("Cálculo da folha não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperadoTotal, total), total.doubleValue() == resultadoEsperadoTotal.doubleValue());
	}
	
	@Ignore("Contexto não implementado")
	@Test
	public void deveCalcularFolhaFeriasFulanoDaSilvaMarco2016() {
		Double resultadoEsperadoTotal = 2320.98;
		
		/*
		 *  montar configuração do cálculo:
		 *  
		 *  Folha: 8527- 3/2016 FÉRIAS DE MARÇO/2016 Dt. Pgto.:01/03/2016
		 *  9302
		 * 
			Ganhos
			
			Referência			Cálculo		Rubrica												Valor		Prazo
								30,000000 	249-1/3 FERIAS 										2.199,30
											296-1/3 FÉRIAS CARGO/FUNÇÃO/ATIVIDADE 				1.002,05
											
			Descontos
			
			Referência			Cálculo		Rubrica												Valor		Prazo
								1,000000 	941- IRRF. 											  880,37
			
			
			Bruto:		3.201,35		Margem Consignável:		 -880,37			Previdência Regime Próprio:
			Desconto:	  880,37		Base para IRRF:			3.201,35			Previdência Regime Geral:
			Líquido:	2.320,98
			
			
			Observações: 
				FÉRIAS NO PERÍODO DE 14/03/16 A 01/04/16, 1ª PARCELA, 19 DIAS.
				PERÍODO AQUISITIVO: 10/04/13 A 09/04/14.(M)ok			
		 * 
		 */
		
		FolhaPagamento folha = calculoFolhaTestHelper.montaFolhaParaTesteCalcularFolhaFeriasFulanoDaSilvaMarco2016();
		Contexto contexto = calculoFolhaTestHelper.montaContextoParaTesteCalcularFolhaFeriasFulanoDaSilvaMarco2016(folha);
		
		folhaFeriasCalculo.calcular(contexto, folha);

		Double total = totalizarPagamentos(folha);

		assertTrue(String.format("Cálculo da folha não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperadoTotal, total), total.doubleValue() == resultadoEsperadoTotal.doubleValue());
	}

	@Test
	public void deveCalcularFolhaDePlantaoComLancamentosAvulsos() {
		Double resultadoEsperadoTotal = 163376.0;

		FolhaPagamento folha = calculoFolhaTestHelper.montaFolhaParaTesteCalcularFolhaDePlantaoComLancamentosAvulsos();
		Contexto contexto = calculoFolhaTestHelper.montaContextoParaTesteCalcularFolhaDePlantaoComLancamentosAvulsos(folha);
		
		folhaNormalCalculo.calcular(contexto, folha);

		Double total = totalizarPagamentos(folha);
		
		assertTrue(total.equals(resultadoEsperadoTotal));
	}
	
	private void imprimir(Pagamento pagamento) {
		System.out.println(pagamento.getFuncionario().getMatricula()+"-"+pagamento.getFuncionario().getPessoa().getNome()+"    "+pagamento.getGanhos()+" - "+pagamento.getDescontos()+" = "+pagamento.getLiquido());
		System.out.println("Itens:");

		List<PagamentoItem> itens = pagamento.getItens();

		Collections.sort(itens, new Comparator<PagamentoItem>() {

			@Override
			public int compare(PagamentoItem o1, PagamentoItem o2) {
				return o1.getTipo().compareTo(o2.getTipo());
			}
		});

		for (PagamentoItem pagamentoItem : itens) {
			System. out.println(pagamentoItem.getTipo()+ " - " + pagamentoItem.getValor()+"  -  "+ pagamentoItem.getDescricao());
		}
	}

    private Double totalizarPagamentos(FolhaPagamento folha) {
        Double total = 0.0;
        List<Pagamento> pagamentos = folha.getPagamentos();
        System.out.println("------------------------------------------------------------------------------------\n\n<<Pagamentos gerados>>\n");

        if (pagamentos!=null) for (Pagamento pagamento : pagamentos) {
            imprimir(pagamento);
            total = total + pagamento.getLiquido();
        }
        return total;
    }

	@Test
	public void deveCalcularFolhaNormalRoberto() {
		Double resultadoEsperadoTotal = 5093.78;

		/*
		 *  montar configuração do cálculo:
		 *
		    Ganhos
			3-Vencimento evetivo				6.061,99	Valor atual da referência do cargo, TNSU - referencia 5 (inicial 1 6.061,99)
			ADICIONAL DE QUALIFICAÇÃO	        484,96		8% Vencimento efetivo

			Descontos
			940-MS PREV							720,16		Programado, percentual sobre base de cálculo (ver o cálculo, reproduzir no teste)
			941-IRRF							733,01		Programado, percentual sobre base de cálculo (ver o cálculo, reproduzir no teste)

			Líquido								5.093,78
		 *
		 */

		FolhaPagamento folha = calculoFolhaTestHelper.montaFolhaParaTesteCalcularFolhaNormalRoberto2018();
		Contexto contexto = calculoFolhaTestHelper.montaContextoParaTesteCalcularFolhaNormal(folha);

		folhaNormalCalculo.calcular(contexto, folha);

		Double total = totalizarPagamentos(folha);
		assertTrue(String.format("Cálculo da folha não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperadoTotal, total), total.doubleValue() == resultadoEsperadoTotal.doubleValue());
	}

}