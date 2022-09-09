package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Aproveitamento;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:33
 */
@Stateless
public class AproveitamentoService extends GenericService<Aproveitamento, Long> implements Serializable {

	private static final long serialVersionUID = -1047756468842496723L;

}