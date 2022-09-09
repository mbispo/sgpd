package br.jus.tjms.sgpd.service.concursoservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.Concurso;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class ConcursoService extends GenericService<Concurso, Long> implements Serializable {

	private static final long serialVersionUID = 5730955320802058324L;

}