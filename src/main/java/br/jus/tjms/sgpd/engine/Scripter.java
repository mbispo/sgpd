package br.jus.tjms.sgpd.engine;

import java.io.Serializable;

import br.jus.tjms.sgpd.exception.SGPException;

@FunctionalInterface
public interface Scripter extends Serializable {

	Object executar(String expressao, Object contexto, String nomeVariavelContexto);

}