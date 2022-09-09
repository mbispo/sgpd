package br.jus.tjms.sgpd.engine.impl;

import br.jus.tjms.sgpd.engine.Scripter;
import br.jus.tjms.sgpd.exception.SGPException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScripter implements Scripter {
	
	private static final long serialVersionUID = 3352292011948227969L;

    private static Logger logger = LoggerFactory.getLogger(JavaScripter.class);
	
	static Scripter instance;
	
	public static Scripter newInstance() {
		return new JavaScripter();
	}
	
	public static Scripter instance() {
		if (instance == null) {
			instance = new JavaScripter(); 
		}
		
		return instance;
	}
	
	/**
	 * Executa expressão ou script javascript
	 * @param expressao
	 * @param contexto
	 * @param nomeVariavelContexto
	 * @return Object
	 */
	@Override
	public Object executar(String expressao, Object contexto, String nomeVariavelContexto){

        logger.debug("\n\nJavaScripter.executarExpressao(String expressao, Object contexto, String nomeVariavelContexto)");
        logger.debug("expressao: \n\n"+expressao+"\n\n");
        logger.debug("contexto: "+contexto.toString());
        logger.debug("nomeVariavelContexto: "+nomeVariavelContexto);
		
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		
		engine.put(nomeVariavelContexto, contexto);
		
		Object resultado;
		
		try {
			resultado = engine.eval(expressao);
		} catch (ScriptException e) {
            logger.error(expressao, e);
			throw new SGPException(e);
		}

        logger.debug("resultado: "+resultado);
		
		return resultado;
	}

}