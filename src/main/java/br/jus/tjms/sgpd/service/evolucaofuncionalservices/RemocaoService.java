package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Remocao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:45
 */
@Stateless
public class RemocaoService extends GenericService<Remocao, Long> implements Serializable {

	private static final long serialVersionUID = -6784694495888764137L;

}