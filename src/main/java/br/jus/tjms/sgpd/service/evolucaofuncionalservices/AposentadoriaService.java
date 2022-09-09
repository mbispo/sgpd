package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Aposentadoria;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Stateless
public class AposentadoriaService extends GenericService<Aposentadoria, Long> implements Serializable {

	private static final long serialVersionUID = -4484927435506069538L;

}