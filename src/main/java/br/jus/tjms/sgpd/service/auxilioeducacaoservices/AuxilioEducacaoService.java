package br.jus.tjms.sgpd.service.auxilioeducacaoservices;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.ConcessaoAuxilioEducacaoInfantil;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:35
 */
@Stateless
public class AuxilioEducacaoService extends GenericService<ConcessaoAuxilioEducacaoInfantil, Long> implements Serializable {

	private static final long serialVersionUID = 4792335616775039098L;

}