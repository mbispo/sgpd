package br.jus.tjms.sgpd.service.frequenciaservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.BancoHora;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
public class BancoHorasService extends GenericService<BancoHora, Long> implements Serializable {

	private static final long serialVersionUID = 3240162489315142736L;

}