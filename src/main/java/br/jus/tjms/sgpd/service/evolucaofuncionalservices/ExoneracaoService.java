package br.jus.tjms.sgpd.service.evolucaofuncionalservices;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Exoneracao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class ExoneracaoService extends GenericService<Exoneracao, Long> implements Serializable {

	private static final long serialVersionUID = 4739242131524114919L;

}