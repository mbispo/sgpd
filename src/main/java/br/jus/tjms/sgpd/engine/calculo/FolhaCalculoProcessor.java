package br.jus.tjms.sgpd.engine.calculo;

import java.io.Serializable;
import java.util.List;

import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.engine.to.ItemCalculo;
import br.jus.tjms.sgpd.entity.Funcionario;
import br.jus.tjms.sgpd.entity.Pessoa;

@FunctionalInterface
public interface FolhaCalculoProcessor extends Serializable {
	
	List<ItemCalculo> processarCalculo(Contexto contexto, List<ItemCalculo> input, Pessoa pessoa, Funcionario funcionario);

}
