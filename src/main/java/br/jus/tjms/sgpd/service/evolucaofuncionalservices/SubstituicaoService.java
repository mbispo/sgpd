package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Substituicao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:49
 */
@Stateless
public class SubstituicaoService extends GenericService<Substituicao, Long> implements Serializable {

	private static final long serialVersionUID = -6596513679045993972L;

}