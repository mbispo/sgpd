package br.jus.tjms.sgpd.service.feriasservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.SolicitacaoFerias;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:49
 */
@Stateless
public class SolicitacaoFeriasService extends GenericService<SolicitacaoFerias, Long> implements Serializable {

	private static final long serialVersionUID = 7602595377968657541L;

}