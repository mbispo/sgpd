package br.jus.tjms.sgpd.service.plantaoservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Pensao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:43
 */
@Stateless
public class PensaoService extends GenericService<Pensao, Long> implements Serializable {

	private static final long serialVersionUID = -8898502256368012622L;

}