package br.jus.tjms.sgpd.service.frequenciaservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Digital;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:38
 */
@Stateless
public class DigitalService extends GenericService<Digital, Long> implements Serializable {

	private static final long serialVersionUID = 6942563827986630701L;

}