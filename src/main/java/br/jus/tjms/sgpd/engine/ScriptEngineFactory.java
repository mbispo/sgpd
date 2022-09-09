package br.jus.tjms.sgpd.engine;

import br.jus.tjms.sgpd.engine.impl.GenericScripter;
import br.jus.tjms.sgpd.engine.impl.Groover;
import br.jus.tjms.sgpd.engine.impl.JavaScripter;
import br.jus.tjms.sgpd.engine.impl.MSSQLServerProcedurer;
import br.jus.tjms.sgpd.engine.impl.MSSQLServerSQLScripter;
import br.jus.tjms.sgpd.enumerators.TipoScript;
import br.jus.tjms.sgpd.exception.SGPException;

/**
 * Fábrica de engines de execução de scripts
 * @author marcos.bispo
 *
 */
public class ScriptEngineFactory {
	
	private ScriptEngineFactory() {
	}

	/**
	 * 
	 * @param TipoScript tipo (tipo de engine: 	GROOVY_SCRIPT, JAVA_SCRIPT, SQL_PROCEDURE, SQL_SCRIPT, GENERIC_SCRIPT	)
	 * @return Scripter implementação da engine de acordo com o tipo informado (Groover, JavaScripter, etc)
	 */	
	public static Scripter fabricar(TipoScript tipo) {
		switch (tipo) {
			case GROOVY_SCRIPT: return Groover.instance();
			case JAVA_SCRIPT: return JavaScripter.instance();
			case SQL_PROCEDURE: return MSSQLServerProcedurer.instance();
			case SQL_SCRIPT: return MSSQLServerSQLScripter.instance();
			case GENERIC_SCRIPT: return GenericScripter.instance();
			default: throw new SGPException("Tipo de Script não informado!");
		}
	}

}