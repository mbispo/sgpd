package br.jus.tjms.sgpd.service.bancoservices;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.ConvenioBancario;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class ConvenioBancarioService extends GenericService<ConvenioBancario, Long> implements Serializable {

	private static final long serialVersionUID = -4122610970385724615L;

}