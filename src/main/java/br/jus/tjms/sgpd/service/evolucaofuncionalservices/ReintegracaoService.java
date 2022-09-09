package br.jus.tjms.sgpd.service.evolucaofuncionalservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Reintegracao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:45
 */
@Stateless
public class ReintegracaoService extends GenericService<Reintegracao, Long> implements Serializable {

	private static final long serialVersionUID = 4892750148917202673L;

}