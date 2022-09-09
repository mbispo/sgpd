package br.jus.tjms.sgpd.service.feriasservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.InterrupcaoFerias;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:41
 */
@Stateless
public class InterrupcaoFeriasService extends GenericService<InterrupcaoFerias, Long> implements Serializable {

	private static final long serialVersionUID = 9208221865807614746L;

}