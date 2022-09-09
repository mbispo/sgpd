package br.jus.tjms.sgpd.service.frequenciaservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Turno;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:52
 */
@Stateless
public class TurnoService extends GenericService<Turno, Long> implements Serializable {

	private static final long serialVersionUID = -2466166308291732201L;

}