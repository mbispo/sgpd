package br.jus.tjms.sgpd.tests.calculo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.jus.tjms.sgpd.engine.ScriptEngineFactory;
import br.jus.tjms.sgpd.enumerators.TipoScript;

public class SQLScriptEngineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@SuppressWarnings("unchecked")
	@Test
	public void deveExecutarScriptSQLERetornarData() {

		Dto contexto = new Dto(100.00, 200.00, 100.00, null, null, null, null, new FuncionarioDto(1L, "Marcos", "", ""));

		StringBuilder sbScript = new StringBuilder();

		sbScript.append("<RETORNO>select getdate() as data");

		try {

			Object resultado = ScriptEngineFactory.fabricar(TipoScript.SQL_SCRIPT).executar(sbScript.toString(), contexto, "contexto");

			Timestamp data = null;

			if (resultado instanceof Map) {
				data = (Timestamp) ((Map<String, Object>) resultado).get("data");
			}

			String esperado = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

			assertTrue("Falha ao executar script " + sbScript.toString(), data != null && data.toString().startsWith(esperado));

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Test
	public void deveExecutarScriptSQLERetornarVariaveis() {

		Dto contexto = new Dto(100.00, 200.00, 100.00, null, null, null, null, new FuncionarioDto(1L, "Marcos", "", ""));

		Integer esperado1 = 10;
		Integer esperado2 = 100;

		StringBuilder sbScript = new StringBuilder();

		sbScript.append("DECLARE @contador1 int;").append("DECLARE @contador2 int;")
				.append("SET @contador1 = " + esperado1.toString() + ";")
				.append("SET @contador2 = " + esperado2.toString() + ";")
				// aqui fica definido o formato de cláusula de retorno:
				// <RETORNO>select @var1 as var1, @var2 as var2, @varN as varN
				.append("<RETORNO> @contador1 as contador1, @contador2 as contador2;");

		try {

			Object resultado = ScriptEngineFactory.fabricar(TipoScript.SQL_SCRIPT).executar(sbScript.toString(),
					contexto, "contexto");

			Integer contador1 = null;
			Integer contador2 = null;

			if (resultado instanceof Map) {
				contador1 = Integer.valueOf(((Map<String, Object>) resultado).get("contador1").toString());
				contador2 = Integer.valueOf(((Map<String, Object>) resultado).get("contador2").toString());
			}

			assertTrue("Falha ao executar script " + sbScript.toString(),
					contador1 != null && contador1.equals(esperado1));
			assertTrue("Falha ao executar script " + sbScript.toString(),
					contador2 != null && contador2.equals(esperado2));

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Test
	public void deveExecutarScriptSQLERetornarVariaveisComValoresDoContexto() {

		Dto contexto = new Dto(100.00, 200.00, 100.00, null, null, null, null, new FuncionarioDto(1L, "Marcos", "", ""));

		// criar lista de atributo e valor do objeto contexto
		// o retorno deve conter os mesmos atributos e valores
		// a engine de script deve traduzir o objeto contexto para sql e retornar

		Integer esperado1 = 10;
		Integer esperado2 = 100;
		Double variavelEsperadaDeContexto_saldo = contexto.getSaldo();

		StringBuilder sbScript = new StringBuilder();

		sbScript.append("DECLARE @contador1 int;").append("DECLARE @contador2 int;")
				.append("SET @contador1 = " + esperado1.toString() + ";")
				.append("SET @contador2 = " + esperado2.toString() + ";")
				
				// aqui fica definido o formato de cláusula de retorno:
				// <RETORNO>select @var1 as var1, @var2 as var2, @varN as varN
				.append("<RETORNO>select @contador1 as contador1, @contador2 as contador2");

		try {

			Object resultado = ScriptEngineFactory.fabricar(TipoScript.SQL_SCRIPT).executar(sbScript.toString(),
					contexto, "contexto");

			Integer contador1 = null;
			Integer contador2 = null;
			Double saldo = null;

			if (resultado instanceof Map) {
				contador1 = Integer.valueOf(((Map<String, Object>) resultado).get("contador1").toString());
				contador2 = Integer.valueOf(((Map<String, Object>) resultado).get("contador2").toString());
				saldo = Double.valueOf(((Map<String, Object>) resultado).get("saldo").toString());
			}

			assertTrue("Falha ao executar script " + sbScript.toString(), contador1 != null && contador1.equals(esperado1));
			assertTrue("Falha ao executar script " + sbScript.toString(), contador2 != null && contador2.equals(esperado2));
			assertTrue("Falha ao executar script " + sbScript.toString(), saldo != null && saldo.equals(variavelEsperadaDeContexto_saldo));
			
			System.out.println(resultado);

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
	
	@Test
	public void deveListarFieldsEValues() {

		Dto contexto = new Dto(100.00, 200.00, 100.00, "Descrição", new Date(), false, 99, new FuncionarioDto(1L, "Marcos", "", ""));

		Map<String,Object> values = new HashMap<>();
		Map<String,Object> types = new HashMap<>();

		for (Class<?> c = contexto.getClass(); c != null; c = c.getSuperclass()) {
			Field[] fields = c.getDeclaredFields();
			for (Field classField : fields) {
				
				try {
					
					Field field = contexto.getClass().getDeclaredField(classField.getName());
					field.setAccessible(true);

					Object value = field.get(contexto);
					Class<?> t = field.getType();

					values.put(classField.getName(), value);
					types.put(classField.getName(), t.getName());
					
				} catch (NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(values.toString());
		System.out.println(types.toString());
		System.out.println(values.get("valorInicial").toString());
		
		assertTrue("",values.get("valorInicial").equals(100.0));

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

		@Override
		public String toString() {
			return nome;
		}

	}

	public class Dto {

		private Double valorInicial;
		private Double valorFinal;
		private Double saldo;

		private String descricao;
		private Date data;
		private Boolean ativo;
		private Integer quantidade;
		
		private FuncionarioDto funcionario;

		public Dto(Double valorInicial, Double valorFinal, Double saldo, String descricao, Date data, Boolean ativo,
				Integer quantidade, FuncionarioDto funcionario) {
			super();
			this.valorInicial = valorInicial;
			this.valorFinal = valorFinal;
			this.saldo = saldo;
			this.descricao = descricao;
			this.data = data;
			this.ativo = ativo;
			this.quantidade = quantidade;
			this.funcionario = funcionario;
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

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}

		public Boolean getAtivo() {
			return ativo;
		}

		public void setAtivo(Boolean ativo) {
			this.ativo = ativo;
		}

		public Integer getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}

		public FuncionarioDto getFuncionario() {
			return funcionario;
		}

		public void setFuncionario(FuncionarioDto funcionario) {
			this.funcionario = funcionario;
		}
		
	}

}