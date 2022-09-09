package br.jus.tjms.sgpd.service.feriasservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.CancelamentoFerias;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
public class CancelamentoFeriasService extends GenericService<CancelamentoFerias, Long> implements Serializable {

	private static final long serialVersionUID = 8172517200312502110L;

}