package br.jus.tjms.sgpd.service.licencaservices;
import java.io.Serializable;

import javax.ejb.Stateless;

import br.jus.tjms.sgpd.entity.SolicitacaoLicenca;
import br.jus.tjms.sgpd.service.GenericService;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:49
 */
@Stateless
public class SolicitacaoLicencaService extends GenericService<SolicitacaoLicenca, Long> implements Serializable {

	private static final long serialVersionUID = 8104703935433466233L;

}