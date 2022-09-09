package br.jus.tjms.sgpd.tests.calculo;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.jus.tjms.sgpd.engine.calculo.FormulaCalculoFactory;
import br.jus.tjms.sgpd.engine.calculo.FormulaGlobalCache;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.Formula;
import br.jus.tjms.sgpd.enumerators.TipoFormula;

public class CalculoFormulaTest {
	
	CalculoFormulaTestHelper calculoFormulaTestHelper = new CalculoFormulaTestHelper();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void deveCalcularFormulaExpressaoGroovy() {
		Double esperado = 82851.552;
		
		/* 
		 * 
		 * OK - Objetivos do teste: 
		 *  
		 * OK - Criar uma fórmula com vários parâmetros de entrada e saída
		 * OK - O cálculo deve considerar o tipo de fórmula (groovy, javascript, etc), inputs e outputs
		 * OK - Inputs e outputs devem estar disponíveis para o script, via contexto ou outro mecanismo
		 * 
		 * OK - Uma fórmula pode referenciar outra fórmula, ver como inserir inputs e obter outputs
		 * 
		 * Exemplo: se a fórmula atual é um script, nele posso refereciar outra fórmula: res = SALDO(a,b,c,d); a=res['total']
		 * 
		 */
		
		// monta as duas fórmulas para tornar disponíveis globalmente e disponibiliza no cache (de fórmulas globais)
		FormulaGlobalCache.instance()
			.adicionar(calculoFormulaTestHelper.montaFormulaBonusPorDiaUtilNoMes(TipoFormula.SCRIPT_GROOVY))
			.adicionar(calculoFormulaTestHelper.montaFormulaDiasUteis(TipoFormula.SCRIPT_GROOVY));
		
		
		// início: monta contexto e expressão que vamos testar
		// bonusPorDiaUtilNoMes(13.699,2016,3)
		// deve retornar 82851.552
		Contexto contexto = calculoFormulaTestHelper.montaContextoParaTesteCalcularFormula();
		Double valor = 13.699;
		Integer ano = 2016;
		Integer mes = 3;
		
		contexto.input("valor").setValor(valor);
		contexto.input("ano").setValor(ano);
		contexto.input("mes").setValor(mes);
		// fim: contexto e expressão montados
		
		Formula expressao1UsandoAmbasFormulasGlobais = calculoFormulaTestHelper.montaExpressao1UsandoAmbasFormulasGlobais(TipoFormula.EXPRESSAO_GROOVY);

		FormulaCalculoFactory.fabricar(expressao1UsandoAmbasFormulasGlobais.getTipo()).calcular(contexto, expressao1UsandoAmbasFormulasGlobais);
		
		// aqui o resultado é setado no parâmetro de saída 'valor'
		// ou seja, o script pode fornecer vários resultados
		Double resultado = (Double) contexto.output("bonus").getValor();
		
		assertTrue("Cálculo da fórmula/expressão não resultou como esperado!",(resultado.doubleValue() == esperado.doubleValue()));

		// aqui o resultado é simplesmente o retorno da expressão executado pelo groovy!
		Formula expressao2UsandoAmbasFormulasGlobais = calculoFormulaTestHelper.montaExpressao2UsandoAmbasFormulasGlobais(TipoFormula.EXPRESSAO_GROOVY);

		Double resultado2 = (Double) FormulaCalculoFactory.fabricar(expressao2UsandoAmbasFormulasGlobais.getTipo()).calcular(contexto, expressao2UsandoAmbasFormulasGlobais);
		
		assertTrue("Cálculo da fórmula/expressão não resultou como esperado!",(resultado2.doubleValue() == esperado.doubleValue()));
	}
	
	@Test
	public void deveCalcularFormulaExpressaoJavaScript() {
		Double esperado = 82851.552;
		
		/* 
		 * 
		 * Objetivos do teste: 
		 * 
		 * Idem ao teste acima, porém usando javascript ao invés dfe groovy
		 * 
		 */
		
		// monta as duas fórmulas para tornar disponíveis globalmente e disponibiliza no cache (de fórmulas globais)
		FormulaGlobalCache.instance()
			.adicionar(calculoFormulaTestHelper.montaFormulaBonusPorDiaUtilNoMes(TipoFormula.SCRIPT_JAVASCRIPT))
			.adicionar(calculoFormulaTestHelper.montaFormulaDiasUteis(TipoFormula.SCRIPT_JAVASCRIPT));
		
		
		// início: monta contexto e expressão que vamos testar
		// bonusPorDiaUtilNoMes(13.699,2016,3)
		// deve retornar 82851.552
		Contexto contexto = calculoFormulaTestHelper.montaContextoParaTesteCalcularFormula();
		Double valor = 13.699;
		Integer ano = 2016;
		Integer mes = 3;
		
		contexto.input("valor").setValor(valor);
		contexto.input("ano").setValor(ano);
		contexto.input("mes").setValor(mes);
		// fim: contexto e expressão montados
		
		Formula expressao1UsandoAmbasFormulasGlobais = calculoFormulaTestHelper.montaExpressao1UsandoAmbasFormulasGlobais(TipoFormula.EXPRESSAO_JAVASCRIPT);

		FormulaCalculoFactory.fabricar(expressao1UsandoAmbasFormulasGlobais.getTipo()).calcular(contexto, expressao1UsandoAmbasFormulasGlobais);
		
		// aqui o resultado é setado no parâmetro de saída 'valor'
		// ou seja, o script pode fornecer vários resultados
		Double resultado = (Double) contexto.output("bonus").getValor();
		
		assertTrue("Cálculo da fórmula/expressão não resultou como esperado!",(resultado.doubleValue() == esperado.doubleValue()));
		

		// aqui o resultado é simplesmente o retorno da expressão executado pelo groovy!
		Formula expressao2UsandoAmbasFormulasGlobais = calculoFormulaTestHelper.montaExpressao2UsandoAmbasFormulasGlobais(TipoFormula.EXPRESSAO_JAVASCRIPT);

		Double resultado2 = (Double) FormulaCalculoFactory.fabricar(expressao2UsandoAmbasFormulasGlobais.getTipo()).calcular(contexto, expressao2UsandoAmbasFormulasGlobais);
		
		assertTrue("Cálculo da fórmula/expressão não resultou como esperado!",(resultado2.doubleValue() == esperado.doubleValue()));
	}
	
	@Test
	public void deveCalcularFormulaSQLScript() {
		Double esperado = 82851.552;
		
		// monta contexto e script sql que vamos testar:
		
		/*
		 * 
		 * SET @output_bonus = @input_valor * @input_ano * @input_mes;
		 * 
		 */

		// deve retornar 82851.552
		
		Contexto contexto = calculoFormulaTestHelper.montaContextoParaTesteCalcularFormula();
		Double valor = 13.699;
		Integer ano = 2016;
		Integer mes = 3;
		
		contexto.input("valor").setValor(valor);
		contexto.input("ano").setValor(ano);
		contexto.input("mes").setValor(mes);
		// fim: contexto e expressão montados
		
		Formula formulaSQLScript = calculoFormulaTestHelper.montaFormulaBonusPorDiaUtilNoMes(TipoFormula.SCRIPT_SQL);

		FormulaCalculoFactory.fabricar(formulaSQLScript.getTipo()).calcular(contexto, formulaSQLScript);
		
		// aqui o resultado é setado no parâmetro de saída 'bonus'
		// ou seja, o script pode fornecer vários resultados
		Double resultado = (Double) contexto.output("bonus").getValor();
		
		assertTrue("Cálculo da fórmula/expressão não resultou como esperado!",(resultado.doubleValue() == esperado.doubleValue()));
	}
	
	@Test
	public void deveCalcularFormulaClasse() {
		Double esperado = 150746.4;
		
		// monta contexto e expressao (da classe) que vamos testar:
		
		/*
		 * 
		 * br.jus.tjms.sgpd.tests.calculo.ClasseCalculoParaTeste
		 * 
		 */

		// deve retornar 150746,4
		
		Contexto contexto = calculoFormulaTestHelper.montaContextoParaTesteCalcularFormula();
		Double valor = 14.955;
		Integer ano = 2016;
		Integer mes = 5;
		
		contexto.input("valor").setValor(valor);
		contexto.input("ano").setValor(ano);
		contexto.input("mes").setValor(mes);
		// fim: contexto e expressão montados
		
		Formula formulaClasse = calculoFormulaTestHelper.montaFormulaBonusPorDiaUtilNoMes(TipoFormula.CLASSE);

		Double resultado = (Double)FormulaCalculoFactory.fabricar(formulaClasse.getTipo()).calcular(contexto, formulaClasse);
		
		// aqui o resultado é setado no parâmetro de saída 'bonus'
		// ou seja, o script pode fornecer vários resultados
		Double resultado2 = (Double) contexto.output("bonus").getValor();
		
		assertTrue("Cálculo da fórmula/expressão não resultou como esperado!",(resultado.doubleValue() == esperado.doubleValue()));
		assertTrue("Cálculo da fórmula/expressão não resultou como esperado!",(resultado2.doubleValue() == esperado.doubleValue()));
	}
	
	@Test
	public void deveCalcularFormulaMetodoEstatico() {
		Double esperado = 150746.4;
		
		// monta contexto e expressao (da classe) que vamos testar:
		
		/*
		 * 
		 * br.jus.tjms.sgpd.tests.calculo.ClasseCalculoParaTeste
		 * 
		 */

		// deve retornar 150746,4
		
		Contexto contexto = calculoFormulaTestHelper.montaContextoParaTesteCalcularFormula();
		Double valor = 14.955;
		Integer ano = 2016;
		Integer mes = 5;
		
		contexto.input("valor").setValor(valor);
		contexto.input("ano").setValor(ano);
		contexto.input("mes").setValor(mes);
		// fim: contexto e expressão montados
		
		Formula formulaClasse = calculoFormulaTestHelper.montaFormulaBonusPorDiaUtilNoMes(TipoFormula.METODO_ESTATICO);

		// aqui pegamos o retorno do método estático
		Double resultado = (Double)FormulaCalculoFactory.fabricar(formulaClasse.getTipo()).calcular(contexto, formulaClasse);
		
		// aqui o resultado é setado no parâmetro de saída 'bonus'
		// ou seja, o script pode fornecer vários resultados
		Double resultado2 = (Double) contexto.output("bonus").getValor();
		
		assertTrue("Cálculo da fórmula/expressão não resultou como esperado!",(resultado.doubleValue() == esperado.doubleValue()));
		assertTrue("Cálculo da fórmula/expressão não resultou como esperado!",(resultado2.doubleValue() == esperado.doubleValue()));
	}

}