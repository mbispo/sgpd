package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Demissao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:38
 */
@Stateless
public class DemissaoService extends GenericService<Demissao, Long> implements Serializable {

	private static final long serialVersionUID = 5128607984902252670L;

}