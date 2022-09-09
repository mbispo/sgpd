package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Reversao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:46
 */
@Stateless
public class ReversaoService extends GenericService<Reversao, Long> implements Serializable {

	private static final long serialVersionUID = -3107742934156890937L;

}