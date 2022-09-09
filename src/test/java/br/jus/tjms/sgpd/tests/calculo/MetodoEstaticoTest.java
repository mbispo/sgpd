package br.jus.tjms.sgpd.tests.calculo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.jus.tjms.sgpd.engine.ScriptEngineFactory;
import br.jus.tjms.sgpd.enumerators.TipoScript;

public class MetodoEstaticoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testaMetodoEstatico() {
		Dto contexto = new Dto(250.0, 125.0);
		
		Double saldo = Teste.saldo(contexto);
		
		assertTrue(saldo.doubleValue() == 125.0);
		
	}
	
	@Test
	public void testaFormulaDoMetodoEstaticoViaGroovyShell() {

		Dto contexto = new Dto(250.0, 125.0);
		Double saldo = Teste.saldo(contexto);

		StringBuilder importStatic = new StringBuilder();
		importStatic.append("import static "+Teste.class.getName()+".saldo\n");

		String expressao = "saldo(contexto)";

		try {
			Double resultado = (Double) ScriptEngineFactory.fabricar(TipoScript.GROOVY_SCRIPT).executar(importStatic.toString() + expressao, contexto, "contexto");
			assertTrue("Falha ao executar método estático " + importStatic.toString() + expressao, resultado.doubleValue() == saldo.doubleValue());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
	
	@Test
	public void testaMetodoEstaticoViaReflections() {
		Dto contexto = new Dto(250.0, 125.0);
		Double saldo = Teste.saldo(contexto);
		Double resultado = 0.0;
		
		String metodo = "saldo";
		String classe = Teste.class.getName();

		Method[] methods;
		Method method = null;
		
		try {			
			methods = Class.forName(classe).getMethods();			
			for (Method m : methods) {
			    if (metodo.equals(m.getName())) {
			    	method = m;
			        resultado = (Double) method.invoke(null, new Object[] {contexto});
			        break;
			    }
			}			
		} catch (SecurityException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail(e.getMessage());
		}
		
		assertTrue("Falha ao executar método estático " + method.toGenericString(), resultado.doubleValue() == saldo.doubleValue());
	}

	public static class Teste {
		
		public static Double saldo(Dto contexto) {
			
			return contexto.getDepositos() - contexto.getSaques();
			
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