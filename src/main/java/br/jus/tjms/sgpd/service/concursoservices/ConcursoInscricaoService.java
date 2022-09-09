package br.jus.tjms.sgpd.service.concursoservices;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.ConcursoInscricao;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class ConcursoInscricaoService extends GenericService<ConcursoInscricao, Long> implements Serializable {

	private static final long serialVersionUID = 8719938297225775453L;

}