package br.jus.tjms.sgpd.tests.calculo;


import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.jus.tjms.sgpd.engine.calculo.ItemCalculoResultadoRubricaFuncionarioFolhaCache;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculoFactory;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculoResultado;
import br.jus.tjms.sgpd.entity.FolhaPagamento;
import br.jus.tjms.sgpd.entity.Pessoa;
import br.jus.tjms.sgpd.entity.Rubrica;
import br.jus.tjms.sgpd.entity.RubricaBase;
import br.jus.tjms.sgpd.entity.RubricaCompoeBaseCalculo;
import br.jus.tjms.sgpd.entity.RubricaFuncionario;
import br.jus.tjms.sgpd.entity.RubricaParametro;
import br.jus.tjms.sgpd.entity.RubricaUtilizaBaseCalculo;
import br.jus.tjms.sgpd.enumerators.Sinal;
import br.jus.tjms.sgpd.enumerators.TipoBaseCalculo;
import br.jus.tjms.sgpd.enumerators.TipoFormula;
import br.jus.tjms.sgpd.enumerators.TipoRubrica;

public class CalculoRubricaTest {
	
	CalculoRubricaTestHelper calculoRubricaTestHelper;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		calculoRubricaTestHelper = new CalculoRubricaTestHelper();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deveCalcularRubricaValorFixoComParametroDefinidoNaRubrica() {
		Double resultadoEsperado = 100.0;
		
		Rubrica r = new Rubrica();
		r.setValor(100.0);
		
		Double resultado = RubricaCalculoFactory.fabricar(TipoRubrica.VALOR_FIXO).calcular(new Contexto(), r).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());
	}
	
	@Test
	public void deveCalcularRubricaValorFixoComParametroDefinidoNosParametros() {
		Double resultadoEsperado = 255.0;
		
		Rubrica r = new Rubrica();
		r.setValor(100.0);
		
		Calendar vigenciaInicio = Calendar.getInstance();
		vigenciaInicio.add(Calendar.DATE, -10);
		
		Calendar vigenciaFim = Calendar.getInstance();
		vigenciaFim.add(Calendar.DATE, 10);
		
		r.getParametros().add(new RubricaParametro(r, vigenciaInicio.getTime(), vigenciaFim.getTime(), false, null, null, null, null, null, true, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, resultadoEsperado, 0.0, 0.0, 0.0, null, null, null));
		
		Double resultado = RubricaCalculoFactory.fabricar(TipoRubrica.VALOR_FIXO).calcular(new Contexto(), r).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());
	}
	
	
	@Test
	public void deveCalcularRubricaFuncionarioValorFixoDefinidoNoFuncionario() {
		Double resultadoEsperado = 199.0;
		
		Rubrica r = new Rubrica();
		r.setValor(100.0);
		
		Calendar vigenciaInicio = Calendar.getInstance();
		vigenciaInicio.add(Calendar.DATE, -10);
		
		Calendar vigenciaFim = Calendar.getInstance();
		vigenciaFim.add(Calendar.DATE, 10);
		
		r.getParametros().add(new RubricaParametro(r, vigenciaInicio.getTime(), vigenciaFim.getTime(), false, null, null, null, null, null, true, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, resultadoEsperado, 0.0, 0.0, 0.0, null, null, null));
		
		RubricaFuncionario rf = new RubricaFuncionario();
		rf.setRubrica(r);
		rf.setValor(resultadoEsperado);
		
		Double resultado = RubricaCalculoFactory.fabricar(TipoRubrica.VALOR_FIXO).calcular(new Contexto(), rf).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());
	}
	
	@Test
	public void deveCalcularRubricaFuncionarioValorFixoDefinidoNaRubrica() {
		Double resultadoEsperado = 155.0;
		
		Rubrica r = new Rubrica();
		r.setValor(resultadoEsperado);
		
		RubricaFuncionario rf = new RubricaFuncionario();
		rf.setRubrica(r);
		
		Double resultado = RubricaCalculoFactory.fabricar(TipoRubrica.VALOR_FIXO).calcular(new Contexto(), rf).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());
	}
	
	@Test
	public void deveCalcularRubricaBaseInicial() {
		Double resultadoEsperado = 3555.50;
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseInicial(resultadoEsperado);
		
		/*
		 * base inicial depende do cargo do funcionário, que está vinculado às progressões,  que está vinculado às referências e valores
		 */
		
		Double resultado = RubricaCalculoFactory.fabricar(TipoRubrica.BASE_INICIAL).calcular(contexto, new Rubrica()).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaBaseAtual() {
		Double resultadoEsperado = 3760.00;
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(resultadoEsperado);
		FolhaPagamento folha = new FolhaPagamento();
		folha.setAno(2016);
		folha.setMes(4);
		
		contexto.setFolha(folha);

		/*
		 * base atual depende do cargo do funcionário, que está vinculado às progressões, que possui progressão atual, que está vinculado às referências e valores, que possui valor atual
		 */
		
		Double resultado = RubricaCalculoFactory.fabricar(TipoRubrica.BASE_ATUAL).calcular(contexto, new Rubrica()).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaFuncionarioBaseInicial() {
		Double resultadoEsperado = 3555.50;
		
		RubricaFuncionario rf = new RubricaFuncionario();
		rf.setRubrica(new Rubrica());
		rf.setFuncionarioCargo(calculoRubricaTestHelper.montaCargoFuncionario(resultadoEsperado, resultadoEsperado*1.025));
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseInicial(9999.0);
		
		/*
		 * base inicial depende do cargo do funcionário, que está vinculado às progressões,  que está vinculado às referências e valores
		 */
		
		Double resultado = RubricaCalculoFactory.fabricar(TipoRubrica.BASE_INICIAL).calcular(contexto, rf).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaFuncionarioBaseAtual() {
		Double resultadoEsperado = 3555.50;
		
		RubricaFuncionario rf = new RubricaFuncionario();
		rf.setRubrica(new Rubrica());
		rf.setFuncionarioCargo(calculoRubricaTestHelper.montaCargoFuncionario(resultadoEsperado-(resultadoEsperado*0.025), resultadoEsperado));
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(9988.50);
		FolhaPagamento folha = new FolhaPagamento();
		folha.setAno(2016);
		folha.setMes(4);
		
		contexto.setFolha(folha);

		/*
		 * base atual depende do cargo do funcionário, que está vinculado às progressões, que possui progressão atual, que está vinculado às referências e valores, que possui valor atual
		 */
		
		Double resultado = RubricaCalculoFactory.fabricar(TipoRubrica.BASE_ATUAL).calcular(contexto, rf).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularPercentualRubricaBaseInicial() {
		Double base = 6500.00;
		Double percentual = 15.0;
		Double resultadoEsperado = base * (percentual/100);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseInicial(base);
		
		Rubrica rubrica = new Rubrica();
		rubrica.setPercentual(percentual);
		rubrica.setTipo(TipoRubrica.PERCENTUAL_BASE_INICIAL);

		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		

	}
	
	@Test
	public void deveCalcularPercentualRubricaFuncionarioBaseInicial() {
		
		Double outraBase = 9850.0;
		Double base = 8600.00;
		Double percentual = 10.0;
		Double resultadoEsperado = base * (percentual/100);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Rubrica rubrica = new Rubrica();
		rubrica.setTipo(TipoRubrica.PERCENTUAL_BASE_INICIAL);
		rubrica.setPercentual(15.0);
		
		RubricaFuncionario rf = new RubricaFuncionario();
		rf.setRubrica(new Rubrica());
		rf.setFuncionarioCargo(calculoRubricaTestHelper.montaCargoFuncionario(base, base*1.025));
		rf.setPercentual(percentual);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(outraBase);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rf).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());	
	}	
	
	@Test
	public void deveCalcularRubricaPercentualBaseAtual() {
		Double base = 6500.00*1.025;
		Double percentual = 15.0;
		Double resultadoEsperado = base * (percentual/100);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(base);
		
		FolhaPagamento folha = new FolhaPagamento();
		folha.setAno(2016);
		folha.setMes(4);
		
		contexto.setFolha(folha);
		
		Rubrica rubrica = new Rubrica();
		rubrica.setPercentual(percentual);
		rubrica.setTipo(TipoRubrica.PERCENTUAL_BASE_ATUAL);

		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularPercentualRubricaFuncionarioBaseAtual() {
		Double outraBase = 9850.0;
		
		Double baseInicial = 8600.0;
		Double base = baseInicial*1.025;
		
		Double percentual = 10.0;
		Double resultadoEsperado = base * (percentual/100);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Rubrica rubrica = new Rubrica();
		rubrica.setTipo(TipoRubrica.PERCENTUAL_BASE_ATUAL);
		rubrica.setPercentual(15.0);
		
		RubricaFuncionario rf = new RubricaFuncionario();
		rf.setRubrica(new Rubrica());
		rf.setFuncionarioCargo(calculoRubricaTestHelper.montaCargoFuncionario(baseInicial, base));
		rf.setPercentual(percentual);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(outraBase);
		
		FolhaPagamento folha = new FolhaPagamento();
		folha.setAno(2016);
		folha.setMes(4);
		
		contexto.setFolha(folha);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rf).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());
	}
	
	@Test
	public void deveCalcularRubricaSomaRubricasBaseCalculo() {
		Double baseAtual = 5450.0;
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		folhaPagamento.setId(1l);
		
		Pessoa pessoa = new Pessoa(1l, "Marcos");
		
		// cria a rubrica para teste
		Rubrica rubrica = new Rubrica();
		rubrica.setId(1l);
		rubrica.setTipo(TipoRubrica.SOMA_RUBRICAS_BASE);
		
		// cria as rubricas base
		Rubrica rubricaBase1 = new Rubrica();
		rubricaBase1.setTipo(TipoRubrica.BASE_ATUAL);
		rubricaBase1.setId(2l);
		Double resultadoRubricaBase1 = baseAtual;
		
		Rubrica rubricaBase2 = new Rubrica();
		rubricaBase2.setTipo(TipoRubrica.VALOR_FIXO);
		rubricaBase2.setValor(10000.0);
		rubricaBase2.setId(3l);
		Double resultadoRubricaBase2 = 10000.0;
		
		Rubrica rubricaBase3 = new Rubrica();
		rubricaBase3.setTipo(TipoRubrica.FORMULA);
		rubricaBase3.setFormulas(null);
		rubricaBase3.setId(4l);
		Double resultadoRubricaBase3 = 7650.0;
		
		Double resultadoEsperado = resultadoRubricaBase1 + resultadoRubricaBase2 + resultadoRubricaBase3;
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		// associa as rubricas base
		rubrica.getRubricasBase().add(new RubricaBase(rubrica, rubricaBase1));
		rubrica.getRubricasBase().add(new RubricaBase(rubrica, rubricaBase2));
		rubrica.getRubricasBase().add(new RubricaBase(rubrica, rubricaBase3));
		
		// adiciona os resultados de cálculo de cada rubrica base no cache, simulando um cálculo já realizado
		ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache()
			.limpar()
			.adicionar(folhaPagamento, pessoa, rubricaBase1, new ItemCalculoResultado(resultadoRubricaBase1))
			.adicionar(folhaPagamento, pessoa, rubricaBase2, new ItemCalculoResultado(resultadoRubricaBase2))
			.adicionar(folhaPagamento, pessoa, rubricaBase3, new ItemCalculoResultado(resultadoRubricaBase3));
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		contexto.setFolha(folhaPagamento);
		contexto.setPessoa(pessoa);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());

	}
	
	@Test
	public void deveCalcularRubricaPercentualSomaRubricasBaseCalculo() {
		Double percentual = 13.5;
		Double baseAtual = 9850.0;
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		folhaPagamento.setId(1l);
		
		Pessoa pessoa = new Pessoa(1l, "Marcos");
		
		// cria a rubrica para teste
		Rubrica rubrica = new Rubrica();
		rubrica.setId(1l);
		rubrica.setTipo(TipoRubrica.PERCENTUAL_SOMA_RUBRICAS_BASE);
		rubrica.setPercentual(percentual);
		
		// cria as rubricas base
		Rubrica rubricaBase1 = new Rubrica();
		rubricaBase1.setTipo(TipoRubrica.BASE_ATUAL);
		rubricaBase1.setId(2l);
		Double resultadoRubricaBase1 = baseAtual;
		
		Rubrica rubricaBase2 = new Rubrica();
		rubricaBase2.setTipo(TipoRubrica.VALOR_FIXO);
		rubricaBase2.setValor(12000.0);
		rubricaBase2.setId(3l);
		Double resultadoRubricaBase2 = 12000.0;
		
		Rubrica rubricaBase3 = new Rubrica();
		rubricaBase3.setTipo(TipoRubrica.FORMULA);
		rubricaBase3.setFormulas(null);
		rubricaBase3.setId(4l);
		Double resultadoRubricaBase3 = 9625.21;
		
		Double resultadoEsperado = (resultadoRubricaBase1 + resultadoRubricaBase2 + resultadoRubricaBase3) * (percentual/100.0);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		// associa as rubricas base
		rubrica.getRubricasBase().add(new RubricaBase(rubrica, rubricaBase1));
		rubrica.getRubricasBase().add(new RubricaBase(rubrica, rubricaBase2));
		rubrica.getRubricasBase().add(new RubricaBase(rubrica, rubricaBase3));
		
		// adiciona os resultados de cálculo de cada rubrica base no cache, simulando um cálculo já realizado
		ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache()
			.limpar()
			.adicionar(folhaPagamento, pessoa, rubricaBase1, new ItemCalculoResultado(resultadoRubricaBase1))
			.adicionar(folhaPagamento, pessoa, rubricaBase2, new ItemCalculoResultado(resultadoRubricaBase2))
			.adicionar(folhaPagamento, pessoa, rubricaBase3, new ItemCalculoResultado(resultadoRubricaBase3));
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		contexto.setFolha(folhaPagamento);
		contexto.setPessoa(pessoa);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());

	}
	
	@Test
	public void deveCalcularRubricaSomaTipoBaseCalculoCalculo() {
		Double baseAtual = 6485.99;
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		folhaPagamento.setId(1l);
		
		Pessoa pessoa = new Pessoa(1l, "Marcos");
		
		// cria a rubrica para teste
		Rubrica rubrica = new Rubrica();
		rubrica.setId(1l);
		rubrica.setTipo(TipoRubrica.SOMA_TIPO_BASE_CALCULO);
		// define que ela usa (Rubrica.utilizaTiposBaseCalculo) como base de cálculo as rubricas que entram na composição de plano de saúde
		rubrica.getUtilizaTiposBaseCalculo().add(new RubricaUtilizaBaseCalculo(1l, rubrica, TipoBaseCalculo.PLANO_SAUDE));
		
		Rubrica rubricaBase1 = new Rubrica();
		rubricaBase1.setTipo(TipoRubrica.VALOR_FIXO);
		rubricaBase1.setSinal(Sinal.POSITIVO);
		rubricaBase1.setValor(10000.0);
		rubricaBase1.setId(2l);
		// define que ela compõe (Rubrica.compoeTiposBaseCalculo) a base de rubricas que usam como base de cálculo as rubricas que entram na composição de plano de saúde
		rubricaBase1.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(1l, rubricaBase1, TipoBaseCalculo.PLANO_SAUDE));
		Double resultadoRubricaBase1 = 350.0;
		
		Rubrica rubricaBase2 = new Rubrica();
		rubricaBase2.setTipo(TipoRubrica.FORMULA);
		rubricaBase2.setSinal(Sinal.POSITIVO);
		rubricaBase2.setFormulas(null);
		rubricaBase2.setId(3l);
		rubricaBase2.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(2l, rubricaBase2, TipoBaseCalculo.PLANO_SAUDE));
		Double resultadoRubricaBase2 = 1000.0;
		
		Rubrica rubricaBase3 = new Rubrica();
		rubricaBase3.setTipo(TipoRubrica.FORMULA);
		rubricaBase3.setSinal(Sinal.POSITIVO);
		rubricaBase3.setFormulas(null);
		rubricaBase3.setId(4l);
		rubricaBase3.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(3l, rubricaBase3, TipoBaseCalculo.PLANO_SAUDE));
		Double resultadoRubricaBase3 = 466.0;
		
		Rubrica rubricaBase4 = new Rubrica();
		rubricaBase4.setTipo(TipoRubrica.FORMULA);
		rubricaBase4.setSinal(Sinal.POSITIVO);
		rubricaBase4.setFormulas(null);
		rubricaBase4.setId(5l);
		rubricaBase4.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(4l, rubricaBase4, TipoBaseCalculo.DECIMO_TERCEIRO));
		Double resultadoRubricaBase4 = 1650.0;
		
		Double resultadoEsperado = resultadoRubricaBase1 + resultadoRubricaBase2 + resultadoRubricaBase3;
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		// adiciona os resultados de cálculo de cada rubrica base no cache, simulando um cálculo já realizado
		ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache()
			.limpar()
			.adicionar(folhaPagamento, pessoa, rubricaBase1, new ItemCalculoResultado(resultadoRubricaBase1))
			.adicionar(folhaPagamento, pessoa, rubricaBase2, new ItemCalculoResultado(resultadoRubricaBase2))
			.adicionar(folhaPagamento, pessoa, rubricaBase3, new ItemCalculoResultado(resultadoRubricaBase3))
			.adicionar(folhaPagamento, pessoa, rubricaBase4, new ItemCalculoResultado(resultadoRubricaBase4));
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		contexto.setFolha(folhaPagamento);
		contexto.setPessoa(pessoa);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());

	}
	
	@Test
	public void deveCalcularRubricaPercentualSomaTipoBaseCalculoCalculo() {
		Double percentual = 5.5;
		Double baseAtual = 6485.99;
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		folhaPagamento.setId(1l);
		
		Pessoa pessoa = new Pessoa(1l, "Marcos");
		
		// cria a rubrica para teste
		Rubrica rubrica = new Rubrica();
		rubrica.setId(1l);
		rubrica.setTipo(TipoRubrica.PERCENTUAL_SOMA_TIPO_BASE_CALCULO);
		rubrica.getUtilizaTiposBaseCalculo().add(new RubricaUtilizaBaseCalculo(1l, rubrica, TipoBaseCalculo.PLANO_SAUDE));
		rubrica.setPercentual(percentual);
		
		Rubrica rubricaBase1 = new Rubrica();
		rubricaBase1.setTipo(TipoRubrica.VALOR_FIXO);
		rubricaBase1.setValor(10000.0);
		rubricaBase1.setSinal(Sinal.POSITIVO);
		rubricaBase1.setId(2l);
		rubricaBase1.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(1l, rubricaBase1, TipoBaseCalculo.PLANO_SAUDE));
		Double resultadoRubricaBase1 = 350.0;
		
		Rubrica rubricaBase2 = new Rubrica();
		rubricaBase2.setTipo(TipoRubrica.FORMULA);
		rubricaBase2.setFormulas(null);
		rubricaBase2.setSinal(Sinal.POSITIVO);
		rubricaBase2.setId(3l);
		rubricaBase2.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(2l, rubricaBase2, TipoBaseCalculo.PLANO_SAUDE));
		Double resultadoRubricaBase2 = 1000.0;
		
		Rubrica rubricaBase3 = new Rubrica();
		rubricaBase3.setTipo(TipoRubrica.FORMULA);
		rubricaBase3.setFormulas(null);
		rubricaBase3.setSinal(Sinal.POSITIVO);
		rubricaBase3.setId(4l);
		rubricaBase3.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(3l, rubricaBase3, TipoBaseCalculo.PLANO_SAUDE));
		Double resultadoRubricaBase3 = 466.0;
		
		Rubrica rubricaBase4 = new Rubrica();
		rubricaBase4.setTipo(TipoRubrica.FORMULA);
		rubricaBase4.setFormulas(null);
		rubricaBase4.setSinal(Sinal.POSITIVO);
		rubricaBase4.setId(5l);
		rubricaBase4.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(4l, rubricaBase4, TipoBaseCalculo.DECIMO_TERCEIRO));
		Double resultadoRubricaBase4 = 1650.0;
		
		Double resultadoEsperado = (resultadoRubricaBase1 + resultadoRubricaBase2 + resultadoRubricaBase3) * (percentual/100.0);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		// adiciona os resultados de cálculo de cada rubrica base no cache, simulando um cálculo já realizado
		ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache()
			.limpar()
			.adicionar(folhaPagamento, pessoa, rubricaBase1, new ItemCalculoResultado(resultadoRubricaBase1))
			.adicionar(folhaPagamento, pessoa, rubricaBase2, new ItemCalculoResultado(resultadoRubricaBase2))
			.adicionar(folhaPagamento, pessoa, rubricaBase3, new ItemCalculoResultado(resultadoRubricaBase3))
			.adicionar(folhaPagamento, pessoa, rubricaBase4, new ItemCalculoResultado(resultadoRubricaBase4));
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		contexto.setFolha(folhaPagamento);
		contexto.setPessoa(pessoa);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());

	}

	//----------------------------------------------------------------------------------------------------------------
	// início: bruto, líquido, etc
	
	private void executaTesteBrutoLiquidoDescontos(TipoRubrica tipoRubrica) {
		executaTesteBrutoLiquidoDescontosComPercentual(tipoRubrica, null);		
	}
	
	private void executaTesteBrutoLiquidoDescontosComPercentual(TipoRubrica tipoRubrica, Double percentual) {
		Double baseAtual = 6485.99;
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		folhaPagamento.setId(1l);
		
		// cria a rubrica para teste
		Rubrica rubrica = new Rubrica();
		rubrica.setId(1l);
		rubrica.setTipo(tipoRubrica);
		rubrica.setPercentual(percentual);
		
		Pessoa pessoa = new Pessoa(1l, "Marcos");
		
		Rubrica ganho1 = new Rubrica();
		ganho1.setTipo(TipoRubrica.BASE_ATUAL);
		ganho1.setId(2l);
		ganho1.setSinal(Sinal.POSITIVO);
		Double resultadoGanho1 = baseAtual;
		
		Rubrica desconto1 = new Rubrica();
		desconto1.setTipo(TipoRubrica.FORMULA);
		desconto1.setId(3l);
		desconto1.setSinal(Sinal.NEGATIVO);
		Double resultadoDesconto1 = 1000.0;
		
		Rubrica ganho2 = new Rubrica();
		ganho2.setTipo(TipoRubrica.FORMULA);
		ganho2.setId(4l);
		ganho2.setSinal(Sinal.POSITIVO);
		Double resultadoGanho2 = 466.0;
		
		Rubrica desconto2 = new Rubrica();
		desconto2.setTipo(TipoRubrica.FORMULA);
		desconto2.setId(5l);
		desconto2.setSinal(Sinal.NEGATIVO);
		Double resultadoDesconto2 = 1650.0;
		
		Double resultadoEsperado = 0.0;
		
		switch (tipoRubrica) {
			case BRUTO: {
				resultadoEsperado = resultadoGanho1 + resultadoGanho2;
				break;
			}
			case PERCENTUAL_BRUTO: {
				resultadoEsperado = (resultadoGanho1 + resultadoGanho2) * (percentual/100.0);
				break;
			}
			case LIQUIDO: {
				resultadoEsperado = (resultadoGanho1 + resultadoGanho2) - (resultadoDesconto1 + resultadoDesconto2);
				break;
			}
			case PERCENTUAL_LIQUIDO: {
				resultadoEsperado = ((resultadoGanho1 + resultadoGanho2) - (resultadoDesconto1 + resultadoDesconto2)) * (percentual/100.0);
				break;
			}
			case DESCONTOS: {
				resultadoEsperado = resultadoDesconto1 + resultadoDesconto2;
				break;
			}
			case PERCENTUAL_DESCONTOS: {
				resultadoEsperado = (resultadoDesconto1 + resultadoDesconto2) * (percentual/100.0);
				break;
			}
			default:
				break;
		}
		
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		// adiciona os resultados de cálculo de cada rubrica base no cache, simulando um cálculo já realizado
		ItemCalculoResultadoRubricaFuncionarioFolhaCache.cache()
			.limpar()
			.adicionar(folhaPagamento, pessoa, ganho1, new ItemCalculoResultado(resultadoGanho1))
			.adicionar(folhaPagamento, pessoa, desconto1, new ItemCalculoResultado(resultadoDesconto1))
			.adicionar(folhaPagamento, pessoa, ganho2, new ItemCalculoResultado(resultadoGanho2))
			.adicionar(folhaPagamento, pessoa, desconto2, new ItemCalculoResultado(resultadoDesconto2));
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		contexto.setFolha(folhaPagamento);
		contexto.setPessoa(pessoa);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());

	}
	
	@Test
	public void deveCalcularRubricaBrutoCalculo() {
		executaTesteBrutoLiquidoDescontos(TipoRubrica.BRUTO);
	}
	
	@Test
	public void deveCalcularRubricaPercentualBrutoCalculo() {
		executaTesteBrutoLiquidoDescontosComPercentual(TipoRubrica.BRUTO, 12.0);
	}
	
	@Test
	public void deveCalcularRubricaDescontosCalculo() {
		executaTesteBrutoLiquidoDescontos(TipoRubrica.DESCONTOS);
	}

	@Test
	public void deveCalcularRubricaPercentualDescontosCalculo() {
		executaTesteBrutoLiquidoDescontosComPercentual(TipoRubrica.DESCONTOS, 10.0);
	}
	
	@Test
	public void deveCalcularRubricaLiquidoCalculo() {
		executaTesteBrutoLiquidoDescontos(TipoRubrica.LIQUIDO);
	}
	
	@Test
	public void deveCalcularRubricaPercentualLiquidoCalculo() {
		executaTesteBrutoLiquidoDescontosComPercentual(TipoRubrica.LIQUIDO, 17.0);
	}

	// fim: bruto, líquido, etc
	
	//------------------------------------------------------------------------------------------------------------------
	
	// início: testes com fórmulas
	
	@Test
	public void deveCalcularRubricaFormulaScriptGroovy() {
		// criar uma fórmula que calcule x% sobre o base atual do funcionário
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * x%
		// nesse caso o percentual é definido na rubrica
		
		Double baseAtual = 7650.0;
		Double percentual = 11.28;
		Double resultadoEsperado = baseAtual * (percentual/100);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.SCRIPT_GROOVY);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaFuncionarioFormulaScriptGroovy() {
		// criar uma fórmula que calcule X% sobre o base atual do funcionário 
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * X%
		// nesse caso o percentual é definido na rubrica do funcionário
		
		Double baseAtual = 7650.0;
		Double percentual = 11.28;
		Double percentualFuncionario = 13.0;
		Double resultadoEsperado = baseAtual * (percentualFuncionario/100.0);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.SCRIPT_GROOVY);
		
		RubricaFuncionario rubricaFuncionario = new RubricaFuncionario();
		rubricaFuncionario.setPercentual(percentualFuncionario);
		rubricaFuncionario.setRubrica(rubrica);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubricaFuncionario).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f", resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaFormulaExpressaoGroovy() {
		// criar uma fórmula que calcule x% sobre o base atual do funcionário
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * x%
		// nesse caso o percentual é definido na rubrica
		
		Double baseAtual = 9680.0;
		Double percentual = 11.28;
		Double resultadoEsperado = baseAtual * (percentual/100);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.EXPRESSAO_GROOVY);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaFuncionarioFormulaExpressaoGroovy() {
		// criar uma fórmula que calcule X% sobre o base atual do funcionário 
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * X%
		// nesse caso o percentual é definido na rubrica do funcionário
		
		Double baseAtual = 9680.0;
		Double percentual = 11.28;
		Double percentualFuncionario = 13.0;
		Double resultadoEsperado = baseAtual * (percentualFuncionario/100.0);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.EXPRESSAO_GROOVY);
		
		RubricaFuncionario rubricaFuncionario = new RubricaFuncionario();
		rubricaFuncionario.setPercentual(percentualFuncionario);
		rubricaFuncionario.setRubrica(rubrica);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubricaFuncionario).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f", resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaFormulaScriptJavaScript() {
		// criar uma fórmula que calcule x% sobre o base atual do funcionário
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * x%
		// nesse caso o percentual é definido na rubrica
		
		Double baseAtual = 11200.0;
		Double percentual = 15.5;
		Double resultadoEsperado = baseAtual * (percentual/100);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.SCRIPT_JAVASCRIPT);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaFuncionarioFormulaScriptJavaScript() {
		// criar uma fórmula que calcule X% sobre o base atual do funcionário 
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * X%
		// nesse caso o percentual é definido na rubrica do funcionário
		
		Double baseAtual = 11200.0;
		Double percentual = 15.5;
		Double percentualFuncionario = 20.5;
		Double resultadoEsperado = baseAtual * (percentualFuncionario/100.0);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.SCRIPT_JAVASCRIPT);
		
		RubricaFuncionario rubricaFuncionario = new RubricaFuncionario();
		rubricaFuncionario.setPercentual(percentualFuncionario);
		rubricaFuncionario.setRubrica(rubrica);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubricaFuncionario).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f", resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}

	@Test
	public void deveCalcularRubricaFormulaExpressaoJavaScript() {
		// criar uma fórmula que calcule x% sobre o base atual do funcionário
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * x%
		// nesse caso o percentual é definido na rubrica
		
		Double baseAtual = 9680.0;
		Double percentual = 11.28;
		Double resultadoEsperado = baseAtual * (percentual/100);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.EXPRESSAO_JAVASCRIPT);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaFuncionarioFormulaExpressaoJavaScript() {
		// criar uma fórmula que calcule X% sobre o base atual do funcionário 
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * X%
		// nesse caso o percentual é definido na rubrica do funcionário
		Double baseAtual = 9680.0;
		Double percentual = 11.28;
		Double percentualFuncionario = 13.0;
		Double resultadoEsperado = baseAtual * (percentualFuncionario/100.0);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.EXPRESSAO_JAVASCRIPT);
		
		RubricaFuncionario rubricaFuncionario = new RubricaFuncionario();
		rubricaFuncionario.setPercentual(percentualFuncionario);
		rubricaFuncionario.setRubrica(rubrica);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubricaFuncionario).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f", resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());
	}
	
	@Test
	public void deveCalcularRubricaFormulaClasse() {
		// criar uma fórmula que calcule x% sobre o base atual do funcionário
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * x%
		// nesse caso o percentual é definido na rubrica
		
		Double baseAtual = 9680.0;
		Double percentual = 11.28;
		Double resultadoEsperado = baseAtual * (percentual/100);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.CLASSE);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaFuncionarioFormulaClasse() {
		// criar uma fórmula que calcule X% sobre o base atual do funcionário 
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * X%
		// nesse caso o percentual é definido na rubrica do funcionário
		Double baseAtual = 9680.0;
		Double percentual = 11.28;
		Double percentualFuncionario = 13.0;
		Double resultadoEsperado = baseAtual * (percentualFuncionario/100.0);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.CLASSE);
		
		RubricaFuncionario rubricaFuncionario = new RubricaFuncionario();
		rubricaFuncionario.setPercentual(percentualFuncionario);
		rubricaFuncionario.setRubrica(rubrica);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubricaFuncionario).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f", resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());
	}
	
	@Test
	public void deveCalcularRubricaFormulaMetodoEstatico() {
		// criar uma fórmula que calcule x% sobre o base atual do funcionário
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * x%
		// nesse caso o percentual é definido na rubrica
		
		Double baseAtual = 9680.0;
		Double percentual = 11.28;
		Double resultadoEsperado = baseAtual * (percentual/100);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.METODO_ESTATICO);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		System.out.println("resultado = "+resultado);
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f",resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());		
	}
	
	@Test
	public void deveCalcularRubricaFuncionarioFormulaMetodoEstatico() {
		// criar uma fórmula que calcule X% sobre o base atual do funcionário 
		// criar rubrica usando esta fórmula
		// deve retornar o valor esperado = base atual * X%
		// nesse caso o percentual é definido na rubrica do funcionário
		Double baseAtual = 9680.0;
		Double percentual = 11.28;
		Double percentualFuncionario = 13.0;
		Double resultadoEsperado = baseAtual * (percentualFuncionario/100.0);
		System.out.println("resultadoEsperado = "+resultadoEsperado);
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaBaseAtual(baseAtual);
		
		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.METODO_ESTATICO);
		
		RubricaFuncionario rubricaFuncionario = new RubricaFuncionario();
		rubricaFuncionario.setPercentual(percentualFuncionario);
		rubricaFuncionario.setRubrica(rubrica);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubricaFuncionario).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f", resultadoEsperado, resultado), resultado.doubleValue() == resultadoEsperado.doubleValue());
	}
	
	@Test
	public void deveCalcularRubricaFormulaSQLScript() {
		Double valor = 13.699;
		Integer ano = 2016;
		Integer mes = 3;

		Double percentual = 10.0;
		
		Double esperado = ((valor*ano*mes) * percentual) / 100.0;
		
		// monta contexto e script sql que vamos testar:
		
		/*
		 * 
		 * SET @output_bonus = ((@input_valor * @input_ano * @input_mes) * @rubrica_percentual) / 100.0;
		 * 
		 */

		// deve retornar 82851.552
		
		Contexto contexto = calculoRubricaTestHelper.montaContextoParaTesteCalcularRubricaFormulaSQLScript();
		
		contexto.input("valor").setValor(valor);
		contexto.input("ano").setValor(ano);
		contexto.input("mes").setValor(mes);
		// fim: contexto e expressão montados

		Rubrica rubrica = calculoRubricaTestHelper.montaRubricaParaTesteCalcularRubricaFormula(percentual, TipoFormula.SCRIPT_SQL);
		
		Double resultado = RubricaCalculoFactory.fabricar(rubrica.getTipo()).calcular(contexto, rubrica).getResultado();
		
		assertTrue(String.format("Cálculo da rubrica não resultou como esperado: resultado esperado = %f, resultado obtido = %f", esperado, resultado), resultado.doubleValue() == esperado.doubleValue());

	}

	// fim: testes com fórmulas
	//------------------------------------------------------------------------------------------------------------------
	
}