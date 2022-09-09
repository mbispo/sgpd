package br.jus.tjms.sgpd.service.licencaservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.ConcessaoLicenca;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:37
 */
@Stateless
public class ConcessaoLicencaService extends GenericService<ConcessaoLicenca, Long> implements Serializable {

	private static final long serialVersionUID = -1475256590049304595L;

}