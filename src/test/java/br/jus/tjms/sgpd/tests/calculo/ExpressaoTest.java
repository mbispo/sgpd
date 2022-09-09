package br.jus.tjms.sgpd.tests.calculo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.jus.tjms.sgpd.engine.ScriptEngineFactory;
import br.jus.tjms.sgpd.enumerators.TipoScript;

public class ExpressaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void deveExecutarFormulaUsandoGroovyShell() {

		Dto contexto = new Dto(300.00, 125.00);
		Double saldo = contexto.getDepositos() - contexto.getSaques();

		// define a fórmula SALDO cujo resultado é calculado da usando o
		// contexto (contexto.totalDepositos - contexto.totalSaques):
		StringBuilder funcoes = new StringBuilder();
		funcoes.append("def SALDO(c) {");
		funcoes.append("    return c.depositos - c.saques");
		funcoes.append("};\n");

		// o script que retorna o saldo usando a fórmula SALDO(contexto)
		String script = "SALDO(contexto)";

		try {
			Double resultado = (Double) ScriptEngineFactory.fabricar(TipoScript.GROOVY_SCRIPT).executar(funcoes.toString() + script, contexto, "contexto");
			assertTrue("Falha ao executar fórmula " + script, resultado.doubleValue() == saldo.doubleValue());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	@Test
	public void deveExecutarFormulaUsandoJavaScriptEngine() {

		Dto contexto = new Dto(300.00, 125.00);
		Double saldo = contexto.getDepositos() - contexto.getSaques();

		// define a fórmula SALDO cujo resultado é calculado da usando o
		// contexto (contexto.totalDepositos - contexto.totalSaques):
		String funcoes = "function SALDO(c) {return c.depositos - c.saques;}\n";

		// o script que retorna o saldo usando a fórmula SALDO(contexto)
		String script = "SALDO(contexto)";


		Double resultado;
		
		try {
			
			resultado = (Double) ScriptEngineFactory.fabricar(TipoScript.JAVA_SCRIPT).executar(funcoes.toString() + script, contexto, "contexto");

			assertTrue("Falha ao executar fórmula " + script, resultado.doubleValue() == saldo.doubleValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
	

	public class Dto {

		private Double depositos;
		private Double saques;

		public Double getDepositos() {
			return depositos;
		}

		public void setDepositos(Double depositos) {
			this.depositos = depositos;
		}

		public Double getSaques() {
			return saques;
		}

		public void setSaques(Double saques) {
			this.saques = saques;
		}

		public Dto(Double depositos, Double saques) {
			super();
			this.depositos = depositos;
			this.saques = saques;
		}

		@Override
		public String toString() {
			return "Dto [depositos=" + depositos + ", saques=" + saques + "]";
		}

	}
}
