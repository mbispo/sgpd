package br.jus.tjms.sgpd.service.estagioprobatorioservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.EstagioProbatorio;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:39
 */
@Stateless
public class EstagioProbatorioService extends GenericService<EstagioProbatorio, Long> implements Serializable {

	private static final long serialVersionUID = 8762399486743157715L;

}