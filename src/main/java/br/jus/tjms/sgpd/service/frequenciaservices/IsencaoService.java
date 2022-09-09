package br.jus.tjms.sgpd.service.frequenciaservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.IsencaoFrequencia;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:41
 */
@Stateless
public class IsencaoService extends GenericService<IsencaoFrequencia, Long> implements Serializable {

	private static final long serialVersionUID = -1363398731646935588L;

}