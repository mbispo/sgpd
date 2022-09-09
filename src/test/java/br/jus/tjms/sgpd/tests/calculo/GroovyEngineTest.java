package br.jus.tjms.sgpd.tests.calculo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.jus.tjms.sgpd.engine.ScriptEngineFactory;
import br.jus.tjms.sgpd.enumerators.TipoScript;

public class GroovyEngineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void deveTestarExpressaoUsandoGroovyShell() {

		Dto contexto = new Dto(100.00, 200.00, 100.00, null);

		String expressao = "contexto.valorInicial < contexto.valorFinal";

		try {
			
			Boolean resultado = (Boolean) ScriptEngineFactory.fabricar(TipoScript.GROOVY_SCRIPT).executar(expressao, contexto, "contexto");
	
			assertTrue("Falha ao executar expressao " + expressao, resultado);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}

	}
	
	
	@Test
	public void deveExecutarScriptERetornarObjetoContextoAlterado() {
		
		Dto contexto = new Dto(100.00, 200.00, 100.00, new FuncionarioDto(1L, "Marcos", "", ""));

		String lotacao = "Área 51";
		
		/*
		 * O script a ser executado altera a lotação para 'Área 51' e retorna o objeto contexto alterado':
		 * 
		 * contexto.funcionario.lotacao = 'Área 51'
		 * contexto
		 * 
		 */
		
		String script = 
				  "contexto.funcionario.lotacao = '"+lotacao+"'\n"
				+ "contexto";

		try {
			Dto resultado = (Dto) ScriptEngineFactory.fabricar(TipoScript.GROOVY_SCRIPT).executar(script, contexto, "contexto");
	
			assertTrue("Falha ao executar script " + script, resultado.getFuncionario().getLotacao().equals(lotacao));
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

	public class FuncionarioDto {
		private Long matricula;
		private String nome;
		private String lotacao;
		private String cargo;

		public FuncionarioDto(Long matricula, String nome, String lotacao, String cargo) {
			super();
			this.matricula = matricula;
			this.nome = nome;
			this.lotacao = lotacao;
			this.cargo = cargo;
		}

		public Long getMatricula() {
			return matricula;
		}

		public void setMatricula(Long matricula) {
			this.matricula = matricula;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getLotacao() {
			return lotacao;
		}

		public void setLotacao(String lotacao) {
			this.lotacao = lotacao;
		}

		public String getCargo() {
			return cargo;
		}

		public void setCargo(String cargo) {
			this.cargo = cargo;
		}

	}

	public class Dto {

		private Double valorInicial;
		private Double valorFinal;
		private Double saldo;
		
		private FuncionarioDto funcionario; 

		public Dto(Double valorInicial, Double valorFinal, Double saldo, FuncionarioDto funcionarioDto) {
			super();
			this.valorInicial = valorInicial;
			this.valorFinal = valorFinal;
			this.saldo = saldo;
			this.funcionario = funcionarioDto;
		}

		public Double getValorInicial() {
			return valorInicial;
		}

		public void setValorInicial(Double valorInicial) {
			this.valorInicial = valorInicial;
		}

		public Double getValorFinal() {
			return valorFinal;
		}

		public void setValorFinal(Double valorFinal) {
			this.valorFinal = valorFinal;
		}

		public Double getSaldo() {
			return saldo;
		}

		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}

		public FuncionarioDto getFuncionario() {
			return funcionario;
		}

		public void setFuncionario(FuncionarioDto funcionarioDto) {
			this.funcionario = funcionarioDto;
		}
		
	}
}