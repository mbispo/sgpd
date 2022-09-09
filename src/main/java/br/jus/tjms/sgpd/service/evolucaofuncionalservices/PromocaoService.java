package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Promocao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:44
 */
@Stateless
public class PromocaoService extends GenericService<Promocao, Long> implements Serializable {

	private static final long serialVersionUID = -6855818431977762178L;

}