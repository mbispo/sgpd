package br.jus.tjms.sgpd.engine.impl;

import br.jus.tjms.sgpd.engine.Scripter;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilationFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Groover implements Scripter {
	
	private static final long serialVersionUID = 1000621940632690170L;

    private static Logger logger = LoggerFactory.getLogger(Groover.class);
	
	static Scripter instance;
	
	public static Scripter newInstance() {
		return new Groover();
	}
	
	public static Scripter instance() {
		if (instance == null) {
			instance = new Groover(); 
		}
		
		return instance;
	}
	
	/**
	 * Executa expressão ou script groovy
	 * @param expressao
	 * @param contexto
	 * @param nomeVariavelContexto
	 * @return Object
	 */
	public Object executar(String expressao, Object contexto, String nomeVariavelContexto) {

        logger.debug("\n\nGroover.executarExpressao(String expressao, Object contexto, String nomeVariavelContexto)");
        logger.debug("expressao: \n\n"+expressao+"\n\n");
        logger.debug("contexto: "+contexto.toString());
        logger.debug("nomeVariavelContexto: "+nomeVariavelContexto);
		
		Binding binding = new Binding();
		binding.setVariable(nomeVariavelContexto, contexto);
		GroovyShell shell = new GroovyShell(binding);
		
		Object resultado = null;
		try {
			resultado = shell.evaluate(expressao);
		} catch (CompilationFailedException e) {
            logger.error(expressao, e);
		}

        logger.debug("resultado: "+resultado);
		return resultado;
	}

}
