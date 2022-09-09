package br.jus.tjms.sgpd.service.feriasservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Ferias;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class FeriasService extends GenericService<Ferias, Long> implements Serializable {

	private static final long serialVersionUID = -3182000767701863847L;

}