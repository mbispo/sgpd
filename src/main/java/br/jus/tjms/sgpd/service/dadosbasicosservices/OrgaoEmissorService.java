package br.jus.tjms.sgpd.service.dadosbasicosservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.OrgaoEmissor;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:38
 */
@Stateless
public class OrgaoEmissorService extends GenericService<OrgaoEmissor, Long> implements Serializable {

	private static final long serialVersionUID = 516843565260412524L;

}