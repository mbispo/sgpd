package br.jus.tjms.sgpd.service.evolucaofuncionalservices;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Nomeacao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:42
 */
@Stateless
public class NomeacaoService extends GenericService<Nomeacao, Long> implements Serializable {

	private static final long serialVersionUID = -3700416101323242358L;

}