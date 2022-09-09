package br.jus.tjms.sgpd.engine.impl;

import br.jus.tjms.sgpd.engine.Scripter;
import br.jus.tjms.sgpd.engine.annotations.FolowField;
import br.jus.tjms.sgpd.engine.annotations.FolowList;
import br.jus.tjms.sgpd.engine.calculo.InputParam;
import br.jus.tjms.sgpd.engine.calculo.OutputParam;
import br.jus.tjms.sgpd.exception.SGPException;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Field;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MSSQLServerSQLScripter implements Scripter {

	private static final long serialVersionUID = -1951643630017525081L;
    private static final Logger logger = LoggerFactory.getLogger(MSSQLServerSQLScripter.class);

	private static Scripter instance;
	
	private static final String RETORNO = "<RETORNO>";

	public static Scripter newInstance() {
		return new MSSQLServerSQLScripter();
	}

	public static Scripter instance() {
		if (instance == null) {
			instance = new MSSQLServerSQLScripter();
		}
		return instance;
	}

	@Override
	public Map<String,Object> executar(String script, Object contexto, String nomeVariavelContexto) {
		/*
		 * Tarefas: 
		 * 	traduzir o contexto para dentro do script
		 * 	executar via nativequery
		 * 	coletar o resultado usando o metadata do resultset e retornar
		 * 
		 */

		// valida o script antes de prosseguir
		validarScript(script);
		
		Connection con = getConnection();
		
		Map<String,Object> valores = getValoresDoContexto(contexto);
		
		StringBuilder sbScript = new StringBuilder();

		// inclui as variáveis de retorno do contexto
		sbScript.append(gerarCabecalho(valores));
		
		// trata para retirar a cláusula de retorno <RETORNO> adicionada pelo usuário
		sbScript.append(tratarScript(script));
		
		// aqui é gerado o retorno das varíaveis de contexto incluindo as informadas pelo usuário na cláusula de retorno <RETORNO>
		sbScript.append(gerarRetorno(script,valores));
		
		Map<String, Object> resultado = new HashMap<>();
		
		// TODO melhorar o gerenciamento das conexões, liberação, fechamento, etc...
		try {

            logger.debug(sbScript.toString());
			
			PreparedStatement pst = con.prepareStatement(sbScript.toString());
			ResultSet rs = pst.executeQuery();
	
			final ResultSetMetaData md = rs.getMetaData();
			final int cols = md.getColumnCount();

			if (rs.next()) {
				for (int i = 0; i < cols; i++) {
					final String name = md.getColumnLabel(i + 1);
					resultado.put(name, rs.getObject(name));
				}
			}
			
			pst.close();
			rs.close();
		} catch (Exception e) {
            logger.error(e.getMessage(), e);
			throw new SGPException(e);			
		}

		return resultado;
	}

	private void validarScript(String script) {
		if (script.contains(RETORNO) && script.split(RETORNO).length>2) {
			throw new SGPException("Script só pode ter uma cláusula de retorno <RETORNO>!");
		}
	}
	
	private String tratarScript(String script) {
		String retorno = script;
		if (script.contains(RETORNO)) {
			retorno = script.split(RETORNO)[0].trim();
		}		
		return retorno;
	}

	private String gerarCabecalho(Map<String, Object> valores) {
		StringBuilder sb = new StringBuilder();
		for (String key: valores.keySet()) {
			Object o = valores.get(key);
			if (o!=null) {
				sb.append("\n"+String.format("DECLARE @%s %s;",key,getSQLType(valores.get(key)))+"\n");
				sb.append(String.format("SET @%s = %s;",key,getSQLValue(valores.get(key)))+"\n");
			}
			
		}
		return sb.toString();
	}
	
	private String gerarRetorno(String script, Map<String, Object> valores) {
		StringBuilder sb = new StringBuilder("\n\nselect ");
		String retorno;
		
		if (script.contains(RETORNO)) {
			retorno = (script.split(RETORNO)[1]).replaceAll(RETORNO, "").replaceAll("select","").replaceAll(";", "").trim();
			if (!"".equals(retorno)) {
				sb.append(retorno+",");
			}
		}
		
		int i = 0;
		for (String key: valores.keySet()) {
			Object o = valores.get(key);
			if (o!=null) {
				i++;
			}
		}
		
		int j = 0;
		for (String key: valores.keySet()) {
			Object o = valores.get(key);
			
			if (o!=null) {
				sb.append(String.format("@%s as %s",key,key));
				j++;
				if (j<i) {
					sb.append(",");
				} else {
					sb.append(";");
				}
			}
		}
		
		return sb.toString();
	}
	
	private String getSQLType(Object o) {
		// descobre tipo SQL em funçao do tipo java...
		String tipo = null;
		switch (o.getClass().getName()) {
			case "java.lang.Boolean": {
				tipo = "bit";
				break;
			}
			case "java.util.Date": {
				tipo = "date";
				break;
			}
			case "java.lang.Double": {
				tipo = "float";
				break;
			}
			case "java.lang.Integer": {
				tipo = "int";
				break;
			}
			case "java.lang.String": {
				tipo = String.format("varchar(%d)", o.toString().length());
				break;
			}
			default: {
				tipo = String.format("varchar(%d)", o.toString().length());
				break;
			}
		}
		return tipo;
	}

	private String getSQLValue(Object o) {
		// descobre valor em formato SQL em funçao do tipo java...
		String valor = "";
		switch (o.getClass().getName()) {
			case "java.lang.Boolean": {
				Boolean b = (Boolean) o;
				valor = (b ? "1" : "0");
				break;
			}
			case "java.util.Date": {
				Date d = (Date) o;
				valor = "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(d) + "'";
				break;
			}
			case "java.lang.Double": {
				valor = o.toString();
				break;
			}
			case "java.lang.Integer": {
				valor = o.toString();
				break;
			}
			case "java.lang.String": {
				valor = "'" + (String) o + "'";
				break;
			}
			default: {
				valor = "'" + o.toString() + "'";
				break;
			}
		}
		return valor;
	}
	
	private Map<String,Object> getValoresDoContexto(Object contexto) {
		Map<String,Object> values = new HashMap<>();
		for (Class<?> c = contexto.getClass(); c != null; c = c.getSuperclass()) {
			Field[] fields = c.getDeclaredFields();
			
			for (Field classField : fields) {
				try {
					Field field = contexto.getClass().getDeclaredField(classField.getName());
					
					field.setAccessible(true);

					Object value = field.get(contexto);
					String fieldName = classField.getName();
					
					if (classField.isAnnotationPresent(FolowField.class) && (value != null)) {
						// insere os campos recursivamente, se anotado com @FolowField
						Map<String,Object> subValues = getValoresDoContexto(value);

						folowField(values, fieldName, subValues);
						
					} else if (classField.isAnnotationPresent(FolowList.class) && (value != null)) {
						// TODO aqui vamos ter que fazer com que o script defina um tipo table com os campos e faça a inserção dos valores
						// TODO para que possa ser acessado via select * from @table
					} else if ((value instanceof java.util.List) && (value != null)) {
						putList(values, value);
					} else if (value != null) {
						putField(values, value, fieldName);	
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		return values;
	}

	private void putField(Map<String, Object> values, Object value, String fieldName) {
		logger.debug("values.put(fieldName="+fieldName+", value="+value+");");
		values.put(fieldName, value);
	}

	private void putList(Map<String, Object> values, Object value) {
		@SuppressWarnings("rawtypes")
		java.util.List parametros = (java.util.List)value;
		for (Object parametro : parametros) {
			try {
				if (parametro instanceof InputParam) {
					InputParam i = (InputParam) parametro; 
					values.put("input_"+i.getNome(), getValorInputDefault(i,i.getValor()));
				}
			} catch (Exception e) {
                logger.error(e.getMessage(), e);
			}

			try {
				if (parametro instanceof OutputParam) {
					OutputParam o = (OutputParam) parametro; 
					values.put("output_"+o.getNome(), getValorOutputDefault(o, o.getValor()));
				}
			} catch (Exception e) {
                logger.error(e.getMessage(), e);
			}

		}
	}

	private void folowField(Map<String, Object> values, String fieldName, Map<String, Object> subValues) {
		System.out.println("\n\nlistando recursivamente campos do ["+fieldName+"]...");
		for (String key : subValues.keySet()) {
			String subFieldName = fieldName+"_"+key;
			Object subValue = subValues.get(key);
			System.out.println("values.put(subFieldName="+subFieldName+", subValue="+subValue+");");
			values.put(subFieldName, subValue);	
		}
	}

	private Object getValorOutputDefault(OutputParam o, Object valor) {
		return valor != null ? valor : getValorDefault(o.getClasse());
	}

	private Object getValorInputDefault(InputParam i, Object valor) {
		return valor != null ? valor : getValorDefault(i.getClasse());
	}
	
	private Object getValorDefault(String classe) {
		switch (classe) {
			case "java.lang.Boolean":
				return Boolean.FALSE;
			case "java.util.Date":
				return new Date(0);
			case "java.lang.Double":
				return Double.valueOf(0.0);
			case "java.lang.Integer":
				return Integer.valueOf(0);
			case "java.lang.String":
				return "";
			default:
				return null;
		}
	}
	
	private Connection getConnection() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		Connection c;
		try {
			c = ((SessionFactoryImpl) ((HibernateEntityManagerFactory) emf).getSessionFactory()).getConnectionProvider().getConnection();
		} catch (SQLException e) {
			throw new SGPException(e);
		}
		return c;
	}
	
}