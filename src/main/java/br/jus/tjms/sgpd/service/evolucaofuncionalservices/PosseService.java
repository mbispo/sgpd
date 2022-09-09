package br.jus.tjms.sgpd.service.evolucaofuncionalservices;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Posse;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:43
 */
@Stateless
public class PosseService extends GenericService<Posse, Long> implements Serializable {

	private static final long serialVersionUID = 2947550085915497523L;

}